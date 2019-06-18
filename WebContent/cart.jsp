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
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}

#tablecart {
  font-size: 26px;
  margin: 20px 0;
  text-align: center;
}
#ttshop {
    font-size: 0.5em;
  }
  .bill{
  padding-top: 12px;
  width:100%;
  height: 50px;  
  margin: 20px 0;
  text-align: center;
  }
   #bill{
   	font-size: 40px;
   	float:right;
   }
   #billprice{
   font-size: 0.6em;
   color: red;
   }
  
.btn-style-delete{
border : solid 1px #ff001a;
	border-radius : 6px;
	moz-border-radius : 6px;
	font-size : 13px;
	color : #f04d0c;
	padding : 3px 3px;
	background-color : #81eb1e;

}
.btn-style-update{
	display: inline;
	border : solid 1px #ff001a;
	border-radius : 6px;
	moz-border-radius : 6px;
	font-size : 13px;
	color : #f04d0c;
	padding : 3px 3px;
	background-color : #81eb1e;

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
					<h2 id="tablecart">Your Cart <small id="ttshop">ThanhTung Shop</small></h2>
					<table id="customers">
					  <tr>
					    <th>Item ID</th>
					    <th>Item Name</th>	
					    <th>Unit Cost</th>
					    <th>Number</th>			 
					    <th>Total Cost</th>
					    <th>Delete</th>
					  </tr>
					  <!--${itemsOrdered.entrySet().stream().map(x -> "-->
					  <tr>
					    <td>"+= x.getValue().getItemID() += "</td>
					    <td>"+= x.getValue().getItemName() += "</td>
					    <td>"+= x.getValue().getUnitCost() += "</td>
					    <td>
					    	<FORM>
								<INPUT TYPE='HIDDEN' NAME='itemID' VALUE='"+= x.getValue().getItemID() += "'> 
								<INPUT TYPE='TEXT' NAME='numItems' SIZE=3 VALUE='"+= x.getValue().getNumItems() += "'> 
								<SMALL>
									<INPUT TYPE='SUBMIT' class='btn-style-update'  VALUE='Update'>
								</SMALL>
							</FORM>
					    </td>
					    <td>"+= x.getValue().getTotalItemCost() += "</td>
					    <td>
					    	<FORM>
								<INPUT TYPE='HIDDEN' NAME='itemID' VALUE='"+= x.getValue().getItemID() += "'>
								<INPUT TYPE='HIDDEN' NAME='numItems' VALUE='null'>
								<INPUT TYPE='SUBMIT' class='btn-style-delete' VALUE='DELETE'>
							</FORM>
						</td>					
					  </tr>
					  <!--").toList()}-->					  					  
					</table>					
				</div>
				<div class="bill">
					<h2 id="bill">Total bill: <small id="billprice">$${prices}</small></h2>
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