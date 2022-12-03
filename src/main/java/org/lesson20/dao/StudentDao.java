package org.lesson20.dao;

import org.lesson20.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

    void insertStudent(Student student) throws ClassNotFoundException, SQLException;
     List<Student> getAllStudents() throws ClassNotFoundException, SQLException;
    void deleteStudent(Student student) throws SQLException, ClassNotFoundException;
}
