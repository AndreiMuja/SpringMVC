<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>List of planets</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="tableTitle">
			<h2>Solar System - Introduction to Space Journey</h2>
		</div>
		<div id="tableContent">
			<table id="table">
				<thead class="tableHead">
					<tr>
						<th>Planet</th>
						<th>Mission</th>
						<th>Launch</th>
						<th>IAU Pattern</th>
						<th>Moons</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody class="tableBody">
					<c:forEach var="iterator" items="${planets}">
						<!-- create jstl update link with planets id -->
						<c:url var="update" value="/planet/updatePlanetForm">
							<c:param name="planetId" value="${iterator.id}" />
						</c:url>
						<tr>
							<td>${iterator.planetName}</td>
							<td>${iterator.mission}</td>
							<td>${iterator.launch}</td>
							<td>${iterator.iau_code}</td>
							<td>${iterator.moons}</td>
							<td><a href="${update}">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<input class="addButton" type="button" value="Add planet"
			onClick="window.location.href='addForm'; return false" />
	</div>
</body>
</html>