package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.*;
import org.apache.ibatis.session.SqlSession;

public class DaoFactory {

    public static IBaseDAO<?> createDao(SqlSession session, String daoName) {
        IBaseDAO<?> result = null;
        switch (daoName) {
            case "address":
                result = session.getMapper(IAddressDao.class);
                break;
            case "employee":
                result = session.getMapper(IEmployeeDao.class);
                break;
            case "room":
                result = session.getMapper(IRoomDao.class);
                break;
            case "specialization":
                result = session.getMapper(ISpecializationDao.class);
                break;
            case "supplier":
                result = session.getMapper(ISupplierDao.class);
                break;
        }
        return result;
    }
}
