/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.training.dao.impl;

import com.innovature.training.dao.UserDao;
import com.innovature.training.entity.User;
import com.innovature.training.jdbc.JDBCHelper;
import java.sql.*;
/**
 *
 * @author jerald
 */
public class UserDaoImpl implements UserDao{
        Connection conn;
    public UserDaoImpl() {
        conn= JDBCHelper.DBConnect();
    }

    @Override
    public void createUser(User u) {
              PreparedStatement stmt=null;
        ResultSet rslt=null;
        try{
            Integer userId=u.getUserId();
            String sql="select * from Employees where id="+userId;
            stmt = conn.prepareStatement(sql);
            rslt = stmt.executeQuery(sql);
            if(rslt.next()){
                System.out.println("User already exists, try using different User Id..");
            }
            else{
                String s="insert into Employees(id,age,first,last) values("+u.getUserId()+","+u.getAge()+",'"+u.getFirstName()+"','"+u.getLastName()+"')";
                stmt=conn.prepareStatement(s);
                stmt.executeUpdate();
                System.out.println("User created, User ID : "+ u.getUserId());
            }
        }catch(SQLException | RuntimeException se){
            se.printStackTrace();
        }finally{
                try{
                    if(stmt==null)
                    conn.close();
                    }catch(SQLException se){
                    System.out.println(se.getCause());
                    }
            }
    }

    @Override
    public void updateUser(Integer userId, User u) {
    
        
        PreparedStatement stmt=null;
        ResultSet rslt=null;
        try{
            String sql="select * from Employees where id="+userId;
            stmt = conn.prepareStatement(sql);
            rslt = stmt.executeQuery();
            if(rslt.next()){
                String s="update Employees set fitsr= '"+u.getFirstName()+"', last= '"+u.getLastName()+"',age="+u.getAge()+" where id= "+userId;
                stmt=conn.prepareStatement(s);
                stmt.executeUpdate();
                System.out.println("User updated, User ID : "+ userId);
            }
            else{
                System.out.println("User not found, please confirm User Id");
            }
        }catch(SQLException | RuntimeException se){
            se.printStackTrace();
        }finally{
                try{
                    if(stmt==null)
                    conn.close();
                    }catch(SQLException se){
                    System.out.println(se.getCause());
                    }
            }    
    }

    @Override
    public void deleteUser(Integer userId) {
                PreparedStatement stmt=null;
        ResultSet rslt=null;
        try{
            String sql="select * from Employees where id="+userId;
            stmt = conn.prepareStatement(sql);
            rslt = stmt.executeQuery();
            if(rslt.next()){
                String s="delete from Employees where id= "+userId;
                System.out.println(s);
                stmt=conn.prepareStatement(s);
                stmt.executeUpdate();
                System.out.println("User deleted");   
            }
            else{
                System.out.println("User not found, please confirm User Id");
            }
        }catch(SQLException | RuntimeException se){
            se.printStackTrace();
        }finally{
                try{
                    if(stmt==null)
                    conn.close();
                    }catch(SQLException se){
                    System.out.println(se.getCause());
                    }
        }
    }
    
}
