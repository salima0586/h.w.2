package com.example.filmapi.ui.room_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.filmapi.R;

class FilmRoomFragment extends Fragment {

    @Override
    public
    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState) {
        return inflater.inflate( R.layout.fragment_film_detail, container, false );
    }
}