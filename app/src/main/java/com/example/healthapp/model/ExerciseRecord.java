package com.example.healthapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "exercise_records",
        foreignKeys = @ForeignKey(
                entity = Exercise.class,
                parentColumns = "id",
                childColumns = "exercise_id",
                onDelete = ForeignKey.RESTRICT),
        indices = {@Index("exercise_id"), @Index("record_date")})
public class ExerciseRecord {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "exercise_id")
    public long exerciseId;

    @NonNull
    @ColumnInfo(name = "record_date")
    public String recordDate = "";

    @ColumnInfo(name = "duration_minutes")
    public int durationMinutes;

    @ColumnInfo(name = "estimated_calories_kcal")
    public double estimatedCaloriesKcal;
}
