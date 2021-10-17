package com.example.filmapi.ui.room_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.filmapi.App;
import com.example.filmapi.data.Films;
import com.example.filmapi.databinding.FragmentRoomBinding;
import com.example.filmapi.ui.room_fragment.adapter.RoomAdapter;
import java.util.List;

public
class RoomFragment extends Fragment implements RoomAdapter.clickRoom {

    private
    FragmentRoomBinding binding;

    @Override
    public
    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState) {

        binding = FragmentRoomBinding.inflate( inflater,container,false );
        return binding.getRoot();

    }

    @Override
    public
    void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

        roomInit();
    }

    private
    void roomInit() {
        App.appDatabase.instance().getAll().observe( getViewLifecycleOwner(), new Observer<List<Films>>() {
            @Override
            public
            void onChanged(List<Films> films) {
                initrecycler(films);
            }
        } );
    }

    private
    void initrecycler(List<Films> films) {
        RoomAdapter adapter = new RoomAdapter( this );
        adapter.addItems( films );
        binding.recyclerview.setAdapter( adapter );
    }


    @Override
    public
    void click(Films films) {

    }
}