CREATE TABLE Estabelecimento (
	id INT,
	nome VARCHAR (100),
	estabelecimento VARCHAR(100),
	email VARCHAR(100),
	CPF_CNPJ VARCHAR(18),
	senha VARCHAR(100),
	PRIMARY KEY (id)	
);

INSERT INTO Estabelecimento
VALUES (1,'Vítor Nunes Macêdo', 'Barbearia do Vitim', 'vitinho@gmail.com', '16716716788', 'vitor');
