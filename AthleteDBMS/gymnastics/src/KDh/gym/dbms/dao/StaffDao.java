package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Staff;

import java.util.List;

public interface StaffDao {
    int insert(Staff staff);
    int deleteBySId(int sId);
    int update(Staff staff);
    List<String> find();
    List<String> findBySId(int sId);
    List<String> findBySName(String sName);
    List<String> findByTId(int tId);
    List<String> findByRole(String role);

}
