<%-- 
    Document   : borrar-habitacion
    Created on : 06/08/2021, 04:28:04
    Author     : Maria Emilia Corbetta
--%>

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

    <head>
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
                            <span class="user-name"><%=request.getSession().getAttribute("usuario")%></span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
                            <a class="dropdown-item" href="profile.html"><i class="dw dw-user1"></i> Perfil</a>
                            <a class="dropdown-item" href="login.jsp"><i class="dw dw-logout"></i> Log Out</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="left-side-bar">
            <!--Logo -->
            <div class="brand-logo">
                <a href="index.html">
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
                                <li><a href="editar-huesped.jsp">Editar huesped</a></li>
                                <li><a href="borrar-huesped.jsp">Borrar huesped</a></li>
                            </ul>
                        </li>

                        <!--2-Reservas -->
                        <li class="dropdown">
                            <a href="javascript:;" class="dropdown-toggle">
                                <span class="micon dw dw-calendar-5"></span><span class="mtext">Reservas</span>
                            </a>
                            <ul class="submenu">
                                <li><a href="form-crear-reserva.jsp">Nueva reserva</a></li>
                                <li><a href="editar-reserva.jsp">Editar reservas</a></li>
                                <li><a href="borrar-reserva.jsp">Cancelar reservas</a></li>
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
                                <li><a href="editar-habitacion.jsp">Editar habitacion </a></li>
                                <li><a href="borrar-habitacion.jsp">Cancelar habitacion</a></li>
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
                                <li><a href="editar-empleado.jsp">Editar empleado</a></li>
                                <li><a href="borrar-empleado.jsp">Cancelar empleado</a></li>
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
                                <li><a href="editar-usuario.jsp">Editar usuario</a></li>
                                <li><a href="borrar-usuario.jsp">Cancelar usuario</a></li>
                                <li><a href="ver-tabla-usuarios.jsp">Ver usuarios</a></li>
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
        <div class="mobile-menu-overlay"></div>
        <div class="main-container">
            <div class="pd-ltr-20 xs-pd-20-10">
                <div class="min-height-200px">
                    <div class="page-header">
                        <div class="row">
                            <div class="col-md-6 col-sm-12">
                                <div class="title">
                                    <h4>Habitacion</h4>
                                </div>
                                <nav aria-label="breadcrumb" role="navigation">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Cancelar habitación</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>

                    <!-- Contenedor seccion de formulario y tabla-->
                    <div class="pd-20 card-box mb-30">
                        <div class="clearfix">

                            <!--titulo contenedor-->
                            <div class="pull-left">
                                <h4 class="text-blue h4">Borrar habitación</h4>
                                <p class="mb-30">Ingresar un número de habitación para borrarla del sistema.</p>
                            </div>
                        </div>

                        <!-- formulario borrar una habitacion-->
                        <form>
                            <div class="row">
                                <div class="col-md-4 col-sm-12">
                                    <div class="form-group">
                                        <input type="text" nombre= "id_habitacion" class="form-control">
                                    </div>
                                </div>

                                <!--boton para editar -->
                                <div class="row">
                                    <div class="col-md-4 col-sm-12 text-center">
                                        <!-- Button para  borrar  y activa un modal -->
                                        <button  class="btn btn-primary text-center" type="button" data-toggle="modal" data-target="#confirmation-modal">
                                            BORRAR
                                        </button>
                                    </div>

                                    <!-- Modal -->
                                    <div class="modal fade" id="confirmation-modal" tabindex="-1" role="dialog" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered" role="document">
                                            <div class="modal-content">
                                                <div class="modal-body text-center font-18">
                                                    <h4 class="padding-top-30 mb-30 weight-500">¿Esta seguro que desea borrar esto?</h4>
                                                    <div class="padding-bottom-30 row" style="max-width: 170px; margin: 0 auto;">
                                                        <div class="col-6">
                                                            <button type="button" class="btn btn-secondary border-radius-100 btn-block confirmation-btn" data-dismiss="modal"><i class="fa fa-times"></i></button>
                                                            NO
                                                        </div>
                                                        <div class="col-6">
                                                            <button type="button" class="btn btn-primary border-radius-100 btn-block confirmation-btn" data-dismiss="modal"><i class="fa fa-check"></i></button>
                                                            SI
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form> <!--fin formulario-->



                        <!-- la tabla -->
                        <div class="pd-20 card-box mb-30">
                            <div class="clearfix mb-20">
                                <div class="pull-left">
                                    <h4 class="text-blue h4">Tabla habitaciones existentes</h4>
                                </div>
                                <!--boton para recargar la pagina-->
                                <div class="pull-right">
                                    <button type="button" class="btn btn-primary text-center" onclick = "location.reload();">
                                        <i class="icon-copy ion-refresh"></i> Recargar lista </button>  
                                </div>
                            </div>

                            <table class="table  table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">Número</th>
                                        <th scope="col">Piso</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Tipo</th>
                                        <th scope="col">Precio</th>
                                        <th scope="col">Disponibilidad</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        HttpSession miSesion = request.getSession();
                                        /*
                                        List<Habitacion> listaHabitacion = (List) request.getSession().getAttribute("lista_habitacion");

                                        for (Habitacion hab : listaHabitacion) {
                                            int id_habitacion =hab.getNro_habitacion();
                                            int nro_piso = hab.getNroPiso();
                                            String nombre_hab= hab.getNombre_habitacion();
                                            String tipo = hab.dameTipo();
                                            double precio = hab.damePrecio();
                                        
                                            String badge_esta_disponible = "";
                                            String mensaje_esta_disponible = " ";
                                        
                                            if (!hab.isEsta_reservada()) {
                                                    badge_esta_disponible = "badge badge-success";
                                                    mensaje_esta_disponible = "Esta disponible";
                                                } else {
                                                    badge_esta_disponible = "badge badge-danger";
                                                    mensaje_esta_disponible = "Reservada";
                                                }
                                         */
                                    %>
                                    <tr>
                                        <th><% %></th>
                                        <td><%  %> </td>
                                        <td><% %> </td>
                                        <td><% %> </td>
                                        <td>$ <%  %></td>
                                        <td><span class="badge badge-success">Disponible</span></td>
                                        <td><button type="submit" class="btn boton"><i class="dw dw-delete-3"></i></button></td>
                                    </tr>
                                    <% //}%>
                                </tbody>
                            </table>



                        </div>
                    </div><!-- fin contenedor del formulario y tabla-->
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

