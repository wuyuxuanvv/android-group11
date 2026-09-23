package com.example.healthapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "sleep_records", indices = {@Index("sleep_date"), @Index("wake_time_epoch_millis")})
public class SleepRecord {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "sleep_start_epoch_millis")
    public long sleepStartEpochMillis;

    @ColumnInfo(name = "wake_time_epoch_millis")
    public long wakeTimeEpochMillis;

    @ColumnInfo(name = "duration_minutes")
    public int durationMinutes;

    /** The local calendar date on which the user wakes, formatted yyyy-MM-dd. */
    @NonNull
    @ColumnInfo(name = "sleep_date")
    public String sleepDate = "";
}
