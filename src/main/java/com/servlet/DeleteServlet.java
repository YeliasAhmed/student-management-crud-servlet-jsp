package com.servlet;

import com.conn.DBConnection;
import com.dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        StudentDao studentDao = new StudentDao(DBConnection.getConnections());
        HttpSession session = req.getSession();

        if (studentDao.deleteStudent(id)) {
            session.setAttribute("successMsg", "Student deleted successfully.");
        } else {
            session.setAttribute("errorMsg", "Failed to delete student.");
        }

        resp.sendRedirect("index.jsp");
    }
}
