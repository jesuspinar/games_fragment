package com.jesuspinar.gamesfragment.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.jesuspinar.gamesfragment.R;
import com.jesuspinar.gamesfragment.controller.IOnClickListener;
import com.jesuspinar.gamesfragment.fragments.Hangman;
import com.jesuspinar.gamesfragment.fragments.Home;
import com.jesuspinar.gamesfragment.fragments.Ticktacktoe;

public class MainActivity extends AppCompatActivity implements IOnClickListener {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainerView, Home.class, null)
                .commit();
    }

    /**
     * Acts like fragment menu for Home
     * @param position
     */
    @Override
    public void onClick(int position) {
        if (position == 1){
            manager.beginTransaction()
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainerView, Ticktacktoe.class, null)
                    .commit();
        }
        else if (position == 2){
            manager.beginTransaction()
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainerView, Hangman.class, null)
                    .commit();
        }
    }
}