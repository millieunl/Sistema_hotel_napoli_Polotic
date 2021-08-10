package Logica;

import Logica.Habitacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-08-09T22:12:10")
@StaticMetamodel(TipoHabitacion.class)
public class TipoHabitacion_ { 

    public static volatile SingularAttribute<TipoHabitacion, Integer> cantidad_limite;
    public static volatile SingularAttribute<TipoHabitacion, String> tipo;
    public static volatile SingularAttribute<TipoHabitacion, Double> precio_noche;
    public static volatile ListAttribute<TipoHabitacion, Habitacion> lista_habitaciones;
    public static volatile SingularAttribute<TipoHabitacion, Integer> id_tipo;

}