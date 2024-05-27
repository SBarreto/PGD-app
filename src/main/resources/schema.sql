create table if not exists entidad (
    codigosigep bigserial not null,
    nombre varchar not null,
    naturaleza_juridica varchar not null,
    orden varchar not null,
    sector varchar not null,
    codigomunicipio varchar not null,
    codigodepartamento bigserial not null,
    primary key (codigosigep)
);

create table if not exists formulariofurag(
    id bigserial not null,
    vigencia date not null,
    entidad_id bigserial references entidad(codigosigep),
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
    opcion_respuesta boolean not null,
    texto varchar not null,
    version int not null,
    puntaje int not null,
    evidencia varchar,
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
    opcion boolean,
    pregunta_ge_id varchar(255) references pregunta_ge,
    formulario_id bigserial references formulariofurag,
    primary key (id)
);

create table if not exists evidencia(
    id uuid not null DEFAULT gen_random_uuid(),
    texto varchar not null,
    alerta varchar,
    respuestage_id uuid references respuesta_ge,
    formulariofurag_id bigserial references formulariofurag,
    primary key (id)
    );

create table if not exists config_plantilla_furag(
    pregunta_id varchar (255) not null,
    fila int not null,
    primary key (pregunta_id)
);

create table if not exists puntaje (
    id uuid not null DEFAULT gen_random_uuid(),
    valor numeric(5, 2) not null,
    categoria varchar not null,
    vigencia date not null,
    entidad_id bigserial references entidad(codigosigep)
);

create table if not exists usuario (
    id bigserial not null,
    username varchar not null,
    password varchar not null,
    tipo varchar not null,
    entidad_id bigserial references entidad(codigosigep),
    primary key (id)
);