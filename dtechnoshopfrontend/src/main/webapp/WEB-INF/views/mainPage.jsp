<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Set contextRoot -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!-- Assets locations -->
<sf:url var="css" value="/resources/css" />
<sf:url var="js" value="/resources/js" />
<sf:url var="jquery" value="/resources/jquery" />
<sf:url var="images" value="/resources/images" />

<!-- JavaScrip window -->
<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>D'TechnoShop - ${title}</title>

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
		
		body {
			min-height: 100%;
		}
    </style>

  </head>

  <body>

    <!-- Navigation -->
    <div id="header">
    <%@ include file="./shared/navbar.jsp" %>
	</div>

    <!-- Content -->
    <div id="content">
    <c:if test="${userClickHome}">
    	<%@ include file="home.jsp" %>
    </c:if>
    
    <c:if test="${userClickAbout}">
    	<%@ include file="aboutUs.jsp" %>
    </c:if>
    
    <c:if test="${userClickContact}">
    	<%@ include file="contact.jsp" %>
    </c:if>
    
    <c:if test="${userClickCategoryProducts}">
    	<%@ include file="listProducts.jsp" %>
    </c:if>
    
    <c:if test="${userClickSingleProducts}">
    	<%@ include file="singleProduct.jsp" %>
	</c:if>
	
	<c:if test="${userClickRegister}">
    	<%@ include file="register.jsp" %>
	</c:if>
	
	<c:if test="${userClickRegisterSuccess}">
    	<%@ include file="registerSuccess.jsp" %>
	</c:if>
	
	<c:if test="${userClickLogin}">
    	<%@ include file="login.jsp" %>
	</c:if>
	
	<c:if test="${userClickCart}">
    	<%@ include file="cart.jsp" %>
	</c:if>
	
	<c:if test="${userClickUserCartLine}">
		<%@ include file="cart.jsp" %>
	</c:if>
	
	<c:if test="${userClickConfirmUserCartLines}">
		<%@ include file="confirmCart.jsp" %>
	</c:if>
	
	<c:if test="${userClickPayments}">
		<%@ include file="payment.jsp" %>
	</c:if>
	
	</div>
    
    <!-- Footer -->
    <div id="footer">
    <%@ include file="./shared/footer.jsp" %>
	</div>

    <!-- Bootstrap core JavaScript -->
    <script src="${jquery}/jquery.min.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    
    <!-- My Custom JavaScript -->
    <%-- <script src="${js}/myCustom.js"></script> --%>
    
    <script>
    	// Set active navbar
    	$(document).ready(function() {
    		
    		$('#content').css('min-height', 500);
    		
    		
    		switch(menu) {
			case 'Tentang' : 
				$('#aboutUs').addClass('active');
			break;
			
			case 'Kontak' : 
				$('#contact').addClass('active');
			break;
			
			case 'Daftar' :
				$('#signUp').addClass('active');
			break;
			
			case 'Masuk' :
				$('#login').addClass('active');
			break;
			
			default :
				$('#ct' + menu).addClass('list-group-item-primary');
			break;
		}
    		
    		
    	// Update and remove item at user cart
			$('button').click(function() {
				var button = $(this).attr('id');
				var cartLineId = button.substring(8, button.length);
				
				$.ajax({
		    		url : contextRoot + '/json/data/product/quantity/' + cartLineId,
		    		method : 'post',
		    		dataType : 'json',
		    		success : function(data) {
		    			if (button.substring(0, 3) == 'ref') {
		    				var productQuantity = $('#quantity_' + cartLineId).val();
		    				
		    				if (productQuantity < 1 || productQuantity > 3) {
		    					alert('Anda hanya dapat memesan minimal 1 dan maksimal 3 per produk');
		    				}
		    				else if (data < productQuantity) {
								alert('Produk hanya tersisa ' + data);
							}
		    				else {
		    					window.location.replace(contextRoot + '/cartUpdate/' + button.substring(8, button.length) + '?quantity=' + productQuantity);
		    				}
		    			}
		    			else if (button.substring(0, 3) == 'rem') {
		    				window.location.replace(contextRoot + '/cartRemove/' + button.substring(8, button.length));
		    			}
		    		}
		    	});
				
			});
    	
    	
    	// Set province, city, and subdistrict
    		// Set province in register page
    		$.ajax({
    			url : contextRoot + '/json/data/province',
    			method : 'post',
    			dataType : 'json',
    			success : function(data) {
    				$.each(data, function(index, value) {
    					$('#province').append('<option value="' + value + '">' + value + '</option>');
    				});
    			}
    		
    		});
    		
    		
    		// Set city if province select is changed
    		$('#province').change(function() {
    			var city = $('#city');
    			city.empty();
    			city.append('<option value="">- Pilih Kota</option>');
    			
    			$.ajax({
    				url : contextRoot + '/json/data/city/' + $('#province').val(),
    				method : 'post',
    				dataType : 'json',
    				success : function(data) {
    					$.each(data, function(index, value) {
    						city.append('<option value="' + value + '">' + value + '</option>');
    						
    					});
    					
    				}
    			});
    		});
    		
    		
    		// Set subdistrict if city select is changed
    		$('#city').change(function() {
    			var subdistrict = $('#subdistrict');
    			subdistrict.empty();
    			subdistrict.append('<option value="">- Pilih Kecamatan</option>');
    			
    			$.ajax({
    				url : contextRoot + '/json/data/subdistrict/' + $('#city').val(),
    				method : 'post',
    				dataType : 'json',
    				success : function(data) {
    					$.each(data, function(index, value) {
    						subdistrict.append('<option value="' + value + '">' + value + '</option>');
    						
    					});
    					
    				}
    			});
    		});	
	});	
    </script>

  </body>

</html>
