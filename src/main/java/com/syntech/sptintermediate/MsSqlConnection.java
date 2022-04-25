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
public class MsSqlConnection extends JdbcConnection {

    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    String jdbcURL = "jdbc:sqlserver://127.0.0.1;databaseName=users;selectMethod=cursor";

    String userName = "sa";

    String password = "19Febru@ri";

    @Override
    String getJdbcDriverClass() {
        return driver;
    }

    @Override
    String getJdbcURL() {
        return jdbcURL;
    }

    @Override
    String getUserName() {
        return userName;
    }

    @Override
    String getPassword() {
        return password;
    }
    
//    public static void main(String[] args) throws SQLException {
//        MsSqlConnection a = new MsSqlConnection();
//        a.establishConnection();
//        a.read();
//        
//    }
}
