package com.labfisica.regression;

import com.labfisica.xydata.XYData;
import com.labfisica.io.CsvXYReader;
import java.nio.file.Path;

public class Persona3Main {
    public static void main(String[] args) {
        System.out.println("=== PERSONA 3: ERRORES DE COEFICIENTES ===");
        
        String[] tablas = {"Tabla1.csv", "Tabla2.csv", "Tabla3.csv"};
        
        for (String tabla : tablas) {
            System.out.println("Procesando: " + tabla);
            try {
                XYData data = CsvXYReader.read(Path.of(tabla));
                System.out.println("Puntos: " + data.x.length);
                
                LinearRegressionErrors.RegressionResult result = 
                    LinearRegressionErrors.linearRegressionWithErrors(data.x, data.y);
                
                System.out.println("A: " + result.A + " ? " + result.sigmaA);
                System.out.println("B: " + result.B + " ? " + result.sigmaB);
                System.out.println("R?: " + result.rSquared);
                System.out.println("---");
                
            } catch (Exception e) {
                System.out.println("Error con " + tabla + ": " + e.getMessage());
            }
        }
        System.out.println("FIN - PERSONA 3");
    }
}
