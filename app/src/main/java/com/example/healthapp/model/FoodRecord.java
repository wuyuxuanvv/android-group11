package com.example.healthapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "food_records",
        foreignKeys = @ForeignKey(
                entity = Food.class,
                parentColumns = "id",
                childColumns = "food_id",
                onDelete = ForeignKey.RESTRICT),
        indices = {@Index("food_id"), @Index("record_date")})
public class FoodRecord {
    public static final String MEAL_BREAKFAST = "BREAKFAST";
    public static final String MEAL_LUNCH = "LUNCH";
    public static final String MEAL_DINNER = "DINNER";
    public static final String MEAL_SNACK = "SNACK";

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo(name = "food_id")
    public long foodId;

    @NonNull
    @ColumnInfo(name = "record_date")
    public String recordDate = "";

    @NonNull
    @ColumnInfo(name = "meal_type")
    public String mealType = MEAL_BREAKFAST;

    @ColumnInfo(name = "weight_grams")
    public double weightGrams;

    @ColumnInfo(name = "calories_kcal")
    public double caloriesKcal;

    @ColumnInfo(name = "protein_grams")
    public double proteinGrams;

    @ColumnInfo(name = "carbs_grams")
    public double carbsGrams;

    @ColumnInfo(name = "fat_grams")
    public double fatGrams;
}
