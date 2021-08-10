
package Servlets;

import Logica.ControladoraHotel;

//librerias
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServAltaEmpleado", urlPatterns = {"/ServAltaEmpleado"})
public class ServAltaEmpleado extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();
        
        //VARIABLES AUXILIARES
        //traemos lo que se ingreso desde el formulario como string 
        //datos para el empleado
        String nombre = request.getParameter("nombre").toLowerCase();
        String apellido = request.getParameter("apellido").toLowerCase();
        String dni = request.getParameter("dni");
        String sFechaNac = request.getParameter("fechaNac");
        String cargo = request.getParameter("cargo").toLowerCase();
        String direccion = request.getParameter("direccion");
        
        //datos para el usuario
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        
        
        //convertimos al tipo que corresponde para poder guardarlo en la DB
        Date fechaNac = control.deStringToDate(sFechaNac);
        
        
        //traemos la sesion
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("fechaNac", fechaNac);
        request.getSession().setAttribute("cargo", cargo);
        request.getSession().setAttribute("direccion", direccion);
        request.getSession().setAttribute("usuario", usuario);
        request.getSession().setAttribute("contrasenia", contrasenia);
       
        response.sendRedirect("exito.jsp");
         
        /*enviamos los parametros  desde el servlet,para crear nuevo empleado,
        para eso crear un objeto de la clase Controladora de la logica en este servlet */
        control.crearEmpleadoUsuario(nombre, apellido,dni,fechaNac,cargo,direccion,usuario,contrasenia);
     
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
