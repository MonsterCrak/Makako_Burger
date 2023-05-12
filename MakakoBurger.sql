
drop database Makako_Burger;
create database Makako_Burger;
use Makako_Burger;

create table if not exists Distrito(
idDistrito int,
nomDistrito varchar(50),
constraint PKidDistrito primary key  (idDistrito)
);

create table if not exists ZonaReparto(
idZonaReparto int,
nombreZona varchar(100),
idDistrito int,
latitud varchar(100),
longitud varchar(100),
constraint PKIDZonaReparto primary key(idZonaReparto),
foreign key (idDistrito) references Distrito (idDistrito)
);

create table if not exists Establecimiento
(
idEstablecimiento int , 
nomEstablecimiento varchar(100),
telefonoEstablecimiento char(15),
idZonaReparto int,
SobreNosotros varchar(500),
constraint PKidEstablecimiento primary key  (idEstablecimiento),
foreign key (idZonaReparto) references ZonaReparto (idZonaReparto)
);


Create table if not exists Cargo
(
IdCargo int,
Cargo varchar (80) not null,
constraint PKIdCargo primary key (IdCargo)
);

create table if not exists DNI
(
Dni Char(8) unique not null,
constraint PKDNI Primary Key (DNI) 
);

CREATE TABLE if not exists Empleados (
    ID_Empleado INT,
    nom_Empleado VARCHAR(50),
    ape_Empleado VARCHAR(50),
    IdCargo int not null,
    fechaRegistro_Empleado datetime,
    telf_Empleado CHAR(15),
    Dni CHAR(8) not null,
    CONSTRAINT PKID_Empleado PRIMARY KEY (ID_Empleado),
    foreign key (IdCargo) references Cargo (IdCargo),
    foreign key (Dni) references DNI (Dni),
    FULLTEXT(nom_Empleado, ape_Empleado, telf_Empleado, Dni) -- PARA PODER REALIZAR EL MATCH
);

Create table if not exists Cliente
(
idCliente int not null,
nomCliente varchar (50) not null,
apeCliente varchar(50) not null,
Dni CHAR(8) not null,
foreign key (Dni) references DNI (Dni),
constraint PKCLI Primary Key (idCliente) 
);

create table if not exists tipoUsuario
(
idTipoUsuario int not null,
nomTipoUsuario varchar(50),
constraint idTipoUsuario primary key (idTipoUsuario)
);

create table if not exists Usuario
(
IdUsuario int not null,
idTipoUsuario int not null, 
Dni Char(8) unique null,
correo varchar(50) unique not null,
contraseña varchar(25) not null,
constraint IdUsuario primary key (IdUsuario),
FOREIGN KEY (idTipoUsuario) REFERENCES tipoUsuario (idTipoUsuario),
FOREIGN KEY (Dni) REFERENCES DNI (Dni)
);


create table if not exists Cat_Producto(
Id_CatProd int not null,
nombre_CatProd varchar(20) not null,
constraint PKID_CatProd primary key (Id_CatProd)
);


create table if not exists Producto(
codPro int,
nomPro varchar(50) not null,
precioPro decimal (8,2) not null,
Id_CatProd int not null,
imagenProd varchar(300) not null,
constraint codPro primary key (codPro),
foreign key (Id_CatProd) references Cat_Producto(Id_CatProd)  
);

create table if not exists Promocion(
codPromo int,
precioPromo decimal (8,2) not null,
nomPromo varchar(50) not null,
fechaVigencia date null, 
imagenCombo varchar(300) not null,
constraint PKcodPromo primary key (codPromo)
);

/*------------------------------------------------*/
create table if not exists DetallePromo(
codDetallePromo int not null,
codPromo int  not null,
codPro int not null,
cantidad int not null,
constraint PKcodDetallePromo primary key (codDetallePromo),
foreign key (codPromo) references  Promocion(codPromo),
foreign key (codPro) references Producto(codPro)
);

-- Listo --
create table if not exists MetPago(
codMetPago int,
NomTipoPago varchar(40) not null,

constraint PKCodMetPago primary key (codMetPago)
);

create table if not exists estadosPedido
(
codEstadoPedido int,
nomTipoEstado varchar(40) not null,
constraint PKCodEstadoPedido primary key (codEstadoPedido)
);

create table if not exists metodoRecojo
(
codMetodoRecojo int,
nomTipoRecojo varchar(40) not null,
constraint PKCodMetodoRecojo primary key(codMetodoRecojo)
);

