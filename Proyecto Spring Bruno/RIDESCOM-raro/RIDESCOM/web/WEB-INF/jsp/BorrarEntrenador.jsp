<%-- 
    Document   : registroentrenador
    Created on : 27/05/2019, 04:06:39 PM
    Author     : Carlos A. Rosales
--%>

<%@page import="java.sql.*"%>
<%@page import="mx.ipn.escom.ridescom.config.Connect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<head>
	<meta charset="utf-8">
	<title> Registra un entrenador </title>


	<!--Jquery -->
	<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="C:/Users/Carlos A. Rosales/Documents/IPN/RIDESCOM/js/jquery-ui/jquery-ui.min.js"></script>
	<link rel="stylesheet"href="C:/Users/Carlos A. Rosales/Documents/IPN/RIDESCOM/js/jquery-ui/jquery-ui.min.css">
	<link rel="stylesheet" " href="C:/Users/Carlos A. Rosales/Documents/IPN/RIDESCOM/js/jquery-ui/jquery-ui.structure.min.css">
	<link rel="stylesheet"  href="C:/Users/Carlos A. Rosales/Documents/IPN/RIDESCOM/js/jquery-ui/jquery-ui.theme.min.css">

	<!-- Moment js  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/locale/es.js"></script>

	<!-- Mis scripts -->
	<script type="text/javascript" src="js/main.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.full.min.js"></script>

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
        
        <style>
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

           ::-webkit-input-value {
                   color: #888;  
           }

           input:-moz-value {
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
        </style>
</head>
<body>
	<section id="global">
		<div id="titulo">
			<h1> Elimina un entrenador </h1>
		</div>

		<div class="col-12 ">
			<div id="noti" class="alert alert-dark col-4" role="alert">
			  <p> Elimina a un entrenador que labore en la Unidad Acádemica. </p>
			  <p> Recuerda verificar todos los datos antes de concluir. </p>
			</div>
		</div>

		<!-- Formulario --> 
		<form class="needs-validation" novalidate method="POST">
                    <label>ID_Persona: ${per[0].ID_Persona}</label>
                        <div class="form-row">
		    	
			    <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Nombre </label>
				    <input type="text" class="form-control" id="validationTooltip02" name="Nombre" value="${per[0].Nombre}" disabled/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
				</div>
			    <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Apellido Paterno </label>
				    <input type="text" class="form-control" id="validationTooltip02" name="Appat" value="${per[0].Ap_Pat}" disabled/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
			    <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Apellido Materno </label>
				    <input type="text" class="form-control" id="validationTooltip02" name="Apmat" value="${per[0].Ap_Mat}" disabled/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> CURP </label>
				    <input type="text" class="form-control" id="validationTooltip02" name="CURP" value="${per[0].CURP}" disabled/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> NSS </label>
				    <input type="text" class="form-control" id="validationTooltip02" name="NSS" value="${per[0].NSS}" disabled/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Sexo </label>
				    <input name="Sexo" class="form-control" value="${per[0].Sexo}" style="width: 100px;" disabled/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Estado </label>
				    <input type="text" class="form-control" id="validationTooltip02" value="${per[0].Estado}" name="Estado" disabled/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Municipio </label>
				    <input type="text" class="form-control" id="validationTooltip02" value="${per[0].Municipio}" disabled/>
                                    
                                    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Fecha de Nacimiento </label>
				    <input type="text" class="form-control" id="validationTooltip02" name="Nacimiento" value="${per[0].Fecha_Nac}" disabled/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Correo </label>
                                    <input type="text" class="form-control" id="validationTooltip02" name="Correo" value="${per[0].Correo}" disabled/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
			    <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Teléfono de contacto </label>
                                    <input type="text" class="form-control" id="validationTooltip02" name="Tel_fijo" value="${per[0].Telefono}" disabled/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Teléfono Móvil (Opcional) </label>
                                    <input type="text" class="form-control" id="validationTooltip02" name="Tel_cel" value="${per[0].Celular}" disabled/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
			</div>

			<div class="form-row">    

				<div class="col-md-5 mb-3">
					<label for="validationTooltip03">Deporte</label>
					<input type="text" class="form-control" id="validationTooltip02" name="Tel_cel" value="${per[0].Disciplina}" disabled/>
				</div>
		  	</div>
                        <a href="ConfirmaBorrarEntrenador?EntrenadorID=${per[0].ID_Persona}" type="submit" value="Eliminar" class="btn btn-success">Eliminar</a>
<!--		  	<button type="submit" class="btn  btn-outline-success "> Borrar </button>-->
		  	<a href="../../Entrenadores"style='text-decoration:none;color: #FFFFFF;'> <button type="button" class="btn  btn-outline-danger"> Cancelar </button></a>
		</form>
	</section>

</body>
</html>