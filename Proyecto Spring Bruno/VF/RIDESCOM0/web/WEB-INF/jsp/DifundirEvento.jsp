<%-- 
    Document   : difundirevento
    Created on : 27/05/2019, 03:56:50 PM
    Author     : Carlos A. Rosales
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title> Difundir evento </title>

        <!--Jquery -->
        <script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery-ui/jquery-ui.min.js"></script>
	<link rel="stylesheet"href="resources/js/jquery-ui/jquery-ui.min.css">
	<link rel="stylesheet" href="resources/js/jquery-ui/jquery-ui.structure.min.css">
	<link rel="stylesheet"  href="resources/js/jquery-ui/jquery-ui.theme.min.css">
        
	<!-- Mis scripts -->
        <script type="text/javascript" src="resources/js/mainfb.js"></script>

	<!-- Bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

	<!-- JS en bootstrap  -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<!-- CSS en bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

	<!-- Moment js  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/locale/es.js"></script>
        
        <!-- referencias para el calendario -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />

	<!-- referencias para el calendario -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
        
        <style>
            /*****************************************
            * Autor: Rosales Gonz�lez Carlos Andr�s *
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
            * Dise�o para buscador *
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
        </style>
</head>
<body>
<script>
  window.fbAsyncInit = function() {
    FB.init({
      appId      : '{569609143783510}',
      cookie     : true,
      xfbml      : true,
      version    : '{v4.0}'
    });
      
    FB.AppEvents.logPageView();   
      
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "https://connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
   
   
FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
});


{
    status: 'connected',
    authResponse: {
        accessToken: '...',
        expiresIn:'...',
        signedRequest:'...',
        userID:'...'
    }
}


</script>
    <div id="fb-root"></div>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v5.0&appId=569609143783510&autoLogAppEvents=1"></script>
<section id="global">
	<div id="titulo">
            <h1> Difundir evento interpolit�cnico deportivo </h1>
        </div>
        <h2 id="titulo">Consulta los eventos para publicar</h2>
        <div class="container">
            <div class="col-row-12">
                <div class="fb-login-button" data-width="" data-size="large" data-button-type="continue_with" data-auto-logout-link="true" data-use-continue-as="true"></div>
                <div class="flexsearch">
                            <div class="flexsearch--wrapper">
                                <form class="flexsearch--form" id="searchTerm" placeholder="Buscar" type="text" onkeyup="doSearch()" />
                                    <div class="flexsearch--input-wrapper">
                                        <input type="text" id="search" placeholder="Buscar..." title="Busqueda Rapida" class="form-control">
                                    </div>
                                </form>    
                            </div>
                    </div>
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col"> Nombre del evento </th>
                            <th scope="col"> Deporte </th>
                            <th scope="col"> Fecha del evento </th>
                            <th scope="col"> Lugar del evento </th>
                            <th scope="col"> Ciclo </th>
                            <th></th>
                            <!--<th></th>-->
                        </tr>
                    </thead>
                    <tbody id="datos">
                    <c:forEach var="e" items="${even}">
                        <tr>
                                                            <td>${e.Nombre_Evento}</td>
                                                            <td>${e.Disciplina}</td>
                                                            <td>${e.FE}</td>
                                                            <td>${e.Nombre_S}</td>
                                                            <td>${e.Ciclo_Escolar}</td>
<!--                                                            <td>${e.Prueba} </td>
                                                            <td>${e.Lugar_Obtenido}</td>
                                                            <td>${e.Marca}</td>-->
                                                            <td>
                                                                    <button type="button" class="btn btn-outline-info"> RIDESCOM </button>
                                                            </td>
                                                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="../Coordinador.html" class="btn btn-light float-right login_btn"> Volver </a>
            </div>
        </div>
    <script>
	// Load the SDK asynchronously
	  (function(d, s, id) {
	    var js, fjs = d.getElementsByTagName(s)[0];
	    if (d.getElementById(id)) return;
	    js = d.createElement(s); js.id = id;
	    js.src = "//connect.facebook.net/en_US/sdk.js";
	    fjs.parentNode.insertBefore(js, fjs);
	  }(document, 'script', 'facebook-jssdk'));
	 </script>
</section>
</body>
<script>
var $rows = $('#datos tr');
$('#search').keyup(function() {
    var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();
    
    $rows.show().filter(function() {
        var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
        return !~text.indexOf(val);
    }).hide();
});

</script>
</html>