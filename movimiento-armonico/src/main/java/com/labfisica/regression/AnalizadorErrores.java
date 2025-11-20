package com.labfisica.regression;

import com.labfisica.xydata.XYData;
import com.labfisica.io.CsvXYReader;
import java.nio.file.Path;

public class AnalizadorErrores {
    
    public static void main(String[] args) {
        System.out.println("=== ANALIZADOR DE ERRORES - PERSONA 3 ===");
        System.out.println("ESTE ES EL CODIGO NUEVO - DEBERIA FUNCIONAR!");
        
        String[] tablas = {"Tabla1.csv", "Tabla2.csv", "Tabla3.csv"};
        
        for (String tabla : tablas) {
            System.out.println("\n>>> ANALIZANDO: " + tabla);
            System.out.println("========================================");
            
            try {
                // 1. Leer datos
                XYData data = CsvXYReader.read(Path.of(tabla));
                System.out.println("Datos leidos: " + data.x.length + " puntos");
                
                // 2. Calcular regresion
                LinearRegressionErrors.RegressionResult result = 
                    LinearRegressionErrors.linearRegressionWithErrors(data.x, data.y);
                
                // 3. Mostrar resultados
                System.out.println("A = " + result.A + " +- " + result.sigmaA);
                System.out.println("B = " + result.B + " +- " + result.sigmaB);
                System.out.println("R? = " + result.rSquared);
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        System.out.println("\n>>> FIN DEL ANALISIS - PERSONA 3");
    }
}
