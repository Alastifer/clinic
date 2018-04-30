package com.clinic.dao.impl;

import com.clinic.dao.EmployeeDAO;
import com.clinic.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component
public class DefaultEmployeeDAO implements EmployeeDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_EMPLOYEE_BY_USERNAME = "SELECT username, first_name, last_name, positions.name AS position" +
                                                              "FROM patients JOIN positions ON patients.id_position = position.id " +
                                                              "WHERE username = ?";
    @Override
    public Optional<Employee> getEmployee(String username) {
        Employee employee = jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_USERNAME, new EmployeeRowMapper(), username);
        return Optional.of(employee);
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setUsername(rs.getString("username"));
            employee.setFirstName(rs.getString("first_name"));
            employee.setLastName(rs.getString("last_name"));
            employee.setPosition(rs.getString("position"));
            return employee;
        }
    }
}
