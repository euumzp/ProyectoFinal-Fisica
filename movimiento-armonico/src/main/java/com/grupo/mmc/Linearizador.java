package com.grupo.mmc;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Linearizador {
    
    public static double[] linearizarX(double[] x) {
        double[] X = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            X[i] = x[i] * x[i];  // X = x²
        }
        return X;
    }
    
    public static double[] linearizarY(double[] v) {
        double[] Y = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            Y[i] = v[i] * v[i];  // Y = v²
        }
        return Y;
    }
    
    public static void main(String[] args) {
        System.out.println("=== LINEARIZACIÓN PARA MMC ===");
        
        // Datos de la Tabla 1 (partícula con masa 4m)
        double[] x = {1.000, 0.951, 0.809, 0.588, 0.309, 0.000};
        double[] v = {0.000, -0.485, -0.923, -1.271, -1.494, -1.571};
        
        double[] X = linearizarX(x);
        double[] Y = linearizarY(v);
        
        System.out.println("Datos originales - Tabla 1:");
        System.out.println("x: " + Arrays.toString(x));
        System.out.println("v: " + Arrays.toString(v));
        System.out.println("\nDatos linearizados:");
        System.out.println("X = x²: " + Arrays.toString(X));
        System.out.println("Y = v²: " + Arrays.toString(Y));
        
        // Convertir a List para MMCCalculator
        List<Double> XList = new ArrayList<>();
        List<Double> YList = new ArrayList<>();
        for (int i = 0; i < X.length; i++) {
            XList.add(X[i]);
            YList.add(Y[i]);
        }
        
        double coeficienteA = MMCCalculator.calculateA(XList, YList);
        System.out.println("\nResultado MMC:");
        System.out.println("Coeficiente A calculado: " + coeficienteA);
    }
}