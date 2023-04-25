<jsp:include page="menu.jsp" />


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="/css/alluser.css">


<title>All User</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>

	<table class="table table-striped table-dark" id="example">
		<thead>
			<tr>
				<th scope="col">USERNAME</th>
				<th scope="col">FIRST NAME</th>
				<th scope="col">LAST NAME</th>
				<th scope="col">EMAIL</th>

				<%
				String role = (String) session.getAttribute("role");
				if (role.equalsIgnoreCase("Admin")) {
				%>
				<th scope="col">PASSWORD</th>
				<%
				}
				%>



			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usrList}" var="user">
				<tr>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.firstName}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.email}" /></td>

					<%
					if (role.equalsIgnoreCase("Admin")) {
					%>
					<td><c:out value="${user.password}" /></td>
					<%
					}
					%>


				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>

</html>
<jsp:include page="footer.jsp" />
