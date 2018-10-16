package com.example.jetpacktest.model;


import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {


//    @PrimaryKey(autoGenerate = true)
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "name")
    private String name = "AAA";

    @ColumnInfo(name = "age")
    private int age = 100;

    @Embedded
    private Address address;


    @Ignore
    private String ignore = "ignore";




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }
}
