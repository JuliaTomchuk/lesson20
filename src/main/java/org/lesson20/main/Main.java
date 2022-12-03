package org.lesson20.main;

import org.lesson20.dao.CityDao;
import org.lesson20.dao.StudentDao;
import org.lesson20.dao.TableDao;
import org.lesson20.dao.impl.DaoProvider;
import org.lesson20.entity.City;
import org.lesson20.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String  url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user="postgres";
    private final static String password ="14271915";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        City berlin = new City(1,"Berlin");
        City wangen = new City(3,"Wangen");
        City bremen = new City(2,"Bremen");

        Student one = new Student(1,"Ann","Novak",bremen);
        Student two = new Student(2,"Alex","Orlov",wangen);
        Student three = new Student(3,"Joe","Black",berlin);

        DaoProvider daoProvider= DaoProvider.getInstance();
       TableDao tableDao = daoProvider.getTableDao();
       tableDao.createTableOfCities();
      tableDao.createTableStudents();

        CityDao cityDao=daoProvider.getCityDao();
        cityDao.insertCity(berlin);
        cityDao.insertCity(wangen);
        cityDao.insertCity(bremen);

        StudentDao studentDao = daoProvider.getStudentDao();
        studentDao.insertStudent(one);
        studentDao.insertStudent(two);
        studentDao.insertStudent(three);

        System.out.println("All students");
        List <Student> group =studentDao.getAllStudents();
        group.forEach(System.out::println);

        System.out.println("All Students with cities");
        List<Student> students =tableDao.joinTables();
        students.forEach(System.out::println);

        studentDao.deleteStudent(one);
        cityDao.deleteCity(bremen);

        System.out.println("Students with cites after delete");

        List<Student> group2 = tableDao.joinTables();

        group2.forEach(System.out::println);









    }

    }
