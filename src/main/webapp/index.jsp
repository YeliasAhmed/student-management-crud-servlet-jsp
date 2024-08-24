<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnection"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.entity.Student"%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>

<%@ include file="css.jsp"%>
</head>
<body class="bg-light">

	<%@include file="navbar.jsp"%>

	<div class="container p-3">
		<div class="card">
			<div class="card-body">
				<p class="text-center fs-1">Student Details List</p>

				<c:if test="${not empty successMsg}">
                    <div class="text-center text-success">${successMsg}</div>
                    <c:remove var="successMsg" />
                </c:if>

                <c:if test="${not empty errorMsg}">
                   <div class="text-center text-danger">${errorMsg}</div>
                   <c:remove var="errorMsg" />
                </c:if>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Student Name</th>
							<th scope="col">Birth Date</th>
							<th scope="col">Address</th>
							<th scope="col">Qualification</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					<%
					StudentDao dao = new StudentDao(DBConnection.getConnections());
                    List<Student> list = dao.getAllStudent();
                    for (Student s : list) {
                    %>
                    <tr>
                        <td><%=s.getName() %></td>
                        <td><%=s.getDob() %></td>
                        <td><%=s.getAddress() %></td>
                        <td><%=s.getQualification() %></td>
                        <td><%=s.getEmail() %></td>
                        <td>
                        <a href="edit_student.jsp?id=<%=s.getId()%>" class="btn btn-sm btn-primary">Edit</a>
                        <a href="delete?id=<%=s.getId()%>" class="btn btn-sm btn-danger ms-2">Delete</a>
                        </td>
                    </tr>
                    <%
                      }
                    %>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
