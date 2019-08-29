package KDh.gym.dbms.service;

import KDh.gym.dbms.dao.ScoreDao;
import KDh.gym.dbms.dao.ScoreDaoImpl;
import KDh.gym.dbms.entity.Score;

import java.util.List;

public class ScoreServiceImpl implements ScoreService{
    private ScoreDao scoreDao = new ScoreDaoImpl();

    @Override
    public int addScore(Score score) {
        if (scoreDao.insert(score) > 0) {
            System.out.println("W");
        } else {
            System.out.println("L");
        }
        return scoreDao.insert(score);
    }

    @Override
    public int deleteByAId(int aId) {
        if (scoreDao.deleteByaId(aId) > 0) {
            System.out.println("W");
        } else {
            System.out.println("L");
        }
        return scoreDao.deleteByaId(aId);
    }

    @Override
    public int updateScore(Score score){
        if (scoreDao.update(score)>0){
            System.out.println("W");
        }
        else{
            System.out.println("L");
        }
        return scoreDao.update(score);
    }

    @Override
    public List<String> find() {
        if(scoreDao.find() != null){
            System.out.println(scoreDao.find());
        }else {
            System.out.println("L");
        }
        return scoreDao.find();
    }

    @Override
    public List<String> findByaId(int aId, int pId) {
        if(scoreDao.findByaId(aId,pId) != null){
            System.out.println(scoreDao.findByaId(aId,pId));
        }else {
            System.out.println("L");
        }
        return scoreDao.findByaId(aId,pId);
    }

    @Override
    public List<String> findBypId(int pId,int aId, int staffId) {
        if(scoreDao.findBypId(pId,aId,staffId) != null){
            System.out.println(scoreDao.findBypId(pId,aId,staffId));
        }else {
            System.out.println("L");
        }
        return scoreDao.findBypId(pId,aId,staffId);
    }

    public List<String> findByType(String type,int aId,int pId){
        if(scoreDao.findByType(type,aId,pId) != null){
            System.out.println(scoreDao.findByType(type,aId,pId));
        }else {
            System.out.println("L");
        }
        return scoreDao.findByType(type,aId,pId);
    }

    @Override
    public List<String> findBysId(int sId) {
        if(scoreDao.findBysId(sId) != null){
            System.out.println(scoreDao.findBysId(sId));
        }else {
            System.out.println("L");
        }
        return scoreDao.findBysId(sId);
    }

    @Override
    public List<String> findByStaffId(int staffId) {
        if(scoreDao.findByStaffId(staffId) != null){
            System.out.println(scoreDao.findByStaffId(staffId));
        }else {
            System.out.println("L");
        }
        return scoreDao.findBysId(staffId);
    }

    @Override
    public List<String> findP_DScore(int pId, int aId, int staffId, String type) {
        if(scoreDao.findP_DScore(pId,aId,staffId,type) != null){
            System.out.println(scoreDao.findP_DScore(pId,aId,staffId,type));
        }else {
            System.out.println("L");
        }
        return scoreDao.findP_DScore(pId,aId,staffId,type);
    }
}
