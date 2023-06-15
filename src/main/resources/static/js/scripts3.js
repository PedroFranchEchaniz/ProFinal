function validarFormulario() {
        var editorial = document.getElementById("editorial");
        
        if (editorial.value === "-1") {
            alert("Por favor, selecciona una editorial");
            return false; 
        }
        
        return true; 
    }