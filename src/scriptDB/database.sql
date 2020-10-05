/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  angel
 * Created: 5/10/2020
 */
DROP DATABASE IF EXISTS testJPASwingCRUD;
CREATE DATABASE IF NOT EXISTS testJPASwingCRUD;
USE testJPASwingCRUD;

CREATE TABLE IF NOT EXISTS empleado(
    cedula INT NOT NULL PRIMARY KEY,
    nombre CHAR(30) NOT NULL,
    apellido CHAR(60) NOT NULL,
    sueldo DECIMAL(6.2) NOT NULL,
    fechaContratacion TIMESTAMP NOT NULL
);