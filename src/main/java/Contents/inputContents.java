package Contents;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "inputContents", value = "/input/contents")
public class inputContents extends HttpServlet {
    public static List<ContentsList> contentsList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        HttpSession session = request.getSession();

        String whoseContents = (String) session.getAttribute("loginUser");

        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        if (!(title.equals("")) && !(contents.equals(""))) {
            if(whoseContents.equals("admin01")) {
                title = "<공지>" + title;
            }

            ContentsList list = new ContentsList(title, contents);
            contentsList.add(list);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}