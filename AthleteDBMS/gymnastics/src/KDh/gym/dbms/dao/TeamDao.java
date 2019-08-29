package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Team;

import java.util.List;

public interface TeamDao {
    int insert(Team team);
    int deleteByTId(int tId);
    int update(Team team);
    List<String> find();
    List<String> findByTId(int tId);
    List<String> findByTName(String tName);
}
