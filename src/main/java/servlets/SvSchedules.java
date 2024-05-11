
package servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Controller;
import logic.Schedule;



@WebServlet(name = "SvSchedules", urlPatterns = {"/SvSchedules"})
public class SvSchedules extends HttpServlet {
 Controller control = new Controller();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Schedule> listSchedules = new ArrayList<Schedule>();
        listSchedules = control.getSchedules();
       
        HttpSession mysession = request.getSession();
        mysession.setAttribute("listSchedules",listSchedules);
        
  
        response.sendRedirect("seeSchedules.jsp");
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String startSchedule = request.getParameter("start_schedule");
        String finishSchedule = request.getParameter("finish_schedule");
        
        
        control.createSchedule(startSchedule,finishSchedule);
        
        response.sendRedirect("index.jsp");
       
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
