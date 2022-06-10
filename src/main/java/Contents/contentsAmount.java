package Contents;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "contentsAmount", value = "/contents/amount")
public class contentsAmount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int amount = inputContents.contentsList.size();

        PrintWriter output = response.getWriter();
        output.print(amount);
        output.close();
    }
}