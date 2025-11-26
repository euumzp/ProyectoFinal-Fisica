package com.labfisica.movimientoarmonico.ajuste;
public class CoeficienteB {
    public static double calcularB(double m, double k) {
        return -Math.sqrt(k / m);
    }
}
