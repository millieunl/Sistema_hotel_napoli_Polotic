package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logica.ControladoraHotel;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.TipoHabitacion;
import Logica.Usuario;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServAltaReservaHuespedNuevo", urlPatterns = {"/ServAltaReservaHuespedNuevo"})
public class ServAltaReservaHuespedNuevo extends HttpServlet {

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

        //datos del huesped
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");

        String str_fecha_nac = request.getParameter("fecha_nac");
        String profesion = request.getParameter("profesion");
        String direccion = request.getParameter("direccion");

        //datos del empleado que realizo la reserva
        String str_id_usuario = request.getParameter("id_usuario");

        //la habitacion
        String str_nro_habitacion = request.getParameter("nro_habitacion");
        int nro_habitacion = Integer.parseInt(str_nro_habitacion);

        //convertimos al tipo que corresponde para poder guardarlo en la DB
        //double precio = Double.parseDouble(str_precio);
        int id_usuario = Integer.parseInt(str_id_usuario);
        Date fecha_ingreso = control.deStringToDate(str_fecha_ingreso);
        Date fecha_egreso = control.deStringToDate(str_fecha_egreso);
        Date fecha_nac = control.deStringToDate(str_fecha_nac);

        //la fecha del alta de la reserva
        Date fecha_alta = new Date();
       
        
        //traemos de la sesion todos los datos ingresados
        request.getSession().setAttribute("fecha_ingreso", fecha_ingreso);
        request.getSession().setAttribute("fecha_egreso", fecha_egreso);
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("fecha_nac", fecha_nac);
        request.getSession().setAttribute("profesion", profesion);
        request.getSession().setAttribute("direccion", direccion);
        request.getSession().setAttribute("id_usuario", id_usuario);
        request.getSession().setAttribute("nro_habitacion", nro_habitacion);
        request.setAttribute("cant_personas", cant_personas);

        Habitacion habitacion = control.traerHabitacionPorId(nro_habitacion);
        Empleado empleado = control.traerEmpleadoPorID(id_usuario);
        
        try {
        //enviamos todos estos parametros  desde el servlet,para crear nueva reserva,
        //para eso crear un objeto de la clase Controladora en este servlet
        control.crearReservaHuespedNuevo(fecha_alta, fecha_ingreso, fecha_egreso, nombre, apellido, dni, fecha_nac, profesion, direccion, empleado, habitacion, cant_personas);
        //redirije 
        
        response.sendRedirect("exito.jsp");
        } catch (IOException e) {
            response.sendRedirect("error.jsp");
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
