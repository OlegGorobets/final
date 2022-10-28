create table roles
(
    id   integer      not null
        primary key,
    name varchar(255) not null
        constraint uk_ofx66keruapi6vyqpv6f2or37
            unique
);

alter table roles
    owner to postgres;

create table users
(
    id         varchar(255) not null
        primary key,
    email      varchar(255) not null
        constraint uk_6dotkott2kjsp8vw4d0m25fb7
            unique,
    first_name varchar(255) not null,
    last_name  varchar(255),
    password   varchar(255)
);

alter table users
    owner to postgres;

create table user_role
(
    user_id varchar(255) not null
        constraint fkj345gk1bovqvfame88rcx7yyx
            references users,
    role_id integer      not null
        constraint fkt7e7djp752sqn6w22i6ocqy6q
            references roles
);

alter table user_role
    owner to postgres;

create table category
(
    category_id varchar(255) not null
        primary key,
    name        varchar(255)
);

alter table category
    owner to postgres;

create table product
(
    id          varchar(255) not null
        primary key,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    price       numeric(19, 2),
    category_id varchar(255)
        constraint fk1mtsbur82frn64de7balymq9s
            references category
);

alter table product
    owner to postgres;