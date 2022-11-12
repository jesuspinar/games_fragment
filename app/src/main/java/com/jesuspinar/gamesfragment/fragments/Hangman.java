package com.jesuspinar.gamesfragment.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jesuspinar.gamesfragment.R;
import com.jesuspinar.gamesfragment.controller.GameHangman;

public class Hangman extends Fragment {

    private GameHangman game;
    private String failedWord;
    private String word;
    private String wordToGuess;

    private TextView tvWord, tvAttempPlayer, tvPickedLetters;
    private Button btn_a, btn_b, btn_c, btn_d, btn_e, btn_f, btn_g, btn_h, btn_i, btn_j,
                   btn_k, btn_l, btn_m, btn_n, btn_ny, btn_o, btn_p, btn_q, btn_r,
                   btn_s, btn_t, btn_u, btn_v, btn_w, btn_x, btn_y, btn_z ;

    public Hangman() {
        super(R.layout.fragment_hangman);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        game = new GameHangman();
        //get the word
        wordToGuess = game.getRandomWord();

        btn_a = view.findViewById(R.id.btn_a);
        btn_b = view.findViewById(R.id.btn_b);
        btn_c = view.findViewById(R.id.btn_c);
        btn_d = view.findViewById(R.id.btn_d);
        btn_e = view.findViewById(R.id.btn_e);
        btn_f = view.findViewById(R.id.btn_f);
        btn_g = view.findViewById(R.id.btn_g);
        btn_h = view.findViewById(R.id.btn_h);
        btn_i = view.findViewById(R.id.btn_i);
        btn_j = view.findViewById(R.id.btn_j);
        btn_k = view.findViewById(R.id.btn_k);
        btn_l = view.findViewById(R.id.btn_l);
        btn_m = view.findViewById(R.id.btn_m);
        btn_n = view.findViewById(R.id.btn_n);
        btn_ny = view.findViewById(R.id.btn_ñ);
        btn_o = view.findViewById(R.id.btn_o);
        btn_p = view.findViewById(R.id.btn_p);
        btn_q = view.findViewById(R.id.btn_q);
        btn_r = view.findViewById(R.id.btn_r);
        btn_s = view.findViewById(R.id.btn_s);
        btn_t = view.findViewById(R.id.btn_t);
        btn_u = view.findViewById(R.id.btn_u);
        btn_v = view.findViewById(R.id.btn_v);
        btn_w = view.findViewById(R.id.btn_w);
        btn_x = view.findViewById(R.id.btn_x);
        btn_y = view.findViewById(R.id.btn_y);
        btn_z = view.findViewById(R.id.btn_z);

        setBtnListeners();
    }

    private View.OnClickListener manager(char letter) {
        return v -> {
            //get the word
            //check if the letter is NOT in the word
            if (!game.contains(letter)){
                //block btn change color bg
                v.setEnabled(false);
                v.setClickable(false);
                tvPickedLetters.setText(game.getFailedLetter());

            }
            else{
                //is in the word . action

            }
            //game.isMatch()
        };
    }


    private void setBtnListeners() {
        btn_a.setOnClickListener(manager('a'));
        btn_b.setOnClickListener(manager('b'));
        btn_c.setOnClickListener(manager('c'));
        btn_d.setOnClickListener(manager('d'));
        btn_e.setOnClickListener(manager('e'));
        btn_f.setOnClickListener(manager('f'));
        btn_g.setOnClickListener(manager('g'));
        btn_h.setOnClickListener(manager('h'));
        btn_i.setOnClickListener(manager('y'));
        btn_j.setOnClickListener(manager('f'));
        btn_k.setOnClickListener(manager('k'));
        btn_l.setOnClickListener(manager('l'));
        btn_m.setOnClickListener(manager('m'));
        btn_n.setOnClickListener(manager('n'));
        btn_ny.setOnClickListener(manager('ñ'));
        btn_o.setOnClickListener(manager('o'));
        btn_p.setOnClickListener(manager('p'));
        btn_q.setOnClickListener(manager('q'));
        btn_r.setOnClickListener(manager('r'));
        btn_s.setOnClickListener(manager('s'));
        btn_t.setOnClickListener(manager('t'));
        btn_u.setOnClickListener(manager('u'));
        btn_v.setOnClickListener(manager('v'));
        btn_w.setOnClickListener(manager('w'));
        btn_x.setOnClickListener(manager('x'));
        btn_y.setOnClickListener(manager('y'));
        btn_z.setOnClickListener(manager('z'));

    }
}
