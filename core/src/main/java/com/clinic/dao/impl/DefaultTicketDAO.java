package com.clinic.dao.impl;

import com.clinic.dao.TicketDAO;
import com.clinic.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DefaultTicketDAO implements TicketDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_TICKETS_BY_USERNAME = "SELECT id, receipt_date, room, employee, patient " +
                                                             "FROM tickets WHERE patient = ? AND receipt_date >= NOW()";

    private static final String SELECT_TICKETS_WITHOUT_PATIENT = "SELECT id, receipt_date, room, employee, patient " +
                                                                 "FROM tickets WHERE patient IS NULL AND receipt_date >= NOW()";

    private static final String SELECT_ALL_TICKETS = "SELECT id, receipt_date, room, employee, patient " +
                                                     "FROM tickets WHERE receipt_date >= NOW()";

    private static final String UPDATE_SET_NULL_FOR_PATIENT_BY_ID_AND_USERNAME = "UPDATE tickets SET patient = NULL " +
                                                                                 "WHERE id = ? AND patient = ?";

    private static final String UPDATE_SET_PATIENT_FOR_TICKET = "UPDATE tickets SET patient = ? " +
                                                                "WHERE id = ?";

    @Override
    public List<Ticket> getAllTicketsByUsername(String username) {
        return jdbcTemplate.query(SELECT_TICKETS_BY_USERNAME, new TicketRowMapper(), username);
    }

    @Override
    public void cancelTicketByIdAndUsername(Long id, String username) {
        jdbcTemplate.update(UPDATE_SET_NULL_FOR_PATIENT_BY_ID_AND_USERNAME, id, username);
    }

    @Override
    public List<Ticket> getTicketsForOrder() {
        return jdbcTemplate.query(SELECT_TICKETS_WITHOUT_PATIENT, new TicketRowMapper());
    }

    @Override
    public void orderTicketByIdAndUsername(Long id, String username) {
        jdbcTemplate.update(UPDATE_SET_PATIENT_FOR_TICKET, username, id);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return jdbcTemplate.query(SELECT_ALL_TICKETS, new TicketRowMapper());
    }

    private static class TicketRowMapper implements RowMapper<Ticket> {
        @Override
        public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
            Ticket ticket = new Ticket();
            ticket.setId(rs.getLong("id"));
            ticket.setReceiptDate(rs.getTimestamp("receipt_date"));
            ticket.setRoom(rs.getLong("room"));
            ticket.setPatientUsername(rs.getString("patient"));
            ticket.setEmployeeUsername(rs.getString("employee"));
            return ticket;
        }
    }
}
