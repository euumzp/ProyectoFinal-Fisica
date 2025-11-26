package com.persona3.unique;

import com.labfisica.xydata.XYData;
import com.labfisica.io.CsvXYReader;
import com.labfisica.regression.LinearRegressionErrors;
import java.nio.file.Path;

public class Xyz123UniqueMainTest {
    public static void main(String[] args) {
        System.out.println("=== PERSONA 3: ERRORES DE COEFICIENTES PARA TODAS LAS TABLAS ===");
        System.out.println();
        
        String[] tablas = {"Tabla1.csv", "Tabla2.csv", "Tabla3.csv", "Tabla4.csv", "Tabla5.csv", "Tabla6.csv"};
        String[] masas = {"4m", "3m", "2m", "1m", "1m", "1m"};
        
        for (int i = 0; i < tablas.length; i++) {
            System.out.println(">>> ANALIZANDO: " + tablas[i] + " (Masa: " + masas[i] + ")");
            System.out.println("==================================================");
            
            try {
                XYData data = CsvXYReader.read(Path.of(tablas[i]));
                System.out.println("Puntos leidos: " + data.x.length);
                
                LinearRegressionErrors.RegressionResult result = 
                    LinearRegressionErrors.linearRegressionWithErrors(data.x, data.y);
                
                System.out.println("Coeficiente A: " + String.format("%.6f", result.A) + " ? " + String.format("%.6f", result.sigmaA));
                System.out.println("Coeficiente B: " + String.format("%.6f", result.B) + " ? " + String.format("%.6f", result.sigmaB));
                System.out.println("Error relativo A: " + String.format("%.2f", (result.sigmaA/Math.abs(result.A)*100)) + "%");
                System.out.println("Error relativo B: " + String.format("%.2f", (result.sigmaB/Math.abs(result.B)*100)) + "%");
                System.out.println("Coeficiente R?: " + String.format("%.6f", result.rSquared));
                
                // Evaluaci?n de calidad
                if (result.rSquared > 0.95) {
                    System.out.println("Calidad: EXCELENTE");
                } else if (result.rSquared > 0.85) {
                    System.out.println("Calidad: BUENA");
                } else {
                    System.out.println("Calidad: REGULAR");
                }
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
        
        System.out.println("=== AN?LISIS COMPLETADO - PERSONA 3 ===");
    }
}
