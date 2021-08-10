
package Servlets;

import Logica.ControladoraHotel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServAltaTipoHabitacion", urlPatterns = {"/ServAltaTipoHabitacion"})
public class ServAltaTipoHabitacion extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();
        
        //VARIABLES AUXILIARES
        //traemos lo que se ingreso desde el formulario como string 
        //datos para el empleado
        String tipo = request.getParameter("tipo");
        String cant_limite = request.getParameter("cant_limite");
        String s_precio = request.getParameter("precio");
        
        
       
        
        //convertimos a los tipos que corresponde para poder guardarlo en la DB
        Double d_precio = Double.valueOf(s_precio);
        int i_cant_limite = Integer.parseInt(cant_limite);
        String l_tipo = tipo.toLowerCase();
       
        //traemos la sesion
        request.getSession().setAttribute("tipo", l_tipo);
        request.getSession().setAttribute("cant_limite", cant_limite);
        request.getSession().setAttribute("precio", d_precio);
        
        response.sendRedirect("exito.jsp");
        
        /*enviamos los parametros  desde el servlet,para crear nuevo empleado,
        para eso crear un objeto de la clase Controladora de la logica en este servlet */
        control.crearTipoHabitacion(l_tipo,i_cant_limite,d_precio);
        
        
       
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
