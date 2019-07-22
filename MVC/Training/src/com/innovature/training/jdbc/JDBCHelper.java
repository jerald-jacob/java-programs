/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovature.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jerald
 */
public class JDBCHelper {
    
    private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    private static final String DB_URL="jdbc:mysql://localhost:3306/EMP";
    private static final String USER="jerald";
    private static final String PASS="12345678";
    private static Connection conn=null;

    public JDBCHelper() {
    }
    
    public static Connection DBConnect(){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            }catch(SQLException | ClassNotFoundException | RuntimeException se){
            System.out.println(se.getCause());
            }
        return conn;
    }
}
