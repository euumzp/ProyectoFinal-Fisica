package com.labfisica.plots;

import com.labfisica.xydata.XYData;
import com.labfisica.io.CsvXYReader;
import com.labfisica.regression.LinearRegressionErrors;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;
import org.knowm.xchart.SwingWrapper;

import java.nio.file.Path;
import java.util.Arrays;

public class AnalizadorCompleto {
    
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java AnalizadorCompleto <archivo.csv> [masa]");
            System.out.println("Ejemplo: java AnalizadorCompleto Tabla1.csv 4m");
            return;
        }
        
        String archivo = args[0];
        String masa = (args.length >= 2) ? args[1] : "desconocida";
        
        System.out.println("=== AN?LISIS COMPLETO MAS - PERSONA 3 ===");
        System.out.println("Archivo: " + archivo);
        System.out.println("Masa: " + masa);
        System.out.println();
        
        try {
            // Leer datos
            XYData data = CsvXYReader.read(Path.of(archivo));
            
            // 1. C?LCULOS MAS (de tus compa?eros)
            System.out.println("--- C?LCULOS MAS ---");
            double amplitud = Arrays.stream(data.y)
                    .map(Math::abs)
                    .max()
                    .orElse(0);
            System.out.printf("Amplitud (A): %.3f m\n", amplitud);
            
            double periodo = estimarPeriodo(data.x, data.y);
            System.out.printf("Periodo estimado (T): %.3f s\n", periodo);
            
            double omega = 2 * Math.PI / periodo;
            System.out.printf("Frecuencia angular (?): %.3f rad/s\n", omega);
            
            if (masa.endsWith("m")) {
                double valorMasa = extraerValorMasa(masa);
                double k = valorMasa * omega * omega;
                System.out.printf("Constante el?stica (k): %.3f N/m\n", k);
            }
            
            System.out.println();
            
            // 2. REGRESI?N LINEAL CON ERRORES (TU TRABAJO - Persona 3)
            System.out.println("--- REGRESI?N LINEAL CON ERRORES ---");
            LinearRegressionErrors.RegressionResult result = 
                LinearRegressionErrors.linearRegressionWithErrors(data.x, data.y);
            
            System.out.printf("Coeficiente A: %.6f ? %.6f\n", result.A, result.sigmaA);
            System.out.printf("Coeficiente B: %.6f ? %.6f\n", result.B, result.sigmaB);
            System.out.printf("Error relativo A: %.2f%%\n", (result.sigmaA / Math.abs(result.A)) * 100);
            System.out.printf("Error relativo B: %.2f%%\n", (result.sigmaB / Math.abs(result.B)) * 100);
            System.out.printf("Coeficiente R?: %.6f\n", result.rSquared);
            
            // 3. GR?FICA CON REGRESI?N (TU TRABAJO - Persona 3)
            System.out.println();
            System.out.println("--- GENERANDO GR?FICA ---");
            
            XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("An?lisis Completo - " + archivo.replace(".csv", "") + " (Masa: " + masa + ")")
                .xAxisTitle("Tiempo (s)")
                .yAxisTitle("Posici?n (m)")
                .build();
            
            // Datos experimentales
            XYSeries dataSeries = chart.addSeries("Datos Experimentales", data.x, data.y);
            dataSeries.setMarker(SeriesMarkers.CIRCLE);
            dataSeries.setLineWidth(0);
            
            // L?nea de regresi?n
            double xMin = Arrays.stream(data.x).min().orElse(0);
            double xMax = Arrays.stream(data.x).max().orElse(1);
            double[] regressionX = {xMin, xMax};
            double[] regressionY = {
                result.A + result.B * xMin,
                result.A + result.B * xMax
            };
            
            String equation = String.format("y = %.4f + %.4fx (R?=%.4f)", result.A, result.B, result.rSquared);
            XYSeries regressionSeries = chart.addSeries(equation, regressionX, regressionY);
            regressionSeries.setLineWidth(3);
            regressionSeries.setMarker(SeriesMarkers.NONE);
            
            new SwingWrapper<>(chart).displayChart();
            
            System.out.println("? Gr?fica abierta: " + equation);
            
        } catch (Exception e) {
            System.out.println("? Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static double estimarPeriodo(double[] tiempo, double[] posicion) {
        // M?todo simple para estimar periodo
        int cruces = 0;
        double primerCruce = 0;
        double ultimoCruce = 0;
        
        for (int i = 1; i < posicion.length; i++) {
            if (posicion[i-1] * posicion[i] <= 0) {
                cruces++;
                if (cruces == 1) primerCruce = tiempo[i];
                ultimoCruce = tiempo[i];
            }
        }
        
        if (cruces < 2) return 2.0;
        return (ultimoCruce - primerCruce) / ((cruces - 1) / 2.0);
    }
    
    private static double extraerValorMasa(String masa) {
        try {
            return Double.parseDouble(masa.replace("m", ""));
        } catch (NumberFormatException e) {
            return 1.0;
        }
    }
}
