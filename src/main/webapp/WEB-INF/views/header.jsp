<%@ page language="java" contentType="text/html;"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
	<style>
      body {
        padding-top: 40px; /* 40px to make the container go all the way to the bottom of the topbar */
      }
      ul.nav li.dropdown:hover ul.dropdown-menu{
	    display: block;    
	}

	a.menu:after, .dropdown-toggle:after {
	  content: none;
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
             <ul class="nav pull-right">
             <li class="dropdown">
			<a class="dropdown-toggle" href="#" class="navbar-link"> Logged in as <sec:authentication property="principal.username"/> </a>              	
              <ul class="dropdown-menu">
	                <li><a href="#"><sec:authentication property="principal.name"/></a> <sec:authentication property="principal.lastName"/></li>
	                <li><a href="#"><sec:authentication property="principal.email"/></a></li>
	                <li class="divider"></li>
	                <li><a href="/j_spring_logout">Logout</a></li>
              </ul>
            </li>
          </ul>
            <ul class="dropdown-menu">
				<li><a href="#">Secondary link</a></li>
				<li><a href="#">Something else here</a></li>
				<li class="divider"></li>
				<li><a href="#">Another link</a></li>
			</ul>
		</div>
	</div>
</div>
</html>