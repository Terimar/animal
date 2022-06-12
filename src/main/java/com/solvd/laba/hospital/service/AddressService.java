package com.solvd.laba.hospital.service;

import com.solvd.laba.hospital.dao.IAddressDao;
import com.solvd.laba.hospital.dao.factory.AbstractDaoFactory;
import com.solvd.laba.hospital.dao.factory.DaoType;
import com.solvd.laba.hospital.model.Address;

public class AddressService {

    private final IAddressDao addressDao = (IAddressDao) AbstractDaoFactory.createDao(DaoType.MYBATIS).createDao("address");

    public Address create(Address address) {
        addressDao.saveEntity(address);
        return address;
    }

    public Address getById(Long id) {
        return addressDao.getEntityById(id);
    }

    public Address update(Address address) {
        addressDao.updateEntity(address);
        return address;
    }

    public void delete(Long id) {
        addressDao.removeEntity(id);
    }
}
