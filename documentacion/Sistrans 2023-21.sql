
--- Creacion del secuenciador
create sequence hotel_sequence;

CREATE TABLE TIPOS_USUARIOS
   (ID NUMBER, 
	NOMBRE VARCHAR2(255 BYTE) NOT NULL, 
	CONSTRAINT TIPOS_USUARIOS_PK PRIMARY KEY (ID));

ALTER TABLE TIPOS_USUARIOS
	ADD CONSTRAINT CK_TIPOUSURA_NOMBRE 
	CHECK (NOMBRE IN ('Administrador', 'Cliente', 'Gerente', 'Recepcionista', 'Empleado'))
ENABLE;

CREATE TABLE HOTELES 
   (ID NUMBER, 
	NOMBRE VARCHAR2(255 BYTE) NOT NULL, 
	ESTRELLAS NUMBER NOT NULL, 
	CONSTRAINT HOTELES_PK PRIMARY KEY (ID));

CREATE TABLE USUARIOS 
   (ID NUMBER, 
	NOMBRE VARCHAR2(255 BYTE) NOT NULL, 
	TIPO NUMBER NOT NULL, 
	CORREO_ELECTRONICO VARCHAR2(255 BYTE),
    ID_HOTEL NUMBER NOT NULL,
	CONSTRAINT USUARIOS_PK PRIMARY KEY (ID));
	
ALTER TABLE USUARIOS
ADD CONSTRAINT fk_a_tipos_usuario
    FOREIGN KEY (tipo)
    REFERENCES tipos_usuarios(id)
    ON DELETE CASCADE
ENABLE;

ALTER TABLE USUARIOS
ADD CONSTRAINT fk_a_hoteles
    FOREIGN KEY (id_hotel)
    REFERENCES hoteles(id)
    ON DELETE CASCADE
ENABLE;
    
CREATE TABLE PLANES_CONSUMO 
   (ID NUMBER, 
	TIPO VARCHAR2(255 BYTE) NOT NULL, 
	DESCUENTO_GENERAL NUMBER NOT NULL, 
    ID_HOTEL NUMBER NOT NULL,
    BEBIDAS_ILIMITADAS NUMBER NOT NULL,
    INTERNET_ILIMITADO NUMBER NOT NULL,
	CONSTRAINT PLANESCONS_PK PRIMARY KEY (ID));
    
ALTER TABLE PLANES_CONSUMO
ADD CONSTRAINT fk_plancons_a_hoteles
    FOREIGN KEY (id_hotel)
    REFERENCES hoteles(id)
    ON DELETE CASCADE
ENABLE;

ALTER TABLE PLANES_CONSUMO
ADD CONSTRAINT ck_bebidas_ilim
    CHECK (BEBIDAS_ILIMITADAS >=0 AND BEBIDAS_ILIMITADAS <= 1)
ENABLE;

ALTER TABLE PLANES_CONSUMO
ADD CONSTRAINT ck_internet_ilim
    CHECK (INTERNET_ILIMITADO >=0 AND INTERNET_ILIMITADO <= 1)
ENABLE;

CREATE TABLE TIPOS_HABITACIONES
   (ID NUMBER, 
	NOMBRE VARCHAR2(255 BYTE) NOT NULL, 
	CONSTRAINT TIPOS_HABITACIONES_PK PRIMARY KEY (ID));
	
ALTER TABLE TIPOS_HABITACIONES
	ADD CONSTRAINT UN_TIPOHABIT_NOMBRE 
	UNIQUE (NOMBRE)
ENABLE;

ALTER TABLE TIPOS_HABITACIONES
	ADD CONSTRAINT CK_TIPOHABIT_NOMBRE 
	CHECK (NOMBRE IN ('Presidencial', 'Suite', 'Familiar', 'Doble', 'Sencilla'))
ENABLE;

CREATE TABLE HABITACIONES 
   (ID NUMBER, 
	TIPO NUMBER NOT NULL, 
    CAPACIDAD NUMBER NOT NULL,
    PRECIO_HABITACION NUMBER NOT NULL,
    PRECIO_MINIBAR NUMBER NOT NULL,
    CONSUMOS_TIENDA NUMBER NOT NULL,
    ESTA_OCUPADA NUMBER NOT NULL,
	CONSTRAINT HABITACIONES_PK PRIMARY KEY (ID));
    
