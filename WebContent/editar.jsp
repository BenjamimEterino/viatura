<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserir contacto</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<h1>Editar contacto</h1>

	<form name="formContacto" action="update">
		<table>
			<tr>
				<td><input type="text" name="cod" class="caixa3" readonly
					value="<%out.print(request.getAttribute("cod"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="caixa1"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="marca" class="caixa2"
					value="<%out.print(request.getAttribute("marca"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fabrico" class="caixa1"
					value="<%out.print(request.getAttribute("fabrico"));%>"></td>
			</tr>
		</table>

		<button class="botao1" type="button" value="adicionar"
			onclick="validar()">Salvar</button>
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>