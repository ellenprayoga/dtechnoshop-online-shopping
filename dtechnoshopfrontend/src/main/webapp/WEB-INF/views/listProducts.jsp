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
					<li class="breadcrumb-item active" aria-current="listOfProduct">${title}</li>
				</ol>
			</nav>


			<!-- List of products -->

			<c:if test="${productList.size() == 0}">
				<div class="mr-0 ml-0">
					<p style="text-align: center; color: gray;">Maaf produk yang Anda cari tidak ada</p>
				</div>
			</c:if>
			
			<div class="row">
				<c:if test="${productList.size() != null}">
					<c:forEach items="${productList}" var="product">
						<div class="col-lg-3 col-sm-6 portfolio-item">
							<div class="card">
								<a href="${contextRoot}/product/${product.id}"><img
									class="card-img-top" src="${images}/${product.productCode}.jpg"
									alt="No Image"></a>

								<div class="card-body">
									<h6 class="card-title">
										<a href="${contextRoot}/product/${product.id}"
											style="text-decoration: none">${product.productName}</a>
									</h6>
									<p style="color: orange; font-weight: bolder; font-size: 14px;">
										Rp. <fmt:formatNumber value="${product.msrp}" type="number" maxFractionDigits="0" />
									</p>
									
									<c:choose>
										<c:when test="${product.quantity == 0}">
											<a href="#" class="btn btn-success btn-sm float-right p disabled" role="button">Beli</a>
										</c:when>
								
										<c:when test="${userData == null}">
											<a href="${contextRoot}/login" class="btn btn-success btn-sm float-right" role="button">Beli</a>
										</c:when>
							
										<c:otherwise>
											<a href="${contextRoot}/addToCart/${tablet.id}" class="btn btn-success btn-sm float-right" role="button">Beli</a>
										</c:otherwise>
									</c:choose>
								</div>

							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>


			<!-- Pagination for products
			<div class="row pt-3 float-right">
				<nav aria-label="Product pagination">
					<ul class="pagination">
						<li class="page-item disabled"><a class="page-link"
							tabindex="-1" href="#">Previous</a></li>
						<li class="page-item active"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</nav>
			</div> -->

		</div>
	</div>
</div>