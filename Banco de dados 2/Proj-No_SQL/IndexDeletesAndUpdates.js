/*indices */
/*INDICES DE METODO E DATA_NASC */
db.Exame.createIndex({metodo: 1})
db.Paciente.createIndex({data_nasc: 1})

/*deletes*/
/*DELETANDO O EXAME DE ANEMIA DA CL�NICA */
db.Exame.deleteOne({nome: "Anemia"})

/*Updates */
/*Atualizando o valor dos exames que s�o 40 para 60 */
db.Exame.updateMany({valor: 40},{$set:{"valor": 60}})