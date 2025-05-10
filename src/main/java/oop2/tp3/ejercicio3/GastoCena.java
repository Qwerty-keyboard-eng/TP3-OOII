package oop2.tp3.ejercicio3;

public class GastoCena extends Gastos {

    public GastoCena(int monto) {
        this.tipoGasto = TipoDeGasto.CENA;
        this.monto = monto;
    }

    @Override
    public String getNombre() {
        return "Cena";
    }

    @Override
    public String marcarExceso() {
        return monto > 5000 ? "X" : " ";
    }
}
