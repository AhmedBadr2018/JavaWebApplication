package test.api;

/**
 *
 * @author nemo
 */
public class TestData {

    public static void main(String... args) {

        String apiUrl = "https://ipinfo.io";

        java.net.HttpURLConnection urlConnection = null;
        java.io.InputStream inputStream = null;
        java.net.URL mUrl = null;
        String fullData = "";

        try {

            mUrl = new java.net.URL(apiUrl);
            urlConnection = (java.net.HttpURLConnection) mUrl.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(15000);
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            java.io.InputStreamReader reader = new java.io.InputStreamReader(inputStream);

            int data = reader.read();

            while (data != -1) {

                char currentData = (char) data;
                fullData += currentData;
                data = reader.read();

            }

            System.out.println(fullData);

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
