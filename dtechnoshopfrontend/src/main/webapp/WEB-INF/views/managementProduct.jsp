<div style="overflow: hidden">
	<div style="float: left">
		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#addProductModal">Tambah Produk</button>
		
		<!-- Add product modal -->
		<div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="addProductModalLabel" aria-hidden="true">
  			<div class="modal-dialog" role="document">
    			<div class="modal-content">
      				<div class="modal-header">
       					<h5 class="modal-title" id="addProductModalLabel">Tambah Produk</h5>
      					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
         					<span aria-hidden="true">&times;</span>
        				</button>
      				</div>
      						
      				<form:form action="${contextRoot}/dataManagement/addProduct" method="POST" modelAttribute="product" 
      					enctype="multipart/form-data">	
      					<div class="modal-body">
        						
							<div class="form-group row">
								<label for="productName" class="col-sm-3">Nama</label>
								<div class="col-sm-9">
									<form:input path="productName" class="form-control" placeholder="Nama Produk" 
									aria-describedby="productName" />
								</div>
							</div>
									
							<div class="form-group row">
								<label for="unitPrice" class="col-sm-3">Harga Beli</label>
								<div class="col-sm-9">
									<form:input path="unitPrice" class="form-control" placeholder="Harga Beli" 
									aria-describedby="unitPrice" />
								</div>
							</div>
									
							<div class="form-group row">
								<label for="msrp" class="col-sm-3">Harga Jual</label>
								<div class="col-sm-9">
									<form:input path="msrp" class="form-control" placeholder="Harga Jual" 
									aria-describedby="msrp" />
								</div>
							</div>
									
							<div class="form-group row">
								<label for="categoryId" class="col-sm-3">ID Kategori</label>
								<div class="col-sm-9">
									<form:input path="categoryId" class="form-control" placeholder="ID Kategori" 
									aria-describedby="categoryId" />
								</div>
							</div>
							
							<div class="form-group row">
								<label for="image" class="col-sm-3">Pilih Gambar</label>
								<div class="col-sm-9">
									<form:input type="file" path="file" class="form-control" placeholder="Pilih Gambar" 
									aria-describedby="image" />
								</div>
							</div>
									
							<div class="form-group row">
								<label for="description" class="col-sm-3">Deskripsi</label>
								<div class="col-sm-9">
									<form:textarea path="description" class="form-control" placeholder="Deskripsi" 
									aria-describedby="description" rows="3"></form:textarea>
								</div>
							</div>
							
							<form:input type="hidden" path="quantity" value="0" />
							<form:input type="hidden" path="active" value="true" />
      					</div>
      						
     					<div class="modal-footer">
        					<input type="submit" class="btn btn-primary" value="Tambah" />
      					</div>
      						
      				</form:form>
    			</div>
  			</div>
		</div>
	</div>
	
	<div style="float: right">
		<form action="${contextRoot}/dataManagement/searchProduct" method="GET">
			<input type="text" name="key" id="searchData" class="form-control" placeholder="Cari" style="float: left; width: 250px; margin-right: 8px"/>
			<input type="submit" id="searchBtn" class="btn btn-secondary" style="float: left; background-color: orange; border: 1px solid orange" value="Cari" />
		</form>
	</div>
</div>

