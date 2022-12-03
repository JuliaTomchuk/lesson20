package org.lesson20.dao.impl;

import org.lesson20.dao.TableDao;
import org.lesson20.entity.City;
import org.lesson20.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableDaoImpl implements TableDao {
    private final static String  url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user="postgres";
    private final static String password ="14271915";
    @Override
    public List<Student> joinTables() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement statement = connection.prepareStatement("SELECT ID_STUDENT,FIRST_NAME,SECOND_NAME,id_city,nameOfCity FROM students inner join cities ON id_city=position_ref");
        ResultSet set =statement.executeQuery();
        List <Student> group = new ArrayList<>();
        while(set.next()){
            Student student= new Student();
            student.setId(set.getInt("id_student"));
            student.setFirstName(set.getString("first_name"));
            student.setSecondName(set.getString("second_name"));
            City city= new City();
            city.setId(set.getInt("id_city"));
            city.setName(set.getString("nameOfCity"));
            student.setCity(city);
            group.add(student);
        }
        return group;
    }

    @Override
    public void createTableOfCities() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement statement = connection.prepareStatement("create table cities"+
                "("+
                "id_city int primary key,"+
                "nameOfCity VARCHAR(50))"

        );
        statement.execute();
        statement.close();
        connection.close();
    }

    @Override
    public void createTableStudents() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement statement = connection.prepareStatement("CREATE TABLE STUDENTS"
                + "("
                + " ID_STUDENT INT primary key ,"
                + " FIRST_NAME varchar(50),"
                + " SECOND_NAME VARCHAR(50),"
                +"position_ref int)");
        statement.execute();
        statement.close();
        connection.close();
    }
}
