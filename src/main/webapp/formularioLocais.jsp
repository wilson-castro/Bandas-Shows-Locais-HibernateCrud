<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entitys.Show" %>
<%@ page import="model.entitys.Local" %>
<%
List<Show> shows = (List<Show>) request.getAttribute("shows");
List<Integer> idsIguaisShows = new ArrayList<Integer>();
																															
String titulo = request.getAttribute("titulo").toString();
String actionForm  = request.getAttribute("actionForm").toString();
String textoBotao = request.getAttribute("txtBotao").toString();
String textoInputNome = request.getAttribute("textoInputNome").toString();
String textoInputCapacidade = request.getAttribute("textoInputCapacidade").toString();
String placeHolderInput = request.getAttribute("defaultInput").toString();
Local local = (Local) request.getAttribute("local");

SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
String dataFormat = "";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=titulo%></title>
</head>
<body>
	<h1><%=titulo %> Local</h1>

	<form name="form" action="<%=actionForm%>">
		
		<div class="formComponentes">
			<div>
				<% if(titulo.equals("Editar")){ %>
					<label for="Caixa3"> ID </label>
					<input type="text" name="idLocal" readOnly id="Caixa3"
						value="<% out.print(local.getId()); %>">
				<% }%>
			</div>
				<input type="text" name="nome" placeholder="<%=placeHolderInput %>"
					value="<%=textoInputNome %>" class="Caixa2">
				
				<div style="margin-top: 10px">
					<input type="number" id="capacidade" name="capacidade" value="<%=textoInputCapacidade %>"
					 min=1 class="Caixa2">
				</div>
				
				
			<h5>Shows</h5>
			<div class="group-checkbox" style="margin-bottom: 10px;">
				<% for(Show show : shows){ %>
					<input type="checkbox"
					 id="<%=show.getId()%>"
					 name="List_ShowsIDs" value=<%= show.getId()%>
					>
					<label for="<%= show.getId() %>">
						<strong>ID</strong>: <%= show.getId() %> -
						<strong>Data</strong>:
							<%
								dataFormat = formatDate.format(show.getData().getTime());
								out.print(dataFormat);
							%> -
						<strong>Nº Bandas</strong>:
							<%
								int numBandas = show.getBandas() !=null? show.getBandas().size():0;
								out.print(numBandas);
							%>
					 </label><br>
				<%}%>
			</div>
			
		</div>
		
		
		<input type="button" value="<%=textoBotao %>" class="Botao1"
			onclick="validarLocal()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>