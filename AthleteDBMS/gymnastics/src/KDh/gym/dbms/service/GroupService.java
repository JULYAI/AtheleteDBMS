package KDh.gym.dbms.service;

import KDh.gym.dbms.entity.Group;

import java.util.List;

public interface GroupService {
    int addGroup(Group group);
    int deleteByGID(int gId);
    int updateGroup(Group group);
    List<String> find();
    List<String> findByGId(int gId);
    List<String> findByGName(String gName);
}
