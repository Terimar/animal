package com.solvd.laba.hospital.dao.factory;

import com.solvd.laba.hospital.dao.IBaseDAO;

public interface DaoFactory {

    IBaseDAO<?> createDao(String daoName);

}
