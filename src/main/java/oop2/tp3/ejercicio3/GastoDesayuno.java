package oop2.tp3.ejercicio3;

public class GastoDesayuno extends Gastos {

    public GastoDesayuno(int monto) {
        this.tipoGasto = TipoDeGasto.DESAYUNO;
        this.monto = monto;
    }

    @Override
    public String getNombre() {
        return "Desayuno";
    }

    @Override
    public String marcarExceso() {
        return monto > 1000 ? "X" : " ";
    }
}
