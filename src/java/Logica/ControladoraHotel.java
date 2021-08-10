// esta clase controladora
//sirve de nexo entre el servlet y la controladora de persistencia.
package Logica;

//librerias
import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ControladoraHotel {

    //creamos e inicializamos la controladora de persistencia
    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();

    //*********************************************************************************
    //metodo para crear la reserva
    //*********************************************************************************
    public void crearReservaHuespedNuevo(Date fecha_alta, Date fecha_ingreso, Date fecha_egreso, String nombre, String apellido, String dni, Date fecha_nac, String profesion, String direccion, Empleado empleado, Habitacion habitacion, int cant_personas) {

        //setea la reserva con los parametros que recibio desde el servlet
        Reserva reserva = new Reserva();

        //setea los atributos de la clase/entidad reserva
        reserva.setFecha_alta_reserva(fecha_alta);
        reserva.setFecha_ingreso(fecha_ingreso);
        reserva.setFecha_egreso(fecha_egreso);
        reserva.setCant_personas(cant_personas);
        reserva.setEsta_activa(true);
        reserva.setMonto_total(damePrecioTotal(fecha_ingreso, fecha_egreso, habitacion.getTipo_habitacion().getPrecio_noche()));
        reserva.setCant_total_dias_reserva(dameCantidadDias(fecha_ingreso, fecha_egreso));

        //setea como true la boleana esta_reservada de la habitacion
        habitacion.setEsta_reservada(true);

        //agrega la reserva a la listas  de reservas que surgen de las relaciones con habitacion y empleado 
        habitacion.agregarReserva(reserva);
        empleado.agregarReserva(reserva);

        //creamos la reserva
        controlPersistencia.crearReserva(reserva);

        //creamos huesped nuevo y le asignamos la reserva
        crearHuesped(nombre, apellido, dni, fecha_nac, profesion, direccion, reserva);

        controlPersistencia.modificarEmpleado(empleado);
        controlPersistencia.modificarHabitacion(habitacion);

    }

    public void crearReservaHuespedExistente(Date fecha_alta, Date fecha_ingreso, Date fecha_egreso, String apellido, String dni, Empleado empleado, Habitacion habitacion, int cant_personas) {

        Reserva reserva = new Reserva();
        Huesped huesped = dameHuespedExistente(apellido, dni);

        //setea como true la boleana esta_reservada
        habitacion.setEsta_reservada(true);

        //setea los atributos de la clase/entidad reserva
        reserva.setFecha_alta_reserva(fecha_alta);
        reserva.setFecha_ingreso(fecha_ingreso);
        reserva.setFecha_egreso(fecha_egreso);
        reserva.setCant_personas(cant_personas);
        reserva.setEsta_activa(true);
        reserva.setMonto_total(damePrecioTotal(fecha_ingreso, fecha_egreso, habitacion.getTipo_habitacion().getPrecio_noche()));
        reserva.setCant_total_dias_reserva(dameCantidadDias(fecha_ingreso, fecha_egreso));

        //agrega a las listas de reservas de cada objeto la nueva reserva
        huesped.agregarReserva(reserva);
        habitacion.agregarReserva(reserva);
        empleado.agregarReserva(reserva);

        //crea la reserva y modifica las listas de reservas para tener la nueva reserva
        controlPersistencia.crearReserva(reserva);
        controlPersistencia.modificarHuesped(huesped);
        controlPersistencia.modificarEmpleado(empleado);
        controlPersistencia.modificarHabitacion(habitacion);

    }

    //public void crearHuesped(String nombre, String apellido, String dni, Date fechaNac, String profesion, String direccion) {
    public void crearHuesped(String nombre, String apellido, String dni, Date fechaNac, String profesion, String direccion, Reserva reserva) {

        //creamos un nuevo objeto huesped 
        Huesped huesped = new Huesped();
        List<Reserva> lista_reserva = new ArrayList<Reserva>();

        //seteamos al objeto cada uno de los parametros que recibimos
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setDni(dni);
        huesped.setFecha_nac(fechaNac);
        huesped.setProfesion(profesion);
        huesped.setDireccion(direccion);
        lista_reserva.add(reserva);
        huesped.setLista_reservas(lista_reserva);

        //llamamos  a la controladora de persistencia  para  pedirle que cree 
        //la reserva en la DB. Para eso  llamamos al metodo creahuesped y le pasamos el huesped
        controlPersistencia.crearHuesped(huesped);
    }

    //metodo para crear empleados
    public void crearEmpleado(String nombre, String apellido, String dni, Date fechaNac, String cargo, String direccion) {

        Empleado empleado = new Empleado();

        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setFecha_nac(fechaNac);
        empleado.setCargo(cargo);
        empleado.setDireccion(direccion);

        //controladora de peRsistencia
        controlPersistencia.crearEmpleado(empleado);
    }

    //metodo para crear empleados y el usuario
    public void crearEmpleadoUsuario(String nombre, String apellido, String dni, Date fechaNac, String cargo, String direccion, String usuario, String contrasenia) {

        //instanciamos las clases-entidad que necesitamos
        Empleado empleado = new Empleado();
        Usuario user = new Usuario(usuario, contrasenia);

        empleado.setUsuario(user);
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setDni(dni);
        empleado.setFecha_nac(fechaNac);
        empleado.setCargo(cargo);
        empleado.setDireccion(direccion);

        controlPersistencia.crearEmpleadoUsuario(empleado);

    }

    //metodo que crea SOLO usuarios
    public void crearUsuario(String usuario, String contrasenia) {
        Usuario user = new Usuario();

        user.setNombre_usuario(usuario);
        user.setContrasenia(contrasenia);

        controlPersistencia.crearUsuario(user);
    }

    //metodo para crear tipo de habitaciones
    public void crearTipoHabitacion(String tipo, int i_cant_limite, Double d_precio) {
        TipoHabitacion tipoh = new TipoHabitacion();
        tipoh.setTipo(tipo);
        tipoh.setCantidad_limite(i_cant_limite);
        tipoh.setPrecio_noche(d_precio);
        controlPersistencia.crearTipoHabitacion(tipoh);

    }

    public void crearHabitacion(int nro_piso, String nombre_habitacion, int tipo, boolean esta_reservada) {
        Habitacion habitacion = new Habitacion();
        habitacion.setNroPiso(nro_piso);
        habitacion.setNombre_habitacion(nombre_habitacion);
        habitacion.setEsta_reservada(esta_reservada);
        TipoHabitacion h = new TipoHabitacion();
        h.setId_tipo(tipo);
        habitacion.setTipo_habitacion(h);
        controlPersistencia.crearHabitacion(habitacion);
    }

    //**********************************************
    //METODOS PARA TRAER LISTA DE OBJETOS SIN FILTRAR
    //********************************************
    //metodo para lista de empleados
    public List<Empleado> traerEmpleado() {
        return controlPersistencia.traerEmpleado();
    }

    public List<Usuario> traerUsuario() {
        return controlPersistencia.traerUsuario();
    }

    //metodo para lista de huespedes
    public List<Huesped> traerHuesped() {
        return controlPersistencia.traerHuesped();
    }

    //trae todas las habitaciones de la persistencia y las devuelve en forma de lista
    public List<Reserva> traerReserva() {
        return controlPersistencia.traerReserva();
    }

    public List<TipoHabitacion> traerTipo() {
        return controlPersistencia.traerTipo();
    }

    public List<Habitacion> traerHabitacion() {
        return controlPersistencia.traerHabitacion();
    }

    //*********************************************************************************
    //METODOS PARA TRAER LISTAS DE OBJETOS FILTRADOS POR FECHAS, DISPONIBILIDADES, ETC
    //**********************************************************************************
    //devuelve una lista  de reservas filtrada por fechas. Se le debe indicar un rango de inicio a fin de la duracion de la reserva
    public List<Reserva> traerReservaPorFecha(Date fecha_ingreso, Date fecha_egreso) {
        List<Reserva> lista_reserva = traerReserva();
        List<Reserva> lista_filtrada = new ArrayList<Reserva>();

        int cont = 0;
        for (Reserva res : lista_reserva) {
            cont++;
            if (hayInterseccionFechas(fecha_ingreso,
                    fecha_egreso,
                    res.getFecha_ingreso(),
                    res.getFecha_egreso())) {
                lista_filtrada.add(res);
            }

        }

        return lista_filtrada;
    }

    //METODO PARA FECHAS QUE COMPARA TRES FECHAS PARA LAS RESERVAS DEL EMPLEADO
    //recibe una lista del tipo reserva de un empleado determinado.
    //y devuelve una lista del tipo reserva filtrada por fecha
    //recibe  2 fechas del tipo date y las compara con una fecha de alta de la reserva retirada de la DB
    //Trabaja comparando 3 fechas: compara la fecha de alta de una reserva con la fecha fecha desde y hasta 
    //utiliza la funcion compareTo de fecha para deterctar si la fecha de alta de una reserva esta en el rango de fechas desde y hasta
    public List<Reserva> traerReservaEmpleadoPorFecha(Date fecha_desde, Date fecha_hasta, List<Reserva> lista_reserva) {

        List<Reserva> lista_filtrada = new ArrayList<Reserva>();

        for (Reserva res : lista_reserva) {
            if (res.getFecha_alta_reserva().compareTo(fecha_desde) >= 0
                    && res.getFecha_alta_reserva().compareTo(fecha_hasta) <= 0) {
                lista_filtrada.add(res);
            }
        }

        return lista_filtrada;
    }

    //METODO QUE COMPARA 3 FECHAS
    //devuelve una lista de reservas de un huesped desde su dia de ingreso dentro de un determinado rango de fechas desde-hasta
    public List<Reserva> traerReservaHuespedPorFecha(Date fecha_desde, Date fecha_hasta, List<Reserva> lista_reserva) {

        List<Reserva> lista_filtrada = new ArrayList<Reserva>();

        for (Reserva res : lista_reserva) {
            if (res.getFecha_egreso().compareTo(fecha_desde) >= 0
                    && res.getFecha_ingreso().compareTo(fecha_hasta) <= 0) {
                lista_filtrada.add(res);
            }
        }

        return lista_filtrada;
    }

    //METODO QUE COMPARA DOS FECHAS : la de HOY y la de alta de una reserva
    //Sirve para traer TODAS las reservas del dia de HOY
    public List<Reserva> traerReservaDeHoy() {
        //traigo toda la lista 
        List<Reserva> lista = traerReserva();
        String dia = getFechaActual();

        //hago una lista copia, que sirve para guardar las coincidencias con la fecha que me envio de parametro
        List< Reserva> lista_filtrada = new ArrayList();

        //si la lista no esta vacia la recorro
        if (lista != null) {
            //busca 
            for (int i = 0; i < lista.size(); i++) {
                Reserva r = lista.get(i);
                if (DateAString(r.getFecha_alta_reserva()).equals(dia)) {
                    lista_filtrada.add(r);
                }
            }
        }

        return lista_filtrada;
    }

    //devuleve una lista de habitaciones filtrada por la cantidad limite de personas permitidas
    public List<Habitacion> traerHabitacionDisponiblePorCantLimite(int cant_personas) {

        List<Habitacion> lista_hab = traerHabitacion();
        List<Habitacion> lista_filtrada = new ArrayList<Habitacion>();

        for (Habitacion hab : lista_hab) {
            if (cant_personas <= hab.getTipo_habitacion().getCantidad_limite()) {
                lista_filtrada.add(hab);
            }
        }
        System.out.println("ACAAA trae el filtro por persnas " + lista_filtrada.isEmpty());
        return lista_filtrada;
    }

    //devuleve una lista de habitaciones filtrada por fechas disponibles
    public List<Habitacion> traerHabitacionDisponible(Date fecha_averiguar_inicio, Date fecha_averiguar_fin, int cant_personas) {

        //creamos una lista que contendra las habitaciones disponibles
        List<Habitacion> lista_habitacion = traerHabitacionDisponiblePorCantLimite(cant_personas);

        //en esta lista guarda  las habitaciones disponibles
        List< Habitacion> lista_filtrada = new ArrayList();

        for (Habitacion habitacion : lista_habitacion) {
            List<Reserva> listaR = habitacion.getLista_reservas();
            boolean registrar = true;

            if (listaR.isEmpty()) {
                lista_filtrada.add(habitacion);
            } else {
                for (Reserva reserva : listaR) {

                    if (hayDisponibilidad(fecha_averiguar_inicio,
                            fecha_averiguar_fin,
                            reserva.getFecha_ingreso(),
                            reserva.getFecha_egreso())) {
                        if (registrar) {
                            lista_filtrada.add(habitacion);
                            registrar = false;
                        }
                    }

                }

            }

        }
        return lista_filtrada;
    }

    //*********************************************************************************
    //TRAE OBJETOS POR ID
    //*********************************************************************************
    public Habitacion traerHabitacionPorId(int nro_habitacion) {
        return controlPersistencia.traerHabitacionPorId(nro_habitacion);
    }

    public TipoHabitacion traerTipoPorID(int tipo) {
        return controlPersistencia.traerTipoPorID(tipo);
    }

    public Usuario traerUsuarioPorId(int id_usuario) {
        return controlPersistencia.traerUsuarioPorID(id_usuario);
    }

    public Huesped traerHuespedPorID(int id_huesped) {
        return controlPersistencia.traerHuespedPorID(id_huesped);
    }

    public Empleado traerEmpleadoPorID(int id_empleado) {
        return controlPersistencia.traerEmpleadoPorID(id_empleado);
    }

    public Reserva traerReservaPorID(int id_reserva) {
        return controlPersistencia.traerReservaPorID(id_reserva);
    }

    //*********************************************************************************
    //METODOS PARA MODIFICAR OBJTEOS
    //*********************************************************************************
    public void modificarHuesped(Huesped huesped) {
        controlPersistencia.modificarHuesped(huesped);
    }

    public void modificarUsuario(Usuario usuario) {
        controlPersistencia.modificarUsuario(usuario);
    }

    public void modificarTipoHabitacion(TipoHabitacion tipo) {
        controlPersistencia.modificarTipoHabitacion(tipo);
    }

    public void modificarEmpleado(Empleado empleado) {
        controlPersistencia.modificarEmpleado(empleado);
    }

    public void modificarHabitacion(Habitacion habitacion) {
        controlPersistencia.modificarHabitacion(habitacion);
    }

    //no andaaaa?
    public void modificarReservaCompleta(Reserva reserva, Habitacion habitacion_nueva, Habitacion habitacion_vieja, Huesped huesped) {

        reserva.setMonto_total(damePrecioTotal(reserva.getFecha_ingreso(), reserva.getFecha_egreso(), habitacion_nueva.getTipo_habitacion().getPrecio_noche()));
        reserva.setCant_total_dias_reserva(dameCantidadDias(reserva.getFecha_ingreso(), reserva.getFecha_egreso()));

        //agrega a las listas de reservas de cada objeto la nueva reserva
        //huesped.agregarReserva(reserva);
        habitacion_nueva.agregarReserva(reserva);
        habitacion_vieja.quitarReserva(reserva);

        habitacion_nueva.setEsta_reservada(true);
        habitacion_vieja.setEsta_reservada(false);

        /*
        System.out.println(" DATOS QUE LLEGAN A MODIFICAR RESERVA");

        System.out.println(" HUESPED  " + huesped.getNombre() + " " + huesped.getId_persona());
        System.out.println(" RESERVA VIEJA " + habitacion_vieja.getNombre_habitacion() + "  " + habitacion_vieja.getNro_habitacion());
        System.out.println(" RESERVA nueva " + habitacion_nueva.getNombre_habitacion() + "  " + habitacion_nueva.getNro_habitacion());

         */
        controlPersistencia.modificarReserva(reserva);
        controlPersistencia.modificarHuesped(huesped);
        controlPersistencia.modificarHabitacion(habitacion_nueva);
        controlPersistencia.modificarHabitacion(habitacion_vieja);

    }

    //*********************************************************************************
    //METODOS PARA BORRAR OBJETOS
    //*********************************************************************************
    public void borrarEmpleado(int id_empleado) {
        controlPersistencia.borrarEmpleado(id_empleado);
    }

    public void borrarHuesped(int id_huesped) {
        controlPersistencia.borrarHuesped(id_huesped);
    }

    public void borrarReserva(int id_reserva) {
        controlPersistencia.borrarReserva(id_reserva);
    }

    public void borrarHabitacion(int id_habitacion) {
        controlPersistencia.borrarHabitacion(id_habitacion);
    }

    //*********************************************************************************
    //UTILIDADES
    //*********************************************************************************
    //Convertir Date a String
    //sirve para mostrar en pantalla la fecha que traigo de la DB
    public String DateAString(Date fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        return formatoFecha.format(fecha);
    }

    //Convierte un String a un tipo DATE en formato dd-MM-yyyy
    //@return Retorna la fecha en formato Date
    /**
     *
     * @param fecha
     * @return
     */
    public synchronized java.util.Date deStringToDate(String fecha) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); //formato guión
        Date fechaEnviar = null;
        try {
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //Metodo usado para obtener la fecha actual
    //@return Retorna un STRING con la fecha actual formato "dd-MM-yyyy"
    public String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy"); //acá pueden cambiar el formato si quieren
        return formatoFecha.format(ahora);
    }

    //metodo para saber si hay disponibilidad  de habitacion 
    private boolean hayDisponibilidad(Date fecha_averiguar_inicio, Date fecha_averiguar_fin, Date fecha_ocupado_inicio, Date fecha_ocupado_fin) {
        //System.out.println("FOI ---> " + fecha_ocupado_inicio);
        //System.out.println("FOF  --> " + fecha_ocupado_fin);
        //comparamos las fechas con los metodos de date before y after
        if ((fecha_averiguar_inicio.before(fecha_ocupado_inicio)
                && fecha_averiguar_inicio.before(fecha_ocupado_fin)
                && fecha_averiguar_fin.before(fecha_ocupado_inicio)
                && fecha_averiguar_fin.before(fecha_ocupado_fin))
                || (fecha_averiguar_inicio.after(fecha_ocupado_inicio)
                && fecha_averiguar_inicio.after(fecha_ocupado_fin)
                && fecha_averiguar_fin.after(fecha_ocupado_inicio)
                && fecha_averiguar_fin.after(fecha_ocupado_fin))) {
            //System.out.println("HAY DISPONIBLE");
            return true;
        } else {
            //System.out.println("NO HAY DISPONIBLE");
            return false;
        }

    }

    //si le paso una reserva me devuelve el huesped que la reservó
    public Huesped dameHuepedReserva(Reserva reserva) {
        //buscamos entre los huespedes el que tiene la reserva elegida
        //1-traemos todos los huespedes y lo guardamos en una lista
        //2-se crea una instancia nueva de huesped antes de empezar el for
        //3-recorremos  tda la lista de huespedes y  luego recorremos
        //4-la lista de reservas que tiene cada instancia de ese huesped
        //5 se le asigna al objeto creado del tipo huesped, el huesped que tiene el numero de reserva buscado
        List<Huesped> lista_huesped = traerHuesped();
        Huesped huesped = new Huesped();
        for (Huesped hues : lista_huesped) {
            for (Reserva res : hues.getLista_reservas()) {
                if (res.getNro_reserva() == reserva.getNro_reserva()) {
                    huesped = hues;
                }
            }
        }
        return huesped;
    }

    //si le paso una reserva me devuelve la habitacion que tiene esa reserva
    public Habitacion dameHabitacionReserva(Reserva reserva) {
        List<Habitacion> lista_habitacion = traerHabitacion();
        Habitacion habitacion = new Habitacion();

        for (Habitacion hab : lista_habitacion) {
            for (Reserva res : hab.getLista_reservas()) {
                if (res.getNro_reserva() == reserva.getNro_reserva()) {
                    habitacion = hab;
                }
            }
        }

        return habitacion;
    }

    public Huesped dameHuespedExistente(String apellido, String dni) {
        List<Huesped> lista_huesped = controlPersistencia.traerHuesped();

        Huesped huesped = new Huesped();
        //verifica si el usuario ya existe
        for (Huesped hues : lista_huesped) {
            if (hues.getDni().equals(dni) && hues.getApellido().equals(apellido)) {
                huesped = hues;
            }
        }

        return huesped;
    }

    //devuelve un entero con la cantidad de dias entre dos fechas(del tipo DATE)
    //Uso general
    private int dameCantidadDias(Date fecha_inicial, Date fecha_final) {
        long nro_dias = fecha_final.getTime() - fecha_inicial.getTime();
        int cant_dias = (int) TimeUnit.DAYS.convert(nro_dias, TimeUnit.MILLISECONDS); // ya convertido en INT
        return cant_dias;
    }

    //devuelve el monto total del precio de una habitacion segun su tipo y la cantidad de dias de la reserva
    public double damePrecioTotal(Date fecha_ingreso, Date fecha_egreso, double precio_noche) {
        int cant_dias_reserva = dameCantidadDias(fecha_ingreso, fecha_egreso);
        double precio_total = cant_dias_reserva * precio_noche;
        return precio_total;
    }

    //METODO PARA COMPARAR 4 FECHAS, USO GENERAL    
    //recibe formato tipo DATE.Sirve para saber si dos fechas a buscar estan dentro de un rango de otras dos fechas
    //si hay una interseccion entre las fechas ( segmento en comun)  devuleve true
    private boolean hayInterseccionFechas(Date fecha_averiguar_inicio, Date fecha_averiguar_fin, Date fecha_ocupado_inicio, Date fecha_ocupado_fin) {
        //comparamos las fechas con los metodos de date before y after
        if ((fecha_averiguar_inicio.before(fecha_ocupado_inicio)
                && fecha_averiguar_inicio.before(fecha_ocupado_fin)
                && fecha_averiguar_fin.before(fecha_ocupado_inicio)
                && fecha_averiguar_fin.before(fecha_ocupado_fin))
                || (fecha_averiguar_inicio.after(fecha_ocupado_inicio)
                && fecha_averiguar_inicio.after(fecha_ocupado_fin)
                && fecha_averiguar_fin.after(fecha_ocupado_inicio)
                && fecha_averiguar_fin.after(fecha_ocupado_fin))) {
            return false;
        } else {
            return true;
        }
    }

    //verificar cerdenciales de usuario
    //este metodo trae todos los usuario y contraseña de la base de datos y compara
    //si coincide con el usuario y contraseña que recibio del fomrulario
    public boolean verificarUsuario(String usuario, String contrasenia) {
        List<Usuario> lista_usuarios = controlPersistencia.traerUsuario();

        //recorremos la lista en caso de que no sea null
        //porque si no hay usuarios registrados en la BD, devuelve null
        //cuando recorramos la lista con el for habra un error y se cortara el programa
        if (lista_usuarios != null) {
            //las listas las recorremos con for
            // verificara que cada usuario tarido de la base de datos coincida con el usuario y contrasenia
            //que tenemos  por parametro
            for (Usuario user : lista_usuarios) {

                //hacemos las comparaciones como Strings (tener en cuenta que la constrasenia esta sin encriptar)
                if (user.getNombre_usuario().equals(usuario) && user.getContrasenia().equals(contrasenia)) {

                    //aqui cortamos la ejecucion de la busqueda con for cuando hay coincidencia  y que no busque mas
                    //asi el metodo devuelve true
                    return true;
                }
            }
        }
        //el metodo retorna false si no despues de recorrer el for no encontro coincidencia
        return false;
    }

} //FIN CLASE
