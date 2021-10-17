package com.example.filmapi.ui.film_detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filmapi.data.Films;
import com.example.filmapi.databinding.FragmentFilmDetailBinding;
import com.example.filmapi.remote.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public
class FilmDetailFragment extends Fragment {

    private
    FragmentFilmDetailBinding binding;
    private String id;

    @Override
    public
    void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        if (getArguments() != null) {
            id = getArguments().getString( "id" );
        }
    }

    @Override
    public
    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate( inflater, container, false );
        return binding.getRoot();
    }

    @Override
    public
    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

        RetrofitBuilder.getInstance().getFilmsById( id ).enqueue( new Callback<Films>() {
            @Override
            public
            void onResponse(Call<Films> call, Response<Films> response) {
                if (response.isSuccessful() && response.body() != null) {

                    binding.tvTitle.setText( response.body().getTitle() );
                    binding.tvProducer.setText( response.body().getOriginalTitle() );
                    binding.desc.setText( response.body().getDescription() );
                }
            }

            @Override
            public
            void onFailure(Call<Films> call, Throwable t) {
                Log.d( "tag", "failure: " + t.getLocalizedMessage() );
            }
        } );
    }
}