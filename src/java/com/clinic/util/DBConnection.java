package com.clinic.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Fatin Amalin
 */
public class DBConnection {
    public static Connection createConnection() throws SQLException {
    try {
        String driver="org.apache.derby.jdbc.ClientDriver";
        String connectionString="jdbc:derby://localhost:1527/ClinicManagement;create=true;user=root;password=root";
            try{
                 Class.forName(driver); 
                }
            catch(ClassNotFoundException ex){
                ex.printStackTrace();
            }
        Connection con = DriverManager.getConnection(connectionString);
        if (con != null) {
            System.out.println("Connection working");
        } else {
            System.out.println("Failed to make connection!");
        }
        return con;
    } catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        throw e;
    }
}
}
