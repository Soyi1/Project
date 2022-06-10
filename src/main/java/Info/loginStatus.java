package Info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login/status")
public class loginStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String User = (String) session.getAttribute("User");

        if (User == null) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            PrintWriter output = response.getWriter();

            output.print(User);
            output.close();
        }
    }
}
