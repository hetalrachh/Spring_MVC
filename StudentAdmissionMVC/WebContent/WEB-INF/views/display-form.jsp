<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form details</title>
</head>
<h1>${headerMessage}</h1>
<body>
	<h1>${message}</h1>

	<table>
		<tr>
			<td>Student name:</td>
			<td>${studentDetails.studentName}</td>
		</tr>
		<tr>
			<td>Student dob:</td>
			<td>${studentDetails.studentDOB}</td>
		</tr>
		<tr>
			<td>Student gender:</td>
			<td>${studentDetails.gender}</td>
		</tr>

		<tr>
			<td>Student address:</td>
			<td>${studentDetails.studentMobile}</td>
		</tr>
		<tr>
			<td>Student address:</td>
			<td>${studentDetails.studentSkills}</td>
		</tr>
		<tr>
			<td>Student street:</td>
			<td>${studentDetails.studentAddress.street}</td>
		</tr>
		<tr>
			<td>Student landmark:</td>
			<td>${studentDetails.studentAddress.landmark}</td>
		</tr>
		<tr>
			<td>Student pincode:</td>
			<td>${studentDetails.studentAddress.pinCode}</td>
		</tr>
		<tr>
			<td>Student hobby:</td>
			<td>${studentDetails.studentHobby}</td>
		</tr>
	</table>

</body>
</html>