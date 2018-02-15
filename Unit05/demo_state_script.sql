create database test;

use test;

drop table if exists State;	

create table State (
name varchar(15) not null,
capital varchar(25),
population integer);

insert into State values ('Georgia', 'Atlanta', 8282915);
insert into State values ('New York', 'Albany', 19011378);
insert into State values ('Illinois', 'Springfield', 78908907);
insert into State values ('Texas', 'Austin', 24326974);

