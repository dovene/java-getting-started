package com.dov.database;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    boolean addStudent(Student student) throws ClassNotFoundException, SQLException;

    void deleteStudent(int id);

    void updateStudent(int id);

    List<Student> getAllStudents() throws ClassNotFoundException, SQLException;

    Student findStudentById(int id);
}
