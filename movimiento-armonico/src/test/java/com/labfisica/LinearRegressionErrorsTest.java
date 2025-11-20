package com.labfisica;

import com.labfisica.regression.LinearRegressionErrors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinearRegressionErrorsTest {
    
    @Test
    public void testPerfectLinearRegression() {
        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] y = {3.0, 5.0, 7.0, 9.0, 11.0};
        
        LinearRegressionErrors.RegressionResult result = 
            LinearRegressionErrors.linearRegressionWithErrors(x, y);
        
        assertEquals(1.0, result.A, 1e-10);
        assertEquals(2.0, result.B, 1e-10);
        assertEquals(1.0, result.rSquared, 1e-10);
        assertTrue(result.sigmaA < 0.001);
        assertTrue(result.sigmaB < 0.001);
    }
    
    @Test
    public void testRSquaredRange() {
        double[] x = {1.0, 2.0, 3.0, 4.0};
        double[] y = {2.0, 3.0, 4.0, 5.0};
        
        LinearRegressionErrors.RegressionResult result = 
            LinearRegressionErrors.linearRegressionWithErrors(x, y);
        
        assertTrue(result.rSquared >= 0 && result.rSquared <= 1);
    }
    
    @Test
    public void testNoisyData() {
        // Datos REALMENTE con ruido alrededor de y = 1 + 1x
        double[] x = {0.0, 1.0, 2.0, 3.0, 4.0};
        double[] y = {1.1, 1.9, 3.2, 3.8, 5.1};  // ? 1 + 1x con ruido
        
        LinearRegressionErrors.RegressionResult result = 
            LinearRegressionErrors.linearRegressionWithErrors(x, y);
        
        // Verificar que los coeficientes son aproximadamente correctos
        assertEquals(1.0, result.A, 0.2);
        assertEquals(1.0, result.B, 0.2);  // Cambiado de 2.0 a 1.0
        
        // Verificar que R? es alto pero no perfecto
        assertTrue(result.rSquared > 0.95);
        
        // Verificar que los errores son razonables
        assertTrue(result.sigmaA > 0);
        assertTrue(result.sigmaB > 0);
    }
    
    @Test
    public void testInvalidInput() {
        double[] x = {1.0};
        double[] y = {2.0};
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LinearRegressionErrors.linearRegressionWithErrors(x, y);
        });
        
        assertTrue(exception.getMessage().contains("at least 2 points"));
    }
}
