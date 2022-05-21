CREATE TABLE tb_socio(
    id_socio INT NOT NULL PRIMARY KEY,
    no_socio VARCHAR(50) NOT NULL,
    nu_cpf VARCHAR(14) NOT NULL
);

CREATE TABLE tb_dependente(
                              id_dependente INT NOT NULL PRIMARY KEY,
    no_dependente VARCHAR(50) NOT NULL,
    nu_cpf VARCHAR(14) NOT NULL,
    id_socio INT,
    FOREIGN KEY (id_socio) REFERENCES tb_socio(id_socio)
);

INSERT INTO tb_socio (id_socio, no_socio, nu_cpf) VALUES (1, 'Karine', '584.722.330-73');
INSERT INTO tb_dependente (id_dependente, no_dependente, nu_cpf, id_socio) VALUES (1, 'Pedro', '632.466.340-09', 1);
INSERT INTO tb_dependente (id_dependente, no_dependente, nu_cpf, id_socio) VALUES (2, 'Luciano', '565.984.130-95', 1);

INSERT INTO tb_socio (id_socio, no_socio, nu_cpf) VALUES (2, 'Marcos', '053.376.170-01');
INSERT INTO tb_dependente (id_dependente, no_dependente, nu_cpf, id_socio) VALUES (3, 'Patricia', '505.553.290-46', 2);




