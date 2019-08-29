package KDh.gym.dbms.service;

import KDh.gym.dbms.dao.ProjectDao;
import KDh.gym.dbms.dao.ProjectDaoImpl;
import KDh.gym.dbms.entity.Project;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    ProjectDao projectDao = new ProjectDaoImpl();

    public ProjectServiceImpl(){

    }

    @Override
    public int addProject(Project project) {
        if(projectDao.insert(project)>0){
            System.out.println("W");
        }
        else{
            System.out.println("L");
        }
        return projectDao.insert(project);
    }

    @Override
    public int deleteByPId(int pId) {
        if(projectDao.deleteByPId(pId)>0){
            System.out.println("W");
        }
        else {
            System.out.println("L");
        }
        return  projectDao.deleteByPId(pId);
    }

    @Override
    public int updateProject(Project project) {
        if(projectDao.update(project)>0){
            System.out.println("W");
        }
        else {
            System.out.println("L");
        }
        return projectDao.update(project);
    }

    @Override
    public List<String> find() {
        if(projectDao.find() != null){
            System.out.println(projectDao.find());
        }
        else {
            System.out.println("L");
        }
        return projectDao.find();
    }

    @Override
    public List<String> findByPId(int pId) {
        if(projectDao.findByPId(pId) != null){
            System.out.println(projectDao.findByPId(pId));
        }
        else {
            System.out.println("L");
        }
        return projectDao.find();
    }

    @Override
    public List<String> findBypName(String pName) {
        if(projectDao.findByPName(pName) != null){
            System.out.println(projectDao.findByPName(pName));
        }
        else {
            System.out.println("L");
        }
        return projectDao.find();
    }
}
