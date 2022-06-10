package checkPopulation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "checkPopulationStatus", value = "/check/population/status")
public class checkPopulationStatus extends HttpServlet {
    public static List<populationList> yourPlaceList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter output = response.getWriter();

        try {
            HttpSession session = request.getSession();
            String nthPlaceName = (String) session.getAttribute("nthPlaceName");
            int nthPopulation = ((Integer) (session.getAttribute("nthPopulation"))).intValue();
            int nthPopulation65 = ((Integer) (session.getAttribute("nthPopulation65"))).intValue();
            double nthPercent65 = ((Double) (session.getAttribute("nthPercent65"))).doubleValue();

            populationList list = new populationList(nthPlaceName);
            yourPlaceList.add(list);

            String json = "{\"nthPlaceName\": \"" + nthPlaceName + "\", \"nthPopulation\": \"" + nthPopulation + "\", \"nthPopulation65\": \"" + nthPopulation65 + "\", \"nthPercent65\": \"" + nthPercent65 + "\"}";
            output.print(json);
        } catch (NullPointerException e) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }

        output.close();
    }
}