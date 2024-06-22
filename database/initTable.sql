create table public.todo
(
    id          varchar not null
        constraint todo_pk
            primary key,
    version     bigint,
    title       varchar,
    category    varchar,
    description varchar,
    done        boolean
);

alter table public.todo
    owner to postgres;

