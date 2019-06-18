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
<title>Admin</title>

<!-- Bootstrap core CSS -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="assets/css/shop-homepage.css" rel="stylesheet">

<style>
#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}

#tablecart {
	width: 100%;
	font-size: 26px;
	margin: 20px 0;
	text-align: center;
}

#Add_Product {
	font-size: 18px;
	margin:0;
	text-align: center;
}

#ttshop {
	font-size: 0.5em;
}

.bill {
	padding-top: 12px;
	width: 100%;
	height: 50px;
	margin: 20px 0;
	text-align: center;
}

#bill {
	font-size: 40px;
	float: right;
}

#billprice {
	font-size: 0.6em;
	color: red;
}

.btn-style-delete {
	border: solid 1px #ff0000;
	border-radius: 6px 20px 20px 6px;
	moz-border-radius: 6px 20px 20px 6px;
	-webkit-box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	-moz-box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	font-size: 12px;
	color: #ff0000;
	padding: 4px 13px;
	background: #31fa1e;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #31fa1e),
		color-stop(100%, #30ab00));
	background: -moz-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -webkit-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -o-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -ms-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#31fa1e',
		endColorstr='#30ab00', GradientType=0);
}

.btn-style-update {
	border: solid 1px #ff0000;
	border-radius: 6px;
	moz-border-radius: 6px;
	-webkit-box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	-moz-box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	font-size: 12px;
	color: #ff0000;
	padding: 4px 13px;
	background: #31fa1e;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #31fa1e),
		color-stop(100%, #30ab00));
	background: -moz-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -webkit-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -o-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -ms-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#31fa1e',
		endColorstr='#30ab00', GradientType=0);
}

.btn-style-add {
	border: solid 1px #ff0000;
	border-radius: 20px 6px 6px 20px;
	moz-border-radius: 20px 6px 6px 20px;
	-webkit-box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	-moz-box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	box-shadow: 0px 0px 1px rgba(0, 0, 0, 0.7);
	font-size: 12px;
	color: #ff0000;
	padding: 4px 13px;
	background: #31fa1e;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #31fa1e),
		color-stop(100%, #30ab00));
	background: -moz-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -webkit-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -o-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: -ms-linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	background: linear-gradient(top, #31fa1e 0%, #30ab00 100%);
	filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#31fa1e',
		endColorstr='#30ab00', GradientType=0);
}
</style>

</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="HomeController">MOCCAT</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="HomeController">Home <span class="sr-only">(current)</span>
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
				<!-- Product -->
				<div class="row">
					<h2 id="tablecart">
						Admin <small id="ttshop">ThanhTung Shop</small>
						<br>
						<HR>
						<a id="Add_Product" href="AdminAddProductController?itemID=">Add_Product</a>
					</h2>
					<br>

					<table id="customers">
						<tr>
							<th>Item ID</th>
							<th>Item Name</th>
							<th>Prices/Product</th>
							<th>ImagePath</th>
							<th>Detail</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						<!--${product.entrySet().stream().map(x -> 
					"-->
						<tr>
							<td>"+= x.getValue().getItemID() += "</td>
							<td>"+= x.getValue().getItemName() += "</td>
							<td>"+= x.getValue().getCost() += "</td>
							<td>"+= x.getValue().getImagePath() += "</td>
							<td>
								<FORM id='add' ACTION='ItemInfoController'>
									<INPUT TYPE='HIDDEN' NAME='itemID'
										VALUE='"+= x.getValue().getItemID() += "'> <SMALL>
										<INPUT TYPE='SUBMIT' class='btn-style-add' VALUE='DETAIL'>
									</SMALL>
								</FORM>
							</td>
							<td>
								<FORM id='edit' ACTION='AdminEditController'>
									<INPUT TYPE='HIDDEN' NAME='itemID'
										VALUE='"+= x.getValue().getItemID() += "'> <SMALL>
										<INPUT TYPE='SUBMIT' class='btn-style-update' VALUE='EDIT'>
									</SMALL>
								</FORM>
							</td>
							<td>
								<FORM id='delete' ACTION='AdminDeleteController'>
									<INPUT TYPE='HIDDEN' NAME='itemID'
										VALUE='"+= x.getValue().getItemID() += "'><INPUT
										TYPE='SUBMIT' class='btn-style-delete' VALUE='DELETE'>
								</FORM>
							</td>
						</tr>

						<!--").toList()}-->

					</table>

				</div>
			</div>
			<!-- /.col-lg-9 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.Content -->
	
	<br><br><br><br>

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


</body>
</html>