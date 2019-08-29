package KDh.gym.dbms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import KDh.gym.dbms.entity.User;
import KDh.gym.dbms.util.Tools;

public class UserDaoImpl implements UserDao{
    @Override
    public int insert(User user) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "INSERT INTO user (UID,UName, Password, TID, isOnline) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1, user.getuId());
            pstmt.setString(2, user.getuName());
            pstmt.setString(3,user.getPassword());
            pstmt.setInt(4,user.getuId());
            pstmt.setBoolean(5,user.getisOnline());
            count = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException var) {
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    @Override
    public int deleteByUId(int uId) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "DELETE FROM user WHERE UID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1, uId);
            count = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException var) {
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    @Override
    public int update(User user) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "UPDATE user SET  Password = ? WHERE UID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,user.getPassword());
            pstmt.setInt(2,user.getuId());
            count = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException var) {
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    @Override
    public List<String> find() {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM user";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("UID"));
                list.add(rs.getString("UName"));
                list.add(rs.getString("Password"));
                list.add(rs.getString("TID"));
                list.add(rs.getString("isOnline"));
            }
            pstmt.close();
        } catch (SQLException var) {
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<String> findByUId(int uId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM user WHERE UID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,uId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("UID"));
                list.add(rs.getString("UName"));
                list.add(rs.getString("Password"));
                list.add(rs.getString("TID"));
                list.add(rs.getString("isOnline"));
            }
            pstmt.close();
        } catch (SQLException var) {
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<String> findByUsername(String username) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM user WHERE UName = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("UID"));
                list.add(rs.getString("UName"));
                list.add(rs.getString("Password"));
                list.add(rs.getString("TID"));
                list.add(rs.getString("isOnline"));
            }
            pstmt.close();
        } catch (SQLException var) {
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM user WHERE UName = ? AND Password = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setuName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setisOnline(true);
            }
        } catch (SQLException var) {
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }

        return user;
    }


}
