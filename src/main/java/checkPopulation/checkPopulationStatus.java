package checkPopulation;

import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "checkPopulationStatus", value = "/check/population/status")
public class checkPopulationStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter output = response.getWriter();
        JSONObject json = new JSONObject();

        try {
            HttpSession session = request.getSession();
            String placeName = (String) session.getAttribute("placeName");
            String allPopulation = (String) session.getAttribute("allPopulation");
            String over65 = (String) session.getAttribute("over65");
            String percent65 = (String) session.getAttribute("percent65");
            String proportionOver65 = (String) session.getAttribute("proportionOver65");
            int year = ((Integer)session.getAttribute("year")).intValue();

            json.put("placeName", placeName);
            json.put("allPopulation", allPopulation);
            json.put("over65", over65);
            json.put("percent65", percent65);
            json.put("year", year);
            json.put("proportionOver65", proportionOver65);
            output.print(json);
        } catch (NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }

        output.close();
    }
}