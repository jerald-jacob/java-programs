/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.hangman;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

=======
import java.util.Random;


>>>>>>> 2a174c0136ac008f31ad85fd2af783e7b04a4154
/**
 *
 * @author jerald
 */
public class WordGenerator implements WordProvider {

<<<<<<< HEAD
   private static String[] stringarray = {"Hello","world","welcome"}; 
    
    
   public  String word;
   @Override
   public boolean hasNext() {
       if(stringarray==null){
           return false;
       }
      return true;
   }

   @Override
   public String nextWord() {         
         List<String> wordslist=new ArrayList<String>(Arrays.asList(stringarray));
         String word = wordslist.get(new Random().nextInt(wordslist.size()));
         wordslist.remove(word);
         stringarray=wordslist.toArray(new String[0]);
    
      return word;
   }

   
}
=======
    String[] wordDictionary;

    public String[] getWordDictionary() {
        return wordDictionary;
    }

    public WordGenerator() {
        this.wordDictionary = new String[]
        {
            "apple", "banana", "lemon", "lime", "mango","Books", "Pens", "Pencils", "Notebooks","mobile",
        };
    }

    @Override
    public void nextWord() {
        int idx = new Random().nextInt(wordDictionary.length);
String random = (wordDictionary[idx]);
        System.out.println(random);
       
         }
    String One(){
        
        int idx = new Random().nextInt(wordDictionary.length);
String random = (wordDictionary[idx]);
        return random;
    }
    }


>>>>>>> 2a174c0136ac008f31ad85fd2af783e7b04a4154
