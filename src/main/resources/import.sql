-- You can use this file to load seed data into the database using SQL statements
insert into USER (ID, DNI, ADRESSS, BIRTHDAY, EMAIL, INSCRIPTION, LASTNAME, NAME, PASSWORD, PERMITS, PHONE, USERNAME) values (1, '1', 'ESTRADA','1000-01-01 00:00:00', 'TEST@UCC.EDU.AR', '1000-01-01 00:00:00', 'AHRE', 'FACUNDO', '12346789', 'ADMIN', '123', 'FARG')
insert into USER (ID, DNI, ADRESSS, BIRTHDAY, EMAIL, INSCRIPTION, LASTNAME, NAME, PASSWORD, PERMITS, PHONE, USERNAME) values (2, '4969420', 'ESTRADA','1000-01-01 00:00:00', 'Ilove2Test@hotmail.com', '2020-06-23 00:00:00', 'Tester', 'Testificate', 'asdasdasd', 'USER', '4444471', 'testtingatHome')
insert into USER (ID, DNI, ADRESSS, BIRTHDAY, EMAIL, INSCRIPTION, LASTNAME, NAME, PASSWORD, PERMITS, PHONE, USERNAME) values (3, '12345678', 'Belgrano 443','1993-4-24 23:00:00', 'TestIsmyPassion@gmail.com', '2020-03-08 00:00:00', 'Perez', 'Juan', 'password', 'USER', '911', 'DulceDeLecheDestroyer441')


insert into STATE (ID,NAME,BODY) values (1,"Open","Se Esta Trabajando en la tarea.")
insert into STATE (ID,NAME,BODY) values (2,"Closed","La tarea esta cerrada y terminada.")
insert into STATE (ID,NAME,BODY) values (3,"Project Open","Se Esta Trabajando en el Proyecto.")
insert into STATE (ID,NAME,BODY) values (4,"Project Closed","El Proyecto esta cerrado y terminado.")

insert into PROJECT (ID,NAME,DESCRIPTION,START,STATE_ID) values (1,"SegundoParcial","Realizar el segundo parcial de Arquitectura de software 2",'2020-11-01 00:00:00',3)
insert into PROJECT (ID,NAME,DESCRIPTION,START,STATE_ID) values (2,"RedSocialMascotas","Crear una red social que haga competencia a facebook",'2005-7-13 14:00:00',4)

insert into TASK (ID,NAME,BODY,USER_ID,PROYECT_ID,STATE_ID,DATE_START,DATE_END) values (1,"Realizar los casos de carga a la base de Datos","Se deberian cargar valores de prueba a la base de datos",1,1,2,'2020-11-23 4:00:00','2020-11-23 23:59:00')
insert into TASK (ID,NAME,BODY,USER_ID,PROYECT_ID,STATE_ID,DATE_START,DATE_END) values (2,"Pulir todo y agregar interfaz","Esto deberia poder accederse de forma grafica",2,1,1,'2020-11-23 23:59:00',NULL)
insert into TASK (ID,NAME,BODY,USER_ID,PROYECT_ID,STATE_ID,DATE_START,DATE_END) values (3,"Investigar que esta haciendo facebook bien","Por algo la gente usa esa red social",1,2,2,'2006-11-23 4:00:00','2006-11-23 23:59:00')
insert into TASK (ID,NAME,BODY,USER_ID,PROYECT_ID,STATE_ID,DATE_START,DATE_END) values (4,"Copiar codigo de facebook","No debe ser tan dificil",3,2,2,'2006-11-23 4:00:00','2006-11-23 23:59:00')

insert into COMMENT (ID,NAME,BODY,USER_ID,TASK_ID,DATE) values (1,"Hay un problema legal","Esto se llama espionaje corporativo y creo que es ilegal",3,4,'2006-11-23 23:59:00')
insert into COMMENT (ID,NAME,BODY,USER_ID,TASK_ID,DATE) values (2,"Pues Solucionenlo","La gente lo hace todo el tiempo",1,4,'2006-11-23 23:59:30')
insert into COMMENT (ID,NAME,BODY,USER_ID,TASK_ID,DATE) values (3,"Terminado","Easy peazy",2,1,'2020-11-23 23:59:00')
