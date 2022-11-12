package com.jesuspinar.gamesfragment.controller;

import java.util.Random;

public class GameHangman {

    //DEVELOPMENT VARS
    private final int ATTEMPT_CONF = 5;
    //GAME VARS
    private final String[] words = {"bocata","coche","humano","ironia","zaragoza"};
    private final StringBuilder sbFailedLetter;
    private final StringBuilder sbGuessedLetter;
    private String wordToGuess;
    private int attempts;
    char[] lettersWord;

    public GameHangman() {
        attempts = ATTEMPT_CONF;
        sbFailedLetter = new StringBuilder();
        sbGuessedLetter = new StringBuilder();
    }

    /**
     * Get a new word from the words array and creates
     * and saves to String and a char array.
     * @return the new random word
     */
    public String getRandomWord(){
        Random r = new Random();
        int max = words.length;
        wordToGuess = words[r.nextInt(max)];
        lettersWord = wordToGuess.toCharArray();
        return wordToGuess;
    }

    public void addFailedLetter(String letter){
        sbFailedLetter.append(letter);
    }

    public String getFailedLetter(){
        return sbFailedLetter.toString();
    }

    /**
     * This method checks if the letter is word
     * @param c represents de character
     * @return true if it's in the word
     */
    public boolean contains(char c){
        if (wordToGuess == null) return false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if(c == lettersWord[i]){
                sbGuessedLetter.append(c);
                return true;
            }
        }
        sbFailedLetter.append(c);
        return false;
    }

    /**
     * Checks the whole word
     * @param word
     * @return true if match
     */
    public boolean isMatch(String word){
        return wordToGuess.equalsIgnoreCase(word);
    }

    public void subtractAttempt(){
        --attempts;
    }

    public int getAttempts(){
        return attempts;
    }


}
