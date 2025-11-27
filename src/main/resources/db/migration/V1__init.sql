CREATE TABLE IF NOT EXISTS conteudos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(1000) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('CURSO','MENTORIA'))
);

CREATE TABLE IF NOT EXISTS cursos (
    id INTEGER PRIMARY KEY REFERENCES conteudos(id) ON DELETE CASCADE,
    carga_horaria INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS mentorias (
    id INTEGER PRIMARY KEY REFERENCES conteudos(id) ON DELETE CASCADE,
    data DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS bootcamps (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(1000) NOT NULL,
    data_inicial DATE NOT NULL,
    data_final DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS bootcamp_conteudos (
    bootcamp_id INTEGER NOT NULL REFERENCES bootcamps(id) ON DELETE CASCADE,
    conteudo_id INTEGER NOT NULL REFERENCES conteudos(id) ON DELETE CASCADE,
    PRIMARY KEY (bootcamp_id, conteudo_id)
);

CREATE TABLE IF NOT EXISTS devs (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS devs_inscritos (
    dev_id INTEGER NOT NULL REFERENCES devs(id) ON DELETE CASCADE,
    conteudo_id INTEGER NOT NULL REFERENCES conteudos(id) ON DELETE CASCADE,
    PRIMARY KEY (dev_id, conteudo_id)
);

CREATE TABLE IF NOT EXISTS devs_concluidos (
    dev_id INTEGER NOT NULL REFERENCES devs(id) ON DELETE CASCADE,
    conteudo_id INTEGER NOT NULL REFERENCES conteudos(id) ON DELETE CASCADE,
    PRIMARY KEY (dev_id, conteudo_id)
);

