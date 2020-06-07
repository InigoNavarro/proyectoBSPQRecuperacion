[![Build Status](https://travis-ci.com/InigoNavarro/proyectoBSPQRecuperacion.svg?branch=master)](https://travis-ci.com/InigoNavarro/proyectoBSPQRecuperacion)[![Coverage Status](https://coveralls.io/repos/github/InigoNavarro/proyectoBSPQRecuperacion/badge.svg?branch=master)](https://coveralls.io/github/InigoNavarro/proyectoBSPQRecuperacion?branch=master)[![codecov](https://codecov.io/gh/InigoNavarro/proyectoBSPQRecuperacion/branch/master/graph/badge.svg)](https://codecov.io/gh/InigoNavarro/proyectoBSPQRecuperacion)
# Proyecto BSPQ Recuperacion
Este es el proyecto que he realizado para poder recuperar la nota de la asignatura Procesos del Software y Calidad de la Universidad de Deusto

# Tema del proyecto
El proyecto sera un applicación que tiene como idea principal la gestión de una tienda de videojuegos.

# Comandos para instalación
  - mvn install

# Comandos para usar la aplicación
  - mvn javafx:run
  
  La primera vez que se ejecute habra que ir a App.java:
  
  (Si se tiene en modo Navigator en Eclipse)
  
  ![image](https://user-images.githubusercontent.com/33113628/83974040-95f69400-a8ea-11ea-8bee-0afafe21bac6.png)
 
  (Si se tiene en modo Package Explorer en Eclipse)
  
  ![image](https://user-images.githubusercontent.com/33113628/83974027-85461e00-a8ea-11ea-9f35-b399ab5394a8.png)
  
  Y ahi descomentar estas dos linea:
  
  ![image](https://user-images.githubusercontent.com/33113628/83974079-e40b9780-a8ea-11ea-9e78-63b617db14cd.png)
  
  Una vez hecho esto, estas dos lineas habria que comentarlas para que no salte la excepción flush().
  
# Comandos para generar documentación

# Interfaz
Hay 6 ventanas:

  -Principal, que contedra 5 botones desde lo que se podran abrir el resto de ventanas.
  
  -Catalogo, buscar los juegos disponibles en el almacen de la tienda.
  
  -Juego, poder editar la información de un juego, recargar por falta de stock o retirarlo.
  
  -Reservas, poder ver las reservas realizadas por un cliente.
  
  -Socio, podra verse la información de todos los clientes y seleccionando a uno se podra editar su info y elimiar antiguos.
  
  -Un grafico de 10 juegos para ver cuales se venden y cuales no, desde aqui se podran recargar aquellos con falta de stock.
  
  
Para crear las ventanas se hara uso de javaFX.

# Base de Datos
Para la base de datos se hara uso de DataNucleos. La base de datos consta de 3 clases:

  -Juego, con los atributos JuegoId, un String; NombreJ, un String; Precio, un double; Creadores, un String; numVendidos, un int y copiasDisp, un boolean.
  
  -Socio, con los atributos SocioID, un String; NombreApellido, un String; y pts, un int.
  
  -Reserva, con los atributos id y nombre de las otras dos tablas.

Estos son los datos que estan en la BD sin haber realizado ninguno cambio mediante teses o al hacer uso de la aplicación:

![image](https://user-images.githubusercontent.com/33113628/83974143-4c5a7900-a8eb-11ea-9921-5295edc643a0.png)

# Hecho por:
<td align="center"><a href="https://github.com/InigoNavarro">
 <img src="https://avatars1.githubusercontent.com/u/33113628?s=400&v=4" 
        width="150px;" alt="Iñigo Navarro"/><br /><sub><b>Iñigo Navarro</b></sub></a><br/></td>
