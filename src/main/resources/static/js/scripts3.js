   function validarFormulario() {
        var editorial = document.getElementById("editorial");
        
        if (editorial.value === "-1") {
            alert("Por favor, selecciona una editorial");
            return false; // Evita que se envíe el formulario
        }
        
        return true; // Envía el formulario si la validación pasa
    }