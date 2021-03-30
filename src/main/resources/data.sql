
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

insert into brands (id, name) values (uuid_generate_v1(),'Mercedes');
insert into brands (id, name) values (uuid_generate_v1(),'BMW');
insert into brands (id, name) values (uuid_generate_v1(),'Opel');

insert into model (id, engine_capacity, horse_power, name, volume, year_of_manufacture, brand_id)
values (uuid_generate_v1(),  5.8, 448, 'M 3', 5.5, '2015-01-19',(SELECT id from brands where name like 'BMW'));
insert into model (id, engine_capacity, horse_power, name, volume, year_of_manufacture, brand_id)
values (uuid_generate_v1(),  5.8, 228, 'X4', 5.5, '2002-01-19',(SELECT id from brands where name like 'BMW'));
insert into model (id, engine_capacity, horse_power, name, volume, year_of_manufacture, brand_id)
values (uuid_generate_v1(),  10.8, 338, 'S klasa', 12.5, '2019-01-19',(SELECT id from brands where name like 'Mercedes'));
insert into model (id, engine_capacity, horse_power, name, volume, year_of_manufacture, brand_id)
values (uuid_generate_v1(),  5.8, 8, 'E klasa', 15.5, '2015-01-19',(SELECT id from brands where name like 'Mercedes'));
insert into model (id, engine_capacity, horse_power, name, volume, year_of_manufacture, brand_id)
values (uuid_generate_v1(),  5.8, 8, 'Astra', 5.5, '2016-01-19',(SELECT id from brands where name like 'Opel'));
insert into model (id, engine_capacity, horse_power, name, volume, year_of_manufacture, brand_id)
values (uuid_generate_v1(),  5.8, 98, 'Kaded', 5.5, '2020-01-19',(SELECT id from brands where name like 'Opel'));
insert into model (id, engine_capacity, horse_power, name, volume, year_of_manufacture, brand_id)
values (uuid_generate_v1(),  5.8, 335, 'Vectra', 5.5, '2015-01-19',(SELECT id from brands where name like 'Opel'));
insert into model (id, engine_capacity, horse_power, name, volume, year_of_manufacture, brand_id)
values (uuid_generate_v1(),  55.8, 448, 'G 550', 25.5, '2021-01-19',(SELECT id from brands where name like 'Mercedes'));

insert into owners (id, first_name, lastname, username)
values (uuid_generate_v1(), 'Dimitar', 'Chikalanov', 'dimitar96');
insert into owners (id, first_name, lastname, username)
values (uuid_generate_v1(), 'Ivan', 'Ivanov', 'ivan96');
insert into owners (id, first_name, lastname, username)
values (uuid_generate_v1(), 'Pesho', 'Peshev', 'pesho96');
