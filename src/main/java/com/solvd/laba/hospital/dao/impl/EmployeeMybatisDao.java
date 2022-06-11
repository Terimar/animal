package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.IEmployeeDao;
import com.solvd.laba.hospital.dao.MybatisConfig;
import com.solvd.laba.hospital.model.Employee;
import org.apache.ibatis.session.SqlSession;

public class EmployeeMybatisDao implements IEmployeeDao {

    @Override
    public Employee getEntityById(long id) {
        Employee result;
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IEmployeeDao employeeDao = session.getMapper(IEmployeeDao.class);
            result = employeeDao.getEntityById(id);
        }
        return result;
    }

    @Override
    public void saveEntity(Employee entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IEmployeeDao employeeDao = session.getMapper(IEmployeeDao.class);
            employeeDao.saveEntity(entity);
        }
    }

    @Override
    public void updateEntity(Employee entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IEmployeeDao employeeDao = session.getMapper(IEmployeeDao.class);
            employeeDao.updateEntity(entity);
        }
    }

    @Override
    public void removeEntity(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IEmployeeDao employeeDao = session.getMapper(IEmployeeDao.class);
            employeeDao.removeEntity(id);
        }
    }
}
