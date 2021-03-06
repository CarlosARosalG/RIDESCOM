<%-- 
    Document   : principal
    Created on : 24/04/2019, 03:42:44 PM
    Author     : Carlos A. Rosales
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
Autor: Rosales González Carlos Andrés
Fecha: 25/02/19
Titulo: Principal
Funciones: Será la vista gerenal para los alumnos
-->
<!DOCTYPE html>
<html lang="es">
    <head>
    <head>
        <meta charset="utf-8">
        <title> Coordinador </title>

        <!-- Estilos CSS -->
        <style type="text/css">
            /*****************************************
            * Autor: Rosales González Carlos Andrés *
            * Titulo: Hoja de estilos 				 *
            ****************************************/

            .clearfix {
                float: none;
                clear: both;
            }

            #global {
                width: 80%;
                margin: 0px auto;
                margin-top: 30px;
                margin-bottom: 30px;
                background: white;
                padding: 20px;
                box-shadow: 0px 0px 50px gray;
            }

            body {
                background: #000046;
                background: -webkit-linear-gradient(to bottom, #1CB5E0, #000046);
                background: linear-gradient(to bottom, #1CB5E0, #000046);

                /* background-image: url(../img/fondo.jpg); */
            }

            .subir {
                color: white;
                text-decoration: none;
                display: block;
                float: right;
            }

            footer {
                font-family: "Helvitica", "Arial";
                color: white;
                background: rgba(51, 51, 51, 0.70);
                line-height: 47px;
                width: 80%;
                height: 80px;
                margin: 0px auto;
                margin-top: 30px;
                padding: 20px;
                margin-bottom: 30px;
            }

            #texto {
                text-align: center;
            }

            #titulo {
                text-align: center;
                font-family: "Verdana", "Arial";
            }

            #logo {
                font-family: "Verdana", "Arial";
                font-size: 28px;
                letter-spacing: 4px;
                line-height: 80px;
                color: white;
                width: auto;
                height: auto;
                text-transform: uppercase;
                text-align: center;
                background: #667db6;
                background: -webkit-linear-gradient(to bottom, #667db6, #0082c8, #0082c8, #667db6);
                background: linear-gradient(to bottom, #667db6, #0082c8, #0082c8, #667db6);
            }

            #logoi {
                text-align: center;
            }

            #agregaboton {
                text-align: right;
            }

            /************************
             * Diseño para buscador *
            ************************/

            #slidebar {
                font-family: "Helvitica", "Arial";
                width: 50%;
                float: all;
            }

            #slidebar h4 {
                margin-top: 50px;
                margin-bottom: 20px;
                text-align: center;
                line-height: 10px;
                color: #333;
                background: url('../img/negro.jpg') repeat-x;
            }

            #slidebar h4 span {
                background: white;
                padding: 5px;
            }

            #slidebar img {
                width: 100%;
            }

            #slidebar p {
                font-size: 15px;
                text-align: justify;
            }

            form input[type="text"],
            form input[type="pasword"],
            form input[type="email"],
            form input[type="number"],
            select {
                font-family: "Verdana", "Arial";
                font-size: 12px;
                text-align: center;
                padding: 5px;
                border-radius: 5px;
                border: 1px solid #ccc;
                width: 80%;
                box-shadow: 0px 0px 2px gray;
                margin-top: 5px;
                margin-bottom: 5px;
            }

            /***********************
             * Essential Structure *
             ***********************/
            .flexsearch--wrapper {
                height: 20%;
                width: 60%;
                max-width: 80%;
                overflow: hidden;
                background: transparent;
                margin: 0;
                position: static;
            }

            .flexsearch--form {
                overflow: hidden;
                position: relative;
            }

            .flexsearch--input-wrapper {
                padding: 0 66px 0 0; /* Right padding for submit button width */
                overflow: hidden;
            }

            .flexsearch--input {
                width: 100%;
            }

            /***********************
             * Configurable Styles *
             ***********************/
            .flexsearch {  
                padding: 0 5px 0 30px; /* Padding for other horizontal elements */
            }

            .flexsearch--input {
                -webkit-box-sizing: content-box;
                -moz-box-sizing: content-box;
                box-sizing: content-box;
                height: 30px;
                padding: 0 46px 0 10px;
                border-color: #667db6;
                border-radius: 35px; 
                border-style: solid;
                border-width: 5px;
                margin-top: 15px;
                color: #333;
                font-family: 'Helvetica', sans-serif;
                font-size: 16px;
                -webkit-appearance: none;
                -moz-appearance: none;
            }

            .flexsearch--submit {
                position: absolute;
                right: 0;
                top: 0;
                display: block;
                width: 50px;
                height: 50px;
                padding: 0;
                border: none;
                margin-top: 6px; /* margin-top + border-width */
                margin-right: 3px; /* border-width */
                background: transparent;
                color: #667db6;
                font-family: 'Helvetica', sans-serif;
                font-size: 40px;
                line-height: 60px;
            }

            .flexsearch--input:focus {
                outline: none;
                border-color: #333;
            }

            .flexsearch--input:focus.flexsearch--submit {
                color: #333; 
            }

            .flexsearch--submit:hover {
                color: #333;
                cursor: pointer;
            }

            ::-webkit-input-placeholder {
                color: #888;  
            }

            input:-moz-placeholder {
                color: #888
            }

            .h1 {
                float: left;
                margin: 25px;
                color: #333;
                font-family: 'Helvetica', sans-serif;
                font-size: 45px;
                font-weight: bold;
                line-height: 45px;
                text-align: center;
            }


            /**********************
             * Medios de Contacto *
             *********************/

            .cuadro {
                width:800px;
                margin:50px auto 0;
                display:flex;
            }
            .cuadro .box {
                position:relative;
                width: 300px;
                height:100px;
                box-sizing:border-box;
                text-align:center;
                margin:0 10px;
                background:#00171d;
                overflow:hidden;
                border-radius:4px;
                box-shadow:0 0 0 2px rgba(0,7,10,1);
            }
            .cuadro .box .icon {
                width:100%;
                height:100%;
                background: #000046;
                background: -webkit-linear-gradient(to bottom, #1CB5E0, #000046);
                background: linear-gradient(to bottom, #1CB5E0, #000046);
                transition: 0.5s;
            }
            .cuadro .box .icon .fa {
                font-size: 4em;
                line-height:100px;
                color: #FFFFFF;
            }
            .cuadro .box:hover .icon {
                transform:scale(0);
            }
            .cuadro .box .details {
                position:absolute;
                top:0;
                left:0;
                right:0;
                width:100%;
                height:100%;
                background:#03a9f4;
                transition:0.5s;
                transform:scale(2);
                opacity:0;
            }
            .cuadro .box:hover .details {
                transform:scale(1);
                opacity:1;
            }
            .cuadro .box .details h3 {
                margin:0;
                padding:0;
                line-height:100px;
                font-size:24px;
                color:#fff;
            }
            .cuadro .box .details:nth-child(2) .details {
                background:#e91e63;
            }
            .cuadro .box .details:nth-child(2) .details {
                background:#607d8b;
            }


            /************
             * Carousel *
             ***********/

            #slider-home {
                margin-bottom: 50px;
            }

            #carouselExampleIndicators{
                width: 80%;
                margin: 0px auto;
                margin-top: 20px;
                margin-bottom: 30px;
                background: white;
                padding: 20px;
            }

            .slider-home {
                height: 100%;
                left: 0;
                top: 0;
                width: 340px;
            }

            .carousel-inner {
                background: rgba(255, 255, 255, 0.55);
                height: 100%;
                left: 0;
                top: 0;
                padding: 30px 45px;
                text-align: left;
                width: 340px;
            }

            .carousel-item img {
                display: block;
                max-width: 100%;
                height: auto;
                margin: 0 auto;
            }

            .carousel-control-prev-icon {
                background: black;
                margin-top: 100px;
                width: 10px;
            }



            * {
                margin:0;
                padding:0;
            }

            /*EN EL VIDEO HAY UN ERROR POR EL CUAL NO SE VISUALIZA EN GOOGLE CHROME,
            EL CÓDIGO A CONTINUACIÓN YA ESTA CORREGIDO*/

            header {
                margin-top:10px;
                width: 100%;
                overflow: hidden;
                height: 100px;
                position: relative;
            }

            #bar {
                margin-top:3px;
                width: 100%;
                overflow: hidden;
                height: 150px;
                position: relative;
            }

            nav {
                top:-20px;
                position: absolute;
                left:0;
                right:0;
                margin:20px auto;
                max-width:1000px;
                width:90%;
            }

            nav ul {
                list-style:none;
            }

            nav > ul {
                display:table;
                width:100%;
                background:#000;
                position:relative;
            }

            nav > ul li {
                display:table-cell;
            }

            /*Sub-menu*/
            nav > ul > li:hover > ul {
                display:block;
                height:100%;
            }

            nav > ul > li > ul {
                display:block;
                position:absolute;
                background:#000;
                left:0;
                right:0;
                overflow:hidden;
                height:0%;
                -webkit-transition: all .3s ease;
                -moz-transition: all .3s ease;
                -ms-transition: all .3s ease;
                -o-transition: all .3s ease;
                transition: all .3s ease;
            }

            nav > ul li a {
                color:#fff;
                display:block;
                line-height:20px;
                padding:20px;
                position: relative;
                text-align:center;
                text-decoration:none;
                -webkit-transition: all .3s ease;
                -moz-transition: all .3s ease;
                -ms-transition: all .3s ease;
                -o-transition: all .3s ease;
                transition: all .3s ease;
            }

            nav > ul > li > ul > li a:hover {
                background:#FFFFFF;
            }

            #Usuario {
                right: auto;
                text-color: #DE1426;
                align-content: right;
                text-align: right;
            }

            nav > ul > li > a span {
                background:#174459;
                display:block;
                height:100%;
                width:100%;
                left:0;
                position:absolute;
                top:-55px;
                -webkit-transition: all .3s ease;
                -moz-transition: all .3s ease;
                -ms-transition: all .3s ease;
                -o-transition: all .3s ease;
                transition: all .3s ease;
            }

            nav > ul > li > a span .fas {
                display:block;
                line-height:60px;
            }

            nav > ul > li > a:hover > span {
                top:0;
            }

            /*Colores*/
            nav ul li a .primero {
                background:#0e5061;
            }

            nav ul li a .segundo {
                background:#5da5a2;
            }

            nav ul li a .tercero {
                background:#f25724;
            }

            nav ul li a .cuarto {
                background:#174459;
            }

            nav ul li a .quinto {
                background:#37a4d9;
            }

            nav ul li a .sexto {
                background:#0174DF;
            }

            nav ul li a .septimo {
                background: #0101DF;
            }

            /************
             * TIMELINE *
             ***********/
            .timeline {
                position: relative;
            }
            /*Ajuste de la linea del centro*/
            .timeline::before {
                content: '';
                background: #C5CAE9;
                width: 10px;
                height: 95%;
                position: absolute;
                left: 50%;
                transform: translateX(-50%);
            }
            /*Ajuste del ancho de los cuadros*/
            .timeline-item {
                width: 90%;
                margin-bottom: 70px;
            }
            .timeline-item:nth-child(even) .timeline-content {
                float: right;
                padding: 40px 30px 10px 30px;
            }
            .timeline-item:nth-child(even) .timeline-content .date {
                right: auto;
                left: 0;
            }
            .timeline-item:nth-child(even) .timeline-content::after {
                content: '';
                position: absolute;
                border-style: solid;
                width: 0;
                height: 0;
                top: 30px;
                left: -15px;
                border-width: 10px 15px 10px 0;
                border-color: transparent #f5f5f5 transparent transparent;
            }
            .timeline-item::after {
                content: '';
                display: block;
                clear: both;
            }

            .timeline-content {
                position: relative;
                width: 45%;
                padding: 10px 30px;
                border-radius: 4px;
                background: #f5f5f5;
                box-shadow: 0 20px 25px -15px rgba(0, 0, 0, 0.3);
            }
            .timeline-content::after {
                content: '';
                position: absolute;
                border-style: solid;
                width: 0;
                height: 0;
                top: 30px;
                right: -15px;
                border-width: 10px 0 10px 15px;
                border-color: transparent transparent transparent #f5f5f5;
            }

            .timeline-img {
                width: 30px;
                height: 30px;
                background: #3F51B5;
                border-radius: 50%;
                position: absolute;
                left: 50%;
                margin-top: 25px;
                margin-left: -15px;
            }

            .timeline-card {
                padding: 0 !important;
            }
            .timeline-card p {
                padding: 0 20px;
            }
            .timeline-card a {
                margin-left: 20px;
            }

            .timeline-item:nth-child(2) .timeline-img-header {
                background: linear-gradient(transparent, rgba(0, 0, 0, 0.4)), url("https://hd.unsplash.com/photo-1458530970867-aaa3700e966d") center center no-repeat;
                background-size: cover;
            }
            .timeline-item:nth-child(5) .timeline-img-header {
                background: linear-gradient(transparent, rgba(0, 0, 0, 0.4)), url("https://hd.unsplash.com/photo-1444093826349-9ce8c622f4f3") center center no-repeat;
                background-size: cover;
            }
            .timeline-item:nth-child(6) .timeline-img-header {
                background: linear-gradient(transparent, rgba(0, 0, 0, 0.4)), url("https://hd.unsplash.com/photo-1471479917193-f00955256257") center center no-repeat;
                background-size: cover;
            }
            .timeline-item:nth-child(8) .timeline-img-header {
                background: linear-gradient(transparent, rgba(0, 0, 0, 0.4)), url("https://hd.unsplash.com/photo-1466840787022-48e0ec048c8a") center center no-repeat;
                background-size: cover;
            }
            .timeline-item:nth-child(10) .timeline-img-header {
                background: linear-gradient(transparent, rgba(0, 0, 0, 0.4)), url("https://hd.unsplash.com/photo-1447639703758-f525f36456bf") center center no-repeat;
                background-size: cover;
            }
            .timeline-item:nth-child(11) .timeline-img-header {
                background: linear-gradient(transparent, rgba(0, 0, 0, 0.4)), url("https://hd.unsplash.com/photo-1469429978400-082eec725ad5") center center no-repeat;
                background-size: cover;
            }

            .timeline-img-header {
                height: 200px;
                position: relative;
                margin-bottom: 20px;
            }
            .timeline-img-header h2 {
                color: #FFFFFF;
                position: absolute;
                bottom: 5px;
                left: 20px;
            }
            blockquote {
                margin-top: 30px;
                color: #757575;
                border-left-color: #3F51B5;
                padding: 0 20px;
            }
            .date {
                background: #FF4081;
                display: inline-block;
                color: #FFFFFF;
                padding: 10px;
                position: absolute;
                top: 0;
                right: 0;
            }
            @media screen and (max-width: 768px) {
                .timeline::before {
                    left: 50px;
                }
                .timeline .timeline-img {
                    left: 50px;
                }
                .timeline .timeline-content {
                    max-width: 100%;
                    width: auto;
                    margin-left: 70px;
                }
                .timeline .timeline-item:nth-child(even) .timeline-content {
                    float: none;
                }
                .timeline .timeline-item:nth-child(odd) .timeline-content::after {
                    content: '';
                    position: absolute;
                    border-style: solid;
                    width: 0;
                    height: 0;
                    top: 30px;
                    left: -15px;
                    border-width: 10px 15px 10px 0;
                    border-color: transparent #f5f5f5 transparent transparent;
                }
            </style>

            <!--Jquery -->

            <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
            <script type="text/javascript" src="js/jquery-ui/jquery-ui.min.js"></script>
            <link rel="stylesheet" href="js/jquery-ui/jquery-ui.min.css">
            <link rel="stylesheet"  href="js/jquery-ui/jquery-ui.structure.min.css">
            <link rel="stylesheet"  href="js/jquery-ui/jquery-ui.theme.min.css">

            <!-- Moment js  -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/locale/es.js"></script>

            <!-- Mis scripts -->
            <script type="text/javascript" src="js/main.js"></script>
            <script type="text/javascript" src="js/timeline1.js"></script>

            <!-- Slider -->
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
            <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

            <!-- Bootstrap  -->	
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <!-- JS en bootstrap  -->
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
            <!-- CSS en bootstrap -->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

            <!--Fontawesome CDN-->
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

            <!--TIME LINE-->
            <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
            <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
            <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

            <script type="text/javascript" src="js/addons-pro/timeline.js"></script>
        </head>
    </head>
    <body id="fon">
        <c:forEach var="p" items="${e}">
        <section id="global">

            <!-- Cabecera -->
            <header>
                <div id="logoi">
                    <img src="resources/img/ridescom.jpg" width="500">
                </div>
                <div class="clearfix">	
                </div>
            </header>
            <!-- Menú -->
            <nav id="bar">
                <ul>
                    <li><a href="#" style='text-decoration:none; color: #fff'><span class="primero"><i class="fas fa-user"></i></span> Perfil </a>
                        <ul id="Usuario">
                            <li><a href="#"style='text-decoration:none;'> ${Nombre_U}</a></li>
                            <li><a href="#"style='text-decoration:none;'> ${p.Correo} </a></li>
                            <li><a href="#"style='text-decoration:none;'> ${p.Nombre} ${p.Ap_pat} </a></li>
                            <li><a href="#Contacto"style='text-decoration:none;'><span class="sexto"></span> Contacto </a></li>
                            <li><a href="Logout.html" style='text-decoration:none;'>Salir</a></li>
                            
                        </ul>
                    </li>
                    <li><a href="Coordinador/Entrenadores.html" style='text-decoration:none; color: #fff'><span class="segundo"><i class="fas fa-users"></i></span> Entrenadores </a></li>
                    <li><a href="Coordinador/DifundirEvento.html"><span class="tercero" style='text-decoration:none; color: #fff'><i class="fas fa-share-alt"></i></span> Difundir Evento </a></li>
                    <li><a href="Coordinador/AlumnosInscritos.html"><span class="cuarto" style='text-decoration:none; color: #fff'><i class="fas fa-users"></i></span> Consulta Inscritos </a></li>
                    <li><a href="Coordinador/Cedulas.html"><span class="quinto" style='text-decoration:none; color: #fff'><i class="fas fa-book-open"></i></span> Cédulas de Inscripción </a></li>
                    <li><a href="Coordinador/Resultados.html" style='text-decoration:none; color: #fff'><span class="sexto"><i class="fas fa-poll"></i></span> Resultados </a></li>
                    
                </ul>
            </nav>


            <div class="container text-center">
                <h1>Eventos Interpolitécnicos Deportivos</h1>
            </div>

            <section class="timeline">
                <div class="container">
                    <c:forEach var="dato" items="${eve}">
                    <div class="timeline-item">
                        <div class="timeline-img"></div>
                        <script>
                            var today;
                            today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate()+1);
                            var condition = ${dato.Fecha_evento}>today;
                            $('#edita').toggle(condition);
                        </script>
                            <div class="timeline-content js--fadeInLeft">
                                <div class="clearfix">&nbsp;</div>
                                <h2>${dato.Nombre_Evento}</h2>
                                <div class="date">${dato.FE}</div>
                                <blockquote><u>Lugar del Evento</u>: ${dato.Nombre_S}</blockquote>
                                <blockquote><u>Período de inscripciones</u>: ${dato.FIR} / ${dato.FFR}</blockquote>
                                <blockquote><u>Descripción: </u><div class="clearfix">&nbsp;</div>
                                    ${dato.Descripcion}</blockquote>
                            </div>
                        <div class="clearfix">&nbsp;</div>
                    </div>    
                 </c:forEach>
                </div>
            </section>
            <script src='https://code.jquery.com/jquery-2.2.4.min.js'></script>
            <script src='https://cdn.jsdelivr.net/scrollreveal.js/3.3.1/scrollreveal.min.js'></script>


            <!-- Contacto -->
            <a name="Contacto" id="Contacto"></a>
            <div class="container">
                <div class="cuadro">
                    <div class="box">
                        <div class="icon"><i class="fa fa-map-marker" aria-hidden="true"></i></div>
                        <div class='details'>
                            <h3><a href='https://www.google.com.mx/maps/place/Escuela+Superior+de+Cómputo/@19.5046589,-99.1490405,17z/data=!3m1!4b1!4m5!3m4!1s0x85d1f835393528b5:0x5f2dd0563ce99e8!8m2!3d19.5046539!4d-99.1468518' style='text-decoration:none;color: #FFFFFF;'> 
                                    ESCOM - Actividades Deportivas
                                </a></h3>
                        </div>
                    </div>
                    <div class="box">
                        <div class="icon"><i class="fa fa-phone" aria-hidden="true"></i></div>
                        <div class='details'><h3>5512345678</h3></div>
                    </div>
                    <div class="box">
                        <div class="icon"><i class="fa fa-envelope" aria-hidden="true"></i></div>
                        <div class='details'><h3>prueba@gmail.com</h3></div>
                    </div>
                </div>
            </div>
            <div class="clearfix" >&nbsp;</div>
            <div class="clearfix" >&nbsp;</div>
        </section>

        <footer>
            Escuela Superior de Cómputo &copy;
            <a href="#" class="subir"> Ir arriba </a>
        </footer>
