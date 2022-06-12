package com.solvd.laba.hospital.service;

import com.solvd.laba.hospital.dao.IEmployeeDao;
import com.solvd.laba.hospital.dao.factory.AbstractDaoFactory;
import com.solvd.laba.hospital.dao.factory.DaoType;
import com.solvd.laba.hospital.model.Employee;
import com.solvd.laba.hospital.model.Specialization;

public class EmployeeService {

    private final IEmployeeDao employeeDao = (IEmployeeDao) AbstractDaoFactory.createDao(DaoType.MYBATIS).createDao("employee");
    private final SpecializationService specializationService = new SpecializationService();

    public Employee create(Employee employee) {
        if (employee.getSpecialization() != null) {
            Specialization specialization = specializationService.create(employee.getSpecialization());
            employee.setSpecialization(specialization);
        }
        employeeDao.saveEntity(employee);
        return employee;
    }

    public Employee getById(Long id) {
        return employeeDao.getEntityById(id);
    }

    public Employee update(Employee employee) {
        if (employee.getSpecialization() != null) {
            Specialization specialization = specializationService.update(employee.getSpecialization());
            employee.setSpecialization(specialization);
        }
        employeeDao.updateEntity(employee);
        return employee;
    }

    public void delete(Long id) {
        employeeDao.removeEntity(id);
    }
}
