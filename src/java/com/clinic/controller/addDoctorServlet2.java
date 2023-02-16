/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package com.clinic.controller; 
 
import bean.Doctor; 
import com.clinic.dao.DoctorDAO;
import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.sql.Timestamp; 
 
import java.text.ParseException; 
import java.text.SimpleDateFormat; 
 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 
/* 
 * 
 * @author User 
 */ 
public class addDoctorServlet2 extends HttpServlet { 
     
    private DoctorDAO doctorDAO; 
 
    public void init(){ 
        doctorDAO=new DoctorDAO(); 
    } 
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8"); 
        try (PrintWriter out = response.getWriter()) { 
            /* TODO output your page here. You may use following sample code. */ 
            out.println("<!DOCTYPE html>"); 
            out.println("<html>"); 
            out.println("<head>"); 
            out.println("<title>Servlet addDoctorServlet</title>");             
            out.println("</head>"); 
            out.println("<body>"); 
            out.println("<h1>Servlet addDoctorServlet at " + request.getContextPath() + "</h1>"); 
            out.println("</body>"); 
            out.println("</html>"); 
        } 
    } 
 
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException { 
         
        response.setContentType("text/html;charset=UTF-8"); 
        PrintWriter out = response.getWriter(); 
             
        try { 
 
            String EmpICNo = request.getParameter("employeeICNo"); 
            String EmpFName = request.getParameter("dFName"); 
            String EmpLName = request.getParameter("dLName"); 
            String EmpAddress = request.getParameter("employeeAddress"); 
            String StartDate = request.getParameter("employeeStartDate"); 
            String EmpPhone = request.getParameter("employeePhone");   
            String sEmpTypeId = request.getParameter("EmpTypeId");   
            int EmpTypeId = Integer.parseInt(sEmpTypeId);  
            String Username = request.getParameter("username"); 
            String Password = request.getParameter("password"); 
             
            if(EmpICNo.length() == 0 || EmpFName.length() == 0 || EmpLName.length() == 0 || EmpAddress.length() == 0 || StartDate.length() == 0 ||  
                    EmpPhone.length() == 0 ||  Username.length() == 0 || Password.length() == 0) 
            { 
                out.println("Please fill in the form completely"); 
                return; 
            } 
            else { 
                if(EmpICNo.length() >12 || EmpICNo.length() <12) 
                { 
                    out.println("Please enter valid IC Number"); 
                    return; 
                } 
            } 
         
            Doctor newDoctor = new Doctor(EmpICNo,EmpFName,EmpLName,EmpAddress,StartDate,EmpPhone,EmpTypeId,Username,Password);     
            doctorDAO.insertDoctor(newDoctor); 
                                
            request.getRequestDispatcher("/addDoctor.jsp").forward(request, response); 
             
            } 
            catch(Exception ex) { 
                throw new ServletException(ex); 
            }            
        } 
         
     
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {     
        doGet(request, response); 
    } 
   
}