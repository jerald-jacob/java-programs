/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.hangman;

<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.util.Scanner;

=======
import java.util.Scanner;
>>>>>>> 2a174c0136ac008f31ad85fd2af783e7b04a4154
/**
 *
 * @author jerald
 */
<<<<<<< HEAD
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
    
      WordGenerator wordSelector=new WordGenerator();
      WordFromFile wordFile=new WordFromFile();
        System.out.println(wordFile.getResult());
       
      try{
      while(wordSelector.hasNext()==true){
//       String words = "hello";
      
      String word=wordSelector.nextWord();
            HangMan hm = new HangMan(word);
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
    }catch(Exception e){
          System.out.println("no more values");
    } 
   }
}
=======


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
>>>>>>> 2a174c0136ac008f31ad85fd2af783e7b04a4154
