package KDh.gym.dbms.entity;

public class Staff {
    private int sId;
    private String sName;
    private int tId;
    private String role;
    private String tel;

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int stId) {
        this.tId = stId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
