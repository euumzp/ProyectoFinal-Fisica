package com.labfisica.regression;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class LinearRegressionErrors {
    
    public static class RegressionResult {
        public final double A, B, sigmaA, sigmaB, rSquared;
        
        public RegressionResult(double A, double B, double sigmaA, double sigmaB, double rSquared) {
            this.A = A;
            this.B = B;
            this.sigmaA = sigmaA;
            this.sigmaB = sigmaB;
            this.rSquared = rSquared;
        }
        
        @Override
        public String toString() {
            return String.format("A = %.6f ± %.6f, B = %.6f ± %.6f, R² = %.6f", 
                               A, sigmaA, B, sigmaB, rSquared);
        }
    }
    
    public static RegressionResult linearRegressionWithErrors(double[] x, double[] y) {
        if (x.length != y.length || x.length < 2) {
            throw new IllegalArgumentException("Arrays must have same length and at least 2 points");
        }
        
        // Convertir a List para facilitar cálculos
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            xList.add(x[i]);
            yList.add(y[i]);
        }
        
        return linearRegressionWithErrors(xList, yList);
    }
    
    public static RegressionResult linearRegressionWithErrors(List<Double> x, List<Double> y) {
        if (x.size() != y.size() || x.size() < 2) {
            throw new IllegalArgumentException("Lists must have same size and at least 2 points");
        }
        
        int n = x.size();
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;
        
        for (int i = 0; i < n; i++) {
            double xi = x.get(i);
            double yi = y.get(i);
            sumX += xi;
            sumY += yi;
            sumXY += xi * yi;
            sumX2 += xi * xi;
            sumY2 += yi * yi;
        }
        
        double B = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double A = (sumY - B * sumX) / n;
        
        double chi2 = 0;
        for (int i = 0; i < n; i++) {
            double residual = y.get(i) - (A + B * x.get(i));
            chi2 += residual * residual;
        }
        
        double variance = chi2 / (n - 2);
        double sigmaB = Math.sqrt(n * variance / (n * sumX2 - sumX * sumX));
        double sigmaA = Math.sqrt(sumX2 * variance / (n * sumX2 - sumX * sumX));
        double rSquared = 1 - (chi2 / (sumY2 - sumY * sumY / n));
        
        return new RegressionResult(A, B, sigmaA, sigmaB, rSquared);
    }
}