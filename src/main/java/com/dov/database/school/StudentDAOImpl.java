package com.dov.database.school;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean addStudent(Student student) throws ClassNotFoundException, SQLException {
        StudentDBConfig studentDBConfig = new StudentDBConfig();
        Connection connection = studentDBConfig.getConnection();
        String insertionQuery = "INSERT INTO student (id, firstName, lastName) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertionQuery);
        preparedStatement.setInt(1, student.getId());
        preparedStatement.setString(2, student.getFirstName());
        preparedStatement.setString(3, student.getLastName());
        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    }

    @Override
    public List<Student> getAllStudents() throws ClassNotFoundException, SQLException {
        ArrayList<Student> students = new ArrayList<>();
        StudentDBConfig studentDBConfig = new StudentDBConfig();
        Connection connection = studentDBConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from student");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            System.out.println("id: " + id);
            students.add(new Student(firstName, lastName, id));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return students;
    }

    @Override
    public void deleteStudent(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
    }

    @Override
    public void updateStudent(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStudent'");
    }

    @Override
    public Student findStudentById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findStudentById'");
    }

}
