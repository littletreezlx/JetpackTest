package com.example.jetpacktest;

import android.content.Context;

public class MainClickListener {


    private Context context;

    public MainClickListener(Context context){
        this.context = context;
    }


    public void onClick0(){

        MainActivity mainActivity = (MainActivity) context;
        mainActivity.getUser().setUserName("B");
    }


    public void onClick1(){

        MainActivity mainActivity = (MainActivity) context;
        mainActivity.getUser().userAge.set(20);
    }


}
