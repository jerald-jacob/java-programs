/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.hangman;
/**
 *
 * @author jerald
 */

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class HangMan {

    public static final int MAX_WRONG_GUESSES = 5;
    private static final char FILLER = '-';

    private final String word;
    private final StringBuilder filledWord;
    private final Set<Character> guessedCharacters = new LinkedHashSet<>();
    private final Set<Character> guessedCharactersView = Collections.unmodifiableSet(guessedCharacters);

    private GameStatus status = GameStatus.RUNNING;
    private int wrongGuesses = 0;

    public HangMan(String word) {
        this.word = word.toUpperCase();
        this.filledWord = new StringBuilder(word.length());
        for (int i = 0; i < word.length(); i++) {
            this.filledWord.append(FILLER);
        }
    }

    public void guess(char c) {
        if (status != GameStatus.RUNNING) {
            throw new IllegalStateException("Game is not running");
        }

        c = Character.toUpperCase(c);
        if (c < 'A' || c > 'Z') {
            throw new IllegalArgumentException("Invalid guess - must be a character from A~Z");
        }

        if (!guessedCharacters.add(c)) {
            throw new IllegalArgumentException("Already guessed character");
        }

        boolean wrongGuess = true;
        boolean completed = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                filledWord.setCharAt(i, c);
                wrongGuess = false;
            } else if (filledWord.charAt(i) == FILLER) {
                completed = false;
            }
        }

        if (wrongGuess) {
            wrongGuesses++;
            if (wrongGuesses == MAX_WRONG_GUESSES) {
                status = GameStatus.FAILED;
            }
        } else if (completed) {
            status = GameStatus.WON;
        }
    }

    public String getWord() {
        return word;
    }

    public String getFilledWord() {
        return filledWord.toString();
    }

    public Set<Character> getGuessedCharacters() {
        return guessedCharactersView;
    }

    public GameStatus getStatus() {
        return status;
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }
}