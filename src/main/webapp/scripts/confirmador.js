/**
 * 
 */

function confirmar(id) {
	let resposta = confirm("Confirma a exclusão deste item?")
	if (resposta === true) {
		window.location.href = "bandas/delete?idBanda=" + id
	}
}

function confirmarShow(id) {
	let resposta = confirm("Confirma a exclusão deste item?")
	if (resposta === true) {
		window.location.href = "shows/delete?idShow=" + id
	}
}

function confirmarLocal(id) {
	let resposta = confirm("Confirma a exclusão deste item?")
	if (resposta === true) {
		window.location.href = "locais/delete?idLocal=" + id
	}
}