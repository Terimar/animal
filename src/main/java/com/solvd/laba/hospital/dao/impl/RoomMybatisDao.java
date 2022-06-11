package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.IRoomDao;
import com.solvd.laba.hospital.dao.MybatisConfig;
import com.solvd.laba.hospital.model.Room;
import org.apache.ibatis.session.SqlSession;

public class RoomMybatisDao implements IRoomDao {

    @Override
    public Room getEntityById(long id) {
        Room result;
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IRoomDao roomDao = session.getMapper(IRoomDao.class);
            result = roomDao.getEntityById(id);
        }
        return result;
    }

    @Override
    public void saveEntity(Room entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IRoomDao roomDao = session.getMapper(IRoomDao.class);
            roomDao.saveEntity(entity);
        }
    }

    @Override
    public void updateEntity(Room entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IRoomDao roomDao = session.getMapper(IRoomDao.class);
            roomDao.updateEntity(entity);
        }
    }

    @Override
    public void removeEntity(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IRoomDao roomDao = session.getMapper(IRoomDao.class);
            roomDao.removeEntity(id);
        }
    }
}
