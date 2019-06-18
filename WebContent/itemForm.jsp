<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@  page import="org.thanhtung.shop.moccat.*"%>
<%@  page import="java.io.IOException"%>
<%@  page import="java.io.PrintWriter"%>
<%@  page import="java.util.*"%>

<jsp:useBean id="data" scope="request"
	class="org.thanhtung.shop.moccat.ItemListImpl" />
<jsp:setProperty name="data" property="*" />

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>MOCCAT - Shop Homepage JSP</title>

<!-- Bootstrap core CSS -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<link href="assets/css/shop-homepage.css" rel="stylesheet">

<style>
#add {
	float: right;
	display: inline;
}

#star {
	width: 50px;
}

.btn-style {
	border: solid 0px #ffabff;
	border-radius: 20px 0px 20px 0px;
	moz-border-radius: 20px 0px 20px 0px;
	-webkit-box-shadow: 3px 3px 5px rgba(58, 176, 162, 0.7);
	-moz-box-shadow: 3px 3px 5px rgba(58, 176, 162, 0.7);
	box-shadow: 3px 3px 5px rgba(58, 176, 162, 0.7);
	font-size: 20px;
	color: #8241d1;
	padding: 1px 20px;
	background-color: #2bdde3;
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
						class="list-group-item">Category 3</a> <a href="Admin"
						class="list-group-item">Admin</a>

				</div>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div class="management">
					<h2>Item Form</h2>
				</div>

				<!-- Product -->
				<div class="row">

					<div class="container-fluid mt-3">
						<form id="add" action="AdminAddProductController">
							<div class="form-row">
								<div class="form-group col-sm-6">
									<label for="Item_ID">Item_ID</label> <input type="text"
										class="form-control" id="Item_ID" name="itemID" placeholder="Item_ID">
								</div>
								<div class="form-group col-sm-6">
									<label for="Item_Name">Item_Name</label> <input type="text"
										class="form-control" id="Item_Name" name="itemName" placeholder="Item_Name">
								</div>
							</div>
							<div class="form-group">
								<label for="file">Image</label> <input type="file"
									class="form-control" id="Image_Path" name="imagePath" placeholder="Images">
							</div>
							<div class="form-group">
								<label for="Prices">Prices</label> <input type="text"
									class="form-control" id="Prices" name="price" placeholder="Prices">
							</div>
							<div class="form-row">
								<div class="form-group col-sm-6">
									<label for="Category">Category</label> <select id="Category"
										class="form-control">
										<option selected>Choose...</option>
										<option>Giay</option>
										<option>Book</option>
										<option>Phone</option>
									</select>
								</div>

							</div>
							<div class="form-group">
								<div class="form-check">
									<input class="form-check-input" type="checkbox" id="myCheck">
									<label class="form-check-label" for="myCheck"> Check me
										out </label>
								</div>
							</div>
							<button type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>

				</div>
				<!-- /.col-lg-9 -->

			</div>
			<!-- /.row -->

		</div>
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

</body>
</html>