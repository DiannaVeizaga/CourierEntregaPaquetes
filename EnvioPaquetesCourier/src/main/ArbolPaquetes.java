package main;

public class ArbolPaquetes {
    private NodoPaquete raiz;

    public ArbolPaquetes() {
        this.raiz = null;
    }

    public void agregarPaquete(Paquete paquete) {
        raiz = agregarPaqueteRecursivo(raiz, paquete);
    }

    private NodoPaquete agregarPaqueteRecursivo(NodoPaquete nodo, Paquete paquete) {
        if (nodo == null) {
            return new NodoPaquete(paquete);
        }

        if (paquete.getPeso() < nodo.paquete.getPeso()) {
            nodo.izquierdo = agregarPaqueteRecursivo(nodo.izquierdo, paquete);
        } else if (paquete.getPeso() > nodo.paquete.getPeso()) {
            nodo.derecho = agregarPaqueteRecursivo(nodo.derecho, paquete);
        }
        return nodo;
    }

    public Paquete buscarPaquete(String destino) {
        return buscarPaqueteRecursivo(raiz, destino);
    }

    private Paquete buscarPaqueteRecursivo(NodoPaquete nodo, String destino) {
        if (nodo == null) {
            return null;
        }

        if (nodo.paquete.getDestino().equals(destino)) {
            return nodo.paquete;
        }

        Paquete paqueteIzquierda = buscarPaqueteRecursivo(nodo.izquierdo, destino);
        if (paqueteIzquierda != null) {
            return paqueteIzquierda;
        }
        return buscarPaqueteRecursivo(nodo.derecho, destino);
    }
}
