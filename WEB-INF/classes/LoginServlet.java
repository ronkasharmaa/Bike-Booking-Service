import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
            conn.prepareStatement(
            "SELECT * FROM acoounts WHERE email=? AND password=?");

            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                HttpSession session = req.getSession();

                session.setAttribute("user_id",
                rs.getInt("user_id"));

                session.setAttribute("name",
                rs.getString("name"));

                // redirect to servlet (not JSP)
                res.sendRedirect("DashboardServlet");

            }
            else {

                res.sendRedirect("LoginServlet");

            }

        }
        catch(Exception e) {

            e.printStackTrace();
            res.sendRedirect("LoginServlet");

        }
    }
}