package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.TipoHabitacion;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    //instanciamos objetos de cada clase entidad para poder controlarlas
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    HuespedJpaController huespedJPA = new HuespedJpaController();
    HabitacionJpaController habitacionJPA = new HabitacionJpaController();
    TipoHabitacionJpaController tipoHabitacionJPA = new TipoHabitacionJpaController();
    ReservaJpaController reservaJPA = new ReservaJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();

    /* ALTAS */
    //metodo para crear reserva
    public void crearReserva(Reserva reserva) {
        try {
            reservaJPA.create(reserva);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //metodo para crear huesped
    public void crearHuesped(Huesped huesped) {
        try {
            huespedJPA.create(huesped);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //metodo para crear huesped
    public void crearEmpleado(Empleado empleado) {
        try {
            empleadoJPA.create(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //metodo para crear huesped
    public void crearEmpleadoUsuario(Empleado empleado) {
        try {
            empleadoJPA.create(empleado);

        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //metodo para crear usuario
    public void crearUsuario(Usuario user) {
        try {
            usuarioJPA.create(user);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //metodo para crear tipo de habitaciones
    public void crearTipoHabitacion(TipoHabitacion tipoh) {
        try {
            tipoHabitacionJPA.create(tipoh);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearHabitacion(Habitacion habitacion) {
        try {
            habitacionJPA.create(habitacion);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // este metodo devuelve una lista con todos los componentes de la tabla usuarios
    public List<Usuario> traerUsuario() {
        return usuarioJPA.findUsuarioEntities();
    }

    // este metodo devuelve una lista con todos los componentes de la tabla usuarios
    public List<Empleado> traerEmpleado() {
        return empleadoJPA.findEmpleadoEntities();
    }

    public List<Huesped> traerHuesped() {
        return huespedJPA.findHuespedEntities();
    }

    public List<Reserva> traerReserva() {

        return reservaJPA.findReservaEntities();

    }

    public List<TipoHabitacion> traerTipo() {
        return tipoHabitacionJPA.findTipoHabitacionEntities();
    }

    public List<Habitacion> traerHabitacion() {
        return habitacionJPA.findHabitacionEntities();
    }

    public Habitacion traerHabitacionPorId(int id) {
        return habitacionJPA.findHabitacion(id);
    }

    public Usuario traerUsuarioPorID(int id) {
        return usuarioJPA.findUsuario(id);
    }

    public Empleado traerEmpleadoPorID(int id) {
        return empleadoJPA.findEmpleado(id);
    }
    
     public Huesped traerHuespedPorID(int id_huesped) {
        return huespedJPA.findHuesped(id_huesped);
    }
     
    public TipoHabitacion traerTipoPorID(int id) {
       return tipoHabitacionJPA.findTipoHabitacion(id);
    }
    

    //para editar
    public void modificarHabitacion(Habitacion habitacion) {
        try {
            habitacionJPA.edit(habitacion);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarEmpleado(Empleado empleado) {
        //recibe el objeto completo que le pasamos
        //lo compara con la DB, busca por ID cada dato y lo va modficando
        try {
            empleadoJPA.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarHuesped(Huesped huesped) {
        //recibe el objeto completo que le pasamos
        //lo compara con la DB, busca por ID cada dato y lo va modficando
        try {
            huespedJPA.edit(huesped);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarHabitacion(int id_habitacion) {
       //recibe el objeto completo que le pasamos
        //lo compara con la DB, busca por ID cada dato y lo va modficando
        try {
            habitacionJPA.destroy(id_habitacion);
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarHuesped(int id_huesped) {
        //recibe el objeto completo que le pasamos
        //lo compara con la DB, busca por ID cada dato y lo va modficando
        try {
            huespedJPA.destroy(id_huesped);
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarEmpleado(int id_empleado) {
         try {
            empleadoJPA.destroy(id_empleado);
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void modificarUsuario(Usuario usuario) {
        try {
            usuarioJPA.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarTipoHabitacion(TipoHabitacion tipo) {
        try {
            tipoHabitacionJPA.edit(tipo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      public void borrarReserva(int id_reserva) {
         try {
            reservaJPA.destroy(id_reserva);
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Reserva traerReservaPorID(int id_reserva) {
        return reservaJPA.findReserva(id_reserva);
    }

    public void modificarReserva(Reserva reserva) {
        try {
            reservaJPA.edit(reserva);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
