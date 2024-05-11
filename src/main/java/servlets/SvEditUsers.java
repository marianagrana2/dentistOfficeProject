
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Controller;
import logic.User;


@WebServlet(name = "SvEditUsers", urlPatterns = {"/SvEditUsers"})
public class SvEditUsers extends HttpServlet {

   Controller control = new Controller();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        User usu = control.bringUser(id);
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("usuEdit",usu);
        
        response.sendRedirect("editUser.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nameUsu = request.getParameter("userName");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        User usu = (User)request.getSession().getAttribute("usuEdit");
        usu.setUser_name(nameUsu);
        usu.setPassword(password);
        usu.setRole(role);
        
        control.editUser(usu);
        response.sendRedirect("SvUsers");
               
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
