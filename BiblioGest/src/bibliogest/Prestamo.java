package bibliogest;

/**
 * Clase que representa un préstamo en el sistema de gestión bibliotecaria.
 * Incluye información sobre el ID del préstamo, usuario, libro, fechas de
 * préstamo y devolución, y estado. Proporciona métodos para acceder y modificar
 * estos atributos.
 *
 * @author ajesusau
 */
import java.time.LocalDate;

public class Prestamo {

    private int idPrestamo;             //ID único del préstamo.
    private int usuarioId;              //ID del usuario asociado al préstamo.
    private int libroId;                //ID del libro asociado al préstamo.
    private LocalDate fechaPrestamo;    //Fecha del préstamo.
    private LocalDate fechaDevolucion;  //Fecha de devolución.
    private String estado;              //Estado del préstamo (pendiente o devuelto).

    /**
     * Constructor para crear un préstamo con todos los atributos.
     *
     * @param idPrestamo ID único del préstamo.
     * @param usuarioId ID del usuario asociado al préstamo.
     * @param libroId ID del libro asociado al préstamo.
     * @param fechaPrestamo Fecha del préstamo.
     * @param fechaDevolucion Fecha de devolución.
     * @param estado Estado del préstamo (pendiente o devuelto).
     */
    public Prestamo(int idPrestamo, int usuarioId, int libroId, LocalDate fechaPrestamo, LocalDate fechaDevolucion, String estado) {
        this.idPrestamo = idPrestamo;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    /**
     * Constructor para crear un préstamo sin ID (nuevo préstamo).
     *
     * @param usuarioId ID del usuario asociado al préstamo.
     * @param libroId ID del libro asociado al préstamo.
     * @param fechaPrestamo Fecha del préstamo.
     * @param fechaDevolucion Fecha de devolución.
     * @param estado Estado del préstamo (pendiente o devuelto).
     */
    public Prestamo(int usuarioId, int libroId, LocalDate fechaPrestamo, LocalDate fechaDevolucion, String estado) {
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    /**
     * Devuelve el ID del préstamo.
     *
     * @return El ID del préstamo.
     */
    public int getIdPrestamo() {
        return idPrestamo;
    }

    /**
     * Establece un nuevo ID para el préstamo.
     *
     * @param idPrestamo Nuevo ID del préstamo.
     */
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    /**
     * Devuelve el ID del usuario del préstamo.
     *
     * @return El ID del usuario del préstamo.
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * Establece un nuevo ID del usuario del préstamo.
     *
     * @param usuarioId Nuevo ID del usuario del préstamo.
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * Devuelve el ID del libro del préstamo.
     *
     * @return El ID del libro del préstamo.
     */
    public int getLibroId() {
        return libroId;
    }

    /**
     * Establece un nuevo ID del libro del préstamo.
     *
     * @param libroId Nuevo ID del libro del préstamo.
     */
    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    /**
     * Devuelve la fecha del préstamo.
     *
     * @return La fecha del préstamo.
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Establece una nueva fecha del préstamo.
     *
     * @param fechaPrestamo Nueva fecha del préstamo.
     */
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Devuelve la fecha de devolución del préstamo.
     *
     * @return La fecha de devolución del préstamo.
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Establece una nueva fecha de devolución del préstamo.
     *
     * @param fechaDevolucion Nueva fecha del préstamo.
     */
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Devuelve el estado del préstamo.
     *
     * @return El estado del préstamo.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece un nueva estado del préstamo.
     *
     * @param estado Nuevo estado del préstamo.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
