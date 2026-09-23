package com.example.healthapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "exercises", indices = {@Index(value = "name", unique = true)})
public class Exercise {
    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    public String name = "";

    @NonNull
    public String category = "";

    @ColumnInfo(name = "met_value")
    public double metValue;

    @ColumnInfo(name = "demo_resource_name")
    public String demoResourceName;
}
