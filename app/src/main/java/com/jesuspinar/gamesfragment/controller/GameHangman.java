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
    private char[] lettersWord;

    public GameHangman() {
        sbFailedLetter = new StringBuilder();
        sbGuessedLetter = new StringBuilder();
    }

    public void newGame() {
        attempts = ATTEMPT_CONF;
        sbFailedLetter.setLength(0);
        sbGuessedLetter.setLength(0);
        getRandomWord();
    }

    /**
     * Get a new word from the words array and creates
     * and saves to String and a char array.
     * @return the new random word
     */
    private String getRandomWord(){
        Random r = new Random();
        int max = words.length;
        wordToGuess = words[r.nextInt(max)];
        lettersWord = wordToGuess.toCharArray();
        return wordToGuess;
    }

    public String getFailedLetter(){
        return sbFailedLetter.toString();
    }

    /**
     * Changes under score char with the correct letters
     * @return the parsed string
     */
    public String getFilteredLetters(){

        //TODO: check this logic
        StringBuilder temp = new StringBuilder();
        char[] tempWord = wordToGuess.toCharArray();

        for (int i = 0; i < tempWord.length; i++) {
            for (int j = 0; j < sbGuessedLetter.length(); j++) {
                if (tempWord[i] == sbGuessedLetter.charAt(j)){
                    temp.append(tempWord[i]);
                };
            }
            temp.append("_");
        }

        return temp.toString();
    }

    /**
     * This method checks if the letter is word and
     * adds letter to failed or guessed string builder
     * @param c represents the character
     * @return true if it's in the word
     */
    public boolean contains(char c){
        //TODO: check this logic
        boolean isIn = false;
        if (wordToGuess == null) return false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if(c == lettersWord[i]){
                sbGuessedLetter.append(c);
                isIn = true;
            }
        }
        if (isIn) sbFailedLetter.append(c);
        return isIn;
    }

    public int getWordLength(){
        return lettersWord.length;
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
