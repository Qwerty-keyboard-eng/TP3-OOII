package oop2.tp3.ejercicio1;

public class CopiaLibro {
    private final Libro libro;

    public CopiaLibro(Libro libro) {
        this.libro = libro;
    }

    public double calcularPrecio(int diasAlquilados) {
        double precio = libro.calcularPrecio(diasAlquilados);
        return precio;
    }


    public Libro libro() {
        return libro;
    }
}