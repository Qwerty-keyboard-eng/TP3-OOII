package oop2.tp3.ejercicio1;

public class Alquiler {
    private final CopiaLibro copia;
    private final int diasAlquilados;

    public Alquiler(CopiaLibro copia, int diasAlquilados) {
        this.copia = copia;
        this.diasAlquilados = diasAlquilados;
    }

    public double calcularDeuda() {
        double monto = copia().libro().calcularPrecio(diasAlquilados);
        return monto;
    }

    public int calcularPuntosObtenidos() {
        int puntos = copia().libro().calcularPuntosAlquilerFrecuente(diasAlquilados);
        return puntos;
    }

    public CopiaLibro copia() {
        return this.copia;
    }
}
