<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entitys.Show" %>
<%@ page import="model.entitys.Local" %>
<%
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
			
		</div>
		
		
		<input type="button" value="<%=textoBotao %>" class="Botao1"
			onclick="validarLocal()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>