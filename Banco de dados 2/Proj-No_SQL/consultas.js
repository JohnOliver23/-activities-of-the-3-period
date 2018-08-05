/*consultas*/

 /*consultando todos os exames da clinica /1 colecao inteira/*/
 db.Exame.find({})
 
 /*consultando todos os pacientes da clinica /1 colecao inteira/*/
 db.Paciente.find({})
 
 /*consultando a quantidade de exames cadastrados no laboratório /1 contagem inteira/ */
 db.Exame.find({}).count()
 
 
 /*consultando os Exames que tenham o metodo treekap ou hashmap /1 consulta com filtro sem projecao/ */
 db.Exame.find({metodo:{$in:["treekap","hashmap"]}})
 
 /*consultando os exames acima de 50 reais /2 consulta com filtro sem projecao/ */
 db.Exame.find({valor:{$gt: 50}})
 
 /*consultando os pacientes que fizeram exames na primeira semana de junho / 3 consulta com filtro sem  projecao/ */
 db.Paciente.find({"exames.data_exame":{$gte: ISODate("2018-06-01T00:00:00.000Z"),$lt:ISODate("2018-06-07T00:00:00.000Z")}})
 
 /*consultando o nome, sexo, cidade e data de nascimento  dos pacientes de joão Pessoa /1 consulta com filtro com projecao/*/
 db.Paciente.find({"endereço.cidade":"JP"},{_id:0, nome:1, sexo: 1, data_nasc:1, "endereço.cidade": 1})
 
 /*consultando o nome, sexo e data de nascimento das pacientes mulheres que tenham nascido depois de 1992 // 2 consulta com filtro com projecao*/
 
 db.Paciente.aggregate([
           {
          $project:{
              paciente: "$nome",
              data_nascimento:  { $dateToString: { format: "%Y-%m-%d", date: "$data_nasc" } },
              year: {$year: "$data_nasc"},
              sexo: "$sexo",
              _id: 0
              
          }
      },
      {
          $match: {"year":{$gte:1992}, "sexo":"F"}
      }
 ])
 
 /*consultando o  nome do paciente, o nome dos exames que este fez e a data de nascimento dos pacientes que ja fizeram exame de HIV /3 consulta com filtro e projecao/  */
  db.Paciente.aggregate([
    {
     $lookup:
     {
         from:"Exame",
         localField:"exames.id_exame",
         foreignField:"_id",
         as: "Exame do paciente"
     }
 },
      {
          $match: {"Exame do paciente.nome":"HIV"}
      },
      {
          $project:{
              paciente: "$nome",
              data_nascimento:  { $dateToString: { format: "%Y-%m-%d", date: "$data_nasc" } },
              exames: "$Exame do paciente.nome",
              _id: 0
              
          }
      } 
 ])
      
/*consultando o nome e data de nascimento dos pacientes que nasceram no mes de julho /1 consulta com filtro, projecao e expressão regular/*/
db.Paciente.aggregate([
            {
          $project:{
              paciente: "$nome",
              data_nascimento:  { $dateToString: { format: "%Y-%m-%d", date: "$data_nasc" } },
              _id: 0
              
          }
      },
      {
          $match: {"data_nascimento":{$regex: /-07-/}}
      }
 ])
      
 /*consultando o nome dos pacientes, o primeiro email e o nome dos exames que eles fizeram /1 consulta com acesso de array/ */
 db.Paciente.aggregate([
    {
     $lookup:
     {
         from:"Exame",
         localField:"exames.id_exame",
         foreignField:"_id",
         as: "Exame do paciente"
     }
 },
       {
       $project:
         {
           paciente:"$nome",
           exames: "$Exame do paciente.nome",
           primeiroEmail: { $arrayElemAt: [ "$email", 0 ] },
           _id: 0
          

         }
     }
 ])
 
 /* consultando o nome e bairro dos pacientes que fizeram exames de glicose /1 consulta com acesso a estrutura embutida*/ 
  db.Paciente.aggregate([
    {
     $lookup:
     {
         from:"Exame",
         localField:"exames.id_exame",
         foreignField:"_id",
         as: "Exame do paciente"
     }
 },
      {
          $match: {"Exame do paciente.nome":"Glicose"}
      },
          {
          $project:
          {
              paciente: "$nome",
              bairro : "$endereço.bairro",
              _id: 0
          }
      }
      
 ])
      
 /*  consultando os materiais do laboratório e quantidade de exames que os utilizam /consulta com função de agregação/*/
   db.Exame.aggregate([{
    $group: {
       _id: "$material",
       quantidade: { $sum: 1}
    } }
]);
    /*consultando todos os metodos utilizados no laboratorio em ordem alfabetica / consulta utlizando distinct */
    db.Exame.distinct("metodo",{"metodo":{$ne: null}}).sort()

  /*consultando a quantidade de vezes que o exame hemograma foi solicitado /consulta a meu criterio/  */
 db.Paciente.aggregate([
    {
     $lookup:
     {
         from:"Exame",
         localField:"exames.id_exame",
         foreignField:"_id",
         as: "Exame do paciente"
     }
 },
      {
          $match: {"Exame do paciente.nome":"Hemograma"}
      },
      {
          $count:"quantidade de hemogramas solicitados"
      }

 ])