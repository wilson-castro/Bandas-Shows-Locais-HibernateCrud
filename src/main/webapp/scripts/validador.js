/**
 * 
 */

function validar() {
	let nome = form.nome.value;
	let genero = form.selectGeneros.value;
	
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
	
	const today = new Date().toISOString().slice(0, 10)
	const yesterday = new Date(today);
	yesterday.setDate(yesterday.getDate()-1);

	if (data === yesterday) {
		alert("Preencha  o campo 'data'");
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



