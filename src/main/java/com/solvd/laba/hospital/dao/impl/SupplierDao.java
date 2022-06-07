package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.ConnectionPool;
import com.solvd.laba.hospital.dao.ISupplierDao;
import com.solvd.laba.hospital.model.Supplier;

import java.sql.*;

public class SupplierDao implements ISupplierDao {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public Supplier getEntityById(long id) {
        Supplier supplier = null;

        Connection connection = CONNECTION_POOL.getConnection();
        String select = "select s.id, s.name, s.country from Suppliers s where s.id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                supplier = new Supplier();
                supplier.setId(resultSet.getLong("id"));
                supplier.setName(resultSet.getString("name"));
                supplier.setCountry(resultSet.getString("country"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Can't select supplier " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return supplier;
    }

    @Override
    public void saveEntity(Supplier entity) {
        Connection connection = CONNECTION_POOL.getConnection();
        String insert = "insert into Suppliers (name, country) values (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getCountry());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                entity.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't create supplier " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void updateEntity(Supplier entity) {
        Connection connection = CONNECTION_POOL.getConnection();
        String update = "update Suppliers set name = ?, country = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement(update);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getCountry());
            preparedStatement.setLong(3, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't update supplier " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void removeEntity(long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String delete = "delete from Suppliers where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't delete supplier " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
