<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Update info</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/addPlanet.css" />
</head>
<body>
	<div id="wrapper">
		<div id="formTitle">
			<h3>Update planet info</h3>
		</div>
		<div id="formContainer">
			<form:form action="updatePlanet" modelAttribute="planet" method="POST">
			<form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td><label>Planet</label></td>
							<td><form:input path="planetName" disabled="true"/></td>
							<td><form:errors path="planetName" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Mission</label></td>
							<td><form:input path="mission" /></td>
							<td><form:errors path="mission" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Launch</label></td>
							<td><form:input path="launch" placeholder="yyyy/mm/dd"/></td>
							<td><form:errors path="launch" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>IAU_pattern</label></td>
							<td><form:input path="iau_code" disabled="true"/></td>
							<td><form:errors path="iau_code" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Moons</label></td>
							<td><form:input path="moons" disabled="true"/></td>
							<td><form:errors path="moons" cssClass="error" /></td>
						</tr>
						<tr>
							<td><input class="save" type="submit" value="Save" /></td>
						</tr>
					</tbody>
				</table>
			</form:form>

			<div id="style clear:both">
				<p>
					<a href="${pageContext.request.contextPath}/planet/listPlanets">Back
						to list of planets</a>
				</p>
			</div>
		</div>
	</div>
</body>