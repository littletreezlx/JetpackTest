package com.example.jetpacktest.viewmodel;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Application application;
    private String param;


    public MainViewModelFactory(Application application, String param) {
        this.application = application;
        this.param = param;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new MainViewModel(application, param);
    }
}