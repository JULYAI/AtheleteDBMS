package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Score;
import KDh.gym.dbms.util.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDaoImpl implements ScoreDao {
    @Override
    public int insert(Score score) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "INSERT INTO score (AID, SID, PID, grade, type,StaffID) VALUES (?,?,?,?,?,?)";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,score.getaId());
            pstmt.setInt(2,score.getsId());
            pstmt.setInt(3,score.getpId());
            pstmt.setInt(4,score.getGrade());
            pstmt.setString(5,score.getType());
            pstmt.setInt(6,score.getStaffId());
            count = pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    public List<String> findByStaffId(int staffId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM score WHERE StaffID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,staffId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("AID"));
                list.add(rs.getString("SID"));
                list.add(rs.getString("PID"));
                list.add(rs.getString("grade"));
                list.add(rs.getString("type"));
                list.add(rs.getString("StaffID"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public int deleteByaId(int aId) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "DELETE FROM score WHERE AID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,aId);
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
    public int update(Score score) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "UPDATE score SET grade = ? WHERE AID = ? AND PID=? AND StaffID=? AND type = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,score.getGrade());
            pstmt.setInt(2,score.getaId());
            pstmt.setInt(3,score.getpId());
            pstmt.setInt(4,score.getStaffId());
            pstmt.setString(5,score.getType());
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
    public List<String> find() {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM score";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("AID"));
                list.add(rs.getString("SID"));
                list.add(rs.getString("PID"));
                list.add(rs.getString("grade"));
                list.add(rs.getString("type"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<String> findByaId(int aId,int pId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM score WHERE AID = ? AND PID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,aId);
            pstmt.setInt(2,pId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                /*list.add(rs.getString("AID"));
                list.add(rs.getString("SID"));
                list.add(rs.getString("PID"));
                list.add(rs.getString("grade"));
                list.add(rs.getString("type"));*/
                list.add(rs.getString("StaffID"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    public List<String> findByType(String type,int aId,int pId){
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM score WHERE type = ? AND AID = ? AND PID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,type);
            pstmt.setInt(2,aId);
            pstmt.setInt(3,pId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("StaffID"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<String> findBypId(int pId,int aId, int staffId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM score WHERE PID = ? AND AID = ? AND StaffID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,pId);
            pstmt.setInt(2,aId);
            pstmt.setInt(3,staffId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("AID"));
                list.add(rs.getString("SID"));
                list.add(rs.getString("PID"));
                list.add(rs.getString("grade"));
                list.add(rs.getString("type"));
                list.add(rs.getString("StaffID"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<String> findBysId(int sId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM score WHERE SID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,sId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("AID"));
                list.add(rs.getString("SID"));
                list.add(rs.getString("PID"));
                list.add(rs.getString("grade"));
                list.add(rs.getString("type"));
                list.add(rs.getString("StaffID"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<String> findP_DScore(int pId, int aId, int staffId, String type) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM score WHERE PID = ? AND AID = ? AND StaffID = ? AND type = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,pId);
            pstmt.setInt(2,aId);
            pstmt.setInt(3,staffId);
            pstmt.setString(4,type);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("AID"));
                list.add(rs.getString("SID"));
                list.add(rs.getString("PID"));
                list.add(rs.getString("grade"));
                list.add(rs.getString("type"));
                list.add(rs.getString("StaffID"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        } finally {
            Tools.closeConnection(conn);
        }
        return list;
    }
}
