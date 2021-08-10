
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


@WebServlet(name = "ServConsultaReservaDia", urlPatterns = {"/ServConsultaReservaDia"})
public class ServConsultaReservaDia extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        ControladoraHotel control = new ControladoraHotel();
        
        //traigo la lista de reservas por dia de la controladora
        List <Reserva> lista_reserva = control.traerReservaDeHoy();
         
        //si hay resultados en  la lista , configura los atributos y redirije a la vista con la lista de reservas
        if (!lista_reserva.isEmpty() || lista_reserva != null ) {
            HttpSession miSesion = request.getSession();
            miSesion.setAttribute("lista_reserva", lista_reserva);
            response.sendRedirect("informe-reservas-hoy.jsp");
            
            
        } else {
            //**********************
            //PONER UNA VENTANA QUE DIGA QUE NO HAY RESERVAS EN EL DIA DE HOYY AHORA MUESTRA ERROR, pero no es un error
            //****************************
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
