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
	<a href="/books">Back to the shelves</a>
		<h1><i><c:out value="${oneBook.title}" /></i></h1>
		<h2><span style="color:red"><c:out value="${oneBook.creator.userName}"/></span> read <span style="color:#9400d3"><c:out value="${oneBook.title}"/></span> by <span style="color:green"><c:out value="${oneBook.author}"/></span> </h2>
			<h2>Here are <c:out value="${oneBook.creator.userName}"/>'s thoughts:  </h2>
			<hr></hr>
			<c:out value="${oneBook.thoughts}" />
			<hr></hr>
	</div>
</body>
</html>