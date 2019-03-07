<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<div class="jumbotron mt-5">
				<h2 style="color: #636363">Anda telah berhasil masuk ${user.name}, silahkan nikmati belanja di D'TechnoShop</h2>
				<br /><br />
				
				<h4 style="color: #636363">Kategori Produk</h4>
				<table class="table table-bordered col-sm-4">
					<tbody>
						<c:forEach items="${categoryList}" var="category">
							<tr>
								<td><a href="${contextRoot}/show/category/${category.id}/products" style="text-decoration: none">
								<img src="${images}/${category.categoryName}.png" alt="NO IMAGE" style="height: 30px; width: 30px"/> ${category.categoryName}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>