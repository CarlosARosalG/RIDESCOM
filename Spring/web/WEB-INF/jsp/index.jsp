<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Validacion</title>
    </head>

    <body>
        <div class="container mt-4">
            <div class="card-body-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-primary" href="   Login.htm">Iniciar Sesion</a>
                    <a class="btn btn-primary" href="registrar.htm">Registrar</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Numero de Boleta</th>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <!--<th>Sexo</th>-->
                                <!--<th>CURP</th>-->
                                <th>Fecha de Nacimiento</th>
                                <th>Escuela</th>
                                <!--<th>Carrera</th>-->
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${lista}">
                            <tr>
                                <td>${dato.Numero_Boleta}</td>
                                <td>${dato.Nombre}</td>
                                <td>${dato.Apellidos}</td>
                                <!--<td>${dato.Sexo}</td>-->
                                <!--<td>${dato.CURP}</td>-->
                                <td>${dato.Fecha_Nac}</td>
                                <td>${dato.Escuela}</td>
                                <!--<td>${dato.Carrera}</td>-->
                                <td>
                                    <a class="btn btn-warning">Aceptar</a>
                                    <a class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                
                </div>
            </div>
        </div>
    </body>
</html>
