package KDh.gym.dbms.service;

import KDh.gym.dbms.entity.Athlete;

import java.util.List;

public interface AthleteService {
    int addAthlete(Athlete athlete);
    int deleteByAId(int aId);
    int updateAthlete(Athlete athlete);
    List<String> find();
    List<String> findByAId(int aId);
    List<String> findByAName(String aName);
    List<String> findBySex(String sex);
    List<String> findByAGroupId(int aGroupId);
}
