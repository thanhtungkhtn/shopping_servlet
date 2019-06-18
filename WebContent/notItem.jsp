<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="cart" scope="application"
	class="org.thanhtung.shop.moccat.CartBean" />
<jsp:setProperty name="cart" property="*" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Your Cart</title>

<!-- Bootstrap core CSS -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="assets/css/shop-homepage.css" rel="stylesheet">
<style>
h2 {
  font-size: 30px;
  margin: 20px 0;
  text-align: center;
  color: red;
}
</style>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="HomeController">MOCCAT Shop</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="HomeController">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Services</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-lg-3">

				<h1 class="my-4">MVC JSP</h1>
				<div class="list-group">
					<a class="list-group-item" href="yourCart">View Cart</a> <a
						href="HomeController" class="list-group-item">All Products</a> <a
						href="#" class="list-group-item">Category 1</a> <a href="#"
						class="list-group-item">Category 2</a> <a href="#"
						class="list-group-item">Category 3</a>
						<a href="Admin"
						class="list-group-item">Admin</a>
						
				</div>

			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">
				<!-- Product -->
				<div class="row">
					<h2>No items in your cart...!!! </h2>
				</div>
			</div>
			<!-- /.col-lg-9 -->		
		</div>
		<!-- /.row -->
	</div>
<!-- /.Content -->


	<!-- Bootstrap core JavaScript -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


</body>
</html>