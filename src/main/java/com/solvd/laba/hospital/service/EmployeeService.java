package com.solvd.laba.hospital.service;

import com.solvd.laba.hospital.dao.impl.EmployeeDao;
import com.solvd.laba.hospital.model.Employee;
import com.solvd.laba.hospital.model.Specialization;

public class EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDao();
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
