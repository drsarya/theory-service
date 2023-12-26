create schema theory;

create table theory_info
(
    id serial primary key,
    name varchar(500),
    description varchar(5000),
    formula jsonb
)