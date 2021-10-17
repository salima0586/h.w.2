package com.example.filmapi.remote;

import com.example.filmapi.data.Films;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public
interface FilmApi {

    @GET("/films")
    Call<List<Films>> getAllFilms();

    @GET("/films/{id}")
    Call<Films> getFilmsById(
            @Path( "id" ) String filmId
    );

}
