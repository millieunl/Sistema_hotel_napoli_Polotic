package Servlets;

import Logica.ControladoraHotel;
import Logica.Huesped;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServModificarHuesped", urlPatterns = {"/ServModificarHuesped"})
public class ServModificarHuesped extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        //para el formulario de modificar
        //traemos de la IGU los parametros que establecimos en los input y los guarda en variables auxiliares
        int id_huesped = Integer.parseInt(request.getParameter("id_huesped"));
        String nombre = request.getParameter("nombre").toLowerCase();
        String apellido = request.getParameter("apellido").toLowerCase();
        String dni = request.getParameter("dni").toLowerCase();
        String str_fecha_nac = request.getParameter("fecha_nac");
        String profesion = request.getParameter("profesion").toLowerCase();
        String direccion = request.getParameter("direccion").toLowerCase();

        //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();

        
        //convertimos al tipo que corresponde para poder guardarlo en la DB
        Date fecha_nac = control.deStringToDate(str_fecha_nac);
        
         //traemos al huesped
        Huesped huesped = control.traerHuespedPorID(id_huesped);
        
        //seteamos al objeto huesped con cada uno de los parametros que recibimos
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setDni(dni);
        huesped.setFecha_nac(fecha_nac);
        huesped.setProfesion(profesion);
        huesped.setDireccion(direccion);
      

        /*
        //actualiza y redirije a la tabla de modificar y borrar
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("fecha_nac", fecha_nac);
        request.getSession().setAttribute("profesion", profesion);
        request.getSession().setAttribute("direccion", direccion);
*/


        //modificamos la habitacion
        control.modificarHuesped(huesped);

        //actualiza y redirije a la tabla de modificar y borrar
        request.getSession().setAttribute("lista_huespedes", control.traerHuesped());
        response.sendRedirect("borrar-modificar-huesped.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        ControladoraHotel control = new ControladoraHotel();

        //trae parametros  y la convierto al tipo correspondiente
        int id_huesped = Integer.parseInt(request.getParameter("id_huesped"));

        //traigo al huesped/objeto  buscado
        Huesped huesped = control.traerHuespedPorID(id_huesped);

        //traemos la sesion con la que estamos trabajando
        HttpSession misesion = request.getSession();

        //a la sesion le agregamos el atributo huesped
        misesion.setAttribute("huesped", huesped);

        //luego redirije desde este servlet hacia el JSP qu etiene el formulario para editar al huesped
        response.sendRedirect("form-modificar-huesped.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
