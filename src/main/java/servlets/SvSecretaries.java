
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
import logic.Secretary;




@WebServlet(name = "SvSecretaries", urlPatterns = {"/SvSecretaries"})
public class SvSecretaries extends HttpServlet {

   Controller control = new Controller();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Secretary>listSecretaries = new ArrayList<Secretary>();
        listSecretaries = control.getSecretaries();
       
        HttpSession mysession = request.getSession();
        mysession.setAttribute("listSecretaries",listSecretaries);
        
  
        response.sendRedirect("seeSecretaries.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String firstName = request.getParameter("firstName");
         String dni = request.getParameter("dni");
         String phone = request.getParameter("phone");
         String address = request.getParameter("address");
         String lastName = request.getParameter("lastName");
         String sector = request.getParameter("sector");
        
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
           Logger.getLogger(SvSecretaries.class.getName()).log(Level.SEVERE, null, ex);
       }
        
 // ---------End Date Birth Code --------// 
 
         control.createSecretary(firstName,dni,phone,lastName,sector,date_birth,address,aUserId);
         //Poder Utilizar el IdResponsible en forma de String en el seePatients.JSP 
         request.setAttribute("aUserIdString", "a User ID: " + aUserId);
         response.sendRedirect("index.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
