[![Build Status](https://travis-ci.com/InigoNavarro/proyectoBSPQRecuperacion.svg?branch=master)](https://travis-ci.com/InigoNavarro/proyectoBSPQRecuperacion)[![codecov](https://codecov.io/gh/InigoNavarro/proyectoBSPQRecuperacion/branch/master/graph/badge.svg)](https://codecov.io/gh/InigoNavarro/proyectoBSPQRecuperacion)
# Tema del proyecto
El proyecto sera un applicación que tiene como idea principal la gestión de una tienda de videojuegos en las que se buscar un juego en el catalogo, ver la info de un juego y si eso actualizarlo o retirarlo, un grafico de las ventas de 10 juegos donde se podra recargar aquellos que no esten disponibles, ver la información de un socio y si eso actualizarlo y editarlo y ver los juegos que ha reservado un cliente.

## Requisitos
- Java JDK > 11
- Maven

# Comandos para instalación
  - mvn install

# Comandos para usar la aplicación
  - mvn javafx:run
  
# Comandos para generar documentación
- mvn javadoc:javadoc

# Comandos para ver porcentaje de testeo
- mvn clean verify 

o

- mvn jacoco:report

o 

- mvn clean test jacoco:report

# Interfaz
Hay 6 ventanas:

  -Principal, contiene 5 botones desde lo que se podran abrir el resto de ventanas.
  
  -Catalogo, buscar los juegos disponibles en el almacen de la tienda.
  
  -Juego, poder editar la información de un juego, recargar por falta de stock o retirarlo.
  
  -Reservas, poder ver las reservas realizadas por un cliente.
  
  -Socio, poder ver la información de todos los clientes y seleccionando a uno se podra editar su info y elimiar antiguos.
  
  -Un grafico de 10 juegos para ver cuales se venden y cuales no, desde aqui se podran recargar aquellos con falta de stock.
   
Para crear las ventanas se ha hecho uso de javaFX.

# Base de Datos
Para la base de datos se hara uso de DataNucleos. La base de datos consta de 3 clases:

  -Juego, con los atributos JuegoId, un String; NombreJ, un String; Precio, un double; Creadores, un String; numVendidos, un int y copiasDisp, un boolean.
  
  -Socio, con los atributos SocioID, un String; NombreApellido, un String; y pts, un int.
  
  -Reserva, con los atributos id y nombre de las otras dos tablas

# Hecho por:
<td align="center"><a href="https://github.com/InigoNavarro">
 <img src="https://avatars1.githubusercontent.com/u/33113628?s=400&v=4" 
        width="150px;" alt="Iñigo Navarro"/><br /><sub><b>Iñigo Navarro</b></sub></a><br/></td>
