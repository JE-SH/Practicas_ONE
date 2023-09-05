```sql
CREATE DATABASE jugos;
USE jugos;

CREATE TABLE TBCLIENTES(
DNI VARCHAR(20),
NOMBRE VARCHAR(150),
DIRECCION1 VARCHAR(150);
DIRECCION2 VARCHAR(150);
BARRIO VARCHAR(50),
CIUDAD VARCHAR(50),
ESTADO VARCHAR(50),
CP VARCHAR(10),
EDAD SMALLINT,
SEXO VARCHAR(1),
LIMITE_CREDITO FLOAT,
VOLUMEN_COMPRA FLOAT,
PRIMERA_COMPRA BIT(1) 
);


CREATE TABLE tbproductos(
PRODUCTO VARCHAR(20) NULL,
NOMBRE VARCHAR(150) NULL,
ENVASE VARCHAR(50) NULL,
VOLUMEN VARCHAR(20) NULL,
SABOR VARCHAR(50) NULL,
PRECIO FLOAT NULL
);

CREATE TABLE tbvendedores(
MATRICULA VARCHAR(5) NULL,
NOMBRE VARCHAR(100),
PORCENTAJE_COMISION FLOAT NULL  
);
```

REGISTRO DE PRODUCTOS

```sql
USE jugos;

INSERT INTO tbproductos(
producto, nombre, envase, volumen, sabor, precio) VALUES 
(773912, 'clean', 'botella pet', '1 litro', 'naranja', 8.01 );
```

Registro de vendedor

```sql
USE JUGOS;

INSERT INTO tbvendedores(matricula, nombre, porcentaje_comision)
VALUES (00233, 'Joan Geraldo de la Fonseca', .10);
INSERT INTO tbvendedores(matricula, nombre, porcentaje_comision)
VALUES (00235, 'Márcio Almeida Silva', .08);
INSERT INTO tbvendedores(matricula, nombre, porcentaje_comision)
VALUES (00236, 'Cláudia Morais', .08);


UPDATE tbvendedores SET nombre='Cláudia Moral', porcentaje_comision = .11 WHERE matricula =00236;
UPDATE tbvendedores SET nombre= 'Joan Geraldo de la Fonseca Junior' WHERE matricula = 00233;

DELETE FROM tbvendedores WHERE matricula = 00233;

ALTER TABLE tbvendedores ADD PRIMARY KEY(matricula);
ALTER TABLE tbvendedores ADD COLUMN(FECHA_ADMISION DATE, de_vacaciones BIT);

UPDATE tbvendedores SET de_vacaciones = 0 WHERE matricula = 00235;
UPDATE tbvendedores SET de_vacaciones = 1 WHERE matricula = 00236;
UPDATE tbvendedores SET FECHA_ADMISION = '2014-08-15' WHERE matricula =00235;
UPDATE tbvendedores SET FECHA_ADMISION = '2013-09-17' WHERE matricula =00236;

INSERT INTO tbvendedores(matricula, nombre, porcentaje_comision, FECHA_ADMISION, de_vacaciones)
VALUES (00237, 'Roberta Martins', .11, '2017-03-18', 1);
INSERT INTO tbvendedores(matricula, nombre, porcentaje_comision, FECHA_ADMISION, de_vacaciones)
VALUES (00238, 'Péricles Alves', .11, '2016-08-21', 1);
```

```sql
ALTER TABLE tbproductos ADD PRIMARY KEY (producto);
ALTER TABLE tbclientes ADD PRIMARY KEY(dni);
ALTER TABLE tbclientes ADD COLUMN(fecha_nacimiento DATE);


USE jugos;

INSERT INTO tbproductos(
producto, nombre, envase, volumen, sabor,
precio) VALUES ('838819', 'clean', 'botella pet',
'1.5 litros', 'naranja', 12.01);

INSERT INTO tbproductos(
producto, nombre, envase, volumen, sabor,
precio) VALUES ('1037797', 'clean', 'botella pet',
'2 litros', 'naranja', 16.01);

INSERT INTO tbproductos(
producto, nombre, envase, volumen, sabor,
precio) VALUES ('8128292', 'clean', 'latat',
'350 ml', 'naranja', 2.81);


UPDATE tbproductos SET producto = '812829', envase = 'lata'
WHERE volumen = '350 ml';

UPDATE tbproductos SET precio = 28.51
WHERE producto = '695594';

UPDATE tbproductos SET sabor = 'Lima/Limón', precio = 4.90
WHERE producto = '1041119';
```
