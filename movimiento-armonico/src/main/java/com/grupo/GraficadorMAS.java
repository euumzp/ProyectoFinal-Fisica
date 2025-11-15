package com.grupo;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GraficadorMAS {

    private static double[][] leerCSV(String ruta) throws IOException {
        List<Double> tList = new ArrayList<>();
        List<Double> xList = new ArrayList<>();
        List<Double> vList = new ArrayList<>();

        try (Reader in = new InputStreamReader(new FileInputStream(ruta), StandardCharsets.UTF_8)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord r : records) {
                tList.add(Double.parseDouble(r.get("tiempo")));
                xList.add(Double.parseDouble(r.get("posicion")));
                vList.add(Double.parseDouble(r.get("velocidad")));
            }
        }

        int n = tList.size();
        double[] t = new double[n], x = new double[n], v = new double[n];
        for (int i = 0; i < n; i++) {
            t[i] = tList.get(i);
            x[i] = xList.get(i);
            v[i] = vList.get(i);
        }
        return new double[][]{t, x, v};
    }

    private static void generarGrafico(double[] t, double[] x, double[] v, String titulo, String archivoSalida) throws IOException {
        XYSeries sX = new XYSeries("Posición x(t)");
        XYSeries sV = new XYSeries("Velocidad v(t)");

        for (int i = 0; i < t.length; i++) {
            sX.add(t[i], x[i]);
            sV.add(t[i], v[i]);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(sX);
        dataset.addSeries(sV);

        JFreeChart chart = ChartFactory.createXYLineChart(
                titulo,
                "Tiempo [s]",
                "Magnitud",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        // crea la carpeta graficos si no existe
        File dir = new File("graficos");
        if (!dir.exists()) dir.mkdirs();

        ChartUtils.saveChartAsPNG(new File(dir, archivoSalida), chart, 900, 600);
    }

    public static void main(String[] args) {
        String[] csvs = {
                "Tabla1.csv",
                "Tabla2.csv",
                "Tabla3.csv",
                "Tabla4.csv",
                "Tabla5.csv",
                "Tabla6.csv"
        };

        String[] titulos = {
                "Tabla 1 - MAS",
                "Tabla 2 - MAS",
                "Tabla 3 - MAS",
                "Tabla 4 - MAS",
                "Tabla 5 - MAS",
                "Tabla 6 - MAS"
        };

        for (int i = 0; i < csvs.length; i++) {
            try {
                double[][] datos = leerCSV(csvs[i]);
                String salida = "grafico_tabla" + (i+1) + ".png";
                generarGrafico(datos[0], datos[1], datos[2], titulos[i], salida);
                System.out.println("Generado: " + salida);
            } catch (IOException e) {
                System.err.println("Error con " + csvs[i] + ": " + e.getMessage());
            }
        }
    }
}
