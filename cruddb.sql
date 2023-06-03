-- Database: dbcrud

-- DROP DATABASE IF EXISTS dbcrud;

CREATE DATABASE dbcrud
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Mexico.1252'
    LC_CTYPE = 'Spanish_Mexico.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
	CREATE TABLE USER (
ID_USER INT IDENTITY (1,1) PRIMARY KEY,
NAME_USER VARCHAR (50) NOT NULL,
A_PATERNO VARCHAR (50) NOT NULL,
A_MATERNO VARCHAR (50),
USER VARCHAR (50) NOT NULL,
CLAVE VARCHAR (50) NOT NULL
);