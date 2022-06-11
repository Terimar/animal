package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.ISupplierDao;
import com.solvd.laba.hospital.dao.MybatisConfig;
import com.solvd.laba.hospital.model.Supplier;
import org.apache.ibatis.session.SqlSession;

public class SupplierMybatisDao implements ISupplierDao {

    @Override
    public Supplier getEntityById(long id) {
        Supplier result;
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ISupplierDao supplierDao = session.getMapper(ISupplierDao.class);
            result = supplierDao.getEntityById(id);
        }
        return result;
    }

    @Override
    public void saveEntity(Supplier entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ISupplierDao supplierDao = session.getMapper(ISupplierDao.class);
            supplierDao.saveEntity(entity);
        }
    }

    @Override
    public void updateEntity(Supplier entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ISupplierDao supplierDao = session.getMapper(ISupplierDao.class);
            supplierDao.updateEntity(entity);
        }
    }

    @Override
    public void removeEntity(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ISupplierDao supplierDao = session.getMapper(ISupplierDao.class);
            supplierDao.removeEntity(id);
        }
    }
}
