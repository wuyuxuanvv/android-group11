package com.example.healthapp.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.healthapp.model.UserProfile;

@Dao
public interface UserProfileDao {
    @Query("SELECT * FROM user_profile WHERE id = 1 LIMIT 1")
    UserProfile getProfile();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long save(UserProfile profile);

    @Update
    int update(UserProfile profile);
}
