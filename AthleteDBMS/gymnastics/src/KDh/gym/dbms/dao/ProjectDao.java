package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Project;

import java.util.List;

public interface ProjectDao {
    int insert(Project project);
    int deleteByPId(int pId);
    int update(Project project);
    List<String> find();
    List<String> findByPId(int pId);
    List<String> findByPName(String pName);
}
