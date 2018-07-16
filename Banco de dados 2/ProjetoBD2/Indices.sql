
/* Indice para o nome dos pacientes */
 CREATE INDEX ind_nome_pac ON
paciente(nome);

/* Indice para o uf dos pacientes */
CREATE INDEX ind_uf_pac ON
paciente(uf);

/* Indice para o a data de atendimento dos pacientes */
CREATE INDEX ind_at_pac ON
atendimento(data_hora);
