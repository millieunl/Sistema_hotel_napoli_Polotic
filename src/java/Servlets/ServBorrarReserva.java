
package Servlets;

import Logica.ControladoraHotel;
import Logica.Huesped;
import Logica.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServBorrarReserva", urlPatterns = {"/ServBorrarReserva"})
public class ServBorrarReserva extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        ControladoraHotel control = new ControladoraHotel();
        
        //trae parametros  y la convierto al tipo correspondiente
        int id_reserva = Integer.parseInt(request.getParameter("id_reserva"));

        //traemos y guardamos en un objeto del tipo reserva, la reserva que tiene el id buscado
        Reserva reserva= control.traerReservaPorID(id_reserva);
        

       //buscamos entre los huespedes el que tiene la reserva elegida
       //1-traemos todos los huespedes y lo guardamos en una lista
       //2-se crea una instancia nueva de huesped antes de empezar el for
       //3-recorremos  tda la lista de huespedes y  luego recorremos
       //4-la lista de reservas que tiene cada instancia de ese huesped
       //5 se le asigna al objeto creado del tipo huesped, el huesped que tiene el numero de reserva buscado
        List<Huesped> lista_huesped = control.traerHuesped();
        Huesped huesped = new Huesped();
        for (Huesped hues : lista_huesped) {
            for (Reserva res : hues.getLista_reservas()) {
                if (res.getNro_reserva() == reserva.getNro_reserva()) {
                    huesped = hues;
                }
            }
        }


        //llama a la controladora para que invoque el metodo de borrar de la pesistencia no esta funcionando no vorra todo
        //control.borrarReserva(id_reserva);
        
        reserva.setEsta_activa(false);
        //traemos la sesion con la que estamos trabajando
        //HttpSession miSesion = request.getSession();
        
        //actualiza la lista  y la redirije, asi podemos ver los cambios
        //miSesion.setAttribute("lista_reserva", control.traerReserva());
        //miSesion.setAttribute("huesped",huesped);

        //respuesta del servlet la redirije para que pueda verlo en la igu
        response.sendRedirect("borrar-modificar-reserva.jsp");
        

        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
