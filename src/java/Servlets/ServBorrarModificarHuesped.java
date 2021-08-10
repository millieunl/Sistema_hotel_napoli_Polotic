
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


@WebServlet(name = "ServBorrarModificarHuesped", urlPatterns = {"/ServBorrarModificarHuesped"})
public class ServBorrarModificarHuesped extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        ControladoraHotel control = new ControladoraHotel();
        
        List <Huesped> lista_huespedes = control.traerHuesped();
        HttpSession miSesion = request.getSession();
        
         if(lista_huespedes == null || lista_huespedes.isEmpty() ){
            response.sendRedirect("error.jsp");
        }
        else {
            // actualiza la lista
            miSesion.setAttribute("lista_huespedes", lista_huespedes);
            response.sendRedirect("borrar-modificar-huesped.jsp");
        }
        

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
