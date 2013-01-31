<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Movimentação</h2>

	Id: <input value="${produto.id}" disabled="disabled" /><br />
	Descricao: <input value="${produto.descricao}" disabled="disabled" /><br />
	Quantidade: <input value="${produto.quantidade}" disabled="disabled" />
	
	<h2>Lista de Movimentações</h2>
	
	<ul>

		<c:forEach items="${produto.movimentacoes}" var="m">
			<li>
				${m.tipo} - ${m.quantidade} - <fmt:formatDate value="${m.data.time}" pattern="dd/MM/yyyy - hh:mm" />
			</li>
		</c:forEach>
		
	</ul>

</body>
</html>