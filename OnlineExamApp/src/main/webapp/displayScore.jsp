<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1{
color: blue
border: 2px
}
</style>
</head>
<body>
<h1>Congratulations, you have scored <%= session.getAttribute("score") %> marks</h1>
</body>
</html>