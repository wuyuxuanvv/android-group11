package com.example.healthapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.healthapp.model.Food;

import java.util.List;

@Dao
public interface FoodDao {
    @Query("SELECT * FROM foods ORDER BY name")
    List<Food> getAll();

    @Query("SELECT * FROM foods WHERE name LIKE '%' || :query || '%' ORDER BY name")
    List<Food> searchByName(String query);

    @Query("SELECT * FROM foods WHERE id = :id LIMIT 1")
    Food getById(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Food food);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    List<Long> insertAll(List<Food> foods);

    @Update
    int update(Food food);

    @Delete
    int delete(Food food);
}
