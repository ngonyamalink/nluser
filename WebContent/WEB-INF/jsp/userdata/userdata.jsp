<!DOCTYPE html>
<html lang="en">
<head>
<title>User data</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron text-xs-center">
		<h1 class="display-3">Welcome</h1>
		<p class="lead">
			<strong>Please use the key to gain access to apps: </strong>${authstring}</p>
		<hr>
		<p>Just copy and paste when you want to access apps.</p>
		<p class="lead">
			<a class="btn btn-primary btn-sm" href="http://localhost/nlink"
				role="button">Home Page</a> | <a class="btn btn-primary btn-sm" href="userprofile.html"
				role="button">My Profile</a>  | <a class="btn btn-primary btn-sm" href="logout.html"
				role="button">Log Out</a>
		</p>
	</div>
</body>
</html>