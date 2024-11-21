package main;

public class Notificacion implements Comparable<Notificacion> {
    private String mensaje;
    private int prioridad; // 1 = Alta, 2 = Media, 3 = Baja

    public Notificacion(String mensaje, int prioridad) {
        this.mensaje = mensaje;
        this.prioridad = prioridad;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Notificacion otra) {
        // Ordenar por prioridad (prioridad más baja = mayor importancia)
        return Integer.compare(this.prioridad, otra.prioridad);
    }
}
