/*questão 7 */
Create or Replace function calculaBonus (empid IN Integer, bonus OUT
Numeric)
as $$
Declare
Data Date;
qtde_anos integer;
BEGIN
SELECT salario * 0.10, dataadmissao INTO bonus, data FROM empregado
WHERE matricula = empid;
IF bonus IS NULL THEN
RAISE exception 'bonus_exc';
END IF;
qtde_anos = (extract(year from current_date)) - (extract(year from data));

IF qtde_anos > 10 THEN
bonus = bonus + 500;
END IF;
EXCEPTION
WHEN raise_exception THEN
Raise notice 'Bonus inexistente';
end;
$$ LANGUAGE 'plpgsql';
select * from empregado;

/*questão 8 */


Do $$
declare vbonus numeric;
begin
vbonus = calculaBonus(200);
raise notice 'Bonus = %', vbonus;
end $$;

/*o codigo acima envia dois codigos cmo parametros, empid 
como entrada e bonus como saida, primeiro ele insere no parametro
de saida 10 por cento do salario do empregado,
em seguida ele verifica se a data de admissão do empregado é maior que 10 anos
se a data de admissão for mais que 10 anos o seu bonus vai ser os 10 por cento
do salario + 500, se não , vai ser só os 10 por cento, caso o id 
enviado seja nulo, dá uma excessão deBonus inexistente.*/

/*questão 8 */
CREATE or replace FUNCTION selectDinamico (text)
RETURNS INTEGER AS $$
DECLARE
vtabela alias for $1;
vSQL text;
reg record;
BEGIN
vSQL := 'SELECT * FROM ' || vtabela;
FOR reg IN EXECUTE vSQL LOOP
raise notice 'Registro';
END LOOP;
RETURN 1;
END;
$$ LANGUAGE plpgsql;
select selectDinamico('Empregado');
select * from empregado
/*a função acima recebe o nome de uma tabela como parâmetro e ,
pra cada linha q a tabela tiver, ela imprime a palavra 'Registro'*/


