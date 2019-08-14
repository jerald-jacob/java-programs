/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jerald
 */
public class WordGenerator implements WordProvider {

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