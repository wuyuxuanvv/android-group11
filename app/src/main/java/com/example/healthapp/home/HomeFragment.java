package com.example.healthapp.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.healthapp.R;
import com.example.healthapp.common.DateTimeUtils;
import com.example.healthapp.common.RepositoryCallback;
import com.example.healthapp.database.HealthRepository;
import com.example.healthapp.model.SleepRecord;

import java.util.Locale;

/** Displays only real Room-backed values and explicit empty states. */
public class HomeFragment extends Fragment {
    private TextView exerciseValue;
    private TextView calorieValue;
    private TextView sleepValue;
    private HealthRepository repository;

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        exerciseValue = view.findViewById(R.id.text_home_exercise_value);
        calorieValue = view.findViewById(R.id.text_home_calorie_value);
        sleepValue = view.findViewById(R.id.text_home_sleep_value);
        repository = HealthRepository.getInstance(requireContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        loadSummary();
    }

    private void loadSummary() {
        String today = DateTimeUtils.today();
        repository.getExerciseCountForDate(today, new RepositoryCallback<Integer>() {
            @Override
            public void onSuccess(Integer count) {
                if (!isAdded() || exerciseValue == null) {
                    return;
                }
                exerciseValue.setText(count == 0
                        ? getString(R.string.home_no_exercise)
                        : getString(R.string.home_exercise_count, count));
            }

            @Override
            public void onError(Throwable error) {
                showLoadError(exerciseValue);
            }
        });

        repository.getTotalCaloriesForDate(today, new RepositoryCallback<Double>() {
            @Override
            public void onSuccess(Double calories) {
                if (!isAdded() || calorieValue == null) {
                    return;
                }
                calorieValue.setText(calories <= 0
                        ? getString(R.string.home_no_diet)
                        : getString(R.string.home_calorie_total,
                                String.format(Locale.getDefault(), "%.1f", calories)));
            }

            @Override
            public void onError(Throwable error) {
                showLoadError(calorieValue);
            }
        });

        repository.getLatestSleepRecord(new RepositoryCallback<SleepRecord>() {
            @Override
            public void onSuccess(SleepRecord record) {
                if (!isAdded() || sleepValue == null) {
                    return;
                }
                if (record == null) {
                    sleepValue.setText(R.string.home_no_sleep);
                } else {
                    int hours = record.durationMinutes / 60;
                    int minutes = record.durationMinutes % 60;
                    sleepValue.setText(getString(R.string.home_sleep_duration, hours, minutes));
                }
            }

            @Override
            public void onError(Throwable error) {
                showLoadError(sleepValue);
            }
        });
    }

    private void showLoadError(TextView textView) {
        if (isAdded() && textView != null) {
            textView.setText(R.string.home_load_error);
        }
    }

    @Override
    public void onDestroyView() {
        exerciseValue = null;
        calorieValue = null;
        sleepValue = null;
        super.onDestroyView();
    }
}
