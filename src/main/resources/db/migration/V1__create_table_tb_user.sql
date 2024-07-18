create table tb_user (
    id uuid primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    country varchar(255) not null,
    role smallint not null,
    password varchar(255) not null
);
