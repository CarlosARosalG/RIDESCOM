<%-- 
    Document   : Registrarcord
    Created on : 2/05/2019, 12:43:51 PM
    Author     : spy51
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script>
function myFunction() {
  var x = document.getElementById("myDIV");
  if (window.getComputedStyle(x).display === "none") {
    x.style.display = "block";
  }
}
</script>
<script type="text/javascript">
/**
 * Funcion que se ejecuta al seleccionar una opcion del primer select
 */
function cargarSelect2(valor)
{
    /**
     * Este array contiene los valores sel segundo select
     * Los valores del mismo son:
     *  - hace referencia al value del primer select. Es para saber que valores
     *  mostrar una vez se haya seleccionado una opcion del primer select
     *  - value que se asignara
     *  - testo que se asignara
     */
    var arrayValores=new Array(
		
		new Array(0,0),
		
        new Array(1,1,"Si"),
        new Array(1,2,"No"),

		new Array(2,1,"Si"),
        new Array(2,2,"No"),

        new Array(3,1,"Si"),
        new Array(3,2,"No"),
		
		new Array(4,1,"Si"),
		new Array(4,2,"No"),
		
		new Array(5,1,"Si"),
		new Array(5,2,"No"),
		
		new Array(6,1,"Si"),
		new Array(6,2,"No"),
		
		new Array(7,1,"Si"),
		new Array(7,2,"No"),
		
		new Array(8,1,"Si"),
		new Array(8,2,"No"),
		
		new Array(9,1,"Si"),
		new Array(9,2,"No"),
		
		new Array(10,1,"Si"),
		new Array(10,2,"No"),
		
		new Array(11,1,"Si"),
		new Array(11,2,"No"),
    );

    if(valor==0)
    {
        // desactivamos el segundo select
        document.getElementById("select2").disabled=true;
    }else{
        // eliminamos todos los posibles valores que contenga el select2
        document.getElementById("select2").options.length=0;
		// añadimos los nuevos valores al select2
        document.getElementById("select2").options[0]=new Option("¿Tiene Asistente?", "0");
		
        for(i=0;i<arrayValores.length;i++)
        {
            // unicamente añadimos las opciones que pertenecen al id seleccionado
            // del primer select
            if(arrayValores[i][0]==valor)
            {
                document.getElementById("select2").options[document.getElementById("select2").options.length]=new Option(arrayValores[i][2], arrayValores[i][1]);
            }
        }
        // habilitamos el segundo select
        document.getElementById("select2").disabled=false;
    }
}
/**
 * Una vez selecciona una valor del segundo selecte, obtenemos la información
 * de los dos selects y la mostramos
 */
function seleccinado_select2(value)
{
    var v1 = document.getElementById("select1");
    var valor1 = v1.options[v1.selectedIndex].value;
    var text1 = v1.options[v1.selectedIndex].text;
    var v2 = document.getElementById("select2");
    var valor2 = v2.options[v2.selectedIndex].value;
    var text2 = v2.options[v2.selectedIndex].text;
 
    alert("Ha seleccionado el deporte "+text1+" con la prueba "+text2+" ");
}
</script>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Usuarios Coordinador</title>
    </head>
    <body id="top">
<div class="wrapper row3">
  <div class="rounded">
    <main class="container clear"> 
      <!-- main body --> 
      <!-- ################################################################################################ -->
 <div id="comments">
 <div id="portfolio">
        <center><h2>Registro Coordinador</h2>
		
        <form action="#" method="post"></center>
		 <ul class="nospace clear">
          <div class="one_half first">
            <input type="text" name="name" id="name" value="" size="22" placeholder="Usuario">
          </div>
		 <div class="one_half" >
            <input type="text" name="date" id="date" value="" size="22" placeholder="Contraseña">
          </div>
		  
          <div class="one_half first" >
            <input type="text" name="date" id="date" value="" size="22" placeholder="Nombre">
          </div>
		  <div class="one_half">
            <input type="text" name="date" id="date" value="" size="22" placeholder="Apellido Paterno">
          </div>
		  
		  <div class="one_half first">
            <input type="text" name="date" id="date" value="" size="22" placeholder="Apellido Materno">
          </div>
		  <div class="one_half">
            <input type="text" name="date" id="date" value="" size="22" placeholder="Email">
          </div>
		  
		  <div class="one_half first">
            <input type="text" name="date" id="date" value="" size="22" placeholder="Telefono fijo"><label for="name"><span>*</span></label>
          </div>
		  <div class="one_half">
            <input type="text" name="date" id="date" value="" size="22" placeholder="Telefono Movil">
          </div>
		  <div class="one_half first">
            <label for="deporte"></label>
			<select id='select1' onchange='cargarSelect2(this.value);'>
					  <option value="0"> Unidad academica </option> 
					  <option value="1"> ESCOM </option>
					  <option value="2"> ESIME </option>
					  <option value="3"> ESIA </option>
					  <option value="4"> UPIICSA </option>
					  
			</select>
          </div>
        </form>
      </div>
		</div>
	</div>
	<div>
            <input class="fl_right" name="submit"  type="submit" value="Registrar">
    </div>
</div>
 </div>
	  <!-- JAVASCRIPTS --> 
<script src="../layout/scripts/jquery.min.js"></script> 
<script src="../layout/scripts/jquery.fitvids.min.js"></script> 
<script src="../layout/scripts/jquery.mobilemenu.js"></script>
</body>
</html>
