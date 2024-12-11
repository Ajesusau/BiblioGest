package bibliogest.Alertas;

/**
 * Clase que gestiona el sistema de alertas automáticas para los préstamos.
 * Ejecuta verificaciones periódicas y almacena alertas generadas.
 *
 * @author ajesusau
 */
import bibliogest.dao.PrestamoDAO;
import bibliogest.Prestamo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AlertManager {

    // Lista estática que almacena los mensajes de alerta generados.
    private static final List<String> alertas = new ArrayList<>();

    /**
     * Inicia el sistema de alertas automáticas. Configura un temporizador que
     * ejecuta las verificaciones cada 24 horas.
     */
    public static void startAlerts() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            /**
             * Ejecuta la tarea programada para verificar los préstamos y
             * generar alertas.
             */
            public void run() {
                verificarPrestamos();
            }
        }, 0, 24 * 60 * 60 * 1000);
    }

    /**
     * Verifica los préstamos en la base de datos y genera alertas para los
     * vencidos o próximos a vencer.
     *
     * @return Lista de mensajes de alerta generados.
     */
    private static void verificarPrestamos() {
        PrestamoDAO prestamoDAO = new PrestamoDAO();
        var prestamos = prestamoDAO.getPrestamosProximosVencer(LocalDate.now().plusDays(3));
        for (Prestamo prestamo : prestamos) {
            String alerta = "El préstamo con ID " + prestamo.getIdPrestamo() + " está próximo a vencer.";
            alertas.add(alerta);
            System.out.println(alerta);
        }
    }

    /**
     * Devuelve la lista actual de alertas generadas.
     *
     * @return Lista de mensajes de alerta.
     */
    public static List<String> getAlerts() {
        return new ArrayList<>(alertas);
    }

    /**
     * Limpia todas las alertas generadas anteriormente.
     */
    public static void limpiarAlertas() {
        alertas.clear();
    }
}
