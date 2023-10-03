create database aulas_ifba;

use aulas_ifba;

create table semestre(
	codigoSemestre int primary key auto_increment,
    descricaoSemestre varchar(20)
);

insert into semestre (descricaoSemestre)
values("Primeiro"),("Segundo"),("Terceiro"),("Quarto"),("Quinto"),("Sexto"),("Sétimo"),("Oitavo");

create table professor(
	codigoProfessor int primary key auto_increment,
    nomeProfessor varchar(50)
);

insert into professor (nomeProfessor)
value("João Marcelo Moraes Fernandes"),("Fábio Marques da Cruz"),("Fernanda Regebe Castro"),("Lucio Marcos Silva dos Santos"),("Eduardo Oliveira Teles"),
	("Heliomar Conceição Souza"),("Adilson Oliveira de Almirante"),("Alexandre Boleira Lopo");

select * from professor;

create table diaSemana(
	codigoDiaSemana int primary key auto_increment,
    diaSemana varchar(25)
);

insert into diaSemana(diaSemana)
values("Domingo"),("Segunda-feira"),("Terça-feira"),("Quarta-feira"),("Quinta-feira"),("Sexta-feira"),("Sábado");

create table horario(
	codigoHorario int primary key auto_increment,
    descricaoHorario varchar(20)
);

insert into horario(descricaoHorario)
value("13:50 - 16:50");
insert into horario(descricaoHorario)
value("18:40 - 22:00");

create table materia(
	codigoMateria int primary key auto_increment,
    nomeMateria varchar(30),
    codigoSemestre int,
    codigoProfessor int
);

insert into materia (nomeMateria,codigoSemestre,codigoProfessor)
values("Gestão de projetos","7","1");
insert into materia
values(default,"Programação orientada a objeto","3","2");

alter table materia
add constraint fkMateriasCodigoSemestre foreign key (codigoSemestre) references semestre(codigoSemestre);
alter table materia
add constraint fkMateriaCodigoProfessor foreign key (codigoProfessor) references professor(codigoProfessor);

create table aulaDiaHorario(
	codigoAula int primary key auto_increment,
    codigoMateria int,
    codigoDiaSemana int,
    codigoHorario int
);

insert into aulaDiaHorario
values (default,"1","5","1"), (default,"2","3","1"), (default,"2","4","1");

alter table aulaDiaHorario
add constraint fkAulaDiaHorarioCodigoMateria foreign key (codigoMateria) references materia(codigoMateria);
alter table aulaDiaHorario

add constraint fkAulaDiaHorarioCodigoDiaSemana foreign key (codigoDiaSemana) references diaSemana(codigoDiaSemana);
alter table aulaDiaHorario
add constraint fkAulaDiaHorarioCodigoHorario foreign key (codigoHorario) references horario(codigoHorario);

select m.nomeMateria, s.descricaoSemestre, p.nomeProfessor, d.diaSemana, h.descricaoHorario from materia m
join semestre s	
on m.codigoSemestre = s.codigoSemestre 
join professor p
on m.codigoProfessor = p.codigoProfessor
join aulaDiaHorario a
on m.codigoMateria = a.codigoMateria
join diaSemana d
on a.codigoDiaSemana = d.codigoDiaSemana
join horario h
on a.codigoHorario = h.codigoHorario;