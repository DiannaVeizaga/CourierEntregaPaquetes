package main;

import java.util.HashMap;

public class GrafoRutas {
    private HashMap<String, HashMap<String, Integer>> rutas;

    public GrafoRutas() {
        rutas = new HashMap<>();
    }

    public void agregarRuta(String origen, String destino, int tiempoEstimado) {
        rutas.computeIfAbsent(origen, k -> new HashMap<>()).put(destino, tiempoEstimado);
    }

    public Integer obtenerTiempoRuta(String origen, String destino) {
        if (rutas.containsKey(origen) && rutas.get(origen).containsKey(destino)) {
            return rutas.get(origen).get(destino);
        }
        return null;  // Si no existe la ruta
    }

    public HashMap<String, HashMap<String, Integer>> getRutas() {
        return rutas;
    }
}
