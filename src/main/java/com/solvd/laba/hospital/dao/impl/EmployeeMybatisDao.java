package com.solvd.laba.hospital.dao.impl;

import com.solvd.laba.hospital.dao.IEmployeeDao;
import com.solvd.laba.hospital.dao.MybatisConfig;
import com.solvd.laba.hospital.dao.listener.DbEventManager;
import com.solvd.laba.hospital.model.Employee;
import org.apache.ibatis.session.SqlSession;

public class EmployeeMybatisDao implements IEmployeeDao {

    @Override
    public Employee getEntityById(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IEmployeeDao employeeDao = (IEmployeeDao) DaoFactory.createDao(session, "employee");
            Employee employee = employeeDao.getEntityById(id);

            DbEventManager.createInstance().notify(DbEventManager.Type.EMPLOYEE_GETTING, "Employee " + employee.getId() + " was found");

            return employee;
        }
    }

    @Override
    public void saveEntity(Employee entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IEmployeeDao employeeDao = (IEmployeeDao) DaoFactory.createDao(session, "employee");
            employeeDao.saveEntity(entity);

            DbEventManager.createInstance().notify(DbEventManager.Type.EMPLOYEE_SAVING, "Employee " + entity.getId() + " was saved");
        }
    }

    @Override
    public void updateEntity(Employee entity) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IEmployeeDao employeeDao = (IEmployeeDao) DaoFactory.createDao(session, "employee");
            employeeDao.updateEntity(entity);
        }
    }

    @Override
    public void removeEntity(long id) {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            IEmployeeDao employeeDao = (IEmployeeDao) DaoFactory.createDao(session, "employee");
            employeeDao.removeEntity(id);
        }
    }
}
