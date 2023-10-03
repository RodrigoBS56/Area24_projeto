<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<%
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		out.print(nome);
		out.print(senha);
	%>
</body>
</html>