/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

/**
 *
 * @author jerald
 */
public class HelloWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Text me=new Text();
        me.name();
    }
   
    
}
class Text{
     public void name(){
        String name ="jerald";
      System.out.println("hai "+name);
    }
}
