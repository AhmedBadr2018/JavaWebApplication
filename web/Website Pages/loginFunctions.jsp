<%-- 
    Document   : loginFunctions
    Created on : May 8, 2020, 12:00:31 AM
    Author     : nemo
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@page import="digital.locker.AES256"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Digital locker</title>
    </head>
    <body>
        <%!
            int userId;
            String emailAddress;
            String userPassword;
            boolean isUser = false;
        %>
        <%

            String emailField = request.getParameter("email");
            String passwordField = request.getParameter("password");

            final String apiUrl = "http://localhost:8080/JavaWebApplication/api/users";

            java.net.HttpURLConnection urlConnection = null;
            java.io.InputStream inputStream = null;
            java.net.URL mUrl = null;
            String fullJsonData = "";

            if (emailField.equals("") || passwordField.equals("")) {
                return;
            } else {

                String passwordEncrypt = new AES256().encrypt(passwordField);

                try {

                    mUrl = new java.net.URL(apiUrl);
                    urlConnection = (java.net.HttpURLConnection) mUrl.openConnection();
                    urlConnection.setDoInput(true);
                    urlConnection.setDoOutput(true);
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setRequestProperty("Accept", "application/json");
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.connect();

                    inputStream = urlConnection.getInputStream();
                    java.io.InputStreamReader reader = new java.io.InputStreamReader(inputStream);

                    int data = reader.read();

                    while (data != -1) {

                        char currentData = (char) data;
                        fullJsonData += currentData;
                        data = reader.read();

                    }

                    System.out.println("Response Code: " + urlConnection.getResponseCode() + "\n");

                    org.json.JSONArray dataArray = new org.json.JSONArray(fullJsonData);

                    for (int i = 0; i < dataArray.length(); i++) {

                        org.json.JSONObject dataObject = dataArray.getJSONObject(i);

                        userId = dataObject.getInt("userId");
                        emailAddress = dataObject.getString("emailAddress");
                        userPassword = dataObject.getString("userPassword");
                        String fullName = dataObject.getString("fullName");
                        String dateOfBirth = dataObject.getString("dateOfBirth");
                        String mobileNumber = dataObject.getString("mobileNumber");
                        String userCity = dataObject.getString("userCity");
                        String userCountry = dataObject.getString("userCountry");

                        if (emailField.equals(emailAddress) && passwordEncrypt.equals(userPassword)) {
                            isUser = true;
                            break;
                        } else {
                            isUser = false;
                        }

                    }

                    if (isUser) {
                        session.setAttribute("emailAddress", emailAddress);
                        response.sendRedirect("welcome.jsp");
                    } else {
        %>
        <script type="text/javascript">
            alert("Wrong email or password, try again!");
        </script> 
        <%
                    }

                } catch (java.net.MalformedURLException e) {
                    e.printStackTrace();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        urlConnection.disconnect();
                        inputStream.close();
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        %>
    </body>

</html>
