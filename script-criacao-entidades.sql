DROP TABLE jogador;
CREATE TABLE jogador(
nome varchar(225),
altura float,
peso float,
idade int
);

DROP TABLE time;
CREATE TABLE time(
nome varchar(255)
);

DROP TABLE tecnico;
CREATE TABLE tecnico(
nome varchar(255),
idade int
);

DROP TABLE clube;
CREATE TABLE clube(
nome varchar(255),
nmPresidente varchar(255),
dtFundacao varchar(19),
site varchar(255)
);

-- adicionar um comentário a uma coluna de determinada tabela
comment on column clube.dtFundacao
  is 'dd/mm/yyyy';


