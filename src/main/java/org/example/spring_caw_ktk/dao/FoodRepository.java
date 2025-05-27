package org.example.spring_caw_ktk.dao;

import org.example.spring_caw_ktk.dto.Food;
import org.example.spring_caw_ktk.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodRepository {
    // DB 연결 객체 생성
    private Connection conn = DBUtil.getConnection();

    // 검색 명을 포함한 모든 음식 검색
    public List<Food> searchFoodByName(String keyword) {
        List<Food> list = new ArrayList<>();
        String sql = "SELECT * FROM food_list WHERE food_name LIKE ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Food(rs.getInt("id"), rs.getString("food_name"), rs.getInt("calories")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

