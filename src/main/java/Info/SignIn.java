package Info;

import Mysql.DatabaseManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "SignIn", value = "/sign/in")
public class SignIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");
        String PW = request.getParameter("PW");

        Connection conn = DatabaseManager.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        if (conn != null) {
            try {
                String sql = "SELECT * FROM customer_info WHERE userID = ? AND userPW = ?";

                pstmt = DatabaseManager.getPstmt(conn, sql);
                pstmt.setString(1, ID);
                pstmt.setString(2, PW);

                rs = pstmt.executeQuery();

                if (rs.next()) {
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(3600);
                    session.setAttribute("loginUser", ID);
                } else {
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
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
