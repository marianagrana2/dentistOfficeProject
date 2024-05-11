
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Controller;
import logic.Dentist;
import logic.Shift;




@WebServlet(name = "SvShifts", urlPatterns = {"/SvShifts"})
public class SvShifts extends HttpServlet {

   Controller control = new Controller();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Shift>listShifts = new ArrayList<Shift>();
        listShifts = control.getShift();
       
        HttpSession mysession = request.getSession();
        mysession.setAttribute("listShifts",listShifts);
        
  
        response.sendRedirect("seeShifts.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
         String timeShift = request.getParameter("timeShift");
         String treatment = request.getParameter("treatment");
         String dentiId = request.getParameter("dentiId");
         String patieId = request.getParameter("patieId");
         
//-------Date --------------//
         //Obtener Valor desde el forms del frontend y en forma de String por el Servlet(Lo necesita de esta forma)
         String dateShiftString = request.getParameter("dateShift");
         //Crear Formato de la fecha en la base de datos
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //Inicializamos en null para evitar errores y por eso va en un try y catch 
        Date dateShift = null;
       try {
           //Convierte de String a Date para la base de datos que asi se programo en formato Date
           dateShift = formatter.parse(dateShiftString);
       } catch (ParseException ex) {
           Logger.getLogger(SvShifts.class.getName()).log(Level.SEVERE, null, ex);
       }
        
 // ---------End Date  --------// 
         
         control.createShift(dateShift,timeShift,treatment,dentiId,patieId);
         //Poder Utilizar el IdResponsible en forma de String en el seePatients.JSP 
         request.setAttribute("dentiIdString", "Dentist ID: " + dentiId);
         request.setAttribute("patieIdString","Patient ID: " + patieId);
         response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
