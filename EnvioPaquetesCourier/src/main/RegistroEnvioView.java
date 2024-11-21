package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroEnvioView extends JFrame {
    private JTextField origenField, destinoField, pesoField, contenidoField;
    private JTextField largoField, anchoField, altoField;
    private JButton registrarButton;
    private RegistroEnvioController controller;

    public RegistroEnvioView(RegistroEnvioController controller) {
        this.controller = controller;

        setTitle("Registro de Envío");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Crear los campos de entrada para la información del paquete
        panel.add(new JLabel("Origen:"));
        origenField = new JTextField();
        panel.add(origenField);

        panel.add(new JLabel("Destino:"));
        destinoField = new JTextField();
        panel.add(destinoField);

        panel.add(new JLabel("Peso:"));
        pesoField = new JTextField();
        panel.add(pesoField);

        panel.add(new JLabel("Contenido:"));
        contenidoField = new JTextField();
        panel.add(contenidoField);

        panel.add(new JLabel("Largo:"));
        largoField = new JTextField();
        panel.add(largoField);

        panel.add(new JLabel("Ancho:"));
        anchoField = new JTextField();
        panel.add(anchoField);

        panel.add(new JLabel("Alto:"));
        altoField = new JTextField();
        panel.add(altoField);

        registrarButton = new JButton("Registrar Envío");
        panel.add(registrarButton);

        // Acción de registrar el paquete
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String origen = origenField.getText();
                String destino = destinoField.getText();
                double peso = Double.parseDouble(pesoField.getText());
                String contenido = contenidoField.getText();
                double largo = Double.parseDouble(largoField.getText());
                double ancho = Double.parseDouble(anchoField.getText());
                double alto = Double.parseDouble(altoField.getText());

                // Llamamos al controlador para registrar el envío
                String numeroSeguimiento = Long.toString(System.currentTimeMillis());
                controller.registrarEnvio(numeroSeguimiento, origen, peso, destino);

                JOptionPane.showMessageDialog(null, "Envío registrado con éxito. Número de seguimiento: " + numeroSeguimiento);
            }
        });

        add(panel);
    }
}
