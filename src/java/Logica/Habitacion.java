package Logica;

//librerias
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "habitacion_generador")
    @SequenceGenerator(allocationSize = 1, name = "habitacion_generador")
    int nro_habitacion;

    @Basic
    int nroPiso;
    String nombre_habitacion;
    boolean esta_reservada;

    //por relacion 1:n entre clase Habitacion y clase Reserva, hacemos una lista
    @OneToMany
    List<Reserva> lista_reservas;

    //lo usamos por que hay asociada en la clase (tipohabitacion) un @OneToMany
    @ManyToOne()
    @JoinColumn(name = "id_tipo")
    TipoHabitacion tipo_habitacion;

    //constructores
    public Habitacion() {
    }

    public Habitacion(int nroPiso, String nombre_habitacion, boolean esta_reservada, List<Reserva> lista_reservas, TipoHabitacion tipo_habitacion) {
        this.nroPiso = nroPiso;
        this.nombre_habitacion = nombre_habitacion;
        this.esta_reservada = esta_reservada;
        this.lista_reservas = lista_reservas;
        this.tipo_habitacion = tipo_habitacion;
    }

    //getter y setter
    public int getNro_habitacion() {
        return nro_habitacion;
    }

    public void setNro_habitacion(int nro_habitacion) {
        this.nro_habitacion = nro_habitacion;
    }

    public int getNroPiso() {
        return nroPiso;
    }

    public void setNroPiso(int nroPiso) {
        this.nroPiso = nroPiso;
    }

    public String getNombre_habitacion() {
        return nombre_habitacion;
    }

    public void setNombre_habitacion(String nombre_habitacion) {
        this.nombre_habitacion = nombre_habitacion;
    }

    public boolean isEsta_reservada() {
        return esta_reservada;
    }

    public void setEsta_reservada(boolean esta_reservada) {
        this.esta_reservada = esta_reservada;
    }

    public List<Reserva> getLista_reservas() {
        return lista_reservas;
    }

    public void setLista_reservas(List<Reserva> lista_reservas) {
        this.lista_reservas = lista_reservas;
    }

    public void agregarReserva(Reserva reserva) {
        this.lista_reservas.add(reserva);
    }

    public void quitarReserva(Reserva reserva) {
        this.lista_reservas.remove(reserva);
    }
     
    public Habitacion dameHabitacion(Reserva reserva, List <Habitacion> lista_habitacion) {
        //List <Habitacion>  lista_habitacion = traerHabitacion();
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
     
    public TipoHabitacion getTipo_habitacion() {
        return tipo_habitacion;
    }

    public void setTipo_habitacion(TipoHabitacion tipo_habitacion) {

        this.tipo_habitacion = tipo_habitacion;

    }

    public String dameTipo() {
        return tipo_habitacion.getTipo();
    }

    public double damePrecio() {
        return tipo_habitacion.getPrecio_noche();
    }

}
