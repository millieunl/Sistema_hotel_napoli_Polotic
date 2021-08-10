package Servlets;



import Logica.ControladoraHotel;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;

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


@WebServlet(urlPatterns = {"/ServModificarReserva"})
public class ServModificarReserva extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         ControladoraHotel control = new ControladoraHotel();

        //trae parametros  y la convierto al tipo correspondiente
        int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
       
      
        //PARA OBTENER LAS FECHAS A CONSULTAR
        //traemos las fechas que se ingresaron desde el formulario como string 
        String str_fecha_averiguar_inicio = request.getParameter("fecha_ingreso"); //desde
        String str_fecha_averiguar_fin = request.getParameter("fecha_egreso"); //hasta

        //convertimos al tipo DATE para poder compararlas con las de la DB
        Date fecha_averiguar_inicio = control.deStringToDate(str_fecha_averiguar_inicio);
        Date fecha_averiguar_fin = control.deStringToDate(str_fecha_averiguar_fin);


        //datos para el tipo de habitacion mas adecuado segun la necesidad del huesped
        String str_cant_personas = request.getParameter("cant_personas");
        int cant_personas = Integer.parseInt(str_cant_personas);
        
        Reserva reserva = control.traerReservaPorID(id_reserva);
       
        //traigo huesped y habitacion que tenia seleccionada 
        Huesped huesped = control.dameHuepedReserva(reserva);
        Habitacion habitacion_vieja = control.dameHabitacionReserva(reserva);
        
        
        //traemos las habitaciones disponibles segun las fechas dadas y la cargamos en esta lista
        List <Habitacion> lista_hab_disponible = control.traerHabitacionDisponible(fecha_averiguar_inicio, fecha_averiguar_fin,cant_personas);
      
        HttpSession miSesion = request.getSession();

        
        //verificacion si la lista no esta vacia
        if(lista_hab_disponible == null || lista_hab_disponible.isEmpty()){
            //si no hay habitaciones disponibles muestra mensaje de que no hay habitaciones
            response.sendRedirect("respuesta-no-disponible.jsp");
        }
        else {
            //setea los atributos nuevos y  redirige al formulario 2
            miSesion.setAttribute("lista_hab_disponible", lista_hab_disponible);
            miSesion.setAttribute("fecha_ingreso", str_fecha_averiguar_inicio);
            miSesion.setAttribute("fecha_egreso", str_fecha_averiguar_fin);
            miSesion.setAttribute("cant_personas", cant_personas);
            miSesion.setAttribute("id_reserva", id_reserva);
            miSesion.setAttribute("huesped", huesped);
            miSesion.setAttribute("reserva", reserva);
            miSesion.setAttribute("habitacion_vieja", habitacion_vieja);
            response.sendRedirect("form-modificar-reserva-2.jsp");
        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        ControladoraHotel control = new ControladoraHotel();
        
        //trae parametros  y la convierto al tipo correspondiente
        int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));
        
        //traigo a la habitacion/objeto  buscado
        Reserva reserva= control.traerReservaPorID(id_reserva);
        
        
        //traemos la sesion con la que estamos trabajando
        HttpSession misesion = request.getSession();
        
        //a la sesion le agregamos el atributo reserva
        misesion.setAttribute("reserva", reserva);

        
        //luego redirije desde este servlet hacia el JSP qu etiene el formulario para editar la reserva
        response.sendRedirect("form-modificar-reserva.jsp");

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
