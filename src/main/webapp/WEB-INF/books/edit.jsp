<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Edit Book</h1>
		<form:form method="POST" action="/books/${bookObj.id}/edit" modelAttribute="bookObj">
			<input type="hidden" name="_method" value="PUT" />
			<form:input type="hidden" path="creator" value="${user_id}" />
			<p>
				Title:
				<form:input path="title" />
				<form:errors path="title" />
			</p>
			<p>
				Author:
				<form:input path="author"/>
				<form:errors path="author" />
			</p>
			<p>
				My thoughts
				<form:textarea path="thoughts"/>
				<form:errors path="thoughts" />
			</p>
			<button>Edit</button>
		</form:form>
	</div>
</body>
</html>