# ApiRest_JDBC_Prodecure

Esta es una api rest sencilla, utilizando jdbc, spring y mysql, que hace uso de un procedimiento almacendo de la base de datos

Para ejecutar la aplicación, solo se debe establecer el username y password de la conexion a la base de datos. 
Por la parte de la base de datos se debe crear un schema de nombre "db_auto", con una tabla "autos" con 5 atributos id de tipo int
y los demás de tipo String (marca, modelo, fecha, string)

El procedimiento almacenado se llama marca_procedure y se encarga de filtrar por la marca de auto
en mysql ese es el código:
CREATE DEFINER=`root`@`localhost` PROCEDURE `marca_procedure`(IN `marcaIn` VARCHAR(255))
    READS SQL DATA
SELECT * FROM autos WHERE marca = marcaIn
