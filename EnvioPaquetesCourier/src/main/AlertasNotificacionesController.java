package main;

import javax.swing.*;
import java.util.HashMap;

public class AlertasNotificacionesController {
    private AlertasNotificacionesView view;
    private AlertasNotificaciones model;
    private static HashMap<String, Envio> envios = RegistroEnvioController.getEnvios(); // Obtener envíos registrados

    public AlertasNotificacionesController(AlertasNotificacionesView view) {
        this.view = view;
        this.model = new AlertasNotificaciones();
    }

    // Método para asociar un retraso al envío
    public void alertarRetraso(String numeroSeguimiento) {
        Envio envio = envios.get(numeroSeguimiento);
        if (envio != null) {
        	if (envio.getEstadoEnvio() == "Entregado") {
        		JOptionPane.showMessageDialog(view, "El envio ya fue entregado exitosamente.", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				envio.setEstadoEnvio("Retrasado"); // Actualizar el estado del envío
	            model.alertarRetraso(numeroSeguimiento); // Crear una notificación
	            view.mostrarNotificacionProcesada("Retraso registrado para el envío con número: " + numeroSeguimiento +
	                    ". Estado actualizado: " + envio.getEstadoEnvio());
			}
            
        } else {
            JOptionPane.showMessageDialog(view, "El número de seguimiento no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para notificar entrega exitosa
    public void notificarEntregaExitosa(String numeroSeguimiento) {
        Envio envio = envios.get(numeroSeguimiento);
        if (envio != null) {
            envio.setEstadoEnvio("Entregado"); // Actualizar el estado del envío
            model.notificarEntregaExitosa(numeroSeguimiento); // Crear una notificación
            view.mostrarNotificacionProcesada("Entrega exitosa registrada para el envío con número: " + numeroSeguimiento +
                    ". Estado actualizado: " + envio.getEstadoEnvio());
        } else {
            JOptionPane.showMessageDialog(view, "El número de seguimiento no existe.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Procesar todas las notificaciones pendientes
    public void procesarNotificaciones() {
        model.procesarNotificaciones();
    }
}
