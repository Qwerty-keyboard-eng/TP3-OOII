package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {
    public void imprimir(List<? extends IGasto> gastos) {
        int total = 0;
        int gastosDeComida = 0;

        System.out.println("Expenses " + LocalDate.now());

        for (IGasto gasto : gastos) {
            if (gasto.getTipoGasto() == TipoDeGasto.CENA || gasto.getTipoGasto() == TipoDeGasto.DESAYUNO) {
                gastosDeComida += gasto.getMonto();
            }

            gasto.imprimirDetalle();
            total += gasto.getMonto();
        }

        System.out.println("Gastos de comida: " + gastosDeComida);
        System.out.println("Total de gastos: " + total);
    }
}