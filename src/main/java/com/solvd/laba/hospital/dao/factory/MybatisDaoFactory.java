package com.solvd.laba.hospital.dao.factory;

import com.solvd.laba.hospital.dao.*;
import com.solvd.laba.hospital.dao.impl.*;

public class MybatisDaoFactory implements DaoFactory {

    @Override
    public IBaseDAO<?> createDao(String daoName) {
        IBaseDAO<?> result = null;
        switch (daoName) {
            case "address":
                result = new AddressMybatisDao();
                break;
            case "employee":
                result = new EmployeeMybatisDao();
                break;
            case "room":
                result = new RoomMybatisDao();
                break;
            case "specialization":
                result = new SpecializationDao();
                break;
            case "supplier":
                result = new SupplierMybatisDao();
                break;
        }
        return result;
    }
}
