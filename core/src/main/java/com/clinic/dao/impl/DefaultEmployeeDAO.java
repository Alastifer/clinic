package com.clinic.dao.impl;

import com.clinic.dao.EmployeeDAO;
import com.clinic.dao.exception.AmbiguousIdentifierException;
import com.clinic.dao.exception.UnknownIdentifierException;
import com.clinic.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DefaultEmployeeDAO implements EmployeeDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_EMPLOYEE_BY_USERNAME = "SELECT username, first_name, last_name, positions.name AS position " +
                                                              "FROM employees JOIN positions ON employees.id_position = positions.id " +
                                                              "WHERE username = ?";
    @Override
    public Employee getEmployeeByUsername(String username) {
        List<Employee> employees = jdbcTemplate.query(SELECT_EMPLOYEE_BY_USERNAME, new EmployeeRowMapper(), username);
        if (employees.isEmpty()) {
            throw new UnknownIdentifierException("Employee with username '" + username + "' not found!");
        } else if (employees.size() > 1) {
            throw new AmbiguousIdentifierException("Employee with username '" + username + "' is not unique, " + employees.size() + " employees found!");
        }
        return employees.get(0);
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
