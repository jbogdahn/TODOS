create table public.todo
(
    id          varchar not null
        constraint todo_pk
            primary key,
    version     bigint,
    title       varchar(250),
    category    varchar(100),
    description varchar(750),
    done        boolean
);

alter table public.todo
    owner to postgres;

