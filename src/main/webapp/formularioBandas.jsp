<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="model.entitys.Banda" %>
<%@ page import="model.entitys.Show" %>
<%
List<Show> showsDaBanda = new ArrayList<Show>();

String titulo = request.getAttribute("titulo").toString();
String placeHolderInput = request.getAttribute("defaultInput").toString();
String selectedOption = request.getAttribute("selected").toString();
String textoBotao = request.getAttribute("txtBotao").toString();
String textoInputNome = request.getAttribute("textoInputNome").toString();
String actionForm  = request.getAttribute("actionForm").toString();
Banda banda = (Banda) request.getAttribute("Banda");

SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
String dataFormat = "";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=titulo%></title>
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<h1><%=titulo %> banda</h1>

	<form name="form" action="<%=actionForm%>">
		
		<div class="formComponentes">
			
			<% if(titulo.equals("Editar")){ %>
				<div class="ID-group">
					<label for="Caixa3"> ID </label>
					<input type="text" name="idBanda" readOnly id="Caixa3"
						value="<% out.print(banda.getId()); %>">
				</div>

			<% }%>
			<input style="margin-top: 10px" type="text" name="nome" value="<%=textoInputNome %>" required placeholder="<%=placeHolderInput%>"
				class="Caixa2">
							
			<div style="margin-top: 10px">
				<select id="selectGeneros" required name="selectGeneros">
					<option value="-selecione-">Selecione Genero</option>
					<option value="ROCK" >ROCK</option>
					<option value="FORRO">FORRÓ</option>
					<option value=AXE>AXÉ</option>
				</select>
			</div>	
		</div>
		
		
		<input type="button" value="<%=textoBotao %>" class="Botao1"
			onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
	<script>
	document.querySelector('#selectGeneros [value="<%=selectedOption %>"]').selected = true;
	
	</script>
</body>
</html>