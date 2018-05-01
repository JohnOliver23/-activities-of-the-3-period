/*questão 1 */
update artista
set cidade = 'Hollywood'
where cidade is null

/*questão 2 */
insert into artista values(9, 'Pah ferreira','Joao pessoa','Brasil','25/01/1992');

/*questão 3 */
select * from filme
where duracao > 135

/*questão 4 */
select f.titulo, c.desccateg categoria from filme f join categoria c
on c.codcateg = f.codcateg
where f.titulo like 'Encontro Explosivo'

/*questão 5 */ 
select a.nomeart from artista a join personagem p on p.codart = a.codart
join filme f on f.codfilme = p.codfilme
where f.titulo like 'Encontro Explosivo'

/*questão 6 */
insert into filme values (9,'terror em ihc',2018,160,6,1)
insert into filme values (10,'teror em poo',2018,150,6,2)
insert into personagem values (8, 9, 'neil pistol',1000);
insert into personagem values (8, 10, 'neil John',1000);

/*questão 7 */
select a.nomeart from artista a join personagem p on
p.codart = a.codart join filme f on f.codfilme = p.codfilme join categoria
c on c.codcateg = f.codcateg
where a.nomeart like 'B%' and c.desccateg like 'Aventura'

/*Questão 8 */
select f.titulo filme, e.nomeest estudio, c.desccateg categoria
from categoria c join filme f on c.codcateg = f.codcateg  join
estudio e on e.codest = f.codest

/*questão 9 */
select c.desccateg categoria, count(f.titulo) from categoria c join filme f
on f.codcateg = c.codcateg
group by c.desccateg

/*questão 10 */ 

select  count(p.codart) qtdartistas from personagem p
join filme f on f.codfilme = p.codfilme join categoria c
on c.codcateg = f.codcateg
where c.desccateg like 'Romance'

/*Questão 11 */
select a.nomeart, p.nomepers
from artista a left outer join personagem p on a.codart = p.codart;
/*mostra todos os artistas mesmo que não tenham atuado em nenhum filme*/

/*questão 12 */
select nomeart from artista 
where codart in( select codart from personagem
		 where cache >  (select avg(cache)
				  from personagem))
				 