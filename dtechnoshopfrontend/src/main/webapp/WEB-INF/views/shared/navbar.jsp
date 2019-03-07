<!-- Navbar -->
<nav
	class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">

	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/index"><h3>D'TechnoShop</h3></a>

		<button class="navbar-toggler" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarResponsive">

			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/aboutUs" id="aboutUs">Tentang</a></li>

				<li class="nav-item dropdown">
					<a id="listCategoryProducts" class="nav-link dropdown-toggle" href="#" id="listProduct" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Daftar Produk </a>
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
						<c:forEach items="${categoryList}" var="category">
							<a class="dropdown-item" href="${contextRoot}/show/category/${category.id}/products">${category.categoryName}</a>
						</c:forEach>
					</div>
				</li>
				
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/contact" id="contact">Kontak</a></li>
				
				
				<!-- User data menus -->
				<c:choose>
					<c:when test="${userData != null}">
						<li class="nav-item dropdown">	
							<a id="user" class="nav-link dropdown-toggle" href="#" id="userAccount" data-toggle="dropdown" 
								aria-haspopup="true" aria-expanded="false">
								<img src="${images}/user-filled.png" style="width: 18px; height: 18px; margin-top: -8px" /> Akun Saya </a>
							<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
								<a class="dropdown-item" href="${contextRoot}/userCartLines"><img src="${images}/cart.png" 
								style="width: 20px; height: 20px; margin-right: 5px" />
								${userCart.cartLines} - Rp. <fmt:formatNumber value="${userCart.grandTotal}" type="number" maxFractionDigits="0" /></a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="${contextRoot}/logout">Keluar</a>
							</div>
						</li>
					</c:when>
					
					<c:otherwise>
						<li class="nav-item"><a class="nav-link" href="${contextRoot}/login" id="login">Masuk</a></li>
		
						<li class="nav-item"><a class="nav-link" href="${contextRoot}/register" id="signUp">Daftar</a></li>
					</c:otherwise>
				</c:choose>
				
			</ul>
			
			<form action="${contextRoot}/product/search" method="GET" class="form-inline my-2 my-lg-0">
				<input type="text" name="keyWords" class="form-control mr-sm-2"  placeholder="Cari" />
				<button type="submit" class="btn btn-primary my-2 my-sm-0" style="background-color: orange">Cari</button>
			</form>
			
		</div>
	</div>
</nav>