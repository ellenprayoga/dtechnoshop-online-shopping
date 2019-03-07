<!-- Navbar -->
<nav
	class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary fixed-top pt-3 pb-3">

	<div class="container-fluid">
		<h3><a href="${contextRoot}/dataManagement/home" style="color: white; text-decoration: none; margin-right: 10px">D'TechnoShop</a></h3>

		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarResponsive">

			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/dataManagement/manageProduct" id="manageProduct">Manajemen Produk</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/dataManagement/manageCategoryProduct" id="manageCategoryProduct">Manajemen Kategori Produk</a></li>
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/dataManagement/manageUser" id="manageUser">Manajemen User</a></li>
				<%-- <li class="nav-item"><a class="nav-link" href="${contextRoot}/dataManagement/manageCartLines" id="manageCartLines">Manajemen Pesanan</a></li> --%>
				
				<li class="nav-item dropdown">
					<a id="manageCartLines" class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Manajemen Pesanan
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownPortfolio">
						<a class="dropdown-item" href="${contextRoot}/dataManagement/manageCartLines/order">Daftar Pesan</a>
						<a class="dropdown-item" href="${contextRoot}/dataManagement/manageCartLines/paid">Daftar Bayar</a>
						<a class="dropdown-item" href="${contextRoot}/dataManagement/manageCartLines/shipped">Daftar Kirim</a>
					</div>
				</li>
				
				<li class="nav-item"><a class="nav-link" href="${contextRoot}/dataManagement/manageDistribution" id="manageDistribution">Manajemen Distribusi</a></li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="userAccount" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<img src="${images}/user-filled.png" style="width: 20px; height: 20px; margin-top: -8px"/> Akun Saya
					</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownPortfolio">
						<a class="dropdown-item" href="${contextRoot}/dataManagement/adminLogout">Keluar</a>
					</div>
				</li>
			</ul>
			
			<%-- <div class="dropdown">
				<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<img src="${images}/user-filled.png" style="width: 20px; height: 20px; margin-top: -8px"/> Akun Saya
				</button>
				
				<div class="dropdown-menu dropdown-menu-right">
					<a class="dropdown-item" href="${contextRoot}/dataManagement/logout">Keluar</a>
				</div>
			</div> --%>
			
			<!-- <div style="margin-left: 1000px">
				<button type="button" class="btn btn-primary">Keluar</button>
			</div> -->
		</div>
	</div>
</nav>