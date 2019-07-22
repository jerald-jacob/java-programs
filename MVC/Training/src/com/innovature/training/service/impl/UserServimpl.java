/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.training.service.impl;

import com.innovature.training.dao.UserDao;
import com.innovature.training.entity.User;
import com.innovature.training.service.UserServ;
import java.util.Scanner;

/**
 *
 * @author jerald
 */
public class UserServimpl implements UserServ {

    private final UserDao userDao;
    public UserServimpl(UserDao userDao){
        this.userDao=userDao;
        
    }
    @Override
    public void createUser() {
       Scanner in =new Scanner(System.in);
       System.out.println("Enter details to register an employee");
       System.out.println("enter user id");
       int userId=in.nextInt();
       System.out.println("enter user age");
       int age=in.nextInt();

       System.out.println("enter user first name");
       String firstName=in.nextLine();

       System.out.println("enter user last name");
       String lastName=in.nextLine();
       User user=new User(userId,age,firstName,lastName);
       userDao.createUser(user);

    }

    @Override
    public void updateUser() {
       
       Scanner in =new Scanner(System.in);
       System.out.println("Enter details to be updated");
       System.out.println("enter user id");
       int userId=in.nextInt();
       System.out.println("enter user age");
       int age=in.nextInt();

       System.out.println("enter user first name");
       String firstName=in.nextLine();

       System.out.println("enter user last name");
       String lastName=in.nextLine();
       User user=new User(userId,age,firstName,lastName);
       userDao.updateUser(userId,user);
    }

    @Override
    public void deleteUser() {
     Scanner in =new Scanner(System.in);
       System.out.println("Enter userId to remove the user");
       int userId=in.nextInt();   
       User user=new User(userId);
       userDao.deleteUser(userId);
    }

    @Override
    public void displayUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
