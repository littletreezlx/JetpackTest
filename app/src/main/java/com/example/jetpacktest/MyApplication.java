package com.example.jetpacktest;

import android.app.Application;

import com.example.jetpacktest.model.MyDataBase;

import androidx.room.Room;

public class MyApplication extends Application {


    private MyDataBase myDataBase;



    @Override
    public void onCreate() {
        super.onCreate();

        myDataBase = Room.databaseBuilder(this, MyDataBase.class, "myDataBase").build();


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    public MyDataBase getMyDataBase() {
        return myDataBase;
    }

    public void setMyDataBase(MyDataBase myDataBase) {
        this.myDataBase = myDataBase;
    }
}
