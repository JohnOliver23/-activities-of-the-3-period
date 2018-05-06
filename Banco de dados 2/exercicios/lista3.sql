/*Question 1 */
create view artistaV(codigo, nome, datanasc) as
select codart, nomeart, datanasc from artista

/*question 2 */
create view filmeV (titulo, duracao, ano, estudio)
as select f.titulo, f.duracao, f.ano, e.nomeest 
from filme f join estudio e on f.codest = 
e.codest

select * from filmeV

/*question 3 */
select * from artistaV
insert into artistaV (codigo, nome, datanasc)
values (10, 'Mariana Ximenes','27/11/1978')
/*obs : a inserção foi possível por conter a chave 
primária e os aribuos não especificados poder 
aceitar valores nulos */

/*question 4 */
insert into filmeV values
('Window Builder',134,2010, 'Paramount')

/*da um erro, pois as visões que selecionam
mais de uma tabela, não são atualizaveis
automaticamente , o que da um erro de restrição
*/
/*4.a*/
insert into filme  values
(11, 'Window Builder',2018,135,3, 1)

select * from filmeV

/*5 */
update artistaV
set datanasc = '28/11/1978'
where nome like 'Mariana Ximenes'

select * from artistaV

/*6 */
delete from artistaV
where nome like 'Mariana Ximenes'

select * from artistaV

/*7 */
drop view filmeV
select * from filmeV

/* 8 */
create or replace view artistas2016 as
select distinct a.nomeart from artista a join
personagem p on p.codart = a.codart join
filme f on f.codfilme = p.codfilme
where f.ano = 2018
select * from artistas2016

/* 9 */
create or replace view artistasB
(nome, codigo, pais) as
select nomeart, codart , pais from artista
where nomeart like 'B%'
with check option

select * from artistasB
insert into artistasB values('Builder',10,'Siria');
insert into artistasB values('kaisar',11,'Siria');

/*Não foi possível inserir a ultima linha, pois
está violando a condição de check option definida pelo
no where */
