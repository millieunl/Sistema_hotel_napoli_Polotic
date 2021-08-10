
package Servlets;

import Logica.ControladoraHotel;
import Logica.Huesped;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServConsultaHuesped", urlPatterns = {"/ServConsultaHuesped"})
public class ServConsultaHuesped extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        ControladoraHotel control = new ControladoraHotel();
        
        List <Huesped> listaHuespedes = control.traerHuesped();
        HttpSession miSesion = request.getSession();
        
        miSesion.setAttribute("listaHuespedes",listaHuespedes);
        response.sendRedirect("informe-huespedes.jsp");
      
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
