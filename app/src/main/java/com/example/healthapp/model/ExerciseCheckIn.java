package com.example.healthapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "exercise_check_ins",
        foreignKeys = @ForeignKey(
                entity = ExercisePlan.class,
                parentColumns = "id",
                childColumns = "exercise_plan_id",
                onDelete = ForeignKey.CASCADE),
        indices = {
                @Index("exercise_plan_id"),
                @Index(value = {"exercise_plan_id", "check_in_date"}, unique = true),
                @Index("check_in_date")
        })
public class ExerciseCheckIn {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "exercise_plan_id")
    public long exercisePlanId;

    @NonNull
    @ColumnInfo(name = "check_in_date")
    public String checkInDate = "";

    public boolean completed = true;
}
