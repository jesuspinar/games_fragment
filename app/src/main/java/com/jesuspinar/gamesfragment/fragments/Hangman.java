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
import com.jesuspinar.gamesfragment.controller.GameHangman;

public class Hangman extends Fragment {

    private GameHangman game;
    private String failedWord;
    private String word;
    private String wordToGuess;

    private ImageView ivHangman;
    private TextView tvWord, tvAttemptPlayer, tvPickedLetters;
    private Button btn_a, btn_b, btn_c, btn_d, btn_e, btn_f, btn_g, btn_h, btn_i, btn_j,
                   btn_k, btn_l, btn_m, btn_n, btn_ny, btn_o, btn_p, btn_q, btn_r,
                   btn_s, btn_t, btn_u, btn_v, btn_w, btn_x, btn_y, btn_z ;

    public Hangman() {
        super(R.layout.fragment_hangman);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvWord = view.findViewById(R.id.tvWord);
        tvAttemptPlayer = view.findViewById(R.id.tvAttempsPlayer);
        tvPickedLetters = view.findViewById(R.id.tvPickedLetters);
        ivHangman = view.findViewById(R.id.ivHangman);

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


        init();
        setBtnListeners();
    }

    private void init() {
        game = new GameHangman();
        newGame();
    }

    private View.OnClickListener manager(char letter) {
        return v -> {
            disableBtn(v);
            if (!game.contains(letter)){
                game.subtractAttempt();
                int attempts = game.getAttempts();
                tvAttemptPlayer.setText(String.valueOf(attempts));

                switch (attempts){
                    case 6: ivHangman.setImageResource(R.drawable.hangman_6); break;
                    case 5: ivHangman.setImageResource(R.drawable.hangman_5); break;
                    case 4: ivHangman.setImageResource(R.drawable.hangman_4); break;
                    case 3: ivHangman.setImageResource(R.drawable.hangman_3); break;
                    case 2: ivHangman.setImageResource(R.drawable.hangman_2); break;
                    case 1: ivHangman.setImageResource(R.drawable.hangman_1); break;
                    case 0: ivHangman.setImageResource(R.drawable.hangman_0); break;
                }
            }
            tvWord.setText(game.wordReveal(letter));
            tvPickedLetters.setText(game.getLetters());

            if(game.getAttempts() == 0){
                displayDefeatMessage();
                newGame();
                resetButtonProperties();
            }
            if (game.isMatch(tvWord.getText().toString())){
                displayWinMessage();
                newGame();
                resetButtonProperties();
            }
        };
    }

    private void newGame() {
        game.newGame();
        ivHangman.setImageResource(R.drawable.hangman_6);
        tvAttemptPlayer.setText(String.valueOf(game.getAttempts()));
        tvPickedLetters.setText("");
        tvWord.setText(game.wordFilter());
    }


    private void displayDefeatMessage() {
        Toast.makeText(getContext(), R.string.defeat_message, Toast.LENGTH_SHORT).show();
    }

    private void displayWinMessage() {
        Toast.makeText(getContext(), R.string.win_message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Properties that will affect to btn
     * @param btn
     */
    private void disableBtn(View btn){
        btn.setEnabled(false);
        btn.setClickable(false);
    }

    private void resetButtonProperties(){
        btn_a.setEnabled(true);
        btn_a.setClickable(true);
        btn_b.setEnabled(true);
        btn_b.setClickable(true);
        btn_c.setEnabled(true);
        btn_c.setClickable(true);
        btn_d.setEnabled(true);
        btn_d.setClickable(true);
        btn_e.setEnabled(true);
        btn_e.setClickable(true);
        btn_f.setEnabled(true);
        btn_f.setClickable(true);
        btn_g.setEnabled(true);
        btn_g.setClickable(true);
        btn_h.setEnabled(true);
        btn_h.setClickable(true);
        btn_i.setEnabled(true);
        btn_i.setClickable(true);
        btn_j.setEnabled(true);
        btn_j.setClickable(true);
        btn_k.setEnabled(true);
        btn_k.setClickable(true);
        btn_l.setEnabled(true);
        btn_l.setClickable(true);
        btn_m.setEnabled(true);
        btn_m.setClickable(true);
        btn_n.setEnabled(true);
        btn_n.setClickable(true);
        btn_ny.setEnabled(true);
        btn_ny.setClickable(true);
        btn_o.setEnabled(true);
        btn_o.setClickable(true);
        btn_p.setEnabled(true);
        btn_p.setClickable(true);
        btn_q.setEnabled(true);
        btn_q.setClickable(true);
        btn_r.setEnabled(true);
        btn_r.setClickable(true);
        btn_s.setEnabled(true);
        btn_s.setClickable(true);
        btn_t.setEnabled(true);
        btn_t.setClickable(true);
        btn_u.setEnabled(true);
        btn_u.setClickable(true);
        btn_v.setEnabled(true);
        btn_v.setClickable(true);
        btn_w.setEnabled(true);
        btn_w.setClickable(true);
        btn_x.setEnabled(true);
        btn_x.setClickable(true);
        btn_y.setEnabled(true);
        btn_y.setClickable(true);
        btn_z.setEnabled(true);
        btn_z.setClickable(true);
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
        btn_i.setOnClickListener(manager('i'));
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
