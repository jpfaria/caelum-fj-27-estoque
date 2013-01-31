<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${mensagem}"><p>${mensagem}</p></c:if>
	
	<c:forEach items="${produtoList}" var="produto">
		${produto.descricao} - ${produto.quantidade} - 
		<a href="/estoque/produtos/mostrar/${produto.id}">detalhes</a> - 
		<a href="/estoque/produtos/editar/${produto.id}">editar</a> - 
		<a href="/estoque/produtos/remover/${produto.id}">remover</a><br />
	</c:forEach>

</body>
</html>