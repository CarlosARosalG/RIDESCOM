<%-- 
    Document   : ingresaresultados
    Created on : 27/05/2019, 04:53:38 PM
    Author     : Carlos A. Rosales
--%>
<%@page import="java.sql.*"%>
<%@page import="mx.ipn.escom.ridescom.config.Connect"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title> Registrate como alumno </title>

	<!--Jquery -->

	<script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="resources/js/jquery-ui/jquery-ui.min.js"></script>
	<link rel="stylesheet"href="resources/js/jquery-ui/jquery-ui.min.css">
	<link rel="stylesheet" href="resources/js/jquery-ui/jquery-ui.structure.min.css">
	<link rel="stylesheet"  href="resources/js/jquery-ui/jquery-ui.theme.min.css">

	<!-- Mis scripts -->
	<script type="text/javascript" src="resources/js/main.js"></script>

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
        
        <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

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
</head>
<body>
	<section id="global">
		<div id="titulo">
			<h1> Registrate como usuario alumno para registrarte a los interpolit�cnicos</h1>
                        ${mjs}
		</div>

		<div class="col-12 ">
			<div id="noti" class="alert alert-light col-6" role="alert">
			<p> 
			  Verifica que no falte ning�n campo por completar antes de guardar la actualizaci�n de datos.
			</p>
                        <div>${nom} Por favor complete el formulario</div>
			</div>
		</div>

		<!-- Formulario --> 
                <form class="needs-validation" novalidate method="POST">
                    <div class="form-row">
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> CURP </label><span style="color: #ff0000">*</span>
				    <input type="text" class="form-control" id="curp_input" oninput="validarInput(this)" name="CURP" placeholder="CURP" minlength="18" maxlength="18" required/>
                                    <pre id="resultado"></pre>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> NSS (Opcional) </label>
				    <input type="text" class="form-control" id="validationTooltip02" name="NSS" placeholder="NSS" maxlength="45" />
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
                            <label for="validationTooltip03"> Fecha de Nacimiento </label><span style="color: #ff0000">*</span>
                            <input name="Nacimiento" type="text" class="form-control" id="datepicker" placeholder="YYYY-MM-DD" maxlength="10" required/>
                            <script>
                                 var today, datepicker;
                                today = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate()-1);
                                    datepicker = $('#datepicker').datepicker({
                                    uiLibrary: 'bootstrap4',
                                    maxDate: today,
                                    format: 'yyyy-mm-dd'
                                });
                            </script>
                        </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Sexo </label><span style="color: #ff0000">*</span>
                                    <br>
				    <select name="Sexo" class="custom-select" style="width: 150px;" required/>
					  <option value=""></option>
                                                    <%
                                                        try{
                                                            String query="select * from Tipo_Sexo";
                                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                            Connect conn = new Connect();
                                                            Statement stm=conn.Connect().createStatement();
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
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02">Municipio </label><span style="color: #ff0000">*</span>
<!--				    <input type="text" class="form-control" id="validationTooltip02" placeholder="Buscar..." required>-->
                                    <select name="municipio" id="mun" class="custom-select" style="width: 300px;" required/>
					  <option value="">Seleccione municipio</option>
                                                    <%
                                                        try{
                                                            String query="select * from Municipio m, Estados edo where m.Estados_ID_estado=edo.ID_estado order by Municipio ASC";
                                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                            Connect conn = new Connect();
                                                            Statement stm=conn.Connect().createStatement();
                                                            ResultSet rs=stm.executeQuery(query);
                                                            while(rs.next()){
                                                                %>
                                                                <option value="<%=rs.getString("ID_Municipio")%>"><%=rs.getString("Municipio")%>-<%=rs.getString("Estado")%></option>
                                                                <%
                                                            }
                                                            
                                                        }catch(Exception ex)
                                                        {
                                                            ex.printStackTrace();
                                                            out.println("Error: "+ex.getMessage());
                                                        }
                                                    %>
                                                </select>
                                    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Correo </label><span style="color: #ff0000">*</span>
                                    <input type="text" class="email form-control" id="validationTooltip02" name="Correo" placeholder="Correo" required/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
			    <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Tel�fono de contacto (minimo 8 d�gitos) </label><span style="color: #ff0000">*</span>
                                    <input type="text" class="num form-control" id="validationTooltip02" onkeypress="return validarSiNumero()" name="Tel_fijo" placeholder="Telefono fijo" minlength="8" maxlength="10" required/>
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Extensi�n (Opcional) </label>
                                    <input type="text" class="num form-control" id="validationTooltip02" onkeypress="return validarSiNumero()" name="Ext" placeholder="Extension de Telefono fijo"  maxlength="10">
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
                            <div class="col-md-4 mb-3">
				    <label for="validationTooltip02"> Tel�fono M�vil (Opcional) </label>
                                    <input type="text" class="num form-control" id="validationTooltip02" onkeypress="return validarSiNumero()" name="Tel_cel" placeholder="Telefono movil" minlength="10" maxlength="15">
				    <div class="valid-tooltip">
				    	OK
				    </div>
			    </div>
			</div>

			<div class="form-row">    
				<div class="col-md-5 mb-3">
					<label for="validationTooltip03">Unidad Acad�mica</label><span style="color: #ff0000">*</span>
					<select  id="deporte" class="custom-select" style="width: 380px;" data-live-search="true" required/>
<!--					  <option value="">Seleccione Escuela</option>-->
                                                    <%
                                                        try{
                                                            String query="select * from Escuela where ID_Escuela=7";
                                                            Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                            Connect conn = new Connect();
                                                            Statement stm=conn.Connect().createStatement();
                                                            ResultSet rs=stm.executeQuery(query);
                                                            while(rs.next()){
                                                                %>
                                                                <option value="<%=rs.getInt("ID_Escuela")%>"><%=rs.getString("Escuela")%></option>
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
                    <button type="submit" class="btn  btn-outline-success "> Registrar </button>
                    <a href="LoginAlumno.html"style='text-decoration:none;color: #FFFFFF;'> <button type="button" class="btn btn-outline-danger"> Cancelar </button></a>
                </form>
		<div class="clearfix" >&nbsp;</div>
	</section>
</body>

<script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function() {
          'use strict';
          window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
              form.addEventListener('submit', function(event) {
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
<script>
        function soloLetras(e){
       key = e.keyCode || e.which;
       tecla = String.fromCharCode(key).toLowerCase();
       letras = " �����abcdefghijklmn�opqrstuvwxyz";
       especiales = "8-37-39-46";

       tecla_especial = false;
       for(var i in especiales){
            if(key === especiales[i]){
                tecla_especial = true;
                break;
            }
        }

        if(letras.indexOf(tecla)===-1 && !tecla_especial){
            return false;
        }
    }
    </script>
    <script>
     $('.num').on('input', function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
    });
    </script>
    <script>
     $('.bol').on('input', function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
    });
    </script>
    <script>
        $('.email').keyup(function(){
 var _this = $('.email');
 var _email = $('.email').val();
 
 var re = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
 var valid = re.test(_email);
 
 if(valid){
 _this.attr('style', 'background:white');
 } else {
 _this.attr('style', 'background:#FF4A4A');
 }
 });
    </script>
<script>
    function validarInput(input) {
	var curp = input.value.toUpperCase(),
    	resultado = document.getElementById("resultado"),
        valido = "No v�lido";
        
    if (curpValida(curp)) {
    	valido = "V�lido";
        resultado.classList.add("ok");
    } else {
    	resultado.classList.remove("ok");
    }
        
    resultado.innerText = "CURP: " + curp + "\nFormato: " + valido;
}

function curpValida(curp) {
	var re = /^([A-Z][AEIOUX][A-Z]{2}\d{2}(?:0\d|1[0-2])(?:[0-2]\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\d])(\d)$/,
    	validado = curp.match(re);
	
    if (!validado)  //Coincide con el formato general?
    	return false;
    
    //Validar que coincida el d�gito verificador
    function digitoVerificador(curp17) {
        //Fuente https://consultas.curp.gob.mx/CurpSP/
        var diccionario  = "0123456789ABCDEFGHIJKLMN�OPQRSTUVWXYZ",
            lngSuma      = 0.0,
            lngDigito    = 0.0;
        for(var i=0; i<17; i++)
            lngSuma= lngSuma + diccionario.indexOf(curp17.charAt(i)) * (18 - i);
        lngDigito = 10 - lngSuma % 10;
        if(lngDigito == 10)
            return 0;
        return lngDigito;
    }
    if (validado[2] != digitoVerificador(validado[1])) 
    	return false;
        
	return true; //Validado
}

</script>
</html>
