/*criação das tabelas */
CREATE TABLE Professor (
MatricProf serial NOT NULL,
NomeProf VARCHAR(40),
DataAdmissao DATE );
alter table professor add constraint pk_professor
PRIMARY KEY (MatricProf)

CREATE TABLE Disciplina (
CodDISC serial NOT NULL,
NomeDISC VARCHAR(30))
alter table Disciplina add constraint pk_disciplina
PRIMARY KEY (CodDisc)

alter table professor add codDisc Integer
alter table professor add constraint fk_professor_disciplina
FOREIGN KEY (codDisc) references Disciplina

Insert into disciplina(nomeDisc) values ('BD');
insert into disciplina(nomeDisc) values ('Sistemas Operacionais');

select * from disciplina
Insert into professor(nomeProf, dataadmissao,coddisc) values('Crishane', null, 1);
Insert into professor(nomeProf, dataadmissao,coddisc) values('Damires', null, 1);
Insert into professor(nomeProf, dataadmissao,coddisc) values('Luciana', null, 2);

select * from professor
select p.nomeProf, d.nomeDisc from professor p join disciplina d
on d.codDisc = p.codDisc

/*Teste de integridade referencial*/
/*Exemplo 1 oq acontece */
delete from disciplina where codDisc = 1

/*Erro , pois o default do postgree e no action, ou seja, um dado
referenciado não pode ser atualizado nem excluido*/
/*Exemplo 2 */

alter table professor drop constraint fk_professor_disciplina;

alter table professor add constraint fk2_professor_disciplina
FOREIGN KEY (codDisc) references Disciplina on delete set null;

select * from disciplina
select * from professor

delete from disciplina where codDisc = 1

select * from disciplina
select * from professor

/*os valores do código da disciplina dos professores que era 1 foram
alterados para null, pois a restrição de integridade referencial foi alterado
pra set null. ou seja, ao apagar um dado referenciado, os dados 
dependentes foram alterados para null */

/*Exemplo 3 */
alter table professor drop constraint fk2_professor_disciplina
alter table professor add constraint fk3_professor_disciplina
FOREIGN KEY (codDisc) references Disciplina on delete cascade

select * from disciplina
select * from professor

delete from disciplina where codDisc = 2

select * from disciplina
select * from professor

/*toda a linha onde o codigo da disciplina era igual a 2 foi exluido,
pois a restrição de integridade aplicado foi Cascade, ou seja, ao 
excluir um dado referenciado, toda as linhas dependente do dado
referenciado também são excluídas.

/*Exemplo 4 */
alter table professor drop constraint fk3_professor_disciplina
alter table professor add constraint fk4_professor_disciplina
FOREIGN KEY (codDisc) references Disciplina on update cascade

Insert into disciplina(coddisc,nomeDisc) values (1,'BD');
insert into disciplina(coddisc,nomeDisc) values (2,'Sistemas Operacionais');
update professor set codDisc = 1 where nomeProf = 'Crishane' or 
nomeprof = 'Damires'
Insert into professor values(3,'Luciana', null, 2);

select * from professor
select * from disciplina

update disciplina set codDisc = 11 where codDisc =1

select * from professor
select * from disciplina

/* os dados da coluna coddisc onde antes eram 1 foram atualizados
para 11, pois o dado referenciado também foi alterado pra 11, e a
restrição de integridade aplicado era update cascade, ou seja, ao
atualizar um dado referenciado, os dados dependentes também saõ
atualizados */

update disciplina set codDisc = 1 where codDisc = 11

/*criando outro relacionamento*/

create table aluno (
matricAlu integer not null,
nome varchar(30) not null
)
alter table aluno add constraint pk_aluno PRIMARY KEY (matricAlu)
alter table professor drop constraint fk_professor_disciplina
alter table professor drop column codDisc

CREATE TABLE turma (
MatricAlu integer NOT NULL,
MatricProf integer NOT NULL,
CodDISC integer NOT NULL);
ALTER TABLE turma ADD CONSTRAINT PKturma
PRIMARY KEY(MatricAlu,MatricProf,CodDISC);

insert into aluno values (1, 'Tales Medeiros')
insert into aluno values (2, 'marcio pitar')

alter table turma add constraint fk_turma_aluno FOREIGN KEY (matricAlu)
references aluno on update cascade on delete cascade

alter table turma add constraint fk_turma_professor FOREIGN KEY (matricProf)
references professor on update cascade on delete cascade

alter table turma add constraint fk_turma_disciplina FOREIGN KEY
(codDisc) references Disciplina on update cascade on delete cascade

insert into turma values (1,1,1)
insert into turma values (2,2,2)

select a.nome, d.nomeDisc, t.codDisc, p.nomeProf from aluno a join
turma t on t.matricAlu = a.matricAlu join professor p on t.matricProf
= p.matricProf join Disciplina d on t.codDisc = d.codDisc 
delete from disciplina where coddisc = 5

select * from professor
select * from turma
drop table disciplina cascade constraints







