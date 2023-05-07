const form = document.getElementById('controlForm');
const contrasenia = document.getElementById('contrasena');
const constrasenia2 = document.getElementById('contrasena2');

form.addEventListener('submit', function(){
	if(contrasenia.value !== constrasenia2.value){
		alert('Las contraseñas no coinciden')
		return false
	}
});

