<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>DDyFD</title>
    </head>
    
    <nav class="navbar navbar-expand-lg navbar-info bg-info">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="#">Crear Evento<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="btn" href="#">Agregar Pruebas<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="btn" href="#">Crear Usuarios</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="btn" href="#">Disabled</a>   
                    </li>
<!--                    <label>${nombre.getNombre().concat(nombre.getAppat()).concat("").concat(nombre.getApmat())}</label>-->
                </ul>

                <div class="dropdown">
                    <button style="margin-left: 10px; border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true">
                        ${usuario.getUsuario()}
                    </button>
                    <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">
                            <img src="img/user.png" alt="60" width="60"/>
                        </a>
                        <a class="dropdown-item" href="#">Nombre Usuario</a>
                        <a class="dropdown-item" href="#">Usuario@gmail.com</a>
<!--                        <a class="dropdown-item" href="#"></a>-->
                        <div class="drop-divider"></div>
                        <form action="Coordinador" method="POST">
                            <button name="accion" value="Salir" class="dropdown-item">Salir</button>
                        </form>
                    </div>
                </div>
            </div>
        </nav>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
            
    <body>
        <div class="container mt-4">
            <div class="card-body-info">
                <div class="card-header bg-info text-white">
                    <a class="btn btn-primary" href=#>Registrar Evento</a>
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Nombre del Evento</th>
                                <th>Fecha de registro</th>
                                <th>Fecha de fin de registro</th>
                                <th>Lugar del evento</th>
                                <th>Dirección</th>
                                <th>Descripción del evento</th>
                                <th>Fecha de realización</th>
                                <th>Deporte</th>
                                <th>Ciclo escolar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${prue}">
                            <tr>
                                <td>${dato.ID_Pruebas}</td>
                                <td>${dato.Prueba}</td>
                                <td>${dato.Tipo}</td>
                                <td>${dato.Disciplina}</td>
                                
                                <td>
                                    
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
