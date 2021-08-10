

<%@page import="Logica.Usuario"%>
<%@page import="Logica.Habitacion"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
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
        <link rel="stylesheet" type="text/css" href="vendors/styles/style.css">

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
                                    <h4>Reservas</h4>
                                </div>
                                <nav aria-label="breadcrumb" role="navigation">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">Nueva reserva</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>

                    <!-- Contenedor para la tabla -->
                    <div class="pd-20 card-box mb-30">
                        <div class="clearfix">
                            <!--titulo contenedor-->
                            <div class="pull-left">
                                <h4 class="text-blue h4">Formulario para las reservas</h4>
                                <p class="mb-30">Elegir una de las habitaciones disponibles y seguir completando el formulario.</p>
                            </div>
                        </div>


                        <div class="pb-20">
                            <table class="table">

                                <thead>
                                    <tr>
                                        <th scope="col">Número</th>
                                        <th scope="col">Piso</th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Tipo</th>
                                        <th scope="col">Precio</th>
                                        <th scope="col">Disponibilidad</th>

                                    </tr>
                                </thead>

                                <tbody>
                                    <%
                                        //ver si es necesario crear una sesion por cada JSP
                                        HttpSession miSesion = request.getSession();
                                        List<Habitacion> lista = (List) request.getSession().getAttribute("lista_hab_disponible");

                                        for (Habitacion hab : lista) {
                                            int id = hab.getNro_habitacion();
                                            int nro_piso = hab.getNroPiso();
                                            String nombre_hab = hab.getNombre_habitacion();
                                            String tipo = hab.dameTipo();
                                            double precio = hab.damePrecio();

                                    %>
                                    <tr>
                                        <th><%= id%></th>
                                        <td><%= nro_piso%></td>
                                        <td><%= nombre_hab%></td>
                                        <td><%= tipo%></td>
                                        <td>$ <%= precio%></td>
                                        <td>
                                            <span class= "badge badge-success">Esta disponible
                                            </span>
                                        </td>


                                    </tr>
                                    <% }%>
                                </tbody>

                            </table> <!-- fin tabla consulta-->
                        </div>
                    </div><!-- fin contenedor del formulario y tabla-->


                    <!-- Contenedor para el formulario-->
                    <div class="pd-20 card-box mb-30">
                        <div class="clearfix">
                            <!--titulo contenedor-->
                            <div class="pull-left">
                                <h4 class="text-blue h4">Formulario para las reservas</h4>
                                <p class="mb-30">Seguir completando el formulario.</p>
                            </div>
                        </div>


                        <!-- Aqui empieza el formulario de reservas -->
                      
                        <form action ="ServAltaReservaHuespedNuevo" method = "POST">
                            <!-- Datos para la Habitacion -->
                            <div class="clearfix">
                                <div class="pull-left">
                                    <h5 class="text-blue h5">Datos de la habitacion y fechas para reservala </h5>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-12 col-md-2 col-form-label">Nro Habitacion</label>
                                <div class="col-sm-12 col-md-10">
                                     <!--levantamos los numeros de la habitaciones disponibles-->
                                    <select required class="custom-select col-12"  name = "nro_habitacion">
                                       <%
                            
                                         for (Habitacion hab : lista) {  
                                            int nro_habitacion = hab.getNro_habitacion();
                                         %>
                                         
                                        <option value = "<%=nro_habitacion %>" name = "nro_habitacion" ><%=hab.getNro_habitacion()   %>- <%= hab.getNombre_habitacion() %> - <%= hab.getTipo_habitacion().getTipo() %></option>
                                        <% } 
                                        
                                        
                                        %> 
                                    </select>
                                </div>
                            </div>

                            <!--fechas para la reserva -->
                            <%

                                String fecha_in = (String) request.getSession().getAttribute("fecha_ingreso");
                                String fecha_eg = (String) request.getSession().getAttribute("fecha_egreso");
                                int cant_personas = (int) request.getSession().getAttribute("cant_personas");

                            %>

                            <div class="form-group row">
                                <label class="col-sm-12 col-md-2 col-form-label">Fecha ingreso</label>
                                <div class="col-sm-12 col-md-10">
                                    <input readonly  class="form-control " name = "fecha_ingreso"  value="<%=fecha_in%>" type="text">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-12 col-md-2 col-form-label">Fecha egreso</label>
                                <div class="col-sm-12 col-md-10">
                                    <input readonly class="form-control" name = "fecha_egreso" value= "<%=fecha_eg%>" type="text">
                                </div>
                            </div>


                            <div class="form-group row">
                                <label class="col-sm-12 col-md-2 col-form-label">Cantidad de personas</label>
                                <div class="col-sm-12 col-md-10">
                                    <input readonly class="form-control" name = "cant_personas" value= "<%= cant_personas%>"  type = "text">
                                </div>
                            </div> 

                            <!--datos huesped-->
                            <div class="clearfix">
                                <div class="pull-left">
                                    <h5 class="text-blue h5">Datos del huesped</h5>
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-12 col-md-2 col-form-label">Nombre</label>
                                <div class="col-sm-12 col-md-10">
                                    <input required class="form-control" type="text" name= "nombre" placeholder="Maria">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-12 col-md-2 col-form-label">Apellido</label>
                                <div class="col-sm-12 col-md-10">
                                    <input required class="form-control" type="text" name= "apellido" placeholder=" Brown">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-12 col-md-2 col-form-label">Dni</label>
                                <div class="col-sm-12 col-md-10">
                                    <input class="form-control" type="number" name= "dni" placeholder="dni sin puntos">
                                </div>
                            </div>

                            <!--fechas nacimiento-->
                            <div class="form-group row">
                                <label class="col-sm-12 col-md-2 col-form-label">Fecha de Nacimiento</label>
                                <div class="col-sm-12 col-md-10">
                                    <input class="form-control date-picker"  name = "fecha_nac" placeholder="Seleccionar fecha" type="text">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-12 col-md-2 col-form-label">Profesión</label>
                                <div class="col-sm-12 col-md-10">
                                    <input required class="form-control" type="text" name= "profesion" placeholder=" una profesion">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label class="col-sm-12 col-md-2 col-form-label">Dirección</label>
                                <div class="col-sm-12 col-md-10">
                                    <input required class="form-control" type="text"name ="direccion" placeholder="los pinos 6521">
                                </div>
                            </div>


                            <!--campo ID vendedor-->
                            <div class="clearfix">
                                <div class="pull-left">
                                    <h5 class="text-blue h5">Dato del vendedor</h5>
                                </div>
                            </div>
                            
                            <div class="form-group row">
                                <label class="col-sm-12 col-md-2 col-form-label">Id de usuario del empleado que hace la reserva</label>
                                <div class="col-sm-12 col-md-10">
                                    <input class="form-control" type="text" name="id_usuario" placeholder="id del usuario actual (<%= request.getSession().getAttribute("usuario_sesion")%>)">
                                </div>
                            </div>

                            <!--botones para enviar o resetear todo el formulario -->
                            <div class="form-group row">
                                <div class="col-lg-12 p-t-20 text-center">
                                    <input class="btn btn-primary" type="submit" value="Enviar">
                                </div>
                            </div>
                        </form>

                        <!--fin fomrulario-->

                    </div>


                </div> <!-- fin contenedor principal-->

                 <!--Footer-->
                <div class="footer-wrap pd-20 mb-20 card-box">
                    Hotel Napoli - Hotel Napoli Admin Template By <a href="https://github.com/millieunl"
                                                                     target="_blank">Maria Emilia Corbetta</a>
                </div>

            </div>
        </div>

        <!-- js  generales-->
        <script src="vendors/scripts/core.js"></script>
        <script src="vendors/scripts/script.min.js"></script>
        <script src="vendors/scripts/process.js"></script>
        <script src="vendors/scripts/layout-settings.js"></script>
        <script src="vendors/scripts/fix.js"></script>

        <!--js especiales para la tabla-->
        <script src="src/plugins/datatables/js/jquery.dataTables.min.js"></script>
        <script src="src/plugins/datatables/js/dataTables.bootstrap4.min.js"></script>
        <script src="src/plugins/datatables/js/dataTables.responsive.min.js"></script>
        <script src="src/plugins/datatables/js/responsive.bootstrap4.min.js"></script>
        <script src="src/plugins/datatables/js/vfs_fonts.js"></script>

        <!-- js Setting para la tabla -->
        <script src="vendors/scripts/mitabla-setting.js"></script>

    </body>

</html>
