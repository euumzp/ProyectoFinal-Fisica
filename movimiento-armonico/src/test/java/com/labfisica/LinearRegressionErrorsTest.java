package com.labfisica;

import com.labfisica.regression.LinearRegressionErrors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinearRegressionErrorsTest {
    
    @Test
    public void testPerfectLinearRegression() {
        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};
        double[] y = {3.0, 5.0, 7.0, 9.0, 11.0}; // y = 2x + 1
        
        LinearRegressionErrors.RegressionResult result = 
            LinearRegressionErrors.linearRegressionWithErrors(x, y);
        
        // EN TU CÓDIGO: A = intercepto, B = pendiente
        assertEquals(1.0, result.A, 1e-10);  // Intercepto = 1
        assertEquals(2.0, result.B, 1e-10);  // Pendiente = 2
        assertEquals(1.0, result.rSquared, 1e-10);
        assertTrue(result.sigmaA < 0.001);
        assertTrue(result.sigmaB < 0.001);
    }
    
    @Test
    public void testRSquaredRange() {
        double[] x = {1.0, 2.0, 3.0, 4.0};
        double[] y = {2.0, 3.0, 4.0, 5.0}; // y = x + 1
        
        LinearRegressionErrors.RegressionResult result = 
            LinearRegressionErrors.linearRegressionWithErrors(x, y);
        
        // EN TU CÓDIGO: A = intercepto, B = pendiente
        assertEquals(1.0, result.A, 1e-10);  // Intercepto = 1
        assertEquals(1.0, result.B, 1e-10);  // Pendiente = 1
        assertTrue(result.rSquared >= 0 && result.rSquared <= 1);
    }
    
    @Test
    public void testNoisyData() {
        double[] x = {0.0, 1.0, 2.0, 3.0, 4.0};
        double[] y = {1.1, 1.9, 3.2, 3.8, 5.1}; // ≈ y = x + 1 con ruido
        
        LinearRegressionErrors.RegressionResult result = 
            LinearRegressionErrors.linearRegressionWithErrors(x, y);
        
        // EN TU CÓDIGO: A = intercepto, B = pendiente
        assertEquals(1.0, result.A, 0.2);  // Intercepto ≈ 1
        assertEquals(1.0, result.B, 0.2);  // Pendiente ≈ 1
        assertTrue(result.rSquared > 0.95);
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
        
        assertTrue(exception.getMessage().contains("Arrays must have same length and at least 2 points"));
    }
    
    @Test
    public void testDifferentLengthArrays() {
        double[] x = {1.0, 2.0};
        double[] y = {1.0};
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LinearRegressionErrors.linearRegressionWithErrors(x, y);
        });
        
        assertTrue(exception.getMessage().contains("Arrays must have same length and at least 2 points"));
    }
    
    // Test adicional para verificar la convención
    @Test
    public void testConvention() {
        double[] x = {0.0, 1.0, 2.0};
        double[] y = {5.0, 5.0, 5.0}; // y = 5 (línea horizontal)
        
        LinearRegressionErrors.RegressionResult result = 
            LinearRegressionErrors.linearRegressionWithErrors(x, y);
        
        // Pendiente debería ser 0, intercepto debería ser 5
        assertEquals(5.0, result.A, 1e-10);  // Intercepto = 5
        assertEquals(0.0, result.B, 1e-10);  // Pendiente = 0
    }
    @Test
    public void testErrorCalculation() {
        // Datos con ruido significativo
        double[] x = {1.0, 2.0, 3.0, 4.0};
        double[] y = {1.5, 1.8, 3.5, 3.9}; // Datos dispersos
    
        LinearRegressionErrors.RegressionResult result = 
            LinearRegressionErrors.linearRegressionWithErrors(x, y);
    
        // Verificar que se calculan errores razonables
        assertTrue(result.sigmaA > 0.01, "Error del intercepto debe ser significativo");
        assertTrue(result.sigmaB > 0.01, "Error de la pendiente debe ser significativo");
    
        // Verificar que R² no es perfecto
        assertTrue(result.rSquared < 0.99, "R² debe ser menor que 1 para datos ruidosos");
}
}