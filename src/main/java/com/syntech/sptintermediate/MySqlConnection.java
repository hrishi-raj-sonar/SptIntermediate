/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.sptintermediate;

import java.sql.SQLException;

/**
 *
 * @author hrishi
 */
public class MySqlConnection extends JdbcConnection{

    String driver = "com.mysql.cj.jdbc.Driver";
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/users";
    
    String username = "root";
    
    String password = "toor";
    
    @Override
    String getJdbcDriverClass() {
        return driver;
    }

    @Override
    String getJdbcURL() {
        return jdbcUrl;
    }

    @Override
    String getUserName() {
        return username;
    }

    @Override
    String getPassword() {
        return password;
    }
    
    
    public static void main(String[] args) throws SQLException {
        MySqlConnection a = new MySqlConnection();
        a.establishConnection();
        a.read();
        
    }
}
