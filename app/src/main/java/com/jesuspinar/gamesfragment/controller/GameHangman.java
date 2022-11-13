package com.jesuspinar.gamesfragment.controller;

import java.util.Random;

public class GameHangman {

    //DEVELOPMENT VARS
    private final int ATTEMPT_CONF = 6;
    private final String[] words = {"bocata","coche","humano","ironia","flor"};

    //GAME VARS
    private final StringBuilder sbLetters;
    private final StringBuilder body;
    private String wordToGuess;
    private char[] lettersWord;
    private int attempts;

    public GameHangman() {
        sbLetters = new StringBuilder();
        body = new StringBuilder();
    }

    public void newGame() {
        attempts = ATTEMPT_CONF;
        sbLetters.setLength(0);
        body.setLength(0);
        setRandomWord();
        setWordBody();
    }

    /**
     * Get a new word from the words array and creates
     * and saves to String and a char array.
     * @return the new random word
     */
    private void setRandomWord(){
        Random r = new Random();
        int max = words.length;
        wordToGuess = words[r.nextInt(max)];
        lettersWord = wordToGuess.toCharArray();
    }

    public String getLetters(){
        return sbLetters.toString();
    }

    /**
     * Create a body string builder
     */
    private void setWordBody() {
        for (char c : lettersWord) {
            body.append("_");
        }
    }

    /**
     * Changes under score char with the correct letters
     * @return the parsed string
     */
    public String wordReveal(char c){
        for (int i = 0; i < lettersWord.length; i++) {
            if (lettersWord[i] == c) {
                body.setCharAt(i, c);
            }
        }
        return body.toString();
    }

    /**
     * This method checks if the letter is word and
     * adds letter to string builder
     * @param c represents the character or letter
     * @return true if it's in the word
     */
    public boolean contains(char c){
        boolean isIn = false;
        sbLetters.append(c);
        for (char letter : lettersWord) {
            if (c == letter) {
                isIn = true;
                break;
            }
        }
        return isIn;
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

    /**
     * Hides the word with under score char at start
     * @return the word length
     */
    public String wordFilter(){
        StringBuilder filter = new StringBuilder();
        for (int i = 0; i < lettersWord.length; i++) {
            filter.append('_');
        }
        return filter.toString();
    }
}
