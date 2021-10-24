<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entitys.Banda" %>
<%
List<Banda> bandas = (List<Banda>) request.getAttribute("bandas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de bandas</title>
<style type="text/css">
	table, td, th {
  border: 1px solid black;
	}
	
	table {
	  margin-top:7px;
	  border-collapse: collapse;
	}
</style>
</head>
<body>
	<h1>Lista de bandas</h1>
		<a href="FormControlBandas?operation=novo" class="Botao1">Novo</a>

		<form name="form" method="POST" action="ListarBandas">
			<div class="filtros">
			
					<div id="inputNome">
						<input type="text" name="nome" placeholder="Digite um nome..." class="Caixa2">
						<input type="submit" value="Pesquisar" class="Botao1">
					</div>
				
				<div class="group-checkbox">
					<input type="checkbox" id="ROCK" name="listGeneros" value="ROCK">
					    <label for="ROCK"> ROCK</label>
					<input type="checkbox" id="FORRO" name="listGeneros" value="FORRO">
						<label for="FORRO"> FORRÓ</label>
					 <input type="checkbox" id="AXE" name="listGeneros" value="AXE">
						<label for="AXE"> AXÉ</label>
				</div>
				
			</div>
		</form>

	<table id="tabela">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Genero</th>
				<th>Nº de Shows</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<%for (Banda banda : bandas) {%>
						<tr>
							<td><%=banda.getId()%></td>
							<td><%=banda.getNome()%></td>
							<td><%=banda.getGenero()%></td>
							<td><%=banda.getShows().size()%></td>
							<td>
								<a href="FormControlBandas?operation=editar&idBanda=<%= banda.getId() %>">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="javascript: confirmar(<%= banda.getId() %>)">Excluir</a>
							</td>
						</tr>
					<% } %>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
	<script src="scripts/validador.js"></script>
</body>
</html>