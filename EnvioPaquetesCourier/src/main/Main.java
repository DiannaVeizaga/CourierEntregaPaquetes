package main;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() {
        setTitle("Menú Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Botones del menú principal
        JButton registrarEnvioButton = new JButton("Registrar Envío");
        JButton rastrearEnvioButton = new JButton("Rastrear Envío");
        JButton alertasNotificacionesButton = new JButton("Alertas y Notificaciones");
        JButton salirButton = new JButton("Salir");

        // Agregar botones al JFrame
        add(registrarEnvioButton);
        add(rastrearEnvioButton);
        add(alertasNotificacionesButton);
        add(salirButton);

        // Inicializar componentes de Registro de Envíos
        RegistroEnvios registroEnvios = new RegistroEnvios();
        RegistroEnvioController registroController = new RegistroEnvioController();
        RegistroEnvioView registroView = new RegistroEnvioView(registroController);

        // Inicializar componentes de Rastreo de Envíos
        RastreoEnvioController rastreoController = new RastreoEnvioController();
        RastreoEnvioView rastreoView = new RastreoEnvioView(rastreoController);
        rastreoController.setView(rastreoView);

        // Inicializar componentes de Alertas y Notificaciones
        AlertasNotificaciones alertasModel = new AlertasNotificaciones();
        AlertasNotificacionesView alertasView = new AlertasNotificacionesView();
        AlertasNotificacionesController alertasController = new AlertasNotificacionesController(alertasView);
        alertasView.setController(alertasController);

        // Asociar acciones a los botones del menú
        registrarEnvioButton.addActionListener(e -> registroView.setVisible(true));
        rastrearEnvioButton.addActionListener(e -> rastreoView.setVisible(true));
        alertasNotificacionesButton.addActionListener(e -> alertasView.setVisible(true));
        salirButton.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        Main menu = new Main();
        menu.setVisible(true);
    }
}
