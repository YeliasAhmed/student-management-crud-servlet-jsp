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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        String qualification = req.getParameter("qualification");
        String email = req.getParameter("email");
        String idString = req.getParameter("id");


        if (idString == null || idString.trim().isEmpty()) {
            HttpSession session = req.getSession();
            session.setAttribute("errorMsg", "Invalid student ID.");
            resp.sendRedirect("index.jsp");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idString);
            System.out.println("Updating student with ID: " + id);

        } catch (NumberFormatException e) {
            HttpSession session = req.getSession();
            session.setAttribute("errorMsg", "Invalid student ID format.");
            resp.sendRedirect("index.jsp");
            return;
        }

        Student student = new Student(id, name, dob, address, qualification, email);
        StudentDao studentDao = new StudentDao(DBConnection.getConnections());
        HttpSession session = req.getSession();

        if (studentDao.updateStudent(student)) {
            session.setAttribute("successMsg", "Student updated successfully.");
        } else {
            session.setAttribute("errorMsg", "Something is wrong on server.");
            System.out.println("Update failed for student ID: " + id);

        }
        resp.sendRedirect("index.jsp");
    }
}
