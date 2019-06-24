<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>SAES ${cadena}</title>
    

    <body>
        <div class="container mt-4">
            <div class="card-body-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-primary" href="agregar.htm">Registrar usuarios</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre de Usuario</th>
                                <th type="password">Password</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${lista}">
                            <tr>
                                <td>${dato.User_ID}</td>
                                <td>${dato.Nombre_user}</td>
                                <td>${dato.Psw_user}</td>
                                <td>
                                    <a class="btn btn-warnning">Editar</a>
                                    <div class="clearfix">&nbsp;</div>
                                    <a class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                
                </div>
            </div>
        </div>
        
        <div class="container mt-4">
            <div class="card-body-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-primary" href="agregard.htm">Registrar nuevo deporte</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Disciplina</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${rid}">
                            <tr>
                                <td>${dato.ID_Deporte}</td>
                                <td>${dato.Disciplina}</td>
                                
                                
                                <td>
                                    <a class="btn btn-success">Aceptar</a>
                                    <div class="clearfix">&nbsp;</div>
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

