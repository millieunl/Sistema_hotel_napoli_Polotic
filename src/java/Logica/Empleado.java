
package Logica;

//libreria
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Empleado extends Persona implements Serializable{
    
    @Basic
    String cargo;
    
    //Por relacion 1:1  empleado-usuario
    //este atributo del tipo usuario hace que el empleado se
    //relacione con la clase usuario
    //con esto digo: 1 empleado tendra un usuario relacionado
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_usuario", referencedColumnName = "id_usuario")
    Usuario usuario;
    
    //Por relacion 1:n Empleado-Reserva declaramos una lista
    @OneToMany
    List<Reserva> lista_reservas;
    
    //contructores
    public Empleado() { }

    //contrcutor con atributos propios y los de la madre

    public Empleado(String cargo, Usuario usuario, List<Reserva> lista_reservas, int id_persona, String dni, String nombre, String apellido, String direccion, Date fecha_nac) {
        super(id_persona, dni, nombre, apellido, direccion, fecha_nac);
        this.cargo = cargo;
        this.usuario = usuario;
        this.lista_reservas = lista_reservas;
    }
    
  
    //getter y setter
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    
    //getter y setters heredados
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
    
   
    //devuelve la id del usuario en un entero
    public int getIdUsuario(){
        return usuario.getId_usuario();
    }
    
    
   
}