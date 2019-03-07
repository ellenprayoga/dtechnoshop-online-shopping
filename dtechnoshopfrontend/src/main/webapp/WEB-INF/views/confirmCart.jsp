<div class="container">
	<div class="row">
		<div class="col-sm-12">

			<div class="mt-5"
				style="border: 1px solid lightgray; overflow: hidden">
				<div style="border: 1px dashed lightgray; margin: 5px">
					<img src="${images}/info.png"
						style="float: left; height: 35px; width: 35px; margin: 5px 5px 0 5px" />
					<p style="font-size: 12px; margin-top: 5px">
						Pastikan kembali detil barang belanjaan Anda. Jika masih ada yang
						ingin diubah, silahkan klik tombol <span style="color: green">"Keranjang
							Belanja"</span>. Dan jika sudah yakin, lanjutkan dengan klik tombol <span
							style="color: green">"Bayar"</span> untuk menyelesaikan transaksi
						Anda.
					</p>
				</div>

				<div style="margin: 25px 5px 0 5px">
					<h5>Daftar Barang Belanjaan</h5>

					<div class="table-responsive">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th width="10%">Produk</th>
									<th width="50%">Nama Produk</th>
									<th width="10%">Jumlah</th>
									<th widht="15%">Harga</th>
									<th width="15%">Total</th>
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
										<td>${userCartLine.quantity}</td>
										<td><fmt:formatNumber value="${userCartLine.price}"
												type="number" maxFractionDigits="0" /></td>
										<td><fmt:formatNumber value="${userCartLine.total}"
												type="number" maxFractionDigits="0" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<div style="overflow: hidden">
						<p style="float: right; font-size: 20px">
							Total <b>Rp. <fmt:formatNumber value="${userCart.grandTotal}"
									type="number" maxFractionDigits="0" /></b>
						</p>
					</div>

					<div style="overflow: hidden; margin-bottom: 8px">
						<a href="${contextRoot}/payments" class="btn btn-success"
							style="float: right">Bayar</a> <a
							href="${contextRoot}/userCartLines" class="btn btn-secondary"
							style="float: right; margin-right: 5px">Keranjang Belanja</a>
					</div>
				</div>
			</div>


		</div>
	</div>
</div>