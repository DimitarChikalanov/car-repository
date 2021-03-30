
create table if not exists brands
(
    id   varchar(255) not null
        constraint brands_pkey
            primary key,
    name varchar(255)
);

create  table if not exists model
(
    id                  varchar(255)     not null
        constraint model_pkey
            primary key,
    engine_capacity     double precision not null,
    horse_power         integer          not null,
    name                varchar(255)     not null,
    volume              double precision not null,
    year_of_manufacture timestamp        not null,
    brand_id            varchar(255)
        constraint fk420yixbri0is6b6lvny1hn9yf
            references brands
);

create table if not exists owners
(
    id         varchar(255) not null
        constraint owners_pkey
            primary key,
    first_name varchar(255) not null,
    lastname   varchar(255),
    username   varchar(255) not null
        constraint uk_jshjo2qbm1col3quen97swiw5
            unique
);

create table if not exists cars
(
    id                  varchar(255) not null
        constraint cars_pkey
            primary key,
    color               varchar(255),
    registration_number varchar(255) not null
        constraint uk_i3ldfyekqw49cw6omv99rrfkx
            unique,
    brand_id            varchar(255)
        constraint fk864li48nqoslem704ihv4ax3a
            references brands,
    model_id            varchar(255)
        constraint fk9m6h8tig4kh9o4s5e0dcua4rx
            references model,
    owner_id            varchar(255)
        constraint fkhcsx2hgskre1qwetp67r7qfr
            references owners
);
