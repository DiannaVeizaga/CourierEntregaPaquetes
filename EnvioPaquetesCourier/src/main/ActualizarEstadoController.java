package main;
import javax.swing.JOptionPane;

public class ActualizarEstadoController {
    private ActualizarEstadoView view;

    public ActualizarEstadoController(ActualizarEstadoView view) {
        this.view = view;
    }

    // Actualiza el estado de un envío
    public void actualizarEstado(String numeroSeguimiento, String nuevoEstado) {
        // Lógica para actualizar el estado del envío (simulación)
        JOptionPane.showMessageDialog(view, "Estado del envío " + numeroSeguimiento + " actualizado a " + nuevoEstado);
    }
}
