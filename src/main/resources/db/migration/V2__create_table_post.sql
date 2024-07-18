create table post(
    id uuid primary key,
    title varchar(255) not null,
    body text not null,
    imgUrl varchar(255),
    user_id uuid not null,
    created_at timestamp not null
);