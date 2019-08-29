package KDh.gym.dbms.service;

import KDh.gym.dbms.entity.Score;

import java.util.List;

public interface ScoreService {
    int addScore(Score score);
    int deleteByAId(int aId);
    int updateScore(Score score);
    List<String> find();
    List<String> findByStaffId(int staffId);
    List<String> findByaId(int aId,int pId);
    List<String> findByType(String type,int aId,int pId);
    List<String> findBysId(int sId);
    List<String> findBypId(int pId,int aId, int staffId);
    List<String> findP_DScore(int pId,int aId, int staffId,String type);
}
