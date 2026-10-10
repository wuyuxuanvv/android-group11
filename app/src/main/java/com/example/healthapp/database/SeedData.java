package com.example.healthapp.database;

import android.content.Context;

import com.example.healthapp.model.Exercise;
import com.example.healthapp.model.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Seed entry point for the built-in exercise and food libraries.
 *
 * Framework owns the trigger and the empty-check; C (database owner) fills the
 * seed lists below. Rules:
 * <ul>
 *   <li>Seeds run once per install, only while the table is empty — never re-insert.</li>
 *   <li>After clearAllData() the tables are empty again, so the next launch
 *       re-seeds automatically and the libraries are never lost.</li>
 *   <li>DAO calls stay on DatabaseExecutor; never call this on the UI thread
 *       expecting completion — fire and forget.</li>
 * </ul>
 */
public final class SeedData {

    private SeedData() {
    }

    /** Called once from MainActivity.onCreate. Safe to call on every launch. */
    public static void seedIfEmpty(Context context) {
        DatabaseExecutor.execute(() -> {
            AppDatabase database = AppDatabase.getInstance(context);
            if (database.exerciseDao().getAll().isEmpty()) {
                database.exerciseDao().insertAll(buildExerciseSeeds());
            }
            if (database.foodDao().getAll().isEmpty()) {
                database.foodDao().insertAll(buildFoodSeeds());
            }
        });
    }

    /** TODO(C): 填入不少于 20 种运动。每种必须含 name(唯一)、category、metValue。 */
    private static List<Exercise> buildExerciseSeeds() {
        List<Exercise> seeds = new ArrayList<>();
        // 示例：seeds.add(newExercise("跑步", "有氧", 9.8));
        return seeds;
    }

    /** TODO(C): 填入不少于 100 种食物。每种必须含 name(唯一) 及每 100g 热量与营养。 */
    private static List<Food> buildFoodSeeds() {
        List<Food> seeds = new ArrayList<>();
        // 示例：seeds.add(newFood("米饭", 116, 2.6, 25.9, 0.3));
        return seeds;
    }
}
