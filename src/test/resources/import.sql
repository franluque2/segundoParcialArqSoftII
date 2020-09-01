-- You can use this file to load seed data into the database using SQL statements
insert into STATE (name) values ('Salta');
insert into STATE (name) values ('Córdoba');

insert into USER (name, last_name, email) values ('Jose Maria', 'Quiroga', 'jmquiroga@hotmail.com');

insert into ADDRESS (address_type, number, street, state_id, user_id) values (3, 2015, 'Independencia', 2, 1);