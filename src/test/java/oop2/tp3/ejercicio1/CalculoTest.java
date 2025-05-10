package oop2.tp3.ejercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoTest {
    @Test
    public void test01() {
        Libro elTunel = new LibroRegular("El Túnel");
        Libro antesDelFin = new LibroRegular("Antes del Fin");
        Libro cienDias = new LibroInfantil("100 Dias");
        Libro viajeAlCentroDeLaTierra = new LibroNuevo_Lanzamiento("Viaje al Centro De la Tierra");
        CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
        CopiaLibro cienDiasCopia = new CopiaLibro(cienDias);
        CopiaLibro viajeAlCentroDeLaTierraCopia = new CopiaLibro(viajeAlCentroDeLaTierra);
        CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);
        Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
        Alquiler alquilerCienDias = new Alquiler(cienDiasCopia, 2);
        Alquiler alquilerViajeAlCentroDeLaTierra = new Alquiler(viajeAlCentroDeLaTierraCopia, 3);
        Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);
        Cliente yo = new Cliente("Javier");
        yo.alquilar(alquilerElTunel);
        yo.alquilar(alquilerAntesDelFin);
        yo.alquilar(alquilerViajeAlCentroDeLaTierra);
        yo.alquilar(alquilerCienDias);
        Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
        assertEquals(20.5, resultado[0]);
        assertEquals(6, resultado[1]);
        assertEquals("El Túnel", elTunel.nombre());
    }
}
