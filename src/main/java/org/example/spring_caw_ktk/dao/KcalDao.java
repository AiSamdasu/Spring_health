package org.example.spring_caw_ktk.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.example.spring_caw_ktk.dto.Kcal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class KcalDao {
	private JdbcTemplate jdbcTemplate;

    public KcalDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Kcal> selectAll() {
        String sql = "SELECT * FROM user_kcal";
        List<Kcal> results = jdbcTemplate.query(sql,
            (ResultSet rs, int rowNum) -> new Kcal(
                rs.getInt("id"),
                rs.getString("userid"),
                rs.getDate("date"),
                rs.getString("food_name"),
                rs.getInt("calories"),
                rs.getTimestamp("created_at"),
                rs.getString("classify")
            )
        );
        return results;
    }
    
    public List<Kcal> selectByUserid(String userid) {
        List<Kcal> results = jdbcTemplate.query(
            "SELECT * FROM user_kcal WHERE userid = ?",
            (rs, rowNum) -> new Kcal(
            		rs.getInt("id"),
                    rs.getString("userid"),
                    rs.getDate("date"),
                    rs.getString("food_name"),
                    rs.getInt("calories"),
                    rs.getTimestamp("created_at"),
                    rs.getString("classify")
            ),
            userid
        );
        return results;
    }

    

    public void insert(Kcal kcal) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO user_kcal (id, userid, date, food_name,calories,created_at,classify) " +
                "VALUES (?, ?, ?, ?, ?, ?,?)",
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setInt(1, kcal.getId());
            ps.setString(2, kcal.getUserid());
            ps.setDate(3, kcal.getDate());
            ps.setString(4, kcal.getFood_name());
            ps.setInt(5, kcal.getCalories());
            ps.setTimestamp(6, kcal.getCreated_at());
            ps.setString(7,kcal.getClassify());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
        	kcal.setId(key.intValue());
        }
    }
}
