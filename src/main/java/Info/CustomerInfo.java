package Info;

public class CustomerInfo {
    private String id;
    private String pw;

    public CustomerInfo(String ID, String PW) {
        this.id = ID;
        this.pw = PW;
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
}