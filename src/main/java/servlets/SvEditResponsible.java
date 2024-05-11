
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
import logic.Responsible;



@WebServlet(name = "SvEditResponsible", urlPatterns = {"/SvEditResponsible"})
public class SvEditResponsible extends HttpServlet {

  Controller control = new Controller();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Responsible respo = control.bringResponsible(id);
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("respoEdit",respo);
        
        response.sendRedirect("editResponsible.jsp");
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
         String dateBirthString = request.getParameter("dateBirth");
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         Date date_birth = null;
         try {
           //Convierte de String a Date para la base de datos que asi se programo en formato Date
           date_birth = formatter.parse(dateBirthString);
       } catch (ParseException ex) {
           Logger.getLogger(SvResponsible.class.getName()).log(Level.SEVERE, null, ex);
       }
         
        Responsible respo = (Responsible)request.getSession().getAttribute("respoEdit");
        respo.setType_resp(responsibleType);
        respo.setDni(dni);
        respo.setName(firstName);
        respo.setLast_name(lastName);
        respo.setAddress(address);
        respo.setPhone(phone);
        respo.setDate_birth(date_birth);
        
        control.editResponsible(respo);
        response.sendRedirect("SvResponsible");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
