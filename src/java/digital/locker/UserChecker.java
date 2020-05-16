package digital.locker;

/**
 *
 * @author nemo
 */
public class UserChecker {

    public boolean isUser(String apiUrl, String emailField) {

        boolean isUser = false;

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
                String emailAddressDb = dataObject.getString("emailAddress");

                if (emailField.equals(emailAddressDb)) {

                    isUser = true;
                    break;

                } else {

                    isUser = false;

                }

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

        if (isUser) {
            return true;
        } else {
            return false;
        }

    }

}
