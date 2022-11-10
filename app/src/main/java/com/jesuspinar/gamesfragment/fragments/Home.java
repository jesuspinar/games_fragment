package com.jesuspinar.gamesfragment.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jesuspinar.gamesfragment.R;

public class Home extends Fragment {

    private Button btnTickTackToe;
    private Button btnHangman;
    public Home() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnTickTackToe = view.findViewById(R.id.btnTicktacktoe);
        btnHangman = view.findViewById(R.id.btnHangman);

        btnHangman.setOnClickListener(v -> {

        });
    }


}
