package com.example.jetpacktest.model;


import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM users WHERE name LIKE :name AND "
            + "age LIKE :age LIMIT 1")
    User findByName(String name, String age);

    @Query("SELECT name, city FROM users")
    List<NameCity> loadNameCity();




    @Query("SELECT * FROM users")
    LiveData<List<User>> getAllLiveDate();




    @Insert
    void insertAll(User... users);

    @Insert
    void insert(User user);

    @Update
    void updateUser(User user);


    @Delete
    void delete(User user);

    @Query("DELETE FROM users")
    void deleteAll();

}
