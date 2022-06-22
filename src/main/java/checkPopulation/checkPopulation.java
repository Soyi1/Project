package checkPopulation;

import dao.checkPopulationDao;
import dto.populationList;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "checkPopulation", value = "/check/population")
public class checkPopulation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        HttpSession session = request.getSession();

        try {
            String inputPlace = request.getParameter("inputPlace");
            int year = Integer.parseInt(request.getParameter("year"));

            populationList newPopulationList = new populationList(inputPlace, year);

            checkPopulationDao dao = new checkPopulationDao();
            JSONObject json = dao.getPopulationList(newPopulationList);

            String allPopulation = json.getString("allPopulation");
            String over65 = json.getString("over65");
            String percent65 = json.getString("percent65");
            String proportionOver65 = json.getString("proportionOver65");

            session.setMaxInactiveInterval(3600);
            session.setAttribute("placeName", inputPlace);
            session.setAttribute("allPopulation", allPopulation);
            session.setAttribute("over65", over65);
            session.setAttribute("percent65", percent65);
            session.setAttribute("year", year);
            session.setAttribute("proportionOver65", proportionOver65);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (JSONException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
