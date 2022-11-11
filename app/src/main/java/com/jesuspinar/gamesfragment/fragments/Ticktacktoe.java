package com.jesuspinar.gamesfragment.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jesuspinar.gamesfragment.R;
import com.jesuspinar.gamesfragment.controller.GameTickTackToe;

public class Ticktacktoe extends Fragment {

    private final char PLAYER_COIN = 'o'; //development config
    private final int playerImgCoin;
    private final int cpuImgCoin;
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


    public Ticktacktoe() {
        super(R.layout.fragment_ticktacktoe);
        if (PLAYER_COIN == 'o') {
            playerImgCoin = R.drawable.ticktacktoeo;
            cpuImgCoin = R.drawable.ticktacktoex;
        } else {
            playerImgCoin = R.drawable.ticktacktoex;
            cpuImgCoin = R.drawable.ticktacktoeo;
        }
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
        ibCol1Row1.setOnClickListener(manager(0));
        ibCol2Row1.setOnClickListener(manager(1));
        ibCol3Row1.setOnClickListener(manager(2));
        //ROW 2 ---------------------------
        ibCol1Row2.setOnClickListener(manager(3));
        ibCol2Row2.setOnClickListener(manager(4));
        ibCol3Row2.setOnClickListener(manager(5));
        //ROW 3 ---------------------------
        ibCol1Row3.setOnClickListener(manager(6));
        ibCol2Row3.setOnClickListener(manager(7));
        ibCol3Row3.setOnClickListener(manager(8));

    }

    /**
     * This places an img and manage the game
     *
     * @param pos refers to the array position
     * @return
     */
    public View.OnClickListener manager(int pos) {
        return v -> {
            changeImg(pos, playerImgCoin);
            int posCpu = game.addMove(pos, PLAYER_COIN);
            changeImg(posCpu, cpuImgCoin);

            //TODO: check if isWin

            //TODO: resets game
        };
    }

    /**
     * Depending of the *PLAYER_COIN* will add (X|O) img to the selected img button
     *
     * @param pos acts like static id for ImageView
     * @param coin represents player or cpu move
     */
    private void changeImg(int pos, int coin){
        //TODO: solve double click bug
        switch (pos){
            case 0: ibCol1Row1.setImageResource(coin);break;
            case 1: ibCol2Row1.setImageResource(coin);break;
            case 2: ibCol3Row1.setImageResource(coin);break;
            case 3: ibCol1Row2.setImageResource(coin);break;
            case 4: ibCol2Row2.setImageResource(coin);break;
            case 5: ibCol3Row2.setImageResource(coin);break;
            case 6: ibCol1Row3.setImageResource(coin);break;
            case 7: ibCol2Row3.setImageResource(coin);break;
            case 8: ibCol3Row3.setImageResource(coin);break;
        }
    }

}
