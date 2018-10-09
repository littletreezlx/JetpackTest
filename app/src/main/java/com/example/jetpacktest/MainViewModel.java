package com.example.jetpacktest;

import com.example.jetpacktest.databinding.UserTest0;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {


    private MutableLiveData<List<UserTest0>> users;


    public LiveData<List<UserTest0>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<List<UserTest0>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        // Do an asynchronous operation to fetch users.
    }



}
