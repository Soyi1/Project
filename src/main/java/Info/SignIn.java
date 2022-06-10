package Info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignIn", value = "/sign/in")
public class SignIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");
        String PW = request.getParameter("PW");

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String userName = "root";
        String password = "soyikim4092";

        boolean isLogin = false;

        for (CustomerInfo nthInfo : signUp.InfoList) {
            String nthID = nthInfo.getID();
            String nthPW = nthInfo.getPW();

            if (ID.equals(nthID) && PW.equals(nthPW)) {
                isLogin = true;

                break;
            }
        }

        if (isLogin) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogin", true);
            session.setAttribute("User", ID);
            session.setMaxInactiveInterval(3600);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
