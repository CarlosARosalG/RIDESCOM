/*Inserta datos en la tabla Persona*/
INSERT INTO `RIDESCOM`.`Persona` (`Nombre`, `Ap_Pat`, `Ap_Mat`, `Tipo_Sexo_ID_Tipo_Sexo`, `CURP`, `Fecha_Nac`, `NSS`, `Municipio_ID_Municipio`, `Municipio_Estados_ID_estado`) 
	VALUES ('Carlos Andrés', 'Rosales', 'González', 1, 'ROGC960117HDFSNR09', '1996-01-17', '123456789', '0221', '07');
/*
	Para registrar a un entrenador se toma base la estructura de la Tabla Persona:
	INSERT INTO `RIDESCOM`.`Persona` (`Nombre`, `Ap_Pat`, `Ap_Mat`, `Tipo_Sexo_ID_Tipo_Sexo`, `CURP`, `Fecha_Nac`, `NSS`, `Municipio_ID_Municipio`, `Municipio_Estados_ID_estado`) 
		VALUES ('Eduardo', 'Castañeda', 'Perez', 1, 'CAPE870410HDFSNR09', '1987-04-10', '123456789', '0221', '07');
	Seguido del Query para asignarlo con una ACT_DEPORTIVA: 
    INSERT INTO Persona_has_Act_Deportiva(Persona_ID_Persona, Act_Deportiva_ID_Deporte)
		values ('5', '4');
*/
    
    
/*Inserta datos en la tabla CONTACTO*/
insert into Contacto(Persona_ID_Persona)
	values('4');
    

/*Inserta datos en la Tabla EMAIL*/    
insert into Email(Correo, Contacto_ID_Contacto)
	values('carlosandrosales@gmail.com', '4');
    
    
/*Inserta datos en la tabla TELEFONO_FIJO*/    
insert into Telefono_Fijo(Telefono, Contacto_ID_Contacto)
	values('51154897', '4'); 
    
/*Inserta datos en la tabla EXTENSION*/    
insert into Extension(Ext, telefono_fijo_ID_Tel_Fijo)
	values('1234', '4');
    
    
/*Inserta datos en la tabla TELEFONO_CELULAR*/    
insert into Telefono_Celular(Celular, Contacto_ID_Contacto)
	values('5548758965', '4');    
    

/*Inserta datos en la tabla de USUARIO 1: JFD, 2: CoordUA, 3: ALumno*/    
INSERT INTO Usuario (`Nombre_U`, `Password_U`, `Activo`, `Fecha_Inicio`, `Roles_ID_Roles`, `Persona_ID_Persona`) 
	VALUES ('2015630443', '0443', 1, left(now(),10), 3, 4);
    

/*
En caso de que se quiera dar de alta a un alumno de una escuela diferente de ESCOM, se tiene que ejecutar el Query siguiente.
Tomando en cuenta que se debe de asignar el programa academico correcto a la escuela que corresponde.

insert into escuela_has_prog_academico(Escuela_ID_Escuela, prog_academico_ID_Prog_Academico)
	values('','');
*/


/*Inserta datos en la Tabla ALUMNO*/    
INSERT INTO `RIDESCOM`.`Alumno` (`ID_Alumno`, `Inscrito`, `Persona_ID_Persona`, `Escuela_has_Prog_Academico_Escuela_ID_Escuela`, `Escuela_has_Prog_Academico_Prog_Academico_ID_Prog_Academico`)
	VALUES ('2015630443', '5VC1', 4, 7, 18);
    

/*Inserta datos en la Tabla SEDE*/   
INSERT INTO Sede (`Nombre_S`, `Calle`, `Colonia`, `Numero`, `CP`, `Municipio_ID_Municipio`, `Municipio_Estados_ID_estado`) 
	VALUES ('Cancha Futbol 7', 'Calle Luis Enrique Erro', 'Zacatenco', NULL, '07738', '0221', '07'); 


/*Inserta datos en la Tabla de ESCUELA_ACT_DEPORTIVA*/    
INSERT INTO Escuela_Act_Deportiva(`Escuela_ID_Escuela`, `Act_Deportiva_ID_Deporte`, `Ciclo_ID_Ciclo`) 
	VALUES (7, 1, 4);


/*
Inserta datos en la tabla TIPO_PRUEBA
INSERT INTO Tipo_Pruebas (`ID_Tipo`, `Tipo`) 
	VALUES (3, 'Individual');
*/


/*Inserta datos en la tabla PRUEBAS (Tipo_Prueba: 1=Individual, 2=Equipo)*/
INSERT INTO Pruebas(Prueba, Tipo_Pruebas_ID_Prueba, Act_Deportiva_ID_Deporte)
	values('100 m.', '1', '4');
    

/*Inserta datos en la tabla EVENTO*/
INSERT INTO Evento(Nombre_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Descripcion, Fecha_Evento, Ciclo_ID_Ciclo, Act_Deportiva_ID_Deporte, Sede_ID_Sede)
	values('Evento Interpolitécnico Deportivo de Atletismo', left(now(),10), '2019-10-24', 'El evento esta dirigido para aquellos', '2019-10-30', '1', '4', '1');

select * from alumno;
/*Inserta datos en la tabla INSCRIPCION*/
INSERT INTO Inscripcion(Alumno_ID_Alumno, Evento_Evento_ID, Escuela_ID_Escuela)
	VALUES('2015600297','1','7');
    

/*Inserta datos en la tabla de CEDULA*/    
INSERT INTO Cedula(Inscripcion_Alumno_ID_Alumno, Inscripcion_Evento_Evento_ID)
	values('2015630297','1');
    
select * from evento;    
/*Inserta datos en la tabla RESULTADOS*/    
INSERT INTO Resultados(Lugar_Obtenido, Marca, Inscripcion_Alumno_ID_Alumno, Inscripcion_Evento_Evento_ID)
	Values('3', '1:35 seg.', '2015630297', '1');

