package oop2.tp3.ejercicio1;

public class LibroRegular extends Libro {
    public LibroRegular(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularPrecio(int diasAlquilados) {
        double precio = 2;
        if (diasAlquilados > 2) {
            precio += (diasAlquilados - 2) * 1.5;
        }
        return precio;
    }

}
