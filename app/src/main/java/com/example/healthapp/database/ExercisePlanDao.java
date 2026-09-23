package com.example.healthapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.healthapp.model.ExercisePlan;

import java.util.List;

@Dao
public interface ExercisePlanDao {
    @Query("SELECT * FROM exercise_plans WHERE is_active = 1 ORDER BY day_of_week, id")
    List<ExercisePlan> getActivePlans();

    @Query("SELECT * FROM exercise_plans WHERE day_of_week = :dayOfWeek AND is_active = 1 "
            + "ORDER BY id")
    List<ExercisePlan> getActivePlansForDay(int dayOfWeek);

    @Insert
    long insert(ExercisePlan plan);

    @Update
    int update(ExercisePlan plan);

    @Delete
    int delete(ExercisePlan plan);
}
