
/* question 1 */
select titulo
from filme
where codest in (select codest
 from estudio
 where nomeest like 'P%'); 

 /*1.2*/
 select * from filme
 select distinct c.desccateg from categoria c join filme f on c.codcateg = f.codcateg

/*1.3*/
select a.nomeart from artista a join personagem p on p.codart = a.codart
where p.nomepers like 'Natalie'

/*1.4*/
select nomeart from artista 
where codart not in ( select codart from personagem )

select a.nomeart from artista a left join personagem p on p.codart = a.codart
where p.codart is null

/*1.5 */
select titulo
from filme
where codest in (select codest
 from estudio
 where nomeest like 'P%'); 

select f.titulo from filme f 
where exists( select e.codest from estudio e
	     where e.nomeest like 'P%' and e.codest = f.codest)

select * from filme
/*2 */
create table filmeEst as ( select f.titulo, e.nomeest from filme f join 
estudio e on f.codest = e.codest)

select * from filmeEst

/* 3 */
select nomeart
from artista
where codart in (select codart
 from personagem
 where codfilme in (select codfilme
 from filme
where duracao > 120))

select distinct a.nomeart from artista a join personagem p on a.codart = p.codart
join filme f on p.codfilme = f.codfilme 
where f.duracao > 120


/*4 */
select codart
from artista
where pais = 'USA'
INTERSECT
select codart
from personagem;
/*subquery */
select codart from artista
where pais = 'USA' 
AND codart in(
	select codart from personagem)

select distinct a.codart from artista a join personagem p on a.codart = p.codart
where a.pais ='USA'
/*5 */
select codart
from artista
EXCEPT
select codart
from personagem;

select codart from artista where codart not in (select codart from personagem)

select a.codart from artista a left join personagem p on a.codart = p.codart 
where p.codart is null

/*Question 6 */
select nomeart
from artista a join personagem p on a.codart = p.codart
where cache = (select max(cache) from personagem);





select * from personagem














 