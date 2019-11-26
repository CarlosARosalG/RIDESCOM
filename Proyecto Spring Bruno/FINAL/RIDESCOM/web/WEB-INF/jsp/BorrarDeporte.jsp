<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar</title>
    </head>
    <body>
         <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <h4>No se puede eliminar</h4>
            </div>
            <div class="card-header bg-info">
                    <p>En este deporte ya hay inscritos</p>
                    <label>Deporte: <b>${dep[0].Disciplina}</b></label>
                    <p></p>
                   <a href="../Deportes.html" type="submit" value="Regresar" class="btn btn-success">Regresar</a>
            </div>
        </div>
    </body>
</html>
