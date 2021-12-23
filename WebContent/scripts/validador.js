/**
 * @autor Benjamim Aves
 * 
 */

function validar() {
	let nome = formContacto.nome.value;
	let marca = formContacto.marca.value;
	
	if (nome == ""){
		alert('Preencha o nome');
		formContacto.nome.focus();
		return false;
	} else if (marca == ""){
		alert('Preencha o fone');
		formContacto.fone.focus();
		return false;
	} else {
		document.forms["formContacto"].submit();
	}
}