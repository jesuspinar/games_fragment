package com.jesuspinar.gamesfragment.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jesuspinar.gamesfragment.R;
import com.jesuspinar.gamesfragment.controller.GameTickTackToe;

public class Ticktacktoe extends Fragment {

    private final char PLAYER_COIN = 'o'; //development config
    private final char CPU_COIN = 'x'; //development config
    private final int playerImgCoin;
    private final int cpuImgCoin;
    private GameTickTackToe game;

    private int pointPlayer;
    private int pointCpu;
    private TextView tvPointPlayer;
    private TextView tvPointCpu;

    private ImageView ibCol1Row1;
    private ImageView ibCol2Row1;
    private ImageView ibCol3Row1;
    private ImageView ibCol1Row2;
    private ImageView ibCol2Row2;
    private ImageView ibCol3Row2;
    private ImageView ibCol1Row3;
    private ImageView ibCol2Row3;
    private ImageView ibCol3Row3;


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

        //Init new game button
        Button btnNewGame = view.findViewById(R.id.btnNewGame);

        //Get textview to display result
        tvPointPlayer = view.findViewById(R.id.tvScoreO);
        tvPointCpu = view.findViewById(R.id.tvScoreY);

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
        btnNewGame.setOnClickListener(v -> gameReset());
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
            game.addMove(pos, PLAYER_COIN);

            changeImg(game.addMoveCpu(), cpuImgCoin);

            //TODO: separate win check
            boolean cpuWin = game.isWin(CPU_COIN);
            boolean playerWin = game.isWin(PLAYER_COIN);

            if (playerWin){
                Toast.makeText(getContext(), "Player Wins!", Toast.LENGTH_SHORT).show();
                gameReset();
                pointPlayer++;
                tvPointPlayer.setText(String.valueOf(pointPlayer));
            }else if(cpuWin){
                Toast.makeText(getContext(), "CPU Wins!", Toast.LENGTH_SHORT).show();
                gameReset();
                pointCpu++;
                tvPointCpu.setText(String.valueOf(pointCpu));
            }
        };
    }

    private void gameReset(){
        int empty = R.drawable.ticktacktoe_void;
        game.newGame();
        ibCol1Row1.setImageResource(empty);
        ibCol2Row1.setImageResource(empty);
        ibCol3Row1.setImageResource(empty);
        ibCol1Row2.setImageResource(empty);
        ibCol2Row2.setImageResource(empty);
        ibCol3Row2.setImageResource(empty);
        ibCol1Row3.setImageResource(empty);
        ibCol2Row3.setImageResource(empty);
        ibCol3Row3.setImageResource(empty);

    }

    /**
     * Depending of the *PLAYER_COIN* will add (X|O) img to the selected img button
     *
     * @param pos acts like static id for ImageView
     * @param coin represents player or cpu move
     */
    private void changeImg(int pos, int coin){
        //TODO: avoid img position override
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
