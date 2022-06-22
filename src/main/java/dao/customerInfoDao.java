package dao;

import dto.CustomerInfo;
import Mysql.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class customerInfoDao {
    public boolean signUp(CustomerInfo customerInfo) {
        Connection conn = DatabaseManager.getConnection();
        PreparedStatement pstmt = null;

        boolean success = false;
        boolean isSuitable = false;

        int EngCnt = 0;
        int numCnt = 0;
        int specialCharCnt = 0;
        int othCnt = 0;

        for(int i = 0; i <= customerInfo.getPW().length() - 1; i++) {
            char nth = customerInfo.getPW().charAt(i);

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

        // 올바른 비밀번호 형식일 때
        if(!((EngCnt == 0 || numCnt == 0) || (customerInfo.getPW().length() < 5 || 15 < customerInfo.getPW().length()) || specialCharCnt == 0 || othCnt != 0)) {
            isSuitable = true;
        }

        if (conn != null) {
            if (customerInfo.getPW().equals(customerInfo.getPwCheck()) && isSuitable) {
                try {
                    String sql = "INSERT INTO customer_info VALUES(?, ?)";

                    pstmt = DatabaseManager.getPstmt(conn, sql);
                    pstmt.setString(1, customerInfo.getID());
                    pstmt.setString(2, customerInfo.getPW());

                    pstmt.executeUpdate();

                    success = true;
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    DatabaseManager.closePstmt(pstmt);
                    DatabaseManager.closeConn(conn);
                }
            }
        }

        return success;
    }

    public boolean IDcheck(CustomerInfo customerInfo) {
        Connection conn = DatabaseManager.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        boolean isExistID = false;
        boolean isSuitable = false;
        boolean setDefault = false;

        int EngCnt = 0;
        int numCnt = 0;
        int othCnt = 0;

        for(int i = 0; i <= customerInfo.getID().length() - 1; i++) {
            char nth = customerInfo.getID().charAt(i);

            if (('a' <= nth && nth <= 'z') || ('A' <= nth && nth <= 'Z')) {
                EngCnt++;
            } else if ('0' <= nth && nth <= '9') {
                numCnt++;
            } else {
                othCnt++;
            }
        }

        // 올바른 아이디 형식이 아닐 시 상태 코드 400번 전달
        if(!((EngCnt == 0 || numCnt == 0) || (customerInfo.getID().length() < 4 || 12 < customerInfo.getID().length()) || othCnt != 0)) {
            isSuitable = true;
        }

        if (conn != null) {
            try {
                String sql = "SELECT * FROM customer_info WHERE userID = ?";

                pstmt = DatabaseManager.getPstmt(conn, sql);
                pstmt.setString(1, customerInfo.getID());

                rs = pstmt.executeQuery();

                if (rs.next()) {
                    isExistID = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DatabaseManager.closeResultSet(rs);
                DatabaseManager.closePstmt(pstmt);
                DatabaseManager.closeConn(conn);
            }
        }

        if ((isExistID == false) && (isSuitable == true)) {
            setDefault = true;
        }

        return setDefault;
    }

    public boolean signIn(CustomerInfo customerInfo) {
        boolean isSuccess = false;

        Connection conn = DatabaseManager.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        if (conn != null) {
            try {
                String sql = "SELECT * FROM customer_info WHERE userID = ? AND userPW = ?";

                pstmt = DatabaseManager.getPstmt(conn, sql);
                pstmt.setString(1, customerInfo.getID());
                pstmt.setString(2, customerInfo.getPW());

                rs = pstmt.executeQuery();

                if (rs.next()) {
                    isSuccess = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DatabaseManager.closeResultSet(rs);
                DatabaseManager.closePstmt(pstmt);
                DatabaseManager.closeConn(conn);
            }
        }

        return isSuccess;
    }
}