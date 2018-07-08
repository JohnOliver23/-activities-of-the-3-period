
/*questão 1 */
Create table Esporte (
      	 codesp   	serial,
      	 descesp    	varchar(25));

Create table Atleta (
      Codatl    	        serial,
      Nome                  varchar(30),
      datanasc            date, 
      bolsa	        numeric (14,2),
      esporte              integer);

alter table esporte add constraint pkesp primary key(codesp);
alter table atleta add constraint pkatleta primary key(codatl);
alter table atleta add constraint fkatlesp foreign key(esporte) references esporte; 

insert into esporte values (default, 'Volei');
insert into esporte values (default, 'Uno');
insert into esporte values (default, 'Futebol');

insert into atleta values (default, 'Pah', '1992-05-03', 600, 1);
insert into atleta values (default, 'Will', '1994-06-03', 600, 1);
insert into atleta values (default, 'Salah', '1992-05-03', 1500, 3);
insert into atleta values (default, 'Kroos', '1990-05-03', 1500, 3);
insert into atleta values (default, 'Nou nou', '1992-05-03', 600, 2);
/*questão 2 */
--testando com atleta existente
do $$
begin
  update atleta
  set bolsa = bolsa * 1.1
  where codatl = 2;
  if not found then
   insert into atleta values (default,'Pinkford','1994-05-03',1500,3);
   raise notice 'atleta não encontrado';
  else
    raise notice 'atleta encontrado';
  end if;
end $$;

--testando com atleta não existente
do $$
begin
  update atleta
  set bolsa = bolsa * 1.1
  where codatl = 7;
  if not found then
   insert into atleta values (default,'pogba','1994-05-03',1500,3);
   raise notice 'atleta não encontrado';
  else
    raise notice 'atleta encontrado';
  end if;
end $$;

select * from atleta

/*questão 3 */

create or replace function atualiza_media (percentual integer) returns void
as $$
declare
media numeric;
v_cursor cursor for select codatl, nome, bolsa from atleta;
status varchar(25);
begin
  select into media avg(bolsa) from atleta;
  /*atualizando a bolsa maior q a média */
  for v_cat in v_cursor loop
    if v_cat.bolsa < media then
      update atleta
      set bolsa = bolsa + (bolsa* 10)/100
      where codatl = v_cat.codatl;
      status := 'Atualizado';
    else
      status := 'Não Atualizado';
    end if;
   raise notice 'Atleta = %', v_cat.nome;
   raise notice 'Bolsa = %', v_cat.bolsa;
   raise notice 'Status = %', status;
  end loop;
end;
$$ language plpgsql;

select atualiza_media (20);
 select * from atleta;
 
/*questão 4 */
create or replace view atletaEsp (nome, bolsa, esporte) as
select a.nome, a.bolsa, e.descesp from atleta a join esporte e
on e.codesp = a.esporte

select * from atletaEsp

/*4.a*/
create or replace function verifica_esporte() returns trigger
as $$
declare
codesporte atleta.esporte%type;
begin
select into strict codesporte codesp from esporte
where descesp like new.esporte;
	insert into atleta (codatl, nome, bolsa, esporte) values
	(default, new.nome, new.bolsa, codesporte);
	raise notice 'Esporte Encontrado';
	return new;
exception
    when no_data_found then
	raise notice 'Esporte não encontrado';
        insert into esporte values(default, new.esporte);
       
	  select into  codesporte codesp from esporte
	   where descesp like new.esporte;

	 insert into atleta (codatl, nome, bolsa, esporte) values
	(default, new.nome, new.bolsa, codesporte);
	return new;
end;
$$ language plpgsql;

create trigger insere_view instead of insert on atletaEsp 
for each row execute procedure verifica_esporte()

	insert into atletaEsp values ('Gabriel Jesus',2000,'Futebol'); 
        insert into atletaEsp values('Diego Hipólito',2000,'Ginástica'); 
        insert into atletaEsp values('Guerreirinho',5000,'Ping Pong'); 
	select * from atletaEsp
	select * from atleta  
	
	select * from esporte 

/*questão 5 */
create or replace function quantidade_atletas(nomeesp varchar)
returns integer as $$
declare
codesporte esporte.codesp%type;
qtdesporte integer;
begin
select into strict codesporte codesp from esporte
where descesp like nomeesp;

select into qtdesporte count(codatl) from atleta
where esporte = codesporte;
  return qtdesporte;

exception
  when no_data_found then
      return 0; 
end;
$$ language plpgsql;

--testando com esporte existente
do $$
declare qtdlinhas integer;
begin
  select into qtdlinhas quantidade_atletas('Futebol');
  raise notice 'Quantidade de linhas = %',qtdlinhas;
end $$;

--testando com esporte inexistente
do $$
declare qtdlinhas integer;
begin
  select into qtdlinhas quantidade_atletas('Artes Marciais');
  raise notice 'Quantidade de linhas = %',qtdlinhas;
end $$;

--Questão 6 
SELECT current_time AT TIME ZONE 'Japan';
/*o codigo acima mostra o horario atual do pais passado como
parametro , que no caso é japão */

SELECT age(timestamp '2007-10-07');
/*o código acima  calcula a idade em anos, meses e dias
da data passada como parâmetro */

SELECT CAST(3.1415926535897 AS NUMERIC(7,2));
/*o código acima arredonda um numero em real em duas casas decimais */

SELECT CAST('06/04/2018' AS DATE) + INTERVAL '27 DAYS' AS Data;

/*o codigo calcula uma data mais um intervalo, que no caso é 27
dias, o resultado será a data mais os 27 dias*/
	   
		
		

   
  
  


