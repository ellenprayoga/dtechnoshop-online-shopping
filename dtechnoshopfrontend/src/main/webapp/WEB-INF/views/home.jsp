<!-- Home -->
<header>


	<!-- Page Content -->
	<div class="container mb-5 mt-3">
		<div class="col-12">

			<!-- List of Smartphones -->
			<div class="row">
				<h4 class="my-4 mr-auto" style="color: #636363">Produk
					Smartphone Terbaru</h4>
				<a href="${contextRoot}/show/category/1/products"
					class="ml-auto mt-4" style="text-decoration: none">Lihat Semua</a>
			</div>

			<div class="row">
				<c:forEach items="${smartphoneProducts}" var="smartphone">
					<div class="col-lg-3 col-sm-6 portfolio-item">
						<div class="card">
							<a href="${contextRoot}/product/${smartphone.id}">
								<div style="height: 250px; width: 250px">
									<img class="card-img-top"
										src="${images}/${smartphone.productCode}.jpg" alt="NO IMAGE" />
								</div>
							</a>
							<div class="card-body">
								<h5 class="card-title">
									<a href="${contextRoot}/product/${smartphone.id}"
										style="text-decoration: none">${smartphone.productName}</a>
								</h5>
								<div>
									<p class="float-left mt-1"
										style="color: orange; font-weight: bolder;">
										<fmt:setLocale value="in_ID" />
										Rp. <fmt:formatNumber value="${smartphone.msrp}" type="number" maxFractionDigits="0" />
									</p>

									<c:choose>
										<c:when test="${smartphone.quantity == 0}">
											<a href="#"
												class="btn btn-success btn-sm float-right p disabled"
												role="button">Beli</a>
										</c:when>

										<c:when test="${userData == null}">
											<a href="${contextRoot}/login"
												class="btn btn-success btn-sm float-right p" role="button">Beli</a>
										</c:when>

										<c:otherwise>
											<a href="${contextRoot}/addToCart/${smartphone.id}"
												class="btn btn-success btn-sm float-right p" role="button">Beli</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>


			<!-- List of Tablets -->
			<div class="row">
				<h4 class="my-4 mr-auto" style="color: #636363">Produk Tablet
					Terbaru</h4>
				<a href="${contextRoot}/show/category/2/products"
					class="ml-auto mt-4" style="text-decoration: none">Lihat Semua</a>
			</div>

			<div class="row">
				<c:forEach items="${tabletProducts}" var="tablet">
					<div class="col-lg-3 col-sm-6 portfolio-item">
						<div class="card">
							<a href="${contextRoot}/product/${tablet.id}">
								<div style="height: 250px; width: 250px">
									<img class="card-img-top"
										src="${images}/${tablet.productCode}.jpg" alt="NO IMAGE" />
								</div>
							</a>
							<div class="card-body">
								<h5 class="card-title">
									<a href="${contextRoot}/product/${tablet.id}"
										style="text-decoration: none">${tablet.productName}</a>
								</h5>
								<div>
									<p class="float-left mt-1"
										style="color: orange; font-weight: bolder;">
										Rp. <fmt:formatNumber value="${tablet.msrp}" type="number" maxFractionDigits="0" />
									</p>

									<c:choose>
										<c:when test="${tablet.quantity == 0}">
											<a href="#"
												class="btn btn-success btn-sm float-right p disabled"
												role="button">Beli</a>
										</c:when>

										<c:when test="${userData == null}">
											<a href="${contextRoot}/login"
												class="btn btn-success btn-sm float-right p" role="button">Beli</a>
										</c:when>

										<c:otherwise>
											<a href="${contextRoot}/addToCart/${tablet.id}"
												class="btn btn-success btn-sm float-right p" role="button">Beli</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>


			<!-- List of Laptops -->
			<div class="row">
				<h4 class="my-4 mr-auto" style="color: #636363">Produk Notebook
					Terbaru</h4>
				<a href="${contextRoot}/show/category/3/products"
					class="ml-auto mt-4" style="text-decoration: none">Lihat Semua</a>
			</div>

			<div class="row">
				<c:forEach items="${laptopProducts}" var="laptop">
					<div class="col-lg-3 col-sm-6 portfolio-item">
						<div class="card">
							<a href="${contextRoot}/product/${laptop.id}">
								<div style="height: 250px; width: 250px">
									<img class="card-img-top"
										src="${images}/${laptop.productCode}.jpg" alt="NO IMAGE" />
								</div>
							</a>
							<div class="card-body">
								<h5 class="card-title">
									<a href="${contextRoot}/product/${laptop.id}"
										style="text-decoration: none">${laptop.productName}</a>
								</h5>
								<div>
									<p class="float-left mt-1"
										style="color: orange; font-weight: bolder;">
										Rp. <fmt:formatNumber value="${laptop.msrp}" type="number" maxFractionDigits="0" />
									</p>

									<c:choose>
										<c:when test="${laptop.quantity == 0}">
											<a href="#"
												class="btn btn-success btn-sm float-right p disabled"
												role="button">Beli</a>
										</c:when>

										<c:when test="${userData == null}">
											<a href="${contextRoot}/login"
												class="btn btn-success btn-sm float-right p" role="button">Beli</a>
										</c:when>

										<c:otherwise>
											<a href="${contextRoot}/addToCart/${laptop.id}"
												class="btn btn-success btn-sm float-right p" role="button">Beli</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>


			<!-- List of PCs -->
			<div class="row">
				<h4 class="my-4 mr-auto" style="color: #636363">Produk PC
					Terbaru</h4>
				<a href="${contextRoot}/show/category/4/products"
					class="ml-auto mt-4" style="text-decoration: none">Lihat Semua</a>
			</div>

			<div class="row">
				<c:forEach items="${pcProducts}" var="pc">
					<div class="col-lg-3 col-sm-6 portfolio-item">
						<div class="card">
							<a href="${contextRoot}/product/${pc.id}">
								<div style="height: 250px; width: 250px">
									<img class="card-img-top" src="${images}/${pc.productCode}.jpg"
										alt="NO IMAGE" />
								</div>
							</a>
							<div class="card-body">
								<h5 class="card-title">
									<a href="${contextRoot}/product/${pc.id}"
										style="text-decoration: none">${pc.productName}</a>
								</h5>
								<div>
									<p class="float-left mt-1"
										style="color: orange; font-weight: bolder;">
										<fmt:setLocale value="in_IN" />
										Rp. <fmt:formatNumber value="${pc.msrp}" type="number" maxFractionDigits="0" />
									</p>

									<c:choose>
										<c:when test="${pc.quantity == 0}">
											<a href="#"
												class="btn btn-success btn-sm float-right p disabled"
												role="button">Beli</a>
										</c:when>

										<c:when test="${userData == null}">
											<a href="${contextRoot}/login"
												class="btn btn-success btn-sm float-right p" role="button">Beli</a>
										</c:when>

										<c:otherwise>
											<a href="${contextRoot}/addToCart/${pc.id}"
												class="btn btn-success btn-sm float-right p" role="button">Beli</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>


			<!-- List of Headsets -->
			<div class="row">
				<h4 class="my-4 mr-auto" style="color: #636363">Produk Headset
					Terbaru</h4>
				<a href="${contextRoot}/show/category/5/products"
					class="ml-auto mt-4" style="text-decoration: none">Lihat Semua</a>
			</div>

			<div class="row">
				<c:forEach items="${headsetProducts}" var="headset">
					<div class="col-lg-3 col-sm-6 portfolio-item">
						<div class="card">
							<a href="${contextRoot}/product/${headset.id}">
								<div style="height: 250px; width: 250px">
									<img class="card-img-top"
										src="${images}/${headset.productCode}.jpg" alt="NO IMAGE" />
								</div>
							</a>
							<div class="card-body">
								<h5 class="card-title">
									<a href="${contextRoot}/product/${headset.id}"
										style="text-decoration: none">${headset.productName}</a>
								</h5>
								<div>
									<p class="float-left mt-1"
										style="color: orange; font-weight: bolder;">
										<fmt:setLocale value="in_IN" />
										Rp. <fmt:formatNumber value="${headset.msrp}" type="number" maxFractionDigits="0" />
									</p>

									<c:choose>
										<c:when test="${smartphone.quantity == 0}">
											<a href="#"
												class="btn btn-success btn-sm float-right p disabled"
												role="button">Beli</a>
										</c:when>

										<c:when test="${userData == null}">
											<a href="${contextRoot}/login"
												class="btn btn-success btn-sm float-right p" role="button">Beli</a>
										</c:when>

										<c:otherwise>
											<a href="${contextRoot}/addToCart/${headset.id}"
												class="btn btn-success btn-sm float-right p" role="button">Beli</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>


			<hr class="pt-1" />


			<!-- About Us -->
			<div class="row">
				<h4 class="my-4 mr-auto" style="color: gray">D'TechnoShop</h4>
				<p class="text-secondary">D'TechnoShop adalah sebuah website
					penjualan berbasis online yang menjual berbagai produk elektronik
					seperti Smartphone, Tablet, Notebook, dll. Kita menjual produk
					dengan kualitas terjamin dan harga yang menarik</p>
			</div>

			<div class="row">
				<div class="col-sm-4">
					<img src="${images}/multiple-devices.png" alt="NO IMAGE"
						class="float-left" />
					<p style="font-weight: bolder">Lengkap</p>
					<p style="color: gray">Kita menjual produk elektronik
						terlengkap dan terbaru</p>
				</div>

				<div class="col-sm-4">
					<img src="${images}/save-money.png" alt="NO IMAGE"
						class="float-left mr-3" />
					<p style="font-weight: bolder">Murah</p>
					<p style="color: gray">Kita menjual produk dengan kualitas
						terjamin dengan harga murah</p>
				</div>

				<div class="col-sm-4">
					<img src="${images}/privacy.png" alt="NO IMAGE"
						class="float-left mr-3" />
					<p style="font-weight: bolder">Aman</p>
					<p style="color: gray">Kita menjamin keamanan transaksi
						pembelian Anda</p>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container -->