
package Servlets;

import Logica.ControladoraHotel;
import Logica.Empleado;

//librerias
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServConsultaEmpleado", urlPatterns = {"/ServConsultaEmpleado"})
public class ServConsultaEmpleado extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //llamamos a la controladora
        ControladoraHotel control = new ControladoraHotel();
        
        //
        List <Empleado> listaEmpleados = control.traerEmpleado();
        
        HttpSession miSesion = request.getSession();
        

        if(listaEmpleados.isEmpty()){
            String mensaje = "No existen empleados registrados";
            miSesion.setAttribute("mensaje", mensaje);
            response.sendRedirect("respuesta-inexistente.jsp");
        }else {
            miSesion.setAttribute("listaEmpleados",listaEmpleados);
        response.sendRedirect("ver-tabla-empleados.jsp");
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
