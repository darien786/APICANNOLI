create database cursos_db;
use cursos_db;

drop database cursos_db;

create table cursos(idCurso int primary key auto_increment not null, 
nomenclatura varchar(10) not null unique,
nombre varchar(50) not null,
fechaRealizacion date not null,
catalogo int null,
estatus int null,
foreign key (catalogo) references catalogos(idCatalogo),
foreign key (estatus) references estatus(idEstatus)
);

create table usuarios(username varchar(20) primary key not null,
password varchar(20) not null,
nombreUsuario varchar(15) not null,
apellidoPaterno varchar(15) not null,
apellidoMaterno varchar(15) not null
);

create table modalidades(idModalidad int primary key auto_increment not null, 
nombreModalidad varchar(20) not null
);

create table modalidad_curso (idCurso int not null,
idModalidad int not null,
fichaTecnica int,
cartaDescriptiva int,
foreign key (idCurso) references cursos(idCurso),
foreign key (idModalidad) references modalidades(idModalidad),
foreign key (fichaTecnica) references fichasTecnicas(idFichaTecnica),
foreign key (cartaDescriptiva) references cartasDescriptivas(idCartaDescriptiva),
primary key (idCurso, idModalidad)
);

show tables;

create table fichasTecnicas(idFichaTecnica int primary key auto_increment not null,
descripcion varchar(2) not null);

create table cartasDescriptivas(idCartaDescriptiva int primary key auto_increment not null,
descirpcion varchar(2) not null);

create table catalogos (idCatalogo int primary key not null,
descripcion varchar(2) not null
);

create table estatus(idEstatus int primary key not null,
nombreEstatus varchar(15) not null
);

create table paquetes (idPaquete int primary key not null,
nombrePaquete varchar(50) not null
);

create table paquete_curso(idPaquete int not null, 
idCurso int not null, 
foreign key (idPaquete) references paquetes(idPaquete),
foreign key (idCurso) references cursos(idCurso),
primary key (idPaquete, idCurso));

INSERT INTO estatus (idEstatus, nombreEstatus) 
VALUES (1, 'Curso completo'), (2, 'Curso parcial');

INSERT INTO catalogos (idCatalogo, descripcion) 
VALUES(1, 'si'), (2, 'no'); 


show tables;