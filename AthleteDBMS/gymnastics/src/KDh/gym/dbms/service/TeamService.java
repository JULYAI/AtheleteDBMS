package KDh.gym.dbms.service;

import KDh.gym.dbms.entity.Team;

import java.util.List;

public interface TeamService {
    int addTeam(Team team);
    int deleteByTId(int tId);
    int updateTeam(Team team);
    List<String> find();
    List<String> findByTId(int tId);
    List<String> findByTName(String tName);
}
