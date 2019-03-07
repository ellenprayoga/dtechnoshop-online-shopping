<div class="list-group pt-5">
	<div class="list-group-item" style="background-color: orange">
		<h5 class="text-white">Kategori</h5>
	</div>
	
	<c:forEach items="${categoryList}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="ct${category.categoryName}">
			${category.categoryName}
		</a>
	</c:forEach>
</div>