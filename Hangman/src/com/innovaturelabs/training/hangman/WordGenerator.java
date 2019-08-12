/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovaturelabs.training.hangman;

import java.util.Random;


/**
 *
 * @author jerald
 */
public class WordGenerator implements WordProvider {

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


