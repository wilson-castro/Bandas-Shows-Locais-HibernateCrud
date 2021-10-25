<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.entitys.*"%>
<%
List<Local> locais = (List) request.getAttribute("locais");
List<Banda> bandas = (List) request.getAttribute("bandas");
List<Banda> bandasDoShow = new ArrayList<Banda>();
List<Integer> idsIguaisShows = new ArrayList<>();

String titulo = request.getAttribute("titulo").toString();
String selectedOption = request.getAttribute("selected").toString();
String dataDefault = request.getAttribute("dataDefault").toString();
String actionForm  = request.getAttribute("actionForm").toString();
String textoBotao = request.getAttribute("txtBotao").toString();
Show show = (Show) request.getAttribute("show");

if(titulo.equals("Editar")){
	bandasDoShow = show.getBandas();
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=titulo%></title>
</head>
<body>
	<h1><%=titulo %> show</h1>

	<form name="form" action="<%=actionForm%>">
		
		<div class="formComponentes">
			<div>
				<% if(titulo.equals("Editar")){ %>
					<label for="Caixa3"> ID </label>
					<input type="text" name="idShow" readOnly id="Caixa3"
						value="<% out.print(show.getId()); %>">
				<% }%>
			</div>
					
			<div class="ID-group">
					<input type=date id="data" name="data" min="<%=dataDefault %>" value="<%=dataDefault %>"
						class="Caixa2">
			</div>
					
			<select style="margin-top: 10px;" id="selectLocais" required name="selectLocais">
				<option value="-selecione-">Selecione o Local</option>
				<% for(Local local : locais) { %>
					<option value="<%=local.getId() %>" >
					<%=local.getId() %> - 
					<%=local.getNome() %> - 
					<%=local.getCapacidade() %></option>
				<%} %>
			</select>
			
			<h5>Bandas</h5>
			<div class="group-checkbox" style="margin-bottom: 10px;">
				<% for(Banda banda : bandas){ %>
					<input type="checkbox"
					<%	
						for(Banda bandaDoShow:bandasDoShow){
					
							if(banda.getId()==bandaDoShow.getId()){
								out.print("checked");
							}
						}
					%>
					
					 id="<%=banda.getId() %>"
					 name="List_BandaIDs" value=<%= banda.getId() %>
					>
					<label for="<%= banda.getId() %>">
						<strong>ID</strong>: <%= banda.getId() %> -
						<strong>Nome</strong>: <%= banda.getNome() %> -
						<strong>Genero</strong>: <%= banda.getGenero().getDescricao() %>
   					</label><br>
				<%}%>
					
			</div>
			
		</div>
		
		
		<input type="button" value="<%=textoBotao %>" class="Botao1"
			onclick="validarShow()">
	</form>
	<script src="scripts/validador.js"></script>
	<script>
	document.querySelector('#selectLocais [value="<%=selectedOption %>"]').selected = true;
	</script>
</body>
</html>