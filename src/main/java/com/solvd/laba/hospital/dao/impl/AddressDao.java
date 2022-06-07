package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.ConnectionPool;
import com.solvd.laba.hospital.dao.IAddressDao;
import com.solvd.laba.hospital.model.Address;

import java.sql.*;

public class AddressDao implements IAddressDao {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public Address getEntityById(long id) {
        Address address = null;

        Connection connection = CONNECTION_POOL.getConnection();
        String select = "select a.id, a.city, a.street, a.building_number from Addresses a where a.id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                address = new Address();
                address.setId(resultSet.getLong("id"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setBuildingNumber(resultSet.getString("building_number"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Can't select address " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return address;
    }

    @Override
    public void saveEntity(Address entity) {
        Connection connection = CONNECTION_POOL.getConnection();
        String insert = "insert into Addresses (city, street, building_number) values (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getCity());
            preparedStatement.setString(2, entity.getStreet());
            preparedStatement.setString(3, entity.getBuildingNumber());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                entity.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't create address " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void updateEntity(Address entity) {
        Connection connection = CONNECTION_POOL.getConnection();
        String update = "update Addresses set city = ?, street = ?, building_number = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement(update);
            preparedStatement.setString(1, entity.getCity());
            preparedStatement.setString(2, entity.getStreet());
            preparedStatement.setString(3, entity.getBuildingNumber());
            preparedStatement.setLong(4, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't update address " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void removeEntity(long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String delete = "delete from Addresses where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't delete address " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
