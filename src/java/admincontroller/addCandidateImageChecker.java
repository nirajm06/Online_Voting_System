package admincontroller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ratho
 */
@MultipartConfig(maxFileSize = 16177215) // Adjust file size limit if needed
public class addCandidateImageChecker extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream inputStream = null;
        
        String name = request.getParameter("name");
        Part filePart = request.getPart("empimage"); // Updated field name
        if (filePart != null) {
            inputStream = filePart.getInputStream();
        }

        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinevotingsystem", "root", "root");

            String query = "UPDATE candidate1 SET image = ? WHERE name = ?";
            System.out.println(query);
            pst = con.prepareStatement(query);
            pst.setBlob(1, inputStream);
            pst.setString(2, name);

            int i = pst.executeUpdate();
            if (i > 0) {
                System.out.println("File uploaded and saved into database");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        } finally {
            if (pst != null) try { pst.close(); } catch (SQLException e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        response.sendRedirect("Add_CandidateImage.jsp");
    }
}
