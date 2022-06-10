package Contents;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "titleList", value = "/titleList")
public class titleList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(inputContents.contentsList.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            response.setContentType("application/json;charset=UTF-8");

            PrintWriter output = response.getWriter();

            String json = "[";

            for(ContentsList list : inputContents.contentsList) {
                String data = "{\"title\": \"" + list.getTitle() + "\", \"contents\": \"" + list.getContents() + "\"}";

                json = json + data + ",";
            }

            json = json.substring(0, json.length() - 1);

            json = json + "]";

            output.print(json);
            output.close();
        }
    }
}