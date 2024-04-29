delete
from respuesta;
delete
from pregunta;
delete
from formulariofurag;

insert into entidad
values (2,
        'Ministerio de relaciones exteriores',
        'Ministerio',
        'Nacional',
        'Relaciones Exteriores',
        '11001',
        11);


insert into formulariofurag
values (67,
        '2017-03-14',
        2);

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
        'evidencia de esta respuesta',
        true,
        'GDI123GE1',
        67
       );

insert into config_plantilla_furag
values ('GDI260A', 'Fueron aprobados por el Comité de Gestión y Desempeño Institucional, y se incluyeron en el PETI', 274),
       ('GDI260B', 'Fueron aprobados por el Comité de Gestión y Desempeño Institucional, pero no se incluyeron en el PETI', 274),
       ('GDI260C', 'Ninguna de las anteriores', 274),
       ('GDI261A', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: A. La habilitación o mejora en la provisión de trámites y servicios digitales a los ciudadanos (nuevos servicios, más cobertura, mayor inclusión, menores tiempos, menores costos, etc.).', 275),
       ('GDI261B', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: B. La habilitación o mejora de procesos internos de la entidad (más eficientes, menos costos, más seguros, etc.).', 276),
       ('GDI261C', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: C. La toma de decisiones basada en datos a partir del aumento en el uso y aprovechamiento de la información.', 277),
       ('GDI261D', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: D. El impulso al desarrollo de territorios y ciudades inteligentes para la solución de retos y problemáticas sociales.', 278),
       ('GDI261E', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: E. El empoderamiento a los ciudadanos como Estado Abierto habilitando el acceso a información pública generada por la entidad y procesos de participación ciudadana.', 279),
       ('GDI261F', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: F. Otros. ¿Cuáles?:', 280),
       ('GDI262A', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? A. Uso de infraestructura de datos dando cumplimiento al Plan Nacional de Infraestructura de Datos, la línea de acción de decisiones basadas en datos y el habilitador de seguridad y privacidad de la información', 281),
       ('GDI262B', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Interoperabilidad entre los sistemas de información públicos para suministro e intercambio de la información conforme a los principios señalados en la Ley 1581 de 2012', 282),
       ('GDI262C', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de mecanismos de digitalización y automatización de trámites, servicios y procesos y su vinculación al Portal Único del Estado Colombiano', 283),
       ('GDI262D', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de mecanismos de agregación de demanda, como acuerdos marco de precios vigentes u otros mecanismos que hayan sido establecidos por la Agencia Nacional de Contratación Pública o la modalidad de contratación contenida en el marco de la Política de compras y contratación pública', 284),
       ('GDI262E', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Implementación, migración y uso de servicios de nube, en armonía con el principio de neutralidad tecnológica y normatividad vigente', 285),
       ('GDI262F', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de mecanismos exploratorios de regulación como Sandbox', 286),
       ('GDI262G', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de tecnologías emergentes tales como inteligencia artificial, internet de las cosas (IoT), big data o blockchain', 287),
       ('GDI262H', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Ninguno de los anteriores', 288);

insert into pregunta
values ('GDI260A', 'Fueron aprobados por el Comité de Gestión y Desempeño Institucional, y se incluyeron en el PETI', 'Transformacion Digital'),
       ('GDI260B', 'Fueron aprobados por el Comité de Gestión y Desempeño Institucional, pero no se incluyeron en el PETI', 'Transformacion Digital'),
       ('GDI260C', 'Ninguna de las anteriores', 'Transformacion Digital'),
       ('GDI261A', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: A. La habilitación o mejora en la provisión de trámites y servicios digitales a los ciudadanos (nuevos servicios, más cobertura, mayor inclusión, menores tiempos, menores costos, etc.).', 'Transformacion Digital'),
       ('GDI261B', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: B. La habilitación o mejora de procesos internos de la entidad (más eficientes, menos costos, más seguros, etc.).', 'Transformacion Digital'),
       ('GDI261C', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: C. La toma de decisiones basada en datos a partir del aumento en el uso y aprovechamiento de la información.', 'Transformacion Digital'),
       ('GDI261D', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: D. El impulso al desarrollo de territorios y ciudades inteligentes para la solución de retos y problemáticas sociales.', 'Transformacion Digital'),
       ('GDI261E', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: E. El empoderamiento a los ciudadanos como Estado Abierto habilitando el acceso a información pública generada por la entidad y procesos de participación ciudadana.', 'Transformacion Digital'),
       ('GDI261F', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: F. Otros. ¿Cuáles?:', 'Transformacion Digital'),
       ('GDI262A', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? A. Uso de infraestructura de datos dando cumplimiento al Plan Nacional de Infraestructura de Datos, la línea de acción de decisiones basadas en datos y el habilitador de seguridad y privacidad de la información', 'Transformacion Digital'),
       ('GDI262B', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Interoperabilidad entre los sistemas de información públicos para suministro e intercambio de la información conforme a los principios señalados en la Ley 1581 de 2012', 'Transformacion Digital'),
       ('GDI262C', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de mecanismos de digitalización y automatización de trámites, servicios y procesos y su vinculación al Portal Único del Estado Colombiano', 'Transformacion Digital'),
       ('GDI262D', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de mecanismos de agregación de demanda, como acuerdos marco de precios vigentes u otros mecanismos que hayan sido establecidos por la Agencia Nacional de Contratación Pública o la modalidad de contratación contenida en el marco de la Política de compras y contratación pública', 'Transformacion Digital'),
       ('GDI262E', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Implementación, migración y uso de servicios de nube, en armonía con el principio de neutralidad tecnológica y normatividad vigente', 'Transformacion Digital'),
       ('GDI262F', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de mecanismos exploratorios de regulación como Sandbox', 'Transformacion Digital'),
       ('GDI262G', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de tecnologías emergentes tales como inteligencia artificial, internet de las cosas (IoT), big data o blockchain', 'Transformacion Digital'),
       ('GDI262H', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Ninguno de los anteriores', 'Transformacion Digital');

insert into pregunta_formulariofurag
values ('GDI260A', 67),
       ('GDI260B', 67),
       ('GDI260C', 67),
       ('GDI261A', 67),
       ('GDI261B', 67),
       ('GDI261C', 67),
       ('GDI261D', 67),
       ('GDI261E', 67),
       ('GDI261F', 67),
       ('GDI262A', 67),
       ('GDI262B', 67),
       ('GDI262C', 67),
       ('GDI262D', 67),
       ('GDI262E', 67),
       ('GDI262F', 67),
       ('GDI262G', 67),
       ('GDI262H', 67);

insert into pregunta_ge
values ('GDI260AGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260A'),
       ('GDI260AGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260A'),
       ('GDI260AGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260A'),
       ('GDI260AGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260A'),
       ('GDI260AGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260A'),

       ('GDI260BGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260B'),
       ('GDI260BGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260B'),
       ('GDI260BGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260B'),
       ('GDI260BGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260B'),
       ('GDI260BGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260B'),

       ('GDI260CGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260C'),
       ('GDI260CGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260C'),
       ('GDI260CGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260C'),
       ('GDI260CGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260C'),
       ('GDI260CGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260C'),

       ('GDI261AGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261A'),
       ('GDI261AGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261A'),
       ('GDI261AGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261A'),
       ('GDI261AGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261A'),
       ('GDI261AGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261A'),

       ('GDI261BGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261B'),
       ('GDI261BGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261B'),
       ('GDI261BGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261B'),
       ('GDI261BGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261B'),
       ('GDI261BGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261B'),

       ('GDI261CGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261C'),
       ('GDI261CGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261C'),
       ('GDI261CGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261C'),
       ('GDI261CGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261C'),
       ('GDI261CGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261C'),

       ('GDI261DGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261D'),
       ('GDI261DGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261D'),
       ('GDI261DGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261D'),
       ('GDI261DGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261D'),
       ('GDI261DGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261D'),

       ('GDI261EGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261E'),
       ('GDI261EGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261E'),
       ('GDI261EGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261E'),
       ('GDI261EGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261E'),
       ('GDI261EGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261E'),

       ('GDI261FGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261F'),
       ('GDI261FGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261F'),
       ('GDI261FGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261F'),
       ('GDI261FGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261F'),
       ('GDI261FGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261F'),

       ('GDI262AGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262A'),
       ('GDI262AGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262A'),
       ('GDI262AGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262A'),
       ('GDI262AGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262A'),
       ('GDI262AGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262A'),

       ('GDI262BGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262B'),
       ('GDI262BGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262B'),
       ('GDI262BGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262B'),
       ('GDI262BGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262B'),
       ('GDI262BGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262B'),

       ('GDI262CGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262C'),
       ('GDI262CGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262C'),
       ('GDI262CGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262C'),
       ('GDI262CGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262C'),
       ('GDI262CGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262C'),

       ('GDI262DGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262D'),
       ('GDI262DGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262D'),
       ('GDI262DGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262D'),
       ('GDI262DGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262D'),
       ('GDI262DGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262D'),

       ('GDI262EGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262E'),
       ('GDI262EGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262E'),
       ('GDI262EGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262E'),
       ('GDI262EGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262E'),
       ('GDI262EGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262E'),

       ('GDI262FGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262F'),
       ('GDI262FGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262F'),
       ('GDI262FGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262F'),
       ('GDI262FGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262F'),
       ('GDI262FGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262F'),

       ('GDI262GGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262G'),
       ('GDI262GGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262G'),
       ('GDI262GGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262G'),
       ('GDI262GGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262G'),
       ('GDI262GGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262G'),

       ('GDI262HGE1', 'El comité de gestión y desempeño aprobó los entregables del proceso de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262H'),
       ('GDI262HGE2', 'El PETI esta sustentando en un ejercicio de arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262H'),
       ('GDI262HGE3', 'Actas de decisiones de arquitectura de comité de gestión y desempeño institucional', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262H'),
       ('GDI262HGE4', 'Plan de uso y apropiacion a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262H'),
       ('GDI262HGE5', 'Promoción de habilitadores y la relación con la transformación digital a los participantes del comité?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262H');

insert into respuesta_ge
values (gen_random_uuid(), 'evidencia de esta respuesta', true, 'GDI260AGE1', 67),
       (gen_random_uuid(), 'evidencia de esta respuesta', false, 'GDI260AGE2', 67),
       (gen_random_uuid(), 'evidencia de esta respuesta', true, 'GDI260AGE3', 67),
       (gen_random_uuid(), 'evidencia de esta respuesta', true, 'GDI260AGE4', 67),
       (gen_random_uuid(), 'evidencia de esta respuesta', true, 'GDI260AGE5', 67);

insert into puntaje
values (gen_random_uuid(), 78, 'Transformacion Digital', '2017-03-14', 2);
