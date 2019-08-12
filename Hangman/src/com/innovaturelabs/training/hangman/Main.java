/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.hangman;

import java.util.Scanner;
/**
 *
 * @author jerald
 */


public class Main {

    public static void main(String[] args) {
        WordGenerator wd=new WordGenerator();
        for(int i=0;i<wd.wordDictionary.length;i++){
          String word=  wd.wordDictionary[i];
          String wdd=wd.One();
        HangMan hm = new HangMan(wdd);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf(
                    "Guess the word: %s\nAlready gussed: %s. Wrong gusses: %d/%d\n",
                    hm.getFilledWord(), hm.getGuessedCharacters().toString(),
                    hm.getWrongGuesses(), HangMan.MAX_WRONG_GUESSES
            );

            if (hm.getStatus() != GameStatus.RUNNING) {
                break;
            }

            System.out.print("Enter new guess: ");
            String s = scanner.nextLine();
            try {
                hm.guess(s.charAt(0));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        if (hm.getStatus() == GameStatus.WON) {
            System.out.println("You won!!!");
        } else {
            System.out.println("You failed!!!");
        }
        }
    }
}
