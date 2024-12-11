package bibliogest.dao;

/**
 * Clase que gestiona las operaciones de acceso a datos para los libros.
 * Proporciona métodos para realizar operaciones CRUD y consultas específicas.
 *
 * @author ajesusau
 */
import bibliogest.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLIntegrityConstraintViolationException;

public class LibroDAO {

    /**
     * Añade un nuevo libro a la base de datos.
     *
     * @param libro Objeto Libro que contiene los datos del nuevo libro.
     * @throws SQLException Si ocurre un error durante la inserción.
     */
    public void addLibro(Libro libro) throws SQLException {
        String sql = "INSERT INTO Libros (titulo, autor, ISBN, fecha_publicacion, estado) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setString(3, libro.getIsbn());
            statement.setDate(4, java.sql.Date.valueOf(libro.getFechaPublicacion()));
            statement.setString(5, libro.getEstado());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLException("El ISBN ya existe en la base de datos.");
        } catch (SQLException e) {
            throw new SQLException("Error al añadir el libro: " + e.getMessage());
        }
    }

    /**
     * Recupera todos los libros almacenados en la base de datos.
     *
     * @return Lista de objetos Libro con los datos de los libros.
     */
    public List<Libro> getLibros() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libros";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Libro libro = new Libro(
                        resultSet.getInt("id_libro"),
                        resultSet.getString("titulo"),
                        resultSet.getString("autor"),
                        resultSet.getString("ISBN"),
                        resultSet.getDate("fecha_publicacion").toLocalDate(),
                        resultSet.getString("estado")
                );
                libros.add(libro);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los libros.");
        }
        return libros;
    }

    /**
     * Actualiza los datos de un libro en la base de datos.
     *
     * @param libro Objeto Libro con los datos actualizados.
     * @throws SQLException Si ocurre un error durante la actualización.
     */
    public void updateLibro(Libro libro) throws SQLException {
        String sql = "UPDATE Libros SET titulo = ?, autor = ?, ISBN = ?, fecha_publicacion = ?, estado = ? WHERE id_libro = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setString(3, libro.getIsbn());
            statement.setDate(4, java.sql.Date.valueOf(libro.getFechaPublicacion()));
            statement.setString(5, libro.getEstado());
            statement.setInt(6, libro.getIdLibro());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new SQLException("El ISBN ya existe en la base de datos.");
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar el libro: " + e.getMessage());
        }
    }

    /**
     * Elimina un libro de la base de datos basado en su ID.
     *
     * @param id ID del libro a eliminar.
     */
    public void deleteLibro(int id) {
        String sql = "DELETE FROM Libros WHERE id_libro = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Libro eliminado exitosamente de la base de datos.");
            } else {
                System.out.println("No se encontró ningún libro con ese ID para eliminar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro.");
        }
    }

    /**
     * Busca libros en la base de datos que coincidan con un patrón dado.
     *
     * @param criterio Cadena de texto para filtrar los resultados.
     * @return Lista de libros que coinciden con el patrón.
     * @throws SQLException Si ocurre un error durante la consulta.
     */
    public List<Libro> buscarLibros(String criterio) throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM Libros WHERE LOWER(titulo) LIKE LOWER(?) OR LOWER(autor) LIKE LOWER(?) OR ISBN = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            String patron = "%" + criterio + "%";
            statement.setString(1, patron);
            statement.setString(2, patron);
            statement.setString(3, criterio);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Libro libro = new Libro(
                            resultSet.getInt("id_libro"),
                            resultSet.getString("titulo"),
                            resultSet.getString("autor"),
                            resultSet.getString("ISBN"),
                            resultSet.getDate("fecha_publicacion").toLocalDate(),
                            resultSet.getString("estado")
                    );
                    libros.add(libro);
                }
            }
        }
        return libros;
    }

    /**
     * Recupera un libro basado en su ID.
     *
     * @param idLibro ID del libro a buscar.
     * @return Objeto Libro con los datos del libro encontrado, o null si no
     * existe.
     */
    public Libro getLibroById(int idLibro) {
        String sql = "SELECT * FROM Libros WHERE id_libro = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idLibro);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Libro(
                        resultSet.getInt("id_libro"),
                        resultSet.getString("titulo"),
                        resultSet.getString("autor"),
                        resultSet.getString("ISBN"),
                        resultSet.getDate("fecha_publicacion").toLocalDate(),
                        resultSet.getString("estado")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el libro por ID: " + e.getMessage());
        }
        return null; // Si ocurre un error, devuelve null
    }

    /**
     * Verifica si un libro está disponible para préstamo.
     *
     * @param idLibro ID del libro a verificar.
     * @return true si el libro está disponible, false en caso contrario.
     */
    public boolean isLibroDisponible(int idLibro) {
        String sql = "SELECT estado FROM Libros WHERE id_libro = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idLibro);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("estado").equals("disponible");
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar la disponibilidad del libro: " + e.getMessage());
        }
        return false;
    }

    /**
     * Actualiza el estado de un libro en la base de datos.
     *
     * @param idLibro ID del libro cuyo estado será actualizado.
     * @param estado Nuevo estado del libro (disponible, prestado, etc.).
     * @throws SQLException Si ocurre un error durante la actualización.
     */
    public void actualizarEstadoLibro(int idLibro, String estado) throws SQLException {
        String sql = "UPDATE Libros SET estado = ? WHERE id_libro = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, estado);
            statement.setInt(2, idLibro);
            statement.executeUpdate();
        }
    }
}
