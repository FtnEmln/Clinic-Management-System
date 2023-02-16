import com.clinic.model.Appointment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.clinic.util.DBConnection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fatin Amalin
 */
public class AppEditController extends HttpServlet {

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
            String doctorName=request.getParameter("doctorName");
            String date=request.getParameter("AppointmentDateTime");
            String Replacedate =date.replace('T',' ');
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.ENGLISH);            
            java.util.Date  datechange = formatter.parse(Replacedate);
            Timestamp appDate = new Timestamp( datechange.getTime());
            
            if(patientICNo==null ||  patientICNo.trim().length()==0) {
                errorMsgs.add("Please enter patient ic No.");
            }

            
            if(doctorName==null  ||  doctorName.trim().length()==0) {
                errorMsgs.add("Please choose the doctor.");
            }

            if(errorMsgs.isEmpty())
            {
                Connection con=null;
                PreparedStatement pstmt=null;
                ResultSet rs=null;
                try{
                    con=DBConnection.createConnection();
                    
                    Appointment app =new Appointment();
                    app.setAppointmentID(id);
                    app.setAppointmentDateTime(appDate);
                    app.setMedicineList(null);
                    app.setPrescription(null);
                    request.setAttribute("Appointment",app);
                    request.setAttribute("AppointmentID",id);
                    
                    PreparedStatement pst=con.prepareStatement("Select employeeicno from Employee WHERE employeefirstname=? AND employeetypeid=2");
                    pst.setString(1,doctorName);
                    ResultSet rst=pst.executeQuery();
                   
                    String doctoric=null;
                    while(rst.next())
                    {
                        doctoric=rst.getString(1); 

                    }
                    
                    pstmt=con.prepareStatement("UPDATE APPOINTMENT SET APPOINTMENTDATETIME = ?, PATIENTICNO = ?, EMPLOYEEICNO=? WHERE APPOINTMENTID = ?");
                    pstmt.setTimestamp(1,appDate);
                    pstmt.setString(2,patientICNo);
                    pstmt.setString(3,doctoric);
                    pstmt.setInt(4,id);
                    pstmt.executeUpdate();

                    pst.close();
                    pstmt.close();
                    rst.close();
                    con.close();
                    errorMsgs.add("Successfully updated appointment " + id);
                    request.setAttribute("errorMsgs", errorMsgs);
                    RequestDispatcher view = getServletContext().getRequestDispatcher("/AppointmentList.jsp");
                    //RequestDispatcher view = request.getRequestDispatcher("/Activities/viewActivitiesFStaff.jsp");
                    view.forward(request,response);
                }
                
		catch (IOException | SQLException ex)
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
            Logger.getLogger(AppEditController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AppEditController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
