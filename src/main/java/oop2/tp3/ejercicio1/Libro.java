package oop2.tp3.ejercicio1;

public abstract class Libro {
    private final String nombre;

    public Libro(String nombre) {
        this.nombre = nombre;
    }

    public int calcularPuntosAlquilerFrecuente(int diasAlquilados) {
        return 1;
    }

    public abstract double calcularPrecio(int diasAlquilados);

    public String nombre() {
        return nombre;
    }
}