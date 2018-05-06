create schema projs authorization jova

/*Criação das tabela Engenheiro*/
create table projs.Engenheiro (
codigo integer ,
nome varchar(30),
constraint PK_ENG PRIMARY KEY (codigo))

/*Criação das tabela Projeto*/
create table projs.Projeto (
codigo integer ,
titulo varchar(30),
constraint PK_PROJ PRIMARY KEY (codigo))

/*Criação das tabela Atua*/
create table projs.atua (
cod_eng integer,
cod_proj integer,
funcao varchar(30),
constraint PK_atua PRIMARY KEY (cod_eng, cod_proj),
constraint FK_ENG FOREIGN KEY (cod_eng) references projs.engenheiro,
constraint FK_PROJ FOREIGN KEY (cod_proj) references projs.projeto)

/*inserção na tabela Engenheiro*/
insert into projs.engenheiro values (1, 'Paulo Ferreira');
insert into projs.engenheiro values (2, 'Felipe Smith');
insert into projs.engenheiro values (3, 'Neil Johns');

select * from projs.engenheiro
/*inserção na tabela projeto */
insert into projs.projeto values (1, 'Monitoria LS');
insert into projs.projeto values (2, 'Monitoria Vôlei');
insert into projs.projeto values (3, 'Monitoria Pistola');

select * from projs.atua

/*inserção na tabela atua*/
insert into projs.atua values (1, 1 , 'MonitorLS');
insert into projs.atua values (1,2, 'MonitorVolei');
insert into projs.atua values (2,2, 'MonitorVolei');
insert into projs.atua values (3,3, 'MonitorPistola');

/*criando view com nome dos engenheiros e titulos dos projetos */
create or replace view projs.EngTitulo (engenheiro, projeto)as
select e.nome, p.titulo from projs.engenheiro e join projs.atua a
on e.codigo = a.cod_eng join projs.projeto p on p.codigo = a.cod_proj

/*consultando a visão */
select * from projs.EngTitulo


/*criando um role  de grupo estagiario e gerente */
create role gerente
create role estagiario

/*dando permissões ao gerente */
grant usage on schema projs to gerente
grant all on all tables in schema projs to gerente

/*dando permissões pro estagiário */
grant usage on schema projs to estagiario
grant select on projs.EngTitulo to estagiario

/*criando os papeis */
create role ggg login password 'bd2'
create role eee login password 'bd2'
grant gerente to ggg
grant estagiario to eee

