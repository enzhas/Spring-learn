package com.example.delivery.repositories;

import com.example.delivery.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

//import java.util.Random;

@Repository
public class EmployeeRepository {
    private  JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Employee> rowMapper = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setName(rs.getString("name"));
            employee.setStatus(rs.getString("status"));
            return employee;
        }
    };

    public int save(Employee employee) {
        String sql = "INSERT INTO employee (id, name) VALUES (NEXTVAL ('empl_id'), ?)";
//        Long id = jdbcTemplate.queryForObject("SELECT NEXTVAL ('empl_id')", Long.class);
        return jdbcTemplate.update(sql, employee.getName());
    }

    public Optional<Employee> getById(Long id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        return Optional.ofNullable(employee);
    }

    public List<Employee> getAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public int update(Employee employee) {
        String sql = "UPDATE employee SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getId());
    }

    public int updateStatus(Long id){
        String sql = "UPDATE employee SET status = ? WHERE id = ?";
        Optional<Employee> employee = getById(id);
        if(employee.isPresent()){
            employee.get().updateStatus();
            return jdbcTemplate.update(sql, employee.get().getStatus(), id);
        }
        return 0;
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
    public Optional<Employee> findRandomFree() {
        String sql = "SELECT * FROM employee WHERE status = 'ACTIVE'";
         List<Employee> employeeList = jdbcTemplate.query(sql, rowMapper);
         if(employeeList.isEmpty()){
             return Optional.empty();
         }
         else{
             Random random = new Random();
             int index = random.nextInt(employeeList.size());
             return Optional.of(employeeList.get(index));
         }
    }
}
