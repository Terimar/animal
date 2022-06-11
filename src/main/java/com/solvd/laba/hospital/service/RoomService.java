package com.solvd.laba.hospital.service;

import com.solvd.laba.hospital.dao.IRoomDao;
import com.solvd.laba.hospital.dao.impl.RoomDao;
import com.solvd.laba.hospital.dao.impl.RoomMybatisDao;
import com.solvd.laba.hospital.model.Room;

public class RoomService {

    private final IRoomDao roomDao = new RoomMybatisDao();//new RoomDao();

    public Room create(Room room) {
        roomDao.saveEntity(room);
        return room;
    }

    public Room getById(Long id) {
        return roomDao.getEntityById(id);
    }

    public Room update(Room room) {
        roomDao.updateEntity(room);
        return room;
    }

    public void delete(Long id) {
        roomDao.removeEntity(id);
    }
}
