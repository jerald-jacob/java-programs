/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Scanner;

/**
 *
 * @author jerald
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HangmanPlay play = new HangmanPlay("abcdef");
        Scanner in =new Scanner(System.in);
        String guessWord="";
        for(int i=0;i<=5;i++){
            System.out.println("Enter the Charecter");
             char c = in.next().charAt(0); 

                guessWord+=c;
                play.guess(guessWord);
                play.getStatus();
                System.out.println(guessWord);
        }
        
     
        
    }

}

class HangmanPlay {

    public String word;
    String status;

    public HangmanPlay(String word) {
        this.word = word;
    }

    void guess(String c) {
  
        char[] charArray = word.toCharArray(); 
        char[] cArray = word.toCharArray();

        int numberCount = word.length();
        int totelTry = 5;
        int faildTrail = 0;

        for (int i = 0; i < word.length(); i++) {
            if (cArray[i] == charArray[i]) {
                System.out.println(numberCount);
                numberCount -= 1;
                if (numberCount == 0) {

                    status = "Won";
                    System.out.println("Won "+numberCount);
                } else if (numberCount > 0) {
                    status = "Running";
                    System.out.println("Running "+numberCount);
                }
            } else {
                faildTrail += 1;
                if (totelTry == faildTrail) {
                    status = "faild";
                    System.out.println("faild "+faildTrail);
                }
                
            }

        }

    }

    void getStatus() {
        System.out.println(status);
    }

}
