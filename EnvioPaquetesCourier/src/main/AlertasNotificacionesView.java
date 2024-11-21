package main;

import javax.swing.*;
import java.awt.*;

public class AlertasNotificacionesView extends JFrame {
    private JTextArea notificacionesArea;
    private JButton agregarRetrasoButton;
    private JButton agregarEntregaButton;
    private JButton procesarNotificacionesButton;
    private JTextField numeroSeguimientoField;
    private AlertasNotificacionesController controller;

    public AlertasNotificacionesView() {
        setTitle("Alertas y Notificaciones");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Configuración de la interfaz gráfica
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Campo para el número de seguimiento
        JPanel seguimientoPanel = new JPanel(new FlowLayout());
        seguimientoPanel.add(new JLabel("Número de Seguimiento:"));
        numeroSeguimientoField = new JTextField(15);
        seguimientoPanel.add(numeroSeguimientoField);
        panel.add(seguimientoPanel);

        // Botón para alertar retrasos
        agregarRetrasoButton = new JButton("Alertar Retraso");
        agregarRetrasoButton.addActionListener(e -> {
            String numeroSeguimiento = numeroSeguimientoField.getText();
            if (!numeroSeguimiento.isEmpty()) {
                controller.alertarRetraso(numeroSeguimiento);
                numeroSeguimientoField.setText(""); // Limpiar campo
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de seguimiento.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(agregarRetrasoButton);

        // Botón para notificar entregas exitosas
        agregarEntregaButton = new JButton("Notificar Entrega Exitosa");
        agregarEntregaButton.addActionListener(e -> {
            String numeroSeguimiento = numeroSeguimientoField.getText();
            if (!numeroSeguimiento.isEmpty()) {
                controller.notificarEntregaExitosa(numeroSeguimiento);
                numeroSeguimientoField.setText(""); // Limpiar campo
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número de seguimiento.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(agregarEntregaButton);

        // Botón para procesar todas las notificaciones
        procesarNotificacionesButton = new JButton("Procesar Notificaciones");
        procesarNotificacionesButton.addActionListener(e -> {
            controller.procesarNotificaciones();
        });
        panel.add(procesarNotificacionesButton);

        // Área para mostrar las notificaciones procesadas
        panel.add(new JLabel("Notificaciones Procesadas:"));
        notificacionesArea = new JTextArea(10, 40);
        notificacionesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(notificacionesArea);
        panel.add(scrollPane);

        add(panel);
    }

    // Método para asociar el controlador con la vista
    public void setController(AlertasNotificacionesController controller) {
        this.controller = controller;
    }

    // Método para mostrar notificaciones procesadas
    public void mostrarNotificacionProcesada(String mensaje) {
        notificacionesArea.append(mensaje + "\n");
    }
}
