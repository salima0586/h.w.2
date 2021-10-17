package com.example.filmapi.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.filmapi.data.Films;

@Database( entities = Films.class,version =  1)
public
abstract class  AppDatabase extends RoomDatabase {

    public abstract FilmDao instance();
}
