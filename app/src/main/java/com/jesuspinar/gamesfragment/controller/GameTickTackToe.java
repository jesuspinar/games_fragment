package com.jesuspinar.gamesfragment.controller;

import java.util.Arrays;

public class GameTickTackToe {

    private char CPU_COIN;
    private final char[] board;

    public GameTickTackToe(char playerCoin) {
        board = new char[9];
        newGame();
        if (playerCoin == 'o') CPU_COIN = 'x';
        else CPU_COIN = 'o';
    }

    public void newGame(){
        Arrays.fill(board, ' ');
    }

    /**
     * Adds a movement to the board if empty position
     * @param pos
     * @param xo
     * @return the next move of the CPU
     */
    public int addMove(int pos, char xo){
        char empty = ' ';
        //ROW 1 ---------------------------
        if (empty == board[0] && pos == 0) board[0] = xo;
        else if (empty == board[1] && pos == 1) board[1] = xo;
        else if (empty == board[2] && pos == 2) board[2] = xo;
        //ROW 2 ---------------------------
        else if (empty == board[3] && pos == 3) board[3] = xo;
        else if (empty == board[4] && pos == 4) board[4] = xo;
        else if (empty == board[5] && pos == 5) board[5] = xo;
        //ROW 3 ---------------------------
        else if (empty == board[6] && pos == 6) board[6] = xo;
        else if (empty == board[7] && pos == 7) board[7] = xo;
        else if (empty == board[8] && pos == 8) board[8] = xo;

        //PLAYS THE CPU --------
        return cpuAddMove();
    }

    /**
     * Cpu game logic
     * @return the move has made
     */
    private int cpuAddMove() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' '){
                board[i] = CPU_COIN;
                return i;
            }
        }
        return -1;
    }

    public boolean isWin(char xo){
        //Left-right check
        if (board[0] == xo && board[1] == xo && board[2] == xo) return true;
        else if (board[3] == xo && board[4] == xo && board[5] == xo) return true;
        else if (board[6] == xo && board[7] == xo && board[8] == xo) return true;
        //Top-bottom check
        else if (board[0] == xo && board[3] == xo && board[6] == xo) return true;
        else if (board[1] == xo && board[4] == xo && board[7] == xo) return true;
        else if (board[2] == xo && board[5] == xo && board[8] == xo) return true;
        //Diagonal check
        else if (board[0] == xo && board[4] == xo && board[8] == xo) return true;
        else if (board[2] == xo && board[4] == xo && board[6] == xo) return true;
        return false;
    }
}
