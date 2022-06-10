package Info;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "signUp", value = "/sign/up")
public class signUp extends HttpServlet {
    public static List<CustomerInfo> InfoList = new ArrayList<>();

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

        if (PW.equals(PW_check) && (isSuitable == true)) {
            CustomerInfo newInfo = new CustomerInfo(ID, PW);
            InfoList.add(newInfo);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}