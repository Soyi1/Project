package checkPopulation;

import Mysql.DatabaseManager;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "checkPopulation", value = "/check/population")
public class checkPopulation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter output = response.getWriter();

        JSONObject json = new JSONObject();

        try {
            int year = Integer.parseInt(request.getParameter("year"));
            String inputPlace = request.getParameter("inputPlace");
            String proportionOver65 = null;

            Connection conn = DatabaseManager.getConnection();
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            if (conn != null) {
                try {
                    String sql = null;

                    if (year == 2010) {
                        sql = "SELECT * FROM place_2010 WHERE placeName = ?";
                    } else if (year == 2015) {
                        sql = "SELECT * FROM place_2015 WHERE placeName = ?";
                    } else if (year == 2020) {
                        sql = "SELECT * FROM place_2020 WHERE placeName = ?";
                    } else {
                        sql = "SELECT * FROM place_2022 WHERE placeName = ?";
                    }

                    pstmt = DatabaseManager.getPstmt(conn, sql);
                    pstmt.setString(1, inputPlace);

                    rs = pstmt.executeQuery();

                    if (rs.next()) {
                        if (7 < rs.getFloat("percent65")) {
                            proportionOver65 = "고령화 사회";
                        } else if (14 < rs.getFloat("percent65")) {
                            proportionOver65 = "고령 사회";
                        } else if (20 < rs.getFloat("percent65")) {
                            proportionOver65 = "초고령 사회";
                        }

                        session.setMaxInactiveInterval(3600);
                        session.setAttribute("placeName", inputPlace);
                        session.setAttribute("allPopulation", rs.getString("allPopulation"));
                        session.setAttribute("over65", rs.getString("over65"));
                        session.setAttribute("percent65", rs.getString("percent65"));
                        session.setAttribute("year", year);
                        session.setAttribute("proportionOver65", proportionOver65);

                        json.put("placeName", inputPlace);
                        json.put("allPopulation", rs.getString("allPopulation"));
                        json.put("over65", rs.getString("over65"));
                        json.put("percent65", rs.getString("percent65"));
                        json.put("proportionOver65", proportionOver65);

                        output.print(json);
                        output.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DatabaseManager.closeResultSet(rs);
                    DatabaseManager.closePstmt(pstmt);
                    DatabaseManager.closeConn(conn);
                }
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
