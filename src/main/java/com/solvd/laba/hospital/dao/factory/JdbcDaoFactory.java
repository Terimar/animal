package com.solvd.laba.hospital.dao.factory;

import com.solvd.laba.hospital.dao.IBaseDAO;
import com.solvd.laba.hospital.dao.impl.*;

public class JdbcDaoFactory implements DaoFactory {

    @Override
    public IBaseDAO<?> createDao(String daoName) {
        IBaseDAO<?> result = null;
        switch (daoName) {
            case "address":
                result = new AddressDao();
                break;
            case "employee":
                result = new EmployeeDao();
                break;
            case "room":
                result = new RoomDao();
                break;
            case "specialization":
                result = new SpecializationDao();
                break;
            case "supplier":
                result = new SupplierDao();
                break;
        }
        return result;
    }
}
