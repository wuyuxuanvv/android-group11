package com.example.healthapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.healthapp.model.ExerciseCheckIn;

import java.util.List;

@Dao
public interface ExerciseCheckInDao {
    @Query("SELECT * FROM exercise_check_ins WHERE check_in_date = :date ORDER BY id DESC")
    List<ExerciseCheckIn> getByDate(String date);

    @Query("SELECT * FROM exercise_check_ins WHERE check_in_date BETWEEN :startDate AND :endDate "
            + "ORDER BY check_in_date DESC, id DESC")
    List<ExerciseCheckIn> getByDateRange(String startDate, String endDate);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long save(ExerciseCheckIn checkIn);

    @Update
    int update(ExerciseCheckIn checkIn);

    @Delete
    int delete(ExerciseCheckIn checkIn);
}
