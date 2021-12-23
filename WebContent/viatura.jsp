<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.Viatura"%>
<%@ page import="java.util.ArrayList"%>

<%
	@ SuppressWarnings("unchecked")
	ArrayList<Viatura> lista = (ArrayList<Viatura>) request.getAttribute("viatura");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vehicle Sales</title>
</head>
<body>

	<a href="novo.html" class="botao1">Novo carro</a>

	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>MARCA</th>
				<th>FABRICO</th>
				<th>TIPO</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getCod()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getMarca()%></td>
				<td><%=lista.get(i).getFabrico()%></td>
				<td><%=lista.get(i).getTipoDesc()%></td>
				<td><a href="select?cod<%=lista.get(i).getCod()%>"
					class="botao1">EDITAR</a></td>
				<td><a
					href="javascript: confirmar(<%=lista.get(i).getCod()%>)" 
					class="botao2">EXCLUIR</a>
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>