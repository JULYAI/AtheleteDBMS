package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Match;

import java.util.List;

public interface MatchDao {
    int insert(Match match);
    int deleteByMatchId(int mId);
    int update(Match match);
    List<String> find();
    List<String> findByMId(int mId);
    List<String> findByPId(int pId);
    List<String> findByAId(int aId,int gid);
    List<String> findBySeq(int seq,int gId);
}
