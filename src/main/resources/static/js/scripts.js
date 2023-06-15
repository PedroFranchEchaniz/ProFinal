let boton = document.getElementById('botonFormularioCliente');
let nombre = document.getElementById('nombre');
let apellido = document.getElementById('apellido');
let fechaNacimiento = document.getElementById('fechanacimiento');
let contrasenia = document.getElementById('contrasena')
let contrasenia2 = document.getElementById('contrasena2')
let mensajeContrasena = document.getElementById('mensajeContrasena');
let mensajeNombre = document.getElementById('mensajeNombre');
let mensajeApellido = document.getElementById('mensajeApellido');
let mensajeEdad = document.getElementById('mensajeEdad');
boton.addEventListener('click', validarCampos);

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

	if (contrasenia.value !== contrasenia2.value) {
		mensajeContrasena.textContent = 'Las contraseñas no coinciden.';
		mensajeContrasena.style.display = 'block';
		contrasenia.focus();
		validacionExitosa = false;
	} else {
		mensajeContrasena.style.display = 'none';
	}

	if (validacionExitosa) {
		boton.form.submit();
	}
}

