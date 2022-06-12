package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.ISpecializationDao;
import com.solvd.laba.hospital.dao.MybatisConfig;
import com.solvd.laba.hospital.model.Specialization;
import org.apache.ibatis.session.SqlSession;

public class SpecializationMybatisDao implements ISpecializationDao {

    @Override
    public Specialization getEntityById(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ISpecializationDao specializationDao = (ISpecializationDao) DaoFactory.createDao(session, "specialization");
            return specializationDao.getEntityById(id);
        }
    }

    @Override
    public void saveEntity(Specialization entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ISpecializationDao specializationDao = (ISpecializationDao) DaoFactory.createDao(session, "specialization");
            specializationDao.saveEntity(entity);
        }
    }

    @Override
    public void updateEntity(Specialization entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ISpecializationDao specializationDao = (ISpecializationDao) DaoFactory.createDao(session, "specialization");
            specializationDao.updateEntity(entity);
        }
    }

    @Override
    public void removeEntity(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ISpecializationDao specializationDao = (ISpecializationDao) DaoFactory.createDao(session, "specialization");
            specializationDao.removeEntity(id);
        }
    }
}
