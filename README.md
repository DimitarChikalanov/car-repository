# car-repository

## Running locally
 
## With maven command line

```bash
git clone https://github.com/DimitarChikalanov/car-repository.git
cd /car-repository
./mvnw spring-boot:run
```
## Whith Docker-compose

```bash
git clone https://github.com/DimitarChikalanov/car-repository.git
cd /car-repository
docker-compose -p car up 
docker-compose -p car build
```

## Database c configuration
I use a postgres database. We use the following settings to sit in the application.properties.

## Docker-compose settings in application.properties.
```bash
spring.datasource.url=jdbc:postgresql://${DB_HOSTNAME}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
```

## DPostgres settings in application.properties.
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/car
spring.datasource.username=
spring.datasource.password=
```

## Database shema

![brands](https://user-images.githubusercontent.com/59176864/113470673-10873600-9460-11eb-88e3-43df1050ceef.png)

## Exucute Sql script
After starting the application, we run the following sql script.
```bash
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
```
## Swagger REST API documentation presented here (after application start):
You can use the Swagger API Documentation at http://localhost:8089/swagger-ui/index.html#

![2021-04-03_10-32](https://user-images.githubusercontent.com/59176864/113471878-049f7200-9468-11eb-9fc9-44a58ee1dc7b.png)



 
