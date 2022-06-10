package Info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IDcheck", value = "/id/check")
public class IDcheck extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("ID");

        boolean isExistID = false;
        boolean isSuitable = false;

        int EngCnt = 0;
        int numCnt = 0;
        int othCnt = 0;

        for(int i = 0; i <= ID.length() - 1; i++) {
            char nth = ID.charAt(i);

            if (('a' <= nth && nth <= 'z') || ('A' <= nth && nth <= 'Z')) {
                EngCnt++;
            } else if ('0' <= nth && nth <= '9') {
                numCnt++;
            } else {
                othCnt++;
            }
        }

        // 올바른 아이디 형식이 아닐 시 상태 코드 400번 전달
        if((EngCnt == 0 || numCnt == 0) || (ID.length() < 4 || 12 < ID.length()) || othCnt != 0) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            isSuitable = true;
        }

        for(CustomerInfo nthInfo : signUp.InfoList) {
            String nthID = nthInfo.getID();

            if (ID.equals(nthID)) {
                isExistID = true;

                break;
            }
        }

        if (isExistID) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        } else if ((isExistID == false) && (isSuitable == true)) {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
