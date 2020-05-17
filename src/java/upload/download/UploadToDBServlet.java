package upload.download;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadToDB")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class UploadToDBServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);

        /* toPath.... D:/Projects/NetBeansProjects/JavaWebApplication/web/Website Pages/uploadToDB.jsp */
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("Website Pages/uploadToDB.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);

        Connection conn = null;
        try {
            // Connection to Database
            // (See more in JDBC Tutorial).
            conn = MySQLConnUtils.getMySQLConnection();
            conn.setAutoCommit(false);

            String description = request.getParameter("description");

            // Part list (multi files).
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && fileName.length() > 0) {
                    // File data
                    InputStream is = part.getInputStream();
                    // Write to file
                    this.writeToDB(conn, fileName, is, description);
                }
            }
            conn.commit();

            // Upload successfully!.
            response.sendRedirect(request.getContextPath() + "/uploadToDBResults");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsps/uploadToDB.jsp");

            // Error.... java.lang.IllegalStateException: Cannot forward after response has been committed
            dispatcher.forward(request, response);
        } finally {
            this.closeQuietly(conn);
        }

    }

    private void closeQuietly(Connection connection) {

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }

    private Long getMaxAttachmentId(Connection conn) throws SQLException {
        String sql = "Select max(a.id) from Attachment a";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            long max = rs.getLong(1);
            return max;
        }
        return 0L;
    }

    private void writeToDB(Connection conn, String fileName, InputStream inputStream, String description) throws SQLException {

        String sql = "Insert into Attachment(ID, File_Name, File_Data, Description) values (?,?,?,?) ";
        PreparedStatement pstm = conn.prepareStatement(sql);

        Long id = this.getMaxAttachmentId(conn) + 1;

        pstm.setLong(1, id);
        pstm.setString(2, fileName);
        pstm.setBlob(3, inputStream);
        pstm.setString(4, description);

        pstm.executeUpdate();
    }

}
