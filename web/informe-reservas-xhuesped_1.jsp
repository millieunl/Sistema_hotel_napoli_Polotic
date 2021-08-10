
<%@page import="com.sun.xml.internal.ws.util.StringUtils"%>
<%@page import="Logica.Habitacion"%>
<%@page import="Logica.Huesped"%>
<%@page import="Logica.Empleado"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <!-- Basic Page Info -->
        <meta charset="utf-8">
        <title>Hotel Napoli </title>

        <!-- Site favicon -->
        <link rel="apple-touch-icon" sizes="180x180" href="vendors/images/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="vendors/images/favicon1-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="vendors/images/favicon1-16x16.png">

        <!-- Mobile Specific Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap"
              rel="stylesheet">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="vendors/styles/core.css">
        <link rel="stylesheet" type="text/css" href="vendors/styles/icon-font.min.css">
        <link rel="stylesheet" type="text/css" href="src/plugins/jvectormap/jquery-jvectormap-2.0.3.css">
        <link rel="stylesheet" type="text/css" href="src/styles/style.css">

        <!--jQuerys-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
        <script>
            window.dataLayer = window.dataLayer || [];

            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());

            gtag('config', 'UA-119386393-1');
        </script>
    </head>

    <body>
        <!-- Pre - Loader -->
        <!--
            <div class="pre-loader">
                    <div class="pre-loader-box">
                            <div class="loader-logo"><img src="vendors/images/napoli-logo3.svg" alt=""></div>
                            <div class='loader-progress' id="progress_div">
                                    <div class='bar' id='bar1'></div>
                            </div>
                            <div class='percent' id='percent1'>0%</div>
                            <div class="loading-text">
                                    Loading...
                            </div>
                    </div>
            </div>
        -->

        <div class="header">
            <div class="header-left">
            </div>
            <div class="header-right">
                <div class="user-info-dropdown">
                    <div class="dropdown">
                        <a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                            <span class="user-icon">
                                <img src="vendors/images/photo1.jpg" alt="">
                            </span>
                            <span class="user-name"><%=request.getSession().getAttribute("usuario_sesion")%></span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
                            <a class="dropdown-item" href="login.jsp"><i class="dw dw-logout"></i> Log Out</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="left-side-bar">
            <!--Logo -->
            <div class="brand-logo">
                <a href="index.jsp">
                    <img src="vendors/images/napoli-logo3.svg" alt="" class="dark-logo">
                    <img src="vendors/images/napoli-logo3-white.svg" alt="" class="light-logo">
                </a>
                <div class="close-sidebar" data-toggle="left-sidebar-close">
                    <i class="ion-close-round"></i>
                </div>
            </div>

            <!--menu -->
            <div class="menu-block customscroll">

                <!-- los subitems de este menu tienen un circulito-->
                <div class="sidebar-menu icon-style-1 icon-list-style-2">
                    <ul id="accordion-menu">

                        <!--1-Home -->
                        <li>
                            <a href="index.jsp" class="dropdown-toggle no-arrow">
                                <span class="micon dw dw-house-1"></span><span class="mtext">Home</span>
                            </a>
                        </li>
                        <li>
                            <div class="dropdown-divider"></div>
                        </li>
                        <li>
                            <div class="sidebar-small-cap">Hotel</div>
                        </li>

                        <!--2-Huepedes -->
                        <li class="dropdown">

                            <a href="javascript:;" class="dropdown-toggle">
                                <span class="micon fa fa-address-book-o"></span><span class="mtext">Huepedes</span>
                            </a>
                            <ul class="submenu">
                                <form action="ServBorrarModificarHuesped" method = "GET">
                                    <li><a href = "ServBorrarModificarHuesped" class ="submit">Borrar o modificar Huesped</a> </li>
                                </form>
                            </ul>
                        </li>

                        <!--2-Reservas -->
                        <li class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle">
                                <span class="micon dw dw-calendar-5"></span><span class="mtext">Reservas</span>
                            </a>
                            <ul class="submenu">
                                <li><a href="form-crear-reserva.jsp">Nueva reserva</a></li>
                                <form action="ServCancelarModificarReserva" method = "GET">
                                    <li><a href = "ServCancelarModificarReserva"" class ="submit">Modificar reservas </a> </li>
                                </form>
                            </ul>
                        </li>

                        <!--3-Habitaciones -->
                        <li class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle">
                                <span class="micon dw dw-hotel"></span><span class="mtext">Habitaciones</span>
                            </a>
                            <ul class="submenu">                               
                                <form action="ServConsultaTipo" method = "GET">
                                    <li><a href = "ServConsultaTipo" class ="submit"> Agregar habitación</a> </li>
                                </form>
                                <li><a href="form-crear-tipo.jsp">Agregar tipo de habitación </a></li>
                                <form action="ServBorrarModificarHabitacion" method = "GET">
                                    <li><a href = "ServBorrarModificarHabitacion" class ="submit">Borrar o modificar Habitacion</a> </li>
                                </form>
                                <form action="ServConsultarModificarTipo" method = "GET">
                                    <li><a href = "ServConsultarModificarTipo" class ="submit">Ver o modificar tipos de habitacion </a> </li>
                                </form>
                                <form action="ServConsultaHabitacion" method = "GET">
                                    <li><a href = "ServConsultaHabitacion" class ="submit">Consultar Habitaciones</a> </li>
                                </form>
                            </ul>
                        </li>

                        <li>
                            <div class="dropdown-divider"></div>
                        </li>
                        <li>
                            <div class="sidebar-small-cap">Administración personal</div>
                        </li>

                        <!--4-Empleados -->
                        <li class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle">
                                <span class="micon icon-copy fa fa-user-o" aria-hidden="true"></span>
                                <span class="mtext">Empleados</span>
                            </a>
                            <ul class="submenu">

                                <li><a href="form-crear-empleado.jsp">Nuevo empleado</a></li>
                                <form action="ServBorrarModificarEmpleado" method = "GET">
                                    <li><a href = "ServBorrarModificarEmpleado" class ="submit">Borrar o modificar Empleado</a> </li>
                                </form>
                                <form action="ServConsultaEmpleado" method = "GET">
                                    <li><a href = "ServConsultaEmpleado" class ="submit"> Ver Empleados</a> </li>
                                </form>
                            </ul>
                        </li>


                        <!--usuarios-->
                        <li class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle">
                                <span class="micon dw dw-user-13"></span><span class="mtext">Usuarios</span>
                            </a>
                            <ul class="submenu">
                                <form action="ServModificarUsuario" method = "GET" >
                                    <li><a href = "ServModificarUsuario" class ="submit">Modificar usuario</a></li>
                                </form>
                                <form action="ServConsultaUsuario" method = "GET">
                                    <li><a href = "ServConsultaUsuario" class ="submit">Ver usuarios</a></li>
                                </form>
                            </ul>
                        </li>


                        <!-- una linea divisoria copada con un titulo-->
                        <li>
                            <div class="dropdown-divider"></div>
                        </li>
                        <li>
                            <div class="sidebar-small-cap">Informes</div>
                        </li>

                        <!--informes  -->
                        <li class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle">
                                <span class="micon dw dw-analytics-22" aria-hidden="true"></span><span class="mtext">Ver
                                    Informes</span>
                            </a>
                            <ul class="submenu">
                                <form action="ServConsultaReservaDia" method = "GET">
                                    <li><a href = "ServConsultaReservaDia" class ="submit">Reservas del dia</a></li>
                                </form>
                                <li><a href="informe-reservas-xfecha.jsp">Reservas por fecha</a></li>
                                <li><a href="informe-reservas-xempleado.jsp">Reservas por empleado</a></li>
                                <li><a href="informe-reservas-xhuesped.jsp">Reservas por huesped</a></li>
                                <form action="ServConsultaHuesped" method = "GET">
                                    <li><a href = "ServConsultaHuesped" class ="submit">Ver todos los huespedes</a></li>
                                </form>
                            </ul>
                        </li>
                        <!--fin lista-->

                    </ul>
                </div>
            </div>
        </div>

        <!--contenedor principal de la pagina-->
        <div class="main-container">
            <div class="pd-ltr-20 xs-pd-20-10">
                <div class="min-height-200px">
                    <div class="page-header">
                        <div class="row">
                            <div class="col-md-6 col-sm-12">
                                <div class="title">
                                    <h4>Informes</h4>
                                </div>
                                <nav aria-label="breadcrumb" role="navigation">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Reservas por huesped</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <!-- Contenedor para la seccion de este formulario -->
                    <div class="pd-20 card-box mb-30">
                        <div class="clearfix">

                            <!--titulo contenedor-->
                            <div class="pull-left">
                                <%
                                    HttpSession miSesion = request.getSession();
                                    Huesped huesped = (Huesped) request.getSession().getAttribute("objeto_huesped");

                                    int id_huesped = huesped.getId_persona();
                                    String nombre_huesped = StringUtils.capitalize(huesped.getNombre()) + " " + StringUtils.capitalize(huesped.getApellido());

                                    String fecha_in = (String) request.getSession().getAttribute("fecha_ingreso");
                                    String fecha_eg = (String) request.getSession().getAttribute("fecha_egreso");

                                %>
                                <h4 class="text-blue h4">Lista de reservas de <%= nombre_huesped%>   </h4>
                                <p class="mb-30">Estas son las reservas que tiene el huesped <strong><%= nombre_huesped%>  con ID <%= id_huesped%> </strong> consultado entre el dia <strong> <%=fecha_in%> </strong> hasta el dia <strong><%= fecha_eg%></strong>  .</p>
                            </div>
                        </div>

                        <!-- Tabla de resultados -->
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">ID reserva</th>
                                    <th scope="col">Fecha Ingreso</th>
                                    <th scope="col">Fecha egreso</th>
                                    <th scope="col">Dias de estadia</th>
                                    <th scope="col">Monto Total</th>
                                    <th scope="col">Nro Habitacion</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Tipo</th>
                                </tr>
                            </thead>

                            <tbody>
                                <%
                                    List<Reserva> lista_reserva_huesped = (List) request.getSession().getAttribute("lista_reserva_huesped");
                                    List<Habitacion> lista_habitacion = (List) request.getSession().getAttribute("lista_habitacion");

                                    for (Habitacion hab : lista_habitacion) {

                                        for (Reserva res : hab.getLista_reservas()) {

                                            for (Reserva res2 : lista_reserva_huesped) {

                                                if (res.getNro_reserva() == res2.getNro_reserva()) {

                                                    int id_reserva = res2.getNro_reserva();
                                                    Date fecha1 = res2.getFecha_ingreso();
                                                    String str_fecha1 = huesped.DateAString(fecha1);
                                                    Date fecha2 = res2.getFecha_ingreso();
                                                    String str_fecha2 = huesped.DateAString(fecha2);
                                                    int cant_dias = res2.getCant_total_dias_reserva();
                                                    double monto_total = res2.getMonto_total();

                                                    int nro_habitacion = hab.getNro_habitacion();
                                                    String nombre_habitacion = hab.getNombre_habitacion();

                                                    String tipo_habitacion = hab.getTipo_habitacion().getTipo();
                                %>
                                <tr>
                                    <td><%= id_reserva%></td>
                                    <td><%= str_fecha1%></td>
                                    <td><%= str_fecha2%></td>
                                    <td><%= cant_dias%></td>
                                    <td><%= res2.getCant_personas()%></td>
                                    <td><%= monto_total%></td>
                                    <td><%=nro_habitacion%></td>
                                    <td><%=nombre_habitacion%></td>
                                    <td><%=tipo_habitacion%></td>

                                </tr>
                                <%
                                                }
                                            }

                                        }
                                    }
                                %>
                            </tbody>
                        </table>
                    </div><!-- fin contenedor de la tabla-->
                    <!-- Contenedor para boton de otra busqueda -->
                    <div class="pd-20 card-box mb-30">
                        <div class="clearfix">
                            <!--botones para reendirigir a un formulario u otro depdendiendo si es nuevo huesped o no -->
                            <div class="col-lg-12 p-t-20 text-center">
                                <a class="btn btn-primary" href="informe-reservas-xhuesped.jsp">Realizar otra consulta</a> <!--para hacer otra busqueda-->
                            </div>
                        </div>
                    </div><!-- fin contenedor-->
                </div> <!-- fin contenedor principal-->

                <!--Footer-->
                <div class="footer-wrap pd-20 mb-20 card-box">
                    Hotel Napoli - Hotel Napoli Admin Template By <a href="https://github.com" target="_blank">Maria Emilia
                        Corbetta</a>
                </div>

            </div>
        </div>

        <!-- js  generales-->
        <script src="vendors/scripts/core.js"></script>
        <script src="vendors/scripts/script.min.js"></script>
        <script src="vendors/scripts/process.js"></script>
        <script src="vendors/scripts/layout-settings.js"></script>

    </body>

</html>


