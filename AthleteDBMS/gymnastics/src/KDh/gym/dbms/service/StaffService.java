package KDh.gym.dbms.service;

import KDh.gym.dbms.entity.Staff;

import java.util.List;

public interface StaffService {
    int addStaff(Staff staff);
    int deleteBySId(int sId);
    int updateStaff(Staff staff);
    List<String> find();
    List<String> findBySId(int sId);
    List<String> findBySName(String sName);
    List<String> findByTId(int tId);
    List<String> findByRole(String role);
}
