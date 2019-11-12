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
                <h4>Eliminar campos</h4>
            </div>
            <div class="card-header bg-info">
                <form method="POST">
                    <label>ID Deporte: ${dep[0].ID_Deporte}</label>
                    <p></p>
                    <label>Deporte</label>
                    <input type="text" value="${dep[0].Disciplina}" name="Disciplina" class="form-control" autocomplete="off" disabled>
                    
<!--                    <a href="ConfirmaBorrar.html?DeporteID=${dep[0].ID_Deporte}" type="submit" value="Eliminar" class="btn btn-success">Eliminar</a>-->
                    <button type="submit" class="btn  btn-outline-success "> Eliminar </button>
                   <a href="../Deportes.html" type="submit" value="Regresar" class="btn btn-success">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
