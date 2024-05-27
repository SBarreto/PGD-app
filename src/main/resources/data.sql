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
values ('840beb59-1bf0-4e59-9f40-409abfd8aa89', true, 'GDI260AGE1', 1),
       ('e534a955-b17e-4365-b0f9-031af13d881f', false, 'GDI260AGE2', 1),
       ('39163a75-80f7-4d9a-b5c3-66eeea76c3d9', true, 'GDI260AGE3', 1),

        ('5af1ed4a-ac52-4c3f-bcba-e5a0cf34e571', true, 'GDI261AGE1', 1),
        ('daba4ab0-4f9e-40dc-b05d-8d0352c93070', false, 'GDI261AGE2', 1),
        ('7766a9d2-c859-4d67-990c-32280df046ad', true, 'GDI261AGE3', 1),

        ('08cea537-393d-4c16-92fe-29f53044ce06', true, 'GDI261BGE1', 1),
        ('1a8d3758-c47b-47e5-af35-5a06a9d8f1aa', false, 'GDI261BGE2', 1),
        ('25f90ce1-63e4-430d-a84a-892674e5b70e', true, 'GDI261BGE3', 1),

        ('774fd561-140b-434d-89d4-1a019bd1a939', true, 'GDI261CGE1', 1),
        ('c709f7ba-ebca-482e-99e4-1c8e251a23e3', false, 'GDI261CGE2', 1),
        ('eaea9770-22c2-4e19-ba67-4d72a7f0a275', true, 'GDI261CGE3', 1),

        ('e5da108e-46de-45d3-8a00-2faba5d88ca2', true, 'GDI261DGE1', 1),
        ('7b5bf595-a630-42e4-8efd-ddc59f13a3e3', false, 'GDI261DGE2', 1),
        ('a73ba57c-6aec-473c-8525-5fa0fc956e2a', true, 'GDI261DGE3', 1),

        ('9bf524fa-ed77-44aa-80f9-ad0e3379b42d', true, 'GDI261EGE1', 1),
        ('6af66056-f38d-41f7-af89-310b85e94d11', false, 'GDI261EGE2', 1),
        ('817114db-9ddf-48b9-b3d2-9d7aa7ba6c12', true, 'GDI261EGE3', 1),

        ('44e1705e-7308-480e-b21a-598248eff1e4', true, 'GDI262AGE1', 1),
        ('13be3bc8-f02b-4b13-ba2c-4ad4784d2188', false, 'GDI262AGE2', 1),
        ('cc092cf8-a0ad-421f-8a06-a4c181f2be2b', true, 'GDI262AGE3', 1),

        ('7f88387b-34a0-4b95-9419-16237f3f788e', true, 'GDI262BGE1', 1),
        ('2167b5ca-0c68-41fd-81ad-9ebea8d56a11', false, 'GDI262BGE2', 1),
        ('888dd2d3-70b8-45d7-a941-a2c0c9e5cb8d', true, 'GDI262BGE3', 1),

        ('67ed7e35-97cd-4f88-9e74-2a23e6f859e2', true, 'GDI262CGE1', 1),
        ('cff34b36-ff09-4709-afcd-2ff83288975b', false, 'GDI262CGE2', 1),
        ('00598cad-a532-4539-b577-d7165f810dea', true, 'GDI262CGE3', 1),

        ('8f2ca007-e033-4d6d-8357-c5ea1928db9d', true, 'GDI262DGE1', 1),
        ('fab211e3-6ea3-4f19-9cce-7837fd6c3eae', false, 'GDI262DGE2', 1),
        ('54991a2f-f713-4bb6-a5a2-0b5f059e78f5', true, 'GDI262DGE3', 1),

        ('4d487861-7435-4792-aac1-f2e21dcac063', true, 'GDI262EGE1', 1),
        ('82cc25b0-a8b3-4758-a981-decbc5a755e4', false, 'GDI262EGE2', 1),
        ('0a05b4d2-754b-4d7d-80f6-07ed808bc7ed', true, 'GDI262EGE3', 1),

        ('eba2557b-1cfd-4eac-992d-5e95631969c8', true, 'GDI262FGE1', 1),
        ('da5d28e4-af9f-4618-9fb1-1ae799d2d887', false, 'GDI262FGE2', 1),
        ('f4d11a91-dd9e-415a-b9c5-54a12ec4e82e', true, 'GDI262FGE3', 1),

        ('3ab06029-6e5a-4666-9c93-a330f4a66e60', true, 'GDI262GGE1', 1),
        ('05b2bcf4-de68-41b5-8e34-56f48992a334', false, 'GDI262GGE2', 1),
        ('62e44bf2-e3b5-48a5-bfd6-8f603bb2eae0', true, 'GDI262GGE3', 1);



insert into respuesta_ge
values ('f08f7fd6-1a50-433b-9d37-d8a9197e72d5', true, 'GDI260AGE1', 2),
       ('89886726-e6de-49e2-af0b-a572013d53a0', false, 'GDI260AGE2', 2),
       ('e160d40f-89a1-4b66-9e2c-4821374c31c2', true, 'GDI260AGE3', 2);

