
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Controller;
import logic.Schedule;



@WebServlet(name = "SvEditSchedules", urlPatterns = {"/SvEditSchedules"})
public class SvEditSchedules extends HttpServlet {

   Controller control = new Controller();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Schedule schedu = control.bringSchedule(id);
        
        HttpSession mysession = request.getSession();
        mysession.setAttribute("scheduEdit",schedu);
        
        response.sendRedirect("editSchedule.jsp");
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String startSchedule = request.getParameter("start_schedule");
        String finishSchedule = request.getParameter("finish_schedule");
        
        Schedule schedu = (Schedule)request.getSession().getAttribute("scheduEdit");
        schedu.setStart_schedule(startSchedule);
        schedu.setFinish_schedule(finishSchedule);
        
        control.editSchedule(schedu);
        response.sendRedirect("SvSchedules");
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
