package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteGastosTest {

    private String normalizeLineSeparators(String text) {
        Pattern pattern = Pattern.compile("\\r\\n|\\r|\\n");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(System.lineSeparator());
    }

    @Test
    void imprimir_sinGastos() {
        ReporteDeGastos reporte = new ReporteDeGastos();
        TestOutputCapturer capturer = new TestOutputCapturer();
        reporte.imprimir(List.of());
        capturer.stop();
        String salidaEsperada = "Expenses " + LocalDate.now() + "\n" +
                "Gastos de comida: 0\n" +
                "Total de gastos: 0\n";
        assertEquals(normalizeLineSeparators(salidaEsperada), normalizeLineSeparators(capturer.getOutput()));
    }

    @Test
    void imprimir_gastosVariosSinExceso() {
        ReporteDeGastos reporte = new ReporteDeGastos();
        List<IGasto> gastos = Arrays.asList(
                new GastoDesayuno(800),
                new GastoCena(4500),
                new GastoAlquilerAuto(10000)
        );
        TestOutputCapturer captura = new TestOutputCapturer();
        reporte.imprimir(gastos);
        captura.stop();
        String expectedOutput = "Expenses " + LocalDate.now() + "\n" +
                "Desayuno\t800\t \n" +
                "Cena\t4500\t \n" +
                "Alquiler de Autos\t10000\t \n" +
                "Gastos de comida: 5300\n" +
                "Total de gastos: 15300\n";
        assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(captura.getOutput()));
    }

    @Test
    void imprimir_gastosConExcesoComida() {
        ReporteDeGastos reporte = new ReporteDeGastos();
        List<IGasto> gastos = Arrays.asList(
                new GastoDesayuno(1200),
                new GastoCena(6000)
        );
        TestOutputCapturer captura = new TestOutputCapturer();
        reporte.imprimir(gastos);
        captura.stop();
        String salidaEsperada = "Expenses " + LocalDate.now() + "\n" +
                "Desayuno\t1200\tX\n" +
                "Cena\t6000\tX\n" +
                "Gastos de comida: 7200\n" +
                "Total de gastos: 7200\n";
        assertEquals(normalizeLineSeparators(salidaEsperada), normalizeLineSeparators(captura.getOutput()));
    }

    @Test
    void imprimir_alquilerAuto() {
        ReporteDeGastos reporte = new ReporteDeGastos();
        List<IGasto> gastos = List.of(
                new GastoAlquilerAuto(7500)
        );
        TestOutputCapturer captura = new TestOutputCapturer();
        reporte.imprimir(gastos);
        captura.stop();
        String salidaEsperada = "Expenses " + LocalDate.now() + "\n" +
                "Alquiler de Autos\t7500\t \n" +
                "Gastos de comida: 0\n" +
                "Total de gastos: 7500\n";
        assertEquals(normalizeLineSeparators(salidaEsperada), normalizeLineSeparators(captura.getOutput()));
    }

    @Test
    void imprimir_multiplesGastosConExceso() {
        ReporteDeGastos reporte = new ReporteDeGastos();
        List<IGasto> gastos = Arrays.asList(
                new GastoDesayuno(900),
                new GastoCena(5500),
                new GastoAlquilerAuto(12000),
                new GastoDesayuno(500)
        );
        TestOutputCapturer captura = new TestOutputCapturer();
        reporte.imprimir(gastos);
        captura.stop();
        String salidaEsperada = "Expenses " + LocalDate.now() + "\n" +
                "Desayuno\t900\t \n" +
                "Cena\t5500\tX\n" +
                "Alquiler de Autos\t12000\t \n" +
                "Desayuno\t500\t \n" +
                "Gastos de comida: 6900\n" +
                "Total de gastos: 18900\n";
        assertEquals(normalizeLineSeparators(salidaEsperada), normalizeLineSeparators(captura.getOutput()));
    }
}

class TestOutputCapturer {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public TestOutputCapturer() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    public String getOutput() {
        return outputStreamCaptor.toString();
    }

    public void stop() {
        System.setOut(standardOut);
    }
}