<div style="overflow: hidden">
	<div style="float: right">
		<form action="${contextRoot}/dataManagement/searchUser" method="GET">
			<input type="text" name="userId" class="form-control" placeholder="Cari" style="float: left; width: 250px; margin-right: 5px"/>
			<input type="submit" class="btn btn-secondary" value="Cari" style="float: left; background-color: orange; border: 1px solid orange"/>
		</form>
	</div>
</div>

<table class="table mt-3">
	<thead class="thead-light">
		<tr>
			<th width="5%">ID</th>
			<th width="15%">Nama</th>
			<th width="10%">Telp</th>
			<th width="45%">Alamat</th>
			<th width="15%">Email</th>
		</tr>
	</thead>
	
	<tbody>
		<c:forEach items="${allUsers}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.phoneNumber}</td>
				<td>${user.address}</td>
				<td>${user.email}</td>
			</tr>
		</c:forEach>
	</tbody>
	
</table>

<c:if test="${allUsers == null}">
	<h6 style="text-align: center">User yang Anda cari tidak ada</h6>
</c:if>