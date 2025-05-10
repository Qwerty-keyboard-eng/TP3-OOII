package oop2.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final List<Alquiler> alquileres = new ArrayList<Alquiler>();
    private final String name;

    public Cliente(String nombre) {
        this.name = nombre;
    }

    public Object[] calcularDeudaYPuntosObtenidos() {
        Object[] resultado = new Object[2];
        double total = 0;
        int puntosAlquilerFrecuente = 0;
        
        for (Alquiler alquiler : alquileres) {
            double monto = alquiler.calcularDeuda();
            total += monto;
            int puntos = alquiler.calcularPuntosObtenidos();
            puntosAlquilerFrecuente += puntos;
        }

        resultado[0] = total;
        resultado[1] = puntosAlquilerFrecuente;
        return resultado;
    }

    public void alquilar(Alquiler rental) {
        alquileres.add(rental);
    }
}