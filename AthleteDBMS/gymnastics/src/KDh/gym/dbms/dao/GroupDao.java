package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Group;

import java.util.List;

public interface GroupDao {
    int insert(Group group);
    int deleteByGId(int gId);
    int update(Group group);
    List<String> find();
    List<String> findByGId(int gId);
    List<String> findByGName(String gName);
}
