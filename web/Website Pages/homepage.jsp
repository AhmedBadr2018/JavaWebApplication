<%-- 
    Document   : homePage
    Created on : May 7, 2020, 11:55:38 PM
    Author     : nemo
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Digital locker</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Digital locker Website" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/style0.css" />
        <link rel="stylesheet" type="text/css" href="css/style1.css" />
        <link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
        <!--link for country-region-dropdown-menu-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css?family=Strait|Chonburi" rel="stylesheet">
        <script src="assets/js/en_only/geodatasource-cr.min.js"></script>
        <script type="text/javascript" src="assets/js/Gettext.js"></script>
        <link rel="stylesheet" href="assets/css/geodatasource-countryflag.css">
        <script type="text/javascript">
            $(document).ready(function () {
                $("#citySelection").on('change', function () {
                    $("#display").html("You have selected " + $("#countrySelection").children("option").filter(":selected").text() + " > " + $(this).children("option").filter(":selected").text());
                    jQuery("#userCountry").val($("#countrySelection").children("option").filter(":selected").text());
                    jQuery("#userCity").val($(this).children("option").filter(":selected").text());

                    console.log("You have selected: " + $("#countrySelection").children("option").filter(":selected").text() + " > " + $(this).children("option").filter(":selected").text());

                });
            });
        </script>

        <!--link 'International Telephone Input'-->
        <link rel="stylesheet" href="buildIntlTel/css/intlTelInput.css">
    </head>

    <body>

        <div class="container">

            <header>
                <h1>Digital locker <span>website</span></h1>
                <nav class="codrops-demos">
                    <span>Click <strong>"Join us"</strong> to create a new account.</span>
                </nav>
            </header>

            <section>
                <div id="page_container" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">

                        <div id="login" class="animate form">

                            <form  method="GET" action="loginFunctions.jsp" autocomplete="on">
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="username" class="uname" data-icon="u"> Your email or username </label>
                                    <input id="email" name="email" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                                    <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                                <p class="keeplogin"> 
                                    <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> 
                                    <label for="loginkeeping">Keep me logged in</label>
                                </p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
                                </p>
                                <p style="text-align: center">
                                    Not a member yet ?
                                    <a href="#toregister" class="to_register">Join us</a>
                                </p>
                            </form>

                        </div>

                        <div id="register" class="animate form">

                            <form method="POST" action="signupFunctions.jsp" autocomplete="on">

                                <h1> Sign up </h1>

                                <p> 
                                    <label for="fullNameSignup" class="uname" data-icon="u">Full name</label>
                                    <input id="fullNameSignup" name="fullNameSignup" required="required" type="text" placeholder="mysuperusername690" />
                                </p>
                                <p>
                                    <label for="emailSignup" class="youmail" data-icon="e" >Email address</label>
                                    <input id="emailSignup" name="emailSignup" required="required" type="email" placeholder="mysupermail@mail.com"/> 
                                </p>
                                <label for="userMobileNumber">Mobile Number</label>
                                <p>
                                    <input id="mobileSignup" style="width: 207%; text-align: center" name="mobileSignup" required="required" type="tel"/>
                                </p>
                                <input type="hidden" id="countryCode" name ="countryCode" value="1" >
                                <p>
                                    <label for="userDateOfBirth">Date of birth</label>
                                    <input id="dateOfBirthSignup" style="text-align: left" name="dateOfBirthSignup" required="required" placeholder="eg. 03/06/1992" type="date"/> 
                                </p>
                                <p> 
                                    <label for="passwordSignup" class="youpasswd" data-icon="p">Your password</label>
                                    <input id="passwordSignup" name="passwordSignup" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                    <label for="passwordSignup_confirm" class="youpasswd" data-icon="p">Please confirm your password</label>
                                    <input id="passwordSignupConfirm" name="passwordSignupConfirm" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>

                                <center>
                                    <label for="userCountry">Your country</label>
                                    <select id="countrySelection" class="form-control gds-cr" class="theme-construction" country-data-region-id="citySelection" data-language="en"></select>
                                </center>

                                <br>
                                <center>
                                    <label for="userCity">Your city</label>
                                    <select id="citySelection" class="form-control" class="theme-construction"></select>
                                </center>
                                <input type="hidden" id="userCountry" name="userCountry">
                                <input type="hidden" id="userCity" name="userCity">
                                <br>

                                <p class="signin button"> 
                                    <input type="submit" value="Sign up"/> 
                                </p>
                                <p style="text-align: center">
                                    Already a member ?
                                    <a href="#tologin" class="to_register"> Login now </a>
                                </p>
                            </form>

                        </div>

                    </div>

                </div>
            </section>
        </div>

        <script type="text/javascript">

            //{"code":"TOO_MANY_REQUESTS","message":"The 'tryout' API key is heavily rate limited
            //and is only meant for a few initial tests.","resolution":"Sign up for an API key
            //and get 100,000 free look up credits at https://ipregistry.co"}

            let apiUrl = 'https://api.ipregistry.co/?key=h0tmnchc5bv20f&pretty=true';

            function getJsonData(url) {

                var request = new XMLHttpRequest();

                request.onreadystatechange = function () {
                    if (request.readyState === 4 && request.status === 200) {

                        var json = JSON.parse(request.responseText);
                        console.log('Your country is ' + json['location']['country']['name']);
                        console.log('Your city is ' + json['location']['city']);

                    }
                };

                request.open('GET', url, true);
                request.send();

            }
        </script>

        <script src="buildIntlTel/js/intlTelInput.js"></script>
        <script type="text/javascript">
            var input = document.querySelector("#mobileSignup");
            window.intlTelInput(input, {utilsScript: "buildIntlTel/js/utils.js", });

            var input = $('#mobileSignup');
            var country = $('#countryCode');
            var iti = intlTelInput(input.get(0));
            // listen to the telephone input for changes
            input.on('countrychange', function (e) {
                // change the hidden input value to the selected country code
                country.val(iti.getSelectedCountryData().dialCode);
            });
        </script>

    </body>

</html>
