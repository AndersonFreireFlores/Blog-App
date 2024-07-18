create table comment (
    id uuid primary key,
    body text not null,
    imgUrl varchar(255),
    user_id uuid not null,
    post_id uuid not null,
    created_at timestamp not null
);