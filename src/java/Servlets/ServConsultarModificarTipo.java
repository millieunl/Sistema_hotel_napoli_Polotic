
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


@WebServlet(name = "ServConsultarModificarTipo", urlPatterns = {"/ServConsultarModificarTipo"})
public class ServConsultarModificarTipo extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        ControladoraHotel control = new ControladoraHotel();

        //creamos una lista que contendra cada uno de los atributos de la tabla habitacion
        List <TipoHabitacion> lista_tipo = control.traerTipo();

        HttpSession miSesion = request.getSession();

        //verificacion
        //si la lista que se devolvio esta vacia, muestra un mensaje
        //sino muestra la lista de habitaciones completa
        if (lista_tipo == null || lista_tipo.isEmpty()) {
            response.sendRedirect("error.jsp");
        } else {
            // actualiza la lista
            miSesion.setAttribute("lista_tipo", lista_tipo);
            response.sendRedirect("consultar-modificar-tipo.jsp");
        }
  
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
