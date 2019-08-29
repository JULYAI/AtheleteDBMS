package KDh.gym.dbms.service;

import KDh.gym.dbms.dao.MatchDao;
import KDh.gym.dbms.dao.MatchDaoImpl;
import KDh.gym.dbms.entity.Match;

import java.util.List;

public class MatchServiceImpl implements MatchService {
    private MatchDao matchDao = new MatchDaoImpl();

    public MatchServiceImpl(){

    }

    @Override
    public int addMatch(Match match) {
        if(matchDao.insert(match)>0){
            System.out.println("W");
        }
        else {
            System.out.println("L");
        }
        return matchDao.insert(match);
    }

    @Override
    public int deleteByMID(int mId) {
        if(matchDao.deleteByMatchId(mId)>0){
            System.out.println("W");
        }
        else{
            System.out.println("L");
        }
        return matchDao.deleteByMatchId(mId);
    }

    @Override
    public int updateMatch(Match match) {
        if(matchDao.update(match)>0){
            System.out.println("W");
        }
        else {
            System.out.println("L");
        }
        return matchDao.update(match);
    }

    @Override
    public List<String> find() {
        if(matchDao.find() != null){
            System.out.println(matchDao.find());
        }
        else {
            System.out.println("L");
        }
        return matchDao.find();
    }

    @Override
    public List<String> findByMId(int mId) {
        if(matchDao.findByMId(mId) != null){
            System.out.println(matchDao.findByMId(mId));
        }
        else {
            System.out.println("L");
        }
        return matchDao.findByMId(mId);
    }

    @Override
    public List<String> findByPId(int pId) {
        if(matchDao.findByPId(pId)!= null){
            System.out.println(matchDao.findByPId(pId));
        }
        else {
            System.out.println("L");
        }
        return matchDao.findByPId(pId);
    }

    @Override
    public List<String> findByAId(int aId, int gId) {
        if(matchDao.findByAId(aId,gId)!= null){
            System.out.println(matchDao.findByAId(aId,gId));
        }
        else {
            System.out.println("L");
        }
        return matchDao.findByAId(aId,gId);
    }

    @Override
    public List<String> findBySeq(int seq, int gId) {
        if(matchDao.findBySeq(seq,gId)!= null){
            System.out.println(matchDao.findBySeq(seq,gId));
        }
        else {
            System.out.println("L");
        }
        return matchDao.findBySeq(seq,gId);
    }
}
