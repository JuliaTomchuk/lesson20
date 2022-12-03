package org.lesson20.dao;

import org.lesson20.entity.City;

import java.sql.SQLException;

public interface CityDao {
    void insertCity(City city) throws ClassNotFoundException, SQLException;
    void deleteCity(City city) throws SQLException, ClassNotFoundException;
}
