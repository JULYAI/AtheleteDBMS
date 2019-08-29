package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Staff;
import KDh.gym.dbms.util.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDaoImpl implements StaffDao {
    @Override
    public int insert(Staff staff) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "INSERT INTO staff (SID,SName,TID,Role,Tel) VALUES (?,?,?,?,?)";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,staff.getsId());
            pstmt.setString(2,staff.getsName());
            pstmt.setInt(3,staff.gettId());
            pstmt.setString(4,staff.getRole());
            pstmt.setString(5,staff.getTel());
            count = pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    @Override
    public int deleteBySId(int sId) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "DELETE FROM staff WHERE SID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,sId);
            count = pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    @Override
    public int update(Staff staff) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "UPDATE staff SET tel = ? WHERE sId = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,staff.getTel());
            pstmt.setInt(2,staff.getsId());
            count = pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException var9){
            var9.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    @Override
    public List<String> find() {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM staff";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("SID"));
                list.add(rs.getString("SName"));
                list.add(rs.getString("TID"));
                list.add(rs.getString("Role"));
                list.add(rs.getString("Tel"));
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
    public List<String> findBySId(int sId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM staff WHERE SID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,sId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("SID"));
                list.add(rs.getString("SName"));
                list.add(rs.getString("TID"));
                list.add(rs.getString("Role"));
                list.add(rs.getString("Tel"));
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
    public List<String> findBySName(String sName) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM staff WHERE SName = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,sName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("SID"));
                list.add(rs.getString("SName"));
                list.add(rs.getString("TID"));
                list.add(rs.getString("Role"));
                list.add(rs.getString("Tel"));
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
    public List<String> findByTId(int tId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM staff WHERE TID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,tId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("SID"));
                list.add(rs.getString("SName"));
                list.add(rs.getString("TID"));
                list.add(rs.getString("Role"));
                list.add(rs.getString("Tel"));
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
    public List<String> findByRole(String role) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM staff WHERE Role = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,role);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("SID"));
                list.add(rs.getString("SName"));
                list.add(rs.getString("TID"));
                list.add(rs.getString("Role"));
                list.add(rs.getString("Tel"));
            }
            pstmt.close();
        } catch (SQLException var) {
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return list;
    }
}
