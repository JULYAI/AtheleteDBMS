package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Group;
import KDh.gym.dbms.util.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl implements GroupDao {
    @Override
    public int insert(Group group) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "INSERT INTO `group`(GID,GName) VALUES (?,?)";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,group.getgId());
            pstmt.setString(2,group.getgName());
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
    public int deleteByGId(int gId) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "DELETE FROM `group` WHERE GID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,gId);
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
    public int update(Group group) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "UPDATE `group` SET GName = ? WHERE GID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,group.getgName());
            pstmt.setInt(2,group.getgId());
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
        String strSQL ="SELECT * FROM `group`";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("GID"));
                list.add(rs.getString("GName"));
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
    public List<String> findByGId(int gId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL ="SELECT * FROM `group` WHERE GID = ? ";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,gId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("GID"));
                list.add(rs.getString("GName"));
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
    public List<String> findByGName(String gName) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL ="SELECT * FROM `group` WHERE GName = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,gName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("GID"));
                list.add(rs.getString("GName"));
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
