package KDh.gym.dbms.service;

import KDh.gym.dbms.dao.StaffDao;
import KDh.gym.dbms.dao.StaffDaoImpl;
import KDh.gym.dbms.entity.Staff;

import java.util.List;

public class StaffServiceImpl implements StaffService {
    private StaffDao staffDao = new StaffDaoImpl();

    @Override
    public int addStaff(Staff staff) {
        if(staffDao.insert(staff) > 0){
            System.out.println("W");
        }
        else{
            System.out.println("L");
        }
        return this.staffDao.insert(staff);
    }

    @Override
    public int deleteBySId(int sId) {
        if(staffDao.deleteBySId(sId) > 0){
            System.out.println("W");
        }
        else{
            System.out.println("L");
        }
        return this.staffDao.deleteBySId(sId);
    }

    @Override
    public int updateStaff(Staff staff) {
        if(staffDao.update(staff) > 0){
            System.out.println("W");
        }
        else{
            System.out.println("L");
        }
        return this.staffDao.update(staff);
    }

    @Override
    public List<String> find() {
        if(staffDao.find() != null){
            System.out.println(staffDao.find());
        }
        else{
            System.out.println("L");
        }
        return this.staffDao.find();
    }

    @Override
    public List<String> findBySId(int sId) {
        if(staffDao.findBySId(sId) != null){
            System.out.println(staffDao.findBySId(sId));
        }
        else{
            System.out.println("L");
        }
        return this.staffDao.findBySId(sId);
    }

    @Override
    public List<String> findBySName(String sName) {
        if(staffDao.findBySName(sName) != null){
            System.out.println(staffDao.findBySName(sName));
        }
        else{
            System.out.println("L");
        }
        return this.staffDao.findBySName(sName);
    }

    @Override
    public List<String> findByTId(int tId) {
        if(staffDao.findByTId(tId) != null){
            System.out.println(staffDao.findByTId(tId));
        }
        else{
            System.out.println("L");
        }
        return this.staffDao.findByTId(tId);
    }

    @Override
    public List<String> findByRole(String role) {
        if(staffDao.findByRole(role) != null){
            System.out.println(staffDao.findByRole(role));
        }
        else{
            System.out.println("L");
        }
        return this.staffDao.findByRole(role);
    }
}

