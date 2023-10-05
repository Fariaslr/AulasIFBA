create database aulas_ifba;

use aulas_ifba;

create table semestre(
    codigoSemestre int primary key auto_increment,
    descricaoSemestre varchar(20) UNIQUE
);

create table semestreVigente(
    codigoSemestreVigente int primary key auto_increment,
    descricaoSemestreVigente CHAR(6)
);

create table localDaAula(
    codigoLocalDaAula int auto_increment primary key,
    localDaAula varchar(20) not null
);

create table professor(
    codigoProfessor int primary key auto_increment,
    nomeProfessor varchar(50) UNIQUE,
    matricula char(7) unique
);

create table diaSemana(
    codigoDiaSemana int primary key auto_increment,
    diaSemana varchar(25) UNIQUE
);

create table disciplina(
	codigoDisciplina int primary key auto_increment,
    descricaoDisciplina varchar(25)
);

create table horario(
    codigoHorario int primary key auto_increment,
    descricaoHorario varchar(20) UNIQUE
);

create table materia(
    codigoMateria int primary key auto_increment,
    codigoDisciplina int,
    codigoLocalDaAula int,
    codigoSemestre int,
    codigoSemestreVigente int    
);



alter table materia
add constraint fkMateriaCodigoLocalDaAula foreign key (codigoLocalDaAula) references localDaAula(codigoLocalDaAula);
alter table materia
add constraint fkMateriaCodigoSemestre foreign key (codigoSemestre) references semestre(codigoSemestre);
alter table materia
add constraint fKMateriaCodigoSemestreVigente foreign key (codigoSemestreVigente) references semestreVigente(codigoSemestreVigente);
alter table materia
add constraint fkMateriaCodigoDisciplina foreign key (codigoDisciplina) references disciplina(codigoDisciplina);

create table aulaDiaHorario(
    codigoAula int primary key auto_increment,
    codigoMateria int,
    codigoDiaSemana int,
    codigoHorario int
);

alter table aulaDiaHorario
add constraint fkAulaDiaHorarioCodigoMateria foreign key (codigoMateria) references materia(codigoMateria);
alter table aulaDiaHorario
add constraint fkAulaDiaHorarioCodigoDiaSemana foreign key (codigoDiaSemana) references diaSemana(codigoDiaSemana);
alter table aulaDiaHorario
add constraint fkAulaDiaHorarioCodigoHorario foreign key (codigoHorario) references horario(codigoHorario);

create table professorMateria(
    codigoMateria int,
    codigoProfessor int,
    codigoSemestre int
);

alter table professorMateria
add constraint fkProfessorMateriaCodigoMateria foreign key (codigoMateria) references materia(codigoMateria);
alter table professorMateria
add constraint fkProfessorMateriaCodigoProfessor foreign key (codigoProfessor) references professor (codigoProfessor);
alter table professorMateria
add constraint fkProfessorMateriaCodigoSemestre foreign key (codigoSemestre) references semestre (codigoSemestre);

insert into semestre (descricaoSemestre)
values("Primeiro"),("Segundo"),("Terceiro"),("Quarto"),("Quinto"),("Sexto"),("Sétimo"),("Oitavo");

