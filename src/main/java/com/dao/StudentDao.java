package com.dao;

import com.conn.DBConnection;
import com.entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private Connection conn;

    public StudentDao(Connection conn) {
        super();
        this.conn = conn;
    }
    public boolean addStudent(Student student) {
        boolean result = false;

        String sql = "INSERT INTO student_details(student_name, birth_date, address, qualification, email) Values (?, ?, ?, ?, ?)";
        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getDob());
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getQualification());
            statement.setString(5, student.getEmail());

            int rowAffected = statement.executeUpdate();
            result = rowAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        Student student = null;

        String sql = "select * from student_details";
        try(PreparedStatement statement = conn.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setDob(resultSet.getString(3));
                student.setAddress(resultSet.getString(4));
                student.setQualification(resultSet.getString(5));
                student.setEmail(resultSet.getString(6));
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Student getStudentById(int id) {
        Student student = null;
        String sql = "select * from student_details where id=?";
        try(PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setDob(resultSet.getString(3));
                student.setAddress(resultSet.getString(4));
                student.setQualification(resultSet.getString(5));
                student.setEmail(resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public boolean updateStudent(Student student) {
        boolean result = false;

        String sql = "update student_details set student_name=?, birth_date=?, address=?, qualification=?, email=? where id=?";
        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setString(2, student.getDob());
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getQualification());
            statement.setString(5, student.getEmail());
            statement.setInt(6, student.getId());

            int rowAffected = statement.executeUpdate();
            result = rowAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteStudent(int id) {
        boolean result = false;

        String sql = "delete from student_details where id=?";
        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowAffected = statement.executeUpdate();
            result = rowAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
