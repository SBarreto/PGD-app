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
values (1,
        '2022-01-01',
        2);

insert into formulariofurag
values (2,
        '2022-01-01',
        2);

insert into formulariofurag
values (3,
        '2022-01-01',
        2);

insert into config_plantilla_furag
values ('GDI260A', 10),
       ('GDI261A', 11),
       ('GDI261B', 12),
       ('GDI261C', 13),
       ('GDI261D', 14),
       ('GDI261E', 15),
       ('GDI262A', 16),
       ('GDI262B', 17),
       ('GDI262C', 18),
       ('GDI262D', 19),
       ('GDI262E', 20),
       ('GDI262F', 21),
       ('GDI262G', 22);

insert into pregunta
values ('GDI260A', 'Con respecto a los Proyectos de Transformación Digital formulados o ejecutados por la entidad durante la vigencia 2022: A. Fueron aprobados por el Comité de Gestión y Desempeño Institucional, y se incluyeron en el PETI.', 'Transformacion Digital'),
       ('GDI261A', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: A. La habilitación o mejora en la provisión de trámites y servicios digitales a los ciudadanos (nuevos servicios, más cobertura, mayor inclusión, menores tiempos, menores costos, etc.).', 'Transformacion Digital'),
       ('GDI261B', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: B. La habilitación o mejora de procesos internos de la entidad (más eficientes, menos costos, más seguros, etc.).', 'Transformacion Digital'),
       ('GDI261C', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: C. La toma de decisiones basada en datos a partir del aumento en el uso y aprovechamiento de la información.', 'Transformacion Digital'),
       ('GDI261D', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: D. El impulso al desarrollo de territorios y ciudades inteligentes para la solución de retos y problemáticas sociales.', 'Transformacion Digital'),
       ('GDI261E', 'Los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022 buscaron generar beneficios en términos de: E. El empoderamiento a los ciudadanos como Estado Abierto habilitando el acceso a información pública generada por la entidad y procesos de participación ciudadana.', 'Transformacion Digital'),
       ('GDI262A', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? A. Uso de infraestructura de datos dando cumplimiento al Plan Nacional de Infraestructura de Datos, la línea de acción de decisiones basadas en datos y el habilitador de seguridad y privacidad de la información', 'Transformacion Digital'),
       ('GDI262B', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Interoperabilidad entre los sistemas de información públicos para suministro e intercambio de la información conforme a los principios señalados en la Ley 1581 de 2012', 'Transformacion Digital'),
       ('GDI262C', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de mecanismos de digitalización y automatización de trámites, servicios y procesos y su vinculación al Portal Único del Estado Colombiano', 'Transformacion Digital'),
       ('GDI262D', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de mecanismos de agregación de demanda, como acuerdos marco de precios vigentes u otros mecanismos que hayan sido establecidos por la Agencia Nacional de Contratación Pública o la modalidad de contratación contenida en el marco de la Política de compras y contratación pública', 'Transformacion Digital'),
       ('GDI262E', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Implementación, migración y uso de servicios de nube, en armonía con el principio de neutralidad tecnológica y normatividad vigente', 'Transformacion Digital'),
       ('GDI262F', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de mecanismos exploratorios de regulación como Sandbox', 'Transformacion Digital'),
       ('GDI262G', '¿Cuáles de los siguientes lineamientos establecidos en el Decreto 1263 de 2022 se cumplieron en los proyectos de Transformación Digital formulados o ejecutados por la entidad durante el 2022? Uso de tecnologías emergentes tales como inteligencia artificial, internet de las cosas (IoT), big data o blockchain', 'Transformacion Digital');

insert into pregunta_formulariofurag
values ('GDI260A', 1),
       ('GDI261A', 1),
       ('GDI261B', 1),
       ('GDI261C', 1),
       ('GDI261D', 1),
       ('GDI261E', 1),
       ('GDI262A', 1),
       ('GDI262B', 1),
       ('GDI262C', 1),
       ('GDI262D', 1),
       ('GDI262E', 1),
       ('GDI262F', 1),
       ('GDI262G', 1);

insert into pregunta_formulariofurag
values ('GDI260A', 2),
       ('GDI261A', 2),
       ('GDI261B', 2),
       ('GDI261C', 2),
       ('GDI261D', 2),
       ('GDI261E', 2),
       ('GDI262A', 2),
       ('GDI262B', 2),
       ('GDI262C', 2),
       ('GDI262D', 2),
       ('GDI262E', 2),
       ('GDI262F', 2),
       ('GDI262G', 2);

insert into pregunta_ge
values ('GDI260AGE1', 'Los programas o proyectos asociados a interoperabilidad institucional están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260A'),
       ('GDI260AGE2', '¿Los proyectos de transformación digital cuentan con datos que permitan al comité de gestión y desempeño institucional realizar comparaciones y mejoras en términos de cobertura, inclusión, tiempos, costos, valor público y otros aspectos relevantes?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260A'),
       ('GDI260AGE3', 'Los participantes en la aprobación de proyectos en el comité de gestión y desempeño institucional, incluidos en el Plan Estratégico de Tecnologías de la Información (PETI), formaron parte del plan de cultura y apropiación de proyectos de transformación digital?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI260A'),

       ('GDI261AGE1', 'Los programas o proyectos relacionados con trámites y servicios están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261A'),
       ('GDI261AGE2', 'En la formulación o ejecución de los proyectos de transformación digital, se incluyen entregables y/o soluciones de datos con estadísticas de los trámites y servicios que posibiliten medir la cobertura, inclusión, tiempos y costos?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261A'),
       ('GDI261AGE3', 'Los proyectos de transformación digital formulados o ejecutados relacionados con trámites y servicios ciudadanos digitales contemplan actividades o entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261A'),

       ('GDI261BGE1', 'Los programas o proyectos asociados a los procesos institucionales están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261B'),
       ('GDI261BGE2', '¿En la formulación o ejecución de los proyectos de transformación digital, se incluyen entregables y/o soluciones de datos con estadísticas de los procesos internos que permitan medir la eficiencia, costos y seguridad?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261B'),
       ('GDI261BGE3', 'Los proyectos de transformación digital formulados o ejecutados relacionados con la mejora de procesos internos contemplan actividades o entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261B'),

       ('GDI261CGE1', 'Los programas o proyectos asociados a la estrategia de toma de decisiones basadas en datos están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261C'),
       ('GDI261CGE2', 'En la formulación o ejecución de los proyectos de transformación digital, se incluyen entregables y/o soluciones de datos con estadísticas del uso y aprovechamiento de los datos?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261C'),
       ('GDI261CGE3', 'Los proyectos de transformación digital formulados o ejecutados relacionados con la promoción de la toma de decisiones basadas en datos contemplan actividades y entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261C'),

       ('GDI261DGE1', 'Los programas o proyectos asociados al desarrollo de territorios y ciudades inteligentes están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261D'),
       ('GDI261DGE2', 'En la formulación o ejecución de los proyectos de transformación digital se incluyen entregables y/o soluciones de datos con estadísticas para el desarrollo de territorios y ciudades inteligentes?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261D'),
       ('GDI261DGE3', 'Los proyectos de transformación digital formulados o ejecutados relacionados con la promoción del desarrollo de territorios y ciudades inteligentes contemplan actividades y entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261D'),

       ('GDI261EGE1', 'Los programas o proyectos asociados a datos abiertos y participación ciudadana están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261E'),
       ('GDI261EGE2', 'En la formulación o ejecución de los proyectos de transformación digital se incluyen entregables y/o soluciones de datos con estadísticas de los procesos que midan los datos abiertos y los mecanismos de participación ciudadana?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261E'),
       ('GDI261EGE3', 'Los proyectos de transformación digital formulados o ejecutados relacionados con la promoción del Estado Abierto contemplan actividades y entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI261E'),

       ('GDI262AGE1', 'Los programas o proyectos asociados al cumplimiento y desarrollo del Plan Nacional de Infraestructura de Datos están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262A'),
       ('GDI262AGE2', 'En la formulación o ejecución de los proyectos de transformación digital cuenta con entregables y/o soluciones de datos con estadísticas del avance del cumplimiento del plan nacional de infraestructura de datos', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262A'),
       ('GDI262AGE3', 'Los proyectos de transformación digital formulados o ejecutados relacionados con promover el cumplimiento del Plan Nacional de Infraestructura de Datos contemplan actividades y entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262A'),

       ('GDI262BGE1', 'Los programas o proyectos asociados a interoperabilidad institucional están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262B'),
       ('GDI262BGE2', 'En la formulación o ejecución de los proyectos de transformación digital se incluyen entregables y/o soluciones de datos con estadísticas de la interoperabilidad institucional en los procesos, trámites y servicios?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262B'),
       ('GDI262BGE3', 'Los proyectos de transformación digital formulados o ejecutados relacionados con promover la interoperabilidad institucional contemplan actividades y entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262B'),

       ('GDI262CGE1', 'Los programas o proyectos asociados a la digitalización y automatización de trámites, servicios y procesos con el Portal único del Estado colombiano están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262C'),
       ('GDI262CGE2', 'En la formulación o ejecución de los proyectos de transformación digital se incluyen entregables y/o soluciones de datos con estadísticas de la digitalización y automatización de trámites y servicios en su vinculación al portal único del estado colombiano?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262C'),
       ('GDI262CGE3', 'Los proyectos de transformación digital formulados o ejecutados, relacionados con promover la digitalización y automatización de trámites, servicios y procesos, así como su vinculación con el portal único del estado colombiano, contemplan actividades y entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262C'),

       ('GDI262DGE1', 'Los programas o proyectos asociados al uso de mecanismos de agregación de demanda están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262D'),
       ('GDI262DGE2', 'En la formulación o ejecución de los proyectos de transformación digital se incluyen entregables y/o soluciones de datos con estadísticas del uso de mecanismos de agregación de demanda?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262D'),
       ('GDI262DGE3', 'Los proyectos de transformación digital formulados o ejecutados, relacionados con promover el uso de mecanismos de agregación de demanda, contemplan actividades y entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262D'),

       ('GDI262EGE1', 'Los programas o proyectos asociados a la implementación, migración y uso de servicios en la nube están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262E'),
       ('GDI262EGE2', 'En la formulación o ejecución de los proyectos de transformación digital se incluyen entregables y/o soluciones de datos con estadísticas de la implementación, migración y uso de servicios en la nube?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262E'),
       ('GDI262EGE3', 'Los proyectos de transformación digital formulados o ejecutados, relacionados con promover la implementación, migración y uso de servicios en la nube, contemplan actividades y entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262E'),

       ('GDI262FGE1', 'Los programas o proyectos asociados al uso de mecanismos exploratorios de regulación están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262F'),
       ('GDI262FGE2', 'En la formulación o ejecución de los proyectos de transformación digital se incluyen entregables y/o soluciones de datos con estadísticas del uso de mecanismos exploratorios de regulación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262F'),
       ('GDI262FGE3', 'Los proyectos de transformación digital formulados o ejecutados, relacionados con promover el uso de mecanismos exploratorios de regulación, contemplan actividades y entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262F'),

       ('GDI262GGE1', 'Los programas o proyectos asociados a habilitar capacidades de inteligencia artificial, Internet de las cosas, Big Data y Blockchain están respaldados por los resultados de la arquitectura?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262G'),
       ('GDI262GGE2', 'En la formulación o ejecución de los proyectos de transformación digital se incluyen entregables y/o soluciones de datos con estadísticas de la habilitación y uso de capacidades de inteligencia artificial, Internet de las Cosas, Big Data y Blockchain?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262G'),
       ('GDI262GGE3', 'Los proyectos de transformación digital formulados o ejecutados, relacionados con promover capacidades de inteligencia artificial, Internet de las Cosas, Big Data y Blockchain, contemplan actividades y entregables asociados a cultura y apropiación?', 'evidencia sugerida pdf', 'rol sugerido xxxx', 'GDI262G');

insert into respuesta_ge
values (gen_random_uuid(), 'evidencia de esta respuesta', true, 'GDI260AGE1', 1),
       (gen_random_uuid(), 'evidencia de esta respuesta', false, 'GDI260AGE2', 1),
       (gen_random_uuid(), 'evidencia de esta respuesta', true, 'GDI260AGE3', 1);

insert into respuesta_ge
values (gen_random_uuid(), 'evidencia de esta respuesta', true, 'GDI260AGE1', 2),
       (gen_random_uuid(), 'evidencia de esta respuesta', false, 'GDI260AGE2', 2),
       (gen_random_uuid(), 'evidencia de esta respuesta', true, 'GDI260AGE3', 2);

insert into puntaje
values (gen_random_uuid(), 78, 'Transformacion Digital', '2017-03-14', 2);
