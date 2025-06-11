package org.example.spring_caw_ktk.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.example.spring_caw_ktk.dto.Bmi;
import org.example.spring_caw_ktk.dto.BmiRequest;
import org.example.spring_caw_ktk.dto.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class BmiDao {
	private JdbcTemplate jdbcTemplate;

    public BmiDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Bmi> selectAll() {
        String sql = "SELECT * FROM user_bmi";
        List<Bmi> results = jdbcTemplate.query(sql,
            (ResultSet rs, int rowNum) -> new Bmi(
                rs.getInt("id"),
                rs.getString("userid"),
                rs.getFloat("height"),
                rs.getFloat("weight"),
                rs.getDate("date"),
                rs.getFloat("bmi"),
                rs.getTimestamp("created_at")
            )
        );
        return results;
    }
    
    public List<Bmi> selectByUserid(String userid) {
        List<Bmi> results = jdbcTemplate.query(
            "SELECT * FROM user_bmi WHERE userid = ?",
            (rs, rowNum) -> new Bmi(
                rs.getInt("id"),
                rs.getString("userid"),
                rs.getFloat("height_cm"),
                rs.getFloat("weight_kg"),
                rs.getDate("date"),
                rs.getFloat("bmi"),
                rs.getTimestamp("created_at")
            ),
            userid
        );
        return results;
    }

    public Bmi getTodayBmi(String userId) {
        try {
            return jdbcTemplate.queryForObject(
                "SELECT * FROM user_bmi WHERE userid = ? AND DATE(date) = CURDATE()",
                (rs, rowNum) -> new Bmi(
                    rs.getInt("id"),
                    rs.getString("userid"),
                    rs.getFloat("height_cm"),
                    rs.getFloat("weight_kg"),
                    rs.getDate("date"),
                    rs.getFloat("bmi"),
                    rs.getTimestamp("created_at")
                ),
                userId
            );
        } catch (Exception e) {
            return null; // 오늘 BMI 없으면 null 반환
        }
    }


    

    public void insert(Bmi bmi) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO user_bmi (id, userid, date, height_cm, weight_kg, bmi,created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setInt(1, bmi.getId());
            ps.setString(2, bmi.getUserid());
            ps.setDate(3, bmi.getDate());
            ps.setFloat(4, bmi.getHeight());
            ps.setFloat(5, bmi.getWeight());
            ps.setFloat(6, bmi.getBmi());
            ps.setTimestamp(7, bmi.getCreated_at());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
        	bmi.setId(key.intValue());
        }
    }
    

    
}
