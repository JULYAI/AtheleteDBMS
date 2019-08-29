package KDh.gym.dbms.service;

import KDh.gym.dbms.dao.UserDao;
import KDh.gym.dbms.dao.UserDaoImpl;
import KDh.gym.dbms.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public int addUser(User user) {
        if ((userDao.insert(user)) > 0) {
            System.out.println("W");
        } else {
            System.out.println("L");
        }
        return this.userDao.insert(user);
    }

    @Override
    public int deleteByUId(int uId) {
        if(userDao.deleteByUId(uId)>0){
            System.out.println("W");
        } else {
            System.out.println("L");
        }
        return userDao.deleteByUId(uId);
    }

    @Override
    public int updateUser(User user) {
        if((userDao.update(user)) > 0) {
            System.out.println("W");
        }else{
            System.out.println("L");
        }
        return this.userDao.update(user);
    }

    @Override
    public List<String> find() {
        if(userDao.find() != null){
            System.out.println(userDao.find());
        }else {
            System.out.println("L");
        }
        return userDao.find();
    }

    @Override
    public List<String> findByUId(int uId) {
        if(userDao.findByUId(uId) != null){
            System.out.println(userDao.findByUId(uId));
        }else {
            System.out.println("L");
        }
        return userDao.findByUId(uId);
    }

    @Override
    public List<String> findByUsername(String username) {
        if(userDao.findByUsername(username) != null){
            System.out.println(userDao.findByUsername(username));
        }else {
            System.out.println("L");
        }
        return userDao.findByUsername(username);
    }

    @Override
    public User login(String username, String password) {
        if(userDao.login(username,password) != null) {
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
        return this.userDao.login(username, password);
    }


}
