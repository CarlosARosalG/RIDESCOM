package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Entidad.Captcha;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"BotDetectCaptcha.ashx?get=layoutStyleSheet\" rel=\"stylesheet\" type=\"text/css\" /><link href=\"App_Themes/Granite/_vti_cnf/Default.css\" type=\"text/css\" rel=\"stylesheet\" /><link href=\"App_Themes/Granite/Default.css\" type=\"text/css\" rel=\"stylesheet\" />\n");
      out.write("        <title>Log In</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container mt-4 col-lg-4\">\n");
      out.write("            <div class=\"card border-info\">\n");
      out.write("                <h4>Inicia Sesión</h4>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"accountInfo, card bg-info\">\n");
      out.write("    <fieldset class=\"login\" style=\"font-size:smaller\">\n");
      out.write("        <p>\n");
      out.write("            <label for=\"ctl00_leftColumn_LoginUser_UserName\" id=\"ctl00_leftColumn_LoginUser_UserNameLabel\"><u>U</u>suario:</label><br />\n");
      out.write("            <input name=\"ctl00$leftColumn$LoginUser$UserName\" type=\"text\" size=\"13\" id=\"ctl00_leftColumn_LoginUser_UserName\" accesskey=\"u\" tabindex=\"60\" class=\"textEntry, form-control\" autocomplete=\"off\" /><br />\n");
      out.write("            <span id=\"ctl00_leftColumn_LoginUser_UserNameRequired\" title=\"El nombre de usuario es obligatorio.\" class=\"failureNotification\" style=\"color:Red;visibility:hidden;\">*</span><br />\n");
      out.write("            <label for=\"ctl00_leftColumn_LoginUser_Password\" id=\"ctl00_leftColumn_LoginUser_PasswordLabel\"><u>P</u>assword:</label><br />\n");
      out.write("            <input name=\"ctl00$leftColumn$LoginUser$Password\" type=\"password\" size=\"13\" id=\"ctl00_leftColumn_LoginUser_Password\" accesskey=\"p\" tabindex=\"61\" class=\"passwordEntry, form-control\" autocomplete=\"off\" /><br />\n");
      out.write("            <span id=\"ctl00_leftColumn_LoginUser_PasswordRequired\" title=\"La contraseña es obligatoria.\" class=\"failureNotification\" style=\"color:Red;visibility:hidden;\">*</span><br />\n");
      out.write("            <label for=\"ctl00_leftColumn_LoginUser_CaptchaCodeTextBox\" id=\"ctl00_leftColumn_LoginUser_CaptchaLabel\"><u>C</u>aptcha:</label><br />\n");
      out.write("            <input name=\"ctl00$leftColumn$LoginUser$CaptchaCodeTextBox\" type=\"text\" size=\"13\" id=\"ctl00_leftColumn_LoginUser_CaptchaCodeTextBox\" accesskey=\"c\" tabindex=\"62\" class=\"textEntry, form-control\" autocomplete=\"off\" />\n");
      out.write("            <span id=\"ctl00_leftColumn_LoginUser_CaptchaRequiredValidator\" title=\"CAPTCHA es obligatorio\" style=\"color:Red;visibility:hidden;\">*</span>\n");
      out.write("        </p>\n");
      out.write("    </fieldset>\n");
      out.write("<div align=\"center\">\n");
      out.write("    <p class=\"submitButton\">\n");
      out.write("        <div class=\"LBD_CaptchaDiv \" id=\"c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaDiv\" style=\"width: 140px !important; height: 50px !important; \"><!--\n");
      out.write("        --><div class=\"LBD_CaptchaImageDiv\" id=\"c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImageDiv\" style=\"width: 110px !important; height: 50px !important;\"><!--\n");
      out.write("            --><a target=\"_blank\" href=\"http://captcha.com/asp.net-captcha-info.html\" title=\"BotDetect Control\" onclick=\"c_default_ctl00_leftcolumn_loginuser_logincaptcha.OnHelpLinkClick(); return c_default_ctl00_leftcolumn_loginuser_logincaptcha.FollowHelpLink;\"><img class=\"LBD_CaptchaImage\" id=\"c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaImage\" src=\"/BotDetectCaptcha.ashx?get=image&amp;c=c_default_ctl00_leftcolumn_loginuser_logincaptcha&amp;t=a688871bd1104e0cb328ac635124aa1b\" alt=\"CAPTCHA\" /></a><!--\n");
      out.write("        --></div><!--\n");
      out.write("        --><div class=\"LBD_CaptchaIconsDiv\" id=\"c_default_ctl00_leftcolumn_loginuser_logincaptcha_CaptchaIconsDiv\" style=\"width: 24px !important;\"><!--\n");
      out.write("            --><a class=\"LBD_ReloadLink\" id=\"c_default_ctl00_leftcolumn_loginuser_logincaptcha_ReloadLink\" href=\"#\" onclick=\"c_default_ctl00_leftcolumn_loginuser_logincaptcha.ReloadImage(); this.blur(); return false;\" title=\"Change the CAPTCHA code\"><img class=\"LBD_ReloadIcon\" id=\"c_default_ctl00_leftcolumn_loginuser_logincaptcha_ReloadIcon\" src=\"..\\Spring\\img\\cap.jpg\" alt=\"Change the CAPTCHA code\" /></a><!--\n");
      out.write("        --></div>\n");
      out.write("        <script src=\"/BotDetectCaptcha.ashx?get=clientScriptInclude\" type=\"text/javascript\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    //<![CDATA[\n");
      out.write("      try{(function(){var bdrsn = document.createElement('script'); bdrsn.type = 'text/javascript'; bdrsn.async = true; bdrsn.src = document.location.protocol + '//remote.captcha.com/include.js?i=ATABMAEwATMBMAIxNhT93OmAIvSwNXGDqVLEf-HrzxvnwA'; var fsn = document.getElementsByTagName('script')[0]; fsn.parentNode.insertBefore(bdrsn, fsn);})();} catch(err){}\n");
      out.write("    //]]>\n");
      out.write("    </script>\n");
      out.write("\t\t  </div>\n");
      out.write("                   <!--CAPTCHA-->\n");
      out.write("                   \n");
      out.write("                   <input type=\"submit\" name=\"ctl00$leftColumn$LoginUser$LoginButton\" value=\"Iniciar\" onclick=\"javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions(&quot;ctl00$leftColumn$LoginUser$LoginButton&quot;, &quot;&quot;, true, &quot;LoginUserValidationGroup&quot;, &quot;&quot;, false, false))\" id=\"ctl00_leftColumn_LoginUser_LoginButton\" class=\"btn btn-success\">\n");
      out.write("                    <a href=\"index.htm\" type=\"submit\" value=\"Regresar\" class=\"btn btn-success\">Regresar</a>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("                  ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
