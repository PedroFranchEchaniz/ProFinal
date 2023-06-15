let botonUsuario = document.getElementById('botonUsuario');
let nombreUsuario = document.getElementById('nombreUsuario');
let fechanacimientoUsuario = document.getElementById('fechanacimientoUsuario');
let apellidoUsuario = document.getElementById('apellidoUsuario');
let direccionUsuario = document.getElementById('direccionUsuario');
let emailUsuario = document.getElementById('emailUsuario');
let mensajeNombreUsuario = document.getElementById('mensajeNombreUsuario');
let mensajeApellidoUsuario = document.getElementById('mensajeApellidoUsuario');
let mensajeEdadUsuario = document.getElementById('mensajeEdadUsuario');

botonUsuario.addEventListener('click', validarCamposUsuario);

function validarCamposUsuario(event) {
	event.preventDefault();
	const nombreRegExp = /^[a-zA-Z\s]+$/;
	let validacionExitosa = true;

	if (!nombreRegExp.test(nombreUsuario.value.trim())) {
		mensajeNombreUsuario.textContent = 'Por favor, ingresa un nombre válido sin números ni caracteres especiales.';
		mensajeNombreUsuario.style.display = 'block';
		nombreUsuario.focus();
		validacionExitosa = false;
	} else {
		mensajeNombreUsuario.style.display = 'none';
	}

	if (!nombreRegExp.test(apellidoUsuario.value.trim())) {
		mensajeApellidoUsuario.textContent = 'Por favor, ingresa un apellido válido sin números ni caracteres especiales.';
		mensajeApellidoUsuario.style.display = 'block';
		apellidoUsuario.focus();
		validacionExitosa = false;
	} else {
		mensajeApellidoUsuario.style.display = 'none';
	}

	const hoy = new Date();
	const fechaCumple = new Date(fechanacimientoUsuario.value);
	const edad = hoy.getFullYear() - fechaCumple.getFullYear();

	if (edad < 18) {
		mensajeEdadUsuario.textContent = 'Debes ser mayor de edad para registrarte.';
		mensajeEdadUsuario.style.display = 'block';
		fechanacimientoUsuario.focus();
		validacionExitosa = false;
	} else {
		mensajeEdadUsuario.style.display = 'none';
	}

	if (validacionExitosa) {
		botonUsuario.form.submit();
	}
}