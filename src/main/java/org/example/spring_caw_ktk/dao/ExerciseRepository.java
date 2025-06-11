package org.example.spring_caw_ktk.dao;

import org.example.spring_caw_ktk.dto.Exercise;
import org.example.spring_caw_ktk.util.DBUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExerciseRepository {
    private JdbcTemplate jdbcTemplate;

    public List<Exercise> searchExerciseByName(String keyword) {
        List<Exercise> list = new ArrayList<>();
        String sql = "SELECT * FROM exercise_list WHERE exercise_name LIKE ?";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String exerciseName = rs.getString("exercise_name");
                int calories = rs.getInt("calories");
                list.add(new Exercise(id, exerciseName, calories));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
     
	
}
