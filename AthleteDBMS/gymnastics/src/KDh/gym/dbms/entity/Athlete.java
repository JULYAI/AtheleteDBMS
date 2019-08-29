package KDh.gym.dbms.entity;

public class Athlete {
    private int aId;
    private String aName;
    private String aSex;
    private int aGroupId;

    public int getAID() {
        return aId;
    }
    public void setAID(int aId){
        this.aId = aId;
    }

    public String getAName(){
        return aName;
    }
    public void setAName(String aName){
        this.aName = aName;
    }

    public String getASex(){
        return aSex;
    }
    public void setASex(String aSex){
        this.aSex = aSex;
    }

    public int getAGroupId(){
        return aGroupId;
    }
    public void setAGroupId(int aGroupId){
        this.aGroupId = aGroupId;
    }
}
