package org.example.spring_caw_ktk.dao;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.example.spring_caw_ktk.dto.Member;
import org.springframework.jdbc.core.*;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Member> selectAll() {
        String sql = "SELECT * FROM user";
        List<Member> results = jdbcTemplate.query(sql,
            (ResultSet rs, int rowNum) -> new Member(
                rs.getInt("id"),
                rs.getString("userid"),
                rs.getString("password"),
                rs.getString("nickname"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("gender"),
                rs.getTimestamp("created_at")
            )
        );
        return results;
    }
    
    public Member selectByUserid(String userid) {
        List<Member> results = jdbcTemplate.query(
            "SELECT * FROM user WHERE userid = ?",
            (rs, rowNum) -> new Member(
                rs.getInt("id"),
                rs.getString("userid"),
                rs.getString("password"),
                rs.getString("nickname"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getString("gender"),
                rs.getTimestamp("created_at")
            ),
            userid 
        );
        return results.isEmpty() ? null : results.get(0);
    }

    
    public void insert(Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO user (userid, password, nickname, name, age, gender, created_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, member.getUserid());
            ps.setString(2, member.getPassword());
            ps.setString(3, member.getNickname());
            ps.setString(4, member.getName());
            ps.setInt(5, member.getAge());
            ps.setString(6, member.getGender());
            ps.setTimestamp(7, member.getCreatedAt());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            member.setId(key.intValue());
        }
    }

}