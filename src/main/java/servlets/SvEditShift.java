
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
import logic.Patient;
import logic.Shift;




@WebServlet(name = "SvEditShift", urlPatterns = {"/SvEditShift"})
public class SvEditShift extends HttpServlet {

   Controller control = new Controller();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       int id=Integer.parseInt(request.getParameter("id"));
        Shift shift = control.bringShift(id);
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("shiftEdit",shift);
        
        response.sendRedirect("editShift.jsp");
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
           Logger.getLogger(SvEditShift.class.getName()).log(Level.SEVERE, null, ex);
       }
        
 // ---------End Date  --------// 
         
 
        Shift shift = (Shift)request.getSession().getAttribute("shiftEdit");
        shift.setDate_shift(dateShift);
        shift.setTime_shift(timeShift);
        shift.setTreatment(treatment);
        
        
        /*-----------------  SET Dentist ID ----------------------*/
        //Añadir Responsible ID  y que si existe en la tabla Responsible se crea y se une en la base de datos.
        if (dentiId!= null &&!dentiId.isEmpty()) {
        //Se crea un nuevo Responsible 
        Dentist denti = new Dentist();
        //El Id se pasa de String a Integer
        denti.setId(Integer.parseInt(dentiId));
        //Se establece el objeto aResponsible
        shift.setDent(denti);
        }
        /*---------------- END SET Dentist ID---------------------*/
        
         /*-----------------  SET Patient ID ----------------------*/
        //Añadir Patient ID  y que si existe en la tabla Responsible se crea y se une en la base de datos.
        if(patieId!= null &&!patieId.isEmpty()) {
        //Se crea un nuevo Responsible 
        Patient patie = new Patient();
        //El Id se pasa de String a Integer
        patie.setId(Integer.parseInt(patieId));
        //Se establece el objeto aResponsible
        shift.setPatien(patie);
        }
        /*---------------- END SET Patient ID---------------------*/
         control.editShift(shift);
         response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
