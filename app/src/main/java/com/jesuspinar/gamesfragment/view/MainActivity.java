package com.jesuspinar.gamesfragment.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.jesuspinar.gamesfragment.R;
import com.jesuspinar.gamesfragment.controller.IOnClickListener;
import com.jesuspinar.gamesfragment.fragments.Home;
import com.jesuspinar.gamesfragment.fragments.Ticktacktoe;

public class MainActivity extends AppCompatActivity implements IOnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .replace(R.id.fragmentContainerView, Ticktacktoe.class, null)
                .commit();
    }

    @Override
    public void onClick(int position) {
        //TODO : pass the click to the fragment
    }
}