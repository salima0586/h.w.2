package com.example.filmapi;

import android.app.Application;

import androidx.room.Room;

import com.example.filmapi.local.AppDatabase;

public
class App extends Application {

    public static AppDatabase appDatabase;

    @Override
    public
    void onCreate() {
        super.onCreate();

        appDatabase = Room
                .databaseBuilder( this,AppDatabase.class,"data" )
                .allowMainThreadQueries()
                .build();

    }
    public static AppDatabase getAppDatabase(){return appDatabase;}

}
