/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clinic.controller;

import bean.login_empBean;
import com.clinic.dao.employeeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Farah
 */
public class login_empServlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List errorMsgs = new LinkedList();
        
        boolean validated = false;
        String username = request.getParameter("n");
        String password = request.getParameter("p");
            
        //form verification
        if(username==null || username.trim().length()==0){
            errorMsgs.add("Please enter Username.");
        }
        else if(password==null || password.trim().length()==0){
            errorMsgs.add("Please enter the password.");
        }
            
        if(!errorMsgs.isEmpty()){
            request.setAttribute("e",errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/login_emp.jsp");
            view.forward(request,response);
            return;
        }
        
        employeeDAO  employee= new employeeDAO();
        
        login_empBean emp = new login_empBean(username, password);
        String result = employee.loginProcess(emp);
        
        if(result.equalsIgnoreCase("SUCCESS")){
            HttpSession session = request.getSession();
            session.setAttribute("username", username.toUpperCase());
            response.sendRedirect("login_emp.jsp");
        } else{
            request.setAttribute("errorMsgs", "Invalid user credentials");
            request.getRequestDispatcher("login_emp.jsp").forward(request, response);
        }
    }

}
