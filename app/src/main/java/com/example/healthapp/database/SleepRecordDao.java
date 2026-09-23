package com.example.healthapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.healthapp.model.SleepRecord;

import java.util.List;

@Dao
public interface SleepRecordDao {
    @Query("SELECT * FROM sleep_records ORDER BY wake_time_epoch_millis DESC LIMIT 1")
    SleepRecord getLatest();

    @Query("SELECT * FROM sleep_records WHERE sleep_date = :date "
            + "ORDER BY wake_time_epoch_millis DESC LIMIT 1")
    SleepRecord getLatestBySleepDate(String date);

    @Query("SELECT * FROM sleep_records WHERE sleep_date BETWEEN :startDate AND :endDate "
            + "ORDER BY sleep_date DESC, wake_time_epoch_millis DESC")
    List<SleepRecord> getByDateRange(String startDate, String endDate);

    @Insert
    long insert(SleepRecord record);

    @Update
    int update(SleepRecord record);

    @Delete
    int delete(SleepRecord record);
}