</c:forEach>
        <div class="clearfix" >&nbsp;</div>
    </body>
    <script>
        $(function(){

  window.sr = ScrollReveal();

  if ($(window).width() < 768) {

  	if ($('.timeline-content').hasClass('js--fadeInLeft')) {
  		$('.timeline-content').removeClass('js--fadeInLeft').addClass('js--fadeInRight');
  	}

  	sr.reveal('.js--fadeInRight', {
	    origin: 'right',
	    distance: '300px',
	    easing: 'ease-in-out',
	    duration: 800,
	  });

  } else {
  	
  	sr.reveal('.js--fadeInLeft', {
	    origin: 'left',
	    distance: '300px',
		  easing: 'ease-in-out',
	    duration: 800,
	  });

	  sr.reveal('.js--fadeInRight', {
	    origin: 'right',
	    distance: '300px',
	    easing: 'ease-in-out',
	    duration: 800,
	  });

  }
  
  sr.reveal('.js--fadeInLeft', {
	    origin: 'left',
	    distance: '300px',
		  easing: 'ease-in-out',
	    duration: 800,
	  });

	  sr.reveal('.js--fadeInRight', {
	    origin: 'right',
	    distance: '300px',
	    easing: 'ease-in-out',
	    duration: 800,
	  });


});
    </script>
</html>