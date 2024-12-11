package bibliogest;

/**
 * Clase que representa un libro en la biblioteca. Contiene atributos ID,
 * título, autor, ISBN, fecha de publicación y estado. Proporciona métodos para
 * acceder y modificar los atributos.
 *
 * @author ajesusau
 */
import java.time.LocalDate;

public class Libro {

    private int idLibro;                // ID único del libro
    private String titulo;              // Título del libro
    private String autor;               // Autor del libro
    private String isbn;                // Código ISBN del libro
    private LocalDate fechaPublicacion; // Fecha de publicación del libro
    private String estado;              // Estado del libro (disponible o prestado)

    /**
     * Constructor para crear un libro con todos los atributos.
     *
     * @param idLibro ID único del libro.
     * @param titulo Título del libro.
     * @param autor Autor del libro.
     * @param isbn Código ISBN del libro.
     * @param fechaPublicacion Fecha de publicación.
     * @param estado Estado del libro (disponible o prestado).
     */
    public Libro(int idLibro, String titulo, String autor, String isbn, LocalDate fechaPublicacion, String estado) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.fechaPublicacion = fechaPublicacion;
        this.estado = estado;
    }

    /**
     * Constructor para crear un libro sin ID (nuevo libro).
     *
     * @param titulo Título del libro.
     * @param autor Autor del libro.
     * @param isbn Código ISBN del libro.
     * @param fechaPublicacion Fecha de publicación del libro.
     * @param estado Estado del libro (disponible o prestado).
     */
    public Libro(String titulo, String autor, String isbn, LocalDate fechaPublicacion, String estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.fechaPublicacion = fechaPublicacion;
        this.estado = estado;
    }

    /**
     * Devuelve el ID del libro.
     *
     * @return El ID del libro.
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * Establece un nuevo ID del libro.
     *
     * @param idLibro Nuevo ID del libro.
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Devuelve el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece un nuevo título para el libro.
     *
     * @param titulo Nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece un nuevo autor para el libro.
     *
     * @param autor Nuevo título del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Devuelve el ISBN del libro.
     *
     * @return El ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece un nuevo ISBN para el libro.
     *
     * @param isbn Nuevo ISBN del libro.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Devuelve la fecha de publicación del libro.
     *
     * @return La fecha de publicación del libro.
     */
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Establece una fecha de publicación para el libro.
     *
     * @param fechaPublicacion Nueva fecha de publicación del libro.
     */
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Devuelve el estado del libro.
     *
     * @return La estado del libro.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece un nuevo estado para el libro.
     *
     * @param estado Nuevo estado del libro.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
