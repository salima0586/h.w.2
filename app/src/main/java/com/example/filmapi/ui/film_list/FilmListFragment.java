package com.example.filmapi.ui.film_list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filmapi.App;
import com.example.filmapi.R;
import com.example.filmapi.data.Films;
import com.example.filmapi.databinding.FragmentFilmListBinding;
import com.example.filmapi.remote.RetrofitBuilder;
import com.example.filmapi.ui.film_list.adapter.FilmAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public
class FilmListFragment extends Fragment implements FilmAdapter.Callback,FilmAdapter.SaveToRoom {

    private final FilmAdapter adapter = new FilmAdapter(this,this);
    private
    FragmentFilmListBinding binding;

    @Override
    public
    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState) {

        binding = FragmentFilmListBinding.inflate( inflater,container,false );
        return binding.getRoot();
    }

    @Override
    public
    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView(view);
        getFilms();


    }

    private
    void getFilms() {
        RetrofitBuilder.getInstance().getAllFilms().enqueue( new Callback<List<Films>>() {
            @Override
            public
            void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                adapter.addItems( response.body() );
            }

            @Override
            public
            void onFailure(Call<List<Films>> call, Throwable t) {

            }
        } );
    }

    void initView(View view) {
        binding.recyclerview.setAdapter( adapter );
    }

    @Override
    public
    void filmClick(Films films) {
        NavController navController = Navigation.findNavController( requireActivity(),R.id.fragment );
        Bundle bundle = new Bundle();
        bundle.putString( "id",films.getId() );
        navController.navigate( R.id.filmDetailFragment,bundle );
    }

    @Override
    public
    void click(Films films) {
        App.appDatabase.instance().insert( new Films(films.getTitle(),films.getOriginalTitle(),films.getProducer(),films.getDescription()) );
    }
}