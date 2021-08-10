package Logica;

import Logica.Reserva;
import Logica.TipoHabitacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-08-09T22:12:10")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, Integer> nro_habitacion;
    public static volatile SingularAttribute<Habitacion, String> nombre_habitacion;
    public static volatile ListAttribute<Habitacion, Reserva> lista_reservas;
    public static volatile SingularAttribute<Habitacion, TipoHabitacion> tipo_habitacion;
    public static volatile SingularAttribute<Habitacion, Boolean> esta_reservada;
    public static volatile SingularAttribute<Habitacion, Integer> nroPiso;

}