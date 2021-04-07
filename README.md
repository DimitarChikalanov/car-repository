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
docker-compose -p car build
docker-compose -p car up 
```

## Database c configuration
I use a postgres database. We use the following settings to sit in the application.properties.

## Docker-compose settings in application.properties.
```bash
spring.datasource.url=jdbc:postgresql://${DB_HOSTNAME}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASS}
```

## Postgres settings in application.properties.
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
## RESTful API Server

| METHOD  | PATH | DESCRIPTION |
| ------------- | ------------- | ------------- |
| POST  | /api/car | Create new car  |
| PATCH  | /api/car  | Update car by registration number  |
| GET  | /api/car  | Get all registration number |
| GET  | /car/owner/{name}  | Get all car by owner name |
| GET  | /car/brand/{name}  | Get all car by brand name  |
| GET  | /api/car/{registrationNumber}  | Get all car information by registration number  |
| DELETE  | /api/car  | Delete car by registration number  |

## Curl
Curl for Car

1.Create new car
```bash
curl --location --request POST 'http://127.0.0.1:8089/api/car' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username":"dimitar96",
    "brandName":"BMW",
    "color":"zelen",
    "modelName":"X4",
    "registrationNumber":"CB5653BN"
}'
```
2.Update car
```bash
curl --location --request PATCH 'http://127.0.0.1:8089/api/car' \
--header 'Content-Type: application/json' \
--data-raw '{
    "ownerName":"pesho96",
    "registrationNumber":"CB5653BN",
    "newRegistrationNumber":"CB6078BN",
    "color":""
}'
```
3.Get all registration car number 
```bash
curl --location --request GET 'http://127.0.0.1:8089/api/car' \
--header 'Content-Type: text/plain'
```
4.Get all car by owner name
```bash
curl --location --request GET 'http://127.0.0.1:8089/api/car/owner/dimitar96'
```
5.Get all car by brand name
```bash
curl --location --request GET 'http://127.0.0.1:8089/api/car/brand/BMW' \
--header 'Content-Type: text/plain'
```
6.Get all car information by registration number
```bash
curl --location --request GET 'http://127.0.0.1:8089/api/car/CB5553BN'
```
7.Delete car by registration number
```bash
curl --location --request DELETE 'http://127.0.0.1:8089/api/car' \
--header 'Content-Type: application/json' \
--data-raw '{"registrationNumber":"CB5553BN"}'
```
## Swagger REST API documentation presented here (after application start):
You can use the Swagger API Documentation at http://localhost:8089/swagger-ui/index.html#

![2021-04-03_10-32](https://user-images.githubusercontent.com/59176864/113471878-049f7200-9468-11eb-9fc9-44a58ee1dc7b.png)



 
