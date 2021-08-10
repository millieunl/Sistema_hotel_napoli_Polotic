/*
Esta clase contiene el tipo de habitacion.
1-single
2-doble
3-triple
4-multiple = 1,2,3,4 o mas
*/

package Logica;

//librerias
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class TipoHabitacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="tipoHabitacion_generador")
    @SequenceGenerator(allocationSize=1, name="tipoHabitacion_generador")
    int id_tipo;
    
    @Basic
    String tipo;
    int cantidad_limite;
    double precio_noche;
    
    //Por relacion 1:n entre clase Habitacion y TipoHabitacion, hacemos una lista aqui
    //Usamos una lista de las habitaciones que tiene asociada el tipo de habitacion.
   @OneToMany(mappedBy = "tipo_habitacion", cascade = CascadeType.ALL, orphanRemoval = true)
   List <Habitacion> lista_habitaciones; 
    
   //constructor 
    public TipoHabitacion() {}

    public TipoHabitacion(int id_tipo, String tipo, int cantidad_limite, double precio_noche, List<Habitacion> lista_habitaciones) {
        this.id_tipo = id_tipo;
        this.tipo = tipo;
        this.cantidad_limite = cantidad_limite;
        this.precio_noche = precio_noche;
        this.lista_habitaciones = lista_habitaciones;
    }

   public void addTipo(Habitacion h){
        lista_habitaciones.add(h);
        h.setTipo_habitacion(this);
    }
   
    public void removeTipo(Habitacion h){
        lista_habitaciones.remove(h);
        h.setTipo_habitacion(null);
    }

    
    //getter y setter
    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad_limite() {
        return cantidad_limite;
    }

    public void setCantidad_limite(int cantidad_limite) {
        this.cantidad_limite = cantidad_limite;
    }

    public double getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(double precio_noche) {
        this.precio_noche = precio_noche;
    }

    public List<Habitacion> getLista_habitaciones() {
        return lista_habitaciones;
    }

    public void setLista_habitaciones(List<Habitacion> lista_habitaciones) {
        this.lista_habitaciones = lista_habitaciones;
    }
    
    
      
}
