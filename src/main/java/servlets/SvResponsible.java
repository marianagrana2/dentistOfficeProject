
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
import logic.Responsible;


@WebServlet(name = "SvResponsible", urlPatterns = {"/SvResponsible"})
public class SvResponsible extends HttpServlet {

   Controller control = new Controller();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Responsible> listResponsibles = new ArrayList<Responsible>();
        listResponsibles = control.getResponsibles();
       
        HttpSession mysession = request.getSession();
        mysession.setAttribute("listResponsibles",listResponsibles);
        
  
        response.sendRedirect("seeResponsibles.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String firstName = request.getParameter("firstName");
         String dni = request.getParameter("dni");
         String phone = request.getParameter("phone");
         String address = request.getParameter("address");
         String lastName = request.getParameter("lastName");
         String responsibleType = request.getParameter("responsibleType");
         
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
           Logger.getLogger(SvResponsible.class.getName()).log(Level.SEVERE, null, ex);
       }
        
 // ---------End Date Birth Code --------//       
         control.createResponsible(firstName,dni,phone,lastName,responsibleType,date_birth,address);
         response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
