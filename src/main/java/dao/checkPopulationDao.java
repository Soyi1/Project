package dao;

import Mysql.DatabaseManager;
import dto.populationList;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkPopulationDao {
    public JSONObject getPopulationList(populationList newPopulationList) {
        JSONObject json = new JSONObject();

        Connection conn = DatabaseManager.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String proportionOver65 = null;

        if (conn != null) {
            try {
                String sql = null;

                if (newPopulationList.getYear() == 2010) {
                    sql = "SELECT * FROM place_2010 WHERE placeName = ?";
                } else if (newPopulationList.getYear() == 2015) {
                    sql = "SELECT * FROM place_2015 WHERE placeName = ?";
                } else if (newPopulationList.getYear() == 2020) {
                    sql = "SELECT * FROM place_2020 WHERE placeName = ?";
                } else {
                    sql = "SELECT * FROM place_2022 WHERE placeName = ?";
                }

                pstmt = DatabaseManager.getPstmt(conn, sql);
                pstmt.setString(1, newPopulationList.getInputPlace());

                rs = pstmt.executeQuery();

                if (rs.next()) {
                    if (7 < rs.getFloat("percent65")) {
                        proportionOver65 = "고령화 사회";
                    } else if (14 < rs.getFloat("percent65")) {
                        proportionOver65 = "고령 사회";
                    } else if (20 < rs.getFloat("percent65")) {
                        proportionOver65 = "초고령 사회";
                    }

                    json.put("placeName", newPopulationList.getInputPlace());
                    json.put("allPopulation", rs.getString("allPopulation"));
                    json.put("over65", rs.getString("over65"));
                    json.put("percent65", rs.getString("percent65"));
                    json.put("proportionOver65", proportionOver65);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DatabaseManager.closeResultSet(rs);
                DatabaseManager.closePstmt(pstmt);
                DatabaseManager.closeConn(conn);
            }
        }

        return json;
    }
}
