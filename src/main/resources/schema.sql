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
    primary key(id)
);

create table if not exists respuesta (
    id uuid not null default gen_random_uuid() primary key,
    texto varchar not null,
    version int not null,
    pregunta_id varchar(255) references pregunta,
    formulario_id bigserial references formulariofurag
);

create table if not exists pregunta_formulariofurag (
    pregunta_id varchar(255) not null,
    formulario_id bigserial not null
);

create table if not exists pregunta_ge(
    id varchar(255) not null,
    enunciado varchar not null,
    evidencia_sugerida varchar not null,
    rol_sugerido varchar not null,
    pregunta_id varchar(255) references pregunta,
    primary key (id)
);

create table if not exists respuesta_ge(
    id uuid not null,
    texto varchar,
    pregunta_ge_id varchar(255) references pregunta_ge,
    formulario_id bigserial references formulariofurag,
    primary key (id)
);
