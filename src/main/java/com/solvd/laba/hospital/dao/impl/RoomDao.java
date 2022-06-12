package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.ConnectionPool;
import com.solvd.laba.hospital.dao.IRoomDao;
import com.solvd.laba.hospital.dao.listener.DbEventManager;
import com.solvd.laba.hospital.model.Room;

import java.sql.*;

public class RoomDao implements IRoomDao {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public Room getEntityById(long id) {
        Room room = null;

        Connection connection = CONNECTION_POOL.getConnection();
        String select = "select r.id, r.number from Rooms r where r.id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                room = new Room();
                room.setId(resultSet.getLong("id"));
                room.setNumber(resultSet.getInt("number"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Can't select room " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return room;
    }

    @Override
    public void saveEntity(Room entity) {
        Connection connection = CONNECTION_POOL.getConnection();
        String insert = "insert into Rooms (number) values (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, entity.getNumber());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                entity.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't create room " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        DbEventManager.createInstance().notify(DbEventManager.Type.ROOM_SAVING, "Room " + entity.getId() + " was saved");
    }

    @Override
    public void updateEntity(Room entity) {
        Connection connection = CONNECTION_POOL.getConnection();
        String update = "update Rooms set number = ? where id = ?";
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement(update);
            preparedStatement.setInt(1, entity.getNumber());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't update room " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void removeEntity(long id) {
        Connection connection = CONNECTION_POOL.getConnection();
        String delete = "delete from Rooms where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't delete room " + e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
