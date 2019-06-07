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
        <title>Registro</title>
    </head>
    <body>
         <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <h4>Registrate</h4>
            </div>
            <div class="card-header bg-info">
                <form method="POST">
                    <label>Numero de Boleta</label>
                    <script type="text/javascript" src=".../Spring/src/java/JS/Onlynum.js"></script>
                    <input type="text" onkeypress="isInputNumber(event)" maxlength="10" name="boleta" class="form-control" autocomplete="off">
                   <!--Agreagar algoritmo de comprobación de campo -->
                   
                    <input type="submit" value="Registrar" class="btn btn-success">
                    <a href="Login.htm" type="submit" value="Login" class="btn btn-success">Iniciar Sesion</a>
                    <a href="index.htm" type="submit" value="Regresar" class="btn btn-success">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
