<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">JBK</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		<div class="navbar-nav">
			<a class="nav-item nav-link active" href="#">Home <span
				class="sr-only">(current)</span></a> <a class="nav-item nav-link"
				href="alluser">List Of User</a>

			<%
			String role = (String) session.getAttribute("role");
			if (role.equalsIgnoreCase("Admin")) {
			%>
			 <a class="nav-item nav-link" href="adduserpage">Add User</a>
			<%
			}
			%>


			<a class="nav-item nav-link " href="#">List Of Product</a> <a
				class="nav-item nav-link " href="#">Add Product</a> <a
				class="nav-item nav-link " href="#"> <%
 out.print(session.getAttribute("username"));
 %></a>
			<a class="nav-item nav-link " href="logout">Logout</a>
		</div>
	</div>
</nav>