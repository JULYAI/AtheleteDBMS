package KDh.gym.dbms.service;

import KDh.gym.dbms.entity.Project;

import java.util.List;

public interface ProjectService {
    int addProject(Project project);
    int deleteByPId(int pId);
    int updateProject(Project project);
    List<String> find();
    List<String> findByPId(int pId);
    List<String> findBypName(String pName);
}
