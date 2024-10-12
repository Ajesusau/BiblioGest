BiblioGest - Software de Gestión Bibliotecaria Eficiente
BiblioGest es un software de escritorio creado para facilitar y optimizar la gestión de bibliotecas, permitiendo a los administradores controlar catálogos de libros, usuarios y préstamos de manera eficiente. La aplicación está desarrollada en Java , utilizando Swing para la interfaz gráfica, y se conecta a una base de datos MySQL mediante JDBC o Hibernate para la persistencia de datos. Además, cuenta con funcionalidades automatizadas para alertar sobre préstamos vencidos y generar informes detallados en formato PDF.

Características principales :
Gestión de Libros : Agrega, edita y elimina libros del catálogo de manera sencilla y rápida.
Gestión de Usuarios : Registra nuevos usuarios y gestiona su historial de préstamos, devoluciones y sanciones.
Automatización de Préstamos : Envía recordatorios y alertas cuando los préstamos están a punto de vencer o ya han vencido.
Búsqueda Avanzada : Los usuarios pueden buscar libros por título, autor, categoría o fecha de publicación, facilitando el acceso rápido a los recursos.
Generación de Informes : Los administradores pueden exportar informes en formato PDF sobre el inventario de libros y el historial de préstamos, ayudando a una mejor toma de decisiones.
Tecnologías utilizadas :
Java (Swing) : Utilizado para el desarrollo de una interfaz gráfica amigable y fácil de usar.
MySQL : Base de datos relacional utilizada para almacenar información sobre libros, usuarios y préstamos.
JDBC / Hibernate : Herramientas que facilitan la conexión y el acceso eficiente a la base de datos.
iText : Librería utilizada para generar informes y documentos en formato PDF.
Git/GitHub : Control de versiones para mantener un historial detallado de los cambios en el código y facilitar la colaboración.
Estructura del proyecto :
El proyecto está estructurado en varios módulos que permiten una mejor organización y mantenimiento del código:

Módulo de Gestión de Libros : Incluye todas las funcionalidades relacionadas con la administración de los libros, como agregar, editar, eliminar y buscar libros.
Módulo de Gestión de Usuarios : Gestiona las operaciones de registro de usuarios y el manejo de su historial de préstamos.
Módulo de Préstamos : Automatiza la emisión de préstamos y devoluciones, gestionando las fechas y alertas.
Generación de Informes : Permite la creación de informes PDF con estadísticas sobre los libros y los beneficios obtenidos.
Cómo usar BiblioGest :
Instalación :
Clona el repositorio de GitHub.
Configura tu base de datos MySQL.
Importa el esquema de la base de datos proporcionada en la carpeta /db.
Asegúrese de tener configuradas las dependencias de JDBC o Hibernate en su entorno de desarrollo.
Ejecución :
Abre el proyecto en NetBeans o el IDE de tu preferencia.
Compila y ejecuta la aplicación desde el entorno de desarrollo.
Funciones principales :
Navega a través del menú principal para gestionar libros, usuarios y préstamos.
Usa el panel de búsqueda para encontrar rápidamente libros según varios criterios.
Exporta informes de inventario e historial de préstamos en PDF desde el menú de administración.
