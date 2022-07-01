<%@page import="model.domain.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	Cookie cookie1 = new Cookie("id","test");
	cookie1.setMaxAge(60*60);
	response.addCookie(cookie1);
	
	
	HttpSession session1 = request.getSession();
	session.setAttribute("id","spring");
	session.setAttribute("age","29");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h2>index.jsp</h2>
	
	<h3>Cookie API Test</h3>
	<a href="cookieTest.do">cookieTest.do</a>
	
	<br> <hr>
	<h3>Session API Test</h3>
	<a href="session/sessionTest1.do">sessionTest1.do</a>
	
	<a href =session/sessionTest2.do?id=spring&age=29>2. session/sessionTest2.do : DTO 객체를 저장</a>
	<br> <hr>
	
	<h3>로그인하러 가기</h3>
	<a href="session/loginForm.do">로그인하러 가기</a>
	${sessionScope.login}
	<c:if test="${!empty sessionScope.login}">
		<button onClick="location.href='session/logout.do'">로그아웃</button> 
	</c:if>
	
</body>
</html>