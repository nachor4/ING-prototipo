Ejemplo WebSocket
=================

Requisitos:
- Maven
- Java EE7


El ejemplo corre dentro del servidor GlassFish, pero este se configuró con un 
plugin "embebido" de glassfish que será descargado e instalado por MVN


Inciar el Server
================
- Para iniciar el server, ejecutar el archvo run.sh
Nota: En la primera ejecución se descargan todos los archivos de GlassFish. 
Esto puede demorar mucho tiempo dependiendo del tipo de conexion.

Ejecutar la App
===============
- Para correr el testing, ingresar en: http://localhost:8080/javaee7Sample/
- Para apagar el server escribir: x + intro 


Version Multi Usuario
=====================
En la rama multiusuario hay una version que permite ver el funcionamiento de una app a 
la que se conectan simultaneamente dos o más usuarios. 


El ejemplo se ejecuta de la misma manera que el anterior. Para poder ver el funcionamiento se deberá
abrir la página en dos o más navegadores.
