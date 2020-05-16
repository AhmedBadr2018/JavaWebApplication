package test.api;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import restful.Users;

/**
 * Jersey REST client generated for REST resource:UsersFacadeREST
 * [restful.users]<br>
 * USAGE:
 * <pre>
 * JerseyClientTester client = new JerseyClientTester();
 * Object response = client.XXX(...);
 * // do whatever with response
 * client.close();
 * </pre>
 *
 * @author nemo
 */
public class JerseyClientTester {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/JavaWebApplication/api";

    public static void main(String... args) {

        getAllUsers();

    }

    static void testAddNew() {

        Users newUser = new Users();
        newUser.setFullName("Hossam Ibrahim");
        newUser.setEmailAddress("hossam@gmail.com");
        newUser.setUserPassword("dakhi74927579");
        newUser.setMobileNumber("+0127498793");
        newUser.setDateOfBirth("01/10/1980");
        newUser.setUserCountry("Egypt");

        createNewUser(newUser);

    }

    private static void createNewUser(Users newUser) {

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(BASE_URI).path("users").path("add");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(newUser, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));

    }

    private static void getAllUsers() {

        Client client = ClientBuilder.newClient();

        String fullGsonResult = client.target(BASE_URI).path("users")
                .request(MediaType.APPLICATION_JSON)
                .header("headerName", "headerValue").get(String.class);

        org.json.JSONArray dataArray = new org.json.JSONArray(fullGsonResult);

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

    }

    private static void getUserById(int userId) {

        Client client = ClientBuilder.newClient();

        String entity = client.target(BASE_URI).path("users" + "/" + userId)
                .request(MediaType.APPLICATION_JSON)
                .header("headerName", "headerValue").get(String.class);

        System.out.println(entity);

    }

    /**
     * private static void updateUser() { Client client =
     * ClientBuilder.newClient(); WebTarget webTarget =
     * client.target("http://localhost:8080/jersey-crud-example/api").path("users")
     * .path("user/1");
     *
     * User user = new User(); user.setId(1); user.setName("Ramesh");
     *
     * Invocation.Builder invocationBuilder =
     * webTarget.request(MediaType.APPLICATION_JSON); Response response =
     * invocationBuilder.put(Entity.entity(user, MediaType.APPLICATION_JSON));
     *
     * String userJson = response.readEntity(String.class);
     *
     * System.out.println(response.getStatus()); System.out.println(userJson); }
     *
     * private static void deleteUser() {
     *
     * Client client = ClientBuilder.newClient(); WebTarget webTarget =
     * client.target("http://localhost:8080/jersey-crud-example/api").path("users")
     * .path("user/100");
     *
     * User user = new User(); user.setId(1); user.setName("Ramesh");
     *
     * Invocation.Builder invocationBuilder = webTarget.request(); Response
     * response = invocationBuilder.delete();
     *
     * System.out.println(response.getStatus());
     * System.out.println(response.readEntity(String.class)); }
     */
    public JerseyClientTester() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("restful.users");
    }

    public String countREST() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("count");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void edit_XML(Object requestEntity, String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void edit_JSON(Object requestEntity, String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T find_XML(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T find_JSON(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findRange_XML(Class<T> responseType, String from, String to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findRange_JSON(Class<T> responseType, String from, String to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void create_XML(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void create_JSON(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T findAll_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T findAll_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void remove(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
    }

    public void close() {
        client.close();
    }

}
