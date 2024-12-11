package bibliogest.dao;

/**
 * Clase que gestiona las operaciones de acceso a datos para los préstamos.
 * Incluye métodos para operaciones CRUD y consultas avanzadas como préstamos
 * activos y próximos a vencer.
 *
 * @author ajesusau
 */
import bibliogest.Prestamo;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    /**
     * Agrega un nuevo préstamo a la base de datos.
     *
     * @param prestamo Objeto Prestamo con los datos del nuevo préstamo.
     * @throws SQLException Si ocurre un error durante la inserción.
     */
    public void addPrestamo(Prestamo prestamo) throws SQLException {
        String checkUser = "SELECT COUNT(*) FROM Usuarios WHERE id_usuario = ?";
        String checkBook = "SELECT COUNT(*) FROM Libros WHERE id_libro = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement userStmt = connection.prepareStatement(checkUser); PreparedStatement bookStmt = connection.prepareStatement(checkBook)) {
            userStmt.setInt(1, prestamo.getUsuarioId());
            bookStmt.setInt(1, prestamo.getLibroId());
            ResultSet userResult = userStmt.executeQuery();
            ResultSet bookResult = bookStmt.executeQuery();
            if (userResult.next() && bookResult.next()) {
                if (userResult.getInt(1) == 0) {
                    throw new SQLException("El usuario no existe en la base de datos.");
                }
                if (bookResult.getInt(1) == 0) {
                    throw new SQLException("El libro no existe en la base de datos.");
                }
            }
        }
        String sql = "INSERT INTO Prestamos (usuario_id, libro_id, fecha_prestamo, fecha_devolucion, estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = DatabaseConnection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, prestamo.getUsuarioId());
            statement.setInt(2, prestamo.getLibroId());
            statement.setDate(3, Date.valueOf(prestamo.getFechaPrestamo()));
            statement.setDate(4, prestamo.getFechaDevolucion() != null ? Date.valueOf(prestamo.getFechaDevolucion()) : null);
            statement.setString(5, prestamo.getEstado());
            statement.executeUpdate();
        }
    }

    /**
     * Recupera todos los préstamos registrados en la base de datos.
     *
     * @return Lista de objetos Prestamo.
     */
    public List<Prestamo> getPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM Prestamos";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                prestamos.add(new Prestamo(
                        resultSet.getInt("id_prestamo"),
                        resultSet.getInt("usuario_id"),
                        resultSet.getInt("libro_id"),
                        resultSet.getDate("fecha_prestamo").toLocalDate(),
                        resultSet.getDate("fecha_devolucion") != null ? resultSet.getDate("fecha_devolucion").toLocalDate() : null,
                        resultSet.getString("estado")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los préstamos: " + e.getMessage());
        }
        return prestamos;
    }

    /**
     * Actualiza el estado de un préstamo en la base de datos.
     *
     * @param idPrestamo ID del préstamo a actualizar.
     * @param estado Nuevo estado del préstamo (pendiente, devuelto, etc.).
     * @throws SQLException Si ocurre un error durante la actualización.
     */
    public void updatePrestamoEstado(int idPrestamo, String estado) throws SQLException {
        String sql = "UPDATE Prestamos SET estado = ? WHERE id_prestamo = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, estado);
            statement.setInt(2, idPrestamo);
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un préstamo de la base de datos basado en su ID.
     *
     * @param idPrestamo ID del préstamo a eliminar.
     * @throws SQLException Si ocurre un error durante la eliminación.
     */
    public void deletePrestamo(int idPrestamo) throws SQLException {
        String sql = "DELETE FROM Prestamos WHERE id_prestamo = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPrestamo);
            statement.executeUpdate();
        }
    }

    /**
     * Actualiza la fecha de devolución de un préstamo.
     *
     * @param idPrestamo ID del préstamo a actualizar.
     * @param fechaDevolucion Nueva fecha de devolución.
     * @throws SQLException Si ocurre un error durante la actualización.
     */
    public void updateFechaDevolucion(int idPrestamo, LocalDate fechaDevolucion) throws SQLException {
        String sql = "UPDATE Prestamos SET fecha_devolucion = ? WHERE id_prestamo = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, Date.valueOf(fechaDevolucion));
            statement.setInt(2, idPrestamo);
            statement.executeUpdate();
        }
    }

    /**
     * Cuenta los préstamos activos asociados a un usuario.
     *
     * @param idUsuario ID del usuario.
     * @return Número de préstamos activos.
     */
    public int contarPrestamosActivos(int idUsuario) {
        String sql = "SELECT COUNT(*) FROM Prestamos WHERE usuario_id = ? AND estado = 'pendiente'";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error al contar los préstamos activos: " + e.getMessage());
        }
        return 0;
    }

    /**
     * Recupera un préstamo basado en su ID.
     *
     * @param idPrestamo ID del préstamo.
     * @return Objeto Prestamo con los datos, o null si no se encuentra.
     */
    public Prestamo getPrestamoById(int idPrestamo) {
        String sql = "SELECT * FROM Prestamos WHERE id_prestamo = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idPrestamo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Prestamo(
                        resultSet.getInt("id_prestamo"),
                        resultSet.getInt("usuario_id"),
                        resultSet.getInt("libro_id"),
                        resultSet.getDate("fecha_prestamo").toLocalDate(),
                        resultSet.getDate("fecha_devolucion").toLocalDate(),
                        resultSet.getString("estado")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener préstamo por ID: " + e.getMessage());
        }
        return null;
    }

    /**
     * Obtiene todos los préstamos asociados a un usuario.
     *
     * @param usuarioId ID del usuario.
     * @return Lista de préstamos del usuario.
     */
    public List<Prestamo> getPrestamosByUsuarioId(int usuarioId) {
        List<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM Prestamos WHERE usuario_id = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                prestamos.add(new Prestamo(
                        resultSet.getInt("id_prestamo"),
                        resultSet.getInt("usuario_id"),
                        resultSet.getInt("libro_id"),
                        resultSet.getDate("fecha_prestamo").toLocalDate(),
                        resultSet.getDate("fecha_devolucion") != null ? resultSet.getDate("fecha_devolucion").toLocalDate() : null,
                        resultSet.getString("estado")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener préstamos por usuario ID: " + e.getMessage());
        }
        return prestamos;
    }

    /**
     * Obtiene una lista de préstamos próximos a vencer.
     *
     * @param fechaLimite Fecha limite del prestamo.
     * @return Lista de objetos Prestamo próximos a vencer.
     */
    public List<Prestamo> getPrestamosProximosVencer(LocalDate fechaLimite) {
        List<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM Prestamos WHERE fecha_devolucion <= ? AND estado = 'pendiente'";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, java.sql.Date.valueOf(fechaLimite));
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Prestamo prestamo = new Prestamo(
                            resultSet.getInt("id_prestamo"),
                            resultSet.getInt("usuario_id"),
                            resultSet.getInt("libro_id"),
                            resultSet.getDate("fecha_prestamo").toLocalDate(),
                            resultSet.getDate("fecha_devolucion").toLocalDate(),
                            resultSet.getString("estado")
                    );
                    prestamos.add(prestamo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamos;
    }
}
