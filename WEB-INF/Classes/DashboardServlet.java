
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if(session == null) {

            res.sendRedirect("LoginServlet");
            return;
        }

        String name = (String) session.getAttribute("name");
        PrintWriter out = res.getWriter();
        out.println("<h2>Welcome " + name + "</h2>");
        out.println("<a href='VehicleServlet'>Add Vehicle</a><br>");
        out.println("<a href='BookingServlet'>Book Service</a><br>");
        out.println("<a href='LogoutServlet'>Logout</a>");
    }
}