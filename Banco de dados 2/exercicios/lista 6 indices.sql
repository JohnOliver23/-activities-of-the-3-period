
/*questão 1 */
create table testaFilme as select * from filme;
select * from testafilme;

DO $$DECLARE i int:= 0;
BEGIN
    WHILE I <= 200000 LOOP
             INSERT INTO testafilme select * from filme;
             I := I + 1;
    END LOOP;
END$$;

select titulo from testafilme order by titulo; 
EXPLAIN select titulo from testafilme order by titulo; 
create index testaFilmeindex on testafilme(titulo);

select relpages from pg_class where relname = 'filme';
select relpages from pg_class where relname = 'testafilme';

/*questão 2 */
select titulo from testafilme where ano = 2010; 
explain select titulo from testafilme where ano = 2010; 

/*questão 3 */
create index ind_pais on Artista
select pais from artista
/*seria indicado caso precisasse consultar os artistas
 pelo pais com where e order by */

 /*questão 4 */
 /*criaria indice para a duracao caso precisase pesquisar os filmes que tenha
a duração maior que 100 por exemplo codfilme não seria indicado 
pois como é pk, automaticamente o indice já é criado*/

/*questão 5 */
/*os indices identificam um determinado assunto e localiza a sua posição em
uma determinada página, extraindo somente aqueles registros que satisfazem
os critérios da consulta


