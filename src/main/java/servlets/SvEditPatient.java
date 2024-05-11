
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
import logic.Patient;
import logic.Responsible;


@WebServlet(name = "SvEditPatient", urlPatterns = {"/SvEditPatient"})
public class SvEditPatient extends HttpServlet {

  Controller control = new Controller();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id=Integer.parseInt(request.getParameter("id"));
        Patient patie = control.bringPatient(id);
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("patientEdit",patie);
        
        response.sendRedirect("editPatient.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
         String dni = request.getParameter("dni");
         String phone = request.getParameter("phone");
         String address = request.getParameter("address");
         String lastName = request.getParameter("lastName");
         String bloodType = request.getParameter("bloodType");
         String medicalInsurance = request.getParameter("medicalInsurance");
         String responsibleId = request.getParameter("responsibleId");
         
         /*------------- Date Birth --------------*/
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
           Logger.getLogger(SvPatients.class.getName()).log(Level.SEVERE, null, ex);
       }
       /*-------------- End Date Birth -------------- */
       Patient patie = (Patient)request.getSession().getAttribute("patientEdit");
        patie.setBlood_type(bloodType);
        patie.setHave_medical_insurance("yes".equalsIgnoreCase(medicalInsurance));
        patie.setDni(dni);
        patie.setName(firstName);
        patie.setLast_name(lastName);
        patie.setAddress(address);
        patie.setPhone(phone);
        patie.setDate_birth(date_birth);
        
        /*-----------------  SET Responsible ID ----------------------*/
        //Añadir Responsible ID  y que si existe en la tabla Responsible se crea y se une en la base de datos.
        if (responsibleId!= null &&!responsibleId.isEmpty()) {
        //Se crea un nuevo Responsible 
        Responsible aResponsible = new Responsible();
        //El Id se pasa de String a Integer
        aResponsible.setId(Integer.parseInt(responsibleId));
        //Se establece el objeto aResponsible
        patie.setaResponsible(aResponsible);
        }
        /*---------------- END SET Responsible ID---------------------*/
        
        control.editPatient(patie);
        response.sendRedirect("SvPatients");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
