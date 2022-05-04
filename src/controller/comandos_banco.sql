CREATE TABLE tb_categoria(
	id serial PRIMARY KEY,
	nome VARCHAR(50)
);

CREATE TABLE tb_nivel(
	id serial PRIMARY KEY,
	nome VARCHAR(50)
);

CREATE TABLE tb_meses(
	id serial PRIMARY KEY,
	nome VARCHAR(50)
);

CREATE TABLE tb_funcao(
	id serial PRIMARY KEY,
	nome VARCHAR(50)
);

CREATE TABLE tb_produto(
	id serial PRIMARY KEY,
	id_categoria integer NOT NULL,
	nome VARCHAR(80),
	valorunitario double precision,
	CONSTRAINT fk_produto_categoria FOREIGN KEY (id_categoria) 
	    REFERENCES tb_categoria (id)
);

CREATE TABLE tb_balanco(
	id serial PRIMARY KEY,
	id_meses integer NOT NULL,
	ano VARCHAR(4),
	montante double precision,
	CONSTRAINT fk_balanco_meses FOREIGN KEY (id_meses) 
	    REFERENCES tb_meses (id)
);

CREATE TABLE tb_estoque(
	id serial PRIMARY KEY,
	id_categoria integer NOT NULL,
	nome VARCHAR(80),
	valorunitario double precision,
	CONSTRAINT fk_produto_categoria FOREIGN KEY (id_categoria) 
	    REFERENCES tb_categoria (id)
);

CREATE TABLE tb_fidelidade(
	id serial PRIMARY KEY,
	id_nivel integer NOT NULL,
	nome VARCHAR(80),
	CONSTRAINT fk_cliente_nivel FOREIGN KEY (id_nivel) 
	    REFERENCES tb_nivel (id)
);

CREATE TABLE tb_funcionario(
	id serial PRIMARY KEY,
	id_funcao integer NOT NULL,
	nome VARCHAR(80),
	salario double precision,
	CONSTRAINT fk_funcionario_funcao FOREIGN KEY (id_funcao) 
	    REFERENCES tb_funcao (id)
);

INSERT INTO tb_categoria (nome) VALUES ('Futebol'); 
INSERT INTO tb_categoria (nome) VALUES ('Academia');
INSERT INTO tb_categoria (nome) VALUES ('Võlei');
INSERT INTO tb_categoria (nome) VALUES ('Corrida');
INSERT INTO tb_categoria (nome) VALUES ('Luta');
INSERT INTO tb_categoria (nome) VALUES ('Natação');
INSERT INTO tb_categoria (nome) VALUES ('Tênis');
INSERT INTO tb_categoria (nome) VALUES ('Basquete'); 

INSERT INTO tb_meses (nome) VALUES ('Janeiro'); 
INSERT INTO tb_meses (nome) VALUES ('Fevereiro'); 
INSERT INTO tb_meses (nome) VALUES ('Março'); 
INSERT INTO tb_meses (nome) VALUES ('Abril'); 
INSERT INTO tb_meses (nome) VALUES ('Maio'); 
INSERT INTO tb_meses (nome) VALUES ('Junho'); 
INSERT INTO tb_meses (nome) VALUES ('Julho'); 
INSERT INTO tb_meses (nome) VALUES ('Agosto'); 
INSERT INTO tb_meses (nome) VALUES ('Setembro'); 
INSERT INTO tb_meses (nome) VALUES ('Outubro'); 
INSERT INTO tb_meses (nome) VALUES ('Novembro'); 
INSERT INTO tb_meses (nome) VALUES ('Dezembro'); 

INSERT INTO tb_nivel (nome) VALUES ('Bronze');
INSERT INTO tb_nivel (nome) VALUES ('Prata');
INSERT INTO tb_nivel (nome) VALUES ('Gold');
INSERT INTO tb_nivel (nome) VALUES ('Diamante');

INSERT INTO tb_funcao (nome) VALUES ('Limpeza');
INSERT INTO tb_funcao (nome) VALUES ('Caixa');
INSERT INTO tb_funcao (nome) VALUES ('Segurança');
INSERT INTO tb_funcao (nome) VALUES ('Vendedor');
INSERT INTO tb_funcao (nome) VALUES ('Estagiario');
INSERT INTO tb_funcao (nome) VALUES ('Gerente');