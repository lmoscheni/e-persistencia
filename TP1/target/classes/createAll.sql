DROP SCHEMA IF EXISTS Epers_EjHibernate;
CREATE SCHEMA Epers_EjHibernate;

USE Epers_EjHibernate;

CREATE TABLE  `Epers_EjHibernate`.`jugadores` (
  `J_ID` int(11) NOT NULL AUTO_INCREMENT,
  `J_NOMBRE` varchar(20) NOT NULL,
  `J_APELLIDO` varchar(20) NOT NULL,
  `J_NRO` int(11) DEFAULT NULL,
  PRIMARY KEY (`J_ID`)
) ENGINE = InnoDB AUTO_INCREMENT=1;

INSERT INTO jugadores (J_NOMBRE,J_APELLIDO,J_NRO) VALUES ("Juan Carlos","Batman",23);