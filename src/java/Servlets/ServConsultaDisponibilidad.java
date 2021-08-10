
package Servlets;

import Logica.ControladoraHotel;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
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


@WebServlet(name = "ServConsultaDisponibilidad", urlPatterns = {"/ServConsultaDisponibilidad"})
public class ServConsultaDisponibilidad extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
       
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
        
        ControladoraHotel control = new ControladoraHotel();
       
        
        //PARA OBTENER LAS FECHAS A CONSULTAR
        //traemos las fechas que se ingresaron desde el formulario como string 
        String str_fecha_averiguar_inicio = request.getParameter("fecha_ingreso"); //desde
        String str_fecha_averiguar_fin = request.getParameter("fecha_egreso"); //hasta

        //convertimos al tipo DATE para poder compararlas con las de la DB
        Date fecha_averiguar_inicio = control.deStringToDate(str_fecha_averiguar_inicio);
        Date fecha_averiguar_fin = control.deStringToDate(str_fecha_averiguar_fin);


        //datos para el tipo de habitacion mas adecuado segun la necidad del huesped
        String str_cant_personas = request.getParameter("cant_personas");
        int cant_personas = Integer.parseInt(str_cant_personas);
     
        
        //traemos la sesion y configuramos los atributos
        request.getSession().setAttribute("fecha_ingreso", fecha_averiguar_inicio);
        request.getSession().setAttribute("fecha_egreso", fecha_averiguar_fin);
        request.getSession().setAttribute("cant_personas", cant_personas);
        
        System.out.println(" DATOS QUE LLEGAN a la disponibilidad RESERVA1");
         System.out.println( cant_personas +" " + fecha_averiguar_inicio + fecha_averiguar_fin);
         
        
        //PARA  MOSTRAR LOS RESULTADOS
        //creamos una lista donde se cargaran las habitaciones disponibles segun las fechas dadas
        List <Habitacion> lista_hab_disponible = control.traerHabitacionDisponible(fecha_averiguar_inicio, fecha_averiguar_fin,cant_personas);
      
        System.out.println(" DATOS QUE LLEGAN a la disponibilidad RESERVA");
         System.out.println( cant_personas +" " + fecha_averiguar_inicio);
          
          
           System.out.println(lista_hab_disponible.isEmpty());
          
        HttpSession miSesion = request.getSession();
   
        //verificacion si la lista no esta vacia
        if (lista_hab_disponible == null || lista_hab_disponible.isEmpty()) {
            response.sendRedirect("respuesta-no-disponible.jsp");
        } else {
            miSesion.setAttribute("lista_hab_disponible", lista_hab_disponible);
            miSesion.setAttribute("fecha_ingreso", str_fecha_averiguar_inicio);
            miSesion.setAttribute("fecha_egreso", str_fecha_averiguar_fin);
            miSesion.setAttribute("cant_personas", cant_personas);
            response.sendRedirect("form-intermedio-crear-reserva.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