ALTER TABLE HABITACIONES
ADD CONSTRAINT fk_a_tipos_habitaciones
    FOREIGN KEY (tipo)
    REFERENCES tipos_habitaciones(id)
    ON DELETE CASCADE
ENABLE;

ALTER TABLE HABITACIONES
ADD CONSTRAINT ck_esta_ocup
    CHECK (ESTA_OCUPADA >=0 AND ESTA_OCUPADA <= 1)
ENABLE;

CREATE TABLE RESERVAS_HABITACIONES 
   (ID NUMBER, 
	NUM_PERSONAS NUMBER NOT NULL, 
	TIPO_PLAN NUMBER NOT NULL, 
    DIA_ENTRADA NUMBER NOT NULL,
    MES_ENTRADA NUMBER NOT NULL,
    ANIO_ENTRADA NUMBER NOT NULL,
    DIA_SALIDA NUMBER NOT NULL,
    MES_SALIDA NUMBER NOT NULL,
    ANIO_SALIDA NUMBER NOT NULL,
    ID_USUARIO NUMBER NOT NULL,
    ID_HABITACION NUMBER NOT NULL,
	CONSTRAINT RESERVASHAB_PK PRIMARY KEY (ID));
    
ALTER TABLE RESERVAS_HABITACIONES
ADD CONSTRAINT fk_a_planes_consumo
    FOREIGN KEY (tipo_plan)
    REFERENCES planes_consumo(id)
    ON DELETE CASCADE
ENABLE;

ALTER TABLE RESERVAS_HABITACIONES
ADD CONSTRAINT fk_a_usuarios
    FOREIGN KEY (id_usuario)
    REFERENCES usuarios(id)
    ON DELETE CASCADE
ENABLE;

ALTER TABLE RESERVAS_HABITACIONES
ADD CONSTRAINT fk_a_habitaciones
    FOREIGN KEY (id_habitacion)
    REFERENCES habitaciones(id)
    ON DELETE CASCADE
ENABLE;

CREATE TABLE SERVICIOS 
   (ID NUMBER, 
	PRECIO_UNITARIO NUMBER NOT NULL,
    ID_HOTEL NUMBER NOT NULL,
	CONSTRAINT SERVICIOS_PK PRIMARY KEY (ID));

ALTER TABLE SERVICIOS
ADD CONSTRAINT fk_ser_a_hoteles
    FOREIGN KEY (id_hotel)
    REFERENCES hoteles(id)
    ON DELETE CASCADE
ENABLE;
    
CREATE TABLE PISCINAS
   (ID NUMBER, 
	PROFUNDIDAD NUMBER NOT NULL, 
	CONSTRAINT PISCINAS_PK PRIMARY KEY (ID));
    
ALTER TABLE PISCINAS
ADD CONSTRAINT fk_pis_a_servicios
    FOREIGN KEY (id)
    REFERENCES servicios(id)
    ON DELETE CASCADE
ENABLE;

CREATE TABLE GIMNASIOS
   (ID NUMBER, 
	MAQUINAS NUMBER NOT NULL, 
	CONSTRAINT GIMNASIOS_PK PRIMARY KEY (ID));
    
ALTER TABLE GIMNASIOS
ADD CONSTRAINT fk_gim_a_servicios
    FOREIGN KEY (id)
    REFERENCES servicios(id)
    ON DELETE CASCADE
ENABLE;

CREATE TABLE INTERNET
   (ID NUMBER, 
	CAPACIDAD NUMBER NOT NULL, 
	CONSTRAINT INTERNET_PK PRIMARY KEY (ID));
    
ALTER TABLE INTERNET
ADD CONSTRAINT fk_int_a_servicios
    FOREIGN KEY (id)
    REFERENCES servicios(id)
    ON DELETE CASCADE
ENABLE;

CREATE TABLE RESTAURANTES
   (ID NUMBER, 
	TIPO VARCHAR2(255 BYTE) NOT NULL, 
	CONSTRAINT RESTAURANTES_PK PRIMARY KEY (ID));
    
