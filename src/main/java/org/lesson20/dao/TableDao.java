package org.lesson20.dao;

import org.lesson20.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface TableDao {
    List<Student> joinTables() throws ClassNotFoundException, SQLException;
   void createTableOfCities() throws ClassNotFoundException, SQLException;
    void createTableStudents() throws ClassNotFoundException, SQLException;
}
