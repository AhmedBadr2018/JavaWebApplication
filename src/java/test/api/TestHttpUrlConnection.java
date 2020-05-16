package test.api;

/**
 *
 * @author nemo
 */
public class TestHttpUrlConnection {

    private static final String apiUrl = "http://localhost:8080/JavaWebApplication/api/users";

    public static void main(String... args) {

        /*
        String fullName = "Ahmed Badr";
        String emailAddress = "badr@gmail.com";
        String userPassword = "LdH74017Hajf";
        String mobileNumber = "+0201148683970";
        String dateOfBirth = "03/06/1992";
        String userCity = "Cairo";
        String userCountry = "Egypt";
        addNewUser(fullName, emailAddress, userPassword, mobileNumber, dateOfBirth, userCity, userCountry);
         */
        getAllUsers();
    }

    private static void addNewUser(String fullName, String emailAddress, String userPassword,
            String mobileNumber, String dateOfBirth, String userCity, String userCountry) {

        java.net.HttpURLConnection urlConnection = null;
        java.net.URL mUrl = null;

        try {

            mUrl = new java.net.URL(apiUrl);
            urlConnection = (java.net.HttpURLConnection) mUrl.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(15000);
            urlConnection.connect();

            String jsonInputString = "{\"dateOfBirth\": \"" + dateOfBirth + "\","
                    + "\"emailAddress\": \"" + emailAddress + "\","
                    + "\"fullName\": \"" + fullName + "\","
                    + "\"mobileNumber\": \"" + mobileNumber + "\","
                    + "\"userCity\": \"" + userCity + "\","
                    + "\"userCountry\": \"" + userCountry + "\","
                    + "\"userPassword\": \"" + userPassword + "\"}";

            try (java.io.OutputStream os = urlConnection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            try (java.io.BufferedReader br = new java.io.BufferedReader(
                    new java.io.InputStreamReader(urlConnection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());

                org.json.JSONObject jsonObject = new org.json.JSONObject(response.toString());
                try {
                    String responseMessage = jsonObject.getString("resultCode");
                    if (responseMessage.equals("User has added successfully!")) {
                        System.out.println("User has inserted with username: " + fullName);
                    } else {
                        System.out.println("User hasn't inserted.");
                    }
                } catch (org.json.JSONException jSONException) {
                    jSONException.getCause();
                }

            }

        } catch (java.net.MalformedURLException murle) {
            murle.printStackTrace();
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }

    }

    private static void getAllUsers() {

        java.net.HttpURLConnection urlConnection = null;
        java.io.InputStream inputStream = null;
        java.net.URL mUrl = null;
        String fullJsonData = "";

        try {

            mUrl = new java.net.URL(apiUrl);
            urlConnection = (java.net.HttpURLConnection) mUrl.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(15000);
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

                int userId = dataObject.getInt("userId");
                String fullName = dataObject.getString("fullName");
                String emailAddress = dataObject.getString("emailAddress");
                String userPassword = dataObject.getString("userPassword");
                String dateOfBirth = dataObject.getString("dateOfBirth");
                String mobileNumber = dataObject.getString("mobileNumber");
                String userCity = dataObject.getString("userCity");
                String userCountry = dataObject.getString("userCountry");

                System.out.println("userId: " + userId + "\n"
                        + "fullName: " + fullName + "\n"
                        + "emailAddress: " + emailAddress + "\n"
                        + "userPassword: " + userPassword + "\n"
                        + "dateOfBirth: " + dateOfBirth + "\n"
                        + "mobileNumber: " + mobileNumber + "\n"
                        + "userCity: " + userCity + "\n"
                        + "userCountry: " + userCountry + "\n\n");
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

}
