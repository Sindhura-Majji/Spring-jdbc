package com.stackroute.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleJdbcDemo {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insertEmployeeDetails() {

        if (null != jdbcTemplate) {
            // SQL Operation #1 - SQL INSERT Operation
            String sqlInsertQuery = "INSERT INTO employee (id, name, age, gender) VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sqlInsertQuery, 4, "devi", 29, "f");
        }
    }

    public void readEmployeeDetails() {
       final List<Employee> list1=new ArrayList<>();
        String sqlSelectQuery = "SELECT id,name,age,gender FROM employee";
        final List list = jdbcTemplate.query(sqlSelectQuery, new RowMapper() {
            public Employee mapRow(ResultSet result, int rowNum) throws SQLException {
                Employee employeeObj = new Employee();
                employeeObj.setId(result.getInt(1));
                employeeObj.setName(result.getString(2));
                employeeObj.setAge(result.getInt(3));
                employeeObj.setGender(result.getString(4));

                return employeeObj;


            }
        });

        System.out.println(list);

    }

    public void updateEmployeeDetails() {
        String sqlUpdateQuery = "UPDATE employee set age=? where name=?";
        jdbcTemplate.update(sqlUpdateQuery, 24, "sindhu");
    }

    public void deleteEmployeeDetails() {
        String sqlDeleteQuery = "DELETE FROM employee where name=?";
        jdbcTemplate.update(sqlDeleteQuery, "devi");
    }
}

