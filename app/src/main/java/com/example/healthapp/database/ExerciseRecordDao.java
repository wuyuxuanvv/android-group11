package com.example.healthapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.healthapp.model.ExerciseRecord;

import java.util.List;

@Dao
public interface ExerciseRecordDao {
    @Query("SELECT * FROM exercise_records WHERE record_date = :date ORDER BY id DESC")
    List<ExerciseRecord> getByDate(String date);

    @Query("SELECT * FROM exercise_records WHERE record_date BETWEEN :startDate AND :endDate "
            + "ORDER BY record_date DESC, id DESC")
    List<ExerciseRecord> getByDateRange(String startDate, String endDate);

    @Query("SELECT COUNT(*) FROM exercise_records WHERE record_date = :date")
    int countByDate(String date);

    @Insert
    long insert(ExerciseRecord record);

    @Update
    int update(ExerciseRecord record);

    @Delete
    int delete(ExerciseRecord record);
}
