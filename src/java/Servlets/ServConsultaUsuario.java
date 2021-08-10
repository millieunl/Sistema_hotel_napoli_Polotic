
package Servlets;

import Logica.ControladoraHotel;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServConsultaUsuario", urlPatterns = {"/ServConsultaUsuario"})
public class ServConsultaUsuario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        ControladoraHotel control = new ControladoraHotel();

        //creamos una lista que contendra cada uno de los atributos de la tabla usuario
        List <Usuario> lista_usuario = control.traerUsuario();

        HttpSession miSesion = request.getSession();

        //verificacion
        //si la lista que se devolvio esta vacia, muestra un mensaje
        //sino muestra la lista de habitaciones completa
        if (lista_usuario == null || lista_usuario.isEmpty()) {
            response.sendRedirect("error.jsp");
        } else {
            miSesion.setAttribute("lista_usuario", lista_usuario);
            response.sendRedirect("ver-tabla-usuario.jsp");
        }

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
