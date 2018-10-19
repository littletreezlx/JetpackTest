package com.example.jetpacktest.viewmodel;

import android.app.Application;

import com.example.jetpacktest.model.Address;
import com.example.jetpacktest.model.User;
import com.example.jetpacktest.repository.UserRepository;
import com.example.jetpacktest.ui.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public class MainViewModel extends AndroidViewModel {


    private UserRepository userRepository;
    private LiveData<List<User>> users;



    private String testStr;


//    public MainViewModel() {
//        //
//        int i =1;
//
//    }


    public MainViewModel(Application application, String testStr) {
        super(application);

        this.userRepository = new UserRepository(application);
        users = userRepository.getUsers();

//        users = new MutableLiveData<>();
//        User user = new User("Car", 10, new Address("a", "b", "c", 0));
//        users.setValue(Arrays.asList(user));


        this.testStr = testStr;
    }



    public LiveData<List<User>> getUsers() {
        return users;
    }

    private void loaduser() {
        // Do an asynchronous operation to fetch user.
    }


//    public void onAddAgeClick(){
//        User user = new User("Car", 10, new Address("a", "b", "c", 0));
//
//        List<User> userList = new ArrayList<>();
//        userList.addAll(users.getValue());
//        userList.add(user);
//
//        users.setValue(userList);
//    }

    public void onAddAgeClick(){
        User user = new User("Car", 10, new Address("a", "b", "c", 0));

        userRepository.insert(user);
    }


}
