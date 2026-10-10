package com.example.healthapp.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.healthapp.R;
import com.example.healthapp.common.RepositoryCallback;
import com.example.healthapp.database.HealthRepository;
import com.example.healthapp.model.UserProfile;

/**
 * Member 1: single-user profile form. Saves height/weight/age/gender and the three
 * health goals into Room via HealthRepository (fixed id = SINGLE_USER_ID).
 * Local PIN is intentionally pending and can be added later.
 */
public class ProfileFragment extends Fragment {

    private static final double MIN_HEIGHT_CM = 50;
    private static final double MAX_HEIGHT_CM = 250;
    private static final double MIN_WEIGHT_KG = 20;
    private static final double MAX_WEIGHT_KG = 300;
    private static final int MIN_AGE = 1;
    private static final int MAX_AGE = 120;
    private static final int MIN_WEEKLY_GOAL = 1;
    private static final int MAX_WEEKLY_GOAL = 14;
    private static final double MIN_CALORIE_GOAL = 500;
    private static final double MAX_CALORIE_GOAL = 10000;

    private EditText heightInput;
    private EditText weightInput;
    private EditText ageInput;
    private EditText exerciseGoalInput;
    private EditText calorieGoalInput;
    private RadioGroup genderGroup;

    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        heightInput = view.findViewById(R.id.input_profile_height);
        weightInput = view.findViewById(R.id.input_profile_weight);
        ageInput = view.findViewById(R.id.input_profile_age);
        exerciseGoalInput = view.findViewById(R.id.input_profile_exercise_goal);
        calorieGoalInput = view.findViewById(R.id.input_profile_calorie_goal);
        genderGroup = view.findViewById(R.id.radio_profile_gender);
        Button saveButton = view.findViewById(R.id.button_profile_save);

        saveButton.setOnClickListener(v -> attemptSave());
        loadProfile();
    }

    private void loadProfile() {
        repository().getUserProfile(new RepositoryCallback<UserProfile>() {
            @Override
            public void onSuccess(UserProfile profile) {
                if (!isViewAlive()) {
                    return;
                }
                if (profile != null) {
                    populateForm(profile);
                }
                // null means first launch: keep the empty form for the user to fill in.
            }

            @Override
            public void onError(Throwable error) {
                if (isViewAlive()) {
                    Toast.makeText(requireContext(), R.string.profile_load_error,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void populateForm(UserProfile profile) {
        heightInput.setText(formatNumber(profile.heightCm));
        weightInput.setText(formatNumber(profile.weightKg));
        ageInput.setText(String.valueOf(profile.age));
        exerciseGoalInput.setText(String.valueOf(profile.weeklyExerciseGoalCount));
        calorieGoalInput.setText(formatNumber(profile.dailyCalorieGoalKcal));

        if (getString(R.string.profile_gender_male).equals(profile.gender)) {
            genderGroup.check(R.id.radio_profile_gender_male);
        } else if (getString(R.string.profile_gender_female).equals(profile.gender)) {
            genderGroup.check(R.id.radio_profile_gender_female);
        }
    }

    private void attemptSave() {
        clearErrors();

        String gender = readGender();
        if (gender == null) {
            toast(R.string.profile_error_gender);
            return;
        }

        Double height = readDouble(heightInput, R.string.profile_error_height,
                MIN_HEIGHT_CM, MAX_HEIGHT_CM);
        Double weight = readDouble(weightInput, R.string.profile_error_weight,
                MIN_WEIGHT_KG, MAX_WEIGHT_KG);
        Integer age = readInt(ageInput, R.string.profile_error_age, MIN_AGE, MAX_AGE);
        Integer exerciseGoal = readInt(exerciseGoalInput, R.string.profile_error_exercise_goal,
                MIN_WEEKLY_GOAL, MAX_WEEKLY_GOAL);
        Double calorieGoal = readDouble(calorieGoalInput, R.string.profile_error_calorie_goal,
                MIN_CALORIE_GOAL, MAX_CALORIE_GOAL);

        if (height == null || weight == null || age == null
                || exerciseGoal == null || calorieGoal == null) {
            return; // The failing field already shows its error message.
        }

        UserProfile profile = new UserProfile();
        profile.id = UserProfile.SINGLE_USER_ID;
        profile.heightCm = height;
        profile.weightKg = weight;
        profile.age = age;
        profile.gender = gender;
        profile.weeklyExerciseGoalCount = exerciseGoal;
        profile.dailyCalorieGoalKcal = calorieGoal;

        repository().saveUserProfile(profile, new RepositoryCallback<Long>() {
            @Override
            public void onSuccess(Long rowId) {
                if (isViewAlive()) {
                    Toast.makeText(requireContext(), R.string.profile_saved,
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Throwable error) {
                if (isViewAlive()) {
                    Toast.makeText(requireContext(), R.string.profile_save_error,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Nullable
    private String readGender() {
        int checkedId = genderGroup.getCheckedRadioButtonId();
        if (checkedId == R.id.radio_profile_gender_male) {
            return getString(R.string.profile_gender_male);
        }
        if (checkedId == R.id.radio_profile_gender_female) {
            return getString(R.string.profile_gender_female);
        }
        return null;
    }

    @Nullable
    private Double readDouble(@NonNull EditText input, int errorRes, double min, double max) {
        String raw = input.getText().toString().trim();
        if (raw.isEmpty()) {
            input.setError(getString(R.string.profile_error_empty));
            return null;
        }
        try {
            double value = Double.parseDouble(raw);
            if (value < min || value > max) {
                input.setError(getString(errorRes));
                return null;
            }
            return value;
        } catch (NumberFormatException e) {
            input.setError(getString(errorRes));
            return null;
        }
    }

    @Nullable
    private Integer readInt(@NonNull EditText input, int errorRes, int min, int max) {
        String raw = input.getText().toString().trim();
        if (raw.isEmpty()) {
            input.setError(getString(R.string.profile_error_empty));
            return null;
        }
        try {
            int value = Integer.parseInt(raw);
            if (value < min || value > max) {
                input.setError(getString(errorRes));
                return null;
            }
            return value;
        } catch (NumberFormatException e) {
            input.setError(getString(errorRes));
            return null;
        }
    }

    private void clearErrors() {
        heightInput.setError(null);
        weightInput.setError(null);
        ageInput.setError(null);
        exerciseGoalInput.setError(null);
        calorieGoalInput.setError(null);
    }

    private void toast(int messageRes) {
        Toast.makeText(requireContext(), messageRes, Toast.LENGTH_SHORT).show();
    }

    private boolean isViewAlive() {
        return isAdded() && getView() != null;
    }

    @NonNull
    private HealthRepository repository() {
        return HealthRepository.getInstance(requireContext());
    }

    @NonNull
    private static String formatNumber(double value) {
        if (value == Math.floor(value) && !Double.isInfinite(value)) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
