package org.lesson20.dao.impl;

import org.lesson20.dao.CityDao;
import org.lesson20.dao.StudentDao;
import org.lesson20.dao.TableDao;

public class DaoProvider {

    private static final DaoProvider INSTANCE = new DaoProvider();
    private StudentDao studentDao= new StudentDaoImpl();
    private CityDao cityDao = new CityDaoImpl();
    private TableDao tableDao = new TableDaoImpl();
    private DaoProvider(){}
    public static DaoProvider getInstance(){
        return INSTANCE;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public TableDao getTableDao() {
        return tableDao;
    }

    public void setTableDao(TableDao tableDao) {
        this.tableDao = tableDao;
    }
}
