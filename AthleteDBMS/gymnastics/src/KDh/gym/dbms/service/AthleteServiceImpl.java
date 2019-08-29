package KDh.gym.dbms.service;

import KDh.gym.dbms.dao.AthleteDao;
import KDh.gym.dbms.dao.AthleteDaoImpl;
import KDh.gym.dbms.entity.Athlete;

import java.util.List;

public class AthleteServiceImpl implements AthleteService {
    private AthleteDao athleteDao = new AthleteDaoImpl();

    @Override
    public int addAthlete(Athlete athlete) {
        if(athleteDao.insert(athlete)>0){
            System.out.println("W");
        }
        else {
            System.out.println("L");
        }
        return athleteDao.insert(athlete);
    }

    @Override
    public int deleteByAId(int aId) {
        if(athleteDao.deleteByAId(aId)>0){
            System.out.println("W");
        }
        else {
            System.out.println("L");
        }
        return athleteDao.deleteByAId(aId);
    }

    @Override
    public int updateAthlete(Athlete athlete) {
        if(athleteDao.update(athlete)>0){
            System.out.println("W");
        }
        else {
            System.out.println("L");
        }
        return athleteDao.update(athlete);
    }

    @Override
    public List<String> find() {
        if(athleteDao.find() != null){
            System.out.println(athleteDao.find());
        }
        else {
            System.out.println("L");
        }
        return athleteDao.find();
    }

    @Override
    public List<String> findByAId(int aId) {
        if(athleteDao.findByAId(aId) != null){
            System.out.println(athleteDao.findByAId(aId));
        }
        else {
            System.out.println("L");
        }
        return athleteDao.findByAId(aId);
    }

    @Override
    public List<String> findByAName(String aName) {
        if(athleteDao.findByAName(aName) != null){
            System.out.println(athleteDao.findByAName(aName));
        }
        else {
            System.out.println("L");
        }
        return athleteDao.findByAName(aName);
    }

    @Override
    public List<String> findBySex(String sex) {
        if(athleteDao.findByASex(sex) != null){
            System.out.println(athleteDao.findByASex(sex));
        }
        else {
            System.out.println("L");
        }
        return athleteDao.findByASex(sex);
    }

    @Override
    public List<String> findByAGroupId(int aGroupId) {
        if(athleteDao.findByAGroupId(aGroupId) != null){
            System.out.println(athleteDao.findByAGroupId(aGroupId));
        }
        else {
            System.out.println("L");
        }
        return athleteDao.findByAGroupId(aGroupId);
    }
}
