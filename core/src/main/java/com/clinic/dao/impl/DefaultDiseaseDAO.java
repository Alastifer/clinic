package com.clinic.dao.impl;

import com.clinic.dao.DiseaseDAO;
import com.clinic.model.Disease;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultDiseaseDAO implements DiseaseDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_ALL_DISEASES_BY_USERNAME = "SELECT username, diseases.id AS diseaseId, begin_date, " +
                                                                  "end_date, disease_types.name AS disease, content " +
                                                                  "FROM diseases " +
                                                                  "JOIN disease_types ON diseases.id_type = disease_types.id " +
                                                                  "WHERE username = ?";

    private static final String SELECT_DISEASE_BY_USERNAME_AND_ID = "SELECT username, diseases.id AS diseaseId, begin_date, " +
                                                                    "end_date, disease_types.name AS disease, content " +
                                                                    "FROM diseases " +
                                                                    "JOIN disease_types ON diseases.id_type = disease_types.id " +
                                                                    "WHERE username = ? AND diseases.id = ?";

    @Override
    public List<Disease> getAllDiseasesByUsername(String username) {
        return jdbcTemplate.query(SELECT_ALL_DISEASES_BY_USERNAME, new DiseaseRowMapper(), username);
    }

    @Override
    public Optional<Disease> getDiseaseByIdAndUsername(Long id, String username) {
        List<Disease> diseases = jdbcTemplate.query(SELECT_DISEASE_BY_USERNAME_AND_ID, new DiseaseRowMapper(), username, id);
        if (diseases.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(diseases.get(0));
    }

    private static class DiseaseRowMapper implements RowMapper<Disease> {
        @Override
        public Disease mapRow(ResultSet rs, int rowNum) throws SQLException {
            Disease disease = new Disease();
            disease.setId(rs.getLong("diseaseId"));
            disease.setUsername(rs.getString("username"));
            disease.setBeginDate(rs.getTimestamp("begin_date"));
            disease.setEndDate(rs.getTimestamp("end_date"));
            disease.setType(rs.getString("disease"));
            disease.setContent(rs.getString("content"));
            return disease;
        }
    }
}
