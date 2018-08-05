/*Inserts dos pacientes*/
 db.Paciente.insertMany([
 {nome: "John",
 sexo: "M",
 data_nasc: new Date("1993-12-01"),
 email:["johnoliver021@gmail.com", "oliver0193@hotmail.com"],
 endereço:{
           uf: "PB",
	   bairro: "Cruz das Armas",
	   cidade: "JP"},
 exames:[
	{data_exame: new Date("2018-05-17"),
	 id_exame:db.Exame.find({nome: "HIV"},{id:1}).map(function(x){return x._id})},
	 {data_exame: new Date("2018-06-14"),
	  id_exame: db.Exame.find({nome: "Urina"},{id:1}).map(function(x){return x._id})},
	]},
 {nome: "Kamila Freitas",
 sexo: "F",
 data_nasc: new Date("1991-09-06"),
 email:["kamilafreitas@gmail.com", "kamilaape@hotmail.com"],
 endereço:{
           uf: "PB",
	   bairro: "centro",
	   cidade: "CG"},
 exames:[
	{data_exame: new Date("2018-05-18"),
	 id_exame:db.Exame.find({nome: "Glicose"},{id:1}).map(function(x){return x._id})},
	 {data_exame: new Date("2018-06-19"),
	  id_exame: db.Exame.find({nome: "Hemograma"},{id:1}).map(function(x){return x._id})},
	]},
 {nome: "Mahommed Salah",
 sexo: "M",
 data_nasc: new Date ("1990-05-12"),
 email:["salah@gmail.com", "salahlive@hotmail.com"],
 endereço:{
           uf: "PB",
	   bairro: "Jaguaribe",
	   cidade: "JP"},
 exames:[
	{data_exame: new Date("2018-05-20"),
	 id_exame:db.Exame.find({nome: "Hemograma"},{id:1}).map(function(x){return x._id})},
	 {data_exame: new Date("2018-06-14"),
	  id_exame: db.Exame.find({nome: "Parasitologico"},{id:1}).map(function(x){return x._id})},
	]},
 {nome: "Antonie Griezman",
 sexo: "M",
 data_nasc: new Date("1988-04-01"),
 email:["griezman@gmail.com", "griz9@hotmail.com"],
 endereço:{
           uf: "PB",
	   bairro: "Torre",
	   cidade: "JP"},
 exames:[
	{data_exame: new Date("2018-05-27"),
	 id_exame: db.Exame.find({nome:{$in:["Urina","Hemograma"]}}).map(function(x){return x._id})}
        
     ]},
 {nome: "Paolo Guereiro",
 sexo: "M",
 data_nasc: new Date("1982-04-01"),
 email:["guerreiro@gmail.com", "guerreirofla9@hotmail.com"],
 endereço:{
           uf: "PB",
	   bairro: "Torre",
	   cidade: "JP"},
 exames:[
	{data_exame: new Date("2018-05-30"),
	 id_exame: db.Exame.find({nome:{$in:["Parasitologico","Hemograma","HIV"]}}).map(function(x){return x._id})}
        
     ]},
 {nome: "Yanne Mito",
 sexo: "F",
 data_nasc: new Date("1990-07-25"),
 email:["yanne@gmail.com", "yanne@hotmail.com"],
 endereço:{
           uf: "PB",
	   bairro: "Cruz das Armas",
	   cidade: "JP"},
 exames:[
	{data_exame: new Date("2018-06-02"),
	 id_exame: db.Exame.find({nome:{$in:["Glicose","Hemograma","Triglicerideos"]}}).map(function(x){return x._id})}
        
     ]},
 {nome: "Nou Nou Pistola",
 sexo: "F",
 data_nasc: new Date("1995-07-20"),
 email:["nounou@gmail.com", "nounou@hotmail.com"],
 endereço:{
           uf: "PB",
	   bairro: "Cristo",
	   cidade: "JP"},
 exames:[
	{data_exame: new Date("2018-04-02"),
	 id_exame: db.Exame.find({nome:{$in:["Glicose","Hemograma","Colesterol"]}}).map(function(x){return x._id})}
        
     ]},
 {nome: "Larissa Moreira",
 sexo: "F",
 data_nasc: new Date("1996-05-30"),
 email:["larissa@gmail.com", "larissa@hotmail.com"],
 endereço:{
           uf: "PB",
	   bairro: "Cruz das Armas",
	   cidade: "JP"},
 exames:[
	{data_exame: new Date("2018-06-05"),
	 id_exame: db.Exame.find({nome:{$in:["Glicose","Colesterol","Triglicerideos"]}}).map(function(x){return x._id})}
     ]},
 {nome: "Paul Pogba",
 sexo: "M",
 data_nasc: new Date("1992-08-30"),
 email:["pogba@gmail.com", "pogba@hotmail.com"],
 endereço:{
           uf: "PB",
	   bairro: "Torre",
	   cidade: "JP"},
 exames:[
	{data_exame: new Date("2018-06-06"),
	 id_exame: db.Exame.find({nome:{$in:["Hemograma","Glicose"]}}).map(function(x){return x._id})},
        {data_exame: new Date("2018-06-20"),
	 id_exame: db.Exame.find({nome:{$in:["HIV","Colesterol"]}}).map(function(x){return x._id})}
     ]}, 
 {nome: "Mbappe",
 sexo: "M",
 data_nasc: new Date("1998-11-30"),
 email:["mbappe@gmail.com", "mbappe@hotmail.com"],
 endereço:{
           uf: "PB",
	   bairro: "Jaguaribe",
	   cidade: "JP"},
 exames:[
	{data_exame: new Date("2018-06-15"),
	 id_exame: db.Exame.find({nome:{$in:["Triglicerideos","Urina"]}}).map(function(x){return x._id})},
        {data_exame: new Date("2018-06-25"),
	 id_exame: db.Exame.find({nome:{$in:["Parasitologico","Colesterol"]}}).map(function(x){return x._id})}
     ]}
])
 