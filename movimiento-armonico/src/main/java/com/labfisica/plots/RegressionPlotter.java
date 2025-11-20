package com.labfisica.plots;

import com.labfisica.xydata.XYData;
import com.labfisica.regression.LinearRegressionErrors;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.util.Arrays;

public class RegressionPlotter {

    public static void plotWithRegression(XYData data, String title, 
                                        LinearRegressionErrors.RegressionResult result) {
        
        // Crear gráfica
        XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title(title + " - Regresión Lineal")
                .xAxisTitle(data.xName)
                .yAxisTitle(data.yName)
                .build();
        
        // Agregar datos experimentales
        XYSeries dataSeries = chart.addSeries("Datos experimentales", data.x, data.y);
        dataSeries.setMarker(SeriesMarkers.CIRCLE);
        dataSeries.setLineWidth(0); // Solo puntos
        
        // Calcular puntos para la línea de regresión
        double xMin = Arrays.stream(data.x).min().orElse(0);
        double xMax = Arrays.stream(data.x).max().orElse(1);
        double[] regressionX = {xMin, xMax};
        double[] regressionY = {
            result.A + result.B * xMin,
            result.A + result.B * xMax
        };
        
        // Agregar línea de regresión
        String regressionLabel = String.format("Regresión: y = %.4f + %.4fx (R²=%.4f)", 
                                             result.A, result.B, result.rSquared);
        XYSeries regressionSeries = chart.addSeries(regressionLabel, regressionX, regressionY);
        regressionSeries.setLineWidth(2);
        regressionSeries.setMarker(SeriesMarkers.NONE);
        
        // Mostrar gráfica
        new SwingWrapper<>(chart).displayChart();
        
        System.out.println("Gráfica con regresión generada: " + title);
    }
}