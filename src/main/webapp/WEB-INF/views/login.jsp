<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/login/login.css" rel="stylesheet">
<link href="static/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">

<script type="text/javascript" src="static/js/jquery-1.9.1.min.js" ></script>
<script type="text/javascript" src="static/js/login/login.js" ></script>

<title>Login</title>
</head>
<body>
	<div class="container">
		<form id="login_form" class="form-signin" action="j_spring_security_check" method="post">
			<h2 class="form-signin-heading">Please sign in</h2>
			<input type="text" class="input-block-level" name="j_username" placeholder="Email address"> 
			<input type="password" class="input-block-level" name="j_password" placeholder="Password"> 
      <div id="login_failed" class="alert alert-error">Unable to log in. <br>Please check username and password.</div>
			<label class="checkbox"> <input type="checkbox" value="remember-me">
				Remember me
			</label>
			<button id="login_submit" class="btn btn-large btn-primary" type="submit">Sign in</button>
		</form>
	</div>
	<!-- /container -->
</body>
</html>