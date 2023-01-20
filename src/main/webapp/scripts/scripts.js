function compruebayenvia() {
	datos=document.iniciosesion;
	if (datos.usuario.value == '' ||
			datos.pass.value == '')
		alert ('¡Tiene que rellenar todos los campos!');
	else datos.submit();
}
function compruebanums(campo, evento) {
	var keycode;
	if (window.event) keycode = window.event.keyCode;
	else if (evento) keycode = evento.which;
	else return true;
	if (keycode < 48 || keycode > 57) //Rango ASCII de números
	{
		if (keycode != 8 && keycode != 27 && keycode != 0 ) { //Caracteres especiales permitidos
			alert('Sólo puede introducir números ');
			return false;
		}
		else return true;
	}
	else return true;
}
function compruebaalfan(campo, evento) {
	var keycode;
	if (window.event) keycode = window.event.keyCode;
	else if (evento) keycode = evento.which;
	else return true;
	if (( keycode < 48 || keycode > 57 ) && ( keycode < 64 || keycode > 90 ) && ( keycode < 97 || keycode > 122 )) //Rango ASCII de números y letras
	{
		if (keycode != 8 && keycode != 27 && keycode != 0 ) { //Caracteres especiales permitidos
			alert('Sólo puede introducir letras y números ');
			return false;
		}
		else return true;
	}
	else return true;
}