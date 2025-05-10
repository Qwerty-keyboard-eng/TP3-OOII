package oop2.tp3.ejercicio3;

public class GastoAlquilerAuto extends Gastos {

    public GastoAlquilerAuto(int monto) {
        this.tipoGasto = TipoDeGasto.ALQUILER_AUTO;
        this.monto = monto;
    }

    @Override
    public String getNombre() {
        return "Alquiler de Autos";
    }

    @Override
    public String marcarExceso() {
        return " ";
    }
}
