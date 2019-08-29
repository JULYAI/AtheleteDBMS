package KDh.gym.dbms.entity;

public class User {
    private int uId;
    private String uName;
    private String password;
    private int tId;
    private boolean isOnline;

    public int getuId(){
        return uId;
    }
    public void setuId(int uId){
        this.uId = uId;
    }

    public String getuName(){
        return uName;
    }
    public void setuName(String uName){
        this.uName = uName;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public int gettId(){
        return tId;
    }
    public void settId(int tId){
        this.tId = tId;
    }

    public boolean getisOnline(){
        return isOnline;
    }
    public void setisOnline(boolean isOnline){
        this.isOnline = isOnline;
    }
}
