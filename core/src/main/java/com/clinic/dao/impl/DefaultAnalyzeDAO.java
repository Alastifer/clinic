package com.clinic.dao.impl;

import com.clinic.dao.AnalyzeDAO;
import com.clinic.dao.exception.AmbiguousIdentifierException;
import com.clinic.dao.exception.UnknownIdentifierException;
import com.clinic.model.Analyze;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultAnalyzeDAO implements AnalyzeDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_ANALYZES_BY_USERNAME = "SELECT analyzes.id AS analyzeId, username, " +
                                                                  "receiving_date, content, analyze_types.name AS analyze " +
                                                                  "FROM analyzes " +
                                                                  "JOIN analyze_types ON analyzes.id_type = analyze_types.id " +
                                                                  "WHERE username = ?";

    private static final String SELECT_ANALYZE_BY_USERNAME_AND_ID = "SELECT analyzes.id AS analyzeId, username, " +
                                                                    "receiving_date, content, analyze_types.name AS analyze " +
                                                                    "FROM analyzes " +
                                                                    "JOIN analyze_types ON analyzes.id_type = analyze_types.id " +
                                                                    "WHERE username = ? AND analyzes.id = ?";

    @Override
    public List<Analyze> getAllAnalyzesByUsername(String username) {
        return jdbcTemplate.query(SELECT_ALL_ANALYZES_BY_USERNAME, new AnalyzeRowMapper(), username);
    }

    @Override
    public Analyze getAnalyzeByIdAndUsername(Long id, String username) {
        List<Analyze> analyzes = jdbcTemplate.query(SELECT_ANALYZE_BY_USERNAME_AND_ID, new AnalyzeRowMapper(), username, id);
        if (analyzes.isEmpty()) {
            throw new UnknownIdentifierException("Analyze with id '" + id + "' and username '" + username + "' not found!");
        } else if (analyzes.size() > 1) {
            throw new AmbiguousIdentifierException("Analyze with id '" + id + "' and username '" + username + "' is not unique, " + analyzes.size() + " diseases found!");
        }
        return analyzes.get(0);
    }

    private static class AnalyzeRowMapper implements RowMapper<Analyze> {
        @Override
        public Analyze mapRow(ResultSet rs, int rowNum) throws SQLException {
            Analyze analyze = new Analyze();
            analyze.setId(rs.getLong("analyzeId"));
            analyze.setUsername(rs.getString("username"));
            analyze.setType(rs.getString("analyze"));
            analyze.setReceivingDate(rs.getTimestamp("receiving_date"));
            analyze.setContent(rs.getString("content"));
            return analyze;
        }
    }
}
