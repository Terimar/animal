package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.ConnectionPool;
import com.solvd.laba.hospital.dao.ISpecializationDao;
import com.solvd.laba.hospital.model.Specialization;

import java.sql.*;

public class SpecializationDao implements ISpecializationDao {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public Specialization getEntityById(long id) {
        Specialization specialization = null;

        Connection connection = CONNECTION_POOL.getConnection();
        String select = "select s.id, s.name, s.salary from Specializations s where s.id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                specialization = new Specialization();
                specialization.setId(resultSet.getLong("id"));
                specialization.setName(resultSet.getString("name"));
                specialization.setSalary(resultSet.getBigDecimal("salary"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Can't select specialization " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return specialization;
    }

    @Override
    public void saveEntity(Specialization entity) {
        Connection connection = CONNECTION_POOL.getConnection();
        String insert = "insert into Specializations (name, salary) values (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setBigDecimal(2, entity.getSalary());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                entity.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't create specialization " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void updateEntity(Specialization entity) {
        Connection connection = CONNECTION_POOL.getConnection();
        String update = "update Specializations set name = ?, salary = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement(update);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setBigDecimal(2, entity.getSalary());
            preparedStatement.setLong(3, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't update specialization " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void removeEntity(long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String delete = "delete from Specializations where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't delete specialization " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
