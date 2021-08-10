
package Servlets;

import Logica.ControladoraHotel;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServModificarReserva2", urlPatterns = {"/ServModificarReserva2"})
public class ServModificarReserva2 extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();
        
        
        //para el formulario de modificar
        //traemos de la IGU los parametros que establecimos en los input y los guarda en variables auxiliares
        String nombre = request.getParameter("nombre").toLowerCase();
        String apellido = request.getParameter("apellido").toLowerCase();
        String dni = request.getParameter("dni").toLowerCase();
        String str_fecha_nac = request.getParameter("fecha_nac");
        String profesion = request.getParameter("profesion").toLowerCase();
        String direccion = request.getParameter("direccion").toLowerCase();
        Date fecha_nac = control.deStringToDate(str_fecha_nac);
        

         //los datos de la reserva
        String str_fecha_ingreso = request.getParameter("fecha_ingreso"); 
        String str_fecha_egreso = request.getParameter("fecha_egreso"); 
        Date fecha_ingreso = control.deStringToDate(str_fecha_ingreso);
        Date fecha_egreso = control.deStringToDate(str_fecha_egreso);
        int cant_personas = Integer.parseInt(request.getParameter("cant_personas"));  //agregarlo despues en la DB para reservas
        
        
        //trae parametros las IDs  y la convierto al tipo correspondiente
        int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
        
        int id_huesped = Integer.parseInt(request.getParameter("id_huesped"));
        
        int nro_habitacion_vieja = Integer.parseInt(request.getParameter("nro_habitacion_vieja"));
        int nro_habitacion_nueva = Integer.parseInt(request.getParameter("nro_habitacion_nueva"));
        
       
        //traemos al huesped, reserva, habitacion
        Huesped huesped = control.traerHuespedPorID(id_huesped);
        
        
        Reserva reserva = control.traerReservaPorID(id_reserva);
        //Huesped huesped = control.dameHuepedReserva(reserva);
        Habitacion habitacion_vieja = control.traerHabitacionPorId(nro_habitacion_vieja);
        Habitacion habitacion_nueva = control.traerHabitacionPorId(nro_habitacion_nueva);
       

        //seteamos al objeto huesped con cada uno de los parametros que recibimos
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setDni(dni);
        huesped.setFecha_nac(fecha_nac);
        huesped.setProfesion(profesion);
        huesped.setDireccion(direccion);
       
       reserva.setFecha_ingreso(fecha_ingreso);
       reserva.setFecha_egreso(fecha_egreso);
       reserva.setCant_personas(cant_personas);
       

       control.modificarReservaCompleta(reserva, habitacion_nueva, habitacion_vieja, huesped );
    

        //actualiza y redirije a la tabla de modificar y borrar para ver los cambios
        request.getSession().setAttribute("lista_reserva", control.traerReserva());
        request.getSession().setAttribute("lista_huesped", control.traerHuesped());
        request.getSession().setAttribute("lista_habitacion", control.traerHabitacion());
        response.sendRedirect("borrar-modificar-reserva.jsp");
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
