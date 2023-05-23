# Tienda de cómics y juegos de mesa
Para acceder a la página existen dos formas:

Forma de administrador:

Usuario: admin.
Contraseña: 1234.
Forma de usuario:

Usuario: user.
Contraseña: 1234.
En la aplicación web encontramos una tienda de cómics y juegos de mesa que permite, por un lado, al usuario comprar cómics y juegos de mesa, y por otro lado, al administrador gestionar la tienda dando de alta productos.

##
En el proyecto se encuentra el CRUD, la lógica de negocio y la seguridad. Han quedado algunas cosas por pulir debido a algunos atascos con parte del proyecto, por ejemplo, falta desarrollar la relación de la valoración del producto por parte del usuario, la forma de filtrar los productos mostrados y generar un control de stock (impedir la compra si no hay productos suficientes), lo cual está en el código pero permanece comentado debido a errores.

###
Uso
Al entrar en la web, lo primero que encontramos es un inicio de sesión en una página estática con información sobre la tienda de cómics. Una vez logueados, podemos acceder a la raíz del programa. Dependiendo de cómo accedamos, encontraremos varias posibilidades.

Si accedemos como usuario, podremos ver los productos de la tienda, buscar por nombre del producto en el buscador, agregar el producto a través del botón del carrito y ver la información detallada del producto en el botón "+" del producto. También podemos ver nuestros datos y salir del inicio de sesión.

A través del símbolo del carrito, podremos acceder a la cesta de la compra. También se accede cuando agregamos un nuevo producto. Podemos ver el historial de compras en "Mis compras" y podemos ver nuestros datos en "Zona usuario".

Si accedemos como administrador, encontraremos la misma portada pero sin los botones de compra. La diferencia radica en la "Zona admin", donde podremos realizar todas las acciones CRUD del programa.

En ambos casos el logo de la tienda dirigen al inicio del programa.

Como se pidió en clase, aquí recojo las cosas que me gustaría ir implementando:

Primero, aumentar la lógica de negocio teniendo en cuenta el stock disponible.
En función de este stock, mostrar la palabra "Stock" en diferentes colores.
Filtrar los productos por diferentes atributos.
Permitir al usuario editar sus datos.
Proveer al administrador de un mayor control sobre las finanzas de la tienda.
###

Errores

| Prueba | Solución | OK |
| --- | --- | --- |
| Acceder zona admin | Implementar seguridad en el programa | si |
| Introducción de números negativos | Implementar JS | si |
| Buscar un id inexistente | Implementar seguridad en el programa | si |
| Acceder a las dierentes partes de la tienda sin estar logueado | Implementar seguridad en el programa | si |

