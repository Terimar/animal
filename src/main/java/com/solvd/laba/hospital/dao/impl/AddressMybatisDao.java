package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.IAddressDao;
import com.solvd.laba.hospital.dao.MybatisConfig;
import com.solvd.laba.hospital.model.Address;
import org.apache.ibatis.session.SqlSession;

public class AddressMybatisDao implements IAddressDao {

    @Override
    public Address getEntityById(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IAddressDao addressDao = (AddressDao) DaoFactory.createDao(session, "address");
            return addressDao.getEntityById(id);
        }
    }

    @Override
    public void saveEntity(Address entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IAddressDao addressDao = (AddressDao) DaoFactory.createDao(session, "address");
            addressDao.saveEntity(entity);
        }
    }

    @Override
    public void updateEntity(Address entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IAddressDao addressDao = (AddressDao) DaoFactory.createDao(session, "address");
            addressDao.updateEntity(entity);
        }
    }

    @Override
    public void removeEntity(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IAddressDao addressDao = (AddressDao) DaoFactory.createDao(session, "address");
            addressDao.removeEntity(id);
        }
    }
}
