package com.stackroute.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDao {


    private JdbcTemplate jdbcTemplate;

    //setter for JDBC class
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //create table method
    public void createTable() {
        String query = "create table Employee(id integer,name varchar(20),age integer,gender varchar(10))";
        System.out.println("new table created");
        jdbcTemplate.execute(query);
    }

    //inserting / updating table method
    public void updateTable(Employee employee) {
        String query = "insert into Employee values(?,?,?,?)";
        System.out.println("inserted into the tables");
        jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getAge(), employee.getGender());
    }

    //deleting from table method
    public void deletefromTable(int id) {
        String query = " delete from Employee where id = ? ";
        System.out.println("deleted from table");
        jdbcTemplate.update(query, id);
    }

    //displaying details method
    public List<Employee> readTable() {
        return jdbcTemplate.query("select * from Employee", new RowMapper<Employee>() {

            @Override
            public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setAge(rs.getInt(3));
                e.setGender(rs.getString(4));
                return e;
            }
        });
    }
}
