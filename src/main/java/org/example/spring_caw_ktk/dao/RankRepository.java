package org.example.spring_caw_ktk.dao;

import org.example.spring_caw_ktk.dto.Rank;
import org.example.spring_caw_ktk.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RankRepository {

    // 점수 저장 또는 갱신
    public void saveOrUpdateRank(String userid, int score) {
        String sql = "INSERT INTO rank (userid, score) VALUES (?, ?) " +
                "ON DUPLICATE KEY UPDATE score = ?";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, userid);
            ps.setInt(2, score);
            ps.setInt(3, score);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 전체 랭크 리스트 (내림차순)
    public List<Rank> findAll() {
        List<Rank> list = new ArrayList<>();
        String sql = "SELECT * FROM rank ORDER BY score DESC";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Rank rank = new Rank();
                rank.setUserid(rs.getString("userid"));
                rank.setScore(rs.getInt("score"));
                rank.setUpdatedAt(rs.getTimestamp("updated_at"));
                list.add(rank);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
