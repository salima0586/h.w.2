package com.example.filmapi.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public
class RetrofitBuilder {

    private RetrofitBuilder(){}

    private static FilmApi instance;

    public static FilmApi getInstance(){
        if (instance == null){
            instance = createRetrofit();
        }
        return instance;
    }

    private static
    FilmApi createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl( "https://ghibliapi.herokuapp.com" )
                .addConverterFactory( GsonConverterFactory.create() )
                .build()
                .create( FilmApi.class );
    }

}
