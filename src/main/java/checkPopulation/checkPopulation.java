package checkPopulation;

import Mysql.DatabaseManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "checkPopulation", value = "/check/population")
public class checkPopulation extends HttpServlet {
    public static List<populationList> getPlaceList = new ArrayList<>();	// 행정 구역 17개를 저장하기 위한 ArrayList

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        String year = request.getParameter("year");
        String inputPlace = request.getParameter("inputPlace");

        Connection conn = DatabaseManager.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        if (conn != null) {
            if (year.equals("2010")) {
                try {
                    String sql = "SELECT * FROM place_2010 WHERE placeName = ?";

                    pstmt = DatabaseManager.getPstmt(conn, sql);
                    pstmt.setString(1, inputPlace);

                    rs = pstmt.executeQuery();

                    if (rs.next()) {
                        HttpSession session = request.getSession();
                        session.setMaxInactiveInterval(3600);
                        session.setAttribute("placeName", inputPlace);
                        session.setAttribute("allPopulation", rs.getString("allPopulation"));
                        session.setAttribute("over65", rs.getString("over65"));
                        session.setAttribute("percent65", rs.getString("percent65"));

                        PrintWriter output = response.getWriter();

                        String json = "{\"placeName\": \"" + inputPlace + "\", \"allPopulation\": \"" + rs.getString("allPopulation") + "\", \"over65\": \"" + rs.getString("over65") + "\", \"percent65\": \"" + rs.getString("percent65") + "\"}";
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
            } else if (year.equals("2015")) {
                try {
                    String sql = "SELECT * FROM place_2015 WHERE placeName = ?";

                    pstmt = DatabaseManager.getPstmt(conn, sql);
                    pstmt.setString(1, inputPlace);

                    rs = pstmt.executeQuery();

                    if (rs.next()) {
                        HttpSession session = request.getSession();
                        session.setMaxInactiveInterval(3600);
                        session.setAttribute("placeName", inputPlace);
                        session.setAttribute("allPopulation", rs.getString("allPopulation"));
                        session.setAttribute("over65", rs.getString("over65"));
                        session.setAttribute("percent65", rs.getString("percent65"));

                        PrintWriter output = response.getWriter();

                        String json = "{\"placeName\": \"" + inputPlace + "\", \"allPopulation\": \"" + rs.getString("allPopulation") + "\", \"over65\": \"" + rs.getString("over65") + "\", \"percent65\": \"" + rs.getString("percent65") + "\"}";
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
            } else if (year.equals("2020")) {
                try {
                    String sql = "SELECT * FROM place_2020 WHERE placeName = ?";

                    pstmt = DatabaseManager.getPstmt(conn, sql);
                    pstmt.setString(1, inputPlace);

                    rs = pstmt.executeQuery();

                    if (rs.next()) {
                        HttpSession session = request.getSession();
                        session.setMaxInactiveInterval(3600);
                        session.setAttribute("placeName", inputPlace);
                        session.setAttribute("allPopulation", rs.getString("allPopulation"));
                        session.setAttribute("over65", rs.getString("over65"));
                        session.setAttribute("percent65", rs.getString("percent65"));

                        PrintWriter output = response.getWriter();

                        String json = "{\"placeName\": \"" + inputPlace + "\", \"allPopulation\": \"" + rs.getString("allPopulation") + "\", \"over65\": \"" + rs.getString("over65") + "\", \"percent65\": \"" + rs.getString("percent65") + "\"}";
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
            } else if (year.equals("2022")) {
                try {
                    String sql = "SELECT * FROM place_2022 WHERE placeName = ?";

                    pstmt = DatabaseManager.getPstmt(conn, sql);
                    pstmt.setString(1, inputPlace);

                    rs = pstmt.executeQuery();

                    if (rs.next()) {
                        HttpSession session = request.getSession();
                        session.setMaxInactiveInterval(3600);
                        session.setAttribute("placeName", inputPlace);
                        session.setAttribute("allPopulation", rs.getString("allPopulation"));
                        session.setAttribute("over65", rs.getString("over65"));
                        session.setAttribute("percent65", rs.getString("percent65"));

                        PrintWriter output = response.getWriter();

                        String json = "{\"placeName\": \"" + inputPlace + "\", \"allPopulation\": \"" + rs.getString("allPopulation") + "\", \"over65\": \"" + rs.getString("over65") + "\", \"percent65\": \"" + rs.getString("percent65") + "\"}";
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
        }
    }
}
