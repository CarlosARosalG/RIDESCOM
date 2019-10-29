<%-- 
    Document   : LoginAlumno
    Created on : 15/08/2019, 04:16:11 PM
    Author     : spy51
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <head>
        <link href="https://www.saes.escom.ipn.mx/BotDetectCaptcha.ashx?get=layoutStyleSheet" rel="stylesheet" type="text/css" /><link href="https://www.saes.escom.ipn.mx/App_Themes/Granite/_vti_cnf/Default.css" type="text/css" rel="stylesheet" /><link href="https://www.saes.escom.ipn.mx/App_Themes/Granite/Default.css" type="text/css" rel="stylesheet" />
        <!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
        <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

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
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="js/jquery-ui/jquery-ui.min.css">
	<link rel="stylesheet" href="js/jquery-ui/jquery-ui.structure.min.css">
	<link rel="stylesheet" href="js/jquery-ui/jquery-ui.theme.min.css">

	<!-- Moment js  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/locale/es.js"></script>

	<!-- Mis scripts -->
        <script type="text/javascript" src="js/main.js"></script>

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
        <title>Login</title>
    </head>
    <body>
<script>
    
</script>
    <div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Inicia Sesión</h3>
			</div>
			<div class="card-body">
                            <form class="needs-validation" novalidate method="POST">
				${mjs}	
                                    <div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
                                            <input type="text" class="num form-control" placeholder="Número de Boleta" name="User"  maxlength="10" required/>
<!--                                            <div class="valid-feedback">
                                                Looks good!
                                            </div>-->
                                            <div class="invalid-feedback">
                                                Campo requerido
                                            </div>
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
                                                <input type="password" class="form-control" placeholder="Contraseña" name="Password"  maxlength="10" required/>
                                                <div class="invalid-feedback">
                                                    Campo requerido
                                                </div>
					</div>
                                        <div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<!--<input type="text" class="form-control" name="vrfcd" placeholder="Captcha" requied/>-->
                                                <input type="text" class="form-control" placeholder="Captcha" name="Captcha" autocomplete="off" required/>
                                                <div class="invalid-feedback">
                                                    Campo requerido
                                                </div>
					</div>
                                        <div class="clearfix" >&nbsp;</div>
                                        <div>
                                            <a target="_blank" href="http://captcha.com/asp.net-captcha-info.html" title="BotDetect Control" onclick="c_default_ctl00_leftcolumn_loginuser_logincaptcha.OnHelpLinkClick(); return c_default_ctl00_leftcolumn_loginuser_logincaptcha.FollowHelpLink;"><img class="LBD_CaptchaImage" id="c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage" src="resources/img/abc.jpg" alt="CAPTCHA"></a> <!--src="../../../abc.jpg"-->
                                        <div class="form-group">
                                            <input name="btn" value="Entrar" type="submit" class="btn btn-light float-right login_btn">
                                            <a href="Home.html" class="btn btn-light float-right login_btn"> Volver </a>
					</div>
                                        </div>
                                        <div class="clearfix" >&nbsp;</div>
					
                                        <div class="clearfix" >&nbsp;</div>
                                        <div class="card-footer">
                                            <div class="d-flex justify-content-center">
                                                    <a href="https://www.saes.escom.ipn.mx/SendEmail/PruebaSendMail.aspx">¿Olvidaste tu contraseña?</a>
                                                    <a href="Privacidad.html">Politica de privacidad</a>
                                            </div>
                                        </div>
				</form>
                                    
                                        
                                <script>
                                    // Example starter JavaScript for disabling form submissions if there are invalid fields
                                    (function() {
                                      'use strict';
                                      window.addEventListener('load', function() {
                                        // Fetch all the forms we want to apply custom Bootstrap validation styles to
                                        var forms = document.getElementsByClassName('needs-validation');
                                        // Loop over them and prevent submission
                                        var validation = Array.prototype.filter.call(forms, function(form) {
                                          form.addEventListener('submit', function(event) {
                                            if (form.checkValidity() === false) {
                                              event.preventDefault();
                                              event.stopPropagation();
                                            }
                                            form.classList.add('was-validated');
                                          }, false);
                                        });
                                      }, false);
                                    })();
                                </script>
			</div>
		</div>
	</div>
</div>
    </body>
<script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function() {
          'use strict';
          window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
              form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                  event.preventDefault();
                  event.stopPropagation();
                }
                form.classList.add('was-validated');
              }, false);
            });
          }, false);
        })();
</script>   
<script>
     $('.num').on('input', function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
    });
</script>
</html>
