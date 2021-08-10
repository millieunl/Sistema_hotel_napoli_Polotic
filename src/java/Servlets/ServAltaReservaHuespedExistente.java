
package Servlets;

import Logica.ControladoraHotel;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.TipoHabitacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ciberella
 */
@WebServlet(name = "ServAltaReservaHuespedExistente", urlPatterns = {"/ServAltaReservaHuespedExistente"})
public class ServAltaReservaHuespedExistente extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
         //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();
        
       //traemos lo que se ingreso desde el formulario como string 
       //las fechas de ingreso y egreso
        String str_fecha_ingreso = request.getParameter("fecha_ingreso");
        String str_fecha_egreso = request.getParameter("fecha_egreso");

        //datos para el tipo de habitacion mas adecuado segun la necidad del huesped
        String str_cant_personas = request.getParameter("cant_personas");
        int cant_personas = Integer.parseInt(str_cant_personas);

        //datos del huesped para encontrar luego la id
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        
        //datos del vendedor/usuario que realizo la reserva
        String str_id_usuario = request.getParameter("id_usuario");

        //la habitacion
        String str_nro_habitacion = request.getParameter("nro_habitacion");
        int nro_habitacion = Integer.parseInt(str_nro_habitacion);

        
        //convertimos al tipo que corresponde para poder guardarlo en la DB
        //double precio = Double.parseDouble(str_precio);
        int id_usuario = Integer.parseInt(str_id_usuario);
        Date fecha_ingreso = control.deStringToDate(str_fecha_ingreso);
        Date fecha_egreso = control.deStringToDate(str_fecha_egreso);

        //la fecha del alta de la reserva
        Date fecha_alta = new Date();
   
        //traemos de la sesion todos los datos ingresados y los seteamos
        request.getSession().setAttribute("fecha_ingreso", fecha_ingreso);
        request.getSession().setAttribute("fecha_egreso", fecha_egreso);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("id_usuario", id_usuario);
        request.getSession().setAttribute("nro_habitacion", nro_habitacion);
        request.setAttribute("cant_personas", cant_personas);
        
        Habitacion habitacion = control.traerHabitacionPorId(nro_habitacion);
        Empleado empleado = control.traerEmpleadoPorID(id_usuario);
      
       
        //enviamos todos estos parametros  desde el servlet,para crear nueva reserva,
        //para eso crear un objeto de la clase Controladora en este servlet
        control.crearReservaHuespedExistente(fecha_alta, fecha_ingreso, fecha_egreso, apellido, dni, empleado, habitacion, cant_personas);
         

        //redirije 
        response.sendRedirect("exito.jsp");
        
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
