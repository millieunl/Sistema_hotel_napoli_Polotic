package Logica;

//librerias
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_generador")
    @SequenceGenerator(allocationSize = 1, name = "reserva_generador")
    int nro_reserva;

    @Temporal(TemporalType.DATE)
    Date fecha_alta_reserva;

    @Temporal(TemporalType.DATE)
    Date fecha_ingreso;

    @Temporal(TemporalType.DATE)
    Date fecha_egreso;

    @Basic
    double monto_total;

    int cant_total_dias_reserva;
    int cant_personas;
    
    boolean esta_activa;

    //contructor
    public Reserva() {
    }

    public Reserva(Date fecha_alta_reserva, Date fecha_ingreso, Date fecha_egreso, double monto_total, int cant_total_dias_reserva, int cant_personas) {
        this.fecha_alta_reserva = fecha_alta_reserva;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_egreso = fecha_egreso;
        this.monto_total = monto_total;
        this.cant_total_dias_reserva = cant_total_dias_reserva;
        this.cant_personas = cant_personas;
    }

    //getter y setter
    public int getNro_reserva() {
        return nro_reserva;
    }

    public void setNro_reserva(int nro_reserva) {
        this.nro_reserva = nro_reserva;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_egreso() {
        return fecha_egreso;
    }

    public void setFecha_egreso(Date fecha_egreso) {
        this.fecha_egreso = fecha_egreso;
    }

    public Date getFecha_alta_reserva() {
        return fecha_alta_reserva;
    }

    public void setFecha_alta_reserva(Date fecha_alta_reserva) {
        this.fecha_alta_reserva = fecha_alta_reserva;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }

    public int getCant_total_dias_reserva() {
        return cant_total_dias_reserva;
    }

    public void setCant_total_dias_reserva(int cant_total_dias_reserva) {
        this.cant_total_dias_reserva = cant_total_dias_reserva;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public boolean isEsta_activa() {
        return esta_activa;
    }

    public void setEsta_activa(boolean esta_activa) {
        this.esta_activa = esta_activa;
    }
    
    

}
