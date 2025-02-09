create database dbactivity20242;
use dbactivity20242;

create table tactivity(
idActivity char(36) not null,
name varchar(700) not null,
beginDate datetime not null,
endDate datetime not null,
status boolean not null,/*true => Habilitado, False => Deshabilitado*/
createdAt datetime not null,
updatedAt datetime not null,
primary key(idActivity)
) engine=innodb;