/*questão 1 */
Create or Replace Function trocaNome()
Returns trigger as $$
declare msg varchar(40); 
Begin
  msg = 'Primeiro nome '||old.primeironome|| ' mudou para '||new.primeironome;
  raise notice 'Foi feito: %',msg; 
  return null; 
End; 
$$ LANGUAGE plpgsql;  
CREATE TRIGGER veNome AFTER UPDATE 
  of primeironome ON empregado 
  FOR EACH ROW 
  EXECUTE PROCEDURE trocaNome();
select * from empregado; 
update empregado
set primeironome = 'TROCA'
where primeironome = 'Mariana'; 

/*a- ele imprime uma mensagem do nome antigo e do novo nome
após uma atualização na tabela empregado
b- o teste foi realizado após uma atualização na tabela empregado
c- old se refere à o valor antigo, ou seja , o q vai ser atualizado
o new se refere a o novo valor, ou seja , o novo valor que será inserido*/


/*questão 3 */
create table emplog( usuario varchar(20), 
operacao char(1), datahora timestamp)

create or replace function atualiza_log() returns trigger
as $$
begin
insert into emplog values (user,substring (TG_OP,1,1), now());
return new;
end;
$$ language plpgsql;

create trigger insertLog after insert or update or delete
on empregado for each row execute procedure atualiza_log()

insert into
empregado(matricula,primeironome,salario,gerente,coddepto)
values (default,'Patricia',7000,2,2);

update empregado
set primeironome = 'Sara'
where primeironome = 'Patricia';

select * from emplog

/*questão 4 */
CREATE OR REPLACE function testa_salario() returns trigger
as $$
Begin
    If new.salario > 20000 then
        raise exception 'salario alto';
    end if;
    return new; 
    exception
       when raise_exception then
           Raise notice 'Tentativa de aumento exagerada!!! %', new.salario;
           return null;
 end;
$$ LANGUAGE plpgsql;  

create trigger verSalario 
     BEFORE INSERT OR UPDATE OF salario ON empregado
 FOR EACH ROW
 Execute procedure testa_salario(); 
 insert into empregado(matricula,primeironome,salario,gerente,coddepto) values (default,'Patricia',27000,2,2);

/*ele verifica se o salario que é tentado ser inserido é maior que 20000
caso o salario seja maior que 20000 é disparada uma excessão com uma mensagem
de tentativa de aumento exagerada e o salário não é atualizado, caso o salario inserido
seja menor, o novo salário é atualizado com sucesso */

/*5*/
CREATE TABLE testeINC (
      ID           integer    NOT NULL,
      Descricao  VARCHAR(50)  NOT NULL);
ALTER TABLE testeINC ADD CONSTRAINT testepk PRIMARY KEY (ID);

/*function*/
create or replace function incrementa_id() returns trigger
as $$
declare
contador testeINC.id%type;
begin
SELECT Coalesce(MAX(id),0) +1 INTO contador FROM testeINC;
new.id := contador;
return new;
end;
$$ language plpgsql;

/*trigger*/
create trigger insertId BEFORE INSERT on testeINC
for each row execute procedure incrementa_id();

insert into testeINC(descricao) values('X');
select * from testeINC

/*6*/
