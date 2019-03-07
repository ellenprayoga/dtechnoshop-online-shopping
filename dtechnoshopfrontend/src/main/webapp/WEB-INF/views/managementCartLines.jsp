<div style="overflow: hidden">
	<!-- Refresh table -->
	<div style="float: left">
		<a href="${contextRoot}/dataManagement/manageCartLines/${cartLineStatus}" class="btn btn-success">Refresh</a>
	</div>
	
	<!-- Search date -->
	<div style="float: right">
		<form action="${contextRoot}/dataManagement/searchCartLine" method="GET">
			<input type="text" name="key" id="searchData" class="form-control" placeholder="Cari" style="float: left; width: 250px; margin-right: 8px"/>
			<input type="submit" id="searchBtn" class="btn btn-secondary" style="float: left; background-color: orange; border: 1px solid orange" value="Cari" />
		</form>
	</div>
</div>

<table class="table mt-3">
	<thead class="thead-light">
		<tr>
			<th width="7%">ID Pesan</th>
			<th width="7%">ID Cstmr</th>
			<th width="26%">Nama Produk</th>
			<th width="14%">Harga</th>
			<th width="8%">Jumlah</th>
			<th width="14%">Total</th>
			<th width="11%">Tanggal Pesan</th>
			<th widht="8%">Status</th>
			<th width="5%">Edit </th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${allCartLines}" var="cartLine">
			<tr>
				<td>${cartLine.id}</td>
				<td>${cartLine.cartId}</td>
				<td>${cartLine.product.productName}</td>
				<td>
					<fmt:setLocale value="in_ID" />
					Rp. <fmt:formatNumber value="${cartLine.price}" type="number" maxFractionDigits="0" />
				</td>
				<td>${cartLine.quantity}</td>
				<td>Rp. <fmt:formatNumber value="${cartLine.total}" type="number" maxFractionDigits="0" /></td>
				<td><fmt:formatDate type="date" dateStyle="medium" value="${cartLine.orderDate}" /></td>
				<td>${cartLine.status}</td>
				<td>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#updateModal_${cartLine.id}" style="height: 40px; width: 40px">
						<img src="${images}/synchronize.png" alt="NO IMAGE" style="width: 20px; height: 20px; margin-top: -4px; margin-left: -3px" />	
					</button>
				</td>
				
				<!-- Update product modal -->
				<div class="modal fade" id="updateModal_${cartLine.id}" tabindex="-1" role="dialog" aria-labelledby="refreshModalLabel" aria-hidden="true">
  					<div class="modal-dialog" role="document">
    					<div class="modal-content">
      						<div class="modal-header">
        						<h5 class="modal-title" id="refreshModalLabel">Ubah Status Pesanan</h5>
        						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          							<span aria-hidden="true">&times;</span>
        						</button>
      						</div>
      						
      						<form action="${contextRoot}/dataManagement/updateCartLine" method="POST">	
      							<div class="modal-body">
									
									<div class="form-group row">
										<label for="status" class="col-sm-3">Status</label>
										<div class="col-sm-9">
											<select name="status" class="form-control" aria-describedby="status">
												<option value="ORDER">ORDER</option>
												<option value="PAID">PAID</option>
												<option value="SHIPPED">SHIPPED</otpion>
											</select>
										</div>
									</div>
									
									<input type="hidden" name="cartLineId" value="${cartLine.id}" />
      							</div>
      						
      							<div class="modal-footer">
        							<input type="submit" class="btn btn-primary" value="Ubah" />
      							</div>
      						
      						</form>
    					</div>
  					</div>
				</div>
				
				
			</tr>
		</c:forEach>
	</tbody>
	
</table>

<c:if test="${allCartLines == null}">
	<h6 style="text-align: center; color: gray">Detil pesanan yang Anda cari tidak ada</h6>
</c:if>