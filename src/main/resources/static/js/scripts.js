let formulario = document.querySelector('form');
let nombre = document.getElementById('nombre');
let apellido = document.getElementById('apellido');
let fechaNacimiento = document.getElementById('fechanacimiento');
let contrasenia = document.getElementById('contrasena');
let contrasenia2 = document.getElementById('contrasena2');
let mensajeContrasena = document.getElementById('mensajeContrasena');
let mensajeNombre = document.getElementById('mensajeNombre');
let mensajeApellido = document.getElementById('mensajeApellido');
let mensajeEdad = document.getElementById('mensajeEdad');

formulario.addEventListener('submit', validarCampos);

function validarCampos(event) {
	event.preventDefault();
	const nombreRegExp = /^[a-zA-Z\s]+$/;
	let validacionExitosa = true;

	// Restablecer mensajes de error
	mensajeNombre.style.display = 'none';
	mensajeApellido.style.display = 'none';
	mensajeEdad.style.display = 'none';
	mensajeContrasena.style.display = 'none';

	if (!nombreRegExp.test(nombre.value.trim())) {
		mensajeNombre.textContent = 'Por favor, ingresa un nombre válido sin números ni caracteres especiales.';
		mensajeNombre.style.display = 'block';
		nombre.focus();
		validacionExitosa = false;
	}

	if (!nombreRegExp.test(apellido.value.trim())) {
		mensajeApellido.textContent = 'Por favor, ingresa un apellido válido sin números ni caracteres especiales.';
		mensajeApellido.style.display = 'block';
		apellido.focus();
		validacionExitosa = false;
	}

	const hoy = new Date();
	const fechaCumple = new Date(fechaNacimiento.value);
	const edad = hoy.getFullYear() - fechaCumple.getFullYear();

	if (fechaNacimiento.value.trim() === '') {
		mensajeEdad.textContent = 'Por favor, ingresa tu fecha de nacimiento.';
		mensajeEdad.style.display = 'block';
		fechaNacimiento.focus();
		validacionExitosa = false;
	} else if (edad < 18) {
		mensajeEdad.textContent = 'Debes ser mayor de edad para registrarte.';
		mensajeEdad.style.display = 'block';
		fechaNacimiento.focus();
		validacionExitosa = false;
	}

	if (contrasenia.value.trim() === '') {
		mensajeContrasena.textContent = 'Por favor, ingresa una contraseña.';
		mensajeContrasena.style.display = 'block';
		contrasenia.focus();
		validacionExitosa = false;
	} else if (contrasenia.value !== contrasenia2.value) {
		mensajeContrasena.textContent = 'Las contraseñas no coinciden.';
		mensajeContrasena.style.display = 'block';
		contrasenia.focus();
		validacionExitosa = false;
	}

	if (validacionExitosa) {
		formulario.submit();
	}
}
