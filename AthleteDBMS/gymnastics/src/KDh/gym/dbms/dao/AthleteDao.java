package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Athlete;

import java.util.List;

public interface AthleteDao {
    int insert(Athlete athlete);
    int deleteByAId(int aId);
    int update(Athlete athlete);
    List<String> find();
    List<String> findByAId(int aId);
    List<String> findByAName(String aName);
    List<String> findByASex(String aSex);
    List<String> findByAGroupId(int aGroupId);
}
