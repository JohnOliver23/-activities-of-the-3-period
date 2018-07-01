
/*questão 1 */
alter table produto add quantidade integer;
alter table produto add status varchar(40);

update produto
set quantidade = 50
where codprod = 25

select * from produto

create or replace function atualiza_Status(codigo produto.codprod%type)
returns void
as $$
Declare qtd_atual produto.quantidade%type;
Begin
select quantidade into qtd_atual from produto
where codprod = codigo;
if qtd_atual > 30 then
  update produto
  set status = 'Estoque dentro do esperado'
  where codprod = codigo;
else
  update produto
  set status = 'Estoque fora do limite minimo'
  where codprod = codigo;
end if;
End;
$$ language plpgsql;

select * from produto;
select atualiza_Status(200);

/*questão 2 */
create or replace function atualiza_Status(codigo produto.codprod%type)
returns void
as $$
Declare qtd_atual produto.quantidade%type;
Begin
select quantidade into strict qtd_atual from produto
where codprod = codigo;
if qtd_atual > 30 then
  update produto
  set status = 'Estoque dentro do esperado'
  where codprod = codigo;
else
  update produto
  set status = 'Estoque fora do limite minimo'
  where codprod = codigo;
end if;
Exception 
  when no_data_found then
	raise notice 'Nenhum registro encontrado';
  when too_many_rows then
	raise notice 'mais de um registro retornado';
End;
$$ language plpgsql;

/*questão 3 */
create table fornecedor(
cod serial not null,
nome varchar(30),
cnpj varchar(15),
email varchar(15))
insert into fornecedor (nome, cnpj) values('fernando','58085002');
insert into fornecedor (nome, cnpj) values('marlon','58085003');
insert into fornecedor (nome, cnpj) values('guerreirinho','58085004');
insert into fornecedor (nome, cnpj, email) values ('Pah','58058666','Pah@mon.com')

create or replace function insere_fornecedor(name fornecedor.nome%type)
returns integer
as $$
declare
codigo integer;
begin
select max(cod) into strict codigo from fornecedor;
codigo := codigo+1;
  insert into fornecedor(cod, nome) values(codigo, name);
  return 1;
exception
  when unique_violation then
    raise notice 'ja existe um registro com esse codigo';
    return -1;
  when others then
    raise notice 'Erro descnhecido';
    return -1;
end;
$$ language plpgsql;

select insere_fornecedor('sherishev');
select * from fornecedor

/*questão 4 */
create or replace function showFornecedor()returns void
as $$
declare v_cursor cursor for select cod, nome, email from fornecedor;
begin
  for v_cat in v_cursor loop
    raise notice 'codigo = %',v_cat.cod;
    raise notice 'nome = %', v_cat.nome;
    raise notice 'email = %', v_cat.email;
  end loop;
end;
$$ language plpgsql;

select showFornecedor()

/*USANDO O CURSOR NO FOR*/
create or replace function showFornecedor()returns void
as $$
declare v_cat fornecedor%rowtype;
begin
  for v_cat in select cod, nome, email from fornecedor loop
    raise notice 'codigo = %',v_cat.cod;
    raise notice 'nome = %', v_cat.nome;
    raise notice 'email = %', v_cat.email;
  end loop;
end;
$$ language plpgsql;

select showFornecedor()

/*questão 5 */
CREATE OR REPLACE FUNCTION showFornecedor2(refcursor)
RETURNS refcursor
AS $$
BEGIN
OPEN $1 FOR SELECT cod, nome, email FROM fornecedor;
RETURN $1;
END;
$$ LANGUAGE plpgsql;
--Teste-a dentro de uma transação:
BEGIN
SELECT showFornecedor2('funccursor')
FETCH ALL IN funccursor;
commit;

/* o codigo acima passa o nome e a referencia do cursor pra a função, em seguida
 a função guarda os dados do fornecedor no cursor e depois retorna o cursor, em 
 seguida o fetch lista todas as linhas do cursor*/

 /*questão 6 */

create or replace function getSumSalario()
returns numeric
as $$
Declare
salcomp numeric;
v record;
Begin
Salcomp = 0;
for v in (select salariofixo from vendedor where salariofixo is not null)
loop
salcomp = salcomp + v.salariofixo;
end loop;
return salcomp;
end;
$$ LANGUAGE plpgsql;

select getSumsalario2()
/*o codigo acima faz uma soma do salario de todos os vendedores*/

/*questão 6.1 */
create or replace function getSumSalario2()
returns numeric
as $$
Declare
salcomp numeric;
Begin
select into salcomp sum(salariofixo) from vendedor;
return salcomp;
end;
$$ LANGUAGE plpgsql;
select getSumSalario();
select getSumSalario2();
