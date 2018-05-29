package com.clinic.dao.impl;

import com.clinic.dao.DiseaseDAO;
import com.clinic.dao.exception.AmbiguousIdentifierException;
import com.clinic.dao.exception.UnknownIdentifierException;
import com.clinic.model.Disease;
import com.clinic.model.DiseaseType;
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

import static java.util.stream.Collectors.toList;

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

    private static final String SELECT_ALL_DISEASES = "SELECT username, diseases.id AS diseaseId, begin_date, " +
                                                      "end_date, disease_types.name AS disease, content " +
                                                      "FROM diseases " +
                                                      "JOIN disease_types ON diseases.id_type = disease_types.id";

    private static final String SELECT_ALL_DISEASE_TYPES = "SELECT id, name FROM disease_types";

    private static final String INSERT_DISEASE = "INSERT INTO diseases (begin_date, end_date, id_type, content, username) " +
                                                 "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Disease> getAllDiseasesByUsername(String username) {
        return jdbcTemplate.query(SELECT_ALL_DISEASES_BY_USERNAME, new DiseaseRowMapper(), username);
    }

    @Override
    public Disease getDiseaseByIdAndUsername(Long id, String username) {
        List<Disease> diseases = jdbcTemplate.query(SELECT_DISEASE_BY_USERNAME_AND_ID, new DiseaseRowMapper(), username, id);
        if (diseases.isEmpty()) {
            throw new UnknownIdentifierException("Disease with id '" + id + "' and username '" + username + "' not found!");
        } else if (diseases.size() > 1) {
            throw new AmbiguousIdentifierException("Disease with id '" + id + "' and username '" + username + "' is not unique, " + diseases.size() + " diseases found!");
        }
        return diseases.get(0);
    }

    @Override
    public List<String> getAllDiseaseTypes() {
        return jdbcTemplate.query(SELECT_ALL_DISEASE_TYPES, new DiseaseTypeRowMapper()).stream()
                .map(DiseaseType::getName)
                .collect(toList());
    }

    @Override
    public void save(Disease disease) {
        Date beginDate = new Date(convert(disease.getBeginDate()));
        Date endDate = new Date(convert(disease.getEndDate()));
        Long typeId = jdbcTemplate.query(SELECT_ALL_DISEASE_TYPES, new DiseaseTypeRowMapper()).stream()
                .filter(diseaseType -> diseaseType.getName().equals(disease.getType()))
                .map(DiseaseType::getId)
                .collect(toList()).get(0);
        jdbcTemplate.update(INSERT_DISEASE, beginDate,
                                            endDate,
                                            typeId,
                                            disease.getContent(),
                                            disease.getUsername());
    }

    private long convert(Timestamp dateTime) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime.toString()).getTime();
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
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

    private static class DiseaseTypeRowMapper implements RowMapper<DiseaseType> {
        @Override
        public DiseaseType mapRow(ResultSet rs, int rowNum) throws SQLException {
            DiseaseType diseaseType = new DiseaseType();
            diseaseType.setId(rs.getLong("id"));
            diseaseType.setName(rs.getString("name"));
            return diseaseType;
        }
    }
}
