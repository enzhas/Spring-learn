package com.example.delivery.repositories;

import com.example.delivery.models.Employee;
import com.example.delivery.models.Package;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Slf4j
public class PackageRepository {
    private final JdbcTemplate jdbcTemplate;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public PackageRepository(JdbcTemplate jdbcTemplate, EmployeeRepository employeeRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeRepository = employeeRepository;
    }

    final private RowMapper<Package> rowMapper = new RowMapper<Package>() {
        @Override
        public Package mapRow(ResultSet rs, int rowNum) throws SQLException {
            Package pack = new Package();
            pack.setId(UUID.fromString(rs.getString("id")));
            pack.setDescription(rs.getString("description"));
            pack.setDeliveryAddress(rs.getString("delivery_address"));
            pack.setEmployee(employeeRepository.getById(rs.getLong("employee_id")).orElse(null));
            return pack;
        }
    };

    public int save(Package pack) {
        String sql = "INSERT INTO package (id, description, delivery_address, employee_id) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, UUID.randomUUID(), pack.getDescription(), pack.getDeliveryAddress(), pack.getEmployee().getId());
    }

    public Optional<Package> getById(UUID id) {
        String sql = "SELECT * FROM package WHERE id = ?";
        try {
            Package pack = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
            return Optional.ofNullable(pack);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<Package> getAll() {
        String sql = "SELECT * FROM package limit 2000";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public int update(Package pack) {
        String sql = "UPDATE package SET description = ?, delivery_address = ?, employee_id = ? WHERE id = ?";
        return jdbcTemplate.update(sql, pack.getDescription(), pack.getDeliveryAddress(), pack.getEmployee().getId(), pack.getId().toString());
    }

    public int deleteById(UUID id) {
        String sql = "DELETE FROM package WHERE id = ?";
        if (getById(id).isPresent()) {
            employeeRepository.updateStatus(getById(id).get().getEmployee().getId());
        }
        return jdbcTemplate.update(sql, id.toString());
    }
}