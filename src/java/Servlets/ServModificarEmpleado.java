package Servlets;

import Logica.ControladoraHotel;
import Logica.Empleado;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServModificarEmpleado", urlPatterns = {"/ServModificarEmpleado"})
public class ServModificarEmpleado extends HttpServlet {
    
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
        int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
        String nombre = request.getParameter("nombre").toLowerCase();
        String apellido = request.getParameter("apellido").toLowerCase();
        String dni = request.getParameter("dni").toLowerCase();
        String str_fecha_nac = request.getParameter("fecha_nac");
        String cargo = request.getParameter("cargo").toLowerCase();
        String direccion = request.getParameter("direccion").toLowerCase();
        
        String nombre_usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        

        //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();

        //convertimos al tipo que corresponde para poder guardarlo en la DB
        Date fecha_nac = control.deStringToDate(str_fecha_nac);

        //traemos al empleado
        Empleado empleado = control.traerEmpleadoPorID(id_empleado);
        Usuario usuario = control.traerUsuarioPorId(empleado.getUsuario().getId_usuario());

        //seteamos al objeto empleado y usuario con cada uno de los parametros que recibimos
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setFecha_nac(fecha_nac);
        empleado.setCargo(cargo);
        empleado.setDireccion(direccion);
        
        usuario.setNombre_usuario(nombre_usuario);
        usuario.setContrasenia(contrasenia);

        
        //modificamos
        control.modificarEmpleado(empleado);
        control.modificarUsuario(usuario);

        //actualiza y redirije a la tabla de modificar y borrar para ver los cambios
        request.getSession().setAttribute("lista_empleados", control.traerEmpleado());
        response.sendRedirect("borrar-modificar-empleado.jsp");
        
    }

    //recoge el id del empleado para enviarlo al jsp  del formualario
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        ControladoraHotel control = new ControladoraHotel();

        //trae parametros  y la convierto al tipo correspondiente
        int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));

        //traigo al huesped/objeto  buscado
        Empleado empleado = control.traerEmpleadoPorID(id_empleado);

        //traemos la sesion con la que estamos trabajando
        HttpSession misesion = request.getSession();

        //a la sesion le agregamos el atributo
        misesion.setAttribute("empleado", empleado);

        //luego redirije desde este servlet hacia el JSP que tiene el formulario para editar al empleado
        response.sendRedirect("form-modificar-empleado.jsp");
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
