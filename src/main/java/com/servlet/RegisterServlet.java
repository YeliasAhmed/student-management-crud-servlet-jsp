package com.servlet;

import com.conn.DBConnection;
import com.dao.StudentDao;
import com.entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        String qualification = req.getParameter("qualification");
        String email = req.getParameter("email");

        Student student = new Student(name, dob, address, qualification, email);

        StudentDao studentDao = new StudentDao(DBConnection.getConnections());
        HttpSession session = req.getSession();

        if (studentDao.addStudent(student)) {
            session.setAttribute("successMsg", "Student added successfully.");
        } else {
            session.setAttribute("errorMsg", "Something is wrong on server.");
        }
        resp.sendRedirect("add_student.jsp");
    }
}
