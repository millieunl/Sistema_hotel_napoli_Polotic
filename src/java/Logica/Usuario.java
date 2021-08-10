
package Logica;

//librerias
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="usuario_generador")
    @SequenceGenerator(allocationSize=1, name="usuario_generador")
    int id_usuario;
    
    @Basic
    String nombre_usuario;
    String contrasenia;
    
    //constructores
    public Usuario() {}

    public Usuario( String nombre_usuario, String contrasenia) {
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
    }

    //getter y setter
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
   
   
    
    
    
}
