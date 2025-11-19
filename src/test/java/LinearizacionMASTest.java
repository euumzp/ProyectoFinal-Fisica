import org.junit.Test;
import static org.junit.Assert.*;

public class LinearizacionMASTest {

    @Test
    public void testMinimosCuadrados_PendientePositiva() {
        // Datos de prueba: y = 2x + 1
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {3, 5, 7, 9, 11}; // y = 2x + 1

        double[] resultado = LinearizacionMAS.minimosCuadrados(x, y);

        // Pendiente esperada ≈ 2.0
        assertEquals(2.0, resultado[0], 0.001);
        // Intercepto esperado ≈ 1.0
        assertEquals(1.0, resultado[1], 0.001);
    }

    @Test
    public void testMinimosCuadrados_PendienteCero() {
        // Datos de prueba: y = 3 (pendiente 0)
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {3, 3, 3, 3, 3};

        double[] resultado = LinearizacionMAS.minimosCuadrados(x, y);

        // Pendiente esperada ≈ 0.0
        assertEquals(0.0, resultado[0], 0.001);
        // Intercepto esperado ≈ 3.0
        assertEquals(3.0, resultado[1], 0.001);
    }

    @Test
    public void testLinearizarYMCA_DatosMAS() {
        // Datos de MAS conocidos: A=1, ω=2
        // x = cos(2t), v = -2 sin(2t)
        double[] xData = {1.0, 0.6967, 0.3090, -0.3090, -0.6967, -1.0};
        double[] vData = {0.0, -1.878, -3.249, -3.249, -1.878, 0.0};

        double[] resultados = LinearizacionMAS.linearizarYMCA(xData, vData);

        // Verificar que tenemos 4 resultados
        assertNotNull(resultados);
        assertEquals(4, resultados.length);

        // Omega debería ser cercano a 2.0
        assertEquals(2.0, resultados[2], 0.1);
        // Amplitud debería ser cercana a 1.0
        assertEquals(1.0, resultados[3], 0.1);
    }

    @Test
    public void testLinearizarYMCA_DatosConsistentes() {
        // Datos de ejemplo de la tabla (primer conjunto)
        double[] xData = {1.000, 0.951, 0.809, 0.588, 0.309, 0.000};
        double[] vData = {0.000, -0.485, -0.923, -1.271, -1.494, -1.571};

        double[] resultados = LinearizacionMAS.linearizarYMCA(xData, vData);

        // Verificar que los resultados son numéricamente válidos
        assertTrue("La pendiente debe ser negativa", resultados[0] < 0);
        assertTrue("El intercepto debe ser positivo", resultados[1] > 0);
        assertTrue("Omega debe ser positivo", resultados[2] > 0);
        assertTrue("Amplitud debe ser positiva", resultados[3] > 0);
    }
}
