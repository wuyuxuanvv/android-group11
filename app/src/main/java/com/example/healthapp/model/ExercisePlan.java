package com.example.healthapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "exercise_plans",
        foreignKeys = @ForeignKey(
                entity = Exercise.class,
                parentColumns = "id",
                childColumns = "exercise_id",
                onDelete = ForeignKey.RESTRICT),
        indices = {@Index("exercise_id"), @Index("day_of_week")})
public class ExercisePlan {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "exercise_id")
    public long exerciseId;

    /** ISO day number: Monday=1, Sunday=7. */
    @ColumnInfo(name = "day_of_week")
    public int dayOfWeek;

    @ColumnInfo(name = "target_duration_minutes")
    public int targetDurationMinutes;

    @ColumnInfo(name = "is_active")
    public boolean active = true;
}
