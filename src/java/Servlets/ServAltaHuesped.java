
package Servlets;

//
import Logica.ControladoraHotel;

//importa librerias
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServAltaHuesped", urlPatterns = {"/ServAltaHuesped"})
public class ServAltaHuesped extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();
        
        
        //traemos lo que se ingreso desde el formulario como string 
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String sFechaNac = request.getParameter("fechaNac");
        String profesion = request.getParameter("profesion");
        String direccion = request.getParameter("direccion");
        
        //convertimos al tipo que corresponde para poder guardarlo en la DB
        Date fechaNac = control.deStringToDate(sFechaNac);
        
        
        //traemos la sesion
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("fechaNac", fechaNac);
        request.getSession().setAttribute("profesion", profesion);
        request.getSession().setAttribute("direccion", direccion);
       
        response.sendRedirect("exito.jsp");
        
        //enviamos los parametros  desde el servlet,para crear nuevo huesped,
       // para eso crear un objeto de la clase Controladora de la logica en este servlet
        
        control.crearHuesped(nombre, apellido,dni,fechaNac,profesion,direccion);
        
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
