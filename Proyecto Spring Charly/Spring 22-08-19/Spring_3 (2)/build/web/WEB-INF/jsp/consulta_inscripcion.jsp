<%-- 
    Document   : consulta_inscripcion
    Created on : 24/04/2019, 11:47:56 AM
    Author     : Carlos A. Rosales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
Autor: Rosales González Carlos Andrés
Fecha: 25/02/19
Titulo: Consutla Inscripciones
Funciones: Servirá para que el alumno visualice en una tabla los eventos a los que se ha registrado
-->
<!DOCTYPE html>
<html lang="es">
<head>
	<head>
	<meta charset="utf-8">
	<title> Consulta resultados </title>

	<!-- Estilos CSS 
	<link rel="stylesheet" type="text/css" href="css/styles.css">-->
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
               background: #0f0c29;  
                   background: -webkit-linear-gradient(to right, #24243e, #302b63, #0f0c29);
                   background: linear-gradient(to right, #24243e, #302b63, #0f0c29); 
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
                   left: 100px;
                   width: 640px;
           }

           .slider-home {
                   height: 100%;
                   left: 0;
                   top: 0;
                   width: 340px;
           }

            .carousel-inner {
                   background: rgba(216, 216, 216, 0.75);
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
               height: 60px;
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
                   background:#0101DF;
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
        </style>

	<!--Jquery -->

        <script type="text/javascript" src="../../js/jquery-ui/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="../../js/jquery-ui/jquery-ui.min.js"></script>
        <link rel="stylesheet"  href="../../css/jquery-ui.css">
        <link rel="stylesheet" href="../../css/jquery-ui.min.css">
        <link rel="stylesheet"  href="../../css/jquery-ui.structure.css">
	<link rel="stylesheet" href="../../css/jquery-ui.structure.min.css">
        <link rel="stylesheet"  href="../../css/jquery-ui.theme.css">
	<link rel="stylesheet"  href="../../css/jquery-ui.theme.min.css">
        

	<!-- Moment js  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/locale/es.js"></script>

	<!-- Mis scripts -->
	<script type="text/javascript" src="../../js/main.js"></script>

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

	</head>
</head>
<body id="fon">
	<section id="global">

	<!-- Cabecera -->
                <section>
			<div class="clearfix" >&nbsp;</div>
			<h2 id="titulo">Eventos inscritos</h2>
				<div class="container">
					<div class="table-responsive">
						<div class="clearfix" >&nbsp;</div>
                                                <div class="col-12 ">
                                                    <div id="noti" class="alert alert-light col-5" role="alert">
                                                        <p> Aquí podrás visualizar los eventos a los que te has registrado en el semestre actual. </p>
                                                    </div>
                                                </div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col"> Nombre </th>
									<th scope="col"> Boleta </th>
									<th scope="col"> Escuela </th>
									<th scope="col"> Deporte </th>
									<th scope="col"> Sub-división </th>
									<th scope="col"> Prueba </th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th>Fila 1</th>
									<td>Fila 1 Columna 1</td>
									<td>Fila 1 Columna 2</td>
									<td>Fila 1 Columna 2</td>
									<td>Fila 1 Columna 2</td>
									<td>Fila 1 Columna 2</td>
								</tr>
								<tr>
									<th>Fila 2</th>
									<td>Fila 2 Columna 1</td>
									<td>Fila 2 Columna 2</td>
									<td>Fila 1 Columna 2</td>
									<td>Fila 1 Columna 2</td>
									<td>Fila 1 Columna 2</td>
								</tr>
							</tbody>
						</table>

						<input type="submit" value="Regresar" href="principal.htm" class="btn btn-outline-info float-right login_btn">
                        <div class="clearfix" >&nbsp;</div>
					</div>	
				</div>
		</section>
	
		<div class="clearfix" >&nbsp;</div>
		<div class="clearfix" >&nbsp;</div>
	</section>
</body>
</html>