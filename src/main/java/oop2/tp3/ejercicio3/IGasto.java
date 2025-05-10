package oop2.tp3.ejercicio3;

public interface IGasto {
    TipoDeGasto getTipoGasto();

    int getMonto();

    String getNombre();

    String marcarExceso();

    void imprimirDetalle();
}