ALTER TABLE RESTAURANTES
ADD CONSTRAINT fk_rest_a_servicios
    FOREIGN KEY (id)
    REFERENCES servicios(id)
    ON DELETE CASCADE
ENABLE;

CREATE TABLE BARES
   (ID NUMBER, 
	TIPO VARCHAR2(255 BYTE) NOT NULL, 
	CONSTRAINT BARES_PK PRIMARY KEY (ID));
    
ALTER TABLE BARES
ADD CONSTRAINT fk_bar_a_servicios
    FOREIGN KEY (id)
    REFERENCES servicios(id)
    ON DELETE CASCADE
ENABLE;

CREATE TABLE ESPACIOS
   (ID NUMBER, 
	TIPO_ESPACIO VARCHAR2(255 BYTE) NOT NULL, 
    CAPACIDAD NUMBER NOT NULL,
	CONSTRAINT ESPACIOS_PK PRIMARY KEY (ID));
    
ALTER TABLE ESPACIOS
	ADD CONSTRAINT CK_ESPACIOS_TIPO 
	CHECK (TIPO_ESPACIO IN ('Salon_Reuniones', 'Salon_Conferencia', 'SPA'))
ENABLE;

CREATE TABLE RESERVAS_ESPACIOS
   (ID NUMBER, 
	ESPACIO NUMBER NOT NULL, 
    DIA NUMBER NOT NULL,
    MES NUMBER NOT NULL,
    ANIO NUMBER NOT NULL,
    HORA NUMBER NOT NULL,
	CONSTRAINT RESERVAS_ESPACIOS_PK PRIMARY KEY (ID));
    
ALTER TABLE RESERVAS_ESPACIOS
ADD CONSTRAINT fk_reseresp_a_servicios
    FOREIGN KEY (id)
    REFERENCES servicios(id)
    ON DELETE CASCADE
ENABLE;

ALTER TABLE RESERVAS_ESPACIOS
ADD CONSTRAINT fk_a_ESPACIOS
    FOREIGN KEY (espacio)
    REFERENCES espacios(id)
    ON DELETE CASCADE
ENABLE;

CREATE TABLE CONSUMOS 
   (ID NUMBER, 
	DESCRIPCION VARCHAR2(255 BYTE) NOT NULL, 
	PRECIO_TOTAL NUMBER NOT NULL, 
    DIA NUMBER NOT NULL,
    MES NUMBER NOT NULL,
    ANIO NUMBER NOT NULL,
    HORA NUMBER NOT NULL,
    ID_SERVICIO NUMBER NOT NULL,
    ID_HABITACION NUMBER NOT NULL,
	CONSTRAINT CONSUMOS_PK PRIMARY KEY (ID));
    
ALTER TABLE CONSUMOS
ADD CONSTRAINT fk_cons_a_habitaciones
    FOREIGN KEY (id_habitacion)
    REFERENCES habitaciones(id)
    ON DELETE CASCADE
ENABLE;

ALTER TABLE CONSUMOS
ADD CONSTRAINT fk_cons_a_servicios
    FOREIGN KEY (id_servicio)
    REFERENCES servicios(id)
    ON DELETE CASCADE
ENABLE;


CREATE TABLE INFORMACION_REGISTROS 
   (ID NUMBER, 
	ID_USUARIO NUMBER NOT NULL, 
	ID_HABITACION NUMBER NOT NULL, 
    DIA_ENTRADA NUMBER NOT NULL,
    MES_ENTRADA NUMBER NOT NULL,
    ANIO_ENTRADA NUMBER NOT NULL,
    DIA_SALIDA NUMBER,
    MES_SALIDA NUMBER,
    ANIO_SALIDA NUMBER,
	CONSTRAINT INFORMACIO_REGISTROS_PK PRIMARY KEY (ID));
    
ALTER TABLE INFORMACION_REGISTROS 
ADD CONSTRAINT fk_infregis_a_usuarios
    FOREIGN KEY (id_usuario)
    REFERENCES usuarios(id)
    ON DELETE CASCADE
ENABLE;

ALTER TABLE INFORMACION_REGISTROS 
ADD CONSTRAINT fk_infregis_a_habitaciones
    FOREIGN KEY (id_habitacion)
    REFERENCES habitaciones(id)
    ON DELETE CASCADE
ENABLE;


    





    







