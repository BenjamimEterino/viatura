
function confirmar(cod) {
	let resposta = confirm("Exclui?")

	if (resposta === true) {
		alert(cod)
		window.location.href = "delete?cod=" + cod
	}
}