package com.jesuspinar.gamesfragment.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jesuspinar.gamesfragment.R;
import com.jesuspinar.gamesfragment.controller.IOnClickListener;

public class Home extends Fragment {

    private Button btnTickTackToe;
    private Button btnHangman;
    private IOnClickListener listener;

    public Home() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnTickTackToe = view.findViewById(R.id.btnTicktacktoe);
        btnHangman = view.findViewById(R.id.btnHangman);

        btnTickTackToe.setOnClickListener(v -> {
            listener.onClick(1);
        });
        btnHangman.setOnClickListener(v -> {
            listener.onClick(2);
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IOnClickListener) context;
    }
}
