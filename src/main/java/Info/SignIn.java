package Info;

import dto.CustomerInfo;
import service.customerService;

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

        CustomerInfo customerInfo = new CustomerInfo(ID, PW);

        customerService service = new customerService();
        int statusCode = service.SignInService(customerInfo);

        if (statusCode == 200) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(3600);
            session.setAttribute("loginUser", customerInfo.getID());
        }

        response.setStatus(statusCode);
    }
}
