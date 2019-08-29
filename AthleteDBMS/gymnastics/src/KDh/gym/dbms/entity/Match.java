package KDh.gym.dbms.entity;

public class Match {
    private int mId;
    private int aId;
    private int pId;
    private int seq;
    private int state;
    private int gId;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getgId(){ return gId;}

    public void setgId(int gId) {
        this.gId = gId;
    }
}
