package com.solvd.laba.hospital.service;

import com.solvd.laba.hospital.dao.impl.SpecializationDao;
import com.solvd.laba.hospital.model.Specialization;

public class SpecializationService {

    private final SpecializationDao specializationDao = new SpecializationDao();

    public Specialization create(Specialization specialization) {
        specializationDao.saveEntity(specialization);
        return specialization;
    }

    public Specialization getById(Long id) {
        return specializationDao.getEntityById(id);
    }

    public Specialization update(Specialization specialization) {
        specializationDao.updateEntity(specialization);
        return specialization;
    }

    public void delete(Long id) {
        specializationDao.removeEntity(id);
    }
}
