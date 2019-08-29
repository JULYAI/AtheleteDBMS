package KDh.gym.dbms.service;

import KDh.gym.dbms.dao.GroupDao;
import KDh.gym.dbms.dao.GroupDaoImpl;
import KDh.gym.dbms.entity.Group;

import java.util.List;

public class GroupServiceImpl implements GroupService{
    private GroupDao groupDao= new GroupDaoImpl();

    public GroupServiceImpl(){

    }

    @Override
    public int addGroup(Group group) {
        if(groupDao.insert(group)>0){
            System.out.println("W");
        }
        else {
            System.out.println("L");
        }
        return groupDao.insert(group);
    }

    @Override
    public int deleteByGID(int gId) {
        if(groupDao.deleteByGId(gId)>0){
            System.out.println("W");
        }
        else {
            System.out.println("L");
        }
        return groupDao.deleteByGId(gId);
    }

    @Override
    public int updateGroup(Group group) {
        if(groupDao.update(group)>0){
            System.out.println("W");
        }
        else {
            System.out.println("L");
        }
        return groupDao.update(group);
    }

    @Override
    public List<String> find() {
        if(groupDao.find() != null) {
            System.out.println(groupDao.find());
        }
        else {
            System.out.println("L");
        }
        return groupDao.find();
    }

    @Override
    public List<String> findByGId(int gId) {
        if(groupDao.findByGId(gId) != null) {
            System.out.println(groupDao.findByGId(gId));
        }
        else {
            System.out.println("L");
        }
        return groupDao.findByGId(gId);
    }

    @Override
    public List<String> findByGName(String gName) {
        if(groupDao.findByGName(gName) != null) {
            System.out.println(groupDao.findByGName(gName));
        }
        else {
            System.out.println("L");
        }
        return groupDao.findByGName(gName);
    }
}
