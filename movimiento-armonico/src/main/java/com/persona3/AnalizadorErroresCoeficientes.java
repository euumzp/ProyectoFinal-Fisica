package com.persona3;

import com.labfisica.xydata.XYData;
import com.labfisica.io.CsvXYReader;
import com.labfisica.regression.LinearRegressionErrors;
import java.nio.file.Path;

public class AnalizadorErroresCoeficientes {
    public static void main(String[] args) {
        System.out.println("=== ANALIZADOR DE ERRORES - PERSONA 3 ===");
        System.out.println("ESTE CODIGO DEBERIA FUNCIONAR!");
        System.out.println();
        
        String[] tablas = {"Tabla1.csv", "Tabla2.csv", "Tabla3.csv"};
        
        for (String tabla : tablas) {
            System.out.println(">>> PROCESANDO: " + tabla);
            System.out.println("========================================");
            
            try {
                // 1. Leer datos
                XYData data = CsvXYReader.read(Path.of(tabla));
                System.out.println("Puntos leidos: " + data.x.length);
                
                // 2. Calcular regresion con errores
                LinearRegressionErrors.RegressionResult result = 
                    LinearRegressionErrors.linearRegressionWithErrors(data.x, data.y);
                
                // 3. Mostrar resultados
                System.out.println("Coeficiente A: " + result.A + " +- " + result.sigmaA);
                System.out.println("Coeficiente B: " + result.B + " +- " + result.sigmaB);
                System.out.println("Error relativo A: " + (result.sigmaA/Math.abs(result.A)*100) + "%");
                System.out.println("Error relativo B: " + (result.sigmaB/Math.abs(result.B)*100) + "%");
                System.out.println("R?: " + result.rSquared);
                System.out.println();
                
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println();
            }
        }
        
        System.out.println(">>> ANALISIS COMPLETADO - PERSONA 3");
    }
}
