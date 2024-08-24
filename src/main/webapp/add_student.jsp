<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding Student</title>
<%@ include file="css.jsp"%>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Student</p>

						<c:if test="${not empty successMsg}">
						    <div class="text-center text-success">${successMsg}</div>
						    <c:remove var="successMsg" />
						</c:if>

						<c:if test="${not empty errorMsg}">
                        	<div class="text-center text-danger">${errorMsg}</div>
                        	<c:remove var="errorMsg" />
                        </c:if>

						<form action="register" method="post">
							<div class="mb-3">
								<label class="form-label">Student Name</label>
								<input type="text" name="name" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Date of Birth</label>
								<input type="date" name="dob" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Address</label>
								<input type="text" name="address" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label>
								<input type="text" name="qualification" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label>
								<input type="email" name="email" class="form-control">
							</div>

							<button type="submit" class="btn btn-primary col-md-12">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>