package Info;

import dto.CustomerInfo;
import service.customerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IDcheck", value = "/id/check")
public class IDcheck extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");

        CustomerInfo customerInfo = new CustomerInfo(ID);

        customerService service = new customerService();
        int statusCode = service.IDcheckService(customerInfo);

        response.setStatus(statusCode);
    }
}