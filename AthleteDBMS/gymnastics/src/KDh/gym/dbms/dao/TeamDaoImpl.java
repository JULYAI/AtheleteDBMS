package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Team;
import KDh.gym.dbms.util.Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeamDaoImpl implements TeamDao {
    @Override
    public int insert(Team team) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "INSERT INTO team (TID,TName) VALUES (?,?)";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,team.gettId());
            pstmt.setString(2,team.gettName());
            count = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    @Override
    public int deleteByTId(int tId) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "DELETE FROM team WHERE TID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,tId);
            count = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException var){
            var.printStackTrace();
        }finally {
            Tools.closeConnection(conn);
        }
        return count;
    }

    @Override
    public int update(Team team) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "UPDATE team SET TName = ? WHERE TID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,team.gettName());
            pstmt.setInt(2,team.gettId());
            count = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException var){
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
        String strSQL = "SELECT * FROM team";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("TID"));
                list.add(rs.getString("TName"));
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
    public List<String> findByTId(int tId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM team WHERE TID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,tId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("TID"));
                list.add(rs.getString("TName"));
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
    public List<String> findByTName(String tName) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM team WHERE TName = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setString(1,tName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("TID"));
                list.add(rs.getString("TName"));
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
