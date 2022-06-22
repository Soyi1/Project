package service;

import dto.CustomerInfo;
import dao.customerInfoDao;

public class customerService {
    public int signUpService(CustomerInfo newCustomerInfo) {
        customerInfoDao dao = new customerInfoDao();
        boolean success = dao.signUp(newCustomerInfo);

        if (success) {
            return 200;
        } else {
            return 400;
        }
    }

    public int IDcheckService(CustomerInfo newCustomerInfo) {
        customerInfoDao dao = new customerInfoDao();
        boolean success = dao.IDcheck(newCustomerInfo);

        if (success) {
            return 200;
        } else {
            return 409;
        }
    }

    public int SignInService(CustomerInfo newCustomerInfo) {
        customerInfoDao dao = new customerInfoDao();
        boolean success = dao.signIn(newCustomerInfo);

        if (success) {
            return 200;
        } else {
            return 400;
        }
    }
}
