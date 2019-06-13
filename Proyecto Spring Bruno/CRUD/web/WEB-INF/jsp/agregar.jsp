<%-- 
    Document   : registrar
    Created on : 3/04/2019, 03:10:05 PM
    Author     : spy51
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrate</title>
    </head>
    <body>
         <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <h4>Agregar</h4>
            </div>
            <div class="card-header bg-info">
                <form method="POST">
                    <label>Numero de Boleta</label>
                    <input type="text" maxlength="10" name="boleta" class="form-control" autocomplete="off">
                     <label>CURP</label>
                    <input type="text"  name="CURP" class="form-control" autocomplete="off">
                     <label>Nombre</label>
                    <input type="text"  name="Nombre" class="form-control" autocomplete="off">
                     <label>Apellido Paterno</label>
                    <input type="text"  name="Ap_Pat" class="form-control" autocomplete="off">
                     <label>Apellido Materno</label>
                    <input type="text"  name="Ap_Mat" class="form-control" autocomplete="off">
                     <label>Escuela</label>
                    <input type="text"  name="Escuela" class="form-control" autocomplete="off">
                     <label>Promedio</label>
                    <input type="text"  name="Promedio" class="form-control" autocomplete="off">
                     <label>Turno</label>
                    <input type="text"  name="Turno" class="form-control" autocomplete="off">
                     <label>Fecha de Nacimiento</label>
                    <input type="text"  value="yyyy/mm/dd" name="Fecha" class="form-control" autocomplete="off">
                     <label>Semestre Minimo</label>
                    <input type="text"  name="S_min" class="form-control" autocomplete="off">
                     <label>Semestre Maximo</label>
                    <input type="text"  name="S_max" class="form-control" autocomplete="off">
                     <label>Semestre Inscrito</label>
                    <input type="text"  name="S_i" class="form-control" autocomplete="off">
                     <label>Calle</label>
                    <input type="text"  name="Calle" class="form-control" autocomplete="off">
                     <label>Colonia</label>
                    <input type="text"  name="Col" class="form-control" autocomplete="off">
                     <label>Estado</label>
                    <input type="text"  name="Edo" class="form-control" autocomplete="off">
                     <label>Codigo Postal</label>
                    <input type="text"  name="CP" class="form-control" autocomplete="off">
                     <label>Carrera</label>
                    <input type="text"  name="Carrera" class="form-control" autocomplete="off">
                     <label>Especialidad</label>
                    <input type="text"  name="Esp" class="form-control" autocomplete="off">
                     <label>Plan de estudios</label>
                    <input type="text" value="2019/2"  name="Plan" class="form-control" autocomplete="off">
                     <label>E_mail</label>
                    <input type="text"  name="Correo" class="form-control" autocomplete="off">
                     <label>Tipo de Alumno</label>
                    <input type="text"  name="Tipo" class="form-control" autocomplete="off">
                     <label>Inscrito</label>
                    <input type="text"  name="Ins" class="form-control" autocomplete="off">
                     <label>Sexo</label>
                    <input type="text"  name="Sexo" class="form-control" autocomplete="off">
                     <label>Total de Creditos</label>
                    <input type="text"  name="Total" class="form-control" autocomplete="off">
                     <label>Modo de Ingreso</label>
                    <input type="text"  name="Modo" class="form-control" autocomplete="off">
                     <label>Periodo Escolar de Ingreso</label>
                    <input type="text"  name="Periodo" class="form-control" autocomplete="off">
                     <label>Egresado</label>
                    <input type="text"  name="Egresado" class="form-control" autocomplete="off">
                     <label>Carga Minima</label>
                    <input type="text"  name="C_min" class="form-control" autocomplete="off">
                     <label>Origen</label>
                    <input type="text"  name="Origen" class="form-control" autocomplete="off">
                     <label>Usuario_ID</label>
                    <input type="text"  name="User" class="form-control" autocomplete="off">
                     <label>Observaciones</label>
                    <input type="text"  name="Obs" class="form-control" autocomplete="off">
                     <label>Reprobadas</label>
                    <input type="text"  name="Repro" class="form-control" autocomplete="off">
                    
                    <input type="submit" value="Agregar" class="btn btn-success">
                    <a href="index.htm" type="submit" value="Regresar" class="btn btn-success">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>