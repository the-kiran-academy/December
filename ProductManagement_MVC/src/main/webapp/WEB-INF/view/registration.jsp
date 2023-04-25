<jsp:include page="menu.jsp" />
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="/css/reg.css">

<title>Add User</title>
</head>
<body>
	<form action="adduser" method="post">

		<div class="container register">
			<div class="row">
				<div class="col-md-3 register-left">
					<img src="/images/logo.png" alt="" />
					<h3>Welcome</h3>
					<p>You are 30 seconds away from earning your own money!</p>
				</div>
				<div class="col-md-9 register-right">

					<div class="tab-content" id="myTabContent">
						<div class="tab-pane fade show active" id="home" role="tabpanel"
							aria-labelledby="home-tab">
							<h3 class="register-heading">Add User</h3>
							<h3 style="color: red;">${msg}</h3>
							
							<div class="row register-form">
								<div class="col-md-6">
									<div class="form-group">
										<input name="username" type="text" class="form-control"
											placeholder="User Name*" value="" />
									</div>
									<div class="form-group">
										<input name="firstName" type="text" class="form-control"
											placeholder="First Name *" value="" />
									</div>
									<div class="form-group">
										<input name="lastName" type="text" class="form-control"
											placeholder="Last Name *" value="" />
									</div>
									<div class="form-group">
										<input name="password" type="password" class="form-control"
											placeholder="Password *" value="" />
									</div>

									<div class="form-group">
										<div class="maxl">
											<label class="radio inline"> <input type="radio"
												name="gender" value="male" checked> <span>
													Male </span>
											</label> <label class="radio inline"> <input type="radio"
												name="gender" value="female"> <span>Female </span>
											</label>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<input name="email" type="email" class="form-control"
											placeholder="Your Email *" value="" />
									</div>
									<div class="form-group">
										<input type="text" minlength="10" maxlength="10" name="phone"
											class="form-control" placeholder="Your Phone *" value="" />
									</div>
									<div class="form-group">
										<select class="form-control" name="question">
											<option class="hidden" selected disabled>Please
												select your Sequrity Question</option>
											<option>What is your Birthdate?</option>
											<option>What is Your old Phone Number</option>
											<option>What is your Pet Name?</option>
										</select>
									</div>
									<div class="form-group">
										<input name="answer" type="text" class="form-control"
											placeholder="Enter Your Answer *" value="" />
									</div>
									<div class="form-group">
										<select class="form-control" name="role">
											<option value="Admin">Admin</option>
											<option value="User">User</option>
										</select>
									</div>
									<input type="submit" class="btnRegister" value="ADD USER" />
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

		</div>

	</form>
</body>
</html>
<jsp:include page="footer.jsp" />