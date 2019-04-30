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
	<title> Principal </title>

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
                   width: 65%;
                   margin: 0px auto;
                   margin-top: 30px;
                   background: white;
                   padding: 20px;
                   box-shadow: 0px 0px 50px gray;
                   text-align: center;
                   font-size: 20px;
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

           /************
            * Bar menu *
           ************/

           #menu {
                   font-family: "Helvitica", "Arial";
                   background: #667db6;
                   background: -webkit-linear-gradient(to bottom, #667db6, #0082c8, #0082c8, #667db6);
                   background: linear-gradient(to bottom, #667db6, #0082c8, #0082c8, #667db6);
                   width: 100%;
                   text-transform: uppercase;
                   margin-bottom: 20px;
           }
           #menu ul {
                   line-height: 46px;
                   list-style: none;
           }

           #menu li {
                   height: 46px;
                   display: inline-block;
                   transition: all 300ms;
           }

           #menu a {
                   display: block;
                   color: white;
                   text-decoration: none;
                   padding-left: 30px;
                   padding-right: 30px;
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


           /************************
            * Diseño para buscador *
           ************************/


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

           body {
               margin:0;
               padding:0;
               font-family:sans-serif;
               background:#002b38;
           }
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
<body>

	<!-- Cabecera -->
		<header>
			<div id="logo">
				<h1> RIDESCOM </h1>
			</div>


			<div class="clearfix">
				
			</div>

			<nav id="menu" class="navbar navbar-expand-lg navbar-light bg-light">
			  <a class="navbar-brand" href="#">Inicio</a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			  <div class="collapse navbar-collapse" id="navbarNavDropdown">
			    <ul class="navbar-nav">
			      <li class="nav-item">
			        <a class="nav-link" href="Calen">Calendario</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="Resul">Resultados</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="iniciosesion.htm">Inicia Sesión</a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="Contac">Contacto</a>
			      </li>
			      <li class="nav-item dropdown">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Coordinador
			        </a>
			        <div id="menu" class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
			          <a class="dropdown-item" href="#">Registra</a>
			          <a class="dropdown-item" href="#">Modifica</a>
			          <a class="dropdown-item" href="#">Contraseña</a>
			        </div>
			      </li>
			    </ul>
			  </div>
			</nav>


		</header>

	<!-- Carosel -->
	<section>
		<h2 id="titulo">Deportes en la ESCOM</h2>
			
				<div class="row justify-center">
					<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
						    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="5"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="6"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="7"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="8"></li>
						    <li data-target="#carouselExampleIndicators" data-slide-to="9"></li>
			  			</ol>
			  			<div id="carouselExampleIndicators" class="carousel-inner">
			    			<div class="carousel-item active">
						      <img src="img/ajedrez.png" class="d-block w-50" alt="Ajedrez">
						      <div class="panel-overlay">
					              <h2>Ajedrez</h2>
					              <p>l ajedrez es un juego entre dos personas, cada una de las cuales dispone de 16 piezas móviles que se colocan sobre un tablero​ dividido en 64 casillas o escaques.​<br/>
					          </div>
			    			</div>
			    			<div class="carousel-item">
						      <img src="img/baloncesto.png" class="d-block w-50" alt="Baloncesto">
						      <div class="panel-overlay">
					              <h2>Baloncesto</h2>
					              <p>es un deporte en el cual compiten dos equipos de cinco jugadores cada uno.<br/>
					          </div>
			    			</div>
			    			<div class="carousel-item">
						      <img src="img/barras.png" class="d-block w-50" alt="Barras">
						      <div class="panel-overlay">
					              <h2>Barras</h2>
					              <p>Do you want to know the possible routes to get to know the center of Coyoacan?<br/>
					          </div>
			    			</div>
			    			<div class="carousel-item">
						      <img src="img/beisbol.png" class="d-block w-50" alt="Beisbol">
						      <div class="panel-overlay">
					              <h2>Beisbol</h2>
					              <p>Do you want to know the possible routes to get to know the center of Coyoacan?<br/>
					          </div>
			    			</div>
			    			<div class="carousel-item">
						      <img src="img/futbol.png" class="d-block w-50" alt="Futbol">
						      <div class="panel-overlay">
					              <h2>Futbol</h2>
					              <p>Do you want to know the possible routes to get to know the center of Coyoacan?<br/>
					          </div>
			    			</div>
			    			<div class="carousel-item">
						      <img src="img/sucem.png" class="d-block w-50" alt="Sucem">
						      <div class="panel-overlay">
					              <h2>Sucem</h2>
					              <p>Do you want to know the possible routes to get to know the center of Coyoacan?<br/>
					          </div>
			    			</div>
			    			<div class="carousel-item">
						      <img src="img/taekwondo.png" class="d-block w-50" alt="Taekwondo">
						      <div class="panel-overlay">
					              <h2>Taekwondo</h2>
					              <p>Do you want to know the possible routes to get to know the center of Coyoacan?<br/>
					          </div>
			    			</div>
			    			<div class="carousel-item">
						      <img src="img/tenisdemesa.png" class="d-block w-50" alt="Tenis de mesa">
						      <div class="panel-overlay">
					              <h2>Tenis de mesa</h2>
					              <p>Do you want to know the possible routes to get to know the center of Coyoacan?<br/>
					          </div>
			    			</div>
			    			<div class="carousel-item">
						      <img src="img/tochobandera1.png" class="d-block w-50" alt="Tocho bandera">
						      <div class="panel-overlay">
					              <h2>Tocho bandera</h2>
					              <p>Do you want to know the possible routes to get to know the center of Coyoacan?<br/>
					          </div>
			    			</div>
			    			<div class="carousel-item">
						      <img src="img/voleibol.png" class="d-block w-50" alt="Voleibol">
						      <div class="panel-overlay">
					              <h2>Voleibol</h2>
					              <p>Do you want to know the possible routes to get to know the center of Coyoacan?<br/>
					          </div>
			    			</div>
			    			<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
							    <span class="carousel-control-prev-icon" ></span>
							    <span class="sr-only"> Anterior </span>
			  				</a>
			  				<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
							    <span class="carousel-control-next-icon" aria-hidden="true"></span>
							    <span class="sr-only"> Siguiente </span>
							</a>
			  			</div>
					</div>
				</div>
			
		

	<!-- Calendario -->
		<h2 id="titulo">Calendario de eventos</h2>
			<div id="Calen" class="container">
				<div class="col-row-12">
					<!-- The second value will be selected initially -->
					<select name="select">
					  <option value="value1" selected> Selecciona un deporte </option> 
					  <option value="value2"> Ajedrez </option>
					  <option value="value3"> Baloncesto </option>
					  <option value="value3"> Barras </option>
					  <option value="value3"> Beisbol </option>
					  <option value="value3"> Futbol </option>
					  <option value="value3"> Sucem </option>
					  <option value="value3"> Taekwondo </option>
					  <option value="value3"> Tenis de mesa </option>
					  <option value="value3"> Tocho bandera </option>
					  <option value="value3"> Voleibol </option>
					</select>
				</div>
			</div>
			<div class="container">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col"> Nombre </th>
                                                                <th scope="col"> Escuela </th>
								<th scope="col"> Deporte </th>
								<th scope="col"> Sub-división </th>
								<th scope="col"> Fecha del evento </th>
                                                                <th scope="col"> Lugar del evento </th>
								<th scope="col"> Descripción </th>
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
								<td>Fila 1 Columna 2</td>
								<td>Fila 1 Columna 2</td>
							</tr>
							<tr>
								<th>Fila 2</th>
								<td>Fila 2 Columna 1</td>
								<td>Fila 1 Columna 2</td>
								<td>Fila 1 Columna 2</td>
								<td>Fila 1 Columna 2</td>
								<td>Fila 1 Columna 2</td>
								<td>Fila 1 Columna 2</td>
							</tr>
						</tbody>
					</table>
				</div>	
			</div>

	<!-- Resultados --> 		
		
                <h2 id="titulo">Consulta los resultados</h2>
		<div id="Resul" class="container">
				<div class="col-row-12">
					<div class="flexsearch">
						<div class="flexsearch--wrapper">
							<form class="flexsearch--form" action="#" method="post">
								<div class="flexsearch--input-wrapper">
									<input class="flexsearch--input" type="search" placeholder="Busca un deporte">
								</div>
								<input class="flexsearch--submit" type="submit" value="&#10140;"/>
							</form>
						</div>
					</div>
				</div>
			
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col"> Nombre </th>
                                                                <%--<th scope="col"> Boleta </th> --%>
								<th scope="col"> Escuela </th>
								<th scope="col"> Deporte </th>
                                                                <%--<th scope="col"> Sub-división </th> --%>
								<th scope="col"> Prueba </th>
                                                                <th scope="col"> Posición </th>
								<th scope="col"> Marca </th>
							</tr>
						</thead>
						<tbody>
							<tr>
                                                                <th> ${Persona} </th>
								<td> ${Escuela} </td>
								<td> ${Deporte}</td>
								<td> ${Prueba} </td>
                                                <c:forEach var="dat" items="${Resultado}">
								<td> ${dat.Lugar_Obtenido} </td>
								<td> ${dat.Marca} </td>
                                                </c:forEach>
							</tr>
							<tr>
								<th>Fila 2</th>
								<td>Fila 2 Columna 1</td>
								<td>Fila 2 Columna 2</td>
								<td>Fila 1 Columna 2</td>
								<td>Fila 1 Columna 2</td>
								<td>Fila 1 Columna 2</td>
								<td>Fila 1 Columna 2</td>
								<td>Fila 1 Columna 2</td>
							</tr>
						</tbody>
					</table>
				</div>
		</div>


	<!-- Contacto -->
		<div id="Contac" class="container">
			<div class="cuadro">
				<div class="box">
					<div class="icon"><i class="fa fa-map-marker" aria-hidden="true"></i></div>
					<div class='details'><h3>ESCOM</h3></div>
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
		<div class="clearfix" >&nbsp;</div>
	</section>

</body>
</html>