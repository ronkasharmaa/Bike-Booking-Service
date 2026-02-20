import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class BookingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.sendRedirect("bookService.jsp");

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        HttpSession session = req.getSession();

        int user_id = (int) session.getAttribute("user_id");

        int vehicle_id =
        Integer.parseInt(req.getParameter("vehicle_id"));

        String service =
        req.getParameter("service");

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
            conn.prepareStatement(
            "INSERT INTO bookings(user_id,vehicle_id,service_type,booking_date,status) VALUES(?,?,?,CURDATE(),'Pending')");

            ps.setInt(1,user_id);
            ps.setInt(2,vehicle_id);
            ps.setString(3,service);

            ps.executeUpdate();

            res.sendRedirect("DashboardServlet");

        }
        catch(Exception e) {

            e.printStackTrace();
            res.sendRedirect("BookingServlet");

        }
    }
}