-- crear historial de atenciones
/*
INSERT INTO public.historial_atenciones 
(apellido_materno_cliente,
apellido_paterno_cliente,
email_cliente,
fecha_creacion_atencion,
fecha_creacion_llamada,
id_atencion,
nombre_cliente,
nombre_tipo_atencion,
rut_cliente,
tiempo_atencion,
turno_atencion
)
SELECT 
cl.apellido_materno, 
cl.apellido_paterno, 
cl.email, 
at.fecha_creacion,
lla.fecha_creacion,  
at.id, 
cl.nombre, 
ta.nombre, 
cl.rut, 
ta.tiempo_atencion, 
tu.turno_atencion
FROM public.atenciones at
LEFT JOIN clientes cl ON at.id_cliente=cl.id
LEFT JOIN tipo_atencion ta ON  at.id_tipo_atencion=ta.id
LEFT JOIN turnos tu ON  at.id_turno=tu.id
LEFT JOIN llamadas lla ON at.id=lla.id_atencion
ORDER BY at.fecha_creacion, lla.fecha_creacion; 

TRUNCATE TABLE public.llamadas CASCADE;

TRUNCATE TABLE public.atenciones CASCADE;

TRUNCATE TABLE public.turnos CASCADE;

TRUNCATE TABLE public.tipo_atencion CASCADE;

TRUNCATE TABLE public.clientes CASCADE;

TRUNCATE TABLE public.alertas;

INSERT INTO public.tipo_atencion (nombre, tiempo_atencion) VALUES 
('Solicitar certificado 1', 10),
('Solicitar certificado 2', 15),
('Solicitar certificado 3', 20),
('Solicitar certificado 4', 25),
('Solicitar certificado 5', 30);

INSERT INTO public.clientes (Nombre, Apellido_Paterno, Apellido_Materno, Email, Rut) VALUES 
('PEDRO', 'CARRASCO', 'CABRERA', 'pedro@mail.com', '1000000-9'),
('CATALINA', 'JARA', 'MUÑOZ', 'catalina@mail.com', '1000001-7'),
('ALICIA', 'PINO', 'BARRA', 'alicia@mail.com', '1000002-5'),
('LUIS', 'LOBOS', 'CARMONA', 'luis@mail.com', '1000003-3'),
('CAMILO', 'FUENZALIDA', 'ZUÑIGA', 'camilo@mail.com', '1000004-1'),
('OSCAR', 'LEON', 'PARRAGUEZ', 'oscar@mail.com', '1000005-K'),
('JIMENA', 'ALARCON', 'GUTIERREZ', 'jimena@mail.com', '1000006-8'),
('ALFONSO', 'CHACON', 'PEREIRA', 'alfonso@mail.com', '1000007-6'),
('ERNESTO', 'VELIZ', 'SLCEDO', 'ernesto@mail.com', '1000008-4'),
('AMANDA', 'SOLIS', 'VEGA', 'amanda@mail.com', '1000009-2');

--------- cargar alertas
-- la alerta debiera aparecer a partir desde que se alcanzo una cantidad de minutos
INSERT INTO alertas (color, descripcion, duracion_desde, duracion_hasta, fecha_creacion) VALUES 
('verde', 'Falta bastante tiempo, para su atención.', 30, 600, CURRENT_TIMESTAMP),
('amarillo', 'Atento su turno de atención está próximo a ser llamado.', 11, 29, CURRENT_TIMESTAMP),
('naranjo', 'Su turno de atención está a punto de ser llamado.', 5, 10, CURRENT_TIMESTAMP),
('marron', 'Su turno de atención está siendo llamado.', 3, 4, CURRENT_TIMESTAMP),
('rojo', 'Su turno de atención está próximo a expirar.', 1, 2, CURRENT_TIMESTAMP);

-- registrar turnos de atención
INSERT INTO public.turnos (estado, turno_atencion) VALUES   
(0,'A-01'),
(0,'A-02'),
(0,'A-03'),
(0,'A-04'),
(0,'A-05'),
(0,'A-06'),
(0,'A-07'),
(0,'A-08'),
(0,'A-09'),
(0,'A-10'),
(0,'A-11'),
(0,'A-12'),
(0,'A-13'),
(0,'A-14'),
(0,'A-15'),
(0,'A-16'),
(0,'A-17'),
(0,'A-18'),
(0,'A-19'),
(0,'A-20'),
(0,'A-21'),
(0,'A-22'),
(0,'A-23'),
(0,'A-24'),
(0,'A-25'),
(0,'A-26'),
(0,'A-27'),
(0,'A-28'),
(0,'A-29'),
(0,'A-30'),
(0,'A-31'),
(0,'A-32'),
(0,'A-33'),
(0,'A-34'),
(0,'A-35'),
(0,'A-36'),
(0,'A-37'),
(0,'A-38'),
(0,'A-39'),
(0,'A-40'),
(0,'A-41'),
(0,'A-42'),
(0,'A-43'),
(0,'A-44'),
(0,'A-45'),
(0,'A-46'),
(0,'A-47'),
(0,'A-48'),
(0,'A-49'),
(0,'A-50'),
(0,'A-51'),
(0,'A-52'),
(0,'A-53'),
(0,'A-54'),
(0,'A-55'),
(0,'A-56'),
(0,'A-57'),
(0,'A-58'),
(0,'A-59'),
(0,'A-60'),
(0,'A-61'),
(0,'A-62'),
(0,'A-63'),
(0,'A-64'),
(0,'A-65'),
(0,'A-66'),
(0,'A-67'),
(0,'A-68'),
(0,'A-69'),
(0,'A-70'),
(0,'A-71'),
(0,'A-72'),
(0,'A-73'),
(0,'A-74'),
(0,'A-75'),
(0,'A-76'),
(0,'A-77'),
(0,'A-78'),
(0,'A-79'),
(0,'A-80'),
(0,'A-81'),
(0,'A-82'),
(0,'A-83'),
(0,'A-84'),
(0,'A-85'),
(0,'A-86'),
(0,'A-87'),
(0,'A-88'),
(0,'A-89'),
(0,'A-90'),
(0,'A-91'),
(0,'A-92'),
(0,'A-93'),
(0,'A-94'),
(0,'A-95'),
(0,'A-96'),
(0,'A-97'),
(0,'A-98'),
(0,'A-99'),
(0,'B-01'),
(0,'B-02'),
(0,'B-03'),
(0,'B-04'),
(0,'B-05'),
(0,'B-06'),
(0,'B-07'),
(0,'B-08'),
(0,'B-09'),
(0,'B-10'),
(0,'B-11'),
(0,'B-12'),
(0,'B-13'),
(0,'B-14'),
(0,'B-15'),
(0,'B-16'),
(0,'B-17'),
(0,'B-18'),
(0,'B-19'),
(0,'B-20'),
(0,'B-21'),
(0,'B-22'),
(0,'B-23'),
(0,'B-24'),
(0,'B-25'),
(0,'B-26'),
(0,'B-27'),
(0,'B-28'),
(0,'B-29'),
(0,'B-30'),
(0,'B-31'),
(0,'B-32'),
(0,'B-33'),
(0,'B-34'),
(0,'B-35'),
(0,'B-36'),
(0,'B-37'),
(0,'B-38'),
(0,'B-39'),
(0,'B-40'),
(0,'B-41'),
(0,'B-42'),
(0,'B-43'),
(0,'B-44'),
(0,'B-45'),
(0,'B-46'),
(0,'B-47'),
(0,'B-48'),
(0,'B-49'),
(0,'B-50'),
(0,'B-51'),
(0,'B-52'),
(0,'B-53'),
(0,'B-54'),
(0,'B-55'),
(0,'B-56'),
(0,'B-57'),
(0,'B-58'),
(0,'B-59'),
(0,'B-60'),
(0,'B-61'),
(0,'B-62'),
(0,'B-63'),
(0,'B-64'),
(0,'B-65'),
(0,'B-66'),
(0,'B-67'),
(0,'B-68'),
(0,'B-69'),
(0,'B-70'),
(0,'B-71'),
(0,'B-72'),
(0,'B-73'),
(0,'B-74'),
(0,'B-75'),
(0,'B-76'),
(0,'B-77'),
(0,'B-78'),
(0,'B-79'),
(0,'B-80'),
(0,'B-81'),
(0,'B-82'),
(0,'B-83'),
(0,'B-84'),
(0,'B-85'),
(0,'B-86'),
(0,'B-87'),
(0,'B-88'),
(0,'B-89'),
(0,'B-90'),
(0,'B-91'),
(0,'B-92'),
(0,'B-93'),
(0,'B-94'),
(0,'B-95'),
(0,'B-96'),
(0,'B-97'),
(0,'B-98'),
(0,'B-99'),
(0,'C-01'),
(0,'C-02'),
(0,'C-03'),
(0,'C-04'),
(0,'C-05'),
(0,'C-06'),
(0,'C-07'),
(0,'C-08'),
(0,'C-09'),
(0,'C-10'),
(0,'C-11'),
(0,'C-12'),
(0,'C-13'),
(0,'C-14'),
(0,'C-15'),
(0,'C-16'),
(0,'C-17'),
(0,'C-18'),
(0,'C-19'),
(0,'C-20'),
(0,'C-21'),
(0,'C-22'),
(0,'C-23'),
(0,'C-24'),
(0,'C-25'),
(0,'C-26'),
(0,'C-27'),
(0,'C-28'),
(0,'C-29'),
(0,'C-30'),
(0,'C-31'),
(0,'C-32'),
(0,'C-33'),
(0,'C-34'),
(0,'C-35'),
(0,'C-36'),
(0,'C-37'),
(0,'C-38'),
(0,'C-39'),
(0,'C-40'),
(0,'C-41'),
(0,'C-42'),
(0,'C-43'),
(0,'C-44'),
(0,'C-45'),
(0,'C-46'),
(0,'C-47'),
(0,'C-48'),
(0,'C-49'),
(0,'C-50'),
(0,'C-51'),
(0,'C-52'),
(0,'C-53'),
(0,'C-54'),
(0,'C-55'),
(0,'C-56'),
(0,'C-57'),
(0,'C-58'),
(0,'C-59'),
(0,'C-60'),
(0,'C-61'),
(0,'C-62'),
(0,'C-63'),
(0,'C-64'),
(0,'C-65'),
(0,'C-66'),
(0,'C-67'),
(0,'C-68'),
(0,'C-69'),
(0,'C-70'),
(0,'C-71'),
(0,'C-72'),
(0,'C-73'),
(0,'C-74'),
(0,'C-75'),
(0,'C-76'),
(0,'C-77'),
(0,'C-78'),
(0,'C-79'),
(0,'C-80'),
(0,'C-81'),
(0,'C-82'),
(0,'C-83'),
(0,'C-84'),
(0,'C-85'),
(0,'C-86'),
(0,'C-87'),
(0,'C-88'),
(0,'C-89'),
(0,'C-90'),
(0,'C-91'),
(0,'C-92'),
(0,'C-93'),
(0,'C-94'),
(0,'C-95'),
(0,'C-96'),
(0,'C-97'),
(0,'C-98'),
(0,'C-99'),
(0,'D-01'),
(0,'D-02'),
(0,'D-03'),
(0,'D-04'),
(0,'D-05'),
(0,'D-06'),
(0,'D-07'),
(0,'D-08'),
(0,'D-09'),
(0,'D-10'),
(0,'D-11'),
(0,'D-12'),
(0,'D-13'),
(0,'D-14'),
(0,'D-15'),
(0,'D-16'),
(0,'D-17'),
(0,'D-18'),
(0,'D-19'),
(0,'D-20'),
(0,'D-21'),
(0,'D-22'),
(0,'D-23'),
(0,'D-24'),
(0,'D-25'),
(0,'D-26'),
(0,'D-27'),
(0,'D-28'),
(0,'D-29'),
(0,'D-30'),
(0,'D-31'),
(0,'D-32'),
(0,'D-33'),
(0,'D-34'),
(0,'D-35'),
(0,'D-36'),
(0,'D-37'),
(0,'D-38'),
(0,'D-39'),
(0,'D-40'),
(0,'D-41'),
(0,'D-42'),
(0,'D-43'),
(0,'D-44'),
(0,'D-45'),
(0,'D-46'),
(0,'D-47'),
(0,'D-48'),
(0,'D-49'),
(0,'D-50'),
(0,'D-51'),
(0,'D-52'),
(0,'D-53'),
(0,'D-54'),
(0,'D-55'),
(0,'D-56'),
(0,'D-57'),
(0,'D-58'),
(0,'D-59'),
(0,'D-60'),
(0,'D-61'),
(0,'D-62'),
(0,'D-63'),
(0,'D-64'),
(0,'D-65'),
(0,'D-66'),
(0,'D-67'),
(0,'D-68'),
(0,'D-69'),
(0,'D-70'),
(0,'D-71'),
(0,'D-72'),
(0,'D-73'),
(0,'D-74'),
(0,'D-75'),
(0,'D-76'),
(0,'D-77'),
(0,'D-78'),
(0,'D-79'),
(0,'D-80'),
(0,'D-81'),
(0,'D-82'),
(0,'D-83'),
(0,'D-84'),
(0,'D-85'),
(0,'D-86'),
(0,'D-87'),
(0,'D-88'),
(0,'D-89'),
(0,'D-90'),
(0,'D-91'),
(0,'D-92'),
(0,'D-93'),
(0,'D-94'),
(0,'D-95'),
(0,'D-96'),
(0,'D-97'),
(0,'D-98'),
(0,'D-99'),
(0,'E-01'),
(0,'E-02'),
(0,'E-03'),
(0,'E-04'),
(0,'E-05'),
(0,'E-06'),
(0,'E-07'),
(0,'E-08'),
(0,'E-09'),
(0,'E-10'),
(0,'E-11'),
(0,'E-12'),
(0,'E-13'),
(0,'E-14'),
(0,'E-15'),
(0,'E-16'),
(0,'E-17'),
(0,'E-18'),
(0,'E-19'),
(0,'E-20'),
(0,'E-21'),
(0,'E-22'),
(0,'E-23'),
(0,'E-24'),
(0,'E-25'),
(0,'E-26'),
(0,'E-27'),
(0,'E-28'),
(0,'E-29'),
(0,'E-30'),
(0,'E-31'),
(0,'E-32'),
(0,'E-33'),
(0,'E-34'),
(0,'E-35'),
(0,'E-36'),
(0,'E-37'),
(0,'E-38'),
(0,'E-39'),
(0,'E-40'),
(0,'E-41'),
(0,'E-42'),
(0,'E-43'),
(0,'E-44'),
(0,'E-45'),
(0,'E-46'),
(0,'E-47'),
(0,'E-48'),
(0,'E-49'),
(0,'E-50'),
(0,'E-51'),
(0,'E-52'),
(0,'E-53'),
(0,'E-54'),
(0,'E-55'),
(0,'E-56'),
(0,'E-57'),
(0,'E-58'),
(0,'E-59'),
(0,'E-60'),
(0,'E-61'),
(0,'E-62'),
(0,'E-63'),
(0,'E-64'),
(0,'E-65'),
(0,'E-66'),
(0,'E-67'),
(0,'E-68'),
(0,'E-69'),
(0,'E-70'),
(0,'E-71'),
(0,'E-72'),
(0,'E-73'),
(0,'E-74'),
(0,'E-75'),
(0,'E-76'),
(0,'E-77'),
(0,'E-78'),
(0,'E-79'),
(0,'E-80'),
(0,'E-81'),
(0,'E-82'),
(0,'E-83'),
(0,'E-84'),
(0,'E-85'),
(0,'E-86'),
(0,'E-87'),
(0,'E-88'),
(0,'E-89'),
(0,'E-90'),
(0,'E-91'),
(0,'E-92'),
(0,'E-93'),
(0,'E-94'),
(0,'E-95'),
(0,'E-96'),
(0,'E-97'),
(0,'E-98'),
(0,'E-99');

*/
