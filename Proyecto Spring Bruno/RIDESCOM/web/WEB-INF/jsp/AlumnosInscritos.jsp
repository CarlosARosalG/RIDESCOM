<%-- 
    Document   : ingresaresultados
    Created on : 27/05/2019, 04:53:38 PM
    Author     : Carlos A. Rosales
--%>

<%@page import="java.sql.*"%>
<%@page import="mx.ipn.escom.ridescom.config.Connect"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="utf-8">
        <title> Consulta alumnos inscritos </title>

        <!--Jquery -->
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui/jquery-ui.min.js"></script>
        <link rel="stylesheet"href="js/jquery-ui/jquery-ui.min.css">
        <link rel="stylesheet" href="js/jquery-ui/jquery-ui.structure.min.css">
        <link rel="stylesheet"  href="js/jquery-ui/jquery-ui.theme.min.css">
        <!-- Moment js  -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/locale/es.js"></script>

        <!-- Mis scripts -->
        <script type="text/javascript" src="js/main.js"></script>

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
</head>
<body>
    <section id="global">
        <div id="titulo">
            <h1> Consulta a alumnos inscritos </h1>
        </div>

        <div class="col-12 ">
            <div id="noti" class="alert alert-light" role="alert">
                <p> 
                    Selecciona la unidad académica, el deporte y el ciclo escolar en el que participó.
                </p>
            </div>
        </div>

        <!-- Formulario --> 
            <div class="form-row">
                <div class="col-md-5 mb-3">
                    <label for="validationTooltip03">Deporte</label>
                    <select id="deporte" class="custom-select" >
                        <option value="" >Selecciona un deporte</option>
                        <%
                    try {
                        String query = "select * from Act_Deportiva";
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connect conn = new Connect();
                        Statement stm = conn.Connect().createStatement();
                        ResultSet rs = stm.executeQuery(query);
                        while (rs.next()) {
                %>
                <option value="<%=rs.getInt("ID_Deporte")%>"><%=rs.getString("Disciplina")%></option>
                <%
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        out.println("Error: " + ex.getMessage());
                    }
                %>
                    </select>
                    <div class="invalid-feedback">
                        Selecciona un deporte
                    </div>
                </div>
                <div class="col-md-5 mb-3">
                    <label for="validationTooltip03">Ciclo Escolar</label>
                    <select id="deporte" class="custom-select" >
                    <option value="">Ciclo Escolar</option>
                    <%
                    try {
                        String query = "select * from Ciclo";
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connect conn = new Connect();
                        Statement stm = conn.Connect().createStatement();
                        ResultSet rs = stm.executeQuery(query);
                        while (rs.next()) {
                %>
                <option value="<%=rs.getInt("ID_Ciclo")%>"><%=rs.getString("Ciclo_Escolar")%></option>
                <%
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        out.println("Error: " + ex.getMessage());
                    }
                %>
                </select>
                    <div class="invalid-feedback">
                        Selecciona un ciclo escolar
                    </div>
                </div>
            </div>
            <div class="clearfix" >&nbsp;</div>
        <div class="clearfix" >&nbsp;</div>

        <div class="container">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col"> Nombre </th>
                            <th scope="col"> Boleta </th>
                            <th scope="col"> Evento </th>
                            <th scope="col"> Deporte </th>
                            <th scope="col"> Ciclo Escolar </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ins" items="${ins}">
                        <tr>
                            <td>${ins.Nombre}</td>
                            <td>${ins.ID_Alumno}</td>
                            <td>${ins.Nombre_Evento}</td>
                            <td>${ins.Disciplina}</td>
                            <td>${ins.Ciclo_Escolar}</td>

                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>	
        </div>

        
        <h2 id="titulo">Cédula de Inscripción</h2>
        <div class="col-12 ">
            <div id="noti" class="alert alert-light col-6" role="alert">
                <p> 
                    Para descargar la cédula de inscripción, selecciona el deporte.
                    Posteriormente oprime el Generar Cédula.
                    Guarda el archivo en formato PDF.
                </p>
            </div>
        </div>
        <form name="form1" method="POST" target="_black"><!--action="CedulaInscripcion.java"-->
            <label for="validationTooltip05"> Deporte </label>
            <div class="col-md-3 mb-3">
                <select name="iddeporte" id="selectsport" class="custom-select" style="width: 380px;" required/>
                <option value="">Deporte</option>
                <%
                    try {
                        String query = "select * from Act_Deportiva";
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connect conn = new Connect();
                        Statement stm = conn.Connect().createStatement();
                        ResultSet rs = stm.executeQuery(query);
                        while (rs.next()) {
                %>
                <option value="<%=rs.getInt("ID_Deporte")%>"><%=rs.getString("Disciplina")%></option>
                <%
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        out.println("Error: " + ex.getMessage());
                    }
                %>
                </select>
                <div class="invalid-feedback">
                    Ingresa un deporte
                </div>
            </div>
            <input name="btn" value="Generar" type="submit" class="btn btn-light float-leftt login_btn">
        </form>
            <a href="../Coordinador.html" class="btn btn-light float-right login_btn"> Volver </a>
    </section>
</body>

<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict';
        window.addEventListener('load', function () {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function (form) {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>

</html>
