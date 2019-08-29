package KDh.gym.dbms.service;

import KDh.gym.dbms.entity.User;

import java.util.List;

public interface UserService {
    int addUser(User user);
    int deleteByUId(int uId);
    int updateUser(User user);
    List<String> find();
    List<String> findByUId(int uId);
    List<String> findByUsername(String username);
    User login(String username, String password);

    //缺退出函数即将isonline的值更改为false
}
