package checkPopulation;

import dto.populationList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "listStatus", value = "/list/status")
public class listStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter output = response.getWriter();

        try {
            String json = "[";

            for (populationList yourPlace : list.getPopulationList) {
                String data = "{\"nthPlaceName\": \"" + yourPlace.getInputPlace() + "\", \"year\": \"" + yourPlace.getYear() + "\"}";
                json = json + data + ",";
            }

            json = json.substring(0, json.length() - 1);
            json = json + "]";
            output.print(json);
            output.close();
        } catch (NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}