<div class="container">
	<div class="row">
		<div class="col-sm-8 offset-sm-2">
		
			<div class="card mt-5">
				
				<div class="card-body">
					<h4 class="card-title text-center font-weight-bold">Login</h4>
					<div class="card-subtitle text-muted text-center"><small>Silahkan masukkan akun Anda</small></div>
					<hr class="mt-4 mb-4"/>
				
					<form:form action="${contextRoot}/login" method="POST" modelAttribute="userLogin">
						
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
						
						<div class="form-group">
							<div class="offset-sm-3 col-sm-5">
								<button type="submit" class="btn btn-success btn-block">Masuk</button>
							</div>
						</div>
					</form:form>
				</div> 
			</div>
				
		</div>
	</div>
</div>