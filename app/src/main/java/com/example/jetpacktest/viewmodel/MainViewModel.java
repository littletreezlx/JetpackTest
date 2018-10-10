package com.example.jetpacktest.viewmodel;

import com.example.jetpacktest.model.User;
import com.example.jetpacktest.ui.MainActivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public class MainViewModel extends ViewModel {





    private MutableLiveData<User> user;


    public LiveData<User> getUser() {
        if (user == null) {
            user = new MutableLiveData<>();
            loaduser();
        }
        return user;
    }

    private void loaduser() {
        // Do an asynchronous operation to fetch user.
    }


    public void setuser(MutableLiveData<User> user) {
        this.user = user;
    }

    public void onAddAgeClick(){
        
        int i = user.getValue().getUserAge();

        user.getValue().setUserAge(++i);
    }


}
