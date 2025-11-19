package com.grupo.mmc;

import java.util.List;

public class MMCCalculator {
    
    public static double calculateA(List<Double> X, List<Double> Y) {
        if (X.size() != Y.size()) {
            throw new IllegalArgumentException("Las listas X e Y deben tener la misma longitud.");
        }
        
        int N = X.size();
        double sumX = 0.0, sumY = 0.0, sumXY = 0.0, sumX2 = 0.0;
        
        for (int i = 0; i < N; i++) {
            double x = X.get(i);
            double y = Y.get(i);
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
        }
        
        double denominator = N * sumX2 - sumX * sumX;
        if (denominator == 0) {
            throw new ArithmeticException("El denominador es cero, no se puede calcular el coeficiente.");
        }
        
        double B = (N * sumXY - sumX * sumY) / denominator;
        double A = (sumY - B * sumX) / N;
        
        return A;
    }
}