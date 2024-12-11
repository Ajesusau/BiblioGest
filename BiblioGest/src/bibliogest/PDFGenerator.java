package bibliogest;

/**
 * Clase encargada de generar informes en formato PDF para libros y préstamos.
 * Utiliza la librería iText para crear documentos PDF.
 *
 * @author ajesusau
 */
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.FileOutputStream;
import java.util.List;

public class PDFGenerator {

    /**
     * Genera un informe en formato PDF con la información de los libros.
     *
     * @param rutaArchivo Ruta del archivo donde se guardará el informe
     * generado.
     * @param libros Lista de libros para incluir en el informe.
     * @throws java.lang.Exception Si ocurre un error general durante la
     * generación del informe.
     */
    public static void generarInformeLibros(String rutaArchivo, List<Libro> libros) throws Exception {
        PdfWriter writer = new PdfWriter(new FileOutputStream(rutaArchivo));
        try (Document document = new Document(new com.itextpdf.kernel.pdf.PdfDocument(writer))) {
            document.add(new Paragraph("Informe de Libros"));
            for (Libro libro : libros) {
                document.add(new Paragraph("Título: " + libro.getTitulo()));
                document.add(new Paragraph("Autor: " + libro.getAutor()));
                document.add(new Paragraph("Estado: " + libro.getEstado()));
                document.add(new Paragraph("--------------------------"));
            }
        }
    }

    /**
     * Genera un informe en formato PDF con la información de los préstamos.
     *
     * @param rutaArchivo Ruta del archivo donde se guardará el informe
     * generado.
     * @param prestamos Lista de préstamos para incluir en el informe.
     * @throws java.lang.Exception Si ocurre un error general durante la
     * generación del informe.
     */
    public static void generarInformePrestamos(String rutaArchivo, List<Prestamo> prestamos) throws Exception {
        PdfWriter writer = new PdfWriter(new FileOutputStream(rutaArchivo));
        try (Document document = new Document(new com.itextpdf.kernel.pdf.PdfDocument(writer))) {
            document.add(new Paragraph("Informe de Préstamos"));
            for (Prestamo prestamo : prestamos) {
                document.add(new Paragraph("ID Préstamo: " + prestamo.getIdPrestamo()));
                document.add(new Paragraph("Usuario ID: " + prestamo.getUsuarioId()));
                document.add(new Paragraph("Libro ID: " + prestamo.getLibroId()));
                document.add(new Paragraph("Estado: " + prestamo.getEstado()));
                document.add(new Paragraph("--------------------------"));
            }
        }
    }
}
