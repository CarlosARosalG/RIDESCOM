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
                    <label>Nombre usuario</label>
                    <input type="text" name="Nombre_user" class="form-control" autocomplete="off">
                     <label>Password</label>
                    <input type="password"  name="Psw_user" class="form-control" autocomplete="off"> 
                    
                    <input type="submit" value="Agregar" class="btn btn-success">
                    <a href="index.htm" type="submit" value="Regresar" class="btn btn-success">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
