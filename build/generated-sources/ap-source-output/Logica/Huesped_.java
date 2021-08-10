package Logica;

import Logica.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-08-09T22:12:10")
@StaticMetamodel(Huesped.class)
public class Huesped_ extends Persona_ {

    public static volatile ListAttribute<Huesped, Reserva> lista_reservas;
    public static volatile SingularAttribute<Huesped, String> profesion;

}