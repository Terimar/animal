package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.IRoomDao;
import com.solvd.laba.hospital.dao.MybatisConfig;
import com.solvd.laba.hospital.dao.listener.DbEventManager;
import com.solvd.laba.hospital.model.Room;
import org.apache.ibatis.session.SqlSession;

public class RoomMybatisDao implements IRoomDao {

    @Override
    public Room getEntityById(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IRoomDao roomDao = (IRoomDao) DaoFactory.createDao(session, "room");
            return roomDao.getEntityById(id);
        }
    }

    @Override
    public void saveEntity(Room entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IRoomDao roomDao = (IRoomDao) DaoFactory.createDao(session, "room");
            roomDao.saveEntity(entity);

            DbEventManager.createInstance().notify(DbEventManager.Type.ROOM_SAVING, "Room " + entity.getId() + " was saved");
        }
    }

    @Override
    public void updateEntity(Room entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IRoomDao roomDao = (IRoomDao) DaoFactory.createDao(session, "room");
            roomDao.updateEntity(entity);
        }
    }

    @Override
    public void removeEntity(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IRoomDao roomDao = (IRoomDao) DaoFactory.createDao(session, "room");
            roomDao.removeEntity(id);
        }
    }
}