INSERT INTO professor (nomeProfessor, matricula) VALUES
("ADILSON OLIVEIRA DE ALMIRANTE", "1684218"),
("ALESSANDRO EDUARDO DE ALMEIDA SOUSA", "1575086"),
("ALEX ANDRADE ALVES", "2665664"),
("ALEX DE SOUZA IVO", "1669049"),
("ALEXANDRE BOLEIRA LOPO", "1190681"),
("ALIGER DOS SANTOS PEREIRA", "2116224"),
("ANA PAULA MIRANDA GUIMARÃES", "1796161"),
("ANA RITA REIS DE ALMEIDA", "1358657"),
("ARNON MANASSÉS LARANJEIRA DE SOUZA", "2062256"),
("BRUNO BARBOSA MARQUES DA SILVA", "1864023"),
("CÉSAR ANDREY GOMES FERREIRA", "1181984"),
("CLAUDIA DE MEDEIROS LIMA", "2870247"),
("CLEDSON MESQUITA SANTOS", "1992290"),
("DANIELA CHAGAS OLIVEIRA", "1078985"),
("DANIELA GUIMARÃES MOROZINI", "2136901"),
("EDUARDO OLIVEIRA TELES", "1737324"),
("ELIANO SOARES DA SILVA", "1555387"),
("ELISA CRISTINA DE BARROS CASAES", "1569321"),
("ERIVÃ DE ARAÚJO SILVA", "1729541"),
("ERNANDO FERREIRA", "1732292"),
("FÁBIO MARQUES DA CRUZ", "1783142"),
("FABIO RODRIGUES SANTOS", "1484509"),
("FERNANDA REGEBE CASTRO", "1572135"),
("GESIANE MIRANDA TEIXEIRA", "1565359"),
("GUSTAVO DA SILVA COSTA", "1333085"),
("HELENA AVANZO", "2790616"),
("HELIOMAR CONCEIÇÃO SOUZA", "1788410"),
("IGOR GOMES SANTOS", "1647938"),
("IVANA SILVA FREITAS", "2129020"),
("IVANILDO ANTONIO DOS SANTOS", "2002371"),
("JAILTON WEBER GOMES", "1584704"),
("JEFFERSON DOS SANTOS COSTA", "1766191"),
("JOÃO MARCELO MORAES FERNANDES", "2844527"),
("JOSAN DE FREITAS ROCHA", "1669056"),
("JOSÉ BORGES DOS SANTOS FILHO", "1332459"),
("JOSILDO PEREIRA DA SILVA", "1643908"),
("JUCIARA COSTA DA FONSECA RIOS", "3056318"),
("JULIANA BASTOS FERNANDES DA CONCEIÇÃO", "1814907"),
("JULIANA TEIXEIRA PAINS OLIVEIRA", "3076799"),
("KARINE SOCORRO PUGAS DA SILVA", "2837236"),
("LANUZA LIMA SANTOS", "1770513"),
("LARISSA NATÁLIA DAS VIRGENS CARNEIRO", "2947591"),
("LENADE BARRETO SANTOS GIL", "3316540"),
("LIAMAR FRANCISCO", "2763860"),
("LIGIA TACIANA CARNEIRO DE SOUZA", "2057055"),
("LUCAS DA SILVA SACRAMENTO", "3156705"),
("LUCIENE SANTOS CARVALHO", "1575401"),
("LUCIO MARCOS SILVA DOS SANTOS", "2911096"),
("MARCOS ANTONIO DA SILVA", "2570233"),
("MARCUS LUCIANO SOUZA DE FERREIRA BANDEIRA", "1589386"),
("MARIA RAIDALVA NERY BARRETO", "1805949"),
("MESSIAS BITTENCOURT FIGUEREDO", "1315404"),
("NADSON SILVA DOS SANTOS", "3436978"),
("NÍVEA DE SANTANA CERQUEIRA", "2114553"),
("RAFAEL GOMES WANDERLEY", "1477746"),
("REGINA MARIA SILVA SANTOS", "1188363"),
("ROSÂNGELA DE ARAÚJO SANTOS", "1575167"),
("SÉRGIO RENATO SOUZA", "1553548"),
("SUELI DOS PRAZERES SANTOS", "1499781"),
("TAÍSE DE JESUS CHATES", "1785991"),
("TERESINHA DE QUADROS GUILHERME DOS SANTOS", "2079321"),
("TEREZA KELLY GOMES CARNEIRO", "1275005"),
("VALDENCASTRO PEREIRA VILAS BOAS JÚNIOR", "1513687"),
("VERÔNICA MARIA BASTOS MACIEL BISPO", "1221617"),
("VIGNA NUNES LIMA", "1784571"),
("WASHINGTON JORGE SANTOS BOMFIM", "2722657"),
("WILMA EDYSLEY ROSADO GOMES", "1788823");

insert into diaSemana(diaSemana)
values("Domingo"),("Segunda-feira"),("Terça-feira"),("Quarta-feira"),("Quinta-feira"),("Sexta-feira"),("Sábado");

insert into horario(descricaoHorario)
value("13:50 - 16:50"),("18:40 - 22:00");

insert into semestreVigente 
values(default,"2023.1"),(default,"2023.2");

