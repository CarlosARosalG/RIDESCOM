<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>SAES ${cadena}</title>
    

    <body>
        <div class="container mt-4">
            <div class="card-body-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-primary" href="agregar.htm">Agregar nuevo alumno</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Numero de Boleta</th>
                                <th>CURP</th>
                                <th>Nombre</th>
                                <th>Apellido Paterno</th>
                                <th>Apellido Materno</th>
                                <th>Escuela</th>
                                <th>Promedio</th>
                                <th>Turno</th>
                                <th>Fecha de Nacimiento</th>
                                <th>Semestre Minimo</th>
                                <th>Semestre Maximo</th>
                                <th>Semestre Inscrito</th>
                                <th>Calle</th>
                                <th>Colonia</th>
                                <th>Estado</th>
                                <th>Codigo Postal</th>
                                <th>Carrera</th>
                                <th>Especialidad</th>
                                <th>Plan de estudios</th>
                                <th>Correo electronico</th>
                                <th>Tipo de Alumno</th>
                                <th>Inscrito</th>
                                <th>Sexo</th>
                                <th>Total de Creditos</th>
                                <th>Modo de Ingreso</th>
                                <th>Periodo Escolar de Ingreso</th>
                                <th>Egresado</th>
                                <th>Carga Minima</th>
                                <th>Origen</th>
                                <th>Usuario</th>
                                <th>Observaciones</th>
                                <th>Reprobadas</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${lista}">
                            <tr>
                                <td>${dato.Numero_Boleta}</td>
                                <td>${dato.CURP}</td>
                                <td>${dato.Nombre}</td>
                                <td>${dato.Apellido_Pat}</td>
                                <td>${dato.Apellido_Mat}</td>
                                <td>${dato.Escuela}</td>
                                <td>${dato.Promedio}</td>
                                <td>${dato.Turno}</td>
                                <td>${dato.Fecha_Nac}</td>
                                <td>${dato.Semestre_Min}</td>
                                <td>${dato.Semestre_Max}</td>
                                <td>${dato.Semestre_Inscrito}</td>
                                <td>${dato.Calle}</td>
                                <td>${dato.Colonia}</td>
                                <td>${dato.Estado}</td>
                                <td>${dato.CP}</td>
                                <td>${dato.Carrera}</td>
                                <td>${dato.Especialidad}</td>
                                <td>${dato.Plan_Estud}</td>
                                <td>${dato.E_mail}</td>
                                <td>${dato.Tipo_Alumno}</td>
                                <td>${dato.Inscrito}</td>
                                <td>${dato.Sexo}</td>
                                <td>${dato.Tot_Creditos}</td>
                                <td>${dato.Modo_Ingreso}</td>
                                <td>${dato.Periodo_Escolar_Ingreso}</td>
                                <td>${dato.Egresado}</td>
                                <td>${dato.Cumple_Carga_Minima}</td>
                                <td>${dato.Origen}</td>
                                <td>${dato.Usuario_ID}</td>
                                <td>${dato.Observaciones}</td>
                                <td>${dato.Reprobadas}</td>
                                
                                <td>
                                    <a class=""btn btn-warning>Aceptar</a>
                                    <a class=""btn btn-danger>Eliminar</a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                
                </div>
            </div>
        </div>
    </body>

