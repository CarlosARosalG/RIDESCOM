<%-- 
    Document   : Usuarios
    Created on : 9/08/2019, 02:51:20 PM
    Author     : spy51
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.*"%>
<%@page import="mx.com.ridescom.config.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- Moment js  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/locale/es.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        
        <script src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.8.5/chosen.jquery.min.js"></script>

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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persona</title>
    </head>
    <body>
        <section id="global">
		<div id="titulo">
			<h1> Registra información personal</h1>
		</div>

		<div class="col-12 ">
			<div id="noti" class="alert alert-danger col-6" role="alert">
			<p> 
			  Ingresa los datos del coordinador de la Unidad Académica.
			  * Llena todos los campos.
			</p>
			</div>
		</div>

		<!-- Formulario --> 
                <form class="needs-validation" novalidate>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label for="validationTooltip03"><i class="fas fa-user"></i> Nombre </label>
                            <input type="text" id="validationTooltip03" class="form-control" placeholder="Nombre" maxlength="30" required/>
                            <div class="invalid-feedback">
                                Ingresa un nombre
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationTooltip04"><i class="fas fa-user"></i> Apellido Paterno </label>
                            <input type="text" id="validationTooltip04" class="form-control" placeholder="Apellido Paterno" maxlength="20" required/>
                            <div class="invalid-feedback">
                                Ingresa un apellido
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationTooltip05"><i class="fas fa-user"></i> Apellido Materno </label>
                            <input type="text" id="validationTooltip05" class="form-control" placeholder="Apellido Materno" maxlength="20" required/>
                            <div class="invalid-feedback">
                                Ingresa un apellido
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationTooltip06"><i class="fas fa-envelope"></i> Correo electrónico </label>
                            <input type="text" id="validationTooltip06" class="form-control" placeholder="Correo electrónico" maxlength="40" required/>
                           <div class="invalid-feedback">
                                Ingresa un correo electrónico
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationTooltip07"><i class="fas fa-phone-volume"></i> Teléfono fijo </label>
                            <input type="text" id="validationTooltip07" class="form-control" placeholder="Teléfono fijo" maxlength="10" required/>
                            <div class="invalid-feedback">
                                Ingresa un telefóno
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationTooltip08"><i class="fas fa-mobile"></i> Teléfono móvil </label>
                            <input type="text" id="validationTooltip08" class="form-control" placeholder="Teléfono móvil" maxlength="10" required/>
                            <div class="invalid-feedback">
                                Ingresa un telefóno
                            </div>
                        </div>
                        
                        <div class="col-md-4 mb-3">
                            <label for="validationTooltip08"><i class="fas fa-mobile"></i> CURP </label>
                            <input type="text" id="validationTooltip08" class="form-control" placeholder="Teléfono móvil" maxlength="10" required/>
                            <div class="invalid-feedback">
                                Ingresa un telefóno
                            </div>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="validationTooltip08"><i class="fas fa-mobile"></i> NSS </label>
                            <input type="text" id="validationTooltip08" class="form-control" placeholder="Teléfono móvil" maxlength="10" required/>
                            <div class="invalid-feedback">
                                Ingresa un telefóno
                            </div>
                        </div>
                        
                        <div class="col-md-4 mb-3">
                            <label for="validationTooltip03">Sexo</label>
                            <div class="col-md-4 mb-3">
                            <select name="select" style="width: 100px;">
                                                    <%
                                                        try{
                                                            String query="select * from Tipo_Sexo";
                                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                            Conexion conn = new Conexion();
                                                            Statement stm=conn.Conexion().createStatement();
                                                            ResultSet rs=stm.executeQuery(query);
                                                            while(rs.next()){
                                                                %>
                                                                <option value="<%=rs.getInt("ID_Tipo_Sexo")%>"><%=rs.getString("Sexo")%></option>
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
                                                
                        <div class="col-md-4 mb-3">
                            <label for="validationTooltip03">Residencia Actual (municipio)</label>
                            <div id="myDropdown" class="col-md-4 mb-3">
                                <input type="text" id="searchFilter" name="searchFilter" placeholder="Search" onkeyup="filterItems(this);" style="width: 200px;">
                            <select id="selectsearch" name="selectsearch" style="width: 200px;">
                                
                                                    <%
                                                        try{
                                                            String query="select * from Municipio order by Municipio ASC";
                                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                            Conexion conn = new Conexion();
                                                            Statement stm=conn.Conexion().createStatement();
                                                            ResultSet rs=stm.executeQuery(query);
                                                            while(rs.next()){
                                                                %>
                                                                <option value="<%=rs.getInt("ID_Municipio")%>"><%=rs.getString("Municipio")%></option>
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
                        
                        <div class="col-md-4 mb-3">
                            <label for="validationTooltip03">Entidad Federativa (de nacimiento)</label>
                            <div class="col-md-4 mb-3">
                            <select name="select" style="width: 200px;">
                                                    <%
                                                        try{
                                                            String query="select * from Estados order by Estado ASC";
                                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                            Conexion conn = new Conexion();
                                                            Statement stm=conn.Conexion().createStatement();
                                                            ResultSet rs=stm.executeQuery(query);
                                                            while(rs.next()){
                                                                %>
                                                                <option value="<%=rs.getInt("ID_Estado")%>"><%=rs.getString("Estado")%></option>
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
                    </div>
                    <div class="clearfix" >&nbsp;</div>
                    <button type="submit" class="btn  btn-outline-success "> Registrar </button>
                    <a href="principalJFD.htm"style='text-decoration:none;color: #FFFFFF;'> <button type="button" class="btn btn-outline-danger"> Cancelar </button></a>
                </form>
		<div class="clearfix" >&nbsp;</div>
                
                <a name="usuarios" id="Contacto"></a>
		<h2 id="titulo">Usuarios</h2>
                        <div class="clearfix" >&nbsp;</div>
			<div class="container">
				<div class="table-responsive">
					<table id="tabla" class="table table-hover">
						<thead>
							<tr>
								<th scope="col"> ID</th>
                                                                <th scope="col"> Usuario </th>
                                                                <th scope="col">  </th>
							</tr>
						</thead>
						<tbody>
                                                    <c:forEach var="dato" items="${users}">
                                                    <tr>
                                                        <td>${dato.Usuario_ID}</td>
                                                        <td>${dato.Nombre_U}</td>
                                                                <td> 
                                                                    <a href=# style='text-decoration:none;color: #0174DF;'> 
                                                                        <i class="far fa-edit"></i>  
                                                                    </a> 
                                                                </td>
                                                                <td> 
                                                                    <a href=# style='text-decoration:none;color: red;'>
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
	</section>

<script>
 jQuery.fn.filterByText = function(textbox) {
  return this.each(function() {
    var select = this;
    var options = [];
    $(select).find('option').each(function() {
      options.push({
        value: $(this).val(),
        text: $(this).text()
      });
    });
    $(select).data('options', options);

    $(textbox).bind('change keyup', function() {
      var options = $(select).empty().data('options');
      var search = $.trim($(this).val());
      var regex = new RegExp(search, "gi");

      $.each(options, function(i) {
        var option = options[i];
        if (option.text.match(regex) !== null) {
          $(select).append(
            $('<option>').text(option.text).val(option.value)
          );
        }
      });
    });
  });
};

// You could use it like this:

$(function() {
  $('select#selectsearch').filterByText($('input#searchFilter'));
});
</script>
    </body>
</html>