<table id="productTable" class="table mt-4">
	<thead class="thead-light">
		<tr>
			<th width="3%">ID</th>
			<th width="10%">Produk</th>
			<th width="27%">Nama</th>
			<th width="10%">Kode</th>
			<th width="6%">Jumlah</th>
			<th width="12%">Harga Jual</th>
			<th width="12%">Harga Beli</th>
			<th width="5%">Kategori</th>
			<th width="5%">Aktif</th>
			<th width="20%">Edit</th>
		</tr>
	</thead>
	
	<tbody id="tbody">
		<c:forEach items="${allProducts}" var="product">
			<tr>
				<td>${product.id}</td>
				<td><img src="${images}/${product.productCode}.jpg" alt="NO IMAGE" style="height: 100px; width: 100px" /></td>
				<td>${product.productName}</td>
				<td>${product.productCode}</td>
				<td>${product.quantity}</td>
				<td>Rp. <fmt:formatNumber value="${product.unitPrice}" type="number" maxFractionDigits="0" /></td>
				<td>Rp. <fmt:formatNumber value="${product.msrp}" type="number" maxFractionDigits="0" /></td>
				<td>${product.categoryId}</td>
				<td>
					<c:choose>
						<c:when test="${product.active == true}">
							Ya
						</c:when>
						
						<c:otherwise>
							Tidak
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#updateModal_${product.id}" style="height: 40px; width: 40px">
						<img src="${images}/synchronize.png" alt="NO IMAGE" style="width: 20px; height: 20px; margin-top: -4px; margin-left: -3px" />	
					</button>
					
					<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#inactiveModal_${product.id}" style="height: 40px; width: 40px">
						<img src="${images}/trash.png" alt="NO IMAGE" style="width: 20px; height: 20px;margin-top: -4px; margin-left: -3px"" />
					</button>
				</td>
				
				
				<!-- Update product modal -->
				<div class="modal fade" id="updateModal_${product.id}" tabindex="-1" role="dialog" aria-labelledby="refreshModalLabel" aria-hidden="true">
  					<div class="modal-dialog" role="document">
    					<div class="modal-content">
      						<div class="modal-header">
        						<h5 class="modal-title" id="refreshModalLabel">Ubah Data Produk</h5>
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          							<span aria-hidden="true">&times;</span>
        						</button>
      						</div>
      						
      						<form action="${contextRoot}/dataManagement/updateProduct" method="POST">	
      							<div class="modal-body">
									
									<div class="form-group row">
										<label for="productName" class="col-sm-3">Nama</label>
										<div class="col-sm-9">
											<input type="text" name="productName" class="form-control" id="productName_${product.id}" placeholder="Nama Produk" 
											aria-describedby="productName" value="${product.productName}"/>
										</div>
									</div>
									
									<div class="form-group row">
										<label for="categoryId" class="col-sm-3">ID Kategori</label>
										<div class="col-sm-9">
											<input type="text" name="categoryId" class="form-control" id="categoryId_${product.id}" placeholder="ID Kategori" 
											aria-describedby="categoryId" value="${product.categoryId}"/>
										</div>
									</div>
									
									<div class="form-group row">
										<label for="unitPrice" class="col-sm-3">Harga Beli</label>
										<div class="col-sm-9">
											<input type="text" name="unitPrice" class="form-control" id="unitPrice_${product.id}" placeholder="Harga Beli" 
											aria-describedby="unitPrice" 
											value=<fmt:formatNumber type="number" groupingUsed="false" 
											maxFractionDigits="0" value="${product.unitPrice}" /> />
										</div>
									</div>
									
									<div class="form-group row">
										<label for="msrp" class="col-sm-3">Harga Jual</label>
										<div class="col-sm-9">
											<input type="text" name="msrp" class="form-control" id="msrp_${product.id}" placeholder="Harga Jual" 
											aria-describedby="msrp" value=<fmt:formatNumber type="number" groupingUsed="false" maxFractionDigits="0" 
											value="${product.msrp}" /> />
										</div>
									</div>
									
									<input type="hidden" name="productId" value="${product.id}" />
									
									<div class="form-group row">
										<label for="description" class="col-sm-3">Deskripsi</label>
										<div class="col-sm-9">
											<textarea name="description" class="form-control" id="description_${product.id}" placeholder="Deskripsi" 
											aria-describedby="description" rows="3">${product.description}</textarea>
										</div>
									</div>
      							</div>
      						
      							<div class="modal-footer">
        							<%-- <button type="button" class="btn btn-primary" id="update_${product.id}">Ubah</button> --%>
        							<input type="submit" class="btn btn-primary" value="Ubah" />
      							</div>
      						
      						</form>
    					</div>
  					</div>
				</div>
				
				
				<!-- Inactive product modal -->
				<div class="modal fade" id="inactiveModal_${product.id}" tabindex="-1" role="dialog" aria-labelledby="inactiveModalLabel" aria-hidden="true">
  					<div class="modal-dialog" role="document">
    					<div class="modal-content">
      						<div class="modal-header">
        						<h5 class="modal-title" id="inactiveModalLabel">Aktif Produk</h5>
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          							<span aria-hidden="true">&times;</span>
        						</button>
      						</div>
      						
      						<form action="${contextRoot}/dataManagement/inactiveProduct" method="POST">	
      							<div class="modal-body">	
      								<input type="hidden" name="productId" value="${product.id}" />
      								<c:choose>
      									<c:when test="${product.active == true}">
      										Apakah Anda ingin menon-aktifkan produk ini ?
      									</c:when>
      									
      									<c:otherwise>
      										Apakah Anda ingin meng-aktifkan produk ini ?
      									</c:otherwise>
      								</c:choose>
      							</div>
      						
      							<div class="modal-footer">
        							<input type="submit" class="btn btn-primary" value="Ya" style="margin-right: 5px"/>
        							<button type="button" class="btn btn-secondary" data-dismiss="modal" aria-label="Close">
          								Tidak
        							</button>
      							</div>
      						</form>
      					</div>
      				</div>
      			</div>
				
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${allProducts.size() == 0}">
	<h6 style="text-align: center">Produk yang Anda cari tidak ada</h6>
</c:if>