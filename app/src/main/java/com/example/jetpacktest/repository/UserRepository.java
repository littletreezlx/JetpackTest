package com.example.jetpacktest.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.jetpacktest.room.MyDataBase;
import com.example.jetpacktest.model.User;
import com.example.jetpacktest.model.UserDao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        MyDataBase myDataBase = MyDataBase.getDatabase(application);
        userDao = myDataBase.userDao();

        allUsers =  userDao.getAllLiveDate();
    }

    public LiveData<List<User>> getUsers(){
        return allUsers;
    }


    public void insert (User user) {
        new insertAsyncTask(userDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }




}
