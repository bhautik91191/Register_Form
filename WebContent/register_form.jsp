<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<!-- Required meta tags-->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Colorlib Templates">
	<meta name="author" content="Colorlib">
	<meta name="keywords" content="Colorlib Templates">

	<!-- Title Page-->
	<title>Register Form</title>

	<!-- Main CSS-->
	<link href="css/main.css" rel="stylesheet" media="all">

</head>

<body>
	<div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
		<div class="wrapper wrapper--w680">
			<div class="card card-4">
				<div class="card-body">
					<c:if test="${editUser.id == editUser.id }">
						<c:choose>
							<c:when test="${editUser.id > 0}">
								<h2 class="title">Edit Form</h2>
							</c:when>
							<c:otherwise>
								<h2 class="title">Registration Form</h2>
							</c:otherwise>
						</c:choose>
						<form method="POST" id="registration-form" action="RegistrationController">
							<div class="row row-space">
								<div class="col-2">
									<div class="input-group">
										<label class="label">first name</label>
										<input class="input--style-4" type="text" id="firstname" name="firstname" value="${editUser.firstname }" required>
									</div>
								</div>
								<div class="col-2">
									<div class="input-group">
										<label class="label">last name</label>
										<input class="input--style-4" type="text" id="lastname" name="lastname" value="${editUser.lastname }" required>
									</div>
								</div>
							</div>
							<div class="row row-space">
								<div class="col-2">
									<div class="input-group">
										<label class="label">User name</label>
										<input class="input--style-4" type="text" name="username" value="${editUser.username }" required>
									</div>
								</div>
								<div class="col-2">
									<div class="input-group">
										<label class="label">Password</label>
										<input class="input--style-4" type="text" name="password" value="${editUser.password }" required>
									</div>
								</div>
							</div>
							<div>
								<label class="label">Address</label>
								<input class="input--style-4" type="text" name="address" value="${editUser.address }" required>
							</div>
							<div class="input-group">
								<div class="col-2">
									<div class="input-group">
										<label class="label">Contact No.</label>
										<input class="input--style-4" type="text" name="contactno" value="${editUser.contactno }" required>
										<input type="hidden" name="id" value="${editUser.id }">
									</div>
								</div>
							</div>
							<div class="p-t-15">
								 <c:choose>
									<c:when test="${editUser.id > 0}">
										<button class="btn btn--radius-2 btn--blue" type="submit" >Update</button>
									</c:when>
									<c:otherwise>
										<button class="btn btn--radius-2 btn--blue" type="submit" >Submit</button>
									</c:otherwise>
								 </c:choose>
							</div>
						</form>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<!-- Jquery JS-->
	<script>
		$(document).ready(function() {
			$("#registration-form").validate()
		});
	</script>
</body>

</html>
<!-- end document-->