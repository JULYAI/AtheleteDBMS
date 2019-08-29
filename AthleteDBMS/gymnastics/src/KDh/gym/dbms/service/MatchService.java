package KDh.gym.dbms.service;

import KDh.gym.dbms.entity.Match;

import java.util.List;

public interface MatchService {
    int addMatch(Match match);
    int deleteByMID(int mId);
    int updateMatch(Match match);
    List<String> find();
    List<String> findByPId(int pId);
    List<String> findByMId(int mId);
    List<String> findByAId(int aId,int gId);
    List<String> findBySeq(int seq,int gId);
}
