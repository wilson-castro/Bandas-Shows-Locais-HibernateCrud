/**
 * 
 */

function validar() {
	let nome = form.nome.value;
	let genero = form.selectGeneros.value;
	
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const operation = urlParams.get('operation')
	
	if (nome === "") {
		alert("Preencha  o campo 'Nome'")
		form.nome.focus();
		return false;
	} else if (genero === "-selecione-") {
		alert("Preencha o campo 'Genero'")
		form.selectGeneros.focus();
		return false;
	} else {
		(document.forms["form"].submit());
		
	}
}

function validarShow() {
	let data = form.data.value;
	let locais = form.selectLocais.value;
	
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const operation = urlParams.get('operation')
	
	if (data === "2020-10-13") {
		alert("Preencha  o campo 'data'")
		form.data.focus();
		return false;
	}if (locais === "-selecione-") {
		alert("Preencha o campo 'Local'")
		form.selectLocais.focus();
		return false;
	} else {
		(document.forms["form"].submit());
		
	}
}

function validarLocal(){
	let nome = form.nome.value;
	let capacidade = ""+form.capacidade.value;
	
	
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const operation = urlParams.get('operation');
	
		if (nome === "") {
		alert("Preencha  o campo 'nome'")
		form.nome.focus();
		return false;
	}if (capacidade === "0") {
		alert("Preencha o campo 'capacidade'")
		form.capacidade.focus();
		return false;
	} else {
		(document.forms["form"].submit());
		
	}
}



