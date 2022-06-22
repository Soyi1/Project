package checkPopulation;

import dto.populationList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "list", value = "/list")
public class list extends HttpServlet {
    public static List<populationList> getPopulationList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String inputPlace = request.getParameter("inputPlace");
            int year = Integer.parseInt(request.getParameter("year"));

            populationList getList = new populationList(inputPlace, year);
            getPopulationList.add(getList);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}