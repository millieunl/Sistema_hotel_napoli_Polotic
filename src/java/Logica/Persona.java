
/*
Esta clase servira de plantilla para crear
las clases Huesped y Empleado
*/
package Logica;

//librerias
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

//mapeamos la clase madre
@Entity
//mapeamos como herencia
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {
    
//atributos
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="persona_generador")
    @SequenceGenerator(allocationSize=1, name="persona_generador")
    int id_persona;
      
   @Basic
    String dni;       
    String nombre;
    String apellido;
    String direccion;
    
   @Temporal(TemporalType.DATE)
    Date fecha_nac;
    
    //contructores
    public Persona(){}

    public Persona(int id_persona, String dni, String nombre, String apellido, String direccion, Date fecha_nac) {
        this.id_persona = id_persona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fecha_nac = fecha_nac;
    }
    
    
    //getter y setters
    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    
    //Convertir Date a String
    //sirve para mostrar en pantalla la fecha que traigo de la DB
    public static String DateAString(Date fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        return formatoFecha.format(fecha);
    }
   
     
}

