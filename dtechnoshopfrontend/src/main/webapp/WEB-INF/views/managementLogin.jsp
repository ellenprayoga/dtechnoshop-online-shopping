<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Set contextRoot -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!-- Assets locations -->
<sf:url var="css" value="/resources/css" />
<sf:url var="js" value="/resources/js" />
<sf:url var="jquery" value="/resources/jquery" />
<sf:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>D'TechnoShop - ADMIN LOGIN</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/bootstrap-custom.css" rel="stylesheet">

<!-- Internal custom CSS -->
<style>
	/** Error CSS class */
	.customErrors {
		color: red;
	}
</style>
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="offset-sm-4 col-sm-4">

				<div class="mt-5">
					<div style="border: 1px solid lightgray; padding: 15px">
						<form:form action="${contextRoot}/dataManagement/adminLogin" method="POST" modelAttribute="userAdmin">
							
							<img src="${images}/user.png" style="margin-left: 135px" />
							<h4 style="text-align: center; font-weight: bold; margin-bottom: 20px">ADMIN LOGIN</h4>
							
							<div class="form-group">
								<label for="email">Email: </label> 
								<form:input path="email" class="form-control" aria-describedby="email" placeholder="Email" maxlength="50" />
								<form:errors path="email" cssClass="customErrors" element="em"/>
							</div>

							<div class="form-group">
								<label for="password">Password: </label>
								<form:password path="password" class="form-control" aria-describedby="password" placeholder="Password" maxlength="30" />
								<form:errors path="password" cssClass="customErrors" element="em"/>
							</div>

							<div class="form-group">
								<div class="offset-sm-4 col-sm-4" style="margin-top: 25px">
									<input type="submit" class="btn btn-primary btn-block" value="Masuk" />
								</div>
							</div>
						</form:form>
					</div>

				</div>

			</div>
		</div>
	</div>


	<!-- Bootstrap core JavaScript -->
	<script src="${jquery}/jquery.min.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>
</body>
</html>


