package KDh.gym.dbms.service;

import KDh.gym.dbms.dao.TeamDao;
import KDh.gym.dbms.dao.TeamDaoImpl;
import KDh.gym.dbms.entity.Team;

import java.util.List;

public class TeamServiceImpl implements TeamService {
    private TeamDao teamDao = new TeamDaoImpl();

    @Override
    public int addTeam(Team team) {
        if(teamDao.insert(team) > 0)
        {
            System.out.println("W");
        }
        else{
            System.out.println("L");
        }
        return this.teamDao.insert(team);
    }

    @Override
    public int deleteByTId(int tId) {
        if(teamDao.deleteByTId(tId) > 0)
        {
            System.out.println("W");
        }
        else{
            System.out.println("L");
        }
        return this.teamDao.deleteByTId(tId);
    }

    @Override
    public int updateTeam(Team team) {
        if(teamDao.update(team) > 0)
        {
            System.out.println("W");
        }
        else{
            System.out.println("L");
        }
        return this.teamDao.update(team);
    }

    @Override
    public List<String> find() {
        if(teamDao.find() != null){
            System.out.println(teamDao.find());
        }
        else{
            System.out.println("L");
        }
        return teamDao.find();
    }

    @Override
    public List<String> findByTId(int tId) {
        if(teamDao.findByTId(tId) != null){
            System.out.println(teamDao.findByTId(tId));
        }
        else{
            System.out.println("L");
        }
        return teamDao.findByTId(tId);
    }

    @Override
    public List<String> findByTName(String tName) {
        if(teamDao.findByTName(tName) != null){
            System.out.println(teamDao.findByTName(tName));
        }
        else{
            System.out.println("L");
        }
        return teamDao.findByTName(tName);
    }
}

