/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinic.dao;

import bean.login_empBean;
import bean.register_empBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.clinic.util.DBConnection;
import java.sql.Statement;

/**
 *
 * @author Farah
 */
public class employeeDAO {
    
    public String loginProcess(login_empBean login_empBean)
    {
      
       String username = login_empBean.getUsername();
       String password = login_empBean.getPassword();       
       Connection con = null;
       Statement statement = null;
       PreparedStatement preparedStatement = null;
       try
       {
           con = DBConnection.createConnection();
           String query= "select username, password from employee where username = ? and password = ?";
           
           preparedStatement = con.prepareStatement(query);
           preparedStatement.setString(1, username);
           preparedStatement.setString(2, password);
           
           ResultSet resultSet = preparedStatement.executeQuery();
          
               
            while( resultSet.next()){
                    return "SUCCESS";
            }
        
       
           
        }catch(SQLException e){
          e.printStackTrace();
          }
        return "Invalid user credentials";
        
    }
    
    public String registerProcess(register_empBean register_empBean){
       
       String employeeICNo = register_empBean.getEmployeeICNo();
       String employeeFirstName = register_empBean.getEmployeeFirstName();  
       String employeeLastName = register_empBean.getEmployeeLastName();
       String employeeAddress = register_empBean.getEmployeeAddress(); 
       String employeePhone = register_empBean.getEmployeePhone();
       String username = register_empBean.getUsername();
       String password = register_empBean.getPassword();       
       Connection con = null;
       Statement statement = null;
       PreparedStatement preparedStatement = null;
        
        try{
            con = DBConnection.createConnection();
            String query = "INSERT INTO EMPLOYEE (employeeICNo, employeeFirstName, employeeLastName, employeeAddress, employeePhone, username, password) " +
                         "VALUES (?,?,?,?,?,?,?)";
            
            preparedStatement = con.prepareStatement(query);
            
            preparedStatement.setString(1, employeeICNo);
            preparedStatement.setString(2, employeeFirstName);
            preparedStatement.setString(3, employeeLastName);
            preparedStatement.setString(4, employeeAddress);
            preparedStatement.setString(5, employeePhone);
            preparedStatement.setString(6, username);
            preparedStatement.setString(7, password);      
            preparedStatement.executeUpdate();
            
            ResultSet resultSet = preparedStatement.executeQuery();
            if(preparedStatement.executeUpdate()>0){
                return "Registration Successful!";
            }
        } 
        catch (Exception ex){
            ex.printStackTrace();
        }
        return "Registration failed.";
         
     }
}
       
    

