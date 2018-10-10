package com.example.jetpacktest.service;

import com.example.jetpacktest.ui.MainActivity;
import com.example.jetpacktest.viewmodel.MainViewModel;

import androidx.lifecycle.ViewModelProviders;

public class MainPresenter {


    private MainActivity mainActivity;
    private MainViewModel mainViewModel;

    public MainPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

        mainViewModel = ViewModelProviders.of(mainActivity).get(MainViewModel.class);
    }


    public void onAddAgeClick(){
        mainViewModel.onAddAgeClick();
    }







}
