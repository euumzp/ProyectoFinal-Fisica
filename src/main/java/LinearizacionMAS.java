public class LinearizacionMAS {
    
    /**
     * Lineariza datos de MAS para aplicar Mínimos Cuadrados
     */
    public static double[] linearizarYMCA(double[] xData, double[] vData) {
        // Preparar datos para linearización: X = x², Y = v²
        double[] xCuad = new double[xData.length];
        double[] vCuad = new double[vData.length];
        
        for (int i = 0; i < xData.length; i++) {
            xCuad[i] = xData[i] * xData[i];
            vCuad[i] = vData[i] * vData[i];
        }
        
        // Aplicar Mínimos Cuadrados
        double[] coeficientes = minimosCuadrados(xCuad, vCuad);
        double pendiente = coeficientes[0];
        double intercepto = coeficientes[1];
        
        // Calcular parámetros físicos
        double omega = Math.sqrt(-pendiente);
        double amplitud = Math.sqrt(-intercepto / pendiente);
        
        return new double[]{pendiente, intercepto, omega, amplitud};
    }
    
    public static double[] minimosCuadrados(double[] x, double[] y) {
        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        
        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }
        
        double pendiente = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercepto = (sumY - pendiente * sumX) / n;
        
        return new double[]{pendiente, intercepto};
    }
    
    public static void main(String[] args) {
        // Datos de ejemplo
        double[] xData = {1.000, 0.951, 0.809, 0.588, 0.309, 0.000};
        double[] vData = {0.000, -0.485, -0.923, -1.271, -1.494, -1.571};
        
        double[] resultados = linearizarYMCA(xData, vData);
        
        System.out.println("=== RESULTADOS LINEARIZACIÓN ===");
        System.out.println("Pendiente (m): " + resultados[0]);
        System.out.println("Intercepto (b): " + resultados[1]);
        System.out.println("Omega (ω): " + resultados[2]);
        System.out.println("Amplitud (A): " + resultados[3]);
    }
}
