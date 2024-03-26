create table if not exists entidad (
    id bigserial not null,
    nombre varchar not null,
    codigo varchar not null,
    codigodivipola varchar not null,
    primary key (id)
);

create table if not exists municipio (
    codigo bigserial not null,
    nombre varchar not null,
    primary key (codigo)
);

create table if not exists  departamento(
    codigo bigserial not null,
    nombre varchar not null,
    primary key (codigo)
);

create table if not exists formulariofurag(
    id bigserial not null,
    vigencia date not null,
    primary key (id)
);

create table if not exists pregunta (
    id varchar(255) not null,
    enunciado varchar not null,
    elemento varchar not null,
    primary key(id),
    idformulariofurag bigserial references formulariofurag(id)
);

create table if not exists respuesta (
    id uuid not null default gen_random_uuid() primary key,
    texto varchar not null,
    version int not null,
    idpregunta varchar references pregunta,
    identidad bigserial references entidad(id)
);