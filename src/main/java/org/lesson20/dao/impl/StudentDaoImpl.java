package org.lesson20.dao.impl;

import org.lesson20.dao.StudentDao;
import org.lesson20.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private final static String  url = "jdbc:postgresql://localhost:5432/postgres";
    private final static String user="postgres";
    private final static String password ="14271915";
    @Override
    public void insertStudent(Student student) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO students(id_student,first_name, second_name,position_ref)values(?,?,?,?) ");
        statement.setInt(1,student.getId());
        statement.setString(2, student.getFirstName());
        statement.setString(3, student.getSecondName());
        statement.setInt(4,student.getCity().getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public List<Student> getAllStudents() throws ClassNotFoundException, SQLException {
        List <Student > group = new ArrayList<Student>();
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt("id_student"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setSecondName(resultSet.getString("second_name"));
            group.add(student);
        }
        statement.close();
        connection.close();

        return group;
    }

    @Override
    public void deleteStudent(Student student) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement statement = connection.prepareStatement("DELETE FROM students WHERE id_student=?");
        statement.setInt(1,student.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
