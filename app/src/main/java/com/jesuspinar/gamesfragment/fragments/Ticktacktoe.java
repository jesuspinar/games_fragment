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

public class Ticktacktoe extends Fragment {

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

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
        ibCol1Row1.setOnClickListener(this::changeImg);
        ibCol2Row1.setOnClickListener(this::changeImg);
        ibCol3Row1.setOnClickListener(this::changeImg);
        //ROW 2 ---------------------------
        ibCol1Row2.setOnClickListener(this::changeImg);
        ibCol2Row2.setOnClickListener(this::changeImg);
        ibCol3Row2.setOnClickListener(this::changeImg);
        //ROW 3 ---------------------------
        ibCol1Row3.setOnClickListener(this::changeImg);
        ibCol2Row3.setOnClickListener(this::changeImg);
        ibCol3Row3.setOnClickListener(this::changeImg);
    }

    /**
     * Depending of the turn will add (X|O) img to the selected img button
     */
    private void changeImg(View v) {
        //TODO: IMPLEMENT GAME LOGIC
        int img = 0;
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
