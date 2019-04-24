<%-- 
    Document   : LoginC
    Created on : 22/04/2019, 04:23:31 PM
    Author     : spy51
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <h4>Inicia Sesion</h4>
            </div>
            <div class="card-header bg-info">
                <form method="post" action="index.htm" onsubmit="javascript:return WebForm_OnSubmit();">
                    <label>Usuario</label>
                    <script type="text/javascript"></script>
                    <input type="text" name="usuario" autocomplete="off" /><br />
                    
                    <label>Contraseña</label>
                    <script type="text/javascript"></script>
                    <input type="password" name="psw" autocomplete="off" /><br />
                    
                    <a class="btn btn-success" value="Iniciar">Iniciar</a>
                    <a href="index.htm" value="Regresar" class="btn btn-success">Regresar</a>
                </form>
                <a class="btn btn-danger" value ="registrar" href="registrar.htm">Registrarse</a>
            </div>
        </div>
    </body>
</html>
