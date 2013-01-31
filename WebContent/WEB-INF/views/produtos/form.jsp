<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/estoque/produtos/salvar" method="post">
	
		Descricao: <input type="text" name="descricao" /><br />
		Quantidade: <input type="text" name="quantidade" /><br />
		
		<input type="submit" value="Cadastrar" />
	
	</form>

</body>
</html>