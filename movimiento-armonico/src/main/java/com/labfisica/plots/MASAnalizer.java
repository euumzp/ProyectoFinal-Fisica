package com.labfisica.plots;

import com.labfisica.xydata.XYData;
import com.labfisica.io.CsvXYReader;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.nio.file.Path;
import java.util.Arrays;

public class MASAnalizer {

    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Uso: java MASAnalizer <archivo.csv> [masa]");
                System.out.println("Ejemplo: java MASAnalizer Tabla1.csv 4m");
                return;
            }
            
            String archivo = args[0];
            String masa = (args.length >= 2) ? args[1] : "desconocida";
            
            System.out.println("=== ANÁLISIS MOVIMIENTO ARMÓNICO SIMPLE ===");
            System.out.println("Archivo: " + archivo);
            System.out.println("Masa: " + masa);
            
            // Leer datos del CSV
            XYData data = CsvXYReader.read(Path.of(archivo));
            
            // 1. Gráfica Posición vs Tiempo
            plotPosicionTiempo(data, masa);
            
            // 2. Gráfica Velocidad vs Tiempo (si existe la columna)
            if (tieneVelocidad(data)) {
                plotVelocidadTiempo(data, masa);
            }
            
            // 3. Cálculos de parámetros MAS
            calcularParametrosMAS(data, masa);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void plotPosicionTiempo(XYData data, String masa) {
        XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("MAS - Posición vs Tiempo (Masa: " + masa + ")")
                .xAxisTitle("Tiempo (s)")
                .yAxisTitle("Posición (m)")
                .build();
        
        XYSeries series = chart.addSeries("Posición experimental", data.x, data.y);
        series.setXYSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        series.setMarker(SeriesMarkers.CIRCLE);
        
        new SwingWrapper<>(chart).displayChart();
    }
    
    public static void plotVelocidadTiempo(XYData data, String masa) {
        // Para velocidad necesitaríamos modificar CsvXYReader para leer 3 columnas
        System.out.println("Datos de velocidad disponibles para masa: " + masa);
        // Aquí iría el código para graficar velocidad
    }
    
    public static void calcularParametrosMAS(XYData data, String masa) {
        System.out.println("\n--- CÁLCULOS PARA MASA " + masa + " ---");
        
        // Calcular amplitud (máximo valor absoluto de posición)
        double amplitud = Arrays.stream(data.y)
                .map(Math::abs)
                .max()
                .orElse(0);
        System.out.printf("Amplitud (A): %.3f m\n", amplitud);
        
        // Estimación del periodo (tiempo entre dos máximos consecutivos)
        double periodo = estimarPeriodo(data.x, data.y);
        System.out.printf("Periodo estimado (T): %.3f s\n", periodo);
        
        // Frecuencia angular
        double omega = 2 * Math.PI / periodo;
        System.out.printf("Frecuencia angular (ω): %.3f rad/s\n", omega);
        
        // Calcular constante k si conocemos la masa
        if (masa.endsWith("m")) {
            double valorMasa = extraerValorMasa(masa);
            double k = valorMasa * omega * omega;
            System.out.printf("Constante elástica (k): %.3f N/m\n", k);
        }
    }
    
    private static double estimarPeriodo(double[] tiempo, double[] posicion) {
        // Método simple: tiempo entre primer y último cruce por cero
        int cruces = 0;
        double primerCruce = 0;
        double ultimoCruce = 0;
        
        for (int i = 1; i < posicion.length; i++) {
            if (posicion[i-1] * posicion[i] <= 0) { // Cambio de signo
                cruces++;
                if (cruces == 1) primerCruce = tiempo[i];
                ultimoCruce = tiempo[i];
            }
        }
        
        if (cruces < 2) return 2.0; // Valor por defecto
        
        return (ultimoCruce - primerCruce) / ((cruces - 1) / 2.0);
    }
    
    private static double extraerValorMasa(String masa) {
        // Convertir "4m", "3m", etc. a valores numéricos
        try {
            return Double.parseDouble(masa.replace("m", ""));
        } catch (NumberFormatException e) {
            return 1.0; // Valor por defecto
        }
    }
    
    private static boolean tieneVelocidad(XYData data) {
        return data.yName.toLowerCase().contains("velocidad");
    }
}