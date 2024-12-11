package bibliogest.dao;

/**
 * Clase que gestiona las operaciones de acceso a datos para los usuarios en la
 * base de datos. Incluye métodos para operaciones CRUD y consultas específicas.
 *
 * @author ajesusau
 */
import bibliogest.Usuario;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    /**
     * Crea un nuevo usuario en la base de datos.
     *
     * @param usuario Objeto Usuario con los datos del nuevo usuario.
     * @throws SQLException Si ocurre un error durante la inserción.
     */
    public void addUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuarios (usuario, contrasena, email, tipo_usuario) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getContrasena());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getTipoUsuario());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene un usuario por su ID de usuario.
     *
     * @param idUsuario ID del usuario.
     * @return Objeto Usuario si se encuentra, null en caso contrario.
     */
    public Usuario getUsuario(int idUsuario) {
        String sql = "SELECT * FROM Usuarios WHERE id_usuario = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Timestamp fechaRegistroTimestamp = resultSet.getTimestamp("fecha_registro");
                LocalDateTime fechaRegistro = (fechaRegistroTimestamp != null)
                        ? fechaRegistroTimestamp.toLocalDateTime()
                        : null;
                return new Usuario(
                        resultSet.getInt("id_usuario"),
                        resultSet.getString("usuario"),
                        resultSet.getString("contrasena"),
                        resultSet.getString("email"),
                        resultSet.getString("tipo_usuario"),
                        fechaRegistro
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el usuario por ID: " + e.getMessage());
        }
        return null;
    }

    /**
     * Recupera todos los usuarios registrados en la base de datos.
     *
     * @return Lista de objetos Usuario.
     */
    public List<Usuario> getUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Timestamp fechaRegistroTimestamp = resultSet.getTimestamp("fecha_registro");
                LocalDateTime fechaRegistro = (fechaRegistroTimestamp != null)
                        ? fechaRegistroTimestamp.toLocalDateTime()
                        : null;
                usuarios.add(new Usuario(
                        resultSet.getInt("id_usuario"),
                        resultSet.getString("usuario"),
                        resultSet.getString("contrasena"),
                        resultSet.getString("email"),
                        resultSet.getString("tipo_usuario"),
                        fechaRegistro
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    /**
     * Actualiza los datos de un usuario en la base de datos.
     *
     * @param usuario Objeto Usuario con los datos actualizados.
     * @throws SQLException Si ocurre un error durante la actualización.
     */
    public void updateUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuarios SET usuario = ?, email = ?, tipo_usuario = ?, "
                + "contrasena = CASE WHEN ? = '' OR ? IS NULL THEN contrasena ELSE ? END "
                + "WHERE id_usuario = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getTipoUsuario());
            statement.setString(4, usuario.getContrasena());
            statement.setString(5, usuario.getContrasena());
            statement.setString(6, usuario.getContrasena());
            statement.setInt(7, usuario.getIdUsuario());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                System.err.println("No se encontró el usuario con el ID especificado.");
            }
        }
    }

    /**
     * Elimina un usuario de la base de datos basado en su ID.
     *
     * @param idUsuario ID del usuario a eliminar.
     * @throws SQLException Si ocurre un error durante la eliminación.
     */
    public void deleteUsuario(int idUsuario) throws SQLException {
        String sql = "DELETE FROM Usuarios WHERE id_usuario = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            statement.executeUpdate();
        }
    }

    /**
     * Recupera un usuario basado en su ID.
     *
     * @param idUsuario ID del usuario a buscar.
     * @return Objeto Usuario si se encuentra, null en caso contrario.
     */
    public Usuario getUsuarioById(int idUsuario) {
        String sql = "SELECT * FROM Usuarios WHERE id_usuario = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Timestamp fechaRegistroTimestamp = resultSet.getTimestamp("fecha_registro");
                LocalDateTime fechaRegistro = (fechaRegistroTimestamp != null)
                        ? fechaRegistroTimestamp.toLocalDateTime()
                        : null;
                return new Usuario(
                        resultSet.getInt("id_usuario"),
                        resultSet.getString("usuario"),
                        resultSet.getString("contrasena"),
                        resultSet.getString("email"),
                        resultSet.getString("tipo_usuario"),
                        fechaRegistro
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuario por ID: " + e.getMessage());
        }
        return null;
    }

    /**
     * Recupera un usuario basado en su nombre de usuario.
     *
     * @param username Nombre del usuario.
     * @return Objeto Usuario si se encuentra, null en caso contrario.
     */
    public Usuario getUsuarioByUsername(String username) {
        String sql = "SELECT * FROM Usuarios WHERE usuario = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Timestamp fechaRegistroTimestamp = resultSet.getTimestamp("fecha_registro");
                LocalDateTime fechaRegistro = (fechaRegistroTimestamp != null)
                        ? fechaRegistroTimestamp.toLocalDateTime()
                        : null;
                return new Usuario(
                        resultSet.getInt("id_usuario"),
                        resultSet.getString("usuario"),
                        resultSet.getString("contrasena"),
                        resultSet.getString("email"),
                        resultSet.getString("tipo_usuario"),
                        fechaRegistro
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el usuario: " + e.getMessage());
        }
        return null;
    }

    /**
     * Recupera el tipo de usuario (administrador o usuario normal) basado en su
     * nombre.
     *
     * @param usuario Nombre del usuario.
     * @return Cadena que representa el tipo de usuario, o null si no se
     * encuentra.
     */
    public static String getTipoUsuario(String usuario) {
        String query = "SELECT tipo_usuario FROM Usuarios WHERE usuario = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("tipo_usuario");
            }
        } catch (SQLException e) {
            System.err.println("Error al validar el login: " + e.getMessage());
        }
        return null;
    }

    /**
     * Valida las credenciales de un usuario en la base de datos.
     *
     * @param usuario Nombre del usuario a validar.
     * @param contrasena Contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    public static boolean validarLogin(String usuario, String contrasena) {
        String query = "SELECT * FROM Usuarios WHERE usuario = ? AND contrasena = ?";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al validar el login: " + e.getMessage());
        }
        return false;
    }
}
