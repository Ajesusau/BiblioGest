package bibliogest.dao;

/**
 * Clase encargada de gestionar la conexión con la base de datos MySQL.
 * Proporciona un método para establecer y recuperar conexiones de forma segura.
 *
 * @author ajesusau
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de la base de datos MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/bibliogest_db";
    // Usuario para la conexión a la base de datos
    private static final String USER = "root";
    // Contraseña para la conexión a la base de datos
    private static final String PASSWORD = "root";

    /**
     * Establece y devuelve una conexión con la base de datos.
     *
     * @return Objeto Connection para interactuar con la base de datos.
     */
    public static Connection getConnection() {
        Connection connect = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa a la base de datos.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return connect;
    }
}
