<div class="container">
	<div class="row">
		<div class="col-sm-12">

			<div class="mt-5">

				<h4 style="color: #636363" id="keranjang">Keranjang Belanja</h4>

				<div class="table-responsive">
					<table class="table mt-3">
						<thead class="thead-light">
							<tr>
								<th scope="col">Produk</th>
								<th scope="col">Nama Produk</th>
								<th scope="col">Jumlah</th>
								<th scope="col">Harga</th>
								<th scope="col">Total</th>
								<th scope="col">Edit</th>
							</tr>
						</thead>

						<tbody>
							<!-- Show every user cart lines -->
							<c:forEach items="${userCartLines}" var="userCartLine">
								<tr>
									<td><img
										src="${images}/${userCartLine.product.productCode}.jpg"
										alt="NO IMAGE" style="height: 100px; width: 100px" /></td>
									<td>${userCartLine.product.productName}</td>
									<td><input type="number" id="quantity_${userCartLine.id}"
										class="form-control" value="${userCartLine.quantity}" min="1"
										max="3" style="width: 80px" /></td>

									<!-- Format cart line price and total -->
									<td>Rp. <fmt:formatNumber value="${userCartLine.price}"
											type="number" maxFractionDigits="0" /></td>
									<td>Rp. <fmt:formatNumber value="${userCartLine.total}"
											type="number" maxFractionDigits="0" /></td>
									<td>
										<button type="button" id="refCart_${userCartLine.id}"
											class="btn btn-primary" data-toggle="modal"
											data-target="#refreshCartModal"
											style="height: 35px; width: 50px">
											<img src="${images}/synchronize.png" alt="NO IMAGE"
												style="width: 20px; height: 20px" />
										</button>
										<button type="button" id="remCart_${userCartLine.id}"
											class="btn btn-warning" value="${userCartLine.id}"
											style="height: 35px; width: 50px">
											<img src="${images}/trash.png" alt="NO IMAGE"
												style="width: 20px; height: 20px" />
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<!-- Check if cart lines are empty or not -->
				<c:choose>
					<c:when test="${userCart.cartLines != 0}">
						<div style="float: right">
							<a href="${contextRoot}/confirmUserCartLines"
								class="btn btn-success btn-block">Konfirmasi</a>
						</div>
					</c:when>

					<c:otherwise>
						<h6 style="color: gray; text-align: center">Keranjang Anda
							Kosong</h6>
					</c:otherwise>
				</c:choose>
			</div>

		</div>
	</div>
</div>