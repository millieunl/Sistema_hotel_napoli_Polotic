
package Servlets;

import Logica.ControladoraHotel;
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

/**
 *
 * @author ciberella
 */
@WebServlet(name = "ServConsultaReservaXfecha", urlPatterns = {"/ServConsultaReservaXfecha"})
public class ServConsultaReservaXfecha extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

        //traemos la sesion y configuramos los atributos para enviar a la consulta
        request.getSession().setAttribute("fecha_ingreso", fecha_averiguar_inicio);
        request.getSession().setAttribute("fecha_egreso", fecha_averiguar_fin);
       
        //PARA  MOSTRAR LOS RESULTADOS
        //creamos una lista donde se cargaran las habitaciones disponibles segun las fechas dadas
        List <Reserva> lista_reserva = control.traerReservaPorFecha(fecha_averiguar_inicio, fecha_averiguar_fin);
      
        HttpSession miSesion = request.getSession();
       
        //verificacion
        if(lista_reserva == null || lista_reserva.isEmpty()){
            //response.sendRedirect("respuesta-no-disponible.jsp");
            String mensaje = "Todavia no existen usuarios en la DB";
            miSesion.setAttribute("mensaje", mensaje);
            response.sendRedirect("respuesta-inexistente.jsp");
        }
        else {
            //seteamos los atributos para reenviar al front
            miSesion.setAttribute("lista_reserva", lista_reserva);
            miSesion.setAttribute("fecha_ingreso", str_fecha_averiguar_inicio);
            miSesion.setAttribute("fecha_egreso", str_fecha_averiguar_fin);
            response.sendRedirect("informe-reservas-xfecha_1.jsp");
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
