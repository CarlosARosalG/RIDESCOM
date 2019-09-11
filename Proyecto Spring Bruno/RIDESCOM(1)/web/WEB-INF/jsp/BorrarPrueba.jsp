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
                <h4>¿Seguro que desea eliminar estos datos?</h4>
            </div>
            <div class="card-header bg-info">
                <form method="POST">
                    <label>ID Prueba: ${prue[0].ID_Pruebas}</label>
                    <p></p>
                    <label>Prueba</label>
                    <input type="text" value="${prue[0].Prueba}" name="Prueba" class="form-control" autocomplete="off" disabled/>
                     <label>Tipo de Prueba</label>
                     <input type="text" value=" ${prue[0].Tipo}"  name="Tipo" class="form-control" autocomplete="off" disabled/> 
                     <label>Deporte</label>
                     <input type="text" value=" ${prue[0].Disciplina}"  name="Act_Prueba" class="form-control" autocomplete="off" disabled/> 
                    
                     <a href="ConfirmaBorrar?PruebaID=${prue[0].ID_Pruebas}" type="submit" value="Eliminar" class="btn btn-success">Eliminar</a>
                   <a href="../Pruebas" type="submit" value="Regresar" class="btn btn-success">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
