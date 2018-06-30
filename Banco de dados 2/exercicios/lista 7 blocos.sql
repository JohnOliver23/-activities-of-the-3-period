/*questão 1 */
DO $$
Declare
nome varchar(40);
qtdelinhas integer;
BEGIN
select nomeart into nome from artista where codart = 2;
GET DIAGNOSTICS qtdelinhas := ROW_COUNT;
raise notice 'Nome artista = %', nome;
raise notice 'Quantidade de registros retornados = %',qtdelinhas;
END$$;
/* ele seleciona o artista com o codigo igual a 2 e imprime o seu nome
, retorna apensa um registro */

/*questão 2 */
DO $$
DECLARE
artreg artista%ROWTYPE;
info varchar(30);
BEGIN
artreg.codart := 14;
artreg.nomeart := 'Michael Keaton';
artreg.pais := 'USA';
Select artreg.nomeart || ' é do país '||artreg.pais into info;
raise notice 'Informação = %', info;
END$$;

/*ele cria um artista com o nome Micheal keaton do pais Usa
e depois imprime na tela,
o rowtype serve pra criar um registro do mesmo tipo da tabela
Artista*/
/*questão 3 */
alter table artista
add column indicacaooscar integer

DO $$
BEGIN
UPDATE artista
SET indicacaooscar = 10
WHERE codart = 100;
IF NOT FOUND THEN
INSERT INTO artista (codart, nomeart, indicacaooscar)
VALUES (100, 'XXX', 10);
END IF;
END$$;
/*ele tenta atualizar a coluna indicacaooscar onde codigo é igual a 
100, caso não exista o artista ele insere um novo registro na tabela
artista*/

/*questão 4 */
select * from testa_bloco
create table
testa_bloco (coluna1 integer, coluna2 date);

Do $$
DECLARE
I INT := 0;
BEGIN
WHILE I <= 10 LOOP
if(i % 3 = 0)then
	INSERT INTO TESTA_BLOCO(coluna1,coluna2)
	VALUES (I,current_date);
end if;
I := I + 1;
END LOOP;
END$$;
select * from testa_bloco;

/*questão 5 */
do $$
declare v_cursor cursor for select  f.titulo, c.desccateg from filme f
			join categoria c on f.codcateg
			= c.codcateg
			where c.desccateg like 'Aventura';
begin
for v_cat in v_cursor loop
  raise notice 'Filme %', v_cat.titulo;
  raise notice 'Categoria %', v_cat.desccateg;
end loop;
end $$

/*questão 6 */
do $$
declare v_cursor cursor for select  f.titulo, c.desccateg from filme f
			join categoria c on f.codcateg
			= c.codcateg
			where c.desccateg like 'Ação';
begin
for v_cat in v_cursor loop
  raise notice 'Filme %', v_cat.titulo;
  raise notice 'Categoria %', v_cat.desccateg;
end loop;
end $$

/*questão 7 */
Do $$
Declare
V_cursorTB cursor for select coluna1,coluna2 from testa_bloco;
Begin
for x in v_cursorTB loop
raise notice 'Coluna 2 = %', TO_CHAR(x.coluna2,'MM/DD/YYYY,HH:MI:SS');
end loop;
End$$;
/*o codigo acima pecorre todas as linhas da tabela testa_bloco
e os imprime, um cursor foi utilizado porq foi retornado mais de um
registro*/

/*rescrita */
do $$
declare 
x testa_bloco%rowtype;
v_date date;
begin
  for x in select coluna1,coluna2 from testa_bloco loop
   v_date := x.coluna2;
   raise notice 'Coluna 2 %', v_date;
  end loop;
end $$;		
			