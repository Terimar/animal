package com.solvd.laba.hospital.dao.factory;

public class AbstractDaoFactory {


    public static DaoFactory createDao(DaoType type) {
        DaoFactory result = null;
        switch (type) {
            case JDBC:
                result = new JdbcDaoFactory();
                break;
            case MYBATIS:
                result = new MybatisDaoFactory();
                break;
        }
        return result;
    }
}
