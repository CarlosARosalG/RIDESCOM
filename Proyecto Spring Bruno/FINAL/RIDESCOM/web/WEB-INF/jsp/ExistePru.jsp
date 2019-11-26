<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
         <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <h4>No se puede editar</h4>
            </div>
            <div class="card-header bg-info">
                    <p>En esta prueba ya hay alumnos inscritos</p>
                    <label>Prueba: <b>${prue[0].Prueba}</b></label>
                    <p></p>
                     <label>Tipo de Prueba: <b>${prue[0].Tipo}</b></label>
                     <p></p>
                     <label>Rama: <b>${prue[0].Rama}</b></label>
                     <p></p>
                     <label>Deporte: <b>${prue[0].Disciplina}</b></label>
                     <p></p>
                   <a href="../Pruebas.html" type="submit" value="Regresar" class="btn btn-success">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
