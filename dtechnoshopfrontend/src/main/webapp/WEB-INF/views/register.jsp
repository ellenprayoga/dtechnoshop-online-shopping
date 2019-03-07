<div class="container">
	<div class="row">
		<div class="col-sm-8 offset-sm-2">
		
			<div class="card mt-5">
				
				<div class="card-body">
					<h4 class="card-title text-center font-weight-bold">Sign Up</h4>
					<div class="card-subtitle text-muted text-center"><small>Silahkan isi formulir tentang diri Anda dibawah ini</small></div>
					<hr class="mt-4 mb-4"/>
				
					<form:form action="${contextRoot}/register" method="POST" modelAttribute="user">
						<div class="form-group row">
							<label for="name" class="col-sm-3">Nama Lengkap</label>
							<div class="col-sm-9">
								<form:input path="name" class="form-control" id="name" placeholder="Nama Lengkap" maxlength="30" />
								<form:errors path="name" cssClass="customErrors" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="phoneNumber" class="col-sm-3">Nomor HP</label>
							<div class="col-sm-9">
								<form:input path="phoneNumber" class="form-control" id="phoneNumber" placeholder="Nomor HP" aria-describedby="phoneCode" maxlength="12" />
								<form:errors path="phoneNumber" cssClass="customErrors" element="em" />
							</div>
						</div>
						
						<hr class="mt-4 mb-4"/>
						
						<div class="form-group row">
							<label for="specificAddress" class="col-sm-3">Alamat Lengkap</label>
							<div class="col-sm-9">
								<form:input path="specificAddress" class="form-control" id="specificAddress" placeholder="Alamat Lengkap" maxlength="150" />
								<form:errors path="specificAddress" cssClass="customErrors" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="province" class="col-sm-3">Provinsi</label>
							<div class="col-sm-9">
								
								<form:select path="province" class="form-control" id="province">
									<form:option value="" label="- Pilih Provinsi" />
								</form:select>
							
								<form:errors path="province" cssClass="customErrors" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="city" class="col-sm-3">Kota</label>
							<div class="col-sm-9">
								
								<form:select path="city" class="form-control" id="city">
									<form:option value="" label="- Pilih Kota" />
								</form:select>
								
								<form:errors path="city" cssClass="customErrors" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="subdistrict" class="col-sm-3">Kecamatan</label>
							<div class="col-sm-9">
								
								<form:select path="subdistrict" class="form-control" id="subdistrict">
									<form:option value="" label="- Pilih Kecamatan" />
								</form:select>
								
								<form:errors path="subdistrict" cssClass="customErrors" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="postalCode" class="col-sm-3">Kode Pos</label>
							<div class="col-sm-9">
								<form:input path="postalCode" class="form-control" id="postalCode" placeholder="Kode Pos" maxlength="5" />
								<form:errors path="postalCode" cssClass="customErrors" element="em" />
							</div>
						</div>
						
						<hr class="mt-4 mb-4"/>
						
						<div class="form-group row">
							<label for="email" class="col-sm-3">Email</label>
							<div class="col-sm-9">
								<form:input path="email" class="form-control" id="email" placeholder="Email" maxlength="50" />
								<form:errors path="email" cssClass="customErrors" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="password" class="col-sm-3">Password</label>
							<div class="col-sm-9">
								<form:password path="password" class="form-control" id="password" placeholder="Password" maxlength="30" />
								<form:errors path="password" cssClass="customErrors" element="em" />
							</div>
						</div>
						
						<div class="form-group row">
							<label for="validatePassword" class="col-sm-3">Ulangi Password</label>
							<div class="col-sm-9">
								<form:password path="validatePassword" class="form-control" id="validatePassword" placeholder="Ulangi Password" maxlength="30" />
								<form:errors path="validatePassword" cssClass="customErrors" element="em" />
							</div>
						</div>
						
						<hr class="mt-4 mb-4"/>
						
						<div class="form-check mb-4">
							<div class="col-sm-12">
								<div class="row">
									<form:checkbox path="agreement" class="form-check-input" id="agreement" />
									<label class="form-check-label" for="agreement"><small>Saya sudah membaca dan menyetujui Syarat dan Ketentuan serta 
									Kebijakan Privasi dari D'Technoshop</small></label>
								</div>
								<div class="row">
									<form:errors path="agreement" cssClass="customErrors" element="em" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="offset-sm-3 col-sm-5">
								<button type="submit" class="btn btn-success btn-block">Selanjutnya</button>
								<form:hidden path="role" value="USER" />
							</div>
						</div>
					</form:form>
				</div> 
			</div>
				
		</div>
	</div>
</div>