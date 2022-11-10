package com.jesuspinar.gamesfragment.controller;

public class GameTickTackToe {

    private final char[] board;

    public GameTickTackToe() {
        board = new char[]{' ',' ',' ',
                             ' ',' ',' ',
                             ' ',' ',' '};
    }

    public void addMove(int row, int col, char xo){
        //ROW 1 ---------------------------
        if (row == 1 && col == 1){
            board[0] = xo;
        }
        else if (row == 1 && col == 2){
            board[1] = xo;
        }
        else if (row == 1 && col == 3){
            board[2] = xo;
        }
        //ROW 2 ---------------------------
        else if (row == 2 && col == 1){
            board[3] = xo;
        }
        else if (row == 2 && col == 2){
            board[4] = xo;
        }
        else if (row == 2 && col == 3){
            board[5] = xo;
        }
        //ROW 3 ---------------------------
        else if (row == 3 && col == 1){
            board[6] = xo;
        }
        else if (row == 3 && col == 2){
            board[7] = xo;
        }
        else if (row == 3 && col == 3){
            board[8] = xo;
        }
    }

    public boolean isWin(){
        //TODO: implement player won
        char xo = 'o'; //player coin
        //Left-right check
        if (board[0] == xo && board[1] == xo && board[2] == xo){
            //player won
            return true;
        }
        else if (board[3] == xo && board[4] == xo && board[5] == xo){
            //player won
            return true;
        }
        else if (board[6] == xo && board[7] == xo && board[8] == xo){
            //player won
            return true;
        }
        //Top-bottom check
        else if (board[0] == xo && board[3] == xo && board[6] == xo){
            //player won
            return true;
        }
        else if (board[1] == xo && board[4] == xo && board[7] == xo){
            //player won
            return true;
        }
        else if (board[2] == xo && board[5] == xo && board[8] == xo){
            //player won
            return true;
        }
        //Diagonal check
        else if (board[0] == xo && board[4] == xo && board[8] == xo){
            //player won
            return true;
        }
        else if (board[2] == xo && board[4] == xo && board[6] == xo){
            //player won
            return true;
        }
        return false;
    }
}
