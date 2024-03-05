CREATE TABLE usuarios (
    id_usuario SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    edad INTEGER NOT NULL,
    password VARCHAR(100) NOT NULL,
    rep_password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL,
    foto VARCHAR(255),
    rol VARCHAR(100),
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE mensajes (
    id_mensaje SERIAL PRIMARY KEY,
    creador_email VARCHAR(255) NOT NULL,
    destinatario_email VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    contenido TEXT,
    FOREIGN KEY (creador_email) REFERENCES usuarios(email),
    FOREIGN KEY (destinatario_email) REFERENCES usuarios(email)
);

CREATE TABLE partidas (
    id_partida SERIAL PRIMARY KEY,
    creador_email VARCHAR(255) NOT NULL,
    deporte VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    provincia VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    hora_comienzo TIME NOT NULL,
    hora_final TIME NOT NULL,
    participantes INTEGER NOT NULL,
    suplentes INTEGER NOT NULL,
    comentarios VARCHAR(100) NOT NULL,
    FOREIGN KEY (creador_email) REFERENCES usuarios(email)
);

CREATE TABLE partidas_de_usuarios (
    id SERIAL PRIMARY KEY,
    id_partida BIGINT NOT NULL,
    id_usuario BIGINT NOT NULL,
    FOREIGN KEY (id_partida) REFERENCES partidas(id_partida),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

CREATE TABLE sugerencias (
    id_sugerencia SERIAL PRIMARY KEY,
    descripcion TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    id_usuario BIGINT NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);