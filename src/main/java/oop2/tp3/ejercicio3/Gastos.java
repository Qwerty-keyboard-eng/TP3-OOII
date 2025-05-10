package oop2.tp3.ejercicio3;

abstract class Gastos implements IGasto {

    TipoDeGasto tipoGasto;
    int monto;

    @Override
    public TipoDeGasto getTipoGasto() {
        return tipoGasto;
    }

    @Override
    public int getMonto() {
        return monto;
    }

    @Override
    public abstract String getNombre();

    @Override
    public abstract String marcarExceso();

    @Override
    public void imprimirDetalle() {
        System.out.println(getNombre() + "\t" + getMonto() + "\t" + marcarExceso());
    }
}
