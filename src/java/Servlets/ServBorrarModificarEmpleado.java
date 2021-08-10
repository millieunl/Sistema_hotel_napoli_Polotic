
package Servlets;

import Logica.ControladoraHotel;
import Logica.Empleado;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServBorrarModificarEmpleado", urlPatterns = {"/ServBorrarModificarEmpleado"})
public class ServBorrarModificarEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         ControladoraHotel control = new ControladoraHotel();
        
        List <Empleado> lista_empleados = control.traerEmpleado();
        HttpSession miSesion = request.getSession();
        
         if(lista_empleados == null || lista_empleados.isEmpty() ){
            response.sendRedirect("error.jsp");
        }
        else {
            // actualiza la lista
            miSesion.setAttribute("lista_empleados", lista_empleados);
            response.sendRedirect("borrar-modificar-empleado.jsp");
        }
    }

    


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
