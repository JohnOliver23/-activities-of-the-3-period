Create table testeTransacao (coluna1 serial,coluna2 varchar(10));
Alter table testeTransacao add constraint pk_t primary key(coluna1);
Commit;

Begin;
Insert into testeTransacao values (default,'AAA');
Insert into testeTransacao values (default,'ABC');
Insert into testeTransacao values (default,'BBB');
Insert into testeTransacao values (default,'BCD');
Insert into testeTransacao values (default,'CCC');
Insert into testeTransacao values (default,'CDE');
Select * from testeTransacao;
savepoint spt1;
Insert into testeTransacao values (default,'DDD');
Insert into testeTransacao values (default,'DEF');
Insert into testeTransacao values (default,'EEE');
/*questão a- 9 registros */
Select * from testeTransacao;

/*questão b */
rollback to spt1

/*questão c- 6 registros*/
Select * from testeTransacao;

/*2 parte */
Insert into testeTransacao values (default,'EFG');
Insert into testeTransacao values (default,'FFF');
Insert into testeTransacao values (default,'FGH');
Select * from testeTransacao;
/*questão a- 9 registros */
rollback
/*questão b - 2 transações */
BEGIN;
Insert into testeTransacao values (default,'AAA');
Insert into testeTransacao values (default,'ABC');
Insert into testeTransacao values (default,'BBB');
Insert into testeTransacao values (default,'BCD');
Insert into testeTransacao values (default,'CCC');
Insert into testeTransacao values (default,'CDE');
commit

select * from testeTransacao


/*questão 3 */
select * from projs.engenheiro
select * from projs.projeto
select * from projs.atua

select e.nome, p.titulo from projs.engenheiro e join projs.atua
a on a.cod_eng = e.codigo join projs.projeto p on a.cod_proj
= p.codigo

alter table projs.engenheiro
add  salario  numeric(15,2);

alter table projs.projeto
add area varchar(30)

update projs.projeto
set area = 'Programacao'
where codigo = 1

update projs.projeto
set area = 'Programacao'
where codigo = 4

update projs.projeto
set area = 'Banco de dados'
where codigo = 5

update projs.projeto
set area = 'pistola'
where codigo = 3

update projs.projeto
set area = 'esporte'
where codigo = 2

update projs.engenheiro
set salario = 11750
where codigo =1

update projs.engenheiro
set salario = 1900
where codigo =2

update projs.engenheiro
set salario = 1000
where codigo =3
insert into projs.engenheiro values (4,'Rafael Lins',1000);
insert into projs.engenheiro values (5,'Marlon Five', 1000);
insert into projs.engenheiro values (6,'Talesman', 1000);
insert into projs.projeto values (4,'Monitoria de Ed');
insert into projs.projeto values (5,'Monitoria de Bd');
insert into projs.atua values (4,4,'Monitoria de Estrutura');
insert into projs.atua values(5,5,'Monitoria de Bd');

/*questão 3 */
select nome from projs.engenheiro
where salario  >( select avg(salario) from projs.engenheiro)

/*questão 4 */
select  p.area, count(e.nome) from projs.engenheiro e join projs.atua
a on a.cod_eng = e.codigo join projs.projeto p on a.cod_proj
= p.codigo
group by p.area

/*questão 5 */
select nome
from projs.engenheiro
where codigo in (select cod_eng
                  from projs.atua
                  where cod_proj in (select codigo
                                     from projs.projeto 
                                     where area like 'Banco de dados'))

/*tras o nome dos engenheiros da area Banco de dados*/
/*USANDO JOIN */
select e.nome from projs.engenheiro e join projs.atua a 
on a.cod_eng = e.codigo join projs.projeto p on a.cod_proj
= p.codigo
where p.area like 'Banco de dados'


/*Questão 6 */
select codigo
  from projs.engenheiro
  where salario > 1200 
  INTERSECT
  select cod_eng 
   from projs.atua;
  /* seleciona os engenheiros que ganham mais que 1200 e que estão
  atuando em algum projeto */

  /*com subquery */
  select distinct cod_eng from projs.atua
  where cod_eng in (select codigo from projs.engenheiro
		   where salario > 1200)

/*com join */
select distinct a.cod_eng from projs.atua a join projs.engenheiro e
on a.cod_eng = e.codigo
where e.salario > 1200

/*questão 7 */
select codigo 
  from projs.engenheiro 
except
  select cod_eng 
   from projs.atua;

   /*mostra o código dos engenheiros que não estão atuando em nenhum
   projeto */
   /*subquery*/
   select e.codigo from projs.engenheiro e
   where not exists (select cod_eng from projs.atua a where e.
   codigo =  a.cod_eng)

   /*join */
   select e.codigo from projs.engenheiro e left join 
   projs.atua a on a.cod_eng = e.codigo
   where a.cod_eng is null

   /*questão 8 */
   insert into projs.projeto values (6,'Monitoria de IHC');
   select P.codigo, P.titulo
	From projs.projeto P
	Where not exists (select *
		            From projs.atua A
				Where A.cod_proj = P.codigo);

/*ELA MOSTRA O TÍTULO E O CODIGO DOS PROJETOS QUE NÃO TEM
NENHUM ENGNHEIRO ATUANDO */
 select codigo, titulo
	From projs.projeto 
	Where codigo not in ( select cod_proj from projs.atua)
/*com not in a consulta é mais rápida , pois consome menos recurso
do sgbd do que o exists */

/*Questão 9 */
/* Crie uma view mostrando os nomes dos engenheiros, sua função
 em cada projeto e o título do projeto. Consulte-a. */ 

 create view projs.EngenheiroFuncao2 as
 select e.nome, a.funcao, p.titulo from projs.engenheiro e join projs.atua
a on a.cod_eng = e.codigo join projs.projeto p on a.cod_proj
= p.codigo

select * from EngenheiroFuncao

/*criando o coleguinha */

create role jova login password 'bd2'
grant select on projs.EngenheiroFuncao2 to jova
grant usage on schema projs to jova

/*questão 11 */
/*é um papel que pode ser atribuido tanto a um usuário quanto a um grupo */
/*um role pode ser usado pra atribuir permissões a um grupo*/
/*ou a um usuário específico*/
create role teste
grant teste to jova
grant select on projs.engenheiro to teste

