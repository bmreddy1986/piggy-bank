<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

</body>

<script type="text/javascript">
	<c:forEach items="${groupList}" var="grp">
	var people = new Object();
	people.name = '${grp.name}';

	groupList.push(people);

	console.log(people.name);
	</c:forEach>

</script>

</html>