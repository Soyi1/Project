package Info;

import Mysql.DatabaseManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "signUp", value = "/sign/up")
public class signUp extends HttpServlet {
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");
        String PW = request.getParameter("PW");
        String PW_check = request.getParameter("PW_check");

        boolean isSuitable = false;

        int EngCnt = 0;
        int numCnt = 0;
        int specialCharCnt = 0;
        int othCnt = 0;

        for(int i = 0; i <= PW.length() - 1; i++) {
            char nth = PW.charAt(i);

            if (('a' <= nth && nth <= 'z') || ('A' <= nth && nth <= 'Z')) {
                EngCnt++;
            } else if ('0' <= nth && nth <= '9') {
                numCnt++;
            } else if (nth == '~' || nth == '!' || nth == '@' || nth == '#'|| nth == '$'|| nth == '%'|| nth == '&'|| nth == '*') {
                specialCharCnt++;
            } else {
                othCnt++;
            }
        }

        // 올바른 비밀번호 형식이 아닐 시, 경고 문구 출력 후 비밀번호 새로 입력
        if((EngCnt == 0 || numCnt == 0) || (PW.length() < 5 || 15 < PW.length()) || specialCharCnt == 0 || othCnt != 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            isSuitable = true;
        }

        if (PW.equals(PW_check) && isSuitable) {
            Connection conn = DatabaseManager.getConnection();
            PreparedStatement pstmt = null;

            if (conn != null) {
                try {
                    String sql = "INSERT INTO customer_info VALUES(?, ?)";

                    pstmt = DatabaseManager.getPstmt(conn, sql);
                    pstmt.setString(1, ID);
                    pstmt.setString(2, PW);

                    pstmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DatabaseManager.closePstmt(pstmt);
                    DatabaseManager.closeConn(conn);
                }

            }
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}