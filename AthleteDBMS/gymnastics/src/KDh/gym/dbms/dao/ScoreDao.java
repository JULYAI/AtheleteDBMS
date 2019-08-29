package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Score;

import java.util.List;

public interface ScoreDao {
    int insert(Score score);
    int deleteByaId(int aId);
    int update(Score score);
    List<String> findByStaffId(int staffId);
    List<String> find();
    List<String> findByType(String type,int aId,int pId);
    List<String> findByaId(int aId,int pId);
    List<String> findBysId(int sId);
    List<String> findBypId(int pId,int aId,int staffId);
    List<String> findP_DScore(int pId,int aId,int staffId,String type);


}