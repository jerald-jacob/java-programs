/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.training.dao;

import com.innovature.training.entity.User;

/**
 *
 * @author jerald
 */
public interface UserDao {
    void createUser(User u);
    void updateUser(Integer userId,User u);
    void deleteUser(Integer userId);
    
}
