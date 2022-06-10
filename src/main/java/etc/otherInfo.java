package etc;

import Contents.ContentsList;
import Contents.inputContents;
import Info.CustomerInfo;
import Info.signUp;
import checkPopulation.checkPopulation;
import checkPopulation.populationList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/other/info"}, loadOnStartup = 1)
public class otherInfo extends HttpServlet {
    @Override
    public void init() throws ServletException {
        CustomerInfo admin = new CustomerInfo("admin1", "adminKim1!");
        signUp.InfoList.add(admin);

        CustomerInfo ksoi1004 = new CustomerInfo("ksoi1004", "ksoi1004!");
        signUp.InfoList.add(ksoi1004);

        for(int i = 1; i <= 20; i++) {
            ContentsList list = new ContentsList("제목" + i, "내용1" + i);
            inputContents.contentsList.add(list);
        }

        populationList placeList1 = new populationList("서울특별시", 9506778, 1619507, 17.0);
        populationList placeList2 = new populationList("부산광역시", 3343504, 691489, 20.7);
        populationList placeList3 = new populationList("광주광역시", 1438463, 215662, 15.0);
        populationList placeList4 = new populationList("대구광역시", 2380494, 423030, 17.8);
        populationList placeList5 = new populationList("대전광역시", 1450057, 224785, 15.5);
        populationList placeList6 = new populationList("인천광역시", 2952699, 443849, 15.0);
        populationList placeList7 = new populationList("울산광역시", 1118010, 156120, 14.0);
        populationList placeList8 = new populationList("충청남도", 2119099, 425400, 20.1);
        populationList placeList9 = new populationList("충청북도", 1597484, 306655, 19.2);
        populationList placeList10 = new populationList("전라남도", 1829501, 448807, 24.5);
        populationList placeList11 = new populationList("전라북도", 1782205, 401290, 22.5);
        populationList placeList12 = new populationList("경상남도", 3303274, 617827, 18.7);
        populationList placeList13 = new populationList("경상북도", 2619641, 604182, 23.1);
        populationList placeList14 = new populationList("강원도", 1539036, 338655, 22.0);
        populationList placeList15 = new populationList("경기도", 13575936, 1915723, 14.1);
        populationList placeList16 = new populationList("세종특별자치시", 377296, 38330, 10.2);
        populationList placeList17 = new populationList("제주특별자치도", 677218, 111985, 16.5);

        checkPopulation.getPlaceList.add(placeList1);
        checkPopulation.getPlaceList.add(placeList2);
        checkPopulation.getPlaceList.add(placeList3);
        checkPopulation.getPlaceList.add(placeList4);
        checkPopulation.getPlaceList.add(placeList5);
        checkPopulation.getPlaceList.add(placeList6);
        checkPopulation.getPlaceList.add(placeList7);
        checkPopulation.getPlaceList.add(placeList8);
        checkPopulation.getPlaceList.add(placeList9);
        checkPopulation.getPlaceList.add(placeList10);
        checkPopulation.getPlaceList.add(placeList11);
        checkPopulation.getPlaceList.add(placeList12);
        checkPopulation.getPlaceList.add(placeList13);
        checkPopulation.getPlaceList.add(placeList14);
        checkPopulation.getPlaceList.add(placeList15);
        checkPopulation.getPlaceList.add(placeList16);
        checkPopulation.getPlaceList.add(placeList17);
    }
}
