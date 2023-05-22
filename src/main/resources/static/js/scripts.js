let boton = document.getElementById('botonFormularioCliente');
let contrasena = document.getElementById('contrasena');
let contrasena2 = document.getElementById('contrasena2');
let nombre = document.getElementById('nombre');
let apellido = document.getElementById('apellido');
let fechaNacimiento = document.getElementById('fechanacimiento');
let mensajeContraseña = document.getElementById('mensajeContraseña');
let mensajeNombre = document.getElementById('mensajeNombre');
let mensajeApellido = document.getElementById('mensajeApellido');
let mensajeEdad = document.getElementById('mensajeEdad');

boton.addEventListener('click', validarCampos);

function validarCampos(event) {
	event.preventDefault(); 
	const nombreRegExp = /^[a-zA-Z\s]+$/; 
	let validacionExitosa = true;

	if (contrasena.value !== contrasena2.value) {
		mensajeContraseña.style.display = 'block'; 
		contrasena.focus(); 
		validacionExitosa = false;
	} else {
		mensajeContraseña.style.display = 'none'; // Hide the password error message
	}

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
	
	const today = new Date();
	const birthDate = new Date(fechaNacimiento.value);
	const age = today.getFullYear() - birthDate.getFullYear();

	if (age < 18) {
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