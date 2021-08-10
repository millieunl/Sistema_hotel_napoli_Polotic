
package Servlets;

import Logica.ControladoraHotel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServBorrarEmpleado", urlPatterns = {"/ServBorrarEmpleado"})
public class ServBorrarEmpleado extends HttpServlet {

   
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
        int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
        
        
        
        //llama a la controladora para que invoque el metodo de borrar de la pesistencia
        control.borrarEmpleado(id_empleado);
        
        //traemos la sesion con la que estamos trabajando
        HttpSession miSesion = request.getSession();
        
        //actualiza la lista  y la redirije, asi podemos ver los cambios
        miSesion.setAttribute("lista_empleados", control.traerEmpleado());

        //respuesta del servlet la redirije para que pueda verlo en la igu
        response.sendRedirect("borrar-modificar-empleado.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
