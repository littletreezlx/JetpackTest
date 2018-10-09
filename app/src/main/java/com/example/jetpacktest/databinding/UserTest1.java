package com.example.jetpacktest.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


public class UserTest1 extends BaseObservable {
    private String firstName;
    private String lastName;

    @Bindable
    public String getFirstName() {
        return this.firstName;
    }

    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
//        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
//        notifyPropertyChanged(BR.lastName);
    }
}