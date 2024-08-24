<%@page import="com.conn.DBConnection"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.entity.Student"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<%@ include file="css.jsp"%>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card" >
					<div class="card-body">
						<p class="fs-3 text-center">Edit Student</p>
				    	<%
						int id = Integer.parseInt(request.getParameter("id"));
						StudentDao dao = new StudentDao(DBConnection.getConnections());
						Student s = dao.getStudentById(id);
						%>
						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Student Name</label>
								<input type="text" name="name" value="<%=s.getName()%>" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Date of Birth</label>
								<input type="date" name="dob" value="<%=s.getDob()%>" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Address</label>
								<input type="text" name="address" value="<%=s.getAddress()%>" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label>
								<input type="text" name="qualification" value="<%=s.getQualification()%>" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label>
								<input type="email" name="email" value="<%=s.getEmail()%>" class="form-control">
							</div>

							<input type="hidden" name="id" value="<%=s.getId()%>">

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>