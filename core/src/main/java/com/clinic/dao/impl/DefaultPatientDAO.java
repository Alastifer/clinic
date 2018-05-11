package com.clinic.dao.impl;

import com.clinic.dao.PatientDAO;
import com.clinic.dao.exception.AmbiguousIdentifierException;
import com.clinic.dao.exception.UnknownIdentifierException;
import com.clinic.model.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DefaultPatientDAO implements PatientDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_PATIENT_BY_USERNAME = "SELECT username, first_name, last_name, address, birth_day, " +
                                                             "phone_number FROM patients WHERE username = ?";

    @Override
    public Patient getPatientByUsername(String username) {
        List<Patient> patients = jdbcTemplate.query(SELECT_PATIENT_BY_USERNAME, new PatientRowMapper(), username);
        if (patients.isEmpty()) {
            throw new UnknownIdentifierException("Patient with username '" + username + "' not found!");
        } else if (patients.size() > 1) {
            throw new AmbiguousIdentifierException("Patient with username '" + username + "' is not unique, " + patients.size() + " patients found!");
        }
        return patients.get(0);
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
