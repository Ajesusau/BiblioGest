#  BiblioGest – Sistema de Gestión Bibliotecaria Escolar

**BiblioGest** es una aplicación de escritorio desarrollada en **Java** con interfaz gráfica usando **Swing**, diseñada para facilitar la gestión de bibliotecas escolares. Permite controlar libros, usuarios y préstamos, automatizando tareas comunes como avisos por vencimientos y generación de informes en PDF.

> Este proyecto fue desarrollado como parte del módulo de Desarrollo de Aplicaciones Multiplataforma (DAM) y tiene como objetivo digitalizar los procesos de préstamo y administración de bibliotecas de centros educativos.

---

##  Características destacadas

 **Gestión de libros**  
- Agregar, modificar o eliminar libros del catálogo  
- Búsqueda avanzada por título, autor, categoría o año de publicación  

 **Gestión de usuarios**  
- Registro de nuevos usuarios  
- Consulta de historial de préstamos, devoluciones y sanciones  

 **Automatización de préstamos**  
- Emisión y devolución de libros con control de fechas  
- Alertas automáticas por vencimientos de préstamos  

 **Informes en PDF**  
- Generación de reportes del inventario y del historial de préstamos utilizando **iText**

 **Control de roles**  
- Diferenciación entre usuarios comunes y administradores

---

##  Tecnologías utilizadas

| Herramienta         | Descripción                                              |
|---------------------|----------------------------------------------------------|
| Java (Swing)        | Interfaz gráfica de escritorio                           |
| MySQL               | Base de datos relacional                                 |
| JDBC / Hibernate    | Acceso a datos                                           |
| iText               | Generación de archivos PDF                               |
| NetBeans / IntelliJ | Entornos de desarrollo                                   |
| Git / GitHub        | Control de versiones y colaboración                      |

---

##  Estructura del Proyecto

- ** Módulo de Libros**: Gestión del catálogo, búsquedas, stock
- ** Módulo de Usuarios**: Registro, consultas y control de préstamos
- ** Módulo de Préstamos**: Emisión y devoluciones con validaciones
- ** Módulo de Informes**: Estadísticas exportables en PDF

---

##  Instalación y ejecución

###  Requisitos

- Java JDK 11+
- Servidor MySQL
- IDE como NetBeans o IntelliJ
- Conexión JDBC o Hibernate configurada

###  Pasos

1. Clona el repositorio:
   ```
   git clone https://github.com/tu-usuario/bibliogest.git
2. Configura la base de datos:

   - Crea una base de datos MySQL (biblioteca)

   - Importa el script SQL incluido en /db

3. Abre el proyecto en tu IDE y configura la conexión a la base de datos en hibernate.cfg.xml o mediante JDBC

4. Compila y ejecuta la aplicación desde tu entorno

##  Objetivos del Proyecto
 - Mejorar la eficiencia en el registro y control de libros

 - Facilitar el acceso y gestión del historial de préstamos

 - Automatizar alertas y generar informes útiles para la toma de decisiones

 - Reforzar habilidades de desarrollo en Java, diseño de bases de datos y experiencia de usuario
