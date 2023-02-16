/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.clinic.model.*;
import com.clinic.util.DBConnection;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fatin Amalin
 */
public class editPrescriptionController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
            response.setBufferSize(500000);
        List errorMsgs=new LinkedList();
        
        try(PrintWriter out=response.getWriter())
        {   int id=Integer.parseInt(request.getParameter("AppointmentID"));
            String patientICNo=request.getParameter("patientICNo");
            String date=request.getParameter("AppointmentDateTime");
            String medicineList=request.getParameter("medicineList");
            String prescription=request.getParameter("prescription");
            
            String Replacedate =date.replace('T',' ');
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH);            
            java.util.Date datechange;
            Timestamp appDate = null;
            if(Replacedate=="") {
                errorMsgs.add("Please enter the appointment date and time");
            }
            if(Replacedate!="")
            {   datechange = formatter.parse(Replacedate);
                appDate = new Timestamp( datechange.getTime());
            }

            if(patientICNo==null ||  patientICNo.trim().length()==0) {
                errorMsgs.add("Please enter patient ic No.");
            }
            
            if(errorMsgs.isEmpty())
            {
                Connection con=null;
                PreparedStatement pstmt=null;
                try{
                    con=DBConnection.createConnection();
                    
                    Appointment app =new Appointment();
                    app.setAppointmentID(id);
                    app.setAppointmentDateTime(appDate);
                    app.setMedicineList(medicineList);
                    app.setPrescription(prescription);
                    request.setAttribute("Appointment",app);
                    request.setAttribute("AppointmentID",id);
                    
                    pstmt=con.prepareStatement("UPDATE APPOINTMENT SET APPOINTMENTDATETIME = ?, MEDICINELIST=?,PRESCRIPTION=? WHERE APPOINTMENTID = ?");
                    pstmt.setTimestamp(1,appDate);
                    pstmt.setString(2,medicineList);
                    pstmt.setString(3,prescription);
                    pstmt.setInt(4,id);
                    pstmt.executeUpdate();

                    pstmt.close();;
                    con.close();
                    errorMsgs.add("Successfully updated prescription "+id);
                    request.setAttribute("errorMsgs", errorMsgs);
                    RequestDispatcher view = getServletContext().getRequestDispatcher("/prescriptionList.jsp");

                    view.forward(request,response);
                }
                
		catch (SQLException ex)
		{   ex.printStackTrace();
                    errorMsgs.add("An unexpected error: " + ex.getMessage());
                    request.setAttribute("errorMsgs", errorMsgs);
                    RequestDispatcher view = request.getRequestDispatcher("/editAppointment.jsp");
                    view.forward(request, response); 
                }
            }
            else
                 {  
                    request.setAttribute("errorMsgs", errorMsgs);
                    RequestDispatcher view = request.getRequestDispatcher("/editAppointment.jsp");
                    view.forward(request, response); 
                }
        }
            catch (RuntimeException e) {
                e.printStackTrace();
                errorMsgs.add("An unexpected error: " + e.getMessage());
                request.setAttribute("errorMsgs", errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/editAppointment.jsp");
//                view.forward(request, response); 
                return;
            }
            
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(editPrescriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(editPrescriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
