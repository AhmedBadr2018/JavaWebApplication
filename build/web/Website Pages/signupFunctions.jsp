<%-- 
    Document   : signupFunction
    Created on : May 10, 2020, 7:26:51 PM
    Author     : nemo
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@page import="java.lang.*"%>
<%@page import="java.io.OutputStream"%>
<%@page import="digital.locker.UserChecker"%>
<%@page import="digital.locker.AES256"%>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Digital locker</title>
    </head>

    <body>

        <%!
            final String apiUrl = "http://localhost:8080/JavaWebApplication/api/users/add";

            java.net.HttpURLConnection urlConnection = null;
            java.net.URL mUrl = null;
        %>
        <%

            String fullNameSignup = request.getParameter("fullNameSignup");
            String emailSignup = request.getParameter("emailSignup");
            String mobileSignup = request.getParameter("mobileSignup");
            String countryCode = request.getParameter("countryCode");
            String dateOfBirthSignup = request.getParameter("dateOfBirthSignup");
            String passwordSignup = request.getParameter("passwordSignup");
            String passwordSignupConfirm = request.getParameter("passwordSignupConfirm");
            String userCountry = request.getParameter("userCountry");
            String userCity = request.getParameter("userCity");

            if (fullNameSignup != null && !fullNameSignup.trim().equals("")
                    && emailSignup != null && !emailSignup.trim().equals("")
                    && mobileSignup != null && !mobileSignup.trim().equals("")
                    && dateOfBirthSignup != null && !dateOfBirthSignup.trim().equals("")
                    && passwordSignup != null && !passwordSignup.trim().equals("")
                    && passwordSignupConfirm != null && !passwordSignup.trim().equals("")
                    && userCountry != null && !userCountry.trim().equals("")
                    && userCity != null && !userCity.trim().equals("")) {

                if (!passwordSignup.equals(passwordSignupConfirm)) {
        %>
        <script type="text/javascript">
            alert("Your password hasn't matched");
        </script> 
        <%
        } else {
            UserChecker userChecker = new UserChecker();
            if (userChecker.isUser("http://localhost:8080/JavaWebApplication/api/users", emailSignup)) {
        %>
        <script type="text/javascript">
            alert("Email address already exists!");
        </script> 
        <%
        } else {

            try {

                mUrl = new java.net.URL(apiUrl);
                urlConnection = (java.net.HttpURLConnection) mUrl.openConnection();
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Accept", "application/json");
                urlConnection.setRequestProperty("Content-Type", "application/json");
                urlConnection.connect();

                String finalMobileNumber = "+" + countryCode + mobileSignup;

                AES256 aes256 = new AES256();
                String finalPassword = aes256.encrypt(passwordSignup);

                String jsonInputString = "{\"dateOfBirth\": \"" + dateOfBirthSignup + "\","
                        + "\"emailAddress\": \"" + emailSignup + "\","
                        + "\"fullName\": \"" + fullNameSignup + "\","
                        + "\"mobileNumber\": \"" + finalMobileNumber + "\","
                        + "\"userCity\": \"" + userCity + "\","
                        + "\"userCountry\": \"" + userCountry + "\","
                        + "\"userPassword\": \"" + finalPassword + "\"}";

                OutputStream os = urlConnection.getOutputStream();
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);

                java.io.BufferedReader br = new java.io.BufferedReader(
                        new java.io.InputStreamReader(urlConnection.getInputStream()));
                StringBuilder data = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    data.append(responseLine.trim());
                }
                System.out.println(data.toString());

                org.json.JSONObject jsonObject = new org.json.JSONObject(data.toString());

                try {
                    String responseMessage = jsonObject.getString("resultCode");
                    if (responseMessage.equals("User has added successfully!")) {
                        System.out.println("User has inserted with successfully!");
                        session.setAttribute("emailAddress", emailSignup);
                        response.sendRedirect("welcome.jsp");
                    } else {
                        System.out.println("User hasn't inserted.");
        %>
        <script type="text/javascript">
            alert("User hasn't inserted.");
        </script> 
        <%
                            }

                        } catch (org.json.JSONException jSONException) {
                            jSONException.getCause();
                        }

                    } catch (java.net.MalformedURLException murle) {
                        murle.printStackTrace();
                    } catch (java.io.IOException ioe) {
                        ioe.printStackTrace();
                    }

                }

            }

        } else {
        %>
        <script type="text/javascript">
            alert("There's an error, please fill in all the information required.");
        </script> 
        <%
            }

        %>

    </body>

</html>
