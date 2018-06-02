<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	
<html>
<head>

<title>Insert title here</title>
<%-- <link rel="stylesheet" href="<spring:theme code='stylesheet' />" type="text/css" /> --%>
</head>
<h1>${headerMessage}</h1>
<body>


<!-- <a href="/StudentAdmissionMVC/admissionform.html?siteTheme=green" >Green</a> |
<a href="/StudentAdmissionMVC/admissionform.html?siteTheme=red" >Red</a>
</br> -->

<a href="/StudentAdmissionMVC/admissionform.html?siteLanguage=en" >English</a> |
<a href="/StudentAdmissionMVC/admissionform.html?siteLanguage=fr" >French</a>
	<form action="submitadmissionform.html" method="post">
		<h3><spring:message code="label.title" /></h3>
		
		<form:errors path="studentDetails.*" />

		<p>
			<spring:message code="label.studentName" /> <input type="text" name="studentName" />
		</p>
		<p>
			<spring:message code="label.studentDOB" /> <input type="text" name="studentDOB" />
		</p>
		<p>
			<spring:message code="label.gender" /> <input type="radio" name="gender" value="Female">Female</input>
			<input type="radio" name="gender" value="Male">Male</input>
		<p>
			<spring:message code="label.studentMobile" /> <input type="text" name="studentMobile" />
		</p>
		<p>
			<spring:message code="label.studentSkills" /> <select name="studentSkills" multiple>
				<option value="Java">Java</option>
				<option value="Net">Dot Net</option>
				<option value="C">C</option>
			</select>
		</p>

		<p>
		<table>
			<tr>
				<td><spring:message code="label.street" /> <input type="text" name="studentAddress.street" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.landmark" /> <input type="text" name="studentAddress.landmark" /></td>
			</tr>
			<tr>
				<td><spring:message code="label.pinCode" /> <input type="text" name="studentAddress.pinCode" /></td>
			</tr>
		</table>
		</p>
		<p>
			<spring:message code="label.studentHobby" /> <input type="text" name="studentHobby" />
		</p>
		<p>
			<input type="submit" name="submit" value="Submit" />
		</p>
	</form>

</body>
</html>