package com.example.jetpacktest.model;

import androidx.room.RoomDatabase;

public abstract class MyDataBase extends RoomDatabase {

    public abstract UserDao userDao();

}
