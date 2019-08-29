package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Project;
import KDh.gym.dbms.util.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {
    public int insert(Project project){
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "INSERT INTO project(PID,PName) VALUES (?,?)";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,project.getpId());
            pstmt.setString(2,project.getpName());
            count = pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    public int deleteByPId(int pId){
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "Delete From project WHERE pId = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,pId);
            count = pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    public int update(Project project){
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "UPDATE project SET pName = ? WHERE pId = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,project.getpName());
            pstmt.setInt(2,project.getpId());
            count = pstmt.executeUpdate();
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    public List<String> find(){
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM project";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(rs.getString("PId"));
                list.add(rs.getString("PName"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    public List<String> findByPId(int pId){
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM project WHERE PID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,pId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(rs.getString("PId"));
                list.add(rs.getString("PName"));
            }
            pstmt.close();
        }catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return list;
    }

    public List<String> findByPName(String pName){
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM project WHERE PName = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,pName);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(rs.getString("PId"));
                list.add(rs.getString("PName"));
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
