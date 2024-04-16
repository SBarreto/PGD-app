delete
from respuesta;
delete
from pregunta;
delete
from formulariofurag;

insert into formulariofurag
values (67,
        '2017-03-14');

insert into pregunta
values ('GDI123',
        'enunciado de esta pregunta', 'SEGURIDAD');

insert into pregunta_formulariofurag
    values (
               'GDI123', 67
);

insert into pregunta_ge
values (
        'GDI123GE1',
        'enunciado de pregunta de gestion extendida',
        'evidencia sugerida pdf',
        'rol sugerido xxxx',
        'GDI123'
       );

insert into respuesta_ge
values (
        gen_random_uuid(),
        'texto de esta respuesta',
        'GDI123GE1',
        67
       );