let boton = document.getElementById('botonFormularioCliente');
let nombre = document.getElementById('nombre');
let apellido = document.getElementById('apellido');
let fechaNacimiento = document.getElementById('fechanacimiento');
let mensajeContraseña = document.getElementById('mensajeContraseña');
let mensajeNombre = document.getElementById('mensajeNombre');
let mensajeApellido = document.getElementById('mensajeApellido');
let mensajeEdad = document.getElementById('mensajeEdad');

let botonUsuario = document.getElementById('botonEditarUsuario');
let nombreUsuario = document.getElementById('nombreUsuario');
let fechanacimientoUsuario = document.getElementById('fechanacimientoUsuario');
let apellidoUsuario = document.getElementById('apellidoUsuario');
let direccionUsuario = document.getElementById('direccionUsuario');
let emailUsuario = document.getElementById('emailUsuario');
let mensajeNombreUsuario = document.getElementById('mensajeNombreUsuario');
let mensajeApellidoUsuario = document.getElementById('mensajeApellidoUsuario');
let mensajeEdadUsuario = document.getElementById('mensajeEdadUsuario');

boton.addEventListener('click', validarCampos);
botonUsuario.addEventListener('click', validarCamposUsuario);

function validarCampos(event) {
	event.preventDefault();
	const nombreRegExp = /^[a-zA-Z\s]+$/;
	let validacionExitosa = true;

	if (!nombreRegExp.test(nombre.value.trim())) {
		mensajeNombre.textContent = 'Por favor, ingresa un nombre válido sin números ni caracteres especiales.';
		mensajeNombre.style.display = 'block';
		nombre.focus();
		validacionExitosa = false;
	} else {
		mensajeNombre.style.display = 'none';
	}

	if (!nombreRegExp.test(apellido.value.trim())) {
		mensajeApellido.textContent = 'Por favor, ingresa un apellido válido sin números ni caracteres especiales.';
		mensajeApellido.style.display = 'block';
		apellido.focus();
		validacionExitosa = false;
	} else {
		mensajeApellido.style.display = 'none';
	}

	const hoy = new Date();
	const fechaCumple = new Date(fechaNacimiento.value);
	const edad = hoy.getFullYear() - fechaCumple.getFullYear();

	if (edad < 18) {
		mensajeEdad.textContent = 'Debes ser mayor de edad para registrarte.';
		mensajeEdad.style.display = 'block';
		fechaNacimiento.focus();
		validacionExitosa = false;
	} else {
		mensajeEdad.style.display = 'none';
	}

	if (validacionExitosa) {
		boton.form.submit();
	}
}

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
		mensajeEdad.style.display = 'none';
	}

	if (validacionExitosa) {
		botonUsuario.form.submit();
	}
}