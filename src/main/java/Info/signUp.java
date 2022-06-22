package Info;

import dto.CustomerInfo;
import service.customerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "signUp", value = "/sign/up")
public class signUp extends HttpServlet {
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");
        String PW = request.getParameter("PW");
        String PW_check = request.getParameter("PW_check");

        CustomerInfo customerInfo = new CustomerInfo(ID, PW, PW_check);

       customerService service = new customerService();
       int statusCode = service.signUpService(customerInfo);

       response.setStatus(statusCode);
    }
}