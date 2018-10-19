package com.example.jetpacktest.room;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jetpacktest.model.Address;
import com.example.jetpacktest.model.User;
import com.example.jetpacktest.model.UserDao;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {User.class}, version = 2)
public abstract class MyDataBase extends RoomDatabase {


    public abstract UserDao userDao();

    private static volatile MyDataBase INSTANCE;

    public static MyDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MyDataBase.class, "my_database.db")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }



    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };




    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final UserDao dao;
        PopulateDbAsync(MyDataBase db) {
            dao = db.userDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            dao.deleteAll();

            User user0 = new User("Apple", 10, new Address("a", "b", "c", 0));
            dao.insert(user0);
//            User user1 = new User("Banana", 20, null);
//            dao.insert(user1);
            return null;
        }
    }

}
