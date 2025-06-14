package org.example.spring_caw_ktk.dao;

import org.example.spring_caw_ktk.dto.Food;
import org.example.spring_caw_ktk.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodRepository {

    // 음식 이름으로 부분 검색
    public List<Food> searchFoodByName(String keyword) {
        List<Food> list = new ArrayList<>();
        String sql = "SELECT * FROM food_list WHERE food_name LIKE ?";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String foodName = rs.getString("food_name");
                int calories = rs.getInt("calories");
                list.add(new Food(id, foodName, calories));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


}
