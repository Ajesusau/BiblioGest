package bibliogest.validator;

import java.text.Normalizer;

/**
 * Clase que proporciona métodos para validar y normalizar textos. Incluye
 * funcionalidades como eliminación de acentos y validación de correos
 * electrónicos.
 *
 * @author ajesusau
 */
public class TextValidator {

    /**
     * Normaliza un texto eliminando acentos, convirtiendo a minúsculas y
     * reduciendo espacios.
     *
     * @param texto Texto de entrada a normalizar.
     * @return Texto normalizado.
     */
    public static String normalizarTexto(String texto) {
        if (texto == null) {
            return "";
        }
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        texto = texto.toLowerCase().trim();
        texto = texto.replaceAll("\\s+", " ");
        return texto;
    }

    /**
     * Verifica si un texto tiene el formato de un correo electrónico válido.
     *
     * @param email Texto a evaluar.
     * @return true si el texto es un correo válido, false en caso contrario.
     */
    public static boolean isEmailValido(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(regex);
    }
}
