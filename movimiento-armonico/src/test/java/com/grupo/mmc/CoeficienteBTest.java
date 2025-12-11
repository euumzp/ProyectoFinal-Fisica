package com.grupo.mmc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CoeficienteBTest {

    @Test
    public void testTabla1() {
        CoeficienteB coef = new CoeficienteB();

        double[] x2 = {
            0.0,
            0.009604,
            0.038416,
            0.086436,
            0.153664,
            0.240100
        };

        double[] y2 = {
            0.851929,
            0.654481,
            0.345744,
            0.095481,
            0.0,
            0.095481
        };

        double resultado = coef.calcular(x2, y2);

        assertEquals(-2.9482, resultado, 0.001);

    }
}

