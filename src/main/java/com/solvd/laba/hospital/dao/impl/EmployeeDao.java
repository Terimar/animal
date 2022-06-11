package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.ConnectionPool;
import com.solvd.laba.hospital.dao.IEmployeeDao;
import com.solvd.laba.hospital.model.Employee;
import com.solvd.laba.hospital.model.Specialization;

import java.sql.*;

public class EmployeeDao implements IEmployeeDao {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public Employee getEntityById(long id) {
        Employee employee = null;

        Connection connection = CONNECTION_POOL.getConnection();
        String select = "select e.id as employee_id, e.first_name as employee_first_name, e.last_name as employee_last_name, e.position as employee_position, s.id as spec_id, s.name as spec_name, s.salary as spec_salary from Employees e left join Specializations s on e.specialization_id = s.id where e.id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getLong("employee_id"));
                employee.setFirstName(resultSet.getString("employee_first_name"));
                employee.setLastName(resultSet.getString("employee_last_name"));
                employee.setPosition(Employee.Position.valueOf(resultSet.getString("employee_position")));

                Specialization specialization = new Specialization();
                specialization.setId(resultSet.getLong("spec_id"));
                specialization.setName(resultSet.getString("spec_name"));
                specialization.setSalary(resultSet.getBigDecimal("spec_salary"));

                employee.setSpecialization(specialization);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Can't select employee " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return employee;
    }

    @Override
    public void saveEntity(Employee entity) {
        Connection connection = CONNECTION_POOL.getConnection();
        String insert = "insert into Employees (first_name, last_name, specialization_id, posiion, qualification) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setLong(3, entity.getSpecialization().getId());
            preparedStatement.setString(4, entity.getPosition().name());
            preparedStatement.setInt(5, entity.getQualification());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                entity.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't create employee " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void updateEntity(Employee entity) {
        Connection connection = CONNECTION_POOL.getConnection();
        String update = "update Employees set first_name = ?, last_name = ?, specialization_id = ?, posiion = ?, qualification = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setLong(3, entity.getSpecialization().getId());
            preparedStatement.setString(4, entity.getPosition().name());
            preparedStatement.setInt(5, entity.getQualification());
            preparedStatement.setLong(6, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't update employee " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void removeEntity(long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String delete = "delete from Employees where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't delete employee " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
