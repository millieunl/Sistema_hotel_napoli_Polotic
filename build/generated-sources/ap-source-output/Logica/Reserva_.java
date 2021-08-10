package Logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-08-09T22:12:10")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Date> fecha_egreso;
    public static volatile SingularAttribute<Reserva, Double> monto_total;
    public static volatile SingularAttribute<Reserva, Integer> cant_personas;
    public static volatile SingularAttribute<Reserva, Boolean> esta_activa;
    public static volatile SingularAttribute<Reserva, Date> fecha_ingreso;
    public static volatile SingularAttribute<Reserva, Integer> nro_reserva;
    public static volatile SingularAttribute<Reserva, Date> fecha_alta_reserva;
    public static volatile SingularAttribute<Reserva, Integer> cant_total_dias_reserva;

}