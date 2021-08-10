package Servlets;

//
import Logica.ControladoraHotel;
import Logica.Usuario;

//librerias
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

@WebServlet(name = "ServLogin", urlPatterns = {"/ServLogin"})
public class ServLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //variables auxiliares
        String usuario_sesion = request.getParameter("usuario_sesion");
        String contrasenia = request.getParameter("contrasenia");

        //creamos la controaldora para conectar al servlet con la logica
        ControladoraHotel control = new ControladoraHotel();

        //creamos variable booleana para la autorizacion de entrada al sistema
        //llama a un metodo de la logica para verificar que el usuario y contraseña
        //que trajimos de la interfaz grafica coincide con lo que tenemos guardado en la DB
        boolean estaAutorizado = control.verificarUsuario(usuario_sesion, contrasenia);

 

        /*
        String nombre = "maria";
        String apellido = "corb";
        String dni = "11111";
        String sfecha_nac = "29-09-1983";
        Date fecha_nac = control.deStringToDate(sfecha_nac);
        String cargo = "administradroa de sistemas";
        String direccion = "las lavandas 123";
        String usuario_admin = "admin";
        String contrasenia_admin = "admin";

        control.crearEmpleadoUsuario(nombre, apellido, dni, fecha_nac, cargo, direccion, usuario_admin, contrasenia_admin);

*/
        
        //Si esta estautorizado (si es verdadero)
        if (estaAutorizado) {
            //traemos la sesion
            HttpSession miSesion = request.getSession(true);
            //seteamos los atributos para ser usados en todos  los jsp hasta que cerremos sesion
            miSesion.setAttribute("usuario_sesion", usuario_sesion);
            miSesion.setAttribute("contrasenia", contrasenia);
           

            //realiza la respuesta redireccionando a la pagina principal del sistema
            response.sendRedirect("index.jsp");

        } else {
            //sino esta autorizado redireccionamos al login de nuevo
            response.sendRedirect("login.jsp");
        }
    

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
    }

   
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
