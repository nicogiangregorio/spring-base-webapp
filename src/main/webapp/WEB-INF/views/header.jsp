<%@ page language="java" contentType="text/html;"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<style>
      body {
        padding-top: 40px; /* 40px to make the container go all the way to the bottom of the topbar */
      }
    </style>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
			<span class="icon-bar"></span> <span class="icon-bar"></span> 
			<span class="icon-bar"></span>
		</button>
		<a class="brand" href="#">Project name</a>
		<div class="nav-collapse collapse">
			<ul class="nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
				<sec:authorize ifAllGranted="admin">
					<li><a href="#admin">Admin</a></li>
				</sec:authorize>
			</ul>
			<p class="navbar-text pull-right">
              Logged in as <a href="#" class="navbar-link"><sec:authentication property="principal.username"/> </a>
            </p>
		</div>
	</div>
</div>
</html>