package org.apache.jsp.Website_0020Pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<html lang=\"en\" class=\"no-js\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <!-- <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">  -->\n");
      out.write("        <title>Digital locker</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> \n");
      out.write("        <meta name=\"description\" content=\"Digital locker Website\" />\n");
      out.write("        <meta name=\"keywords\" content=\"html5, css3, form, switch, animation, :target, pseudo-class\" />\n");
      out.write("        <meta name=\"author\" content=\"Codrops\" />\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../favicon.ico\"> \n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style0.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style1.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/animate-custom.css\" />\n");
      out.write("        <!--link for country-region-dropdown-menu-->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Strait|Chonburi\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"assets/js/en_only/geodatasource-cr.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"assets/js/Gettext.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/geodatasource-countryflag.css\">\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#citySelection\").on('change', function () {\n");
      out.write("                    $(\"#display\").html(\"You have selected \" + $(\"#countrySelection\").children(\"option\").filter(\":selected\").text() + \" > \" + $(this).children(\"option\").filter(\":selected\").text());\n");
      out.write("                    jQuery(\"#userCountry\").val($(\"#countrySelection\").children(\"option\").filter(\":selected\").text());\n");
      out.write("                    jQuery(\"#userCity\").val($(this).children(\"option\").filter(\":selected\").text());\n");
      out.write("\n");
      out.write("                    console.log(\"You have selected: \" + $(\"#countrySelection\").children(\"option\").filter(\":selected\").text() + \" > \" + $(this).children(\"option\").filter(\":selected\").text());\n");
      out.write("\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <!--link 'International Telephone Input'-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"buildIntlTel/css/intlTelInput.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <header>\n");
      out.write("                <h1>Digital locker <span>website</span></h1>\n");
      out.write("                <nav class=\"codrops-demos\">\n");
      out.write("                    <span>Click <strong>\"Join us\"</strong> to create a new account.</span>\n");
      out.write("                </nav>\n");
      out.write("            </header>\n");
      out.write("\n");
      out.write("            <section>\n");
      out.write("                <div id=\"page_container\" >\n");
      out.write("                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->\n");
      out.write("                    <a class=\"hiddenanchor\" id=\"toregister\"></a>\n");
      out.write("                    <a class=\"hiddenanchor\" id=\"tologin\"></a>\n");
      out.write("                    <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("                        <div id=\"login\" class=\"animate form\">\n");
      out.write("\n");
      out.write("                            <form  method=\"GET\" action=\"loginFunctions.jsp\" autocomplete=\"on\">\n");
      out.write("                                <h1>Log in</h1> \n");
      out.write("                                <p> \n");
      out.write("                                    <label for=\"username\" class=\"uname\" data-icon=\"u\"> Your email or username </label>\n");
      out.write("                                    <input id=\"email\" name=\"email\" required=\"required\" type=\"text\" placeholder=\"myusername or mymail@mail.com\"/>\n");
      out.write("                                </p>\n");
      out.write("                                <p> \n");
      out.write("                                    <label for=\"password\" class=\"youpasswd\" data-icon=\"p\"> Your password </label>\n");
      out.write("                                    <input id=\"password\" name=\"password\" required=\"required\" type=\"password\" placeholder=\"eg. X8df!90EO\" /> \n");
      out.write("                                </p>\n");
      out.write("                                <p class=\"keeplogin\"> \n");
      out.write("                                    <input type=\"checkbox\" name=\"loginkeeping\" id=\"loginkeeping\" value=\"loginkeeping\" /> \n");
      out.write("                                    <label for=\"loginkeeping\">Keep me logged in</label>\n");
      out.write("                                </p>\n");
      out.write("                                <p class=\"login button\"> \n");
      out.write("                                    <input type=\"submit\" value=\"Login\" /> \n");
      out.write("                                </p>\n");
      out.write("                                <p style=\"text-align: center\">\n");
      out.write("                                    Not a member yet ?\n");
      out.write("                                    <a href=\"#toregister\" class=\"to_register\">Join us</a>\n");
      out.write("                                </p>\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div id=\"register\" class=\"animate form\">\n");
      out.write("\n");
      out.write("                            <form method=\"POST\" action=\"signupFunctions.jsp\" autocomplete=\"on\">\n");
      out.write("\n");
      out.write("                                <h1> Sign up </h1>\n");
      out.write("\n");
      out.write("                                <p> \n");
      out.write("                                    <label for=\"fullNameSignup\" class=\"uname\" data-icon=\"u\">Full name</label>\n");
      out.write("                                    <input id=\"fullNameSignup\" name=\"fullNameSignup\" required=\"required\" type=\"text\" placeholder=\"mysuperusername690\" />\n");
      out.write("                                </p>\n");
      out.write("                                <p>\n");
      out.write("                                    <label for=\"emailSignup\" class=\"youmail\" data-icon=\"e\" >Email address</label>\n");
      out.write("                                    <input id=\"emailSignup\" name=\"emailSignup\" required=\"required\" type=\"email\" placeholder=\"mysupermail@mail.com\"/> \n");
      out.write("                                </p>\n");
      out.write("                                <label for=\"userMobileNumber\">Mobile Number</label>\n");
      out.write("                                <p>\n");
      out.write("                                    <input id=\"mobileSignup\" style=\"width: 207%; text-align: center\" name=\"mobileSignup\" required=\"required\" type=\"tel\"/>\n");
      out.write("                                </p>\n");
      out.write("                                <input type=\"hidden\" id=\"countryCode\" name =\"countryCode\" value=\"1\" >\n");
      out.write("                                <p>\n");
      out.write("                                    <label for=\"userDateOfBirth\">Date of birth</label>\n");
      out.write("                                    <input id=\"dateOfBirthSignup\" style=\"text-align: left\" name=\"dateOfBirthSignup\" required=\"required\" placeholder=\"eg. 03/06/1992\" type=\"date\"/> \n");
      out.write("                                </p>\n");
      out.write("                                <p> \n");
      out.write("                                    <label for=\"passwordSignup\" class=\"youpasswd\" data-icon=\"p\">Your password</label>\n");
      out.write("                                    <input id=\"passwordSignup\" name=\"passwordSignup\" required=\"required\" type=\"password\" placeholder=\"eg. X8df!90EO\"/>\n");
      out.write("                                </p>\n");
      out.write("                                <p> \n");
      out.write("                                    <label for=\"passwordSignup_confirm\" class=\"youpasswd\" data-icon=\"p\">Please confirm your password</label>\n");
      out.write("                                    <input id=\"passwordSignupConfirm\" name=\"passwordSignupConfirm\" required=\"required\" type=\"password\" placeholder=\"eg. X8df!90EO\"/>\n");
      out.write("                                </p>\n");
      out.write("\n");
      out.write("                                <center>\n");
      out.write("                                    <label for=\"userCountry\">Your country</label>\n");
      out.write("                                    <select id=\"countrySelection\" class=\"form-control gds-cr\" class=\"theme-construction\" country-data-region-id=\"citySelection\" data-language=\"en\"></select>\n");
      out.write("                                </center>\n");
      out.write("\n");
      out.write("                                <br>\n");
      out.write("                                <center>\n");
      out.write("                                    <label for=\"userCity\">Your city</label>\n");
      out.write("                                    <select id=\"citySelection\" class=\"form-control\" class=\"theme-construction\"></select>\n");
      out.write("                                </center>\n");
      out.write("                                <input type=\"hidden\" id=\"userCountry\" name=\"userCountry\">\n");
      out.write("                                <input type=\"hidden\" id=\"userCity\" name=\"userCity\">\n");
      out.write("                                <br>\n");
      out.write("\n");
      out.write("                                <p class=\"signin button\"> \n");
      out.write("                                    <input type=\"submit\" value=\"Sign up\"/> \n");
      out.write("                                </p>\n");
      out.write("                                <p style=\"text-align: center\">\n");
      out.write("                                    Already a member ?\n");
      out.write("                                    <a href=\"#tologin\" class=\"to_register\"> Login now </a>\n");
      out.write("                                </p>\n");
      out.write("                            </form>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("            //{\"code\":\"TOO_MANY_REQUESTS\",\"message\":\"The 'tryout' API key is heavily rate limited\n");
      out.write("            //and is only meant for a few initial tests.\",\"resolution\":\"Sign up for an API key\n");
      out.write("            //and get 100,000 free look up credits at https://ipregistry.co\"}\n");
      out.write("\n");
      out.write("            let apiUrl = 'https://api.ipregistry.co/?key=h0tmnchc5bv20f&pretty=true';\n");
      out.write("\n");
      out.write("            function getJsonData(url) {\n");
      out.write("\n");
      out.write("                var request = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("                request.onreadystatechange = function () {\n");
      out.write("                    if (request.readyState === 4 && request.status === 200) {\n");
      out.write("\n");
      out.write("                        var json = JSON.parse(request.responseText);\n");
      out.write("                        console.log('Your country is ' + json['location']['country']['name']);\n");
      out.write("                        console.log('Your city is ' + json['location']['city']);\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                request.open('GET', url, true);\n");
      out.write("                request.send();\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <script src=\"buildIntlTel/js/intlTelInput.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            var input = document.querySelector(\"#mobileSignup\");\n");
      out.write("            window.intlTelInput(input, {utilsScript: \"buildIntlTel/js/utils.js\", });\n");
      out.write("\n");
      out.write("            var input = $('#mobileSignup');\n");
      out.write("            var country = $('#countryCode');\n");
      out.write("            var iti = intlTelInput(input.get(0));\n");
      out.write("            // listen to the telephone input for changes\n");
      out.write("            input.on('countrychange', function (e) {\n");
      out.write("                // change the hidden input value to the selected country code\n");
      out.write("                country.val(iti.getSelectedCountryData().dialCode);\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
