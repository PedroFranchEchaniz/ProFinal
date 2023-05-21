let boton = document.getElementById('botonFormularioCliente');
let contrasena = document.getElementById('contrasena');
let contrasena2 = document.getElementById('contrasena2');
boton.addEventListener('click', compararContrasenias);

function compararContrasenias() {
    if (contrasena.value === contrasena2.value) {
        // Contraseñas coinciden
    } else {
        let mostrarmenaje = document.querySelector('.mensajeContraseña');
        mostrarmenaje.style.display = 'block';
        event.preventDefault(); // Evita el envío del formulario
    }
}