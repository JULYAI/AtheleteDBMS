package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.User;

import java.util.List;

public interface UserDao {
    int insert(User user);
    int deleteByUId(int uId);
    int update(User user);
    List<String> find();
    List<String> findByUId(int uId);
    List<String> findByUsername(String username);
    User login(String username, String password);
    //缺退出函数即将isonline的值更改为false
}
