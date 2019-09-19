<%-- 
    Document   : Coordinador
    Created on : 24/04/2019, 03:42:44 PM
    Author     : Carlos A. Rosales
--%>

<%@page import="java.sql.*"%>
<%@page import="mx.ipn.escom.ridescom.config.Connect"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<head>
	<meta charset="utf-8">
	<title> Coordinador </title>

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

	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui/jquery-ui.min.js"></script>
	<link rel="stylesheet"href="js/jquery-ui/jquery-ui.min.css">
	<link rel="stylesheet"  href="js/jquery-ui/jquery-ui.structure.min.css">
	<link rel="stylesheet"  href="js/jquery-ui/jquery-ui.theme.min.css">
        

	<!-- Moment js  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/locale/es.js"></script>

	<!-- Mis scripts -->
	<script type="text/javascript" src="js/main.js"></script>

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
	</head>
</head>
<body id="fon">
	<section id="global">

	<!-- Cabecera -->
		<header>
			<div id="logoi">
				<img src="img/ridescom.jpg" width="500">
			</div>
			<div class="clearfix">	
			</div>
		</header>
	<!-- Menú -->
		<nav id="bar">
			<ul>
                                <li><a href="#calendario"><span class="tercero"><i class="fas fa-calendar"></i></span> Eventos </a></li>
				<li><a href="#resultados"><span class="cuarto"><i class="fas fa-poll"></i></span> Resultados </a></li>
                                <li><a href="Coordinador/Cedulas"><span class="primero"><i class="fas fa-sign-in-alt"></i></span> Cedulas de inscripción </a></li>
<!--				<li><a href="#"><span class="segundo"><i class="fas fa-calendar"></i></span> Registrate </a></li>-->
				<li><a href="Coordinador/ConsultaInscritos"><span class="quinto"><i class="fas fa-sign-in-alt"></i></span> Consulta Inscritos </a></li>
				<li><a href="Coordinador/DifundirEvento"><span class="sexto"><i class="fas fa-address-book"></i></span> Difundir evento </a></li>
                                <li><a href="#"><span class="septimo"><i class="fas fa-user"></i></span> Perfil </a>
					<ul>
						<li><a href="#"> ${Nombre_U} </a></li>
						<li><a href="#"> Correo </a></li>
                                                <li>
                                                    <a href="Logout">Salir</a>
                                                </li>
					</ul>
				</li>
<!--				<li><a href="#"><span class="septimo"><i class="fas fa-user"></i></span> Contacto </a>
					<ul>
						<li><a href="#"> Inicia sesión </a></li>
						<li><a href="#"> Ingresa resultados </a></li>
						<li><a href="#"> Registra un entrenador </a></li>
						<li><a href="#"> Item #4 </a></li>
						<li><a href="#"> Item #5 </a></li>
					</ul>
				</li>-->
			</ul>
		</nav>
			
	<!-- Calendario -->
                <a name="calendario" id="Contacto"></a>
		<h2 id="titulo">Lista de eventos Por realizar</h2>
			<div class="container">
				<div class="col-row-8">
					<!-- The second value will be selected initially -->
                                        <select name="select" id="selectsport" class="custom-select" style="width: 380px;">
					  <option value="">Seleccione Deporte</option>
                                                    <%
                                                        try{
                                                            String query="select * from Act_Deportiva";
                                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                            Connect conn = new Connect();
                                                            Statement stm=conn.Connect().createStatement();
                                                            ResultSet rs=stm.executeQuery(query);
                                                            while(rs.next()){
                                                                %>
                                                                <option value="<%=rs.getInt("ID_Deporte")%>"><%=rs.getString("Disciplina")%></option>
                                                                <%
                                                            }
                                                            
                                                        }catch(Exception ex)
                                                        {
                                                            ex.printStackTrace();
                                                            out.println("Error: "+ex.getMessage());
                                                        }
                                                    %>
                                                </select>
				</div>
			</div>
                        <div class="clearfix" >&nbsp;</div>
			<div class="container">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
<!--								<th scope="col"> ID </th>-->
								<th scope="col"> Evento </th>
                                                                <th scope="col"> Deporte </th>
								<th scope="col"> Inicio Registro </th>
								<th scope="col"> Limite Registro </th>
                                                                <th scope="col"> Lugar </th>
                                                                <th scope="col"> Fecha del Evento </th>
                                                                <th scope="col"> Ciclo Escolar</th>
								<th scope="col"> Direccion </th>
								<th scope="col"> Punto de Referencia </th>
								<th scope="col"> Descripcion </th>    
							</tr>
						</thead>
						<tbody>
                                                    <c:forEach var="ev" items="${eve}">
                                                        <tr>
