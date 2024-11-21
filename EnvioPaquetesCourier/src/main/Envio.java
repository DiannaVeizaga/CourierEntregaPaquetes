package main;

public class Envio {
    private String numeroSeguimiento;
    private String origen;
    private double peso;
    private String destino;
    private Paquete paquete;
    private String estadoEnvio;

    // Constructor
    public Envio(String numeroSeguimiento, String origen, double peso, String destino, Paquete paquete) {
        this.numeroSeguimiento = numeroSeguimiento;
        this.origen = origen;
        this.peso = peso;
        this.destino = destino;
        this.paquete = paquete;
        this.estadoEnvio = "En tránsito";
    }

    // Getters y Setters
    public String getNumeroSeguimiento() {
        return numeroSeguimiento;
    }

    public String getOrigen() {
        return origen;
    }

    public double getPeso() {
        return peso;
    }

    public String getDestino() {
        return destino;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }
}
