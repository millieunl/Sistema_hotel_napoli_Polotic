
package Servlets;

import Logica.ControladoraHotel;
import Logica.Habitacion;
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


@WebServlet(name = "ServAltaHabitacion", urlPatterns = {"/ServAltaHabitacion"})
public class ServAltaHabitacion extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();
        
        //traemos lo que se ingreso desde el formulario como string 
        String s_nro_piso = request.getParameter("nro_piso");
        String nombre_habitacion = request.getParameter("nombre_habitacion").toLowerCase();
        String s_tipo = request.getParameter("tipo");

        
        //convertimos al tipo que corresponde para poder guardarlo en la DB
        boolean esta_reservada = false;
        int nro_piso = Integer.parseInt(s_nro_piso);
        int tipo = Integer.parseInt(s_tipo);

        //traemos la sesion
        request.getSession().setAttribute("nro_piso", nro_piso);
        request.getSession().setAttribute("nombre_habitacion", nombre_habitacion);
        request.getSession().setAttribute("tipo", s_tipo);

        //enviamos los parametros  desde el servlet,para crear nuevo huesped,
        //para eso crear un objeto de la clase Controladora de la logica en este servlet
        control.crearHabitacion(nro_piso, nombre_habitacion, tipo, esta_reservada);
        
         //redirije 
        response.sendRedirect("exito.jsp");
        
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
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