<!--                                                            <td>${ev.Evento_ID}</td>-->
                                                            <td>${ev.Nombre_Evento}</td>
                                                            <td>${ev.Disciplina}</td>
                                                            <td>${ev.Fecha_inicio_Registro}</td>
                                                            <td>${ev.Fecha_fin_Registro}</td>
                                                            <td>${ev.Lugar_del_evento}</td>
                                                            <td>${ev.Fecha_evento}</td>
                                                            <td>${ev.Ciclo_Escolar}</td>
                                                            <td>${ev.Direccion}</td>
                                                            <td>${ev.P_referencia}</td>
                                                            <td>${ev.Descripcion}</td>
                                                            
                                                        </tr>
                                                    </c:forEach>
						</tbody>
					</table>
				</div>	
			</div>

	<!-- Resultados --> 	
                <a name="resultados" id="Contacto"></a>
		<h2 id="titulo">Consulta los resultados</h2>
                <div id="agregaboton">
                    <label> Para agregar un nuevo resultado pulsa aquí: </label>
                    <a href="ingresaresultados.htm" style='text-decoration:none;color: #777620; align-content: right;'> 
                        <i class="far fa-plus-square"></i> 
                    </a> 
                </div>
		<div class="container">
                    <div class="col-row-8">
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
								<th scope="col"> Boleta </th>
								<th scope="col"> Escuela </th>
								<th scope="col"> Deporte </th>
								<th scope="col"> Sub-división </th>
								<th scope="col"> Posición </th>
								<th scope="col"> Prueba </th>
								<th scope="col"> Marca </th>
                                                                <th scope="col">  </th>
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
                                                                <td> 
                                                                    <a href="editaresultados.htm" style='text-decoration:none;color: #0174DF;'> 
                                                                        <i class="far fa-edit"></i>  
                                                                    </a> 
                                                                </td>
                                                                <td> 
                                                                    <a href="Registracord.htm" style='text-decoration:none;color: #ed3237;'> 
                                                                        <i class="far fa-trash-alt"></i> 
                                                                    </a> 
                                                                </td>
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
                
                <!-- Entrenadores -->
                <a name="calendario" id="Contacto"></a>
		<h2 id="titulo">Entrenadores</h2>
                    <div id="agregaboton">
                        <label> Para agregar un nuevo entrenador pulsa aquí: </label>
                        <a href="Coordinador/AgregarEntrenador" style='text-decoration:none;color: #777620; align-content: right;'> 
                            <i class="far fa-plus-square"></i> 
                        </a> 
                    </div>
			<div class="container">
				<div class="col-row-8">
					<!-- The second value will be selected initially -->
                                        
				</div>
			</div>
                        <div class="clearfix" >&nbsp;</div>
			<div class="container">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col"> Deporte </th>
								<th scope="col"> Nombre </th>
<!--                                                                <th scope="col"> Sexo </th>
                                                                <th scope="col"> Nacimiento </th>
                                                                <th scope="col"> CURP </th>
                                                                <th scope="col"> NSS </th>
                                                                <th scope="col"> Procedencia </th>
                                                                <th scope="col"> Municipio </th>-->
                                                                <th scope="col"> Correo </th>
								<th scope="col"> Telefono fijo </th>
								<th scope="col"> Celular </th>
                                                                <th scope="col">  </th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="en" items="${ent}">
                                                        <tr>
                                                            <td>${en.Disciplina}</td>
                                                            <td>${en.Nombre}</td>
<!--                                                            <td>${en.Sexo}</td>
                                                            <td>${en.Fecha_Nac}</td>
                                                            <td>${en.CURP}</td>
                                                            <td>${en.NSS}</td>
                                                            <td>${en.Estado}</td>
                                                            <td>${en.Municipio}</td>-->
                                                            <td>${en.Correo}</td>
                                                            <td>${en.telefono}</td>
                                                            <td>${en.Celular}</td>

                                                            <td> 
                                                                    <a href="Coordinador/EditarEntrenador?EntrenadorID=${en.ID_Persona}" style='text-decoration:none;color: #0174DF;'> 
                                                                        <i class="far fa-edit"></i>  
                                                                    </a> 
                                                            </td>
                                                            <td> 
                                                                    <a href="Coordinador/BorrarEntrenador?EntrenadorID=${en.ID_Persona}" style='text-decoration:none;color: red;'> 
                                                                        <i class="far fa-trash-alt"></i>  
                                                                    </a> 
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
						</tbody>
					</table>
				</div>	
			</div>
        <div class="clearfix" >&nbsp;</div>    
        <div class="clearfix" >&nbsp;</div>

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
		
	<div class="clearfix" >&nbsp;</div>
</body>
<script>
    $(document).ready(function () {

    $('#selectsport').change(function () {
        var values = [];
        $('#selectsport option:selected').each(function () {
            if ($(this).val() != "") values.push($(this).text());
        });
        filter('table > tbody > tr', values);
    });
    $('#selectsport1').change(function () {
        var values = [];
        $('#selectsport1 option:selected').each(function () {
            if ($(this).val() != "") values.push($(this).text());
        });
        filter('table > tbody > tr', values);
    });

    function filter(selector, values) {
        $(selector).each(function () {
            var sel = $(this);
            var tokens = sel.text().split('\n');
            var toknesObj = [], i;
            for(i=0;i<tokens.length;i++){
                toknesObj.push( {text:tokens[i].trim(), found:false});
            }
            
            var show = false;
            console.log(values);
            $.each(values, function (i, val) {
                
                for(i=0;i<toknesObj.length;i++){                    
                    if (!toknesObj[i].found && toknesObj[i].text.search(new RegExp("\\b"+val+"\\b")) >= 0) {
                        toknesObj[i].found = true;
                    }
                }
            });          
            
            var count = 0;
             $.each(toknesObj, function (i, val) {
                 if (val.found){
                     count+=1;
                 }
             });
            show = (count === values.length);        
            show ? sel.show() : sel.hide();
        });
    }
});
</script>
</html>