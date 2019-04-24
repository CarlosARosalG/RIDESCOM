
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Config.Crawler"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="BotDetectCaptcha.ashx?get=layoutStyleSheet" rel="stylesheet" type="text/css" /><link href="App_Themes/Granite/_vti_cnf/Default.css" type="text/css" rel="stylesheet" /><link href="App_Themes/Granite/Default.css" type="text/css" rel="stylesheet" />
        <title>Log In</title>
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
                    <input name="ctl00$leftColumn$LoginUser$UserName" type="text" size="13" id="ctl00_leftColumn_LoginUser_UserName" accesskey="u" tabindex="60" class="textEntry" autocomplete="off" /><br />
                    
                    <label>Contraseña</label>
                    <script type="text/javascript"></script>
                    <input name="ctl00$leftColumn$LoginUser$Password" type="password" size="13" id="ctl00_leftColumn_LoginUser_Password" accesskey="p" tabindex="61" class="passwordEntry" autocomplete="off" /><br />
                    
                    <label>Captcha</label>
                    <script type="text/javascript"></script>
                    <input name="ctl00$leftColumn$LoginUser$CaptchaCodeTextBox" type="text" size="13" id="ctl00_leftColumn_LoginUser_CaptchaCodeTextBox" accesskey="c" tabindex="62" class="textEntry" autocomplete="off" />
                    
                    <div><a target="_blank" href="http://captcha.com/asp.net-captcha-info.html" title="BotDetect Control" onclick="c_default_ctl00_leftcolumn_loginuser_logincaptcha.OnHelpLinkClick(); return c_default_ctl00_leftcolumn_loginuser_logincaptcha.FollowHelpLink;"><img class="LBD_CaptchaImage" id="c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage" src="${src}" alt="CAPTCHA"></a></div>
                    <input type="submit" name="ctl00$leftColumn$LoginUser$LoginButton" value="Iniciar" onclick="javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(&quot;ctl00$leftColumn$LoginUser$LoginButton&quot;, &quot;&quot;, true, &quot;LoginUserValidationGroup&quot;, &quot;&quot;, false, false))" id="ctl00_leftColumn_LoginUser_LoginButton" class="button" />
                    <a href="index.htm" value="Regresar" class="btn btn-success">Regresar</a>
                </form>
                <a class="btn btn-danger" value ="registrar" href="registrar.htm">Registrarse</a>
            </div>
        </div>
      <script type="text/javascript">
