package main;

import java.util.PriorityQueue;

public class AlertasNotificaciones {
    private PriorityQueue<Notificacion> colaNotificaciones;

    public AlertasNotificaciones() {
        this.colaNotificaciones = new PriorityQueue<>();
    }

    // Agregar una notificación a la cola
    public void agregarNotificacion(String mensaje, int prioridad) {
        Notificacion notificacion = new Notificacion(mensaje, prioridad);
        colaNotificaciones.add(notificacion);
    }

    // Procesar todas las notificaciones
    public void procesarNotificaciones() {
        while (!colaNotificaciones.isEmpty()) {
            Notificacion notificacion = colaNotificaciones.poll(); // Obtiene y elimina la notificación con mayor prioridad
            System.out.println("Notificación: " + notificacion.getMensaje());
        }
    }

    // Métodos específicos para retrasos y entregas
    public void alertarRetraso(String numeroSeguimiento) {
        String mensaje = "El paquete con número de seguimiento " + numeroSeguimiento + " ha sufrido un retraso.";
        agregarNotificacion(mensaje, 1); // Prioridad alta
    }

    public void notificarEntregaExitosa(String numeroSeguimiento) {
        String mensaje = "El paquete con número de seguimiento " + numeroSeguimiento + " ha sido entregado exitosamente.";
        agregarNotificacion(mensaje, 2); // Prioridad media
    }

    // Getter para la cola de notificaciones
    public PriorityQueue<Notificacion> getColaNotificaciones() {
        return colaNotificaciones;
    }
}
