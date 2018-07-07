/*questão 6 */
create or replace function verifica_idade ()returns trigger
as $$
declare
idade integer;
begin
select into idade extract(year from age (new.datanasc)) from artista;
if idade < 14 then
 raise exception 'menor de idade';
end if;
return new;
exception
  when raise_exception then
    raise notice 'Muito jovem para este papel'
    using hint = 'Por favor, insira uma idade maior que 14 anos';
end;
$$ language plpgsql;

create trigger insere_idade_artista before insert on artista
for each row execute procedure verifica_idade()

insert into artista (codart, nomeart, datanasc) values (15, 'Picareta','2012-05-26');
insert into artista (codart, nomeart, datanasc) values (12, 'Heizemberg','1970-05-26');
select * from artista

/*o trigger foi definido como before, pois é necessário verificar
se a idade é permitida antes da inserção */
