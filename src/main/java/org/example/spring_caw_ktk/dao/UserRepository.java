package org.example.spring_caw_ktk.dao;

import org.example.spring_caw_ktk.dto.UserInfo;
import org.example.spring_caw_ktk.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {
    // user 테이블에서 성별 가져오기
    public String findGenderByUserId(int userId) {
        String sql = "SELECT gender FROM user WHERE id = ?";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("gender");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;  // 못 찾은 경우
    }

    // userinfo 테이블에 BMI 정보 저장
    public void saveUserInfo(UserInfo info) {
        String sql = "INSERT INTO userinfo (user_id, height, weight, gender, bmi) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, info.getUserId());
            ps.setDouble(2, info.getHeight());
            ps.setDouble(3, info.getWeight());
            ps.setString(4, info.getGender());
            ps.setDouble(5, info.getBmi());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
