let boton = document.getElementById('botonFormularioCliente');
let contrasena = document.getElementById('contrasena');
let contrasena2 = document.getElementById('contrasena2');
let nombre = document.getElementById('nombre');
let mensajeContraseña = document.getElementById('mensajeContraseña');
let mensajeNombre = document.getElementById('mensajeNombre');

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
        mensajeNombre.style.display = 'block'; // Muestra el mensaje de error de nombre
        nombre.focus(); // Coloca el foco en el campo de nombre
        validacionExitosa = false;
    } else {
        mensajeNombre.style.display = 'none'; // Oculta el mensaje de error de nombre
    }

    if (validacionExitosa) {
        boton.form.submit(); // Envía el formulario si la validación fue exitosa
    }
}