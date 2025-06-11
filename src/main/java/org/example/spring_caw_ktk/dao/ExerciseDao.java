package org.example.spring_caw_ktk.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.example.spring_caw_ktk.dto.Bmi;
import org.example.spring_caw_ktk.dto.Exercise;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class ExerciseDao {
	private JdbcTemplate jdbcTemplate;

    public ExerciseDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Exercise> selectAll() {
        String sql = "SELECT * FROM user_exercise";
        List<Exercise> results = jdbcTemplate.query(sql,
            (ResultSet rs, int rowNum) -> new Exercise(
                rs.getInt("id"),
                rs.getString("userid"),
                rs.getDate("date"),
                rs.getString("exercise_name"),
                rs.getInt("calories"),
                rs.getTimestamp("created_at")
            )
        );
        return results;
    }
    
    public List<Exercise> selectByUserid(String userid) {
        List<Exercise> results = jdbcTemplate.query(
            "SELECT * FROM user_exercise WHERE userid = ?",
            (rs, rowNum) -> new Exercise(
            		rs.getInt("id"),
                    rs.getString("userid"),
                    rs.getDate("date"),
                    rs.getString("exercise_name"),
                    rs.getInt("calories"),
                    rs.getTimestamp("created_at")
            ),
            userid
        );
        return results;
    }

    

    public void insert(Exercise exercise) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO user_exercise (id, userid, date, exercise_name,calories,created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setInt(1, exercise.getId());
            ps.setString(2, exercise.getUserid());
            ps.setDate(3, exercise.getDate());
            ps.setString(4, exercise.getExercise_name());
            ps.setInt(5, exercise.getCalories());
            ps.setTimestamp(6, exercise.getCreated_at());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
        	exercise.setId(key.intValue());
        }
    }

    public List<Exercise> getTodayExercise(String userid) {
        try {
            return jdbcTemplate.query(
                "SELECT * FROM user_exercise WHERE userid = ? AND DATE(date) = CURDATE()",
                (rs, rowNum) -> new Exercise(
                    rs.getInt("id"),
                    rs.getString("userid"),
                    rs.getDate("date"),
                    rs.getString("exercise_name"),
                    rs.getInt("calories"),
                    rs.getTimestamp("created_at")
                ),
                userid
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // 예외 발생 시 빈 리스트 반환
        }
    }

    // 사용자별 총 칼로리 합계 반환
    public int getTotalCaloriesByUser(String userid) {
       String sql = "SELECT COALESCE(SUM(calories), 0) FROM user_exercise WHERE userid = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, userid);
    }
}
