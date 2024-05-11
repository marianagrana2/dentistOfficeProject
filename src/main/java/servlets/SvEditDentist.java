
package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import logic.Schedule;
import logic.Secretary;
import logic.User;




@WebServlet(name = "SvEditDentist", urlPatterns = {"/SvEditDentist"})
public class SvEditDentist extends HttpServlet {

   Controller control = new Controller();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int id=Integer.parseInt(request.getParameter("id"));
        Dentist dent = control.bringDentist(id);
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("dentistEdit",dent);
        
        response.sendRedirect("editDentist.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String firstName = request.getParameter("firstName");
         String dni = request.getParameter("dni");
         String phone = request.getParameter("phone");
         String address = request.getParameter("address");
         String lastName = request.getParameter("lastName");
         String speciality = request.getParameter("specialty");
         String aScheduleId = request.getParameter("aScheduleId");
         String aUserId = request.getParameter("aUserId");
         
//-------Date Birth --------------//
         //Obtener Valor desde el forms del frontend y en forma de String por el Servlet(Lo necesita de esta forma)
         String dateBirthString = request.getParameter("dateBirth");
         //Crear Formato de la fecha en la base de datos
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //Inicializamos en null para evitar errores y por eso va en un try y catch 
        Date date_birth = null;
       try {
           //Convierte de String a Date para la base de datos que asi se programo en formato Date
           date_birth = formatter.parse(dateBirthString);
       } catch (ParseException ex) {
           Logger.getLogger(SvEditDentist.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        // ---------End Date Birth Code --------// 
        Dentist dent = (Dentist)request.getSession().getAttribute("dentistEdit"); 
        dent.setDni(dni);
        dent.setPhone(phone);
        dent.setName(firstName);
        dent.setLast_name(lastName);
        dent.setAddress(address);
        dent.setSpecialty(speciality);
        dent.setDate_birth(date_birth);       
       
        
        /*-----------------  SET User ID ----------------------*/
        //Añadir User ID  y que si existe en la tabla Responsible se crea y se une en la base de datos.
        if (aUserId!= null &&!aUserId.isEmpty()) {
        //Se crea un nuevo Responsible 
        User aUser = new User();
        //El Id se pasa de String a Integer
        aUser.setId_user(Integer.parseInt(aUserId));
        //Se establece el objeto aResponsible
        dent.setaUser(aUser);
        }
        /*---------------- END SET User ID---------------------*/
        
         /*-----------------  SET Schedule ID ----------------------*/
        //Añadir Responsible ID  y que si existe en la tabla Responsible se crea y se une en la base de datos.
        if(aScheduleId!= null &&!aScheduleId.isEmpty()) {
        //Se crea un nuevo Responsible 
        Schedule aSchedule = new Schedule();
        //El Id se pasa de String a Integer
        aSchedule.setId_schedule(Integer.parseInt(aScheduleId));
        //Se establece el objeto aResponsible
        dent.setaSchedule(aSchedule);
        }
        /*---------------- END SET Schedule ID---------------------*/
 
         control.editDentist(dent);
         response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
