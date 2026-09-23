package com.example.healthapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "foods", indices = {@Index(value = "name", unique = true)})
public class Food {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String name = "";

    @ColumnInfo(name = "calories_per_100g")
    public double caloriesPer100g;

    @ColumnInfo(name = "protein_per_100g")
    public double proteinPer100g;

    @ColumnInfo(name = "carbs_per_100g")
    public double carbsPer100g;

    @ColumnInfo(name = "fat_per_100g")
    public double fatPer100g;

    @ColumnInfo(name = "image_resource_name")
    public String imageResourceName;
}
