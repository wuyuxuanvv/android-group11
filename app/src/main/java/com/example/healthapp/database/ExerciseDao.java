package com.example.healthapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.healthapp.model.Exercise;

import java.util.List;

@Dao
public interface ExerciseDao {
    @Query("SELECT * FROM exercises ORDER BY name")
    List<Exercise> getAll();

    @Query("SELECT * FROM exercises WHERE name LIKE '%' || :query || '%' ORDER BY name")
    List<Exercise> searchByName(String query);

    @Query("SELECT * FROM exercises WHERE id = :id LIMIT 1")
    Exercise getById(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Exercise exercise);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    List<Long> insertAll(List<Exercise> exercises);

    @Update
    int update(Exercise exercise);

    @Delete
    int delete(Exercise exercise);
}
