package com.example.delivery.repositories;

import com.example.delivery.models.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PackageRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PackageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Package> rowMapper = new RowMapper<Package>() {
        @Override
        public Package mapRow(ResultSet rs, int rowNum) throws SQLException {
            Package pack = new Package();
            pack.setId(UUID.fromString(rs.getString("id")));
            pack.setDescription(rs.getString("description"));
            pack.setDeliveryAddress(rs.getString("delivery_address"));
            // Fetch Employee data if needed
            return pack;
        }
    };

    public int save(Package pack) {
        String sql = "INSERT INTO packages (id, description, delivery_address, employee_id) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, UUID.randomUUID().toString(), pack.getDescription(), pack.getDeliveryAddress(), pack.getEmployee().getId());
    }

    public Optional<Package> findById(UUID id) {
        String sql = "SELECT * FROM packages WHERE id = ?";
        Package pack = jdbcTemplate.queryForObject(sql, new Object[]{id.toString()}, rowMapper);
        return Optional.ofNullable(pack);
    }

    public List<Package> findAll() {
        String sql = "SELECT * FROM packages";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public int update(Package pack) {
        String sql = "UPDATE packages SET description = ?, delivery_address = ?, employee_id = ? WHERE id = ?";
        return jdbcTemplate.update(sql, pack.getDescription(), pack.getDeliveryAddress(), pack.getEmployee().getId(), pack.getId().toString());
    }

    public int deleteById(UUID id) {
        String sql = "DELETE FROM packages WHERE id = ?";
        return jdbcTemplate.update(sql, id.toString());
    }
}
