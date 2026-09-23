package com.example.healthapp.database;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.example.healthapp.common.DateTimeUtils;
import com.example.healthapp.common.RepositoryCallback;
import com.example.healthapp.model.DailyHealthSummary;
import com.example.healthapp.model.SleepRecord;
import com.example.healthapp.model.UserProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Stable asynchronous cross-module data API. DAO methods remain available for module-owned CRUD,
 * but other modules should use this class instead of depending on another module's UI code.
 */
public final class HealthRepository {
    private static volatile HealthRepository instance;

    private final AppDatabase database;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    private HealthRepository(Context context) {
        database = AppDatabase.getInstance(context);
    }

    public static HealthRepository getInstance(Context context) {
        if (instance == null) {
            synchronized (HealthRepository.class) {
                if (instance == null) {
                    instance = new HealthRepository(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    public void getUserProfile(RepositoryCallback<UserProfile> callback) {
        submit(() -> database.userProfileDao().getProfile(), callback);
    }

    public void saveUserProfile(UserProfile profile, RepositoryCallback<Long> callback) {
        profile.id = UserProfile.SINGLE_USER_ID;
        submit(() -> database.userProfileDao().save(profile), callback);
    }

    /** Returns null when a profile has not yet been saved. */
    public void getCurrentWeightKg(RepositoryCallback<Double> callback) {
        submit(() -> {
            UserProfile profile = database.userProfileDao().getProfile();
            return profile == null ? null : profile.weightKg;
        }, callback);
    }

    /** Returns null when a profile has not yet been saved. */
    public void getDailyCalorieGoalKcal(RepositoryCallback<Double> callback) {
        submit(() -> {
            UserProfile profile = database.userProfileDao().getProfile();
            return profile == null ? null : profile.dailyCalorieGoalKcal;
        }, callback);
    }

    /** Returns null when a profile has not yet been saved. */
    public void getDailySleepGoalMinutes(RepositoryCallback<Integer> callback) {
        submit(() -> {
            UserProfile profile = database.userProfileDao().getProfile();
            return profile == null ? null : profile.dailySleepGoalMinutes;
        }, callback);
    }

    public void getExerciseCountForDate(String date, RepositoryCallback<Integer> callback) {
        submit(() -> database.exerciseRecordDao().countByDate(date), callback);
    }

    public void getTotalCaloriesForDate(String date, RepositoryCallback<Double> callback) {
        submit(() -> database.foodRecordDao().getTotalCaloriesByDate(date), callback);
    }

    /** Returns null when no sleep record exists. */
    public void getLatestSleepRecord(RepositoryCallback<SleepRecord> callback) {
        submit(() -> database.sleepRecordDao().getLatest(), callback);
    }

    public void getDailySummaries(String startDate, String endDate,
                                  RepositoryCallback<List<DailyHealthSummary>> callback) {
        submit(() -> {
            List<DailyHealthSummary> summaries = new ArrayList<>();
            for (String date : DateTimeUtils.datesBetweenInclusive(startDate, endDate)) {
                int exerciseCount = database.exerciseRecordDao().countByDate(date);
                double calories = database.foodRecordDao().getTotalCaloriesByDate(date);
                SleepRecord sleep = database.sleepRecordDao().getLatestBySleepDate(date);
                Integer sleepMinutes = sleep == null ? null : sleep.durationMinutes;
                summaries.add(new DailyHealthSummary(date, exerciseCount, calories, sleepMinutes));
            }
            return summaries;
        }, callback);
    }

    public void clearAllData(RepositoryCallback<Boolean> callback) {
        submit(() -> {
            database.clearAllTables();
            return true;
        }, callback);
    }

    private <T> void submit(Callable<T> task, RepositoryCallback<T> callback) {
        DatabaseExecutor.execute(() -> {
            try {
                T result = task.call();
                mainHandler.post(() -> callback.onSuccess(result));
            } catch (Throwable error) {
                mainHandler.post(() -> callback.onError(error));
            }
        });
    }
}
