[![Build Status](https://travis-ci.com/InigoNavarro/proyectoBSPQRecuperacion.svg?branch=master)](https://travis-ci.com/InigoNavarro/proyectoBSPQRecuperacion)[![Coverage Status](https://coveralls.io/repos/github/InigoNavarro/proyectoBSPQRecuperacion/badge.svg?branch=master)](https://coveralls.io/github/InigoNavarro/proyectoBSPQRecuperacion?branch=master)[![codecov](https://codecov.io/gh/InigoNavarro/proyectoBSPQRecuperacion/branch/master/graph/badge.svg)](https://codecov.io/gh/InigoNavarro/proyectoBSPQRecuperacion)
# Proyecto BSPQ Recuperacion
Este es el proyecto que he realizado para poder recuperar la nota de la asignatura Procesos del Software y Calidad de la Universidad de Deusto

# Tema del proyecto
El proyecto sera un applicación que tiene como idea principal la gestión de una tienda de videojuegos.

# Comandos para instalación
  

# Interfaz
Hay 6 ventanas:

  -Principal, que contedra 5 botones desde lo que se podran abrir el resto de ventanas.
  
  -Catalogo, ver los juegos disponibles en el almacen de la tienda.
  
  -Juego, poder editar la información de un juego, recargar por falta de stock o retirarlo.
  
  -Reservas, poder ver las reservas realizadas por un cliente.
  
  -Socio, podra verse la información de todos los clientes y seleccionando a uno se podra editar su info, ademas de crear nuevos o elimiar antiguos.
  
  -Un grafico de los 10 juegos que más se han vendido, desde aqui se podran recargar aquellos con falta de stock.
  
  
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