-- Listo --
create table if not exists Pedido(
codPedido int,
fecPedido date not null,
idCliente int not null,
precTotPedido decimal(8,2) not null,
codEstadoPedido int,
codMetodoRecojo int,
codMetPago int not null,
constraint PKcodPedido primary key (codPedido),
FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente),
foreign key (codMetPago) references MetPago(codMetPago),
foreign key (codEstadoPedido) references estadosPedido(codEstadoPedido),
foreign key (codMetodoRecojo) references metodoRecojo(codMetodoRecojo)
);

create table if not exists Detalle_De_Pedido(
	numDetalle int not null,
    codPedido int not null,
    codPro int null,
    codPromo int null,
    cant int not null,
    precioPedidoTot decimal(8, 2),
    constraint PKnumDetalle primary key (numDetalle),
    foreign key (codPedido) references Pedido(codPedido),
    foreign key (codPro) references Producto(codPro),
    foreign key (codPromo) references Promocion(codPromo)
);

create table if not exists tipoReclamo(
idTipoReclamo int primary key not null,
nomTipoReclamo varchar(50) not null
);

-- jorge --
create table if not exists Reclamos(
    numReclamo int ,
    idPedido int,
    fechaReclamo date not null,
    idCliente int not null,
    idTipoReclamo int not null,
    descripcionReclamo  varchar(200) not null,
    constraint PKnumReclamo primary key (numReclamo),
    constraint FKtipoReclamo foreign key (idTipoReclamo) references tipoReclamo (idTipoReclamo),
    constraint FKpedido foreign key (idPedido) references Pedido (codPedido),
    FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente)
);

create table if not exists Comprobante_De_Pago(
	codComprobante int,
	idEstablecimiento int, 
	codPedido int,
    fecEmitido date not null,
    precTotPedido decimal(8,2) not null,
    precCostoEnvio decimal(8, 2) null,
	constraint PKcodComprobante primary key (codComprobante ),
    foreign key (idEstablecimiento) references Establecimiento(idEstablecimiento),
    foreign key (codPedido) references Pedido(codPedido)
);



create table if not exists Hoja_De_envio(
	codHojaEnvio int,
	codPedido int,
	idZonaReparto int,
	telefono varchar(15) not null,
    codEstadoPedido  int null,
	constraint PKcodHojaEnvio  primary key (codHojaEnvio),
	foreign key (codPedido) references Pedido(codPedido),
    foreign key (codEstadoPedido) references estadosPedido(codEstadoPedido),
    foreign key (idZonaReparto) references ZonaReparto(idZonaReparto)
);

insert into Distrito values(1, 'San Martin de Porres');
insert into zonaReparto values(1, 'Jiron Las Vascongadas 110 Urb. Los Girasoles - La Molina, 15024',1,'-11.939517189210175','-77.08463024528645');


