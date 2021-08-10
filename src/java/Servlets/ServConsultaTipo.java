
package Servlets;

import Logica.ControladoraHotel;
import Logica.TipoHabitacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServConsultaTipo", urlPatterns = {"/ServConsultaTipo"})
public class ServConsultaTipo extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        processRequest(request, response);
        
        /*para traer los tipos que existen en la DB)*/
        ControladoraHotel control = new ControladoraHotel();
        List <TipoHabitacion> listaTipos = control.traerTipo();        
   
       HttpSession miSesion = request.getSession();
       miSesion.setAttribute("listaTipos",listaTipos);
       response.sendRedirect("form-crear-habitacion.jsp");   
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
