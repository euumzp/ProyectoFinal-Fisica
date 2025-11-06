package com.labfisica.plots;

import com.labfisica.xydata.XYData;
import com.labfisica.io.CsvXYReader;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.nio.file.Path;

public class MASDataPlotter {

    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Uso: java MASDataPlotter <archivo.csv>");
                System.out.println("Ejemplo: java MASDataPlotter datos_mas.csv");
                return;
            }
            
            String archivo = args[0];
            System.out.println("Leyendo datos desde: " + archivo);
            
            // Leer datos del CSV
            XYData data = CsvXYReader.read(Path.of(archivo));
            
            // Crear gráfica de posición vs tiempo
            XYChart chart = new XYChartBuilder()
                    .width(800)
                    .height(600)
                    .title("Movimiento Armónico Simple - Posición vs Tiempo")
                    .xAxisTitle(data.xName)
                    .yAxisTitle(data.yName)
                    .build();
            
            // Agregar serie de datos
            XYSeries series = chart.addSeries("Datos experimentales", data.x, data.y);
            series.setXYSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
            series.setMarker(SeriesMarkers.CIRCLE);
            
            // Mostrar gráfica
            System.out.println("Mostrando gráfica...");
            new SwingWrapper<>(chart).displayChart();
            
            System.out.println("Gráfica mostrada exitosamente!");
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}