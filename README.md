# GESTOR DE CURSOS
============================================
        DOCUMENTACIÓN API REST JAVA 17
============================================
Nombre del proyecto: Gestor de Cursos.

Descripción:Este proyecto es una API REST con el fin de gestionar los cursos y sus docentes de una aplicación web.
En esta aplicación  podran ser creados, editados, filtrados y eliminados, los datos de los cursos, 
para la información de docentes, podra ser creada, filtrada, editada y elimanarla si se desea.

Tecnologías utilizadas: Java 17, Spring Boot 3.2.0,version del conector mysql 8.0.33, Maven 3.8.1, Hibernate)

Requisitos Previos:
JDK 17 (Versión de JAVA).
Maven.
Base de datos requerida.

Instalación y Configuración:
Clonar el repositorio desde GitHub.(comando Git: git clone git@github.com:camiloffuni/CRUD_JAVA.git), "el repositorio es publico".
Configurar el archivo application.properties para realizar el correcto apuntamiento a la base de datos y configurar la credencial de acceso a la db.
Instalación de dependencias. Importar todas las dependencias requeridas para inicializar el proyecto.

Variables de entorno necesarias: 
 - DB_URL=jdbc:mysql://localhost:3306/cursos_db
 - USERNAME=root
 - DB_PASSWORD=12345

URL base de la API para cursos: http://localhost:8080/cursos/
URL base de la API para docentes: http://localhost:8080/docentes/

Métodos y rutas de la API:

GET   /cursos/                → Obtiene todos los cursos.
GET   /docentes/              → Obtiene todos los docentes.

GET   /cursos/idCurso/buscar_por_id/{Id}    → Obtiene los cursos por ID.
GET   /docentes/buscar_por_id/{IdDocente}   → Obtiene los docentes por ID.

GET   /docentes/buscar_por_docente?nombreDocente="nombre a consultar" → Obtiene los docentes por un nombre filtrado.

GET   /cursos/buscar_Por_Precio?precio="valor a consultar" → Obtiene todos los cursos por precio.

GET   /cursos/buscar_entre_precios/?precio_min="valor minimo"&precio_max="valor maximo" → Obtiene los cursos entre dos rangos de precios.

POST  /cursos/crear_curso     → Crea un nuevo curso(requiere JSON en el cuerpo).
POST  /docentes/crearDocente  → Crea un nuevo docente(requiere JSON en el cuerpo).

PUT   /cursos/actualizar_curso/{id}              → Actualiza un curso en la base de datos(requiere JSON en el cuerpo).
PUT   /docentes/actualizar_docente/{idDocente}   → Actualiza un docente en la base de datos(requiere JSON en el cuerpo).

DELETE /cursos/eliminar_curso/{id}             → Elimina un curso por Id.
DELETE /docentes/eliminar_docente/{idDocente}  → Elimina un docente por Id.

Lista de códigos de estado HTTP usados:

200 OK                    → Solicitud exitosa
201 Created               → Recurso creado exitosamente
400 Bad Request           → Error en los datos enviados
404 Not Found             → Recurso no encontrado
500 Internal Server Error → Error interno del servidor

BASE DE DATOS

Script SQL de creación de base de datos y tablas del proyecto:

CREATE DATABASE IF NOT EXISTS cursos_db;

Create table cursos_db.cursos (
    id_curso int auto_increment primary key,
    nombre_curso varchar(100),
    descripcion_curso varchar(100),
    fecha_inicio date,
    fecha_fin date,
    activo boolean,
    precio double
);

Create table cursos_db.docentes (
    id_docente int auto_increment primary key,
    nombre_docente varchar(30),
    apellido_docente varchar(30),
    curso_imparte int,
    foreign key (curso_imparte) references cursos(id_curso)
);

Nota: los docentes no podran ser creados sin antes haber creado el curso al cual sera asignado.

URL repositorio GitHub: https://github.com/camiloffuni/CRUD_JAVA






