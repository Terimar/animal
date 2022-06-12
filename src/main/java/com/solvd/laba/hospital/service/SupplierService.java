package com.solvd.laba.hospital.service;

import com.solvd.laba.hospital.dao.ISupplierDao;
import com.solvd.laba.hospital.dao.factory.AbstractDaoFactory;
import com.solvd.laba.hospital.dao.factory.DaoType;
import com.solvd.laba.hospital.model.Supplier;

public class SupplierService {

    private final ISupplierDao supplierDao = (ISupplierDao) AbstractDaoFactory.createDao(DaoType.MYBATIS).createDao("supplier");

    public Supplier create(Supplier supplier) {
        supplierDao.saveEntity(supplier);
        return supplier;
    }

    public Supplier getById(Long id) {
        return supplierDao.getEntityById(id);
    }

    public Supplier update(Supplier supplier) {
        supplierDao.updateEntity(supplier);
        return supplier;
    }

    public void delete(Long id) {
        supplierDao.removeEntity(id);
    }
}
