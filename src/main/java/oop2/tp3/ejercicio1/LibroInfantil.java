package oop2.tp3.ejercicio1;

public class LibroInfantil extends Libro {

    public LibroInfantil(String nombre) {
        super(nombre);
    }

    @Override
    public double calcularPrecio(int diasAlquilados) {
        double precio = 1.5;
        if (diasAlquilados > 3) {
            precio += (diasAlquilados - 3) * 1.5;
        }
        return precio;
    }
}
