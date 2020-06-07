[![Build Status](https://travis-ci.com/InigoNavarro/proyectoBSPQRecuperacion.svg?branch=master)](https://travis-ci.com/InigoNavarro/proyectoBSPQRecuperacion)[![Coverage Status](https://coveralls.io/repos/github/InigoNavarro/proyectoBSPQRecuperacion/badge.svg?branch=master)](https://coveralls.io/github/InigoNavarro/proyectoBSPQRecuperacion?branch=master)[![codecov](https://codecov.io/gh/InigoNavarro/proyectoBSPQRecuperacion/branch/master/graph/badge.svg)](https://codecov.io/gh/InigoNavarro/proyectoBSPQRecuperacion)
# Proyecto BSPQ Recuperacion
Este es el proyecto que he realizado para poder recuperar la nota de la asignatura Procesos del Software y Calidad de la Universidad de Deusto

# Tema del proyecto
El proyecto sera un applicación que tiene como idea principal la gestión de una tienda de videojuegos.

# Comandos para instalación
  - mvn install

# Comandos para usar
  - mvn javafx:run
  
  La primera vez que se ejecute habra que ir a App.java:
  ![image](https://user-images.githubusercontent.com/33113628/83973916-e0c3dc00-a8e9-11ea-8c6d-22a91ea7c9a1.png)
  (Si se tiene en modo Package Explorer en Eclipse)
  ![image](https://user-images.githubusercontent.com/33113628/83973972-2b455880-a8ea-11ea-9ce7-4ceb220fc9a2.png)
  (Si se tiene en modo Navigator en Eclipse)

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

# Hecho por:
<td align="center"><a href="https://github.com/InigoNavarro">
 <img src="https://avatars1.githubusercontent.com/u/33113628?s=400&v=4" 
        width="150px;" alt="Iñigo Navarro"/><br /><sub><b>Iñigo Navarro</b></sub></a><br/></td>
