package TestDAO;

import bibliogest.Prestamo;
import bibliogest.dao.PrestamoDAO;
import bibliogest.dao.UsuarioDAO;
import bibliogest.dao.LibroDAO;
import bibliogest.Usuario;
import bibliogest.Libro;
import org.junit.*;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ajesusau
 */
public class PrestamosDAOTest {

    private static PrestamoDAO prestamoDAO;
    private static UsuarioDAO usuarioDAO;
    private static LibroDAO libroDAO;

    @BeforeClass
    public static void configurarClase() throws Exception {
        prestamoDAO = new PrestamoDAO();
        libroDAO = new LibroDAO();
        Libro libro = new Libro(1, "El Quijote", "Cervantes", "1234567890123", LocalDate.now(), "disponible");
        libroDAO.addLibro(libro);
    }

    @AfterClass
    public static void limpiarClase() throws Exception {
        List<Prestamo> prestamos = prestamoDAO.getPrestamos();
        for (Prestamo prestamo : prestamos) {
            prestamoDAO.deletePrestamo(prestamo.getIdPrestamo());
        }
        List<Libro> libros = libroDAO.getLibros();
        for (Libro libro : libros) {
            libroDAO.deleteLibro(libro.getIdLibro());
        }
    }

       @After
    public void limpiarTest() throws Exception {
        List<Prestamo> prestamos = prestamoDAO.getPrestamos();
        for (Prestamo prestamo : prestamos) {
            prestamoDAO.deletePrestamo(prestamo.getIdPrestamo());
        }
    }

    @Test
    public void testRegistrarPrestamo() throws Exception {
        Prestamo prestamo = new Prestamo(0, 1, 1, LocalDate.of(2024, 12, 10), null, "pendiente");
        prestamoDAO.addPrestamo(prestamo);

        List<Prestamo> prestamos = prestamoDAO.getPrestamos();
        Assert.assertNotNull(prestamos);
        Assert.assertEquals(1, prestamos.size());
        Assert.assertEquals(1, prestamos.get(0).getUsuarioId());
        Assert.assertEquals(1, prestamos.get(0).getLibroId());
        Assert.assertEquals("pendiente", prestamos.get(0).getEstado());
    }

    @Test
    public void testActualizarPrestamo() throws Exception {
        Prestamo prestamo = new Prestamo(0, 1, 1, LocalDate.of(2024, 12, 10), null, "pendiente");
        prestamoDAO.addPrestamo(prestamo);

        prestamo = prestamoDAO.getPrestamos().get(0);
        LocalDate nuevaFechaDevolucion = LocalDate.of(2024, 12, 20);
        prestamoDAO.updatePrestamoEstado(prestamo.getIdPrestamo(), "devuelto");
        prestamoDAO.updateFechaDevolucion(prestamo.getIdPrestamo(), nuevaFechaDevolucion);

        Prestamo updatedPrestamo = prestamoDAO.getPrestamoById(prestamo.getIdPrestamo());
        Assert.assertNotNull(updatedPrestamo);
        Assert.assertEquals("devuelto", updatedPrestamo.getEstado());
        Assert.assertEquals(nuevaFechaDevolucion, updatedPrestamo.getFechaDevolucion());
    }

    @Test
    public void testEliminarPrestamo() throws Exception {
        Prestamo prestamo = new Prestamo(0, 1, 1, LocalDate.of(2024, 12, 10), null, "pendiente");
        prestamoDAO.addPrestamo(prestamo);

        prestamo = prestamoDAO.getPrestamos().get(0);
        prestamoDAO.deletePrestamo(prestamo.getIdPrestamo());

        List<Prestamo> prestamos = prestamoDAO.getPrestamos();
        Assert.assertNotNull(prestamos);
        Assert.assertTrue(prestamos.isEmpty());
    }

    @Test
    public void testConsultarPrestamosPorUsuario() throws Exception {
        Prestamo prestamo1 = new Prestamo(0, 1, 1, LocalDate.of(2024, 12, 10), null, "pendiente");
        prestamoDAO.addPrestamo(prestamo1);

        List<Prestamo> prestamos = prestamoDAO.getPrestamosByUsuarioId(1);
        Assert.assertNotNull(prestamos);
        Assert.assertEquals(1, prestamos.size());
    }
}
