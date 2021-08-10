
package Servlets;

import Logica.ControladoraHotel;
import Logica.Habitacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServModificarHabitacion", urlPatterns = {"/ServModificarHabitacion"})
public class ServModificarHabitacion extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        //traemos de la IGU los parametros que establecimos en los input y los guarda en variables auxiliares
        String nombre_habitacion = request.getParameter("nombre_habitacion").toLowerCase();
        int nro_piso = Integer.parseInt(request.getParameter("nro_piso"));
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        int nro_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
        //boolean esta_reservada = false;
        
        //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();
        
        //traemos a la habitacion
        Habitacion habitacion = control.traerHabitacionPorId(nro_habitacion);

        //setea los atributos
        habitacion.setNombre_habitacion(nombre_habitacion);
        habitacion.setNroPiso(nro_piso);
        habitacion.setTipo_habitacion(control.traerTipoPorID(tipo));

        //modificamos la habitacion
        control.modificarHabitacion(habitacion);
         
        //actualiza y redirije a la tabla de modificar y borrar
        request.getSession().setAttribute("lista_habitacion", control.traerHabitacion());
        response.sendRedirect("borrar-modificar-habitacion.jsp");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        ControladoraHotel control = new ControladoraHotel();
        
        //trae parametros  y la convierto al tipo correspondiente
        int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
        
        //traigo a la habitacion/objeto  buscado
        Habitacion habitacion = control.traerHabitacionPorId(id_habitacion);
        
        //traemos la sesion con la que estamos trabajando
        HttpSession misesion = request.getSession();
        
        //a la sesion le agregamos el atributo habitacion y el los tipos de habitacion,
        misesion.setAttribute("habitacion", habitacion);
        misesion.setAttribute("lista_tipo", control.traerTipo());
        
        //luego redirije desde este servlet hacia el JSP qu etiene el formulario para editar la habitacion
        response.sendRedirect("form-modificar-habitacion.jsp");
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
