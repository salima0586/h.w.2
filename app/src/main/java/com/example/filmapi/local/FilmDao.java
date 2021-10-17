package com.example.filmapi.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.filmapi.data.Films;

import java.util.List;

@Dao
public
interface FilmDao {

    @Query( "SELECT * FROM Films" )
    LiveData<List<Films>> getAll();

    @Insert
    void insert(Films films);
}
