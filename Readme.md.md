# ForoHub API Rest

## Índice

1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Estado del Proyecto](#estado-del-proyecto)
3. [Demostración de Funcionalidades](#demostración-de-funcionalidades)
    - [Funcionalidades del Proyecto](#funcionalidades-del-proyecto)
    - [Uso del Proyecto](#uso-del-proyecto)
4. [Acceso al Proyecto](#acceso-al-proyecto)
5. [Tecnologías Utilizadas](#tecnologías-utilizadas)
6. [Persona Desarrolladora del Proyecto](#persona-desarrolladora-del-proyecto)

## Descripción del Proyecto 📄

¡Bienvenido/a a **ForoHub**! Este proyecto consiste en una aplicación API Rest CRUD que permite gestionar tópicos relacionados con cursos y autores. Puedes crear, leer, actualizar y eliminar (operaciones CRUD) tópicos, los cuales contienen información como el título, mensaje, autor, y estado.

La API está construida con **Spring Boot**, y utiliza una base de datos **MySQL** para almacenar los datos. Además, se han implementado funciones de autenticación y seguridad con **Spring Security** y **JWT** (JSON Web Token).

### Características clave:

- Crear un tópico con título, mensaje, autor, curso y estado.
- Listar todos los tópicos o uno específico por su ID.
- Actualizar información de un tópico existente.
- Eliminar un tópico de la base de datos.
- Seguridad con JWT para el acceso a las operaciones CRUD.

## Estado del Proyecto ✅

Proyecto completado y funcional. Actualmente, la aplicación está lista para ser utilizada y se están evaluando futuras optimizaciones y nuevas funcionalidades.

## Demostración de Funcionalidades

### Funcionalidades del Proyecto 🔧

1. **Registrar tópico**: Permite registrar un nuevo tópico en la base de datos con los siguientes campos:
    - Título
    - Mensaje
    - Fecha de creación
    - Estado
    - Autor
    - Curso
2. **Listar todos los tópicos**: Muestra todos los tópicos almacenados en la base de datos.
3. **Listar un tópico por ID**: Devuelve la información de un único tópico dado su `ID` en la URI.
4. **Actualizar un tópico**: Modifica los datos de un tópico existente. Solo se permiten cambios no vacíos ni nulos.
5. **Eliminar un tópico**: Elimina un tópico específico utilizando su `ID` en la URI.

**Conexión a la base de datos**: La aplicación se conecta a una base de datos MySQL, la cual debe ser configurada antes de su uso. Es necesario crear la base de datos y ajustar el archivo `application.properties` con las credenciales correctas.

### Uso del Proyecto

1. **Acceder al proyecto**:
   - Clonar o descargar este repositorio desde GitHub.
   - Asegúrate de tener configurado un entorno de desarrollo Java con Spring Boot.
   - Configura la base de datos en el archivo `application.properties`.

2. **Simular las solicitudes**:
   - Usa herramientas como **Postman** o **Insomnia** para enviar solicitudes HTTP de tipo `POST`, `GET`, `PUT`, `DELETE` a la API.
   - Para crear un tópico, realiza un `POST` con los datos del tópico.
   - Para obtener un tópico, realiza un `GET` con el `ID` del tópico.
   - Para actualizar un tópico, realiza un `PUT` con el `ID` y los nuevos datos.
   - Para eliminar un tópico, realiza un `DELETE` con el `ID` correspondiente.

**Ejemplo de uso**:

Registrar un tópico:

POST /api/topicos  
{  
    "titulo": "Nuevo Tópico",  
    "mensaje": "Mensaje sobre el tópico",  
    "autor": "Autor Ejemplo",  
    "curso": "Curso de Ejemplo",  
    "estado": "Activo"  
}  

Obtener un tópico por `ID`:

GET /api/topicos/{id}  

Actualizar un tópico:

PUT /api/topicos/{id}  
{  
    "titulo": "Tópico Actualizado",  
    "mensaje": "Nuevo mensaje del tópico",  
    "autor": "Autor Actualizado"  
}  

Eliminar un tópico:

DELETE /api/topicos/{id}  

## Acceso al Proyecto

1. Clona o descarga este repositorio desde GitHub.
2. Configura tu base de datos MySQL con las credenciales correctas en el archivo `application.properties`.
3. Ejecuta la aplicación a través de tu IDE favorito (IntelliJ IDEA, Eclipse) o mediante el comando Maven.

## Tecnologías Utilizadas 🔨

- **Java 21**: Lenguaje utilizado para el desarrollo de la API.
- **Spring Boot 3**: Framework principal para la construcción de la API REST.
- **Spring Data JPA**: Para la gestión de la base de datos y la implementación de operaciones CRUD.
- **Spring Security**: Para la autenticación y autorización de usuarios.
- **JWT (JSON Web Tokens)**: Para asegurar el acceso a las operaciones CRUD.
- **MySQL**: Base de datos relacional utilizada para almacenar los datos de los tópicos.
- **Flyway Migration**: Herramienta para la gestión de versiones de la base de datos.
- **Postman/Insomnia**: Herramientas para simular las solicitudes y respuestas HTTP.

## Persona Desarrolladora del Proyecto 💻

**Martin Lorenzi**  
Contacto: [alexmartin9c@gmail.com](mailto:alexmartin9c@gmail.com)

Este proyecto es parte de mi formación en desarrollo con **Spring Boot** y **MySQL**, y fue realizado como parte de un desafío propuesto por **Alura Latam** en colaboración con **Oracle Education**. Agradezco a los instructores por su guía y a la comunidad por el apoyo.

