package Logica;

//libreria
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Huesped extends Persona implements Serializable {

    @Basic
    String profesion;

    @OneToMany
    //Por relacion 1:n entre Huesped y Reserva
    List<Reserva> lista_reservas;

    //contructores
    public Huesped() {
    }

    public Huesped(String profesion, List<Reserva> lista_reservas, int id_persona, String dni, String nombre, String apellido, String direccion, Date fecha_nac) {
        super(id_persona, dni, nombre, apellido, direccion, fecha_nac);
        this.profesion = profesion;
        this.lista_reservas = lista_reservas;
    }

    //getter y setters
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
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
    
    public Huesped dameHuesped(Reserva reserva, List <Huesped> lista_huesped) {

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

    //getter y setter heredados
    @Override
    public int getId_persona() {
        return id_persona;
    }

    @Override
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public Date getFecha_nac() {
        return fecha_nac;
    }

    @Override
    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    
    ////otro metodos
    public boolean yaEstaRegistrado(){
       
        if (lista_reservas != null){
            return true;
        }
        return false;
    }

}
