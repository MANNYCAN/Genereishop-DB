use genereishop;

show tables;

INSERT INTO adress VALUES 
(NULL, 'Ciudad de México', 01120, 'Avenida Insurgentes', '300', '1'),
(NULL, 'Guadalajara', 44100, 'Calle López Cotilla', '123', '3'),
(NULL, 'Monterrey', 64000, 'Calle Hidalgo', '567', '2'),
(NULL, 'Tijuana', 22000, 'Boulevard Agua Caliente', '89', '0'),
(NULL, 'Puebla', 72000, 'Avenida Juárez', '45', '3');

SELECT * FROM adress;

INSERT INTO `user` (userName,userPhone,userEmail,userPassword,userId,Adress_adressId)
values 
('Ivan Roman Arratia Garcia',5560894356,'ivandrago35678@gmail.com','Pa$$w0rd',null,1),
('Luis Fernando Pedraza Estañol',9944885566,'luisf.pedrazae@gmail.com','Pa$$w0rd',null,2),
('Angel Omar Andrade Linares',5560322849,'angelandrade.unam@gmail.com','Pa$$w0rd',null,3),
('Efren Garnica Palacios',5635186488,'hola56@gmail.com', 'Pa$$w0rd',null,4),
('Victor Manuel Arena Cantoran',5552145250,'varenac@gmail.com','Pa$$w0rd',null,5);

SELECT * FROM user;

INSERT INTO product VALUES 
(null,'Calcetas','Calcetas Transpirables-Gris',100,20,'./assets/calcetas 1.jpg'),
(null,'Short','Short diseñado para correr - Gris',250,30,'./assets/short 1.jpg'),
(null,'Blusa','Blusa diseñada para ejercicios de yoga - Negro',300,10,'./assets/sud 5.jpg'),
(null,'Sudadera para mujer','Sudadera deportiva para toda ocasión - Verde',250,15,'./assets/sud 1.jpg'),
(null,'Suéter térmico','Suéter térmico para soportar temperaturas frías - Negro',300,16,'./assets/sud 2.jpg');

select * FROM product;

INSERT INTO `order` VALUES
(null,"2024-10-04",1),
(null,"2024-07-04",2),
(null,"2024-10-02",3),
(null,"2024-08-09",4),
(null,"2024-08-31",5)
;

select * FROM `order`;

INSERT INTO `order_has_product` VALUES 
(12,15,1),
(11,11,11),
(2,4,7),
(2,3,5),
(6,6,6);

SELECT * FROM `order_has_product`;



