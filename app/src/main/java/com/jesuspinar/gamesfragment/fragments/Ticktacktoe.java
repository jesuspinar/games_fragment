package com.jesuspinar.gamesfragment.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.jesuspinar.gamesfragment.R;
import com.jesuspinar.gamesfragment.controller.GameTickTackToe;

public class Ticktacktoe extends Fragment {

    private final char PLAYER_COIN = 'o'; //development config
    private GameTickTackToe game;

    private int pointP1;
    private int pointP2;

    private ImageView ibCol1Row1;
    private ImageView ibCol2Row1;
    private ImageView ibCol3Row1;
    private ImageView ibCol1Row2;
    private ImageView ibCol2Row2;
    private ImageView ibCol3Row2;
    private ImageView ibCol1Row3;
    private ImageView ibCol2Row3;
    private ImageView ibCol3Row3;

    private TextView tvPointP1;
    private TextView tvPointP2;

    private int playerImgCoin;

    public Ticktacktoe() {
        super(R.layout.fragment_ticktacktoe);
        if (PLAYER_COIN == 'o') playerImgCoin = R.drawable.ticktacktoeo;
        else playerImgCoin = R.drawable.ticktacktoex;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        game = new GameTickTackToe(PLAYER_COIN);
        //Get textview to display result
        tvPointP1 = view.findViewById(R.id.tvScoreO);
        tvPointP2 = view.findViewById(R.id.tvScoreY);

        //Get buttons id
        ibCol1Row1 = view.findViewById(R.id.ibCol1Row1);
        ibCol2Row1 = view.findViewById(R.id.ibCol2Row1);
        ibCol3Row1 = view.findViewById(R.id.ibCol3Row1);
        ibCol1Row2 = view.findViewById(R.id.ibCol1Row2);
        ibCol2Row2 = view.findViewById(R.id.ibCol2Row2);
        ibCol3Row2 = view.findViewById(R.id.ibCol3Row2);
        ibCol1Row3 = view.findViewById(R.id.ibCol1Row3);
        ibCol2Row3 = view.findViewById(R.id.ibCol2Row3);
        ibCol3Row3 = view.findViewById(R.id.ibCol3Row3);

        //Create event listeners
        //ROW 1 ---------------------------
        ibCol1Row1.setOnClickListener(v -> {
            int id = v.getId();
            changeImg(id, playerImgCoin);//for player
            game.addMove(1, 1, PLAYER_COIN);

        });
        ibCol2Row1.setOnClickListener(v -> {
            int id = v.getId();
            changeImg(id, playerImgCoin);//for player
            game.addMove(1, 2, PLAYER_COIN);

        });
        ibCol3Row1.setOnClickListener(v -> {
            int id = v.getId();
            changeImg(id, playerImgCoin);//for player
            game.addMove(1, 3, PLAYER_COIN);

        });
        //ROW 2 ---------------------------
        ibCol1Row2.setOnClickListener(v -> {
            int id = v.getId();
            changeImg(id, playerImgCoin);//for player
            game.addMove(2, 1, PLAYER_COIN);

        });
        ibCol2Row2.setOnClickListener(v -> {
            int id = v.getId();
            changeImg(id, playerImgCoin);//for player
            game.addMove(2, 2, PLAYER_COIN);

        });
        ibCol3Row2.setOnClickListener(v -> {
            int id = v.getId();
            changeImg(id, playerImgCoin);//for player
            game.addMove(2, 3, PLAYER_COIN);

        });
        //ROW 3 ---------------------------
        ibCol1Row3.setOnClickListener(v -> {
            int id = v.getId();
            changeImg(id, playerImgCoin);//for player
            game.addMove(3, 1, PLAYER_COIN);

        });
        ibCol2Row3.setOnClickListener(v -> {
            int id = v.getId();
            changeImg(id, playerImgCoin);//for player
            game.addMove(3, 2, PLAYER_COIN);

        });
        ibCol3Row3.setOnClickListener(v -> {
            int id = v.getId();
            changeImg(id, playerImgCoin);//for player
           //TODO: int cpuMove = game.addMove(3, 3, PLAYER_COIN);

        });

    }

    /**
     * Depending of the *PLAYER_COIN* will add (X|O) img to the selected img button
     * @param id represents the id of the ImageView
     * @param coin represents player or cpu move
     */
    private void changeImg(int id, int coin) {
        Log.w("changeImg", "click passed");
        //ROW 1 ---------------------------
        if (id == R.id.ibCol1Row1)      ibCol1Row1.setImageResource(coin);
        else if (id == R.id.ibCol2Row1) ibCol2Row1.setImageResource(coin);
        else if (id == R.id.ibCol3Row1) ibCol3Row1.setImageResource(coin);
        //ROW 2 ---------------------------
        else if (id == R.id.ibCol1Row2) ibCol1Row2.setImageResource(coin);
        else if (id == R.id.ibCol2Row2) ibCol2Row2.setImageResource(coin);
        else if (id == R.id.ibCol3Row2) ibCol3Row2.setImageResource(coin);
        //ROW 3 ---------------------------
        else if (id == R.id.ibCol1Row3) ibCol1Row3.setImageResource(coin);
        else if (id == R.id.ibCol2Row3) ibCol2Row3.setImageResource(coin);
        else if (id == R.id.ibCol3Row3) ibCol3Row3.setImageResource(coin);
    }

}