insert into evidencia (id, texto, respuestage_id, formulariofurag_id)
values (gen_random_uuid(), 'evidencia1', '840beb59-1bf0-4e59-9f40-409abfd8aa89', 1),
       (gen_random_uuid(), 'hola.com', 'e534a955-b17e-4365-b0f9-031af13d881f', 1),
       (gen_random_uuid(), 'evidencia3', '39163a75-80f7-4d9a-b5c3-66eeea76c3d9', 1),
       (gen_random_uuid(), 'hola.com', '5af1ed4a-ac52-4c3f-bcba-e5a0cf34e571', 1),
       (gen_random_uuid(), 'evidencia2', 'daba4ab0-4f9e-40dc-b05d-8d0352c93070', 1),
       (gen_random_uuid(), 'evidencia3', '7766a9d2-c859-4d67-990c-32280df046ad', 1),
       (gen_random_uuid(), 'evidencia1', '08cea537-393d-4c16-92fe-29f53044ce06', 1),
       (gen_random_uuid(), 'evidencia2', '1a8d3758-c47b-47e5-af35-5a06a9d8f1aa', 1),
       (gen_random_uuid(), 'evidencia3', '25f90ce1-63e4-430d-a84a-892674e5b70e', 1),
       (gen_random_uuid(), 'evidencia1', '774fd561-140b-434d-89d4-1a019bd1a939', 1),
       (gen_random_uuid(), 'evidencia2', 'c709f7ba-ebca-482e-99e4-1c8e251a23e3', 1),
       (gen_random_uuid(), 'evidencia3', 'eaea9770-22c2-4e19-ba67-4d72a7f0a275', 1),
       (gen_random_uuid(), 'evidencia1', 'e5da108e-46de-45d3-8a00-2faba5d88ca2', 1),
       (gen_random_uuid(), 'evidencia2', '7b5bf595-a630-42e4-8efd-ddc59f13a3e3', 1),
       (gen_random_uuid(), 'evidencia3', 'a73ba57c-6aec-473c-8525-5fa0fc956e2a', 1),
       (gen_random_uuid(), 'evidencia1', '9bf524fa-ed77-44aa-80f9-ad0e3379b42d', 1),
       (gen_random_uuid(), 'evidencia2', '6af66056-f38d-41f7-af89-310b85e94d11', 1),
       (gen_random_uuid(), 'evidencia3', '817114db-9ddf-48b9-b3d2-9d7aa7ba6c12', 1),
       (gen_random_uuid(), 'evidencia1', '44e1705e-7308-480e-b21a-598248eff1e4', 1),
       (gen_random_uuid(), 'evidencia2', '13be3bc8-f02b-4b13-ba2c-4ad4784d2188', 1),
       (gen_random_uuid(), 'evidencia3', 'cc092cf8-a0ad-421f-8a06-a4c181f2be2b', 1),
       (gen_random_uuid(), 'evidencia1', '7f88387b-34a0-4b95-9419-16237f3f788e', 1),
       (gen_random_uuid(), 'evidencia2', '2167b5ca-0c68-41fd-81ad-9ebea8d56a11', 1),
       (gen_random_uuid(), 'evidencia3', '888dd2d3-70b8-45d7-a941-a2c0c9e5cb8d', 1),
       (gen_random_uuid(), 'evidencia1', '67ed7e35-97cd-4f88-9e74-2a23e6f859e2', 1),
       (gen_random_uuid(), 'evidencia2', 'cff34b36-ff09-4709-afcd-2ff83288975b', 1),
       (gen_random_uuid(), 'evidencia3', '00598cad-a532-4539-b577-d7165f810dea', 1),
       (gen_random_uuid(), 'evidencia1', '8f2ca007-e033-4d6d-8357-c5ea1928db9d', 1),
       (gen_random_uuid(), 'evidencia2', 'fab211e3-6ea3-4f19-9cce-7837fd6c3eae', 1),
       (gen_random_uuid(), 'evidencia3', '54991a2f-f713-4bb6-a5a2-0b5f059e78f5', 1),
       (gen_random_uuid(), 'evidencia1', '4d487861-7435-4792-aac1-f2e21dcac063', 1),
       (gen_random_uuid(), 'evidencia2', '82cc25b0-a8b3-4758-a981-decbc5a755e4', 1),
       (gen_random_uuid(), 'evidencia3', '0a05b4d2-754b-4d7d-80f6-07ed808bc7ed', 1),
       (gen_random_uuid(), 'evidencia1', 'eba2557b-1cfd-4eac-992d-5e95631969c8', 1),
       (gen_random_uuid(), 'evidencia2', 'da5d28e4-af9f-4618-9fb1-1ae799d2d887', 1),
       (gen_random_uuid(), 'evidencia3', 'f4d11a91-dd9e-415a-b9c5-54a12ec4e82e', 1),
       (gen_random_uuid(), 'evidencia1', '3ab06029-6e5a-4666-9c93-a330f4a66e60', 1),
       (gen_random_uuid(), 'evidencia2', '05b2bcf4-de68-41b5-8e34-56f48992a334', 1),
       (gen_random_uuid(), 'evidencia3', '62e44bf2-e3b5-48a5-bfd6-8f603bb2eae0', 1),

       (gen_random_uuid(), 'evidencia4', 'f08f7fd6-1a50-433b-9d37-d8a9197e72d5', 1),
       (gen_random_uuid(), 'evidencia5', '89886726-e6de-49e2-af0b-a572013d53a0', 1),
       (gen_random_uuid(), 'evidencia6', 'e160d40f-89a1-4b66-9e2c-4821374c31c2', 1);

insert into puntaje
values (gen_random_uuid(), 78, 'Transformacion Digital', '2017-03-14', 2);
