<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h4>Eliminar campos</h4>
            </div>
            <div class="card-header bg-info">
                <form method="POST">
                    <label>ID Prueba: ${prue[0].ID_Prueba}</label>
                    <p></p>
                    <label>Prueba</label>
                    <input type="text" value="${prue[0].Prueba}" name="Prueba" class="form-control" autocomplete="off" required>
                     <label>Tipo de Prueba</label>
                     <input type="text" value=" ${prue[0].Tipo_Pruebas_ID_Prueba}"  name="Tipo" class="form-control" autocomplete="off" required> 
                     <label>Deporte</label>
                     <input type="text" value=" ${prue[0].Act_Deportiva_ID_Deporte}"  name="Act_Prueba" class="form-control" autocomplete="off" required> 
                    
                    <input type="submit" value="Eliminar" class="btn btn-success">
                   <a href="" type="submit" value="Regresar" class="btn btn-success">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
