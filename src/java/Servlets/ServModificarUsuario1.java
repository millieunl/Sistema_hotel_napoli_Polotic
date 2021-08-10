
package Servlets;

import Logica.ControladoraHotel;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServModificarUsuario1", urlPatterns = {"/ServModificarUsuario1"})
public class ServModificarUsuario1 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //trae parametros  y la convierto al tipo correspondiente
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        String nombre_usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("contrasenia");
        
        //Creamos un objeto  controladora para luego manejar la logica
        ControladoraHotel control = new ControladoraHotel();

        //traemos al usuario indicado en el formulario
        Usuario usuario = control.traerUsuarioPorId(id_usuario);
  
        //seteamos al objeto usuario con cada uno de los parametros que recibimos
        usuario.setNombre_usuario(nombre_usuario);
        usuario.setContrasenia(contrasenia);

 
        //modificamos
        control.modificarUsuario(usuario);


        //actualiza y redirije a la tabla de modificar y borrar para ver los cambios
        request.getSession().setAttribute("lista_usuario",control.traerUsuario());
        response.sendRedirect("modificar-usuario.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        ControladoraHotel control = new ControladoraHotel();

        //trae parametros  y la convierto al tipo correspondiente
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));

        //traigo al huesped/objeto  buscado
        Usuario usuario = control.traerUsuarioPorId(id_usuario);

        //traemos la sesion con la que estamos trabajando
        HttpSession misesion = request.getSession();

        //a la sesion le agregamos el atributo 
        misesion.setAttribute("usuario", usuario);

        //luego redirije desde este servlet hacia el JSP que tiene el formulario para editar al usuario
        response.sendRedirect("form-modificar-usuario.jsp");
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
