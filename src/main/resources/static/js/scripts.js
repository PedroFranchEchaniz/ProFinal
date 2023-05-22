let boton = document.getElementById('botonFormularioCliente');
let contrasena = document.getElementById('contrasena');
let contrasena2 = document.getElementById('contrasena2');
let mensajeContraseña = document.getElementById('mensajeContraseña');

boton.addEventListener('click', compararContrasenias);

function compararContrasenias(event) {
    event.preventDefault(); // Evita el envío del formulario por defecto

    if (contrasena.value === contrasena2.value) {
        mensajeContraseña.style.display = 'none'; // Oculta el mensaje de error
        boton.form.submit(); // Envía el formulario
    } else {
        mensajeContraseña.style.display = 'block'; // Muestra el mensaje de error
        contrasena.focus(); // Coloca el foco en el campo de contraseña
    }
}