//<![CDATA[
var theForm = document.forms['aspnetForm'];
if (!theForm) {
    theForm = document.aspnetForm;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</script>


<script src="/WebResource.axd?d=tZJslfDJDNTAwY4xhCCtfIhNd98MpYvJa1zO54UIkoscL_Lyp3kvGPqozmlRp7haEZh1j4Be9yg3w-bt8D1otuDtUb41&amp;t=635198804332401351" type="text/javascript"></script>


<script src="/WebResource.axd?d=xCWd2iQKp-Buh3i6jROy8xqViqtPkoJh92P3SQRwbAVkbcz0FrEMn1Ad2Z6anL6MDZd8v0BzrFpTXGdgBOYfUvnJczk1&amp;t=635198804332401351" type="text/javascript"></script>
<script src="/WebResource.axd?d=5VOKJoEoHnxN-Wnk23k82PecyAkdBtb6l71cZ3TDk1qQgQJQG_rYi0u1uFGYMWGbRklae4BQYfxnF5lA4pQ-GD6vYNE1&amp;t=635198804332401351" type="text/javascript"></script>
<script type="text/javascript">
//<![CDATA[
function WebForm_OnSubmit() {
if (typeof(ValidatorOnSubmit) == "function" && ValidatorOnSubmit() == false) return false;
return true;
}
//]]>
</script>

<script src="/BotDetectCaptcha.ashx?get=clientScriptInclude" type="text/javascript"></script>
		    <script type="text/javascript">
    //<![CDATA[
      BotDetect.Init('c_default_ctl00_leftcolumn_loginuser_logincaptcha', 'af4f3d42e00848f7b89a11b5226f3c3b', null, true, true, true, true, 1200, 7200, 0, true);
    //]]>
    </script>
		    <script type="text/javascript">
    //<![CDATA[
      try{(function(){var bdrsn = document.createElement('script'); bdrsn.type = 'text/javascript'; bdrsn.async = true; bdrsn.src = document.location.protocol + '//remote.captcha.com/include.js?i=ATABMAEwATMBMAIxNhRZ4rPPveMqOnPLACF5ncOcGFcpdA'; var fsn = document.getElementsByTagName('script')[0]; fsn.parentNode.insertBefore(bdrsn, fsn);})();} catch(err){}
    //]]>
    </script>
    
    <script type="text/javascript">
//<![CDATA[
var Page_Validators =  new Array(document.getElementById("ctl00_leftColumn_LoginUser_UserNameRequired"), document.getElementById("ctl00_leftColumn_LoginUser_PasswordRequired"), document.getElementById("ctl00_leftColumn_LoginUser_CaptchaRequiredValidator"));
//]]>
</script>

<script type="text/javascript">
//<![CDATA[
var ctl00_leftColumn_LoginUser_UserNameRequired = document.all ? document.all["ctl00_leftColumn_LoginUser_UserNameRequired"] : document.getElementById("ctl00_leftColumn_LoginUser_UserNameRequired");
ctl00_leftColumn_LoginUser_UserNameRequired.controltovalidate = "ctl00_leftColumn_LoginUser_UserName";
ctl00_leftColumn_LoginUser_UserNameRequired.errormessage = "El nombre de usuario es obligatorio";
ctl00_leftColumn_LoginUser_UserNameRequired.validationGroup = "LoginUserValidationGroup";
ctl00_leftColumn_LoginUser_UserNameRequired.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
ctl00_leftColumn_LoginUser_UserNameRequired.initialvalue = "";
var ctl00_leftColumn_LoginUser_PasswordRequired = document.all ? document.all["ctl00_leftColumn_LoginUser_PasswordRequired"] : document.getElementById("ctl00_leftColumn_LoginUser_PasswordRequired");
ctl00_leftColumn_LoginUser_PasswordRequired.controltovalidate = "ctl00_leftColumn_LoginUser_Password";
ctl00_leftColumn_LoginUser_PasswordRequired.errormessage = "La contraseña es obligatoria";
ctl00_leftColumn_LoginUser_PasswordRequired.validationGroup = "LoginUserValidationGroup";
ctl00_leftColumn_LoginUser_PasswordRequired.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
ctl00_leftColumn_LoginUser_PasswordRequired.initialvalue = "";
var ctl00_leftColumn_LoginUser_CaptchaRequiredValidator = document.all ? document.all["ctl00_leftColumn_LoginUser_CaptchaRequiredValidator"] : document.getElementById("ctl00_leftColumn_LoginUser_CaptchaRequiredValidator");
ctl00_leftColumn_LoginUser_CaptchaRequiredValidator.controltovalidate = "ctl00_leftColumn_LoginUser_CaptchaCodeTextBox";
ctl00_leftColumn_LoginUser_CaptchaRequiredValidator.errormessage = "CAPTCHA es obligatorio";
ctl00_leftColumn_LoginUser_CaptchaRequiredValidator.validationGroup = "LoginUserValidationGroup";
ctl00_leftColumn_LoginUser_CaptchaRequiredValidator.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
ctl00_leftColumn_LoginUser_CaptchaRequiredValidator.initialvalue = "";
//]]>
</script>


<script type="text/javascript">
//<![CDATA[
var ctl00_mainmenu_Data = new Object();
ctl00_mainmenu_Data.disappearAfter = 500;
ctl00_mainmenu_Data.horizontalOffset = 0;
ctl00_mainmenu_Data.verticalOffset = 0;
ctl00_mainmenu_Data.staticHoverClass = 'ctl00_mainmenu_9 hover';
ctl00_mainmenu_Data.staticHoverHyperLinkClass = 'ctl00_mainmenu_8 hover';
ctl00_mainmenu_Data.iframeUrl = '/WebResource.axd?d=rvmpBNtYpnn7B4cPCvQrHeKc8SAXCIVGOtErI0gw2eSF_1Jq0V7r7jm9QX_bzaqBuBzyr3P37ScUOvVQVM6uhsgg1Ns1&t=635198804332401351';
var ctl00_subMenu_Data = new Object();
ctl00_subMenu_Data.disappearAfter = 500;
ctl00_subMenu_Data.horizontalOffset = 0;
ctl00_subMenu_Data.verticalOffset = 0;
ctl00_subMenu_Data.hoverClass = 'ctl00_subMenu_16 hover';
ctl00_subMenu_Data.hoverHyperLinkClass = 'ctl00_subMenu_15 hover';
ctl00_subMenu_Data.staticHoverClass = 'ctl00_subMenu_14 hover';
ctl00_subMenu_Data.staticHoverHyperLinkClass = 'ctl00_subMenu_13 hover';
ctl00_subMenu_Data.iframeUrl = '/WebResource.axd?d=rvmpBNtYpnn7B4cPCvQrHeKc8SAXCIVGOtErI0gw2eSF_1Jq0V7r7jm9QX_bzaqBuBzyr3P37ScUOvVQVM6uhsgg1Ns1&t=635198804332401351';

var Page_ValidationActive = false;
if (typeof(ValidatorOnLoad) == "function") {
    ValidatorOnLoad();
}

function ValidatorOnSubmit() {
    if (Page_ValidationActive) {
        return ValidatorCommonOnSubmit();
    }
    else {
        return true;
    }
}
        //]]>
</script>

    </body>
</html>                  