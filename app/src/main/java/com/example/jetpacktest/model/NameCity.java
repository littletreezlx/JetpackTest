package com.example.jetpacktest.model;

import androidx.room.ColumnInfo;


public class NameCity {


    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="city")
    public String city;


}