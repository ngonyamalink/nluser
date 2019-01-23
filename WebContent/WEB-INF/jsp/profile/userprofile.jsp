<!DOCTYPE html>
<html lang="en">
<head>
  <title>Profile</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>


<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<head>
<title>Profile</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<hr>
<div class="container bootstrap snippet">
	<div class="row">
		<div class="col-sm-10">
			<h1>${member.member_name}</h1>
		</div>
		<div class="col-sm-2">
			<a href="userdata.html?authstring=${member.authstring}" class="pull-right">Access Key</a>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3">
			<!--left col-->


			<div class="text-center">
				<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
					class="avatar img-circle img-thumbnail" alt="avatar">
				<h6>Upload a different photo...</h6>
				<input type="file" class="text-center center-block file-upload">
			</div>
			</hr>
			<br>
  
		</div>
		<!--/col-3-->
		<div class="col-sm-9">
		 

			<div class="tab-content">
				<div class="tab-pane active" id="home">
					<hr>
					<form class="form" action="updateprofile.html" method="post" id="profile">
						<div class="form-group">

							<div class="col-xs-6">
								<label for="first_name"><h4>First name</h4></label> <input
									type="text" class="form-control" name="member_name"
									id="first_name" placeholder="first name"
									title="enter your first name if any."
									value="${member.member_name}">
							</div>
						</div>
						<div class="form-group">

							<div class="col-xs-6">
								<label for="last_name"><h4>Last name</h4></label> <input
									type="text" class="form-control" name="member_surname"
									id="last_name" placeholder="Surname"
									title="enter your last name if any."
									value="${member.member_surname}">
							</div>
						</div>

						<div class="form-group">

							<div class="col-xs-6">
								<label for="phone"><h4>Date of birth</h4></label> <input type="text"
									class="form-control" name="member_dob" id="member_dob"
									placeholder="enter date of birth"
									title="enter your date of birth."
									value="${member.member_dob}">
							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-6">
								<label for="mobile"><h4>Gender</h4></label> <input type="text"
									class="form-control" name="member_gender" id="member_gender"
									placeholder="Gender"
									title="enter your gender."
									value="${member.member_gender}">
							</div>
						</div>

						<div class="form-group">

							<div class="col-xs-6">
								<label for="email"><h4>Province</h4></label> <input type="text"
									class="form-control" id="member_province_id" name="member_province_id"
									placeholder="somewhere" title="enter a province"
									value="${member.member_province_id}">
							</div>
						</div>

						<div class="form-group">

							<div class="col-xs-6">
								<label for="email"><h4>Contact number</h4></label> <input name="member_contact_no"
									type="text" class="form-control" id="member_contact_no"
									placeholder="somewhere" title="contact number"
									value="${member.member_contact_no}">
							</div>
						</div>


						<div class="form-group">

							<div class="col-xs-6">
								<label for="email"><h4>Email</h4></label> <input type="email"
									class="form-control" name="member_email" id="email"
									placeholder="you@email.com" title="enter your email."
									value="${member.member_email}">
							</div>
						</div>

						<div class="form-group">

							<div class="col-xs-6">
								<label for="password"><h4>Password</h4></label> <input
									type="password" class="form-control" name="member_password"
									id="password" placeholder="password"
									title="enter your password." value="${member.member_password}">
							</div>
						</div>
						<div class="form-group">

						</div>
						<div class="form-group">
							<div class="col-xs-12">
								<br>
								<button class="btn btn-lg btn-success" type="submit">
									<i class="glyphicon glyphicon-ok-sign"></i> Save
								</button>
						 
							</div>
						</div>
					</form>

					<hr>

				</div>
				 
	</div>
	<!--/col-9-->
</div>
<!--/row-->


    </body>
</html>