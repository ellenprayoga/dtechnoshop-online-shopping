<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<script>
	window.title = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<title>D'TechnoShop Management - ${title}</title>

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
	<%@include file="./shared/managementNavbar.jsp"%>

	<div id="content">
		<div class="container-fluid mt-5">
			<div class="row">

				<div class="col-12">
					<c:if test="${userClickManagementHome}">
						<%@include file="managementHome.jsp"%>
					</c:if>

					<c:if test="${userClickManagementProduct}">
						<%@include file="managementProduct.jsp"%>
					</c:if>

					<c:if test="${userClickManagementCategoryProduct}">
						<%@include file="managementCategoryProduct.jsp"%>
					</c:if>

					<c:if test="${userClickManagementUser}">
						<%@include file="managementUser.jsp"%>
					</c:if>

					<c:if test="${userClickManagementCartLines}">
						<%@include file="managementCartLines.jsp"%>
					</c:if>
					
					<c:if test="${userClickDistribution}">
						<%@include file="managementDistribution.jsp"%>
					</c:if>
				</div>
			</div>
		</div>
	</div>


	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>


	<!-- Bootstrap core JavaScript -->
	<script src="${jquery}/jquery.min.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>

	<!-- Custom javascript -->
	<script>
		$(document).ready(function() {
			$('#content').css('min-height', 500);

			switch (title) {

			case 'Produk': {
				$('#manageProduct').addClass('active');
				break;
			}

			case 'Kategori Produk': {
				$('#manageCategoryProduct').addClass('active');
				break;
			}

			case 'User': {
				$('#manageUser').addClass('active');
				break;
			}

			case 'Detil Pesanan': {
				$('#manageCartLines').addClass('active');
				break;
			}
			
			case 'Distribusi' : {
				$('#manageDistribution').addClass('active');
			}
			};
		})
	</script>
</body>
</html>


