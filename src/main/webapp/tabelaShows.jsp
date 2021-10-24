<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.entitys.Show" %>
<%
List<Show> shows = (List<Show>) request.getAttribute("shows");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Lista de shows</title>
<style type="text/css">
	table, td, th {
  border: 1px solid black;
	}
	
	table {
	  margin-top:10px;
	  border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1>Lista de shows</h1>
	<a href="FormControlShows?operation=novo" class="Botao1">Novo</a>
		
		<form name="form" method="POST" action="ListarShows">
			<div class="filtros">
			
					<div id="inputNome">
						<input type="text" name="nomeLugar" placeholder="Digite um lugar..." class="Caixa2">
						<input type="submit" value="Pesquisar" class="Botao1">
					</div>
				
			</div>
		</form>

	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>ONDE</th>
				<th>Data do Show</th>
				<th>Nº de Bandas</th>
				<th>Capacidade</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Show show : shows) {
			%>
			<tr>
				<td><%=show.getId()%></td>
				<td><%=show.getLocal_do_show().getNome()%></td>
				<td><%=show.getData()%></td>
				<td><%=show.getBandas().size()%></td>
				<td><%=show.getLocal_do_show().getCapacidade()%></td>
				<td>
					<a href="FormControlShows?operation=editar&idShow=<%=show.getId()%>" class="Botao1">Editar</a>
					<a href="javascript: confirmarShow(<%= show.getId() %>)" class="Botao2">Excluir</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>