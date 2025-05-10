package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {
    private static final int PERMALINK_COLUMN = 0;
    private static final int COMPANY_NAME_COLUMN = 1;
    private static final int NUMBER_EMPLOYEES_COLUMN = 2;
    private static final int CATEGORY_COLUMN = 3;
    private static final int CITY_COLUMN = 4;
    private static final int STATE_COLUMN = 5;
    private static final int FUNDED_DATE_COLUMN = 6;
    private static final int RAISED_AMOUNT_COLUMN = 7;
    private static final int RAISED_CURRENCY_COLUMN = 8;
    private static final int ROUND_COLUMN = 9;

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<String[]> csvData = leerCSV();

        if (options.containsKey("company_name")) {
            csvData = filtrarPorColumna(csvData, COMPANY_NAME_COLUMN, options.get("company_name"));
        }
        if (options.containsKey("city")) {
            csvData = filtrarPorColumna(csvData, CITY_COLUMN, options.get("city"));
        }
        if (options.containsKey("state")) {
            csvData = filtrarPorColumna(csvData, STATE_COLUMN, options.get("state"));
        }
        if (options.containsKey("round")) {
            csvData = filtrarPorColumna(csvData, ROUND_COLUMN, options.get("round"));
        }

        return pasarASalida(csvData);
    }

    private static List<String[]> leerCSV() throws IOException {
        List<String[]> csvData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/data.csv"))) {
            String[] row;
            while ((row = reader.readNext()) != null) {
                csvData.add(row);
            }
        }
        if (!csvData.isEmpty()) {
            csvData.remove(0); // Remover la fila de encabezados
        }
        return csvData;
    }

    private static List<String[]> filtrarPorColumna(List<String[]> data, int columnIndex, String filtro) {
        List<String[]> results = new ArrayList<>();
        for (String[] row : data) {
            if (row[columnIndex].equals(filtro)) {
                results.add(row);
            }
        }
        return results;
    }

    private static List<Map<String, String>> pasarASalida(List<String[]> data) {
        List<Map<String, String>> output = new ArrayList<>();
        for (String[] row : data) {
            Map<String, String> mapped = new HashMap<>();
            mapped.put("permalink", row[PERMALINK_COLUMN]);
            mapped.put("company_name", row[COMPANY_NAME_COLUMN]);
            mapped.put("number_employees", row[NUMBER_EMPLOYEES_COLUMN]);
            mapped.put("category", row[CATEGORY_COLUMN]);
            mapped.put("city", row[CITY_COLUMN]);
            mapped.put("state", row[STATE_COLUMN]);
            mapped.put("funded_date", row[FUNDED_DATE_COLUMN]);
            mapped.put("raised_amount", row[RAISED_AMOUNT_COLUMN]);
            mapped.put("raised_currency", row[RAISED_CURRENCY_COLUMN]);
            mapped.put("round", row[ROUND_COLUMN]);
            output.add(mapped);
        }
        return output;
    }
}