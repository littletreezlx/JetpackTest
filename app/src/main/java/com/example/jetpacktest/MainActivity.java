package com.example.jetpacktest;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.jetpacktest.databinding.MainActivityBinding;
import com.example.jetpacktest.databinding.UserTest0;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {



    private UserTest0 user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

        user = new UserTest0();
        user.setUserName("A");

        MainActivityBinding mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity);



        MainViewModel mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainActivityBinding.setMainviewmodel(mainViewModel);
        mainActivityBinding.setLifecycleOwner(this);

    }


    @MainThread
    public void addObserver(@NonNull LifecycleObserver observer) {
        getLifecycle().addObserver(observer);
    }

    @MainThread
    public void removeObserver(@NonNull LifecycleObserver observer) {
        getLifecycle().removeObserver(observer);
    }

    @MainThread
    @NonNull
    public Lifecycle.State getCurrentState() {
        return getLifecycle().getCurrentState();
    }


    public UserTest0 getUser() {
        return user;
    }

    public void setUser(UserTest0 user) {
        this.user = user;
    }
}


//
//    ListItemBinding binding = ListItemBinding.inflate(layoutInflater, viewGroup, false);
//    // or
//    ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);