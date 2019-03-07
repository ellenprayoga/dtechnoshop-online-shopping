<div style="overflow: hidden">
	<!-- Refresh button -->
	<div style="float: left">
		<a href="${contextRoot}/dataManagement/manageDistribution" class="btn btn-success">Refresh</a>
	</div>
	
	<!-- Add new distribution button -->
	<div style="float: right">
		<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#addDistributionModal">Tambah Distribusi</button>

		<!-- Add new distribution modal -->
		<div class="modal fade" tabindex="-1" id="addDistributionModal"
			role="dialog" aria-labelledby="addDistributionModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="addDistributionModalLabel">Tambah Distribusi</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>

					<form action="${contextRoot}/dataManagement/addDistribution"
						method="POST">
						<div class="modal-body">

							<div class="form-group row">
								<label for="productId" class="col-sm-3">ID Produk</label>
								<div class="col-sm-9">
									<input type="text" name="productId" class="form-control" placeholder="ID Produk" />
								</div>
							</div>

							<div class="form-group row">
								<label for="quantity" class="col-sm-3">Jumlah</label>
								<div class="col-sm-9">
									<input type="number" name="quantity" class="form-control" style="width: 30%"/>
								</div>
							</div>
						</div>
						

						<div class="modal-footer">
							<input type="submit" class="btn btn-primary" value="Tambah" />
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<table class="table mt-3">
	<thead class="thead-light">
		<tr>
			<th width="5%">ID</th>
			<th width="40%">Nama Produk</th>
			<th width="10%">Jumlah</th>
			<th width="15%">Harga Beli</th>
			<th width="15%">Total</th>
			<th width="15%">Tanggal Distribusi</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${allDistributions}" var="distribution">
			<tr>
				<td>${distribution.id}</td>
				<td>${distribution.product.productName}</td>
				<td>${distribution.quantity}</td>
				<td>Rp. <fmt:setLocale value="in_ID" /> <fmt:formatNumber
						value="${distribution.price}" type="number" maxFractionDigits="0" /></td>
				<td>Rp. <fmt:formatNumber value="${distribution.total}"
						type="number" maxFractionDigits="0" /></td>
				<td><fmt:formatDate type="date" dateStyle="medium"
						value="${distribution.orderDate}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<c:if test="${allDistributions.size() == 0}">
	<h6 style="text-align: center">Distribusi kosong</h6>
</c:if>