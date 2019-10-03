
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorials;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author jerald
 */
public class Hangman {

    private StringBuilder filledWord;
    private Set<Character> guessedCharacter;
    private String word;
    private int wordLength,failLimit=0,winLimit,numberOfTry;
    public enum Status {
    RUN, WIN, FAIL
    }
    Status state =Status.RUN;
    public Hangman(String w) {
        word = w ;
        wordLength = word.length();
        winLimit=wordLength;
    }
    public void guess(char a)
    {
       
       if(state != Status.RUN)
       {
           throw new  IllegalStateException("Game is not Running");
       }
       if(guessedCharacter.contains(a))
       {
           throw new  IllegalStateException("character is allreday entered");
       }
       char testChar =Character.toUpperCase(a);
       if(testChar < 'A'&& testChar >'Z')
       {
           throw new  IllegalArgumentException("Illegal Character");
       }
       boolean flag = false;
       for(int i = 0; i < wordLength; i++)
       {
           if(word.charAt(i)==testChar)
           {
               filledWord.setCharAt(i, testChar);
               flag=true;
               winLimit--;
           }
       }
       System.out.println(filledWord);
       if(flag==false)
       {
           failLimit++;
       }
       if(winLimit==0)
       {
           state = Status.WIN;
       }
       if(failLimit==5)
       {
           state = Status.FAIL;
       }
    }
    public void getStatus()
    {
        if(state==Status.FAIL)
        {
            System.out.println("FAILED");
        }
        else
        if(state==Status.WIN)
        {
            System.out.println("WIN");
        }
        else
        {
            System.out.println("RUNNING");
        }   
    }

    public static void main(String args[])
    {
        System.out.println("enter the word");
        Scanner s = new Scanner(System.in);
        String  wordTemp = s.next();
        Hangman obj = new Hangman(wordTemp.toUpperCase());
        int t=wordTemp.length();
        obj.filledWord=new StringBuilder();
        obj.filledWord.setLength(t);
        obj.guessedCharacter=new HashSet<>();
        for( int i=0;i<t;i++)
        {
          obj.filledWord.setCharAt(i, '_');
        }
        System.out.println("enter the Number Of trys");
        int tryLimit = s.nextInt();
        for (int i = 0; i < tryLimit; i++)
        {    
            if(obj.state!=Status.RUN)
            {
                break;
            }
            System.out.println("enter character:");
            char gu = s.next().charAt(0);
            try {
                obj.guess(gu);
            } catch (IllegalStateException e) {
                System.out.println(e);
            }
        }
       obj.getStatus();
    }
}
