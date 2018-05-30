package com.clinic.dao.impl;

import com.clinic.dao.AnalyzeDAO;
import com.clinic.dao.exception.AmbiguousIdentifierException;
import com.clinic.dao.exception.UnknownIdentifierException;
import com.clinic.model.Analyze;
import com.clinic.model.AnalyzeType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

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

    private static final String SELECT_ALL_ANALYZE_TYPES = "SELECT id, name FROM analyze_types";

    private static final String INSERT_ANALYZE = "INSERT INTO analyzes (receiving_date, content, username, id_type) " +
                                                 "VALUES (?, ?, ?, ?)";

    private static final String DELETE_ANALYZE = "DELETE FROM analyzes WHERE id = ?";

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

    @Override
    public List<String> getAllAnalyzeTypes() {
        return jdbcTemplate.query(SELECT_ALL_ANALYZE_TYPES, new AnalyzeTypeRowMapper()).stream()
                .map(AnalyzeType::getName)
                .collect(toList());
    }

    @Override
    public void save(Analyze analyze) {
        Date receivingDate = new Date(convert(analyze.getReceivingDate()));
        Long typeId = jdbcTemplate.query(SELECT_ALL_ANALYZE_TYPES, new AnalyzeTypeRowMapper()).stream()
                .filter(analyzeType -> analyzeType.getName().equals(analyze.getType()))
                .map(AnalyzeType::getId)
                .collect(toList()).get(0);
        jdbcTemplate.update(INSERT_ANALYZE, receivingDate,
                                            analyze.getContent(),
                                            analyze.getUsername(),
                                            typeId);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(DELETE_ANALYZE, id);
    }

    private long convert(Timestamp dateTime) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime.toString()).getTime();
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
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

    private static class AnalyzeTypeRowMapper implements RowMapper<AnalyzeType> {
        @Override
        public AnalyzeType mapRow(ResultSet rs, int rowNum) throws SQLException {
            AnalyzeType analyzeType = new AnalyzeType();
            analyzeType.setId(rs.getLong("id"));
            analyzeType.setName(rs.getString("name"));
            return analyzeType;
        }
    }
}
