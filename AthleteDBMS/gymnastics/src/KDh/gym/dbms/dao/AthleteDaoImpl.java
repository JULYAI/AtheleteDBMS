package KDh.gym.dbms.dao;


import KDh.gym.dbms.entity.Athlete;
import KDh.gym.dbms.util.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AthleteDaoImpl implements AthleteDao {
    @Override
    public int insert(Athlete athlete) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "INSERT INTO athlete(AID,AName,GID,sex) VALUES (?,?,?,?)";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,athlete.getAID());
            pstmt.setString(2,athlete.getAName());
            pstmt.setInt(3,athlete.getAGroupId());
            pstmt.setString(4,athlete.getASex());
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
    public int deleteByAId(int aId) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "DELETE FROM athlete WHERE AID = ?";

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
    public int update(Athlete athlete) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "UPDATE athlete SET AName = ?,sex = ?,GID = ? WHERE AID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,athlete.getAName());
            pstmt.setString(2,athlete.getASex());
            pstmt.setInt(3,athlete.getAGroupId());
            pstmt.setInt(4,athlete.getAID());
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
        String strSQL = "SELECT * FROM athlete";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("AID"));
                list.add(rs.getString("AName"));
                list.add(rs.getString("GID"));
                list.add(rs.getString("sex"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<String> findByAId(int aId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM athlete WHERE AID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,aId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("AID"));
                list.add(rs.getString("AName"));
                list.add(rs.getString("GID"));
                list.add(rs.getString("sex"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<String> findByAName(String aName) {

        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM athlete WHERE AName = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,aName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("AID"));
                list.add(rs.getString("AName"));
                list.add(rs.getString("GID"));
                list.add(rs.getString("sex"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<String> findByASex(String aSex) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM athlete WHERE sex = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,aSex);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("AID"));
                list.add(rs.getString("AName"));
                list.add(rs.getString("GID"));
                list.add(rs.getString("sex"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<String> findByAGroupId(int aGroupId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM athlete WHERE GID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,aGroupId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("AID"));
                list.add(rs.getString("AName"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return list;
    }
}
