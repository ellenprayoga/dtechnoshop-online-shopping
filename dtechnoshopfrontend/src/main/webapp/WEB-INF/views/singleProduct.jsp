<div class="container">
	<div class="row">

		<!-- Sidebar -->
		<div class="col-sm-3 mt-4">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- Content -->
		<div class="col-sm-9 pt-2">

			<!-- Breadcrumb -->
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="${contextRoot}/index"
						style="text-decoration: none">Home</a></li>
					<li class="breadcrumb-item"><a
						href="${contextRoot}/show/category/${product.categoryId}/products"
						style="text-decoration: none">${productCategory}</a></li>
					<li class="breadcrumb-item active" aria-current="listOfProduct">${product.productName}</li>
				</ol>
			</nav>

			<!-- Product Info -->
			<div class="container">
				<div class="row flex-nowrap">
					<div
						style="width: 300px; height: 300px; float: left; margin-right: 15px;">
						<img class="img-fluid img-thumbnail"
							src="${images}/${product.productCode}.jpg" alt="No Image" />
					</div>

					<div>
						<h3>${product.productName}</h3>

						<hr />
						<h5>Harga: Rp. <fmt:formatNumber value="${product.msrp}" type="number" maxFractionDigits="0" /></h5>
						<h5>Stok: 
							<c:choose>
								<c:when test="${product.quantity == 0}">
									Habis
								</c:when>
									
								<c:otherwise>
									${product.quantity}
								</c:otherwise>	
							</c:choose>
						</h5>

						<hr />
						<c:choose>
							<c:when test="${product.quantity == 0}">
								<a href="#" class="btn btn-success float-left mr-1 disabled" role="button">Beli</a>
							</c:when>
								
							<c:when test="${userData == null}">
								<a href="${contextRoot}/login" class="btn btn-success float-left mr-1" role="button">Beli</a>
							</c:when>
							
							<c:otherwise>
								<a href="${contextRoot}/addToCart/${product.id}" class="btn btn-success float-left mr-1" role="button">Beli</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<div class="row mt-2">
					<p>${product.description}</p>
				</div>
			</div>
		</div>
	</div>
</div>