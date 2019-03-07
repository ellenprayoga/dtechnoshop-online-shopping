
<table class="table mt-3" style="width: 400px">
	<thead class="thead-light">
		<tr>
			<th width="15%">ID</th>
			<th width="50%">Kategori</th>
			<th width="20%">Aktif</th>	
			<th width="15%">Edit</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${allCategories}" var="category">
			<tr>
				<td>${category.id}</td>
				<td>${category.categoryName}</td>
				<td>
					<c:choose>
						<c:when test="${category.active == true}">
							Ya
						</c:when>
						
						<c:otherwise>
							Tidak
						</c:otherwise>
					</c:choose>
				</td> 
				<td>
					<button type="button" id="inactive_${category.id}" class="btn btn-warning" data-toggle="modal" 
						data-target="#inactiveModal_${category.id}" style="height: 40px; width: 40px">
						<img src="${images}/trash.png" alt="NO IMAGE" style="width: 20px; height: 20px;margin-top: -4px; margin-left: -3px"" />
					</button>
					
					<!-- Inactive category modal -->
					<div class="modal fade" id="inactiveModal_${category.id}" tabindex="-1" role="dialog" aria-labelledby="inactiveModalLabel" aria-hidden="true">
  						<div class="modal-dialog" role="document">
    						<div class="modal-content">
    						
      							<div class="modal-header">
        							<h5 class="modal-title" id="inactiveModalLabel">Aktif Kategori Produk</h5>
        							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          								<span aria-hidden="true">&times;</span>
        							</button>
      							</div>
      							
      							<form action="${contextRoot}/dataManagement/inactiveCategory" method="POST">	
      								<div class="modal-body">	
      									<input type="hidden" name="categoryId" value="${category.id}" />
      									<c:choose>
      										<c:when test="${category.active == true}">
      											Apakah Anda ingin menon-aktifkan kategori produk ini ?
      										</c:when>
      										
      										<c:otherwise>
      											Apakah Anda ingin meng-aktifkan kategori produk ini ?
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
      				
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<div style="overflow: hidden; width: 390px">
	<button type="button" class="btn btn-success" style="float: right" data-toggle="modal" data-target="#addCategoryModal">Tambah Kategori</button>
	
	<!-- Inactive product modal -->
	<div class="modal fade" id="addCategoryModal" tabindex="-1" role="dialog" aria-labelledby="addCategoryModalLabel" aria-hidden="true">
  		<div class="modal-dialog" role="document">
  			<div class="modal-content">
    			<div class="modal-header">
     				<h5 class="modal-title" id="addCategoryModalLabel">Aktif Produk</h5>
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
        				<span aria-hidden="true">&times;</span>
      				</button>
     			</div>
      						
      			<form action="${contextRoot}/dataManagement/addCategoryProduct" method="POST">	
      				<div class="modal-body">	
      					<div class="form-group row">
							<label for="categoryName" class="col-sm-3">Nama Kategori</label>
							<div class="col-sm-9">
								<input type="text" name="categoryName" class="form-control" placeholder="Nama Kategori" 
								aria-describedby="categoryName" />
							</div>
						</div>
      				</div>
      						
    				<div class="modal-footer">
     					<input type="submit" class="btn btn-primary" value="Tambah"/>
      				</div>
      			</form>
     		</div>
     	</div>
     </div>
</div>