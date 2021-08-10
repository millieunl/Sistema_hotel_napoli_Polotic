package Servlets;

import Logica.ControladoraHotel;
import Logica.Empleado;
import Logica.Habitacion;
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

@WebServlet(name = "ServConsultaEmpleadoReserva", urlPatterns = {"/ServConsultaEmpleadoReserva"})
public class ServConsultaEmpleadoReserva extends HttpServlet {

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

        //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();

        //VARIABLES AUXILIARES
        //traemos lo que se ingreso desde el formulario como string 
        String str_id_empleado = request.getParameter("id_empleado");
        String str_fecha_averiguar_inicio = request.getParameter("fecha_ingreso"); //desde
        String str_fecha_averiguar_fin = request.getParameter("fecha_egreso"); //hasta

        //convertimos al tipo que corresponde para poder comprara con la DB
        int id_empleado = Integer.parseInt(str_id_empleado);
        Date fecha_averiguar_inicio = control.deStringToDate(str_fecha_averiguar_inicio);
        Date fecha_averiguar_fin = control.deStringToDate(str_fecha_averiguar_fin);

        //traemos la sesion y le seteamos los atributos 
        request.getSession().setAttribute("id_empleado", id_empleado);
        request.getSession().setAttribute("fecha_ingreso", fecha_averiguar_inicio);
        request.getSession().setAttribute("fecha_egreso", fecha_averiguar_fin);

        HttpSession miSesion = request.getSession();

        //traigo al empleado con la id
        Empleado empleado = control.traerEmpleadoPorID(id_empleado);

        //si existe el empleado con esa ID
        if (empleado != null) {
            //guarda una listra de reservas filtradas xfecha
            List<Reserva> lista_reserva_empleado = control.traerReservaEmpleadoPorFecha(fecha_averiguar_inicio, fecha_averiguar_fin, empleado.getLista_reservas());
            List<Habitacion> lista_habitacion = control.traerHabitacion();
            try {
                //si hay resultados en  la lista , configura los atributos y redirije a la vista con la lista de reservas del empleado
                if (!lista_reserva_empleado.isEmpty() || lista_reserva_empleado != null) {
                    miSesion.setAttribute("objeto_empleado", empleado);
                    miSesion.setAttribute("lista_reserva_empleado", lista_reserva_empleado);
                    miSesion.setAttribute("lista_habitacion", lista_habitacion);
                    miSesion.setAttribute("fecha_ingreso", str_fecha_averiguar_inicio);
                    miSesion.setAttribute("fecha_egreso", str_fecha_averiguar_fin);
                    response.sendRedirect("informe-reservas-xempleado_1.jsp");
                } else {
                    String mensaje = "Este empleado no realizo ninguna reserva en esas fechas";
                    miSesion.setAttribute("mensaje", mensaje);
                    response.sendRedirect("respuesta-inexistente.jsp");
                }
            } catch (IOException e) {
                response.sendRedirect("error.jsp");
            }
        } else {
            String mensaje = "Este empleado no existe en el sistema";
            miSesion.setAttribute("mensaje", mensaje);
            response.sendRedirect("respuesta-inexistente.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
