package org.lesson20.dao.impl;

import org.lesson20.dao.CityDao;
import org.lesson20.entity.City;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityDaoImpl implements CityDao {
    private final static String  url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user="postgres";
    private final static String password ="14271915";
    @Override
    public void insertCity(City city) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO cities(id_city,nameOfCity) values  (?,?)");
        statement.setInt(1, city.getId());
        statement.setString(2,city.getName());
        statement.executeUpdate();
        statement.close();
        connection.close();

    }

    @Override
    public void deleteCity(City city) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement statement = connection.prepareStatement("DELETE FROM cities WHERE id_city =?");
        statement.setInt(1,city.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