insert into Establecimiento Values (1,'Makako Burger','966313252', 1,'Somos Makako Burguer
 un restuarante con una variedad de comida extensa, En ese momento 
 existían cadenas nacionales que ofrecían hamburguesas dentro de
 su menú, pero no se había desarrollado el hábito de consumo de 
 hamburguesa en el público peruano ni habían llegado al país las 
 grandes cadenas internacionales.');


insert into Cat_Producto values
(1, 'Hamburguesas'),
(2, 'Salchipapas'),
(3, 'Alitas'),
(4, 'Complementos'),
(5, 'Bebidas'),
(6, 'A la Carta');

insert into estadosPedido values
(1, 'Generado'),
(2, 'Atendido');

insert into metodoRecojo values
(1, 'Delivery'),
(2, 'En tienda');

insert into tipoUsuario values
(1, 'Empleado'),
(2, 'Cliente');

insert into Cargo values
(1, 'administrador'),
(2, 'Cajero'),
(3, 'Repartidor'),
(4, 'Gerente');

insert into DNI values
('77797607');


INSERT INTO Empleados VALUES
(1, 'Rodolfo Andre', 'Caballero Vilela', '1', curdate(), '924022741', '77797607');

INSERT INTO Usuario VALUES
(1, 1,'77797607', 'rcaballerov_10@outlook.com', 'admin');


select * from Usuario;
delete from Usuario where IdUsuario = 2;

INSERT INTO MetPago VALUES
(1, 'YAPE'),
(2, 'PLIN'),
(3, 'VISA'),
(4, 'MASTERCARD'),
(5, 'CRÉDITO');

insert into tipoReclamo values
(1,'Servicio'),
(2,'Producto');


select * from Producto;
/*----------------------------------------------------------------------------------------------------------*/
DELIMITER $$
CREATE PROCEDURE `sp_buscar_correo`(vCorreo VARCHAR(50))
BEGIN
	SELECT correo FROM Usuario 
    WHERE correo = vCorreo;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_cambiar_contraseña`(vContraseña VARCHAR(25), vCorreo VARCHAR(50))
BEGIN
	UPDATE Usuario SET contraseña = vContraseña
    WHERE correo = vCorreo;
END $$
DELIMITER ;

/*------------------------------- PROCEDIMIENTO ALMACENADO DE CATEGORÍA PRODUCTOS-------------------------------*/

DELIMITER $$
CREATE PROCEDURE `sp_listar_categoria_prod`()
BEGIN
	SELECT * FROM Cat_Producto;
END $$
DELIMITER ;

/*------------------------------- PROCEDIMIENTO ALMACENADO DE PRODUCTOS-------------------------------*/



DELIMITER $$
CREATE PROCEDURE `sp_listar_producto`(vConsulta varchar(255), vId_CatProd VARCHAR(10), vPrecioInicio DOUBLE, vPrecioFinal DOUBLE)
BEGIN
	SELECT P.*, C.nombre_CatProd  FROM Producto AS P JOIN Cat_Producto AS C
    ON C.Id_CatProd = P.Id_CatProd
	WHERE P.nomPro LIKE CONCAT("%", vConsulta,"%")
    AND C.Id_CatProd  LIKE CONCAT("%", vId_CatProd,"%") 
    AND P.precioPro BETWEEN IFNULL (vPrecioInicio, 0)
	AND IFNULL (vPrecioFinal, 999999);
END $$
DELIMITER ;






DELIMITER $$
CREATE PROCEDURE `sp_agregar_prod`
	(vIdProd int, vNom_prod VARCHAR(50), vPrecio_prod DECIMAL(7,2), vNom_Imagen VARCHAR(255), vId_CatProd int)
BEGIN
	INSERT Producto VALUES(vIdProd, vNom_prod, vPrecio_prod, vId_CatProd, vNom_Imagen);
END $$
DELIMITER ;



DELIMITER $$
CREATE PROCEDURE `sp_actualizar_prod`
	(vIdProd int, vNom_prod VARCHAR(50), vPrecio_prod DECIMAL(7,2), vNom_Imagen VARCHAR(255), vId_CatProd int)
BEGIN
	IF (vNom_Imagen <> NULL) THEN
		UPDATE Producto SET nomPro = vNom_prod, precioPro = vPrecio_prod, imagenProd = vNom_Imagen, Id_CatProd = vId_CatProd
		WHERE codPro = vIdProd;
	ELSE 
		UPDATE Producto SET nomPro = vNom_prod, precioPro = vPrecio_prod, Id_CatProd = vId_CatProd
		WHERE codPro = vIdProd;
    END IF;
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `sp_eliminar_prod`
	(vIdProd int)
BEGIN
	DELETE FROM Producto WHERE codPro = vIdProd;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_getLastIdProd`()
BEGIN
	SELECT P.codPro from Producto as P ORDER BY codPro DESC;
END $$
DELIMITER ;


/*------------------------------- PROCEDIMIENTO ALMACENADO DE Promociones-------------------------------*/

DELIMITER $$
CREATE PROCEDURE `sp_getLastIdPromo`()
BEGIN
	SELECT P.codPromo from Promocion as P ORDER BY codPromo DESC;
END $$
DELIMITER ;

call sp_getLastIdPromo();

DELIMITER $$
CREATE PROCEDURE `sp_getLastIdDetallePromo`()
BEGIN
	SELECT P.codDetallePromo from DetallePromo as P ORDER BY codDetallePromo DESC;
END $$
DELIMITER ;
call sp_getLastIdDetallePromo();

SELECT P.codPromo from Promocion as P ORDER BY codPromo DESC;


DELIMITER $$
CREATE PROCEDURE `sp_agregar_promocion`
	(vNom_promo VARCHAR(50), vPrecio_promo DECIMAL(7,2), vfechaVigencia date,  vruta_Imagen VARCHAR(255), vcodPro int, vCantidad int)
BEGIN

	SET @id  = IFNULL((SELECT codPromo + 1 FROM Promocion ORDER BY codPromo DESC LIMIT 1), 1);
	SET @id2  = IFNULL((SELECT codDetallePromo + 1 FROM DetallePromo ORDER BY codDetallePromo DESC LIMIT 1), 1);

	INSERT Promocion VALUES(@id, vPrecio_promo, vNom_promo, vfechaVigencia, vruta_Imagen);
	INSERT DetallePromo VALUES(@id2, @id,  vcodPro, vCantidad);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_actualizar_promo`
    (vnomPromo varchar(50), vPrecio_promo DECIMAL(7,2), vfechaVigencia date,  vruta_Imagen VARCHAR(255), vcodPromo int)
BEGIN
        IF (vruta_Imagen <> NULL) THEN
            UPDATE Promocion SET precioPromo  = vPrecio_promo, fechaVigencia = vfechaVigencia, imagenCombo = vruta_Imagen, nomPromo = vnomPromo
            WHERE codPromo = vcodPromo;
        ELSE 
            UPDATE Promocion SET precioPromo  = vPrecio_promo, fechaVigencia = vfechaVigencia, nomPromo = vnomPromo
            WHERE codPromo = vcodPromo;
        END IF;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_eliminar_promo`
	(vIdPromo int)
BEGIN
	DELETE FROM DetallePromo where codPromo = vIdPromo;
	DELETE FROM Promocion WHERE codPromo = vIdPromo;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_listar_promocion`(vConsulta varchar(255), vPrecioInicio DOUBLE, vPrecioFinal DOUBLE, vFechaInicio date, vFechaFinal date)
BEGIN
	SELECT P.*  FROM Promocion AS P 
	WHERE P.nomPromo LIKE CONCAT("%", vConsulta,"%")
    AND P.precioPromo BETWEEN IFNULL (vPrecioInicio, 0)
	AND IFNULL (vPrecioFinal, 999999)
    AND P.fechaVigencia BETWEEN IFNULL (vFechaInicio, '2000-01-01')
    AND IFNULL (vFechaFinal, '3000-01-01')
    ORDER BY codPromo;
END $$
DELIMITER ;

select * from promocion;
call sp_listar_promocion('', NULL, null, '2022-10-11', null);

DELIMITER $$
CREATE PROCEDURE `sp_listar_Detallepromocion`(vIdPromo VARCHAR(10))
BEGIN
    SELECT D.*, P.nomPro, P.Id_CatProd, C.nombre_CatProd, P.imagenProd FROM DetallePromo AS D
    JOIN Producto as P on P.codPro = D.codPro
    JOIN Cat_Producto as C on C.Id_CatProd = P.Id_CatProd
    WHERE D.codPromo LIKE IF(vIdPromo IS NULL OR vIdPromo = "", "%%" ,vIdPromo);
END $$
DELIMITER ;

call sp_listar_Detallepromocion('2');

DELIMITER $$
CREATE PROCEDURE `sp_ActualizarDetallePromo`(vIdPromo int, vcodPro int, vCantidad int, vTipoOp int)
BEGIN
	CASE
    WHEN vTipoOp = 1 THEN
	SELECT @id :=  codDetallePromo  FROM DetallePromo  ORDER BY codDetallePromo  DESC LIMIT 1;
    INSERT DetallePromo VALUES(@id + 1, vIdPromo, vcodPro, vCantidad);
    WHEN vTipoOp = 2 THEN
    UPDATE DetallePromo set cantidad = vCantidad
    where codPromo = vIdPromo AND codPro = vcodPro;
    WHEN vTipoOp = 3 THEN
    DELETE FROM DetallePromo WHERE codPromo = vIdPromo AND codPro = vcodPro;
    END CASE;
END $$
DELIMITER ;


/*------------------------------- PROCEDIMIENTO ALMACENADO De Usuarios-------------------------------*/
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Iniciar_Sesión`(cCorreo varchar(50),cClave varchar(25))
BEGIN
select u.IdUsuario,t.idTipoUsuario,d.Dni,u.correo,u.contraseña
    from Usuario as u inner join tipoUsuario as t
    on u.idTipoUsuario=t.idTipoUsuario
    inner join Dni as d 
    on u.Dni=d.Dni
    where u.correo=cCorreo and u.contraseña=cClave;

END $$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Listar_Usuario`()
BEGIN
select*from Usuario;
END $$
DELIMITER ;
/*------------------------------- PROCEDIMIENTO ALMACENADO DE Empleados-------------------------------*/



DELIMITER $$
CREATE PROCEDURE `sp_listar_empleado`(vConsulta VARCHAR(255), vIdCargo VARCHAR(10), vFechaInicio DATETIME, vFechaFinal DATETIME)
BEGIN
	IF (vConsulta <> '') THEN
		SELECT E.*, C.Cargo, U.IdUsuario, U.correo FROM Empleados AS E JOIN
		Usuario AS U ON U.Dni = E.Dni JOIN Cargo AS C
		ON C.IdCargo = E.IdCargo WHERE MATCH (nom_Empleado, ape_Empleado, telf_Empleado, E.Dni) 
        AGAINST (CONCAT(vConsulta,'*')  IN BOOLEAN MODE) 
        AND C.IdCargo LIKE CONCAT("%", vIdCargo,"%")
		AND E.fechaRegistro_Empleado BETWEEN IFNULL (vFechaInicio, '2000-01-01')
		AND IFNULL (vFechaFinal, '2024-10-10')
        ORDER BY ID_Empleado; 
	ELSE 
		SELECT E.*, C.Cargo, U.IdUsuario, U.correo FROM Empleados AS E JOIN
		Usuario AS U ON U.Dni = E.Dni JOIN Cargo AS C
		ON C.IdCargo = E.IdCargo 
        WHERE C.IdCargo LIKE CONCAT("%", vIdCargo,"%") 
		AND E.fechaRegistro_Empleado BETWEEN IFNULL (vFechaInicio, '2000-01-01')
		AND IFNULL (vFechaFinal, '2024-10-10')
        ORDER BY ID_Empleado; 
    END IF;
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `sp_agregar_empleado`
	(vCorreo VARCHAR(50), vContraseña VARCHAR(25), vNom_Empleado VARCHAR(50), vApe_Empleado VARCHAR(50), 
	vTelf_Empleado CHAR(15), vDni_empleado CHAR(8), vIdCargo INT, vFechaRegistro_Empleado DATETIME)
BEGIN
	SELECT @id :=  ID_Empleado  FROM Empleados  ORDER BY ID_Empleado  DESC LIMIT 1;
    select @id2:=IdUsuario from usuario order by IdUsuario desc limit 1;
    INSERT DNI VALUES(vDni_empleado);
    INSERT Empleados VALUES(@id+1, vNom_Empleado, vApe_Empleado, vIdCargo, vFechaRegistro_Empleado, vTelf_Empleado, vDni_empleado);
	INSERT Usuario VALUES(@id2 + 1, 1, vDni_empleado, vCorreo, vContraseña);
END $$
DELIMITER ;



DELIMITER $$
CREATE PROCEDURE `sp_actualizar_empleado`
	(vIdUsuario INT, vIdEmpleado int, vCorreo VARCHAR(50), vNom_Empleado VARCHAR(50), vApe_Empleado VARCHAR(50), vTelf_Empleado CHAR(15), 
	vIdCargo int)
BEGIN
	UPDATE Usuario SET correo = vCorreo WHERE IdUsuario = vIdUsuario;
    UPDATE Empleados SET nom_Empleado = vNom_Empleado, ape_Empleado = vApe_Empleado, telf_Empleado = vTelf_Empleado, IdCargo = vIdCargo 
		WHERE ID_Empleado = vIdEmpleado;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_eliminar_empleado`(vIdUsuario INT, vIdEmpleado int, vDni varchar(8))
BEGIN
	DELETE FROM Usuario WHERE IdUsuario = vIdUsuario;
    DELETE FROM Empleados WHERE ID_Empleado = vIdEmpleado;
    DELETE FROM DNI WHERE Dni = vDni;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_getLastIdEmpleado`()
BEGIN
	SELECT E.ID_Empleado from Empleados as E ORDER BY ID_Empleado DESC;
END $$
DELIMITER ;


DELIMITER $$
CREATE PROCEDURE `sp_listar_cargo`()
BEGIN
	SELECT * FROM Cargo;
END $$
DELIMITER ;

/*------------------------------- PROCEDIMIENTO ALMACENADO DE DNI-------------------------------*/
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Listar_dni`()
BEGIN
select*from dni;
END $$
DELIMITER ;

/*------------------------------- PROCEDIMIENTO ALMACENADO DE Clientes -------------------------------*/
DELIMITER $$ 
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Insert_cliente`(cNombre varchar(50),cApellido varchar(50),cDni char(8),cCorreo varchar(50),cContraseña varchar(25))
BEGIN
Start transaction;
set @id=ifnull((select IdCliente from cliente ORDER BY IdCliente DESC LIMIT 1),1);
set @id2=ifnull((select idUsuario from  usuario order by IdUsuario desc limit 1),1);
insert into Dni values(cDni);
insert into Cliente values(@id+1,cNombre,cApellido,cDni);
insert Usuario values(@id2+1,2,cDni,cCorreo,cContraseña);
commit;
rollback;

END $$
DELIMITER ; 
/*------------------------------- PROCEDIMIENTO ALMACENADO DE Establecimiento-------------------------------*/

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_listar_establecimiento`()
BEGIN
SELECT E.*, D.nomDistrito, Z.nombreZona FROM Establecimiento AS E 
JOIN ZonaReparto as Z on Z.idZonaReparto  = E.idZonaReparto 
JOIN Distrito as D on D.idDistrito  = Z.idDistrito;
END $$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_establecimiento`(vId int, vSobreNosotros varchar(500))
BEGIN
    update Establecimiento set SobreNosotros =  vSobreNosotros
    where idEstablecimiento = vId;
END $$
DELIMITER ;


/*--------------------------- PROCEDIMIENTO ALMACENADOS DE PEDIDOS --------------------------------------*/ 
DELIMITER $$
CREATE PROCEDURE `sp_listar_pedidos`(vConsulta varchar(255), vFechaInicio DATETIME, vFechaFinal DATETIME, vEstadoPedido varchar(30))
BEGIN
	SELECT P.*, E.nomTipoEstado, M.NomTipoPago, R.nomTipoRecojo, C.nomCliente, C.apeCliente from Pedido as P
    JOIN MetPago AS M ON M.codMetPago = P.codMetPago
    JOIN metodoRecojo AS R on R.codMetodoRecojo = P.codMetodoRecojo
    JOIN estadosPedido as E ON E.codEstadoPedido = P.codEstadoPedido
    JOIN Cliente as C on C.idCliente = P.idCliente
    WHERE C.Dni LIKE CONCAT("%", vConsulta, "%")
    AND P.fecPedido BETWEEN IFNULL (vFechaInicio, '2000-01-01')
	AND IFNULL (vFechaFinal, CURDATE())
    AND P.codEstadoPedido LIKE CONCAT("%", vEstadoPedido, "%")
    ORDER BY P.codPedido;
END $$
DELIMITER ;



DELIMITER $$
CREATE PROCEDURE `sp_listar_detalle_pedidos_productos`(vCodPromo varchar(255))
BEGIN
	SELECT D.numDetalle, D.codPedido, D.codPro, D.cant, D.precioPedidoTot, P.nomPro, P.precioPro, P.Id_CatProd, C.nombre_CatProd, P.imagenProd FROM Detalle_De_Pedido as D
	JOIN Producto as P on P.codPro = D.codPro
	JOIN Cat_Producto as C on C.Id_CatProd = P.Id_CatProd
	where D.codPedido LIKE IF(vCodPromo is null or vCodPromo = "", "%%", vCodPromo)
	AND D.codPro <> 0;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_listar_detalle_pedidos_promos`(vCodPromo varchar(255))
BEGIN
	SELECT  D.numDetalle, D.codPedido, D.codPromo, D.cant, D.precioPedidoTot, P.precioPromo, P.nomPromo, P.fechaVigencia, P.imagenCombo FROM Detalle_De_Pedido as D
    JOIN Promocion as P on P.codPromo = D.codPromo
	where D.codPedido LIKE IF(vCodPromo is null or vCodPromo = "", "%%", vCodPromo) 
    AND D.codPromo <> 0;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_actualizar_pedido`(vEstado int, vCod int)
BEGIN
	UPDATE Pedido set codEstadoPedido = vEstado 
    WHERE codPedido = vCod; 
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_agregar_pedido`(vidCliente int, vprecTot decimal (8,2), vmetRecojo int, vmetPago int)
BEGIN
	SET @id  = IFNULL((SELECT codPedido + 1 FROM Pedido ORDER BY codPedido DESC LIMIT 1), 1);
    INSERT Pedido VALUES(@id, curdate(), vidCliente, vprecTot, 1, vmetRecojo, vmetPago);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_agregar_detalle_pedido`(vcodProd int, vcodPromo int, vcant int, vprecioPedidoTot decimal(8,2))
BEGIN
	SET @id  = IFNULL((SELECT codPedido FROM Pedido ORDER BY codPedido DESC LIMIT 1), 1);
    SET @id2  = IFNULL((SELECT numDetalle  + 1 FROM Detalle_De_Pedido ORDER BY numDetalle  DESC LIMIT 1), 1);
    IF(vcodProd <> 0)
    THEN
        INSERT Detalle_De_Pedido values(@id2, @id, VcodProd, null, vcant, vprecioPedidoTot);
	END IF;
    IF(vcodPromo <> 0)
    THEN
        INSERT Detalle_De_Pedido values(@id2, @id, null, vcodPromo, vcant, vprecioPedidoTot);
	END IF;
    
END $$
DELIMITER ;


/*--------------------------- PROCEDIMIENTO ALMACENADOS DE MÉTODOS DE PAGO --------------------------------------*/
DELIMITER $$
CREATE PROCEDURE `sp_listar_metPago`()
BEGIN
	Select * from MetPago;
END $$
DELIMITER ;

/*--------------------------- PROCEDIMIENTO ALMACENADOS DE ESTADOS DE PEDIDO--------------------------------------*/
DELIMITER $$
CREATE PROCEDURE `sp_listar_estadosPedido`()
BEGIN
	Select * from estadosPedido;
END $$
DELIMITER ;

/*--------------------------- PROCEDIMIENTO ALMACENADOS DE MÉTODOS DE RECOJO--------------------------------------*/
DELIMITER $$
CREATE PROCEDURE `sp_listar_metRecojo`()
BEGIN
	Select * from metodoRecojo;
END $$
DELIMITER ;



/*--------------------------- PROCEDIMIENTO ALMACENADOS DE RECLAMOS--------------------------------------*/
DELIMITER $$
CREATE PROCEDURE `sp_registrar_Reclamo`
    (vidPedido int, vfechaReclamo DATETIME, vidCliente int, vidTipoReclamo int, vdescripReclamo varchar(8000))
BEGIN
    SET @id =  IFNULL((SELECT numReclamo + 1 FROM Reclamos ORDER BY numReclamo DESC LIMIT 1), 1);
    INSERT Reclamos VALUES(@id, vidPedido, vfechaReclamo, vidCliente, vidTipoReclamo, vdescripReclamo);
    
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_listar_reclamo`(vDni VARCHAR(255), vIdTipoReclamo VARCHAR(10), vFecInicio DATE, vFecFinal DATE)
BEGIN
	SELECT R.*, CL.DNI, TR.nomTipoReclamo FROM Reclamos AS R 
    JOIN Cliente AS CL ON CL.idCliente = R.idCliente  
    JOIN TipoReclamo AS TR ON R.idTipoReclamo = TR.idTipoReclamo
    WHERE CL.Dni LIKE CONCAT("%", vDni, "%")
    AND R.idTipoReclamo LIKE CONCAT("%", vIdTipoReclamo,"%")
    AND R.fechaReclamo  BETWEEN IFNULL(vFecInicio, "2000-01-01")
    AND IFNULL(vFecFinal, NOW());
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_listar_tipo_reclamo`()
BEGIN
	SELECT * FROM TipoReclamo;
END $$
DELIMITER ;

/*--------------------------- PROCEDIMIENTO ALMACENADOS DE CLIENTES--------------------------------------*/
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Listar_Cliente` ()
BEGIN
select*from Cliente;
END$$
DELIMITER ;

/*--------------------------- PROCEDIMIENTO ALMACENADOS DE CDP--------------------------------------*/
DELIMITER $$
CREATE PROCEDURE `sp_listar_cdp`(vDni varchar(255), vFecInicio DATE, vFecFinal DATE, vPrecioInicio DOUBLE, vPrecioFinal DOUBLE)
BEGIN
	SELECT C.*, CL.DNI FROM Comprobante_De_Pago AS C 
    JOIN Pedido AS P ON C.codPedido  = P.codPedido 
    JOIN Cliente AS CL ON CL.idCliente = P.idCliente  
    WHERE CL.Dni LIKE CONCAT("%", vDni, "%")
    AND C.fecEmitido  BETWEEN IFNULL(vFecInicio, "2000-01-01")
    AND IFNULL(vFecFinal, NOW())
	AND C.precTotPedido BETWEEN IFNULL(vPrecioInicio, 0)
	AND IFNULL (vPrecioFinal, 999999);
END $$
DELIMITER ;

call sp_listar_cdp('', null, null, null, null);

DELIMITER $$
CREATE PROCEDURE `sp_agregar_cdp`(vprecTotPedido decimal(8,2), vprecCostoEnvio decimal(8,2))
BEGIN
	SET @id  = IFNULL((SELECT codPedido FROM Pedido ORDER BY codPedido DESC LIMIT 1), 1);
    SET @id2  = IFNULL((SELECT codComprobante   + 1 FROM Comprobante_De_Pago ORDER BY codComprobante   DESC LIMIT 1), 1);
    INSERT Comprobante_De_Pago values(@id2, 1, @id, CURDATE(), vprecTotPedido, vprecCostoEnvio);
END $$
DELIMITER ;

/*--------------------------- PROCEDIMIENTO ALMACENADOS DE HOJA DE ENVIO--------------------------------------*/
DELIMITER $$
CREATE PROCEDURE `sp_agregar_hojaEnvio`(vidZonaReparto int, vtelefono varchar(50))
BEGIN
	SET @id  = IFNULL((SELECT codPedido FROM Pedido ORDER BY codPedido DESC LIMIT 1), 1);
    SET @id2  = IFNULL((SELECT codHojaEnvio    + 1 FROM Hoja_De_envio ORDER BY codHojaEnvio    DESC LIMIT 1), 1);
    INSERT Hoja_De_envio values(@id2, @id, vidZonaReparto, vtelefono, 1);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_actualizar_hoja_Envio`(vEstado int, vCod int)
BEGIN
	UPDATE Hoja_De_envio SET codEstadoPedido  = vEstado
    WHERE codPedido = vCod;
	UPDATE Pedido set codEstadoPedido = vEstado 
    WHERE codPedido = vCod; 
END $$
DELIMITER;


DELIMITER $$
CREATE PROCEDURE `sp_listar_hoja_envio`(vidZona varchar(50), vEstadoPedido varchar(50))
BEGIN
	SELECT H.*, Z.nombreZona, D.idDistrito , D.nomDistrito, E.nomTipoEstado FROM Hoja_De_envio as H
    JOIN ZonaReparto AS Z ON Z.idZonaReparto = H.idZonaReparto 
    JOIN Distrito AS D ON D.idDistrito  = Z.idDistrito
    JOIN estadosPedido AS E ON E.codEstadoPedido = H.codEstadoPedido
    WHERE Z.nombreZona  LIKE IF(vidZona is null or vidZona = "", "%%", vidZona) 
    AND  H.codEstadoPedido  LIKE IF(vEstadoPedido is null or vEstadoPedido = "", "%%", vEstadoPedido)
    ORDER BY H.codHojaEnvio ASC; 
END $$
DELIMITER ;


/*--------------------------- PROCEDIMIENTO ALMACENADOS DE ZONA DE REPARTO--------------------------------------*/
DELIMITER $$
CREATE  PROCEDURE `sp_Listar_ZonaDeReparto`(vidDistrito varchar(50),zNombreZona varchar(100))
BEGIN
    select z.*,d.nomDistrito from ZonaReparto as z join Distrito as d
    on z.idDistrito=d.idDistrito
    where z.idDistrito like if(vidDistrito is null or vidDistrito="","%%",vidDistrito)
    AND z.nombreZona like if(zNombreZona is null or zNombreZona="","%%",zNombreZona);
END $$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=root@localhost PROCEDURE sp_DeleteZonaReparto(id int)
BEGIN
        delete from  ZonaReparto where idZonaReparto=id;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_Insert_ZonaDeReparto`(nombreZona varchar(100),distrito varchar(50),latitud varchar(100),longitud varchar(100))
BEGIN
	set @encontrado=(select idDistrito from distrito where upper(nomDistrito)=upper(distrito) limit 1);
    set @id2=ifnull((select idZonaReparto from ZonaReparto order by idZonaReparto desc limit 1),1);
    if(@encontrado is not null or @encontrado <>"")then 
		insert into ZonaReparto values(@id2+1,nombreZona,@encontrado,latitud,longitud);
    else 
		SET @id=IFNULL((SELECT idDistrito FROM Distrito ORDER BY idDistrito DESC LIMIT 1), 1);
         insert into Distrito values(@id+1,distrito);
         insert into ZonaReparto values(@id2+1,nombreZona,@id+1,latitud,longitud);
		end if;
END $$
DELIMITER ;

/*--------------------------- PROCEDIMIENTO ALMACENADOS DE DISTRITOS--------------------------------------*/
DELIMITER $$
CREATE  PROCEDURE `sp_Listar_Distrito`()
BEGIN
    select*from Distrito;
END $$
DELIMITER ;

/*--------------------------- PROCEDIMIENTO ALMACENADOS DE REPORTES--------------------------------------*/
DELIMITER $$
CREATE PROCEDURE `sp_generar_cdp_reporte_productos`(vcodComprobante int)
BEGIN
	SELECT C.codPedido, Cli.Dni, MeP.NomTipoPago, MeR.nomTipoRecojo, Pro.nomPro, Pro.precioPro, C.precTotPedido, C.fecEmitido, Det.cant FROM Comprobante_De_Pago AS C
    JOIN Pedido as Pe on Pe.codPedido = C.codPedido 
    JOIN Cliente AS Cli on Cli.idCliente = Pe.idCliente
    JOIN MetPago AS MeP on Mep.codMetPago = Pe.codMetPago
    JOIN metodoRecojo as MeR on MeR.codMetodoRecojo = Pe.codMetodoRecojo
    JOIN Detalle_De_Pedido as Det on Det.codPedido = Pe.codPedido
    JOIN Producto as Pro on Pro.codPro = Det.codPro
    WHERE C.codComprobante  = vcodComprobante;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `sp_generar_cdp_reporte_promociones`(vcodComprobante int)
BEGIN
	SELECT C.codPedido, Cli.Dni, MeP.NomTipoPago, MeR.nomTipoRecojo, Pro.nomPromo, Pro.precioPromo, C.precTotPedido, C.fecEmitido, Det.cant FROM Comprobante_De_Pago AS C
    JOIN Pedido as Pe on Pe.codPedido = C.codPedido 
    JOIN Cliente AS Cli on Cli.idCliente = Pe.idCliente
    JOIN MetPago AS MeP on Mep.codMetPago = Pe.codMetPago
    JOIN metodoRecojo as MeR on MeR.codMetodoRecojo = Pe.codMetodoRecojo
    JOIN Detalle_De_Pedido as Det on Det.codPedido = Pe.codPedido
    JOIN Promocion as Pro on Pro.codPromo  = Det.codPromo 
    WHERE C.codComprobante  = vcodComprobante;
END $$
DELIMITER ;

