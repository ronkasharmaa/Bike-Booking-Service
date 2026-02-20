import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class VehicleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.sendRedirect("addVehicle.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        HttpSession session = req.getSession();

        int user_id = (int) session.getAttribute("user_id");

        String vin = req.getParameter("vin");
        String number = req.getParameter("number");
        String model = req.getParameter("model");
        String brand = req.getParameter("brand");

        try {

            Connection conn = DBConnection.getConnection();

            PreparedStatement ps =
            conn.prepareStatement(
            "INSERT INTO vehicles(user_id,vin,vehicle_number,model,brand) VALUES(?,?,?,?,?)");

            ps.setInt(1,user_id);
            ps.setString(2,vin);
            ps.setString(3,number);
            ps.setString(4,model);
            ps.setString(5,brand);

            ps.executeUpdate();

            res.sendRedirect("DashboardServlet");

        }
        catch(Exception e) {

            e.printStackTrace();

            // self redirect
            res.sendRedirect("VehicleServlet");

        }
    }
}