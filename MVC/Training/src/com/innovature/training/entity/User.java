/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.training.entity;

/**
 *
 * @author jerald
 */
public class User {
    private Integer userId;

    public User(Integer userId, Integer age, String firstName, String lastName) {
        this.userId = userId;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    private Integer age;
    private String firstName;
    private String lastName;

    public User(int userId) {
        //delete the user
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
