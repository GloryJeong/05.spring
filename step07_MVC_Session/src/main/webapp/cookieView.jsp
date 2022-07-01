<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieView</title>
</head>
<body>
		<h2>cookieView.jsp</h2>
		cookieId : ${param.id}  ----모델 사용 <br>
		cookieId : ${cookie.id.value} <br> 
		cookieName : ${cookie.id.name} <br>
		cookie : ${cookie.id} 
		
</body>
</html>