package com.jesuspinar.gamesfragment.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.jesuspinar.gamesfragment.R;

public class Ticktacktoe extends Fragment {
    private static int GAME_INDEX = 1; // By default starts O

    private int pointP1;
    private int pointP2;
    private ImageButton ibCol1Row1;
    private ImageButton ibCol2Row1;
    private ImageButton ibCol3Row1;
    private ImageButton ibCol1Row2;
    private ImageButton ibCol2Row2;
    private ImageButton ibCol3Row2;
    private ImageButton ibCol1Row3;
    private ImageButton ibCol2Row3;
    private ImageButton ibCol3Row3;
    private TextView tvPointP1;
    private TextView tvPointP2;
    private ConstraintLayout clBoard;

    public Ticktacktoe() {
        super(R.layout.fragment_ticktacktoe);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
        //Get textview to display result
        tvPointP1 = view.findViewById(R.id.tvScoreO);
        tvPointP2 = view.findViewById(R.id.tvScoreY);
        //Get constrain layout board
        clBoard = view.findViewById(R.id.clBoard);
        //Create event listeners
        ibCol1Row1.setOnClickListener(this::changeImg);
        ibCol2Row1.setOnClickListener(this::changeImg);
        ibCol3Row1.setOnClickListener(this::changeImg);

        ibCol1Row2.setOnClickListener(this::changeImg);
        ibCol2Row2.setOnClickListener(this::changeImg);
        ibCol3Row2.setOnClickListener(this::changeImg);

        ibCol1Row3.setOnClickListener(this::changeImg);
        ibCol2Row3.setOnClickListener(this::changeImg);
        ibCol3Row3.setOnClickListener(this::changeImg);
    }

    /**
     * Implements a turn
     * @return player movement
     */
    private int getLast() {
        if(GAME_INDEX == 0) GAME_INDEX = 1;
        else GAME_INDEX = 0;
        return GAME_INDEX;
    }
    /**
     * Depending of the turn will add (X|O) img to the selected img button
     */
    private void changeImg(View v) {
        int img = getLast();
        //Alternates touch
        if (img == 0){
            img = R.drawable.ticktacktoeo;
        }else {
            img = R.drawable.ticktacktoex;
        }
        Log.w("Trying to get click","click passed");
        //ROW 1 ---------------------------
        if(v.getId() == R.id.ibCol1Row1){
            ibCol1Row1.setImageResource(img);
        }
        else if(v.getId() == R.id.ibCol2Row1){
            ibCol2Row1.setImageResource(img);
        }
        else if(v.getId() == R.id.ibCol3Row1){
            ibCol3Row1.setImageResource(img);
        }
        //ROW 2 ---------------------------
        else if(v.getId() == R.id.ibCol1Row2){
            ibCol1Row2.setImageResource(img);
        }
        else if(v.getId() == R.id.ibCol2Row2){
            ibCol2Row2.setImageResource(img);
        }
        else if(v.getId() == R.id.ibCol3Row2){
            ibCol3Row2.setImageResource(img);
        }
        //ROW 3 ---------------------------
        else if(v.getId() == R.id.ibCol1Row3){
            ibCol1Row3.setImageResource(img);
        }
        else if(v.getId() == R.id.ibCol2Row3){
            ibCol2Row3.setImageResource(img);
        }
        else if(v.getId() == R.id.ibCol3Row3){
            ibCol3Row3.setImageResource(img);
        }
    }



    private void startGame(){

    }

}
