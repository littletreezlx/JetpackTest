package com.example.jetpacktest.databinding;

import androidx.databinding.ObservableField;

public class UserTest0 {


    private String userName;

//    private int userAge;


    public ObservableField<Integer> userAge = new ObservableField<>();

    public UserTest0() {

        userAge.set(0);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public ObservableField<Integer> getUserAge() {
        return userAge;
    }

    public void setUserAge(ObservableField<Integer> userAge) {
        this.userAge = userAge;
    }


    public void onClick0(){

        userName = "B";
    }


    public void onClick1(){

        int i = Integer.valueOf(userAge.get());
        userAge.set(++i);
    }
}
