package dto;

public class CustomerInfo {
    private String id;
    private String pw;
    private String pwCheck;

    public CustomerInfo(String id) {
        this.id = id;
    }

    public CustomerInfo(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public CustomerInfo(String ID, String PW, String pwCheck) {
        this.id = ID;
        this.pw = PW;
        this.pwCheck = pwCheck;
    }

    public String getID() {
        return id;
    }
    public void setID(String ID) {
        id = ID;
    }
    public String getPW() {
        return pw;
    }
    public void setPW(String PW) {
        pw = PW;
    }

    public String getPwCheck() {
        return pwCheck;
    }

    public void setPwCheck(String pwCheck) {
        this.pwCheck = pwCheck;
    }
}