
package Servlets;

import Logica.ControladoraHotel;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServConsultaHuepedReserva", urlPatterns = {"/ServConsultaHuepedReserva"})
public class ServConsultaHuepedReserva extends HttpServlet {

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


        //traemos LA ID desde el formulario como string 
        String str_id_huesped = request.getParameter("id_huesped");
        
        // traemos LAS FECHAS A CONSULTAR
        //traemos las fechas que se ingresaron desde el formulario como string 
        String str_fecha_averiguar_inicio = request.getParameter("fecha_inicio"); //desde
        String str_fecha_averiguar_fin = request.getParameter("fecha_fin"); //hasta

       
        //convertimos  las variables al tipo que corresponde para poder consultarlo en la DB
        int id_huesped = Integer.parseInt(str_id_huesped);
        Date fecha_averiguar_inicio = control.deStringToDate(str_fecha_averiguar_inicio);
        Date fecha_averiguar_fin = control.deStringToDate(str_fecha_averiguar_fin);

        
        HttpSession miSesion = request.getSession();
        
        //traemos la sesion y le asignamos los atributos
        request.getSession().setAttribute("id_huesped", id_huesped);
        request.getSession().setAttribute("fecha_inicio", fecha_averiguar_inicio);
        request.getSession().setAttribute("fecha_fin", fecha_averiguar_fin);
       
        
        //traemos el objeto huesped con la id indicada
        Huesped huesped = control.traerHuespedPorID(id_huesped);
        
        
        //si el huesped existe
        if (huesped != null) {
            try {
                List<Reserva> lista_reserva_huesped = control.traerReservaHuespedPorFecha(fecha_averiguar_inicio, fecha_averiguar_fin, huesped.getLista_reservas());
                List<Habitacion> lista_habitacion = control.traerHabitacion();
                
                if(!lista_reserva_huesped.isEmpty() || lista_reserva_huesped != null){
                    miSesion.setAttribute("objeto_huesped", huesped);
                    miSesion.setAttribute("lista_reserva_huesped", lista_reserva_huesped);
                    miSesion.setAttribute("lista_habitacion", lista_habitacion);
                    miSesion.setAttribute("fecha_ingreso", str_fecha_averiguar_inicio);
                    miSesion.setAttribute("fecha_egreso", str_fecha_averiguar_fin);
                    response.sendRedirect("informe-reservas-xhuesped_1.jsp");
                    
                }else {
                    String mensaje = "Este huesped no realizo ninguna reserva en esas fechas";
                    miSesion.setAttribute("mensaje", mensaje);
                    response.sendRedirect("respuesta-inexistente.jsp");
                }
            } catch (IOException e) {
                response.sendRedirect("error.jsp");
            }

        } else {
            String mensaje = "Este huesped no existe en el sistema";
            miSesion.setAttribute("mensaje", mensaje);
            response.sendRedirect("respuesta-inexistente.jsp");
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
