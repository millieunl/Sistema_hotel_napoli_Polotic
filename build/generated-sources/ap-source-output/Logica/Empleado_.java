package Logica;

import Logica.Reserva;
import Logica.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-08-09T22:12:10")
@StaticMetamodel(Empleado.class)
public class Empleado_ extends Persona_ {

    public static volatile ListAttribute<Empleado, Reserva> lista_reservas;
    public static volatile SingularAttribute<Empleado, Usuario> usuario;
    public static volatile SingularAttribute<Empleado, String> cargo;

}