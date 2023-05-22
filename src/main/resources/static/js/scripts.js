let boton = document.getElementById('botonFormularioCliente');
let contrasena = document.getElementById('contrasena');
let contrasena2 = document.getElementById('contrasena2');
let nombre = document.getElementById('nombre');
let apellido = document.getElementById('apellido');
let mensajeContraseña = document.getElementById('mensajeContraseña');
let mensajeNombre = document.getElementById('mensajeNombre');
let mensajeApellido = document.getElementById('mensajeApellido');

boton.addEventListener('click', validarCampos);

function validarCampos(event) {
    event.preventDefault(); // Evita el envío del formulario por defecto
    const nombreRegExp = /^[a-zA-Z\s]+$/; // Expresión regular para permitir solo letras y espacios
    let validacionExitosa = true;

    if (contrasena.value !== contrasena2.value) {
        mensajeContraseña.style.display = 'block'; // Muestra el mensaje de error de contraseña
        contrasena.focus(); // Coloca el foco en el campo de contraseña
        validacionExitosa = false;
    } else {
        mensajeContraseña.style.display = 'none'; // Oculta el mensaje de error de contraseña
    }

    if (!nombreRegExp.test(nombre.value.trim())) {
        mensajeNombre.textContent = 'Por favor, ingresa un nombre válido sin números ni caracteres especiales.';
        mensajeNombre.style.display = 'block'; // Muestra el mensaje de error de nombre
        nombre.focus(); // Coloca el foco en el campo de nombre
        validacionExitosa = false;
    } else {
        mensajeNombre.style.display = 'none'; // Oculta el mensaje de error de nombre
    }

    if (!nombreRegExp.test(apellido.value.trim())) {
        mensajeApellido.textContent = 'Por favor, ingresa un apellido válido sin números ni caracteres especiales.';
        mensajeApellido.style.display = 'block'; // Muestra el mensaje de error de apellido
        apellido.focus(); // Coloca el foco en el campo de apellido
        validacionExitosa = false;
    } else {
        mensajeApellido.style.display = 'none'; // Oculta el mensaje de error de apellido
    }

    if (validacionExitosa) {
        boton.form.submit(); // Envía el formulario si la validación fue exitosa
    }
}