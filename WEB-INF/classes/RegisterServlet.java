import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.sendRedirect("register.jsp");

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
            conn.prepareStatement(
            "INSERT INTO accounts(name,email,password,phone) VALUES(?,?,?,?)");

            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.setString(4,phone);

            ps.executeUpdate();

            // normal redirection
            res.sendRedirect("LoginServlet");

        }
        catch(Exception e) {
            e.printStackTrace();

            // self redirection
            res.sendRedirect("RegisterServlet");
        }
    }
}