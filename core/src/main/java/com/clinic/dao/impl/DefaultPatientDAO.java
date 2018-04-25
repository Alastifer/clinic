package com.clinic.dao.impl;

import com.clinic.dao.PatientDAO;
import com.clinic.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
public class DefaultPatientDAO implements PatientDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_PATIENT_BY_USERNAME = "SELECT username, first_name, last_name, address, birth_day, " +
                                                       "phone_number FROM patients WHERE username = ?";

    @Override
    public Optional<Patient> getPatient(String username) {
        Patient patient = jdbcTemplate.queryForObject(SELECT_PATIENT_BY_USERNAME, new PatientRowMapper(), username);
        return Optional.of(patient);
    }

    private static class PatientRowMapper implements RowMapper<Patient> {
        @Override
        public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
            Patient patient = new Patient();
            patient.setUsername(rs.getString("username"));
            patient.setFirstName(rs.getString("first_name"));
            patient.setLastName(rs.getString("last_name"));
            patient.setAddress(rs.getString("address"));
            patient.setBirthDay(rs.getTimestamp("birth_day"));
            patient.setPhoneNumber(rs.getString("phone_number"));
            return patient;
        }
    }
}
