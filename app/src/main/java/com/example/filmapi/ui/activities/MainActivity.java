package com.example.filmapi.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.View;

import com.example.filmapi.R;
import com.example.filmapi.databinding.ActivityMainBinding;

public
class MainActivity extends AppCompatActivity {

    private
    ActivityMainBinding binding;

    @Override
    protected
    void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding = ActivityMainBinding.inflate( getLayoutInflater() );
        setContentView( binding.getRoot() );

        binding.btnShow.setOnClickListener( new View.OnClickListener() {
            @Override
            public
            void onClick(View v) {
                NavController navController = Navigation.findNavController( MainActivity.this,R.id.fragment );
                navController.navigate( R.id.roomFragment);
            }
        } );
    }


}