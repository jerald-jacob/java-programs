/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.training;

import com.innovature.training.dao.impl.UserDaoImpl;
import com.innovature.training.service.UserServ;
import com.innovature.training.service.impl.UserServimpl;
//import com.innovature.training.entity.User;

import java.util.Scanner;

/**
 *
 * @author jerald
 */
public class Main {
        private final UserServ UserServ;
        public Main(UserServ userServ) {
        this.UserServ=userServ;
    }
  public static void main(String[] args) {
        new  Main(new UserServimpl(new UserDaoImpl())).run();
              System.out.println("enter your choise");
    }
    private void run(){
        
        Scanner in=new Scanner(System.in);
        while(true){
        System.out.println("enter your choise");
        System.out.println("1.Create user");
        System.out.println("2.Delete user");
        System.out.println("3.Update user");
        System.out.println("4.Display user");
        System.out.println("5.exit");
        int opt=in.nextInt();
        switch(opt){
            case 1:
               UserServ.createUser();
                break;
            case 2:
                UserServ.updateUser();
                break;
            case 3:
                  UserServ.deleteUser();
                break;
            case 4:
                UserServ.displayUser();
                break;
            case 5:
                System.exit(0);
                break;
            
        }
        }
    }
}
