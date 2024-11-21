package main;

public class EstadoEnvio {

    public static final String EN_TRANSITO = "En tránsito";
    public static final String ENTREGADO = "Entregado";
    public static final String RETRASADO = "Retrasado";
    public static final String CANCELADO = "Cancelado";

    public EstadoEnvio() {
    }

    public String estadoPorDefecto() {
        return EN_TRANSITO;
    }
}
