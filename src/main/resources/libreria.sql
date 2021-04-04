DROP TABLE if exists venta;
drop table if exists libro_sucursal;
drop table if exists libro;
drop table if exists sucursal;
DROP TABLE if EXISTS authorities;
DROP TABLE if EXISTS users;



create table libro (
    id int auto_increment,
    nombre varchar(200) not null,
    autor VARCHAR(200),
    precio DOUBLE,
    PRIMARY KEY (id)
);

insert into libro (id,nombre,autor,precio) values
(1,'libro español','SEP',150.0),
(2,'libro matematicas','SEV',120.0),
(3,'libro cocina','SEV',100.0),
(4,'libro ingles','Open english',450.0);


create table sucursal(
    id int primary key auto_increment,
    nombre_sucursal varchar(200) not NULL
);

insert into sucursal(id,nombre_sucursal) values
(1,'Sucursal Tlalpan'),
(2,'Sucursal Zocalo'),
(3,'Sucursal Coyoacan');


create table libro_sucursal(
    id int primary key auto_increment,
    libro_id int NOT NULL,
    sucursal_id int NOT NULL,
    disponible int,
    FOREIGN KEY (libro_id) REFERENCES libro (id),
    FOREIGN KEY (sucursal_id) REFERENCES sucursal (id)
);

insert into libro_sucursal(id,libro_id,sucursal_id,disponible) values
(1,1,1,1),
(2,1,1,0),
(3,2,3,1),
(4,3,2,1),
(5,1,3,1),
(6,4,1,1),
(7,2,1,0);


create table venta(
    id int primary key auto_increment,
	 fecha varchar(200),
	 total double
);

alter table venta
add column libro_sucursal_id int,
add foreign key(libro_sucursal_id) references  libro_sucursal(id);

INSERT INTO venta (id,fecha,total,libro_sucursal_id) VALUES 
(1,"01/04/2021",150.0,1),
(2,"30/03/2021",120.0,7);

create table users (
	username varchar(50) NOT NULL ,
	password varchar(100) NOT NULL ,
	enabled tinyint(4) NOT NULL DEFAULT '1',
	primary key (username) USING BTREE
);

create table authorities (
username VARCHAR(50) NOT NULL,
authority VARCHAR(50) NOT NULL,
FOREIGN KEY (username) REFERENCES users(username)
); 

CREATE UNIQUE INDEX ix_auth_username
  on authorities (username,authority);
  
   INSERT INTO users (username, password, enabled) values 
  ('user','$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',1),
  ('greck','$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',1),
  ('ventas','$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',1);
  
   
INSERT INTO authorities (username, authority)
  values ('user', 'ROLE_USER'),
  ('greck','ROLE_ADMIN'),
  ('ventas','ROLE_VENTAS');