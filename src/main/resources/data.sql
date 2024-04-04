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