package bibliogest;

import java.time.LocalDateTime;

/**
 *
 * Clase que representa un usuario en el sistema de gestión bibliotecaria.
 * Incluye atributos como ID, nombre de usuario, contraseña, email, tipo de
 * usuario y fecha de registro. Proporciona métodos para acceder y modificar
 * estos atributos.
 *
 * @author ajesusau
 */
public class Usuario {

    private int idUsuario;                  //ID único del usuario.
    private String usuario;                 //Nombre del usuario.
    private String contrasena;              //Contraseña del usuario.
    private String email;                   //Correo electrónico del usuario.
    private String tipoUsuario;             //Tipo de usuario (administrador o usuario).
    private LocalDateTime fechaRegistro;    //Fecha de registro del usuario.

    /**
     * Constructor para crear un usuario con todos los atributos.
     *
     * @param idUsuario ID único del usuario.
     * @param usuario Nombre del usuario.
     * @param contrasena Contraseña del usuario.
     * @param email Correo electrónico del usuario.
     * @param tipoUsuario Tipo de usuario (administrador o usuario).
     * @param fechaRegistro Fecha de registro del usuario.
     */
    public Usuario(int idUsuario, String usuario, String contrasena, String email, String tipoUsuario, LocalDateTime fechaRegistro) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Constructor para crear un usuario sin ID (nuevo usuario).
     *
     * @param usuario Nombre del usuario.
     * @param contrasena Contraseña del usuario.
     * @param email Correo electrónico del usuario.
     * @param tipoUsuario Tipo de usuario (administrador o usuario).
     * @param fechaRegistro Fecha de registro del usuario.
     */
    public Usuario(String usuario, String contrasena, String email, String tipoUsuario, LocalDateTime fechaRegistro) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Devuelve el ID del usuario.
     *
     * @return El ID del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece un nuevo ID para el usuario.
     *
     * @param idUsuario Nuevo ID del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Devuelve el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece un nuevo nombre para el usuario.
     *
     * @param usuario Nuevo nombre del usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece una nueva contraseña para el usuario.
     *
     * @param contrasena Nuevo nombre del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Devuelve el email del usuario.
     *
     * @return El email del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece un nuevo email para el usuario.
     *
     * @param email Nuevo email del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve el tipo de usuario de usuario.
     *
     * @return El tipo de usuario de usuario.
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Establece un nuevo tipo de usuario para el usuario.
     *
     * @param tipoUsuario Nuevo tipo de usuario de usuario.
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Devuelve la fecha de registro de usuario.
     *
     * @return La fecha de registro de usuario.
     */
    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece una nueva fecha de registro para el usuario.
     *
     * @param fechaRegistro Nueva fecha de registro de usuario.
     */
    public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
        this.fechaRegistro = (fechaRegistro != null) ? fechaRegistro.toLocalDateTime() : null;
    }
}
