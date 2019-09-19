<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmación</title>
    </head>
    <body>
         <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <h4>Se ha actualizado correctamente</h4>
            </div>
            <div class="card-header bg-info">
                <form method="POST">
                    <label>ID Deporte: ${dep[0].ID_Deporte}</label>
                    <p></p>
                    <label>Deporte</label>
                    <input type="text" value="${dep[0].Disciplina}" name="Disciplina" class="form-control" autocomplete="off" disabled/>
                    
                   <a href="../Deportes" type="submit" value="Regresar" class="btn btn-success">Aceptar</a>
                </form>
            </div>
        </div>
    </body>
</html>
