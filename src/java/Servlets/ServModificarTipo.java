package Servlets;

import Logica.ControladoraHotel;
import Logica.TipoHabitacion;
import static com.sun.org.apache.xerces.internal.impl.dtd.XMLDTDLoader.LOCALE;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServModificarTipo", urlPatterns = {"/ServModificarTipo"})
public class ServModificarTipo extends HttpServlet {

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
        int id_tipo = Integer.parseInt(request.getParameter("id_tipo"));
        String nombre_tipo = request.getParameter("nombre_tipo").toLowerCase();
        int cant_personas = Integer.parseInt(request.getParameter("cant_personas"));
       
        Double precio_noche = Double.valueOf(request.getParameter("precio_noche"));
     

        //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();

        //traemos al objeto tipo que se desea modificar
        TipoHabitacion tipo = control.traerTipoPorID(id_tipo);
        
        //seteamos al objeto tipo de habitacion con cada uno de los parametros que recibimos
        tipo.setCantidad_limite(cant_personas);
        tipo.setTipo(nombre_tipo);
        tipo.setPrecio_noche(precio_noche);
        
        //modificamos el tipo
        control.modificarTipoHabitacion(tipo);
        
        //actualiza y redirije a la tabla  para ver los cambios
        request.getSession().setAttribute("lista_tipo", control.traerTipo());
        response.sendRedirect("consultar-modificar-tipo.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        ControladoraHotel control = new ControladoraHotel();

        //trae parametros  y la convierto al tipo correspondiente
        int id_tipo = Integer.parseInt(request.getParameter("id_tipo"));

        //traigo al tipo de habitacion/objeto  buscado
        TipoHabitacion tipo = control.traerTipoPorID(id_tipo);

        //traemos la sesion con la que estamos trabajando
        HttpSession misesion = request.getSession();

        //a la sesion le agregamos el atributo tipo 
        misesion.setAttribute("tipo", tipo);

        //luego redirije desde este servlet hacia el JSP que tiene el formulario para editar el tipo
        response.sendRedirect("form-modificar-tipo.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
