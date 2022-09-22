<!doctype html>
<%@page import="com.util.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="fonts/icomoon/style.css">

	<link rel="stylesheet" href="css/owl.carousel.min.css">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css">

	<!-- Style -->
	<link rel="stylesheet" href="css/style.css">

	<title>All Employee List</title>
</head>

<body>
	<div class="content">
		<div class="container">
			<h2 class="mb-5">All Employee List</h2>
			<div class="table-responsive custom-table-responsive">
				<table class="table custom-table">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">User Name</th>
							<th scope="col">Password</th>
							<th scope="col">Address</th>
							<th scope="col">Contact No.</th>
							<th scope="col">Edit</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody>
						<%
							Connection connection = new DBUtil().getConnectionData();
							String querie = "select * from employee";
							PreparedStatement st = connection.prepareStatement(querie);
							ResultSet rs = st.executeQuery();

							while(rs.next()){
						%>
						<tr>
							<td><%=rs.getString(1) %></td>
							<td><%=rs.getString(2) %></td>
							<td><%=rs.getString(3) %></td>
							<td><%=rs.getString(4) %></td>
							<td><%=rs.getString(5) %></td>
							<td><%=rs.getString(6) %></td>
							<td><%=rs.getString(7) %></td>
							<td><a class="btn btn-info" href="HomeController?action=editUser&userId=<%=rs.getInt(1)%>">Edit</a></td>
							<td><a class="btn btn-danger" href="HomeController?action=deleteUser&userId=<%=rs.getInt(1)%>">Delete</a></td>
						</tr>
						<%
							}
							connection.close();
						%>
					</tbody>
				</table>
				<a class="btn btn-info" type="button" href="register_form.jsp">Add New Employee</a>
			</div>
		</div>
	</div>
</body>

</html>