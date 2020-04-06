<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%MemberVO loginUser = 
	(MemberVO)session.getAttribute("loginUser"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>${loginUser.getId() }님 어서오세요.</h1>
	<h2>이름 : ${loginUser.getName() }</h2>
	<h2>이메일 : ${loginUser.getEmail() }</h2>
</body>
</html>