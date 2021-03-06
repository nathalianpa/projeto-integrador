CREATE DATABASE PETFELIZ;

CREATE TABLE PETFELIZ.PRODUTO (
  ID           BIGINT        NOT NULL AUTO_INCREMENT,
  NOME         VARCHAR(100)  NOT NULL,
  MARCA        VARCHAR(100)  NOT NULL,
  DESCRICAO    VARCHAR(1000) NULL,
  PRECO_COMPRA DECIMAL(9,2)  NOT NULL,
  PRECO_VENDA  DECIMAL(9,2)  NOT NULL,
  QUANTIDADE   INT           NOT NULL DEFAULT 0,
  DT_CADASTRO  TIMESTAMP     NOT NULL,
  CONSTRAINT PK_PRODUTO PRIMARY KEY (ID)
);

CREATE TABLE PETFELIZ.CATEGORIA (
  ID   INT          NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(100) NOT NULL,
  CONSTRAINT PK_CATEGORIA PRIMARY KEY (ID),
  CONSTRAINT UC_NOME UNIQUE (NOME)
);

CREATE TABLE PETFELIZ.PRODUTO_CATEGORIA (
    ID_PRODUTO   BIGINT NOT NULL,
    ID_CATEGORIA INT    NOT NULL,
    CONSTRAINT FK_PRODUTO FOREIGN KEY (ID_PRODUTO) REFERENCES PETFELIZ.PRODUTO(ID),
    CONSTRAINT FK_CATEGORIA FOREIGN KEY (ID_CATEGORIA) REFERENCES PETFELIZ.CATEGORIA(ID)
);

CREATE TABLE PETFELIZ.CLIENTE (
  ID BIGINT NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(100) NOT NULL,
  ENDERECO VARCHAR(80),
  BAIRRO VARCHAR(80),
  CIDADE VARCHAR(80),
  ESTADO VARCHAR(2),
  CEP VARCHAR(9),
  SEXO VARCHAR(1),
  TELEFONE VARCHAR(14),
  CELULAR VARCHAR(14),
  CADASTRO TIMESTAMP NOT NULL,  
  ATIVO VARCHAR(1),  
  CONSTRAINT PK_CLIENTE PRIMARY KEY (ID)
);

CREATE TABLE PETFELIZ.FUNCIONARIO (
  ID BIGINT  NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(100) NOT NULL, 
  CARGO VARCHAR(80) NOT NULL,
  ENDERECO VARCHAR(80),
  BAIRRO VARCHAR(80),
  CIDADE VARCHAR(80),
  ESTADO VARCHAR(2),
  CEP VARCHAR(9),
  SEXO VARCHAR(1),
  TELEFONE VARCHAR(14),
  CELULAR VARCHAR(14),
  CADASTRO TIMESTAMP NOT NULL,
  ATIVO VARCHAR(14),  
  CONSTRAINT PK_VENDEDOR PRIMARY KEY (ID)
);

CREATE TABLE PETFELIZ.USUARIOS (
	ID BIGINT  NOT NULL AUTO_INCREMENT,
    CONSTRAINT PK_USUARIO PRIMARY KEY (ID),
    LOGIN VARCHAR(20) NOT NULL,
    NOME VARCHAR(50) NOT NULL,
    SENHA VARCHAR(10) NOT NULL,
    ATIVO VARCHAR(1)
);

CREATE TABLE PETFELIZ.FUNCIONARIO_USUARIOS (
    ID_FUNCIONARIO   BIGINT NOT NULL,
    ID_USUARIOS BIGINT NOT NULL,
    CONSTRAINT FK_FUNCIONARIO FOREIGN KEY (ID_FUNCIONARIO) REFERENCES PETFELIZ.FUNCIONARIO(ID),
    CONSTRAINT FK_USUARIOS FOREIGN KEY (ID_USUARIOS) REFERENCES PETFELIZ.USUARIOS(ID)
);

CREATE TABLE PETFELIZ.VENDA (
  ID BIGINT  NOT NULL AUTO_INCREMENT,
  CONSTRAINT PK_VENDA PRIMARY KEY (ID),
  ID_CLIENTE BIGINT NOT NULL,
  ID_FUNCIONARIO BIGINT NOT NULL,
  ID_PRODUTO BIGINT NOT NULL,
  QUANTIDADE INT NOT NULL,
  DT_VENDA TIMESTAMP NOT NULL,
  CONSTRAINT FK_VENDA_ID_CLIENTE FOREIGN KEY (ID_CLIENTE) REFERENCES PETFELIZ.CLIENTE(ID),
  CONSTRAINT FK_VENDA_ID_FUNCIONARIO FOREIGN KEY (ID_FUNCIONARIO) REFERENCES PETFELIZ.FUNCIONARIO(ID),
  CONSTRAINT FK_VENDA_ID_PRODUTO FOREIGN KEY (ID_PRODUTO) REFERENCES PETFELIZ.PRODUTO(ID)
);
INSERT INTO PETFELIZ.USUARIOS(LOGIN,NOME,SENHA,ATIVO) VALUES ("admin","Administrador","1234","S");
INSERT INTO PETFELIZ.CATEGORIA(NOME) VALUES ("Unisex");
INSERT INTO PETFELIZ.CATEGORIA(NOME) VALUES ("Masculina");
INSERT INTO PETFELIZ.CATEGORIA(NOME) VALUES ("Feminina");
INSERT INTO PETFELIZ.CATEGORIA(NOME) VALUES ("Infantil");
