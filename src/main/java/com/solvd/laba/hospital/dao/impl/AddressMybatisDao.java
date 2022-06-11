package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.IAddressDao;
import com.solvd.laba.hospital.dao.MybatisConfig;
import com.solvd.laba.hospital.model.Address;
import org.apache.ibatis.session.SqlSession;

public class AddressMybatisDao implements IAddressDao {

    @Override
    public Address getEntityById(long id) {
        Address result;
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IAddressDao addressDao = session.getMapper(IAddressDao.class);
            result = addressDao.getEntityById(id);
        }
        return result;
    }

    @Override
    public void saveEntity(Address entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IAddressDao addressDao = session.getMapper(IAddressDao.class);
            addressDao.saveEntity(entity);
        }
    }

    @Override
    public void updateEntity(Address entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IAddressDao addressDao = session.getMapper(IAddressDao.class);
            addressDao.updateEntity(entity);
        }
    }

    @Override
    public void removeEntity(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IAddressDao addressDao = session.getMapper(IAddressDao.class);
            addressDao.removeEntity(id);
        }
    }
}
