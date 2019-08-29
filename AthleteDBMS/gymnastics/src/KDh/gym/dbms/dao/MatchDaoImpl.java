package KDh.gym.dbms.dao;

import KDh.gym.dbms.entity.Match;
import KDh.gym.dbms.util.Tools;
import com.mysql.cj.jdbc.ha.LoadBalancedMySQLConnection;

import javax.tools.Tool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatchDaoImpl implements MatchDao {
    @Override
    public int insert(Match match) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "INSERT INTO `match` SET MID = ?,PID = ?,AID = ?,Seq = ?,State = ?,GID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,match.getmId());
            pstmt.setInt(2,match.getpId());
            pstmt.setInt(3,match.getaId());
            pstmt.setInt(4,match.getSeq());
            pstmt.setInt(5,match.getState());
            pstmt.setInt(6,match.getgId());
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
    public int deleteByMatchId(int mId) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "DELETE FROM `match` where mId = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,mId);
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
    public int update(Match match) {
        int count = 0;
        Connection conn = Tools.getConnection();
        String strSQL = "UPDATE `match` SET AID = ?,Seq = ? Where MID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,match.getaId());
            pstmt.setInt(2,match.getSeq());
            pstmt.setInt(3,match.getmId());
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
        String strSQL = "SELECT * FROM `match`";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("MID"));
                list.add(rs.getString("PID"));
                list.add(rs.getString("AID"));
                list.add(rs.getString("Seq"));
                list.add(rs.getString("State"));
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
    public List<String> findByMId(int mId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM `match` WHERE MID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,mId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("MID"));
                list.add(rs.getString("PID"));
                list.add(rs.getString("AID"));
                list.add(rs.getString("Seq"));
                list.add(rs.getString("State"));
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
    public List<String> findByPId(int pId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM `match` WHERE PID = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,pId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("MID"));
                list.add(rs.getString("PID"));
                list.add(rs.getString("AID"));
                list.add(rs.getString("Seq"));
                list.add(rs.getString("State"));
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
    public List<String> findByAId(int aId,int gId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM `match` WHERE AID = ? AND GID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,aId);
            pstmt.setInt(2,gId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("MID"));
                list.add(rs.getString("PID"));
                list.add(rs.getString("AID"));
                list.add(rs.getString("Seq"));
                list.add(rs.getString("State"));
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
    public List<String> findBySeq(int seq, int gId) {
        List<String> list = new ArrayList<String>();
        Connection conn = Tools.getConnection();
        String strSQL = "SELECT * FROM `match` WHERE Seq = ? AND GID = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(strSQL);
            pstmt.setInt(1,seq);
            pstmt.setInt(2,gId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("MID"));
                list.add(rs.getString("PID"));
                list.add(rs.getString("AID"));
                list.add(rs.getString("Seq"));
                list.add(rs.getString("State"));
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
