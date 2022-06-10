package checkPopulation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "list", value = "/list")
public class list extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter output = response.getWriter();

        String json = "[";

        for (populationList yourPlace : checkPopulationStatus.yourPlaceList) {
            String data = "{\"nthPlaceName\": \"" + yourPlace.getInputPlace() + "\"}";
            json = json + data + ",";
        }

        json = json.substring(0, json.length() - 1);
        json = json + "]";
        output.print(json);
        output.close();
    }
}