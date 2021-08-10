
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Basic Page Info -->
        <meta charset="utf-8">
        <title>Hotel Napoli</title>

        <!-- Site favicon -->
        <link rel="apple-touch-icon" sizes="180x180" href="vendors/images/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="vendors/images/favicon1-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="vendors/images/favicon1-16x16.png">

        <!-- Mobile Specific Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="vendors/styles/core.css">
        <link rel="stylesheet" type="text/css" href="vendors/styles/icon-font.min.css">
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
    <body class="login-page">
        <!--header del login-->
        <div class="login-header box-shadow">
            <div class="container-fluid d-flex justify-content-between align-items-center">
                <!--imagen del logo-->
                <div class="brand-logo">
                    <a href="login.jsp">
                        <img src="vendors/images/napoli-logo3-white.svg" alt="">
                    </a>
                </div>
            </div>
        </div>

        <!-- contenedor del login -->
        <div class="login-wrap d-flex align-items-center flex-wrap justify-content-center">
            <div class="container">
                <!--contendor para la imagen-->
                <div class="row align-items-center">
                    <div class="col-md-6 col-lg-7 mb-30">
                        <img src="vendors/images/login-page-img1.png" alt="">
                    </div>

                    <!--contenedor para formulario -->
                    <div class="col-md-6 col-lg-5">
                        <div class="login-box bg-white box-shadow border-radius-10">
                            <!--titulo-->
                            <div class="login-title">
                                <h2 class="text-center text-primary">Iniciar sesión Hotel Napoli</h2>
                            </div>

                            <!--formulario-->
                            <form action = "ServLogin" method="POST">
                                
                                <!--campo usuario-->
                                <div class="input-group custom">
                                    <input required type="text" class="form-control form-control-lg" name="usuario_sesion" placeholder="usuario">
                                    <div class="input-group-append custom">
                                        <span class="input-group-text"><i class="icon-copy dw dw-user1"></i></span>
                                    </div>
                                </div>
                                
                                <!--campo contraseña-->
                                <div class="input-group custom">
                                    <input required type="password" class="form-control form-control-lg" name = "contrasenia" placeholder="contraseña ">
                                    <div class="input-group-append custom">
                                        <span class="input-group-text"><i class="dw dw-padlock1"></i></span>
                                    </div>
                                </div>

                                <!-- boton submit para el formulario-->
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="input-group mb-0">
                                            <!--
                                                    use code for form submit--> 
                                            <input class="btn btn-primary btn-lg btn-block" type="submit" value="Iniciar sesión">

                                        </div>
                                    </div>
                                </div><!--fin boton submit-->

                            </form><!-- fin formulario login-->
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- js -->
        <script src="vendors/scripts/core.js"></script>
        <script src="vendors/scripts/script.min.js"></script>
        <script src="vendors/scripts/process.js"></script>
        <script src="vendors/scripts/layout-settings.js"></script>

    </body>
</html>
