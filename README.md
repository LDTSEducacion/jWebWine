Proyecto sobre informacion de botellas de vino, cavas...
Base de datos:

usuarios:idUsuario(int), usuario(VARCHAR), contraseña(VARBINARY), fechaCreacion(DATE), ultimoacceso(datetime), tipocuenta(smallint).

Comentario:idComentario(int), mensaje(text), botellaId(int), usuarioId(int)

Botella:idBotella(int), tipo(VARCHAR), origen(VARCHAR), envejecimiento(VARCHAR), descripcion(TEXT), imagen(MEDIUMBLOB), nombre(VARCHAR)

/-----------------------------------/

CREATE SCHEMA ProyectoBodegas;
USE ProyectoBodegas;

CREATE TABLE usuarios(
    idUsuario int PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(20) NOT NULL,
    passwd VARBINARY(8000),
    fechaCreacion DATE,
    ultimoacceso datetime,
    tipocuenta smallint
)ENGINE=InnoDB;

CREATE TABLE botellas(
    idBotella int PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(20) NOT NULL,
    origen VARCHAR(50),
    envejecimiento VARCHAR(20),
    descripcion text,
    imagen MEDIUMBLOB,
    nombre varchar(100) NOT NULL
)ENGINE=InnoDB;

CREATE TABLE comentarios(
    idComentario int PRIMARY KEY AUTO_INCREMENT,
    comentario text,
    botellaId int NOT NULL,
    usuarioId int NOT NULL,
    CONSTRAINT comentarios_botellas_fk FOREIGN KEY (botellaId) REFERENCES botellas(idBotella),
    CONSTRAINT comentarios_usuarios_fk FOREIGN KEY (usuarioId) REFERENCES usuarios(idUsuario)
)ENGINE=InnoDB;
    
    
/-----------------------------------/
