package oop2.tp3.ejercicio1;

public class LibroNuevo_Lanzamiento extends Libro {

    public LibroNuevo_Lanzamiento(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularPrecio(int diasAlquilados) {
        return diasAlquilados * 3;
    }

    @Override
    public int calcularPuntosAlquilerFrecuente(int diasAlquilados) {
        return diasAlquilados;
    }
}
