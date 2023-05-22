drop table if exists players;

create table players (
    id serial primary key,
    name text not null,
   team text not null,
   age integer not null
);

drop table if exists games;
create table games (
    id serial primary key,
    name text not null,
    date date not null,
    location text not null
);

insert into games (name, date, location) values ('John', '2018-01-01', 'New York');
insert into games (name, date, location) values ('Doe', '2012-01-02', 'LA');
insert into games (name, date, location) values ('Jane', '2021-04-23', 'Bucuresti');
insert into games (name, date, location) values ('DidI', '2002-04-26', 'TECUCI');