package TestDAO;

import bibliogest.Libro;
import bibliogest.dao.LibroDAO;
import java.time.LocalDate;
import org.junit.*;
import java.util.List;

/**
 *
 * @author ajesusau
 */
public class LibroDAOTest {

    private LibroDAO libroDAO;

    @Before
    public void configurarTest() {
        libroDAO = new LibroDAO();
    }

    @After
    public void limpiarTest() throws Exception {
        for (Libro libro : libroDAO.getLibros()) {
            libroDAO.deleteLibro(libro.getIdLibro());
        }
    }

    @Test
    public void TestAñadirLibro() throws Exception {
        Libro libro = new Libro(0, "El Quijote", "Cervantes", "1234567890123", LocalDate.now(), "disponible");
        libroDAO.addLibro(libro);
        List<Libro> libros = libroDAO.getLibros();
        Assert.assertEquals(1, libros.size());
        Assert.assertEquals("El Quijote", libros.get(0).getTitulo());
    }

    @Test
    public void TestActualizarLibro() throws Exception {
        Libro libro = new Libro(0, "El Quijote", "Cervantes", "1234567890123", LocalDate.now(), "disponible");
        libroDAO.addLibro(libro);
        libro = libroDAO.getLibros().get(0);
        libro.setTitulo("El Quijote - Edición Especial");
        libroDAO.updateLibro(libro);
        Libro updatedLibro = libroDAO.getLibroById(libro.getIdLibro());
        Assert.assertNotNull(updatedLibro);
        Assert.assertEquals("El Quijote - Edición Especial", updatedLibro.getTitulo());
    }

    @Test
    public void TestEliminarLibro() throws Exception {
        Libro libro = new Libro(0, "El Quijote", "Cervantes", "1234567890123", LocalDate.now(), "disponible");
        libroDAO.addLibro(libro);
        libro = libroDAO.getLibros().get(0);
        libroDAO.deleteLibro(libro.getIdLibro());
        List<Libro> libros = libroDAO.getLibros();
        Assert.assertTrue(libros.isEmpty());
    }

    @Test
    public void TestBuscarLibros() throws Exception {
        Libro libro1 = new Libro(0, "El Quijote", "Cervantes", "1234567890123", LocalDate.now(), "disponible");
        Libro libro2 = new Libro(0, "Novelas Ejemplares", "Cervantes", "1234567890124", LocalDate.now(), "disponible");
        libroDAO.addLibro(libro1);
        libroDAO.addLibro(libro2);
        List<Libro> libros = libroDAO.buscarLibros("Cervantes");
        Assert.assertEquals(2, libros.size());
    }
}
