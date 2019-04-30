<%-- 
    Document   : ingresa_resultados
    Created on : 24/04/2019, 11:58:30 AM
    Author     : Carlos A. Rosales
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
        <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles 
	<link rel="stylesheet" type="text/css" href="../../css/styles.css">-->
        <!-- Estilos CSS 
        <link rel="stylesheet" type="text/css" href="../../css/styles_login.css">-->
        
        <style type="text/css">
        
        /*****************
         * Inicia sesion *
         ****************/

        @import url('https://fonts.googleapis.com/css?family=Numans');

        html,body{
        background: #373B44;  
        background: -webkit-linear-gradient(to bottom, #4286f4, #373B44);
        background: linear-gradient(to bottom, #4286f4, #373B44); 
        background-size: cover;
        background-repeat: no-repeat;
        height: 100%;
        font-family: 'Numans', sans-serif;
        }

        .container{
        height: 100%;
        align-content: center;
        }

        .card{
        height: 370px;
        margin-top: auto;
        margin-bottom: auto;
        width: 400px;
        background-color: rgba(0,0,0,0.5) !important;
        }

        .social_icon span{
        font-size: 60px;
        margin-left: 10px;
        color: #FFC312;
        }

        .social_icon span:hover{
        color: white;
        cursor: pointer;
        }

        .card-header h3{
        color: white;
        }

        .social_icon{
        position: absolute;
        right: 20px;
        top: -45px;
        }

        .input-group-prepend span{
        width: 50px;
        background-color: #FFC312;
        color: black;
        border:0 !important;
        }

        input:focus{
        outline: 0 0 0 0  !important;
        box-shadow: 0 0 0 0 !important;

        }

        .remember{
        color: white;
        }

        .remember input
        {
        width: 20px;
        height: 20px;
        margin-left: 15px;
        margin-right: 5px;
        }

        .login_btn{
        color: white;
        background-color: #FFC312;
        width: 100px;
        }

        .login_btn:hover{
        color: black;
        background-color: white;
        }

        .links{
        color: white;
        }

        .links a{
        margin-left: 4px;
        }
        </style>

	<!--Jquery -->

        <script type="text/javascript" src="../../js/jquery-ui/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="../../js/jquery-ui/jquery-ui.min.js"></script>
        <link rel="stylesheet"  href="../../css/jquery-ui.css">
        <link rel="stylesheet" href="../../css/jquery-ui.min.css">
        <link rel="stylesheet"  href="../../css/jquery-ui.structure.css">
	<link rel="stylesheet" href="../../css/jquery-ui.structure.min.css">
        <link rel="stylesheet"  href="../../css/jquery-ui.theme.css">
	<link rel="stylesheet"  href="../../css/jquery-ui.theme.min.css">
        

	<!-- Moment js  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/locale/es.js"></script>

	<!-- Mis scripts -->
        <script type="text/javascript" src="../../js/main.js"></script>

	<!-- Bootstrap  -->	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<!-- JS en bootstrap  -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
	<!-- CSS en bootstrap -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
	<!-- google font libraries -->
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400' rel='stylesheet' type='text/css'>	
    
</head>

<body>
        <div class="container">
            <h1>Ingresa los resultados de los participantes </h1>
            <div class="row main_content">
                <div class="clearfix" >&nbsp;</div>
                <div class="col-sm-12 main">
                <div class="clearfix" >&nbsp;</div>
                    <form >
                        <div class="form-group col-sm-6 ">
                            <div class="input-group form-group">
                                <span class="input-group-text"><i class="fas fa-id-card"></i></span>
                                <input type="text" class="form-control" placeholder="Boleta">
                            </div>
                            <input type="submit" value="Buscar" class="btn btn-light float-right login_btn">
                            <div class="clearfix" >&nbsp;</div>
                        </div>
                            
                        <div class="form-group col-sm-6 ">
                            <div class="input-group form-group">
                                <span class="input-group-text"><i class="fas fa-user"></i></span>
                                <input type="text" class="form-control" placeholder="Nombre">
                            </div>
                        </div>
            
                        <div class="form-group col-sm-6 ">
                            <div class="input-group form-group">
                                <span class="input-group-text"><i class="fas fa-graduation-cap"></i></span>
                                <input type="text" class="form-control" placeholder="Unidad Académica">
                            </div>
                        </div>
                            
                        <div class="form-group col-sm-6 ">
                            <div class="input-group form-group">
                                <span class="input-group-text"><i class="fas fa-walking"></i></span>
                                <input type="text" class="form-control" placeholder="Deporte">
                            </div>
                        </div>
                                
                        <div class="form-group col-sm-6 ">
                            <div class="input-group form-group">
                                <span class="input-group-text"><i class="fas fa-walking"></i></span>
                                <input type="text" class="form-control" placeholder="Sub-división">
                            </div>
                        </div>
                            
                        <div class="form-group col-sm-6 ">
                            <div class="input-group form-group">
                                <span class="input-group-text"><i class="fas fa-trophy"></i></span>
                                <input type="text" class="form-control" placeholder="Posición">
                            </div>
                        </div>
                            
                        <div class="form-group col-sm-6 ">
                            <div class="input-group form-group">
                                <span class="input-group-text"><i class="fas fa-walking"></i></span>
                                <input type="text" class="form-control" placeholder="Prueba">
                            </div>
                        </div>
                    
                        <div class="form-group col-sm-6 ">
                            <div class="input-group form-group">
                                <span class="input-group-text"><i class="fas fa-stopwatch"></i></span>
                                <input type="text" class="form-control" placeholder="Marca">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        

                <div>
                    <div class="col-sm-12 main-box">
                        <div class="clearfix" >&nbsp;</div>
                        <div class="clearfix" >&nbsp;</div>
                        <div class="responsive-table table-responsive clearfix">
                            <table id="listado" class="table table-light">
                                <thead>
                                    <tr>
                                        <th> Nombre </th>
                                        <th> Boleta </th>
                                        <th> Unidad Académica </th>
                                        <th> Deporte </th>
                                        <th> Sub-división </th>
                                        <th> Posición </th>
                                        <th> Prueba </th>
                                        <th> Marca </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td> Carlos </td>
                                        <td> 201563XXX </td>
                                        <td> ESCOM </td>
                                        <td> Atletismo </td>
                                        <td> sub-17 </td>
                                        <td> 4 </td>
                                        <td> 100m. </td>
                                        <td> 1:01 </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="clearfix" >&nbsp;</div>
                            <div class="clearfix" >&nbsp;</div>
                        </div>               
                    </div>
                </div>
        </div>
    </body>
</html>
